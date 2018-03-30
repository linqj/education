package com.chinayouthedu.zqzc.config.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * 请求跨源CORS设置,避免同源
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2018年3月7日 下午4:27:44
 * @version 1.0
 */
@Configuration
public class RequestFilter extends WebMvcConfigurerAdapter{

	/**
	 * Access-Control-Allow-Origin
	 */
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**").allowedOrigins("*")
//        .allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS")
//        .allowCredentials(false).maxAge(3600);
//		super.addCorsMappings(registry);
//	}
	
	@Override  
    public void addCorsMappings(CorsRegistry registry) {  
        registry.addMapping("/**")  
        .allowedOrigins("*")  
      .allowedMethods("PUT", "DELETE","GET","POST","PATCH")  
        .allowedHeaders("*")  
      .exposedHeaders("access-control-allow-headers",  
              "access-control-allow-methods",  
              "access-control-allow-origin",  
              "access-control-max-age",  
              "X-Frame-Options")  
      .allowCredentials(false).maxAge(3600);  
    }  
	
	
	

	
	
	
	
}
