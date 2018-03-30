package com.chinayouthedu.zqzc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chinayouthedu.zqzc.config.core.BaseController;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Cla;
import com.chinayouthedu.zqzc.service.ClassService;
import com.chinayouthedu.zqzc.service.Transfer;
import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="班级管理接口API")
public class ClassController extends BaseController{

	@Autowired
	private ClassService classService;	// 班级Service
	
	@Autowired
	private Transfer transfer;		// 字典转换器

	@ApiOperation(value="更改班级的班主任")
	@PostMapping(value = "/class/headteacher")
	public BaseResponse appointHeadTeacher(Long claId,Long teacherId) {
		return classService.appointHeadteacher(claId, teacherId);
	}
	
	/**
	 * 增加or更新一个班级
	 * @param cla 封装的班级对象
	 * @return if(id!=null),返回更新结果(BaseResponse)
	 * @return if(id==null),返回新增结果(BaseResponse)
	 */
	@ApiOperation(value="增加/更新一个班级")
	@PostMapping(value = "/class")
	public BaseResponse saveClass(Cla cla) {
		
		if(cla!=null&&cla.getId()!=null){
			//
			return classService.updateClass(cla);
		}else{
			return classService.saveClass(cla);
		}
	
	}
	
	/**
	 * 删除一个班级
	 * @适用场景:班级列表后的删除按钮
	 * @HTTP请求方式:Delete
	 * @param classId 班级的ID
	 * @return BaseResponse对象,内部封装了所有相关的返回数据(是否更新成功...)
	 */
	@ApiOperation(value="根据班级的ID删除一个班级")
	@ApiImplicitParam(dataType="Long",required=true)
	@DeleteMapping(value = "/class/{classId}")
	public BaseResponse deleteClass(@PathVariable(required = true,value="classId") Long classId) {
		
		return classService.deleteClass(classId);
	
	}

	/**
	 * 根据班级主键查询单个班级对象
	 * @HTTP请求方式:Get
	 * @适用场景:(包含但不仅限于):组织-班级管理-班级管理-列表区域
	 * @return List<Classes> 班级对象集合
	 */
	@ApiOperation(value="根据班级的ID获取班级的详细信息")
	@GetMapping(value="/class/{classId}")
	public Cla selectClassByPrimaryKey(@PathVariable(value="classId",required = true) Long classId) {
		return classService.selectClassByPrimaryKey(classId);
	}
	
	/**
	 * 根据年级ID查询班级集合
	 * @HTTP请求方式:Get
	 * @适用场景:(包含但不仅限于):组织-班级管理-班级管理-列表区域
	 * @return List<Classes> 班级对象集合
	 */
	@ApiOperation(value="根据年级ID获取班级列表的详细信息")
	@GetMapping(value="/class/bygrade/{gradeId}")
	public List<Cla> selectClassListByGradeId(@PathVariable(value="gradeId",required = true) Long gradeId) {
		return transfer.transfer(classService.selectAllClassesByGradeId(gradeId) );
	}
	
	/**
	 * 查询所有的班级
	 * @return
	 */
	@ApiOperation(value="不分年级查询所有的班级列表信息")
	@GetMapping(value="/class/all")
	public List<Cla> selectAllClassListByGradeId() {
		return transfer.transfer(classService.selectAllClasses());
	}
	
}
