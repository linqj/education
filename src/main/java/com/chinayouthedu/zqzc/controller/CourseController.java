package com.chinayouthedu.zqzc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.chinayouthedu.zqzc.entity.paike.Course;
import com.chinayouthedu.zqzc.entity.paike.Dictionary;
import com.chinayouthedu.zqzc.entity.vo.CourseTreeVo;
import com.chinayouthedu.zqzc.entity.vo.CourseVo;
import com.chinayouthedu.zqzc.service.CourseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 课程管理
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2018年3月6日 下午5:44:07
 * @version 1.0
 */
@RestController
@RequestMapping("/course")
@Api(value = "课程管理API",description="课程管理")
public class CourseController extends BaseController{
	
	@Autowired
	private CourseService courseService;
	
	/**
	 * 课程展示
	 * @Time   2018年3月7日下午5:12:12
	 * @param gradeId 	long	年级id
	 * @param pageNum	int		第几页
	 * @param pageSize	int		每页显示几条
	 * @return	json
	 */
	@ApiOperation(value = "课程管理列表", notes = "根据pageNum进行分页")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "java.lang.Long", name = "gradeId", value = "年级id", required = true, paramType = "query"),
            @ApiImplicitParam(dataType = "java.lang.Integer", name = "pageNum", value = "第几页", required = true),
            @ApiImplicitParam(dataType = "java.lang.Integer", name = "pageSize", value = "每页显示条数", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 500, message = "接口异常"),
    })
	@GetMapping("/list")
	public BaseResponse<Map<String,Object>> showList(@RequestParam(value="gradeId",required=true) long gradeId,
			@RequestParam(value="pageNum",required=true,defaultValue="1") int pageNum,
			@RequestParam(value="pageSize",required=true,defaultValue="10") int pageSize){
		BaseResponse<Map<String,Object>> response = courseService.getCourseListByGrade(pageNum, pageSize,gradeId);
		return response;
	}
	
	/**
	 * 创建一个课程
	 * @Time   2018年3月8日下午2:55:05
	 * @param CourseVo	课程VO对象
	 * @return json
	 */
	@PostMapping("/save")
	public BaseResponse<Map<String,Object>> createCourse(CourseVo courseVo,HttpServletRequest request){
		BaseResponse<Map<String,Object>> response = courseService.createCourse(courseVo);
		return response;
	}
	
	/**
	 * 编辑一个课程
	 * @Time   2018年3月8日下午3:48:28
	 * @param CourseVo	课程VO对象
	 * @return json
	 */
	@PostMapping("/edit")
	public BaseResponse<Map<String,Object>> editCourse(HttpServletRequest request,CourseVo CourseVo){
		BaseResponse<Map<String,Object>> response = courseService.editCourse(CourseVo);
		return response;
	}
	
	/**
	 * 删除一个课程
	 * @Time   2018年3月8日下午3:48:42
	 * @param id		long	课程id
	 * @return json
	 */
	@DeleteMapping("/del/{id}")
	public BaseResponse<Map<String,Object>> delCourse(@PathVariable(required = true,value="id") long id){
		BaseResponse<Map<String,Object>> response = courseService.delCourse(id);
		return response;
	}
	
	
	/**
	 * 年级课程管理
	 * @Time   2018年3月8日下午3:51:05
	 * @param gradeId	long	年级id
	 * @return	json
	 */
	@GetMapping("/manage/{gradeId}")
	public BaseResponse<Map<String, List<Dictionary>>> CourseManage(@PathVariable(value="gradeId",required=true) long gradeId){
		BaseResponse<Map<String, List<Dictionary>>> response = courseService.CourseManage(gradeId);
		return response;
	}
	
	/**
	 * 年级课程保存
	 * @Time   2018年3月8日下午3:51:05
	 * @param gradeId	long	年级id
	 * @param codes		String[]	课程编码数组
	 * @return	json
	 */
	@PostMapping("/savemanage")
	public BaseResponse<List<Course>> CourseManageSave(@RequestParam(value="gradeId",required=true) long gradeId,@RequestParam(value="codes",required=true) String[] codes){
		BaseResponse<List<Course>> response = courseService.CourseManageSave(gradeId,codes);
		return response;
	}
	
	
	/**
	 * 获取课程树
	 * eg:
	 * 	语文
	 * 		高一语文
	 * 		高二语文
	 * @Time   2018年3月8日下午3:51:05
	 * @return	json
	 */
	@GetMapping("/coursetree")
	public BaseResponse<List<CourseTreeVo>> getCourseTree(){
		BaseResponse<List<CourseTreeVo>> response = courseService.getCourseTree();
		return response;
	}
	
	/**
	 * 获取该年级下的所有课程
	 * @Time   2018年3月21日下午2:48:05
	 * @param gradeId	long	年级id
	 * @return	json
	 */
	@GetMapping("/gradecourse/{gradeId}")
	public BaseResponse<List<Course>> getGradeCourseList(@PathVariable(value="gradeId",required=true) long gradeId){
		BaseResponse<List<Course>> response = courseService.getGradeCourseList(gradeId);
		return response;
	}
	

}
