package com.chinayouthedu.zqzc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinayouthedu.zqzc.config.core.BaseController;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.SchoolYear;
import com.chinayouthedu.zqzc.entity.paike.Teacher;
import com.chinayouthedu.zqzc.entity.paike.TeacherCoursetime;
import com.chinayouthedu.zqzc.entity.paike.TeacherCoursetimeExample;
import com.chinayouthedu.zqzc.entity.paike.TeacherCoursetimeExample.Criteria;
import com.chinayouthedu.zqzc.entity.paike.TeacherGroup;
import com.chinayouthedu.zqzc.entity.vo.CourseTimeVo;
import com.chinayouthedu.zqzc.mapper.paike.TeacherCoursetimeMapper;
import com.chinayouthedu.zqzc.mapper.paike.TeacherGroupMapper;
import com.chinayouthedu.zqzc.mapper.paike.TeacherMapper;
import com.chinayouthedu.zqzc.service.CourseTimeService;
import com.chinayouthedu.zqzc.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 教师课时管理
 * @Company 中青至诚教育咨询有限公司
 * @author  梁建
 * @Modifier
 * @time   2018年3月21日 下午4:28:25
 * @version 1.0
 */
@RestController
@RequestMapping("/coursetime")
public class CourseTimeController extends BaseController{

	@Autowired
	private CourseTimeService ctService;
	
	@Autowired
	private TeacherCoursetimeMapper ctmapper;
	
	@Autowired
	private TeacherService tService;
	
	@Autowired
	private TeacherMapper tmapper;
	
	@Autowired
	private TeacherGroupMapper tgmapper;
	
	
	/**
	 * 进入课时管理时先传入学年学期父子结构List
	 * @author  梁建
	 * @Time   2018年3月21日下午5:19:55
	 * @return
	 */
	@RequestMapping("/sylist")
	public List<SchoolYear> syList(){
		List<SchoolYear> sylist = ctService.syList();
		return sylist;
	}
	
	/**
	 * 查询教研组List,传入前台
	 * @author  梁建
	 * @Time   2018年3月21日下午5:57:37
	 * @return
	 */
	@RequestMapping("/tglist")
	public List<TeacherGroup> tgList(){
		List<TeacherGroup> tglist = ctService.tgList();
		return tglist;
	}
	
	@PostMapping("/ctlist")
	public BaseResponse ctList(HttpServletRequest request, 
								@RequestParam(required=false)Long syId, 
								@RequestParam(required=false)Long xqId, 
								@RequestParam(required=false)Long tgId,
								@RequestParam(required=false,defaultValue="1")Integer pageNum,
								@RequestParam(required=false,defaultValue="10")Integer pageSize){
	
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		/*
		 *  A.查出所有的关系数据并且封装成<教师ID,关系对象>的Map结构
		 */
		Map<Long,TeacherCoursetime> relationMap = new HashMap<>();
		
		// 1.根据学年学期,教研组等查询出关系数据
		if (syId != null && xqId != null ) {
			TeacherCoursetimeExample example = new TeacherCoursetimeExample();
			Criteria criteria = example.createCriteria()
									.andSchoolYearIdEqualTo(syId)
									.andSemesterIdEqualTo(xqId);
			if(tgId != null) {
				criteria.andTeacherGroupIdEqualTo(tgId);
			}
			List<TeacherCoursetime> relationList = ctmapper.selectByExample(example);
			// 2.遍历,封装进map
			if(relationList!=null&&relationList.size()>0) {
				for (TeacherCoursetime teacherCoursetime : relationList) {
					relationMap.put(teacherCoursetime.getTeacherId(), teacherCoursetime);
				}
			}
		}
		/*
		 * B.查出分页的教师分页对象
		 */
		PageHelper.startPage(pageNum,pageSize ); //开始分页
		List<Teacher> allTeacher = new ArrayList<>();
		if(tgId==null) {
			allTeacher = tService.selectAllTeacher();
		}else {
			allTeacher = tService.selectTeacherListByTeacherGroupId(tgId );
		}
		PageInfo<Teacher> pageInfo = new PageInfo<Teacher>(allTeacher);
		
		/*
		 * C.将教师对象和关系对象结合组成TeacherCoursetime对象,封装到tctList集合中
		 */
		List<TeacherCoursetime> tctList = new ArrayList<TeacherCoursetime>();
		if(pageInfo!=null&&pageInfo.getList()!=null&&pageInfo.getList().size()>0) {
			for (Teacher teacher : pageInfo.getList()) {
				TeacherCoursetime tct = new TeacherCoursetime();
				
				if(relationMap.containsKey(teacher.getId() )){
					tct = relationMap.get(teacher.getId());
					tct.setTeacherName(teacher.getTeacherName());
					tct.setTeacherGroupName(teacher.getTeacherGroupName());
				}else{
					tct.setTeacherId(teacher.getId() );
					tct.setTeacherName(teacher.getTeacherName() );
					tct.setTeacherGroupId(teacher.getTeacherGroupId() );
					tct.setTeacherGroupName(teacher.getTeacherGroupName() );
					tct.setAllLearnTime(0);
					tct.setWeekLearnTime(0);
					tct.setActualCourseTime(0);
				}
				tctList.add(tct );
			}
		}
		
		/*
		 * D.返回数据
		 */
		Map<String,Object> map = new HashMap<>();
		
		map.put("total", pageInfo.getTotal());		//总共多少条
		map.put("totalPages", pageInfo.getPages());  //总共多少页
		map.put("pageNum", pageNum);		//第几页
		map.put("pageSize", pageSize);		//每页显示几条
		
		map.put("tctList", tctList);
		res.setData(map);
		
		return res;
		
	}
	
	/**
	 * 保存
	 * @author  梁建
	 * @Time   2018年3月23日上午11:01:53
	 * @param vo
	 * @param id
	 * @return
	 */
	@RequestMapping("/save")
	public BaseResponse<Map<String, Object>> save(CourseTimeVo vo, @RequestParam(required=false)Long id){
		BaseResponse<Map<String, Object>> response = ctService.save(vo, id);
		return response;
	}
	
	
}
