package com.chinayouthedu.zqzc.config.exception;

import com.chinayouthedu.zqzc.config.enums.ResultCode;

/**
 * web业务异常
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2017年12月25日 下午12:55:22
 * @version 1.0
 */
public class WebException extends RuntimeException implements IException {
	private static final long serialVersionUID = 1L;

	private Integer code;
	
	private String msg;
	
	public WebException(IException bizExcep) {
		this(bizExcep.getCode(), bizExcep.getMsg());
	}
	
	public WebException(ResultCode resultCode) {
		this(resultCode.getCode(), resultCode.getMsg());
	}
	
	public WebException(Integer code, String message) {
		super(message);
		this.code = code;
		this.msg = message;
	}
	
	public static void warn(String msg) {
		throw new WebException(ResultCode.Result_WARN.getCode(), msg);
	}

	public static void warn(Integer code, String msg) {
		throw new WebException(code, msg);
	}

	@Override
	public Integer getCode() {
		return code;
	}

	@Override
	public String getMsg() {
		return msg;
	}
}
