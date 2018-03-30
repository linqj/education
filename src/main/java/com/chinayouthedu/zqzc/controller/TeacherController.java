package com.chinayouthedu.zqzc.controller;

import com.chinayouthedu.zqzc.config.core.BaseController;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Teacher;
import com.chinayouthedu.zqzc.entity.vo.TeacherVo;
import com.chinayouthedu.zqzc.service.TeacherService;
import com.github.pagehelper.PageInfo;
import com.google.common.primitives.Longs;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="教师管理接口API")
public class TeacherController extends BaseController{

	@Autowired
	private TeacherService teacherService;
	
	/**
	 * 保存或者更新教师
	 * @param teacher
	 * @return
	 */
	@ApiOperation(value="添加教师或者更新教师",notes="带id的为更新,不带id的为保存")
	@PostMapping(value="/teacher")
	public BaseResponse saveTeacher(Teacher teacher, TeacherVo vo, @RequestParam(required=false)Long tId){
		if(tId==null) {
			return teacherService.saveTeacher(teacher );
		}else {
			return teacherService.updateTeacher(vo, tId);
		}
	}
	
	/**
	 * 删除单个教师
	 * @param teacherId
	 * @return
	 */
	@ApiOperation(value="根据教师ID删除教师")
	@DeleteMapping(value="/teacher/{teacherId}")
	public BaseResponse deleteTeacherByPrimaryKey(@PathVariable(value="teacherId",required=true)Long teacherId){
		return teacherService.deleteTeacherByPrimaryKey(teacherId );
	}
	
	/**
	 * 批量删除教师
	 * @param ids
	 * @return
	 */
	@ApiOperation(value="根据教师ID数组批量删除教师",notes="接收参数:数组long类型的数组")
	@PostMapping(value="/teacher/delete")
	public BaseResponse batchDeleteTeacher(long[] ids){
		
		List<Long> idList = Longs.asList(ids );
		return teacherService.batchDeleteTeacher(idList );
	
	}
	
	/**
	 * 列表查询教师
	 * @param pageNum
	 * @param pageSize
	 * @param name
	 * @return
	 */
	@ApiOperation(value="分页查询教师信息",notes="可以使用&name=进行教师名称模糊查询")
	@GetMapping(value="/teacher/list")
	public PageInfo<Teacher> pageSelectTeacher(@RequestParam(required=false,defaultValue="1")Integer pageNum,
			@RequestParam(required=false,defaultValue="10")Integer pageSize,
			@RequestParam(required=false,defaultValue="")String name){
		
		return teacherService.selectTeacherPageInfo(pageNum, pageSize, name);
		
	}
	
	@ApiOperation(value="根据教师ID查询教师的详细个人数据")
	@GetMapping(value="/teacher/{id}")
	public Teacher selectTeacherByPrimaryKey(@PathVariable(value="id",required=true)Long id) {
		return teacherService.selectTeacherByPrimaryKey(id );
	}
	
	
	@ApiOperation(value="查询所有教师")
	@GetMapping(value="/teacher/all")
	public List<Teacher> getAllTeacher() {
		return teacherService.selectAllTeacher();
	}
	
}
