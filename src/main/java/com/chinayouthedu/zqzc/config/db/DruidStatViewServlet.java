package com.chinayouthedu.zqzc.config.db;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
 
/**
 * 配置Druid的StatViewServlet
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time  2018年3月25日   下午4:42:51 
 * @version 1.0
 */
@WebServlet(urlPatterns = "/druid/*",
    initParams = {
        @WebInitParam(name = "allow", value = "127.0.0.1"),// IP白名单(没有配置或者为空，则允许所有访问)
        @WebInitParam(name = "deny", value = ""),// IP黑名单 (存在共同时，deny优先于allow)
        @WebInitParam(name = "loginUsername", value = "admin"),// 用户名
        @WebInitParam(name = "loginPassword", value = "123456"),// 密码
        @WebInitParam(name = "resetEnable", value = "false")// 禁用HTML页面上的“Reset All”功能
    })
public class DruidStatViewServlet extends StatViewServlet {
  private static final long serialVersionUID = -2688872071445249539L;
}
