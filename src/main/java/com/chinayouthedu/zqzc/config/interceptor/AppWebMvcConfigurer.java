//package com.chinayouthedu.zqzc.config.interceptor;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
///**
// * 配置拦截器
// * @author 张超群
// * @time   2018年3月13日上午10:36:41
// */
//@Configuration
//public class AppWebMvcConfigurer extends WebMvcConfigurerAdapter {
//
//    public void addInterceptors(InterceptorRegistry registry) {
//        // addPathPatterns 添加拦截规则
//        // excludePathPatterns 排除拦截规则
//        registry.addInterceptor(new LoginInterceptor())
//                .excludePathPatterns("/*/**")
//                .addPathPatterns("/*/**");
//        registry.addInterceptor(new PermissionInterceptor())
//                .excludePathPatterns("/*/**")
//                .addPathPatterns("/*/**");
//        super.addInterceptors(registry);
//    }
//
//}
