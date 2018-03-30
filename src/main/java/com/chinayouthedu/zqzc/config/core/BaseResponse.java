package com.chinayouthedu.zqzc.config.core;

import java.io.Serializable;

import com.chinayouthedu.zqzc.config.enums.ResultCode;
import com.chinayouthedu.zqzc.config.exception.IException;

/**
 * 自定义返回对象
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2017年12月25日 下午12:49:26
 * @version 1.0
 * @param <T>
 */
public class BaseResponse<T> implements IException, Serializable{

	private static final long serialVersionUID = 1L;

	/** 日志抛出编码 */
	private Integer code;
	
	/** 日志抛出错误 */
	private String msg;
	
	/** 返回数据 */
	private T data;
	
	/**响应后浏览器重定向*/
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public BaseResponse(){
		this(ResultCode.Result_SUCCESS);
	}
	
	public BaseResponse(T date){
		this.data = date;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	public BaseResponse(Integer code,String message){
		this.code = code;
		this.msg = message;
	}
	
	public BaseResponse(ResultCode result){
		this(result.getCode(), result.getMsg());
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public Integer getCode() {
		return code;
	}

	@Override
	public String getMsg() {
		return msg;
	}
	
	/** 验证请求是否成功! */
	public boolean isSuccess(){
		return code.equals(ResultCode.Result_SUCCESS.getCode());
	}
}