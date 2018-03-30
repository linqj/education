package com.chinayouthedu.zqzc.config.session;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request. RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Session工具
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2017年12月7日 下午5:18:22
 * @version 1.0
 */
public class SessionUtil {
	
	private static Logger logger = LoggerFactory.getLogger(SessionUtil.class);
	
	/**
	 * 获取Request
	 * @author 张超群 
	 * @Time   2018年1月4日下午5:37:22
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		ServletRequestAttributes sra = (ServletRequestAttributes)  RequestContextHolder.getRequestAttributes();
		return sra == null ? null : sra.getRequest();
	}
	
	public static HttpServletResponse getResponse(){
		HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
		return response == null ? null :response;
	}
	
	/**
	 * 获取当前Session
	 * @author 张超群 
	 * @Time   2018年1月4日下午5:37:15
	 * @return
	 */
	public static HttpSession getSession(){
		HttpServletRequest req = getRequest();
		return req == null ? null : req.getSession();
	}
	
	/**
	 * 获取当前URI
	 * @author 张超群 
	 * @Time   2018年1月4日下午5:37:08
	 * @return
	 */
	public static String getRequestURI() {
		HttpServletRequest req = getRequest();
		return req == null ? null : req.getRequestURI();
	}
	
	/**
	 * 获取当前URL
	 * @author 张超群 
	 * @Time   2018年1月4日下午5:37:01
	 * @return
	 */
	public static StringBuffer getRequestURL() {
		HttpServletRequest req = getRequest();
		return req == null ? null : req.getRequestURL();
	}


	/**
	 * 检查是否存在权限
	 * @param uri
	 * @return
	 */
    public static boolean checkUrlAuth(String uri) {

	return false;
    }
}
