package com.chinayouthedu.zqzc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinayouthedu.zqzc.config.core.BaseController;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.vo.TimeTablesVo;
import com.chinayouthedu.zqzc.entity.vo.TimetableRuleVo;
import com.chinayouthedu.zqzc.service.TimeTablesService;

/**
 * 节次管理
 * @Company 中青至诚教育咨询有限公司
 * @author  张超群
 * @Modifier
 * @time   2018年3月19日  下午12:29:30
 * @version 1.0
 */
@RestController
@RequestMapping("/timetables")
public class TimeTablesController extends BaseController{
	
	@Autowired
	private TimeTablesService timeTables;
	
	/**
	 * 节次列表
	 * @Time   2018年3月20日下午12:17:58
	 * @param pageNum	int		第几页
	 * @param pageSize	int		每页显示几条
	 * @return json
	 */
	@GetMapping("/list")
	public BaseResponse<Map<String,Object>> showList(@RequestParam(value="pageNum",required=true,defaultValue="1") int pageNum,
			@RequestParam(value="pageSize",required=true,defaultValue="10") int pageSize){
		BaseResponse<Map<String,Object>> response = timeTables.getCourseTimeTables(pageNum, pageSize);
		return response;
	}
	
	/**
	 * 保存节次
	 * @Time   2018年3月20日下午12:18:36
	 * @param timeTablesVo	节次表单VO对象
	 * @return json
	 */
	@PostMapping("/save")
	public BaseResponse<Map<String,Object>> createCourseTimeTables(TimeTablesVo timeTablesVo){
		BaseResponse<Map<String,Object>> response = timeTables.createCourseTimeTables(timeTablesVo);
		return response;
	}
	
	/**
	 * 编辑节次
	 * @Time   2018年3月20日下午12:18:42
	 * @param timeTablesVo	节次表单VO对象
	 * @return json
	 */
	@PostMapping("/edit")
	public BaseResponse<Map<String,Object>> editCourseTimeTables(TimeTablesVo timeTablesVo){
		BaseResponse<Map<String,Object>> response = timeTables.editCourseTimeTables(timeTablesVo);
		return response;
	}
	
	/**
	 * 删除节次
	 * @Time   2018年3月20日下午12:18:48
	 * @param id	long	节次id
	 * @return json
	 */
	@DeleteMapping("/del/{id}")
	public BaseResponse<Map<String,Object>> delCourseTimeTables(@PathVariable(required = true,value="id") long id){
		BaseResponse<Map<String,Object>> response = timeTables.delCourseTimeTables(id);
		return response;
	}
	
	/**
	 * 初始化节次
	 * @Time   2018年3月20日下午12:18:54
	 * @param timetableRuleVo	节次规则表单VO对象
	 * @return json
	 */
	@PostMapping("/init")
	public BaseResponse<Map<String,Object>> initCourseTimeTables(TimetableRuleVo timetableRuleVo){
		BaseResponse<Map<String,Object>> response = timeTables.initCourseTimeTables(timetableRuleVo);
		return response;
	}
	
	

}
