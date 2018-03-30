package com.chinayouthedu.zqzc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinayouthedu.zqzc.config.core.BaseController;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Grade;
import com.chinayouthedu.zqzc.entity.vo.GradeVo;
import com.chinayouthedu.zqzc.service.GradeService;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="年级管理接口API")
public class GradeController extends BaseController {

	@Autowired
	private GradeService gradeService;
	
	/**
	 * 新增/更新一个年级
	 * @param grade 封装的年级对象
	 * @HTTP请求方式: Post
	 * @适用场景:新增年级
	 * @return BaseResponse对象,内部封装了所有相关的返回数据(是否保存成功...)
	 */
	@ApiOperation(value="新增/更新一个年级",notes="当对象中带有id参数时,表示根据该id进行更新,否则表示新建")
	@PostMapping(value = "/grade")
	public BaseResponse saveGrade(Grade grade) {
		
		logger.info("grade="+new Gson().toJson(grade));
		
		if(grade!=null&&grade.getId()!=null){
			return gradeService.update(grade);
		}else{
			return gradeService.save(grade );
		}

	}
	
	/**
	 * 删除一个年级
	 * @适用场景:年级列表后的删除按钮
	 * @HTTP请求方式:Delete
	 * @param gradeId 年级的ID
	 * @return BaseResponse对象,内部封装了所有相关的返回数据(是否更新成功...)
	 */
	@ApiOperation(value="根据年级的ID删除一个年级")
	@DeleteMapping(value = "/grade/{gradeId}")
	public BaseResponse deleteGrade(@PathVariable(required=true)Long gradeId) {
		
		return gradeService.deleteGrade(gradeId );
		
	}
	
	/**
	 * 通过年级ID获取年级对象
	 * @适用场景:编辑年级时取数据
	 * @HTTP请求方式:Get
	 * @HTTP请求路径例子:http://website/grade/1
	 * @param gradeId
	 * @return BaseResponse对象,内部封装了所有相关的返回数据(是否保存成功...)
	 */
	@ApiOperation(value="根据年级的ID查询年级的详细信息",notes="如果没有与该ID匹配的年级数据,会返回空或者null")
	@GetMapping(value = "/grade/{gradeId}")
	public Grade selectByPrimaryKey(@PathVariable(required=true)Long gradeId) {
		
		// 返回年级数据
		return gradeService.selectByPrimaryKey(gradeId );
	
	}

	/**
	 * 获取年级列表(父子结构,子结构为班级列表)
	 * @param pageNum ,可以不传,默认值为1
	 * @param pageSize ,可以不传,默认值为10
	 * @Http请求方式:Get
	 * @适用场景: 年级列表
	 * @return PageInfo<GradeVo> 封装了年级和年级下的班级的父子结构信息的集合,以及分页相关数据
	 */
	@ApiOperation(value="分页年级数据列表查询",notes="返回的数据是一个类父子结构的数据,同时包含年级下的班级数据")
	@GetMapping(value = "/grade/list")
	public PageInfo<GradeVo> getList(
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {

		return gradeService.getGradeVoPageList(pageNum, pageSize);

	}

	/**
	 * 查询所有的年级对象,不包含父子结构
	 * @HTTP请求方式:Get
	 * @适用场景:(包含但不仅限于):组织-班级管理-年级管理的 左侧 的年级列表
	 * @return
	 */
	@ApiOperation(value="不分页查询所有年级数据列表",notes="返回的数据是一个不带班级信息的数据")
	@GetMapping(value = "/grade/all")
	public List<Grade> getAllEffectiveGrade() {
		
		// 返回所有的年级对象集合
		return gradeService.getAllEffectiveGrade();
	
	}
	
	/**
	 * 查询所有的年级对象,不包含父子结构
	 * @HTTP请求方式:Get
	 * @适用场景:(包含但不仅限于):组织-班级管理-年级管理的 左侧 的年级列表
	 * @return
	 */
	@ApiOperation(value="不分页查询所有年级数据列表",notes="返回的数据是一个类父子结构的数据,同事包含班级信息的数据")
	@GetMapping(value = "/grade/class")
	public List<GradeVo> selectAllGradeVo() {
		
		// 返回所有的年级对象集合
		return gradeService.selectAllGradeVo();
		
	}


}