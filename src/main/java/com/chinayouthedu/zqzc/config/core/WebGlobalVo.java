package com.chinayouthedu.zqzc.config.core;

import java.util.List;

import com.chinayouthedu.zqzc.entity.paike.Element;
import com.chinayouthedu.zqzc.entity.paike.FunctionPermission;

/**
 * 用户登录成功，进入主页返回的信息，包括菜单列表，用户权限组信息等全局信息
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2018年1月4日 下午2:17:05
 * @version 1.0
 */
public class WebGlobalVo extends BaseBean {

	private static final long serialVersionUID = 1L;
	
	private String adminName;//用户名
	
	private List<FunctionPermission> menuList;//菜单

	private List<Element> buttonList;//按钮
	
	private List<String> buttonCodeList;//按钮编码权限验证
	
	private String currentUrl;//当前功能页面url

	private String currentMenuId;//当前菜单id

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public List<FunctionPermission> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<FunctionPermission> menuList) {
		this.menuList = menuList;
	}

	public List<Element> getButtonList() {
		return buttonList;
	}

	public void setButtonList(List<Element> buttonList) {
		this.buttonList = buttonList;
	}

	public String getCurrentUrl() {
		return currentUrl;
	}

	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}

	public String getCurrentMenuId() {
		return currentMenuId;
	}

	public void setCurrentMenuId(String currentMenuId) {
		this.currentMenuId = currentMenuId;
	}

	public List<String> getButtonCodeList() {
		return buttonCodeList;
	}

	public void setButtonCodeList(List<String> buttonCodeList) {
		this.buttonCodeList = buttonCodeList;
	}
	
}
