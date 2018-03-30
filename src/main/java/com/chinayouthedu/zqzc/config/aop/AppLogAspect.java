package com.chinayouthedu.zqzc.config.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.chinayouthedu.zqzc.common.core.ValidationUtils;
import com.chinayouthedu.zqzc.common.utils.UploadConfig;
import com.chinayouthedu.zqzc.config.annotation.RequestVo;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.config.enums.ResultCode;
import com.chinayouthedu.zqzc.config.exception.WebException;
import com.chinayouthedu.zqzc.entity.paike.Logs;
import com.chinayouthedu.zqzc.service.LogsService;

/**
 * 系统访问日志以及参数效验
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2018年3月7日 下午12:46:30
 * @version 1.0
 */
@Component
@Aspect
//@Order(5)
public class AppLogAspect {
	
	@Autowired
	private LogsService logs;

    private static final Logger LOGGER = LoggerFactory.getLogger(AppLogAspect.class);
    // 保证每个线程都有一个单独的实例
    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    @Pointcut("execution(* com.chinayouthedu.zqzc.controller..*Controller.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
    	
    }
    
    @Around("pointcut()")
	public Object doBefore(ProceedingJoinPoint pjp) throws Throwable {
    	threadLocal.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录请求的内容
        String header = request.getHeader("User-Agent");
        LOGGER.info("用户代理(UA):\t\t{}", header);
        String addr = request.getRemoteAddr();
        LOGGER.info("访问者IP:\t\t\t{}",addr);
        String url = request.getRequestURL().toString();
        LOGGER.info("请求路径(URL):\t\t{}", url);
        String method = request.getMethod();
        LOGGER.info("请求方式(Method):\t\t{}", method);
        Object paremeters = JSON.toJSON(request.getParameterMap());
        LOGGER.info("请求参数(Paremeters):\t{}",paremeters);
        String controller = pjp.toString().replace("execution(", "").replace("", "");
        LOGGER.info("控制器及处理方法:\t\t{}", controller);
//      LOGGER.info("控制器及处理方法:\t{}", joinPoint.getSignature().getDeclaringTypeName() + "."  + joinPoint.getSignature().getName());
//      LOGGER.info("Cookies:{}", request.getCookies());
//      LOGGER.info("Params:{}", Arrays.toString(joinPoint.getArgs()));
        //持久化日志
        if(UploadConfig.getUserOperationSwitch()){
        	Logs userLog = new Logs();
        	userLog.setVisitorIp(addr);
//        	userLog.setVisitorOs();
        	userLog.setUserAgent(header);
        	userLog.setVisitUrl(url);
        	userLog.setLogInfo("请求方式:"+method+", 请求参数:"+paremeters+", 控制器及处理方法:"+controller);
        	logs.createUserLogs(userLog);
        }
        //验证参数和返回
		Object[] objs = pjp.getArgs();
		BaseResponse<?> response = new BaseResponse<>();
		for(Object arg : objs){
			if(arg != null && arg.getClass().isAnnotationPresent(RequestVo.class)){
				try{
					response = ValidationUtils.validateEntity(arg);
					if(!response.isSuccess()){
						LOGGER.info("请求参数校验:\t\t校验失败! 参数params={} \t 返回return={}",JSON.toJSON(arg),JSON.toJSON(response));
						return response;
					}else{
						LOGGER.info("请求参数验证:\t\t校验通过! 参数params={}",JSON.toJSON(arg));
					}
				}catch(Exception e) {
					LOGGER.info("请求参数验证:\t\t校验出现异常! 参数params={} 异常errorMsg={}",JSON.toJSON(arg),e.getMessage());
					throw new WebException(ResultCode.Result_501);
				}
			}
		}
		Object retObj = pjp.proceed();
		return retObj;
		
	}

    @After("pointcut()")
    public void doAfter(JoinPoint joinPoint) {
    }

    @AfterReturning(returning = "obj",pointcut = "pointcut()")//在调用上面 @Pointcut标注的方法后执行。用于获取返回值
    public void doAfterReturning(Object obj){
		LOGGER.info("请求结果:\t\t\t返回resp={}",JSON.toJSON(obj));
        LOGGER.info("执行耗时 :{}", ((System.currentTimeMillis() - threadLocal.get())) + "ms \n");
    }
}