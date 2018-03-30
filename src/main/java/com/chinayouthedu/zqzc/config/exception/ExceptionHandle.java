package com.chinayouthedu.zqzc.config.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.config.enums.ResultCode;

/**
 * 统一异常处理
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2018年3月6日 下午4:03:59
 * @version 1.0
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandle {

	@ExceptionHandler(IOException.class)
	public BaseResponse<?> handleIOException(HttpServletRequest request, Exception ex) {
		return new BaseResponse<>(ResultCode.Result_IO);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public BaseResponse<?> HttpRequestMethodNotSupportedException(HttpServletRequest request, Exception ex) {
		return new BaseResponse<>(ResultCode.MethodNotSupportedException);
	}
	
	@ExceptionHandler(SQLException.class)
	public BaseResponse<?> handleSQLException(HttpServletRequest request, Exception ex) {
		 return new BaseResponse<>(ResultCode.Result_SQL);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public BaseResponse<?> handleNotFoundException(NotFoundException ex) {
		return new BaseResponse<>(ResultCode.Result_NOT_FOUND);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(WebException.class)
	public BaseResponse<?> handleBadRequestException(WebException ex) {
		return new BaseResponse<>(ResultCode.Result_WARN);
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public BaseResponse<?> handleServerErrorException(Exception ex) {
		return new BaseResponse<>(ResultCode.Result_ERROR);
	}

}
