package com.chinayouthedu.zqzc.config.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.chinayouthedu.zqzc.config.cache.ForeverEHCacheManager;
import com.chinayouthedu.zqzc.config.constants.Constants;
import com.chinayouthedu.zqzc.entity.paike.Dictionary;
import com.chinayouthedu.zqzc.entity.paike.DictionaryExample;
import com.chinayouthedu.zqzc.service.DictionaryService;
/**
 * 系统数据初始化
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2018年1月8日 下午3:50:04
 * @version 1.0
 */
@WebListener
public class InitListener implements ServletContextListener{

	public static Logger logger = LoggerFactory.getLogger(InitListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("==========数据字典初始化...==========");  
		try {  
            ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());
            DictionaryService service = ctx.getBean(DictionaryService.class);
            List<Dictionary> list = service.selectByExample(new DictionaryExample());
            ForeverEHCacheManager.set(Constants.DICT, list);
            logger.info("==========数据字典初始化完成!==========");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		 logger.info("==========数据字典缓存清除完成!==========");  
	}

}
