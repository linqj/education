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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Classroom;
import com.chinayouthedu.zqzc.entity.paike.ClassroomBuilding;
import com.chinayouthedu.zqzc.entity.paike.ClassroomExample;
import com.chinayouthedu.zqzc.entity.vo.ClassroomBuildingVo;
import com.chinayouthedu.zqzc.entity.vo.ClassroomVo;
import com.chinayouthedu.zqzc.mapper.paike.ClassroomMapper;
import com.chinayouthedu.zqzc.service.ClassroomBuildingService;
import com.chinayouthedu.zqzc.service.ClassroomService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/***
 * 教室管理
 * @Company 中青至诚教育咨询有限公司
 * @author  梁建
 * @Modifier
 * @time   2018年3月12日 上午10:00:56
 * @version 1.0
 */
@RestController
@RequestMapping(value="/classroom")
public class ClassroomController {
	@Autowired
	private ClassroomBuildingService cbService;
	@Autowired
	private ClassroomService crService;
	
	/***
	 * 传递教学楼到前台
	 * @author  梁建
	 * @Time   2018年3月12日上午10:04:28
	 * @return
	 */
	@RequestMapping(value="/cblist", method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
	public List<ClassroomBuilding> classroomBuildList(){
		List<ClassroomBuilding> cbList = cbService.selectAll();
		return cbList;
	}
	
	/**
	 * 根据教学楼id查出对应的所有教室
	 * @author  梁建
	 * @Time   2018年3月12日上午10:44:53
	 * @param cbId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/crlist", method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
	public BaseResponse<Map<String, Object>> toList(Long cbId, HttpServletRequest request,HttpServletResponse response){
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
		//获取教学楼id下的所有教室信息,List
		List<Classroom> crList = crService.selectClassroom(cbId);
		PageInfo<Classroom> info = new PageInfo<Classroom>(crList);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", info.getTotal());		//总共多少条
		map.put("totalPages", info.getPages());  //总共多少页
		map.put("pageNum", pageNum);		//第几页
		map.put("pageSize", pageSize);		//每页显示几条
		map.put("list", crList);
		
		res.setData(map);
		return res;
	}
	
	/***
	 * 进入编辑教室
	 * @author  梁建
	 * @Time   2018年3月7日下午4:43:02
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/edit")
	public BaseResponse<Map<String, Object>> toEdit(HttpServletRequest request){
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		String crId = request.getParameter("crId");
		
		Map<String,Object> map = new HashMap<String,Object>();
		Classroom classroom = crService.selectByPrimaryKey(Long.parseLong(crId));
		
		map.put("classroom", classroom);
		
		
		res.setData(map);
		return res;
	}
	
	/***
	 * 保存新添加的教室
	 * @author  梁建
	 * @Time   2018年3月7日下午5:11:53
	 *   cbId  教学楼Id
	 *   crId  教室id
	 * @return
	 */
	@PostMapping("/save")
	public BaseResponse<Map<String, Object>> saveClassroomBuilding(ClassroomVo vo, HttpServletRequest request){
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		//获取前台传递的教学楼id,用于判断
		String cbId = request.getParameter("cbId");
		String crId = request.getParameter("crId");
		
		Long crid = StringUtils.isNotBlank(crId)?Long.parseLong(crId):null;
		if (crid == null) {   //教室id为空,说明是新增
			
			Classroom classroom = new Classroom();
			classroom.setRoomName(vo.getRoomName());
			classroom.setRoomNumber(vo.getRoomNumber());
			classroom.setRoomBuildingId(Long.parseLong(cbId));
			classroom.setRoomBuildingName(cbService.selectByPrimaryKey(Long.parseLong(cbId)).getBuildingName());
			classroom.setCreateTime(new Date());
			
			//插入教师信息
			int i = crService.insert(classroom);
			if (i > 0) {
				WebUtils.Success(res, "保存成功!");
				return res;
			}
			WebUtils.Error(res, "保存失败!");
			return res;
		}else{ //教室id不为空,说明是编辑
			//更新教学楼信息
			BaseResponse<Map<String, Object>> response = crService.updateClassroom(crid, vo);
			return response;
		}
	}
	
	/***
	 * 删除教室
	 * @author  梁建
	 * @Time   2018年3月9日下午3:07:20
	 * @param crId 教室id
	 * @return
	 */
	@DeleteMapping("/del/{crId}")
	public BaseResponse<Map<String, Object>> delClassroomBuilding(@PathVariable(required=true)Long crId){
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		
			int i = crService.deleteByPrimaryKey(crId);
			if (i > 0) {
				WebUtils.Success(res, "删除成功!");
				return res;
			}
		WebUtils.Error(res, "删除失败!");
		return res;
	}
	
}
