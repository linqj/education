package com.chinayouthedu.zqzc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinayouthedu.zqzc.common.core.UserLoginUtils;
import com.chinayouthedu.zqzc.common.core.ValidationCode;
import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.common.utils.ToolDateTime;
import com.chinayouthedu.zqzc.config.cache.EHCacheManager;
import com.chinayouthedu.zqzc.config.constants.Constants;
import com.chinayouthedu.zqzc.config.core.BaseController;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.config.core.SessionVo;
import com.chinayouthedu.zqzc.entity.paike.Role;
import com.chinayouthedu.zqzc.entity.paike.User;
import com.chinayouthedu.zqzc.entity.vo.LoginVo;
import com.chinayouthedu.zqzc.entity.vo.RegisterVo;
import com.chinayouthedu.zqzc.service.LoginService;
import com.chinayouthedu.zqzc.service.RoleService;

/**
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2017年12月21日 上午9:33:41
 * @version 1.0
 */
@RestController
public class LoginController extends BaseController {
	
	@Autowired
	private LoginService login;
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * 登录
	 * @author  张超群	2018年3月11日下午10:03:26
	 * @param vo
	 * @param request
	 * @param res
	 * @param salt
	 * @return
	 */
	@PostMapping(value = "/login")
	@ResponseBody
	public BaseResponse<Map<String,Object>> Login(LoginVo vo, HttpServletRequest request,HttpServletResponse res){
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		// 1.校验验证码是否正确
		boolean flag = ValidationCode.validSessionCode(request.getSession(), vo.getCode());
		logger.info("校验登录验证码:"+(flag?"通过":"不通过"));
		if(!flag){
			WebUtils.Error(response, "验证码错误!");
			return response;
		}
		try{
			User user = login.validateLoginInfo(vo);
			if(user==null){
				WebUtils.Error(response, "账户或密码填写有误!");
				return response;
			}else{
				// 缓存用登录信息
				request.getSession().setAttribute(Constants.SESSION_USERID, user.getId());//用户id
				request.getSession().setAttribute(Constants.SESSION_LOGINID, vo.getLoginName());//登录名
				EHCacheManager.set(Constants.LOGIN_CACHE_PREFIX + user.getId(), user);//用户对象
				SessionVo session = new SessionVo();
				List<Role> role_list = roleService.selectRolesByUserId(user.getId());
				if(role_list != null && role_list.size() > 0){//存在角色
					List<Long> roleIds = new ArrayList<Long>();
					for (Role role : role_list) {
						roleIds.add(role.getId());
					}
					session.setUserId(user.getId());
					session.setUserName(user.getUserName());
					session.setRoles(role_list);
					session.setRoleIds(roleIds);
					EHCacheManager.set(Constants.USER_INFO_CACHE_PREFIX + user.getId(),session);//session用户信息
					WebUtils.setCookie(res, Constants.LOGIN_CACHE_PREFIX, Constants.LOGIN_CACHE_PREFIX + user.getId(), 1);
					//删除登录验证码的cookie
					request.getSession().removeAttribute(Constants.VALIDATE_CODE);
					WebUtils.Success(response, vo.getLoginName()+"登陆成功!","index");
				}
			}
			
		}catch(Exception e) {
			WebUtils.Error(response, "登录异常!");
		}
		
		WebUtils.Success(response, "登录成功!");
		return response;
	}
	

	/**
	 * 登出
	 * @author  张超群	2018年3月11日下午10:03:12
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping("/logout")
	@ResponseBody
	public BaseResponse<Map<String,Object>> Logout(HttpServletRequest request,HttpServletResponse resp) {
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		Long userId = null;
		try {
			userId = UserLoginUtils.getLoginUserId(request);
			if(userId != null){
				//删除用户内容缓存
//				EHCacheManager.remove(Constants.LOGIN_CACHE_PREFIX + userId);
//				EHCacheManager.remove(Constants.USER_INFO_CACHE_PREFIX + userId);
//				EHCacheManager.remove(Constants.USER_MENU_CACHE_PREFIX + userId);
//				EHCacheManager.remove(Constants.USER_PERMISSION_INFO_PREFIX + userId);
//				EHCacheManager.remove(Constants.USER_PERMISSION_URL_PREFIX + userId);
//				EHCacheManager.remove(Constants.USER_MENU_ALL_PREFIX + userId);
				// 删除页面用户Cookie
				WebUtils.deleteCookie(request, resp, Constants.LOGIN_CACHE_PREFIX);
				// 清空所有的Session
				request.getSession().invalidate();
				WebUtils.Success(response, "退出成功!");
			}else{
				WebUtils.Error(response, "退出失败!");
			}
		} catch (Exception e) {
			WebUtils.Error(response, "服务出错!");
		}
		return response;
	}
	
	
	/**
	 * 生成登录页验证码
	 * @author 张超群 
	 * @Time   2018年3月11日下午10:03:12
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@GetMapping("/createcode")
	@ResponseBody
	public void createValidCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
			ValidationCode.createImage(request, response);
	}
	
	/**
	 * 效验验证码
	 * @author  张超群	
	 * 2018年3月11日下午10:15:50
	 * @param request
	 * @param session
	 * @param code
	 * @return
	 */
	@RequestMapping(value="/validcode")
	public @ResponseBody Map<String,Boolean> validSessionCode(HttpServletRequest request,HttpSession session,String code){
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		// 1.获取session中的登录验证码
		String sessionCode = String.valueOf(session.getAttribute(Constants.VALIDATE_CODE));
		logger.info("表单输入的验证码:"+code+",session中获取的验证码:"+sessionCode+",验证结果:"+Objects.equals(code.toLowerCase().trim(),sessionCode.toLowerCase().trim())+",当前时间:"+ToolDateTime.dateToDateString(new Date()));
		
		// 2.返回是否成功！
		if(StringUtils.isBlank(code)||StringUtils.isBlank(sessionCode)||Objects.equals(sessionCode, "null")){
			map.put("result", false);
		}
		if(Objects.equals(code.toLowerCase().trim(),sessionCode.toLowerCase().trim())){
			map.put("result", true);
		}else{
			map.put("result", false);
		}
		return map;
	}

	/**
	 * 用户注册
	 * @Time   2018年3月13日下午3:57:08
	 * @param registerVo
	 * @return
	 */
	@Deprecated
	public BaseResponse<Map<String,Object>> register(RegisterVo registerVo){
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		//检测用户是否存在
		login.checkUserByRegister(registerVo);
		//注册新用户
		login.registerLoginInfoAndUserInfo(registerVo);
		
		return response;
	}
	
	/**
	 * 找回密码
	 * @author 张超群 
	 * @Time   2018年3月13日下午4:16:07
	 * @param registerVo
	 * @return
	 */
	@Deprecated
	public BaseResponse<Map<String,Object>> findPassword(){
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		return response;
	}


}
