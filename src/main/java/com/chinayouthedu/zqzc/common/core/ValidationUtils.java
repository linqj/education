package com.chinayouthedu.zqzc.common.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.apache.commons.collections.CollectionUtils;

import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.config.enums.ResultCode;

/**
 * 表单校验工具类
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2017年12月25日 下午12:22:07
 * @version 1.0
 */
public class ValidationUtils {

	private static Validator validator =  Validation.buildDefaultValidatorFactory().getValidator();
	
	/**
	 * 效验表单
	 * @author 张超群 
	 * @Time   2017年12月25日下午1:03:02
	 * @param obj
	 * @return
	 */
	public static <T> BaseResponse<Map<String,Object>> validateEntity(T obj){
		BaseResponse<Map<String,Object>> result = new BaseResponse<Map<String,Object>>();
		 Set<ConstraintViolation<T>> set = validator.validate(obj,Default.class);
		 if( CollectionUtils.isNotEmpty(set) ){
			 result.setCode(ResultCode.Result_501.getCode());
			 result.setMsg(ResultCode.Result_501.getMsg());
			 Map<String,Object> errorMsg = new HashMap<String,Object>();
			 for(ConstraintViolation<T> cv : set){
				 errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
			 }
			 result.setData(errorMsg);
		 }
		 return result;
	}
	
	/**
	 * 效验属性
	 * @author 张超群 
	 * @Time   2017年12月25日下午1:03:02
	 * @param obj
	 * @return
	 */
	public static <T> BaseResponse<Map<String,Object>> validateProperty(T obj,String propertyName){
		BaseResponse<Map<String,Object>> result = new BaseResponse<Map<String,Object>>();
		 Set<ConstraintViolation<T>> set = validator.validateProperty(obj,propertyName,Default.class);
		 if( CollectionUtils.isNotEmpty(set) ){
			 result.setCode(ResultCode.Result_501.getCode());
			 result.setMsg(ResultCode.Result_501.getMsg());
			 Map<String,Object> errorMsg = new HashMap<String,Object>();
			 for(ConstraintViolation<T> cv : set){
				 errorMsg.put(propertyName, cv.getMessage());
			 }
			 result.setData(errorMsg);
		 }
		 return result;
	}
}
