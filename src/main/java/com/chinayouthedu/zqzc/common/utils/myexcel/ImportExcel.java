package com.chinayouthedu.zqzc.common.utils.myexcel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Excel导入时属性注解
 * @author 张超群
 * @time   2018年3月14日下午2:02:45
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( { java.lang.annotation.ElementType.FIELD })
public @interface ImportExcel {

	/**
	 * 配置列的名称,对应A,B,C,D....
	 */
	public abstract String column();

	/**
	 * 记录中boolean类型专用,长度必须为2,(其他类型无效)
	 * true在前,false在后
	 * 例如:true时表示男,false表示女 condition = {"男","女"}
	 */
	public abstract String[] condition() default {};
	
	/**
	 * 单元格验证规则(正则表达式)  eg:[\u4e00-\u9fa5]{2,6}汉字 ,\\d{4}(\\-)\\d{1,2}\\1\\d{1,2}时间格式yyyy-MM-dd
	 */
	public abstract String rule() default "";
	
	/**
	 * 单元格验证规则说明	eg:2-6个汉字
	 */
	public abstract String ruleExplain() default "";

	/**
	 * 非空验证
	 */
	public abstract boolean setNull() default false;

}
