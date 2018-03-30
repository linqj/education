package com.chinayouthedu.zqzc.config.core;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 上传文件基础实体类，包含各实体公用属性 .
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time  2018年3月25日   下午7:09:00 
 * @version 1.0
 */
public class BaseFileEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String createTime;
	private String updateTime;
	private String updaterId;
	private String updaterName;

	public String getId() {
		return id;
	}

	public void setId(String Id) {
		this.id = Id;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdaterId() {
		return updaterId;
	}

	public void setUpdaterId(String updaterId) {
		this.updaterId = updaterId;
	}

	public String getUpdaterName() {
		return updaterName;
	}

	public void setUpdaterName(String updaterName) {
		this.updaterName = updaterName;
	}
	
	/**
	 * 分割字符串去列表
	 */
	public List<String> split2List(String str, String split) {
		if (StringUtils.isEmpty(str)) {
			return new ArrayList<String>();
		}
		String[] strs = str.split(split);
		return Arrays.asList(strs);
	}

	public List<String> split2List(String str) {
		return split2List(str, ",");
	}

	/**
	 * 格式化Double数据
	 */
	public String formatDouble(Double val, String format) {
		if (val == null) return "";
		return new DecimalFormat(format).format(val);
	}

	public String formatDouble(Double val) {
		return formatDouble(val, "0.00");
	}

}
