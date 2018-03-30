package com.chinayouthedu.zqzc.common.core;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.chinayouthedu.zqzc.config.constants.Constants;
import com.chinayouthedu.zqzc.config.core.BaseResponse;

import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;
/**
 * Web工具
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2017年12月28日 下午2:08:30
 * @version 1.0
 */
public class WebUtils {
	public static String Project = Constants.Project;

	/**
	 * 设置Cookice
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:08:38
	 * @param response
	 * @param key
	 * @param value
	 * @param days
	 */
	public static void setCookie(HttpServletResponse response, String key, String value, int days) {
		setCookie(response, key, value, days, Project);
	}

	/**
	 * 设置Cookice
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:08:56
	 * @param response
	 * @param key
	 * @param value
	 * @param days
	 * @param domain
	 */
	public static void setCookie(HttpServletResponse response, String key, String value, int days, String domain) {
		if ((key != null) && (value != null)) {
			Cookie cookie = new Cookie(key, value);
			cookie.setMaxAge(days * 24 * 60 * 60);
			cookie.setPath("/");
			if (StringUtils.isNotEmpty(domain)) {
				cookie.setDomain(domain);
			}
			response.addCookie(cookie);
		}
	}

	/**
	 * 获取Cookice
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:09:00
	 * @param request
	 * @param key
	 * @return
	 */
	public static String getCookie(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();
		String resValue = "";
		if ((cookies != null) && (cookies.length > 0)) {
			for (int i = 0; i < cookies.length; i++)
				if (key.equalsIgnoreCase(cookies[i].getName())) {
					if (StringUtils.isNotEmpty(cookies[i].getValue())) {
						resValue = cookies[i].getValue();
					}
				}
		}
		return resValue;
	}

