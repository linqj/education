package com.chinayouthedu.zqzc.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.common.utils.cye.CyeCollectionUtils;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.config.exception.WebException;
import com.chinayouthedu.zqzc.entity.paike.Course;
import com.chinayouthedu.zqzc.entity.paike.CourseExample;
import com.chinayouthedu.zqzc.entity.paike.Dictionary;
import com.chinayouthedu.zqzc.entity.paike.DictionaryExample;
import com.chinayouthedu.zqzc.entity.vo.CourseTreeVo;
import com.chinayouthedu.zqzc.entity.vo.CourseVo;
import com.chinayouthedu.zqzc.mapper.paike.CourseMapper;
import com.chinayouthedu.zqzc.mapper.paike.DictionaryMapper;
import com.chinayouthedu.zqzc.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 课程管理
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2018年3月8日 下午2:53:51
 * @version 1.0
 */
@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseMapper dao;
	
	@Autowired
	private DictionaryMapper dict;

	/**
	 * 课程展示
	 */
	@Override
	public BaseResponse<Map<String,Object>> getCourseListByGrade(int pageNum, int pageSize,long gradeId) {
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		PageHelper.startPage(pageNum, pageSize);
		CourseExample courseExample = new CourseExample();
//		courseExample.setOrderByClause("");
		courseExample.createCriteria().andGradeIdEqualTo(gradeId);
		List<Course> course_list = dao.selectByExample(courseExample);
		PageInfo<Course> info = new PageInfo<Course>(course_list);
		map.put("pageInfo", info);
//		map.put("list", course_list);
		response.setData(map);
		return response;
	}

	/**
	 * 创建一个课程
	 */
	@Override
	public BaseResponse<Map<String, Object>> createCourse(CourseVo courseVo) {
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		if(courseVo.getGradeId() != null){//年级id
			//TODO 此处只做了学科防重,其他字段未做防重复处理
			CourseExample courseExample = new CourseExample();
			courseExample.createCriteria().andCourseDisciplineEqualTo(courseVo.getCourseDiscipline()).andGradeIdEqualTo(courseVo.getGradeId());
			List<Course> repeat = dao.selectByExample(courseExample);
			Dictionary selectByCode = dict.selectByCode(courseVo.getCourseDiscipline());
			if(repeat.size() > 0){
				if(selectByCode != null){
					WebUtils.Error(response, courseVo.getGradeName()+"的["+selectByCode.getName()+"]学科已存在!");
				}else{
					WebUtils.Error(response, courseVo.getGradeName()+"的["+courseVo.getCourseDiscipline()+"]学科已存在!");
				}
				return response;
			}
			Course course = new Course();
			BeanUtils.copyProperties(courseVo, course);
			course.setCreateTime(new Date());
			course.setDisciplineName(selectByCode.getName());
			int insert = dao.insert(course);
			if(insert > 0){
				WebUtils.Success(response, "保存成功!");
				return response;
			}
		}
		WebUtils.Error(response, "保存失败!");
		return response;
	}

	/**
	 * 编辑一个课程
	 */
	@Override
	public BaseResponse<Map<String, Object>> editCourse(CourseVo courseVo) {
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		if(courseVo.getId() != null){//年级id   && courseVo.getGradeId() != null
			//TODO 此处只做了学科防重,其他字段未做防重复处理 
			CourseExample courseExample = new CourseExample();
			courseExample.createCriteria().andCourseDisciplineEqualTo(courseVo.getCourseDiscipline()).andGradeIdEqualTo(courseVo.getGradeId());
			List<Course> repeat = dao.selectByExample(courseExample);
			Dictionary selectByCode = dict.selectByCode(courseVo.getCourseDiscipline());
			if(repeat.size() > 0){
				if(!(repeat.get(0).getCourseDiscipline().toString()).equals(courseVo.getCourseDiscipline().toString())){//如果编辑时学科改变
					if(selectByCode != null){
						WebUtils.Error(response, courseVo.getGradeName()+"的["+selectByCode.getName()+"]学科已存在!");
					}else{
						WebUtils.Error(response, courseVo.getGradeName()+"的["+courseVo.getCourseDiscipline()+"]学科已存在!");
					}
					return response;
				}
			}
			Course old_course = dao.selectByPrimaryKey(courseVo.getId());
			BeanUtils.copyProperties(courseVo, old_course);
			old_course.setCreateTime(old_course.getCreateTime());
			old_course.setUpdateTime(new Date());
			old_course.setDisciplineName(selectByCode.getName());
			int update = dao.updateByPrimaryKey(old_course);
			if(update > 0){
				WebUtils.Success(response, "编辑成功!");
				return response;
			}
		}
		WebUtils.Error(response, "编辑失败!");
		return response;
	}

	/**
	 * 删除一个课程
	 */
	@Override
	public BaseResponse<Map<String, Object>> delCourse(long id) {
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		if(id > 0){
			int del = dao.deleteByPrimaryKey(id);
			if(del > 0 ){
				WebUtils.Success(response, "删除成功!");
				return response;
			}
		}
		WebUtils.Error(response, "删除失败!");
		return response;
	}

	/**
	 * 年级课程管理
	 */
	@Override
	public BaseResponse<Map<String, List<Dictionary>>> CourseManage(long gradeId) {
		BaseResponse<Map<String, List<Dictionary>>> response = new BaseResponse<Map<String, List<Dictionary>>>();
		//根据年级获取该年级下的所有学科
		List<Dictionary> course_all = new ArrayList<Dictionary>();
		DictionaryExample DictionaryExample = new DictionaryExample();
		DictionaryExample.createCriteria().andTypeEqualTo("paike_course_type");//学科
		course_all = dict.selectByExample(DictionaryExample);//全部学科
		//根据年级获取该年级下分配过得所有科目
		CourseExample courseExample = new CourseExample();
		courseExample.createCriteria().andGradeIdEqualTo(gradeId);
		List<Course> course_list = dao.selectByExample(courseExample);
		//得到选过的学科和没选的
		List<Dictionary> course_exist = new ArrayList<Dictionary>();
		if(course_all.size() > 0){//所有的
			for (Dictionary string : course_all) {
				if(course_list.size() > 0){//分配过得
					for (Course exist : course_list) {
						if((string.getCode().trim().toString()).equals(exist.getCourseDiscipline().trim().toString())){
							course_exist.add(string);//选过的
						}
					}
				}
			}
		}
		List<Dictionary> course_noexist = CyeCollectionUtils.reduce(course_all, course_exist);
		Map<String, List<Dictionary>> map = new HashMap<String, List<Dictionary>>();
		map.put("noexist", course_noexist);
		map.put("exist", course_exist);
		response.setData(map);
		return response;
	}

	/**
	 * 年级课程批量保存
	 */
	@Override
	@Transactional("paikeTransactionManager")
	public BaseResponse<List<Course>> CourseManageSave(long gradeId,String[] codes){
		BaseResponse<List<Course>> response = new BaseResponse<List<Course>>();
		if(codes.length > 0){//分配了课程
			List<String> course_codes = Arrays.asList(codes);//选择的课程
			CourseExample courseExample = new CourseExample();
			courseExample.createCriteria().andGradeIdEqualTo(gradeId);
			List<Course> repeat = dao.selectByExample(courseExample);//目前存在的记录
			List<String> course_exist = new ArrayList<String>();
			if(repeat.size() > 0){
				for (Course course : repeat) {
					course_exist.add(course.getCourseDiscipline());
				}
			}
			List<String> add = CyeCollectionUtils.reduce(course_codes, course_exist);
			List<String> del = CyeCollectionUtils.reduce(course_exist, course_codes);
//			List<String> common = CyeCollectionUtils.common(course_codes, course_exist);
			int delete = 0;
			//删除
			if(del.size() > 0){
				CourseExample delcourseExample = new CourseExample();
				delcourseExample.createCriteria().andGradeIdEqualTo(gradeId).andCourseDisciplineIn(del);
				delete += dao.deleteByExample(delcourseExample);
			}
			//新增
			int insert = 0;
			if(add.size() > 0){
				for (String string : add) {
					Course course = new Course();
					course.setGradeId(gradeId);
					course.setCourseDiscipline(string);
					Dictionary selectByCode = dict.selectByCode(string);
					course.setDisciplineName(selectByCode.getName());
					course.setCreateTime(new Date());
					insert += dao.insert(course);
				}
			}
			if(insert == add.size() && delete == del.size()){
				WebUtils.Success(response, "保存成功!");
			}else{
				throw new WebException(404,"保存失败!");
			}
		}else{//清空课程
			CourseExample delcourseExample = new CourseExample();
			delcourseExample.createCriteria().andGradeIdEqualTo(gradeId);
			int delete = dao.deleteByExample(delcourseExample);
			if(delete > 0){
				WebUtils.Success(response, "保存成功!");
			}else{
				throw new WebException(404,"保存失败!");
			}
		}
		return response;
	}

	
	/**
	 * 获取课程树
	 */
	@Override
	public BaseResponse<List<CourseTreeVo>> getCourseTree() {
		BaseResponse<List<CourseTreeVo>> response = new BaseResponse<List<CourseTreeVo>>();
		List<Dictionary> disc_list = dao.selectExistDiscipline();//获取学科
		CourseExample courseExample = new CourseExample();
		List<Course> tree_list = dao.selectByExample(courseExample);
		//获取所有数据
		List<CourseTreeVo> vo_list = new ArrayList<CourseTreeVo>();
		//构建tree
		if(disc_list.size() > 0 && tree_list.size() > 0){
			for (Dictionary disc : disc_list) {
				CourseTreeVo courseTreeVO = new CourseTreeVo();
				courseTreeVO.setDisciplineName(disc.getName());
				courseTreeVO.setDisciplineCode(disc.getCode());
				List<Course> list = new ArrayList<Course>();
				for (Course course : tree_list) {
					if((disc.getCode().toString()).equals(course.getCourseDiscipline().toString())){
						list.add(course);
					}
				}
				courseTreeVO.setChildlist(list);
				vo_list.add(courseTreeVO);
			}
		}
		response.setData(vo_list);
		return response;
	}

	/**
	 * 获取年级下所有课程
	 */
	@Override
	public BaseResponse<List<Course>> getGradeCourseList(long gradeId) {
		BaseResponse<List<Course>> response = new BaseResponse<List<Course>>();
		Map<String,Object> map = new HashMap<String,Object>();
		CourseExample courseExample = new CourseExample();
		courseExample.createCriteria().andGradeIdEqualTo(gradeId);
		List<Course> course_list = dao.selectByExample(courseExample);
		response.setData(course_list);
		return response;
	}

}
