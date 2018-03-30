package com.chinayouthedu.zqzc.config.core;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class BaseController {
		
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	private String dateFormat = "yyyy-MM-dd";
	private String timeFormat = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 格式化日期字符串
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(this.dateFormat);
		dateFormat.setLenient(false);//设置宽松为FALSE,对日期格式进行严格检查
		binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat, true));
		SimpleDateFormat timeFormat = new SimpleDateFormat(this.timeFormat);
		timeFormat.setLenient(false);//设置宽松为FALSE,对日期格式进行严格检查
		binder.registerCustomEditor(Timestamp.class,new CustomDateEditor(timeFormat,true));
		binder.registerCustomEditor(String.class,new StringTrimmerEditor(false));
	}

}
