package com.chinayouthedu.zqzc.config.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.config.enums.ResultCode;

/**
 * 自定义异常
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2018年3月6日 下午4:04:11
 * @version 1.0
 */
public class ExceptionHelper {
	
	public static Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);
	
	public static <T> BaseResponse<T> createResponse(Throwable e){
		if (e instanceof IException) {
			IException ex = (IException) e;
			return new BaseResponse<T>(ex.getCode(), ex.getMsg());
		}else {
			logger.error("\n requestNo={} 请求系统异常!", e);
			return new BaseResponse<T>(ResultCode.Result_ERROR);
		}
	}
	
}
