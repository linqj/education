package com.chinayouthedu.zqzc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.config.core.BaseController;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.config.exception.WebException;
import com.chinayouthedu.zqzc.entity.paike.Classroom;
import com.chinayouthedu.zqzc.entity.paike.ClassroomBuilding;
import com.chinayouthedu.zqzc.entity.paike.ClassroomBuildingExample;
import com.chinayouthedu.zqzc.entity.paike.ClassroomExample;
import com.chinayouthedu.zqzc.entity.paike.SchoolYear;
import com.chinayouthedu.zqzc.entity.paike.Semester;
import com.chinayouthedu.zqzc.entity.paike.SemesterExample;
import com.chinayouthedu.zqzc.entity.vo.ClassroomBuildingVo;
import com.chinayouthedu.zqzc.service.ClassroomBuildingService;
import com.chinayouthedu.zqzc.service.ClassroomService;
import com.chinayouthedu.zqzc.service.SchoolYearService;
import com.chinayouthedu.zqzc.service.SemesterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;

/***
 * 教学楼管理
 * @Company 中青至诚教育咨询有限公司
 * @author  梁建
 * @Modifier
 * @time   2018年3月9日 下午3:23:16
 * @version 1.0
 */
@RestController
@RequestMapping(value="/classbuilding")
public class ClassroomBuildingController extends BaseController{

	@Autowired
	private ClassroomBuildingService cbService;
	
	@Autowired
	private ClassroomService crService;
	
	/***
	 * 进入教学楼列表 ,以及分页
	 * @author  梁建
	 * @Time   2018年3月7日下午3:47:58
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/list", method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
	public BaseResponse<Map<String, Object>> toList(HttpServletRequest request){
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		
		String pageNum = request.getParameter("pageNum") == null ? "1" : request.getParameter("pageNum");// 第几页
		String pageSize = request.getParameter("pageSize") == null ? "10" : request.getParameter("pageSize");// 显示几条
		if (!"".equals(pageNum) && pageNum.length() <= 0) {
			pageNum = "1";
		}
		if (!"".equals(pageSize) && pageSize.length() <= 0) {
			pageSize = "10";
		}
		PageHelper.startPage(Integer.parseInt(pageNum),Integer.parseInt(pageSize)); //开始分页
		//获取所有的教学楼信息,List
		List<ClassroomBuilding> cbList = cbService.selectAll();
		PageInfo<ClassroomBuilding> info = new PageInfo<ClassroomBuilding>(cbList);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", info.getTotal());		//总共多少条
		map.put("totalPages", info.getPages());  //总共多少页
		map.put("pageNum", pageNum);		//第几页
		map.put("pageSize", pageSize);		//每页显示几条
		map.put("list", cbList);
		res.setData(map);
		
		return res;
	}
	
	/***
	 * 进入编辑教学楼页面
	 * @author  梁建
	 * @Time   2018年3月7日下午4:43:02
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/edit")
	public BaseResponse<Map<String, Object>> toEdit(HttpServletRequest request){
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		String cbId = request.getParameter("cbId");
		
		Map<String,Object> map = new HashMap<String,Object>();
		ClassroomBuilding classroomBuilding = cbService.selectByPrimaryKey(Long.parseLong(cbId));
		
		map.put("classroomBuilding", classroomBuilding);
		
		
		res.setData(map);
		return res;
	}
	
	/***
	 * 保存新添加的教学楼
	 * @author  梁建
	 * @Time   2018年3月7日下午5:11:53
	 * @return
	 */
	@PostMapping("/save")
	public BaseResponse<Map<String, Object>> saveClassroomBuilding(ClassroomBuildingVo vo, HttpServletRequest request){
		logger.info("vo:"+JSON.toJSONString(vo));
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		//获取前台传递的教学楼id,用
		String cbId = request.getParameter("cbId");
		Long cbid = StringUtils.isNotBlank(cbId)?Long.parseLong(cbId):null;
		
		if (cbid == null) {   //教学楼id为空,说明是新增
			
			if (vo.getBuildingName() == null) {
				WebUtils.Error(res, "教学楼名称不能为空!");
				return res;
			}
			if (vo.getBuildingNumber() == null) {
				WebUtils.Error(res, "教学楼编号不能为空!");
				return res;
			}
			
			ClassroomBuilding classroomBuilding = new ClassroomBuilding();
			classroomBuilding.setBuildingName(vo.getBuildingName());
			classroomBuilding.setBuildingNumber(vo.getBuildingNumber());
			classroomBuilding.setCreateTime(new Date());
			//先插入学年信息,返回主键.
			int i = cbService.insert(classroomBuilding);
			if (i > 0) {
				WebUtils.Success(res, "保存成功!");
				return res;
			}
			
			WebUtils.Error(res, "保存失败!");
			return res;
		}else{ //教学楼id不为空,说明是编辑
			//更新教学楼信息
			BaseResponse<Map<String, Object>> response = cbService.updateClassroomBuilding(cbid, vo);
			return response;
		}
	}
	
	/***
	 * 删除教学楼
	 * @author  梁建
	 * @Time   2018年3月9日下午3:07:20
	 * @param id
	 * @return
	 */
	@DeleteMapping("/del/{cbId}")
	public BaseResponse<Map<String, Object>> delClassroomBuilding(@PathVariable(required=true)Long cbId){
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		
		
//			int i = cbService.deleteByPrimaryKey(cbId);
//			if (i > 0) {
//				WebUtils.Success(res, "删除成功!");
//				return res;
//			}
//		WebUtils.Error(res, "删除失败!");
//		return res;
		ClassroomExample example = new ClassroomExample();
		example.createCriteria().andRoomBuildingIdEqualTo(cbId);
		List<Classroom> list = crService.selectByExample(example);
		//先删除改教学楼下的所有教师
		int i = crService.deleteByExample(example);
		
		if (i == list.size()) {
			int j = cbService.deleteByPrimaryKey(cbId);
			if (i > 0) {
				WebUtils.Success(res, "删除成功!");
				return res;
			}else{
				throw new WebException(404,"删除失败!");
			}
		}else{
			throw new WebException(404,"删除失败!");
		}
		
		
		
	}
	
	
	/**
	 * 教学楼和教室之间的父子结构List
	 * @author  梁建
	 * @Time   2018年3月19日下午6:16:19
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/child", method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
	public BaseResponse<Map<String, Object>> toChild(HttpServletRequest request,HttpServletResponse response){
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		
		ClassroomBuildingExample example = new ClassroomBuildingExample();
		List<ClassroomBuilding> cbList = cbService.selectByExample(example);
		Map<String,Object> map = new HashMap<String,Object>();
		if (cbList.size() > 0) {
			for(ClassroomBuilding cb : cbList) {
				ClassroomExample example1 = new ClassroomExample();
				example1.createCriteria().andRoomBuildingIdEqualTo(cb.getId());
				cb.setChildren(crService.selectByExample(example1));
			}
		}
		map.put("cbList", cbList);
		res.setData(map);
		
		return res;
	}
	
	
	
}