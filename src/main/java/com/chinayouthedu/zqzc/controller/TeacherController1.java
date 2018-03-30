package com.chinayouthedu.zqzc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinayouthedu.zqzc.config.core.BaseController;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Teacher;
import com.chinayouthedu.zqzc.service.TeacherGroupService;
import com.chinayouthedu.zqzc.service.TeacherService;

@RestController
@RequestMapping("/teachergroup1")
public class TeacherController1 extends BaseController{

/*	@Autowired
	private TeacherGroupService tgService;
	@Autowired
	private TeacherService tService;
	
	*//**
	 * 左侧教研组列表
	 * @author  梁建
	 * @Time   2018年3月15日下午3:52:20
	 * @param request
	 * @return
	 *//*
	@RequestMapping("/tglist")
	public BaseResponse<Map<String, Object>> toList(HttpServletRequest request) {
		BaseResponse<Map<String, Object>> response = tgService.selectAll(request);
		return response;
	}
	
	
	*//**
	 * 根据教研组id查询教研组成员
	 * @author  梁建
	 * @Time   2018年3月15日下午3:52:46
	 * @param request
	 * 		tgId : 教研组id
	 * @return
	 *//*
	@RequestMapping("/teacherlist")
	public BaseResponse<Map<String, Object>> teacherList(HttpServletRequest request){
		String tgId = request.getParameter("tgId");
		Long tgid = StringUtils.isNotBlank(tgId)?Long.parseLong(tgId):null;
		BaseResponse<Map<String, Object>> response = tgService.selectTeacherByTgid(tgid);
		return response;
	}
	
	*//**
	 * 教研组添加成员时传递数据
	 * @author  梁建
	 * @Time   2018年3月16日下午2:32:21
	 * @param request
	 * 		tgId : 教研组id
	 * @return
	 *//*
	@RequestMapping("/add")
	public BaseResponse<Map<String, Object>> addTeacher(HttpServletRequest request){
		BaseResponse<Map<String, Object>> response = tgService.selectNotTg();
		return response;
		
	}
	
	*//**
	 * 修改教研组长
	 * @author  梁建
	 * @Time   2018年3月19日下午1:59:28
	 * @param tgId
	 * @return
	 *//*
	@RequestMapping("/editleader")
	public BaseResponse<Map<String, Object>> editLeader(HttpServletRequest request){
		String tgId = request.getParameter("tgId");
		Long tgid = StringUtils.isNotBlank(tgId)?Long.parseLong(tgId):null;
		BaseResponse<Map<String, Object>> response = tgService.selectTgLeader(tgid);
		return response;
	}
	
	*//**
	 * 修改教研组副组长
	 * @author  梁建
	 * @Time   2018年3月19日下午2:17:23
	 * @param request
	 * @return
	 *//*
	@RequestMapping("/editleadertwo")
	public BaseResponse<Map<String, Object>> editLeaderTwo(HttpServletRequest request){
		String tgId = request.getParameter("tgId");
		Long tgid = StringUtils.isNotBlank(tgId)?Long.parseLong(tgId):null;
		BaseResponse<Map<String, Object>> response = tgService.selectTgLeaderTwo(tgid);
		return response;
	}
	
	*//**
	 * 保存修改的教研组长
	 * @author  梁建
	 * @Time   2018年3月19日下午4:51:34
	 * @return
	 *//*
	@RequestMapping("/saveleader")
	public BaseResponse<Map<String, Object>> saveLeader(HttpServletRequest request,@RequestParam(required=false,defaultValue="-1")Long tgId,@RequestParam(required=false,defaultValue="-1")Long tId){
//		String tgId = request.getParameter("tgId");
//		Long tgid = StringUtils.isNotBlank(tgId)?Long.parseLong(tgId):null;
		tgService.saveLeader(tgId, tId);
		return null;
	}
	
	*//**
	 * 保存修改的教研组副组长
	 * @author  梁建
	 * @Time   2018年3月20日上午11:19:03
	 * @param request
	 * @param tgId
	 * @param tId
	 * @return
	 *//*
	@RequestMapping("/saveleadertwo")
	public BaseResponse<Map<String, Object>> saveLeaderTwo(HttpServletRequest request,@RequestParam(required=false,defaultValue="-1")Long tgId,@RequestParam(required=false,defaultValue="-1")Long tId){
//		String tgId = request.getParameter("tgId");
//		Long tgid = StringUtils.isNotBlank(tgId)?Long.parseLong(tgId):null;
		tgService.saveLeaderTwo(tgId, tId);
		return null;
	}
	*/

	
}
