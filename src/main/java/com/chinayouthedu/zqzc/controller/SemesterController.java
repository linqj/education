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
import org.springframework.web.bind.annotation.RestController;

import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.config.core.BaseController;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.SchoolYear;
import com.chinayouthedu.zqzc.entity.vo.SchoolYearVo;
import com.chinayouthedu.zqzc.service.SchoolYearService;
import com.chinayouthedu.zqzc.service.SemesterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 学年学期管理
 * @Company 中青至诚教育咨询有限公司
 * @author  梁建
 * @Modifier
 * @time   2018年3月6日 下午5:50:15
 * @version 1.0
 */
@RestController
@RequestMapping("/semester")
public class SemesterController extends BaseController{

	@Autowired
	private SchoolYearService syService;
	@Autowired
	private SemesterService xqService;
	
	
	/***
	 * 进入学年学期列表 ,以及分页
	 * @author  梁建
	 * @Time   2018年3月7日下午3:47:58
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/list", method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
	public BaseResponse<Map<String, Object>> toList(HttpServletRequest request){
		BaseResponse<Map<String, Object>> res = syService.toList(request);
		return res;
	}
	
	/**
	 * 学年学期父子List 不含分页
	 * @author  梁建
	 * @Time   2018年3月23日上午9:51:41
	 * @return
	 */
	@GetMapping("/schoolyearlist")
	public List<SchoolYear> SchoolYearList(){
		List<SchoolYear> syList = syService.SchoolYearList();
		return syList;
	}
	
	/***
	 * 进入编辑学期页面
	 * @author  梁建
	 * @Time   2018年3月7日下午4:43:02
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/edit")
	public BaseResponse<Map<String, Object>> toEdit(HttpServletRequest request){
		BaseResponse<Map<String, Object>> res = syService.toEdit(request);
		return res;
	}
	
	/***
	 * 保存/编辑新的学年,学期
	 * @author  梁建
	 * @Time   2018年3月7日下午5:11:53
	 * xnId  学年id
	 * @return
	 */
	@PostMapping("/save")
	public BaseResponse<Map<String, Object>> saveSemester(SchoolYearVo vo, HttpServletRequest request){
		/*BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		//获取前台传递的学年id,用于判断
		String xnId = request.getParameter("xnId");
		Long xnid = StringUtils.isNotBlank(xnId)?Long.parseLong(xnId):null;
		
		if (xnid == null) {   //学年id为空,说明是新增
			SchoolYear schoolYear = new SchoolYear();
			schoolYear.setSchoolYearName(vo.getSchoolYearName());
			schoolYear.setSchoolYearCode(vo.getSchoolYearCode());
			schoolYear.setCreateTime(new Date());
			//先插入学年信息,返回主键.
			int i = syService.insert(schoolYear);
			if (i > 0) {
				//学年信息添加成功的情况下.再添加学期信息数据
				int all = xqService.insertAll(schoolYear.getId(), vo);
				if (all > 1) {
					WebUtils.Success(res, "保存成功!");
					return res;
				}
			}
			WebUtils.Error(res, "保存失败!");
			return res;
		}else{ //学年id不为空,说明是编辑
			//先更新学年信息
			int i = syService.updateSchoolYear(vo, xnid);
			if (i > 0) {
				int j = xqService.updateFirstAndLast(xnid, vo);
				if (j > 1) {
					WebUtils.Success(res, "编辑成功!");
					return res;
				}
			}
			WebUtils.Error(res, "编辑失败!");
			return res;
		}*/
		BaseResponse<Map<String, Object>> res = syService.saveSemester(vo, request);
		return res;
	}
	
	/***
	 * 删除学年及学期
	 * @author  梁建
	 * @Time   2018年3月9日下午3:07:20
	 * @param id
	 * @return
	 */
	@DeleteMapping("/del/{xnid}")
	public BaseResponse<Map<String, Object>> delSemester(@PathVariable(required=true)Long xnid){
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		
		int i = xqService.deleteFirstAndLast(xnid);
		if (i > 1) {
			int j = syService.deleteByPrimaryKey(xnid);
			if (j > 0) {
				WebUtils.Success(res, "删除成功!");
				return res;
			}
		}
		WebUtils.Error(res, "删除失败!");
		return res;
	}
	
	
}