	/**
	 * 删除Cookice
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:09:09
	 * @param request
	 * @param response
	 * @param name
	 */
	public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String name) {
		deleteCookieDomain(request, response, name, Project);
	}

	/**
	 * 删除Cookice
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:09:24
	 * @param request
	 * @param response
	 * @param name
	 * @param domain
	 */
	public static void deleteCookieDomain(HttpServletRequest request, HttpServletResponse response, String name, String domain) {
		Cookie[] cookies = request.getCookies();
		if ((cookies != null) && (cookies.length > 0))
			for (int i = 0; i < cookies.length; i++)
				if (name.equalsIgnoreCase(cookies[i].getName())) {
					Cookie ck = new Cookie(cookies[i].getName(), null);
					ck.setPath("/");
					if (StringUtils.isNotEmpty(domain)) {
						ck.setDomain(domain);
					}
					ck.setMaxAge(0);
					response.addCookie(ck);
					return;
				}
	}

	/**
	 * 获取真实ip地址
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:09:59
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ipAddress = null;
		ipAddress = request.getHeader("x-forwarded-for");
		if ((ipAddress == null) || (ipAddress.length() == 0) || ("unknown".equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if ((ipAddress == null) || (ipAddress.length() == 0) || ("unknown".equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if ((ipAddress == null) || (ipAddress.length() == 0) || ("unknown".equalsIgnoreCase(ipAddress))) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1")) {
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}
		}

		if ((ipAddress != null) && (ipAddress.length() > 15) && (ipAddress.indexOf(",") > 0)) {
			ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
		}

		return ipAddress;
		
	}

	/**
	 * 获取URL参数
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:10:09
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getServletRequestUrlParms(HttpServletRequest request) {
		StringBuffer sbUrlParms = request.getRequestURL();
		sbUrlParms.append("?");

		Enumeration parNames = request.getParameterNames();
		while (parNames.hasMoreElements()) {
			String parName = ((String) parNames.nextElement()).toString();
			try {
				sbUrlParms.append(parName).append("=").append(URLEncoder.encode(request.getParameter(parName), "UTF-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				return "";
			}
		}
		return sbUrlParms.toString();
	}

	/**
	 * 获取URI参数
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:10:37
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getServletRequestUriParms(HttpServletRequest request) {
		StringBuffer sbUrlParms = new StringBuffer(request.getRequestURI());
		sbUrlParms.append("?");

		Enumeration parNames = request.getParameterNames();
		while (parNames.hasMoreElements()) {
			String parName = ((String) parNames.nextElement()).toString();
			try {
				sbUrlParms.append(parName).append("=").append(URLEncoder.encode(request.getParameter(parName), "UTF-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				return "";
			}
		}
		return sbUrlParms.toString();
	}


	/**
	 * 检测登录名
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:11:28
	 * @param value
	 * @return
	 */
	public static boolean checkLoginName(String value) {
		return value.matches(ToolregExp.loginRegex);
	}

	/**
	 * 检测手机号
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:11:45
	 * @param value
	 * @return
	 */
	public static boolean checkMobile(String value) {
		return value.matches(ToolregExp.telRegex);
	}

	/**
	 * 检测邮箱
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:11:51
	 * @param value
	 * @param length
	 * @return
	 */
	public static boolean checkEmail(String value, int length) {
		if (length == 0) {
			length = 40;
		}
		return (value.matches(ToolregExp.emailRegex)) && (value.length() <= length);
	}

	/**
	 * 检测密码
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:12:00
	 * @param password
	 * @return
	 */
	public static boolean isPasswordAvailable(String password) {
		String partten = "^[_0-9a-zA-Z]{6,}$";
		boolean flag = (password.matches(partten)) && (password.length() >= 6) && (password.length() <= 16);
		return flag;
	}

	/**
	 * 验证是否是ajax请求
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:12:22
	 * @param request
	 * @return
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		String her = request.getHeader("x-requested-with");

		return StringUtils.isNotEmpty(her);
	}


	/**
	 * 获取User-Agent
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:12:49
	 * @param request
	 * @return
	 */
	public static String getUserAgent(HttpServletRequest request) {
		String uabrow = request.getHeader("User-Agent");
		UserAgent userAgent = UserAgent.parseUserAgentString(uabrow);
		Browser browser = userAgent.getBrowser();
		OperatingSystem os = userAgent.getOperatingSystem();
		return browser.getName().toLowerCase() + ";" + os.getName().toLowerCase();
	}

	/**
	 * 替换html标签
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:13:09
	 * @param src
	 * @return
	 */
	public static String replaceTagHTML(String src) {
		String regex = "\\<(.+?)\\>";
		return StringUtils.isNotEmpty(src) ? src.replaceAll(regex, "") : "";
	}
	
	
	/**
	 * 返回成功
	 * @author 张超群 
	 * @Time   2017年12月25日下午2:18:25
	 * @param response
	 * @param SubCode
	 * @param SubMsg
	 * @param url
	 * @return
	 */
	public static void Success(BaseResponse<?> response,Integer SubCode,String SubMsg,String url){
		response.setCode(200);
		response.setMsg(SubMsg);
		response.setUrl(url);
	}
	public static void Success(BaseResponse<?> response,String SubMsg,String url){
		Success(response,200, SubMsg,url);
	}
	public static void Success(BaseResponse<?> response,String SubMsg){
		Success(response,200, SubMsg,"");
	}
	/**
	 * 返回失败!
	 * @author 张超群 
	 * @Time   2017年12月25日下午2:18:37
	 * @param response
	 * @param SubCode
	 * @param SubMsg
	 * @param url
	 * @return
	 */
	public static void Error(BaseResponse<?> response,Integer SubCode,String SubMsg,String url){
		response.setCode(404);
		response.setMsg(SubMsg);
		response.setUrl(url);
	}
	public static void Error(BaseResponse<?> response,String SubMsg,String url){
		Error(response,404, SubMsg,url);
	}
	public static void Error(BaseResponse<?> response,String SubMsg){
		Error(response,404, SubMsg,"");
	}
	
	
}