package com.chinayouthedu.zqzc.config.interceptor;

import com.chinayouthedu.zqzc.common.core.UserLoginUtils;
import com.chinayouthedu.zqzc.config.cache.EHCacheManager;
import com.chinayouthedu.zqzc.config.constants.Constants;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.config.core.SessionVo;
import com.chinayouthedu.zqzc.config.enums.ResultCode;
import com.chinayouthedu.zqzc.config.session.SessionUtil;
import com.chinayouthedu.zqzc.entity.paike.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {

    public static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    //web全局信息，访问任何页面都会用到
    private static final String GLOBAL_INFO = "global";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
        User user = UserLoginUtils.getLoginUser(request);
        String uri = request.getRequestURI();
        logger.info("当前访问的URI={}",uri);
        if(user != null){
            SessionVo vo = (SessionVo) EHCacheManager.get(Constants.USER_INFO_CACHE_PREFIX + user.getId());
            if(handler instanceof HandlerMethod) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                RestController restController = handlerMethod.getClass().getAnnotation(RestController.class);
                ResponseBody hasResponseBody = handlerMethod.getMethodAnnotation(ResponseBody.class);//post
                if(vo == null) {//未登录
                    BaseResponse<String> baseResp = new BaseResponse<String>(ResultCode.Result_NO_SESSION);
                    logger.info("\n用户访问url={} 因未登陆或session过期, 返回超时错误信息:{}", uri, baseResp);
                    response.setCharacterEncoding("UTF-8");
                    response.setHeader("Content-type","text/html;charset=UTF-8");
                    PrintWriter writer = response.getWriter();
                    writer.write(baseResp.toString());
                    return false;
                }else {//登录
                    //权限校验
                    if(hasResponseBody != null || restController != null) {//返回的是json
                        if(!SessionUtil.checkUrlAuth(uri)){
                            logger.info("\n用户访问url={}  该用户UserName={} 无权限，返回提示信息！", uri, vo.getUserName());
                            BaseResponse<String> baseResp = new BaseResponse<String>(ResultCode.Result_NO_AUTH);
                            response.setCharacterEncoding("UTF-8");
                            response.setHeader("Content-type","text/html;charset=UTF-8");
                            PrintWriter writer = response.getWriter();
                            writer.write(baseResp.toString());
                            return false;
                        }
                    }
                }
            }else{
                BaseResponse<String> baseResp = new BaseResponse<String>(ResultCode.Result_REDIRECT);
                response.setCharacterEncoding("UTF-8");
                response.setHeader("Content-type","text/html;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                writer.write(baseResp.toString());
                return false;
            }
        }else{
            BaseResponse<String> baseResp = new BaseResponse<String>(ResultCode.Result_NO_SESSION);
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-type","text/html;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(baseResp.toString());
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
