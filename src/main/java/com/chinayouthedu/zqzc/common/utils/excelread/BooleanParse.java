package com.chinayouthedu.zqzc.common.utils.excelread;

/**
 * 自定义的用于将特定字符串转成布尔型的转换器
 */
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class BooleanParse {

	private Map<String,String> bl;

	/**
	 * 创建一个布尔型的转换器
	 * @param property 需要转换的字段的name
	 * @param trueValue 当原有值=trueValue时,将该字段的属性置为true,否则为false
	 * @author wangzq
	 */
	public BooleanParse(String property,String trueValue ) {
		super();
		bl = new HashMap<String, String>();
		if(StringUtils.isNotBlank(property)&&StringUtils.isNotBlank(trueValue)){
			bl.put(property.trim(), trueValue.trim());
		}
	}
	
	/**
	 * 如果有多个字段需要做不同的String->布尔型的转换,append即可将多个规则封装于一个对象进行使用
	 * @param property property 需要转换的字段的name
	 * @param trueValue
	 * @return trueValue 当原有值=trueValue时,将该字段的属性置为true,否则为false
	 */
	public BooleanParse append(String property,String trueValue ){
		if(StringUtils.isNotBlank(property)&&StringUtils.isNotBlank(trueValue)){
			bl.put(property.trim(), trueValue.trim());
		}
		return this;
	}
	
	/**
	 * 获取String->Boolean转换值的规则,Map形式
	 * key:带转换的字段
	 * value:当该字段的值与value相等时,将其转为true,否则为false
	 * @return
	 */
	public Map<String,String> getRules(){
		 return bl;
	}
	
	
}
