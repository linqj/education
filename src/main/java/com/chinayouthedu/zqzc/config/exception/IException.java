package com.chinayouthedu.zqzc.config.exception;

/**
 * 异常
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2017年12月25日 下午12:56:57
 * @version 1.0
 */
public interface IException {
	
	/** 日志异常编号 */
	Integer getCode();

	/** 日志异常内容 */
	String getMsg();
	
}
