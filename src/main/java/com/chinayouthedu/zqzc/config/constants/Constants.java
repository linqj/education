package com.chinayouthedu.zqzc.config.constants;
/**
 * 常量配置,不可实例化
 * @author 张超群
 * @time   2017年11月30日下午5:33:10
 */
public interface Constants {
	
	//时效
	public static final Integer EXPIRE_IN_100M = 60*100;             //过期时间100分钟 (60*100 秒)
    public static final Integer EXPIRE_IN_20H = 60*60*20;            //过期时间20小时 (60*60*20秒)
    public static final Integer EXPIRE_IN_10H = 60*60*20;            //过期时间10小时 (60*60*10秒)
    public static final Integer EXPIRE_IN_30M = 60*30;               //过期时间30分钟 (60*30 秒)
    public static final Integer EXPIRE_IN_20M = 60*20;               //过期时间20分钟 (60*20 秒)
    public static final Integer EXPIRE_IN_10M = 60*10;               //过期时间10分钟 (60*10 秒)
    public static final Integer EXPIRE_IN_7D = 60*60*24*7;           //过期时间7天 (60*60*24*7 秒)
    
    
    //Session
    public static final String SESSION_USERID = "userid";//Session中获取用户id的key
    public static final String SESSION_LOGINID = "login_id";//Session中获取登录id的key
    
    //验证码
    public static final String VALIDATE_CODE = "validateCode";
    
    
    //缓存前缀
    public static final String Project = "SheDuLe";//Cookice标志
    public static final String DICT = "dict";//字典key
  	public static final String LOGIN_CACHE_PREFIX = "login_cache_prefix";//登录用户缓存前缀
  	public static final String USER_INFO_CACHE_PREFIX = "user_info_cache_prefix";//用户信息缓存前缀
  	public static final String USER_MENU_CACHE_PREFIX = "user_menu_cache_prefix";//用户菜单缓存前缀
  	public static final String USER_PERMISSION_INFO_PREFIX = "user_permission_info_prefix";//用户功能权限缓存前缀
  	public static final String USER_PERMISSION_URL_PREFIX = "user_permission_url_prefix";//用户所有功能url权限缓存前缀
  	public static final String USER_MENU_ALL_PREFIX = "user_menu_all_prefix";//用户所有菜单集合
  	public static final String CURRENT_PAGE_BUTTON_CODE = "current_page_button_code";//当前访问页面按钮权限验证编码
  	public static final String Role_PREFIX = "role_prefix";//用户所有菜单集合
  	
    
}
 	 	