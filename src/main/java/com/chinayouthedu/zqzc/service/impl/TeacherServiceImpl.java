package com.chinayouthedu.zqzc.service.impl;

import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.config.exception.WebException;
import com.chinayouthedu.zqzc.entity.paike.Cla;
import com.chinayouthedu.zqzc.entity.paike.Teacher;
import com.chinayouthedu.zqzc.entity.paike.TeacherExample;
import com.chinayouthedu.zqzc.entity.paike.TeacherGroup;
import com.chinayouthedu.zqzc.entity.vo.TeacherVo;
import com.chinayouthedu.zqzc.mapper.paike.TeacherGroupMapper;
import com.chinayouthedu.zqzc.mapper.paike.TeacherMapper;
import com.chinayouthedu.zqzc.service.ClassService;
import com.chinayouthedu.zqzc.service.LoginLinkageService;
import com.chinayouthedu.zqzc.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@SuppressWarnings("all")
public class TeacherServiceImpl extends BaseServiceImpl implements TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;					// 教师数据库Dao

	@Autowired
	private ClassService classService;						// 班级数据库Dao

	@Autowired
	private TeacherGroupMapper teacherGroupMapper;

	
	@Autowired
	private LoginLinkageService loginLinkageService;		// 同步创建或者销毁登录用户以及登录信息的Service

	/**
	 * 查询所有教师
	 */
	@Override
	public List<Teacher> selectAllTeacher() {

		TeacherExample example = new TeacherExample();
		List<Teacher> list = teacherMapper.selectByExample(example);
//		for (Teacher teacher : list) {
//			if (teacher.getTeacherGroupId() != null) {
//				teacher.setTeacherGroupName(teacherGroupMapper.selectByPrimaryKey(teacher.getTeacherGroupId()).getTgName());
//			}
//		}
		return list;

	}

	@Override
	public BaseResponse saveTeacher(Teacher teacher ) {

		if(teacher==null||teacher.getId()!=null){
			BaseResponse response = new BaseResponse();
			WebUtils.Error(response, "数据有误!");
			return response;
		}

		Long teacherGroupId = teacher.getTeacherGroupId();
		if(teacherGroupId!=null){
			TeacherGroup teacherGroup = teacherGroupMapper.selectByPrimaryKey(teacherGroupId);
			if(teacherGroup==null ){
				BaseResponse response = new BaseResponse();
				WebUtils.Error(response, "教研组不存在!");
				return response;
			}else{
				teacher.setTeacherGroupName(teacherGroup.getTgCourseName() );
			}
		}


		teacher.setUpdateTime(new Date() );
		teacher.setCreateTime(teacher.getUpdateTime() );
		teacher.setIsLeader(false);
		teacher.setIsLeaderTwo(false);

		boolean teacherInsertSuccess = teacherMapper.insert(teacher )>0 ;

		if(teacherInsertSuccess ){
    		boolean linageInsertSuccess = loginLinkageService.insertUserAndLoginWithTeacher(teacher );

				if(linageInsertSuccess ) {
					BaseResponse response = new BaseResponse();
					WebUtils.Success(response, "保存成功");
					return response;
				}else {
					throw new WebException(404,"插入用户表失败!");
				}
		}else{
			BaseResponse response = new BaseResponse();
			WebUtils.Error(response, "保存失败!");
			return response;
		}

	}

	@Override
	public BaseResponse deleteTeacherByPrimaryKey(Long teacherId) {

		BaseResponse response = new BaseResponse();

		Teacher teacherInDB = teacherMapper.selectByPrimaryKey(teacherId);
		if (teacherInDB!=null) {
			int deleteLines = teacherMapper.deleteByPrimaryKey(teacherId ) ;
			if (deleteLines>0) {
				boolean linkageDeleteSuccess = loginLinkageService.deleteUserAndLoginWithTeacher(teacherInDB.getTeacherNumber() );
				if(linkageDeleteSuccess ) {
					WebUtils.Success(response, "删除成功");
					return response;
				}else {
					throw new WebException(404,"联动删除教师登录用户失败!");
				}
			}
		}

		WebUtils.Error(response, "删除失败");
		return response;

	}

	@Override
	public BaseResponse updateTeacher(TeacherVo vo, Long tId) {

		Teacher teacher = teacherMapper.selectByPrimaryKey(tId);
		
		//  1.检查初始对象
		if(teacher==null||tId==null){
			BaseResponse response = new BaseResponse();
			WebUtils.Error(response, "数据有误!");
			return response;
		}

		// 2.检查ID字段
//		Teacher teacherInDB = teacherMapper.selectByPrimaryKey(teacher.getId() );
//		if(teacher==null ){
//			BaseResponse response = new BaseResponse();
//			WebUtils.Error(response, "要修改的教师数据不存在!");
//			return response;
//		}

		// 3.检查teacherGroupId字段
//		Long teacherGroupId = teacher.getTeacherGroupId();
		TeacherGroup teacherGroup = null;
		if(vo.getTeacherGroupId()!=null){
			teacherGroup = teacherGroupMapper.selectByPrimaryKey(vo.getTeacherGroupId());
			if(teacherGroup==null ){
				BaseResponse response = new BaseResponse();
				WebUtils.Error(response, "教研组不存在!");
				return response;
			}else{
				teacher.setTeacherGroupName(teacherGroup.getTgCourseName() );
			}
		}

		// 4.更新操作
		teacher.setTeacherName(vo.getTeacherName() );
		teacher.setTeacherGender(vo.getTeacherGender() );
		teacher.setTeacherLevel(vo.getTeacherLevel() );
		teacher.setTeacherGroupId(vo.getTeacherGroupId() );
//		teacher.setTeacherGroupName(vo.getTeacherGroupName() );
		teacher.setUpdateTime(new Date() );

		boolean teacherUpdateSuccess = teacherMapper.updateByPrimaryKeySelective(teacher)>0 ;

		// 5.检查更新是否成功
		if(teacherUpdateSuccess ){
			BaseResponse response = new BaseResponse();
			WebUtils.Success(response, "更新成功!");
			return response;
		}else{
			BaseResponse response = new BaseResponse();
			WebUtils.Error(response, "更新失败,未知错误!");
			return response;
		}


	}

	@Override
	public Teacher selectTeacherByPrimaryKey(Long teacherId) {
		return teacherMapper.selectByPrimaryKey(teacherId);
	}

	@Override
	public PageInfo<Teacher> selectTeacherPageInfo(Integer pageNum, Integer pageSize, String name) {

		PageHelper.startPage(pageNum, pageSize);

		TeacherExample example = new TeacherExample();

		if (StringUtils.isNotBlank(name)) {
			example.createCriteria().andTeacherNameLike("%" + name + "%");
		}

		List<Teacher> allteacherWithOutPage = teacherMapper.selectByExample(example);

		for (Teacher teacher : allteacherWithOutPage) {
			if (teacher.getTeacherGroupId() != null) {
				
				teacher.setTeacherGroupName(teacherGroupMapper.selectByPrimaryKey(teacher.getTeacherGroupId()).getTgName());
			}
		}
		
		PageInfo<Teacher> teacherPageInfo = new PageInfo<Teacher>(allteacherWithOutPage);

		return teacherPageInfo;

	}

	@Override
	public List<Teacher> selectTeacherListByTeacherGroupId(Long tgId) {
		TeacherExample example = new TeacherExample();
		example.createCriteria().andTeacherGroupIdEqualTo(tgId);
		return teacherMapper.selectByExample(example);
	}

	@Override
	@Transactional
	public BaseResponse batchDeleteTeacher(List<Long> idList) {

		if (idList != null && idList.size() > 0) {

			TeacherExample deleteExample = new TeacherExample();
			deleteExample.createCriteria().andIdIn(idList);
			int deleteLines = teacherMapper.deleteByExample(deleteExample);

			if (deleteLines == idList.size()) {
				BaseResponse response = new BaseResponse();
				WebUtils.Success(response, "删除成功");
				return response;
			} else {
				BaseResponse response = new BaseResponse();
				WebUtils.Error(response, "删除失败");
				return response;
			}
		}else{

			BaseResponse response = new BaseResponse();
			WebUtils.Success(response, "删除成功");
			return response;
		}
	}

	@Override
	public List<Long> selectAllHeadTeacherId() {

		List<Long> result = new ArrayList<Long>();
		List<Cla> allCla = classService.selectAllClasses();
		if (allCla != null && allCla.size() > 0) {
			for (Cla cla : allCla) {
				result.add(cla.getTeacher1Id());
			}
		}
		result.remove(null);
		return result;

	}

}