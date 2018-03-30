package com.chinayouthedu.zqzc.controller;

import com.chinayouthedu.zqzc.config.core.BaseController;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.CoursePlan;
import com.chinayouthedu.zqzc.entity.vo.CoursePlanVo;
import com.chinayouthedu.zqzc.service.CoursePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 课程开设计划管理
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2018年3月21日  上午10:54:46
 * @version 1.0
 */
@RestController
@RequestMapping("/courseplan")
public class CoursePlanController extends BaseController{

	@Autowired
	private CoursePlanService coursePlan;
	
	/**
	 * 学年学期下课程开设计划列表
	 * @Time   2018年3月21日下午2:38:54
	 * @param semesterId	long	学期id
	 * @param yearId		long	学年id
	 * @return
	 */
	@GetMapping("/list")
	public BaseResponse<List<CoursePlan>> showList(
			@RequestParam(value="yearId",required=true) long yearId,
			@RequestParam(value="semesterId",required=true) long semesterId,
			@RequestParam(value="gradeId",required=false) Long gradeId){
		BaseResponse<List<CoursePlan>> response = coursePlan.getCoursePlanList(yearId,semesterId,gradeId);
		return response;
	}
	
	/**
	 * 批量创建课程计划
	 * @Time   2018年3月27日下午12:41:33
	 * @param request
	 * @param list
	 * @return
	 */
	@PostMapping("/save")
	public BaseResponse<Map<String,Object>> createCoursePlan(HttpServletRequest request,@RequestBody List<CoursePlan> list){
		BaseResponse<Map<String,Object>> response = coursePlan.createCoursePlan(list);
		return response;
	}
	
//	@PostMapping("/edit")
	public BaseResponse<Map<String,Object>> editCoursePlan(HttpServletRequest request,@RequestBody List<CoursePlan> list){
		BaseResponse<Map<String,Object>> response = coursePlan.editCoursePlan(list);
		return response;
	}
	
	/**
	 * 编辑一个课程计划
	 * @Time   2018年3月27日下午12:41:46
	 * @param coursePlanVo
	 * @return
	 */
	@PostMapping("/edit")
	public BaseResponse<Map<String,Object>> editOneCoursePlan(CoursePlanVo coursePlanVo){
		BaseResponse<Map<String,Object>> response = coursePlan.editOneCoursePlan(coursePlanVo);
		return response;
	}
	
	/**
	 * 删除一个课程计划
	 * @Time   2018年3月27日下午12:41:57
	 * @param id
	 * @return
	 */
	@DeleteMapping("/del/{id}")
	public BaseResponse<Map<String,Object>> delCoursePlan(@PathVariable(required = true,value="id") long id){
		BaseResponse<Map<String,Object>> response = coursePlan.delCoursePlan(id);
		return response;
	}
	
}
