package com.chinayouthedu.zqzc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 排课系统;
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time 2018年3月5日 下午5:48:47
 * @version 1.0
 */
@SpringBootApplication
@ServletComponentScan//开启Servlet扫描
@EnableTransactionManagement // 开启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
public class SheDuleApplication{
	public static void main(String[] args) {
		SpringApplication.run(SheDuleApplication.class, args);
	}
}