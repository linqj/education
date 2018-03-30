package com.chinayouthedu.zqzc.common.utils;

import org.apache.commons.lang.StringUtils;

/**
 * 获取上传下载配置属性
 * @author  张超群     2017年8月19日下午3:22:31
 *
 */
public class UploadConfig {
	
	private static PropertyUtil appProps=null;//系统属性配置
	
	/**
     * 加载属性配置文件
     */
    public static final void loadConfigProp() {
		try {
			if (appProps==null) {
			    appProps = PropertyUtil.getInstance("application");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
    
    /**
	 * 获取配置属性值
	 */
    public static String getConfigProp(String propName) {
        if(appProps == null) loadConfigProp();
        String val=appProps.getProperty(propName);
        return StringUtils.isEmpty(val)?"":encode(val);
    }
    
    /**
     * 为字符串转换编码为UTF-8
     * @author  张超群	2017年8月19日下午4:00:04
     * @param str
     * @return
     */
    private static String encode(String str) {
		try{
		    return new String(str.getBytes("ISO-8859-1"),"UTF-8");
		}catch(Exception e){
			return str;
		}
	}
    
    
    /**
     * 获取应用名称
     * @author  张超群	2017年8月19日下午4:00:21
     * @return
     */
    public static String getApplicationName(){
    	return getConfigProp("server_name");
    }
    
    /**
     * 获取上传根路径
     * @author  张超群	2017年8月19日下午4:00:33
     * @return
     */
    public static String getUploadRootPath(){
    	return getConfigProp("upload_base_path");
    }
    
    /**
     * 获取模板下载根路径
     * @author 张超群 2017年9月11日下午3:57:53
     * @return
     */
    public static String getDownTemplateRootPath(){
    	return getConfigProp("download_base_path");
    }
    
    /**
     * 用户操作日志持久化开关
     * @author  张超群	2018年3月24日下午8:04:11
     * @return
     */
    public static boolean getUserOperationSwitch(){
    	boolean flag = false;
    	try {
    		flag = Boolean.parseBoolean(getConfigProp("user_logs_enable"));
		} catch (Exception e) {
		}
    	return flag;
    }
   
    /**
     * 获取注册中心授权的字典编码
     * @author  张超群	2018年3月24日 下午9:37:25
     * @return
     */
    public static String getSystemDictByZczx(){
    	return getConfigProp("zczx_dictionary_code");
    }
}
