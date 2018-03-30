package com.chinayouthedu.zqzc.common.utils.myexcel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Excel导出属性注解
 * @author 张超群
 * @time   2018年3月14日下午2:02:45
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( { java.lang.annotation.ElementType.FIELD })
public @interface ExportExcel {

	/**
	 * 导出到Excel中的名字.
	 */
	public abstract String name();

	/**
	 * 配置列的名称,对应A,B,C,D....
	 */
	public abstract String column();

	/**
	 * 提示信息
	 */
	public abstract String prompt() default "";

	/**
	 * 设置此处后,该列只能下拉框选择,不可以手动输入
	 */
	public abstract String[] combo() default {};

	/**
	 * 是否导出数据,应对需求:有时我们需要导出一份模板,这是标题需要但内容需要用户手工填写.
	 * true:导出表头和数据
	 * false:只导出表头
	 */
	public abstract boolean isExport() default true;
	
	/**
	 * 记录中boolean类型专用,长度必须为2,(其他类型无效)
	 * true在前,false在后
	 * 例如:true时表示男,false表示女 condition = {"男","女"}
	 */
	public abstract String[] condition() default {};
	
	/**
	 * 记录中column的列宽,默认22 
	 */
	public abstract int width() default 22;
	
	/**
	 * 记录中column的行高,默认22 
	 */
	public abstract int hight() default 20;
	
}
