//package com.chinayouthedu.zqzc.config.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.context.annotation.Configuration;
///**
// * 请求跨源CORS设置,避免同源
// * @author 张超群
// * @time   2018年3月12日下午3:17:54
// */
//@Configuration
//public class CorsFilter implements Filter{
//
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		
//	}
//
//	/**
//	 * 响应配置
//	 */
//	@Override
//	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
//		HttpServletResponse response = (HttpServletResponse) servletResponse;
////		String origin = (String) servletRequest.getRemoteHost()+":"+servletRequest.getRemotePort();
//		response.setHeader("Access-Control-Allow-Origin", "*");//指定服务器端允许进行跨域资源访问的来源域。可以用通配符*表示允许任何域的JavaScript访问资源.
//		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT,HEAD");//指定服务器允许进行跨域资源访问的响应预检请求列表.
//		response.setHeader("Access-Control-Max-Age", "3600");//免预检时间
//		
//		//"Authorization,Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With"
//		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");//服务器允许进行跨域资源访问的请求头列表,预检请求
//		
//		response.setHeader("Access-Control-Allow-Credentials","true");//请求中携带了身份信息,如果此处不返回true，浏览器都会忽略此次响应。
//		chain.doFilter(servletRequest, servletResponse);
//	}
//
//	@Override
//	public void destroy() {
//		
//	}
//
//}