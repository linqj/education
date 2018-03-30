package com.chinayouthedu.zqzc.config.db;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;
 
/**
 * 配置Druid的WebStatFilter
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time  2018年3月25日   下午4:42:19 
 * @version 1.0
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
    initParams = {
        @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//忽略资源
    }
)
public class DruidStatFilter extends WebStatFilter {
}
