package com.chinayouthedu.zqzc.common.core;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import com.chinayouthedu.zqzc.common.utils.ObjectUtils;
import com.chinayouthedu.zqzc.common.utils.StringUtils;
import com.chinayouthedu.zqzc.config.cache.EHCacheManager;
import com.chinayouthedu.zqzc.config.constants.Constants;
import com.chinayouthedu.zqzc.config.session.SessionUtil;
import com.chinayouthedu.zqzc.entity.paike.User;

/**
 * 获取登录信息
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2017年12月28日 下午2:05:37
 * @version 1.0
 */
public class UserLoginUtils {
	
	/**
	 * 获取登录用户id
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:05:57
	 * @param request
	 * @return long
	 */
	public static Long getLoginUserId(HttpServletRequest request) {
		User useObject = getLoginUser(request);
		if (ObjectUtils.isNotNull(useObject)) {
			return useObject.getId();
		} else {
			return null;
		}
	}

	/**
	 * 获取登录用户对象
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:06:10
	 * @param request
	 * @return User
	 */
	public static User getLoginUser(HttpServletRequest request) {
		String userKey = WebUtils.getCookie(request, Constants.LOGIN_CACHE_PREFIX);
		if (StringUtils.isNotEmpty(userKey)) {
			User sysUser = (User) EHCacheManager.get(userKey);
			if (ObjectUtils.isNotNull(sysUser)) {
				return sysUser;
			}
		}else{
			String user_id = request.getSession().getAttribute(Constants.SESSION_USERID).toString();
			User sysUser = (User) EHCacheManager.get(Constants.LOGIN_CACHE_PREFIX+user_id);
			if (ObjectUtils.isNotNull(sysUser)) {
				return sysUser;
			}
		}
		return null;
	}
	
	
	private static void sendRedirect(String url){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpServletResponse response = ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
		try {
			response.sendRedirect(request.getContextPath() +url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 获取登录用户对象
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:06:10
	 * @param request
	 * @return User
	 */
	public static User getLoginUser() {
		HttpServletRequest request = SessionUtil.getRequest();
		String userKey = WebUtils.getCookie(request, Constants.LOGIN_CACHE_PREFIX);
		if (StringUtils.isNotEmpty(userKey)) {
			User sysUser = (User) EHCacheManager.get(userKey);
			if (ObjectUtils.isNotNull(sysUser)) {
				return sysUser;
			}
		}else{
			String user_id = request.getSession().getAttribute(Constants.SESSION_USERID).toString();
			User sysUser = (User) EHCacheManager.get(Constants.LOGIN_CACHE_PREFIX+user_id);
			if (ObjectUtils.isNotNull(sysUser)) {
				return sysUser;
			}
		}
		return null;
	}

	
	
	/**
	 * 判断是否为手机浏览器
	 * @author 张超群 
	 * @Time   2017年12月28日下午2:06:25
	 * @param request
	 * @return boolean
	 */
	public static boolean IsMoblie(HttpServletRequest request) {
		boolean isMoblie = false;
		String[] mobileAgents = { "iphone", "android","ipad", "phone", "mobile", "wap", "netfront", "java", "opera mobi",
				"opera mini", "ucweb", "windows ce", "symbian", "series", "webos", "sony", "blackberry", "dopod",
				"nokia", "samsung", "palmsource", "xda", "pieplus", "meizu", "midp", "cldc", "motorola", "foma",
				"docomo", "up.browser", "up.link", "blazer", "helio", "hosin", "huawei", "novarra", "coolpad", "webos",
				"techfaith", "palmsource", "alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips", "sagem",
				"wellcom", "bunjalloo", "maui", "smartphone", "iemobile", "spice", "bird", "zte-", "longcos",
				"pantech", "gionee", "portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct", "320x320",
				"240x320", "176x220", "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac",
				"blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs",
				"kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi",
				"mot-", "moto", "mwbp", "nec-", "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play", "port",
				"prox", "qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem",
				"smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-", "upg1", "upsi", "vk-v",
				"voda", "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-",
				"Googlebot-Mobile" };
		if (request.getHeader("User-Agent") != null) {
			String agent=request.getHeader("User-Agent");
			for (String mobileAgent : mobileAgents) {
				if (agent.toLowerCase().indexOf(mobileAgent) >= 0&&agent.toLowerCase().indexOf("windows nt")<=0 &&agent.toLowerCase().indexOf("macintosh")<=0) {
					isMoblie = true;
					break;
				}
			}
		}
		return isMoblie;
	}
}
