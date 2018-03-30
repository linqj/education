package com.chinayouthedu.zqzc.config.db;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * 
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time 2018年3月25日 下午4:42:01
 * @version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "druid.config")
public class DruidConfig {

	/**	url映射	*/
	private String urlMappings;
	/**	IP白名单	*/
	private String allow;
	/**	IP黑名单	*/
	private String deny;
	/**	用户名	*/
	private String loginUsername;
	/**	 密码	*/
	private String loginPassword;
	/**	是否能够重置数据.	*/
	private String resetEnable;
	/**	添加过滤规则.	*/
	private String urlPatterns;
	/**	添加不需要忽略的格式信息.	*/
	private String exclusions;
	
	public String getUrlMappings() {
		return urlMappings;
	}

	public void setUrlMappings(String urlMappings) {
		this.urlMappings = urlMappings;
	}

	public String getAllow() {
		return allow;
	}

	public void setAllow(String allow) {
		this.allow = allow;
	}

	public String getDeny() {
		return deny;
	}

	public void setDeny(String deny) {
		this.deny = deny;
	}

	public String getLoginUsername() {
		return loginUsername;
	}

	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getResetEnable() {
		return resetEnable;
	}

	public void setResetEnable(String resetEnable) {
		this.resetEnable = resetEnable;
	}

	public String getUrlPatterns() {
		return urlPatterns;
	}

	public void setUrlPatterns(String urlPatterns) {
		this.urlPatterns = urlPatterns;
	}

	public String getExclusions() {
		return exclusions;
	}

	public void setExclusions(String exclusions) {
		this.exclusions = exclusions;
	}

	@Bean
	public ServletRegistrationBean registrationBean() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet()); // 添加初始化参数：initParams
		servletRegistrationBean.addUrlMappings(urlMappings);
		// 白名单：
		servletRegistrationBean.addInitParameter("allow", allow);
		// IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not
		// permitted to view this page.
		 servletRegistrationBean.addInitParameter("deny", deny);
		// 登录查看信息的账号密码.
		servletRegistrationBean.addInitParameter("loginUsername", loginUsername);
		servletRegistrationBean.addInitParameter("loginPassword", loginPassword);
		// 是否能够重置数据.
		servletRegistrationBean.addInitParameter("resetEnable", resetEnable);
		return servletRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
		// 添加过滤规则.
		filterRegistrationBean.addUrlPatterns(urlPatterns);
		// 添加不需要忽略的格式信息.
		filterRegistrationBean.addInitParameter("exclusions", exclusions);
		return filterRegistrationBean;
	}
}
