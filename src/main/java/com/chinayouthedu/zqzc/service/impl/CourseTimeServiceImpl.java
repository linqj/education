package com.chinayouthedu.zqzc.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.SchoolYear;
import com.chinayouthedu.zqzc.entity.paike.SchoolYearExample;
import com.chinayouthedu.zqzc.entity.paike.Semester;
import com.chinayouthedu.zqzc.entity.paike.SemesterExample;
import com.chinayouthedu.zqzc.entity.paike.TeacherCoursetime;
import com.chinayouthedu.zqzc.entity.paike.TeacherGroup;
import com.chinayouthedu.zqzc.entity.paike.TeacherGroupExample;
import com.chinayouthedu.zqzc.entity.vo.CourseTimeVo;
import com.chinayouthedu.zqzc.mapper.paike.SchoolYearMapper;
import com.chinayouthedu.zqzc.mapper.paike.SemesterMapper;
import com.chinayouthedu.zqzc.mapper.paike.TeacherCoursetimeMapper;
import com.chinayouthedu.zqzc.mapper.paike.TeacherGroupMapper;
import com.chinayouthedu.zqzc.service.CourseTimeService;

@Service
public class CourseTimeServiceImpl extends BaseServiceImpl implements CourseTimeService {

	@Autowired
	private TeacherCoursetimeMapper mapper;

	@Autowired
	private SchoolYearMapper symapper;
	
	@Autowired
	private SemesterMapper xqmapper;
	
	@Autowired
	private TeacherGroupMapper tgmapper;
	
	/**
	 * 进入课时管理时先传入学年学期父子结构List
	 */
	@Override
	public List<SchoolYear> syList() {
		SchoolYearExample example = new SchoolYearExample();
		List<SchoolYear> syList = symapper.selectByExample(example);
		Map<String, Object> map = new HashMap<String, Object>();
		if (syList.size() > 0) {
			for (SchoolYear schoolYear : syList) {
				SemesterExample example2 = new SemesterExample();
				example2.createCriteria().andSchoolYearIdEqualTo(schoolYear.getId());
				List<Semester> list = xqmapper.selectByExample(example2);
				schoolYear.setChildren(list);
			}
		}
		return syList;
	}

	/**
	 * 查询教研组List
	 */
	@Override
	public List<TeacherGroup> tgList() {
		TeacherGroupExample example = new TeacherGroupExample();
		List<TeacherGroup> list = tgmapper.selectByExample(example);
		return list;
	}

	@Override
	public BaseResponse<Map<String, Object>> save(CourseTimeVo vo, Long id) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		if (id == null) {  //是新增
			TeacherCoursetime coursetime = new TeacherCoursetime();
//				BeanUtils.copyProperties(vo, coursetime);
				org.springframework.beans.BeanUtils.copyProperties(vo, coursetime);
				
				coursetime.setCreateTime(new Date());
				int i = mapper.insert(coursetime);
				if (i > 0) {
					WebUtils.Success(res, "保存成功!");
					return res;
				}else{
					WebUtils.Error(res, "保存失败!");
					return res;
				}
			
		}else{	//是编辑
			TeacherCoursetime coursetime = mapper.selectByPrimaryKey(id);
//				BeanUtils.copyProperties(vo, coursetime);
				org.springframework.beans.BeanUtils.copyProperties(vo, coursetime);
				coursetime.setUpdateTime(new Date());
				int i = mapper.updateByPrimaryKey(coursetime);
				if (i > 0) {
					WebUtils.Success(res, "保存成功!");
					return res;
				}else{
					WebUtils.Error(res, "保存失败!");
					return res;
				}
		}
//		return res;
	}

}
