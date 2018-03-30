package com.chinayouthedu.zqzc.config.enums;

public enum ResultCode {
	
	Result_SUCCESS(200,"请求成功!"),
	Result_NO_SESSION(201,"会话超时,请重新登录!"),
	Result_NO_AUTH(202,"您无权限执行该操作!"),
	Result_REDIRECT(302,"该请求已失效!"),
	Result_WARN(400,"服务出错!"),
	Result_NOT_FOUND(404,"找不到方法!"),	
	Result_ERROR(500,"系统后台异常,请联系客服!"),	
	Result_501(501,"参数不能为空!"),
	Result_SQL(1000,"SQL异常！"),
	MethodNotSupportedException(1001,"该方法无效！"),
	Result_IO(1002,"数据流出错了！");
	
	private Integer code;
	private String msg;
	
	
	ResultCode(Integer code,String msg) {
		this.code=code;
		this.msg=msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
