package com.chinayouthedu.zqzc.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinayouthedu.zqzc.config.core.BaseController;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Student;
import com.chinayouthedu.zqzc.entity.paike.Teacher;
import com.chinayouthedu.zqzc.service.ResetPasswardService;
import com.chinayouthedu.zqzc.service.StudentService;
import com.chinayouthedu.zqzc.service.TeacherService;
import com.chinayouthedu.zqzc.service.Transfer;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/resetpwd")
public class ResetPasswardController extends BaseController{

	@Autowired
	private ResetPasswardService rpService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private Transfer transfer;
	
	@Autowired
	private TeacherService teacherService;
	
	
	/**
	 * 传输教师列表,带分页
	 * @author  梁建
	 * @Time   2018年3月23日下午3:27:03
	 * @param pageNum
	 * @param pageSize
	 * @param name
	 * @return
	 */
	@RequestMapping("/teacherlist")
	public PageInfo<Teacher> toTeacherList(@RequestParam(required=false,defaultValue="1")Integer pageNum,
											   @RequestParam(required=false,defaultValue="10")Integer pageSize,
											   @RequestParam(required=false,defaultValue="")String name){
		PageInfo<Teacher> teacherPageInfo = teacherService.selectTeacherPageInfo(pageNum, pageSize, name);
		return teacherPageInfo;
		
	}
	
	/**
	 * 传输学生列表,带分页
	 * @author  梁建
	 * @Time   2018年3月23日下午3:27:35
	 * @param pageNum
	 * @param pageSize
	 * @param gradeId
	 * @param claId
	 * @param name
	 * @return
	 */
	@GetMapping(value="/student/list")
	public PageInfo<Student> getStudentList(
			@RequestParam(required=false,defaultValue="1")Integer pageNum,
			@RequestParam(required=false,defaultValue="10")Integer pageSize,
			@RequestParam(required=false,defaultValue="-1")Long gradeId,
			@RequestParam(required=false,defaultValue="-1")Long claId,
			@RequestParam(required=false,defaultValue="")String name
			){
		gradeId = gradeId==-1L?null:gradeId;
		claId = claId==-1L?null:claId;
		name = StringUtils.isNotBlank(name)?name.trim():"";
		if(claId!=null){
			gradeId = null;
		}
		PageInfo<Student> pageInfo= studentService.pageList(pageNum,pageSize,gradeId,claId,name);
		return transfer.transfer(pageInfo);
	}
	
	/**
	 * 重置密码为123456
	 * @author  梁建
	 * @Time   2018年3月23日下午4:54:08
	 * @param id   选中人员Id
	 * @param remark  学号或者工号
	 * @return
	 */
	@PostMapping("/reset")
	public BaseResponse<Map<String, Object>> resetPwd(@RequestParam(required=false)Long id, @RequestParam(required=false)String remark){
		BaseResponse<Map<String, Object>> response = rpService.resetPwd(id, remark);
		return response;
	}
	
}
