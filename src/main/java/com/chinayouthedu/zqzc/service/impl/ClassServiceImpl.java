package com.chinayouthedu.zqzc.service.impl;

import com.chinayouthedu.zqzc.common.utils.SimpleResponseUtils;
import com.chinayouthedu.zqzc.service.ClassService;
import com.chinayouthedu.zqzc.service.ClassroomBuildingService;
import com.chinayouthedu.zqzc.service.ClassroomService;
import com.chinayouthedu.zqzc.service.GradeService;
import com.chinayouthedu.zqzc.service.TeacherService;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Cla;
import com.chinayouthedu.zqzc.entity.paike.ClaExample;
import com.chinayouthedu.zqzc.entity.paike.Classroom;
import com.chinayouthedu.zqzc.entity.paike.Grade;
import com.chinayouthedu.zqzc.entity.paike.Teacher;
import com.chinayouthedu.zqzc.mapper.paike.ClaMapper;
import com.chinayouthedu.zqzc.mapper.paike.GradeMapper;
import com.chinayouthedu.zqzc.mapper.paike.StudentClassMapper;

@SuppressWarnings(value = "all")
@Service
public class ClassServiceImpl extends BaseServiceImpl implements ClassService {

	@Autowired
	private ClaMapper classMapper;
	@Autowired
	private GradeMapper gradeMapper;
	@Autowired
	private GradeService gradeService;
	@Autowired
	private ClassroomBuildingService classRoomBuildingService;
	@Autowired
	private ClassroomService classroomService;
	@Autowired
	private TeacherService teacherService;
	
	

	@Autowired
	private StudentClassMapper scMapper;

	public List<Cla> getClassesByIds(List<Long> ids) {
		if (ids == null && ids.size() == 0) {
			return null;
		}
		ClaExample example = new ClaExample();
		example.createCriteria().andIdIn(ids);
		List<Cla> classList = classMapper.selectByExample(example);
		Collections.sort(classList, comparator);
		return classList;
	}

	/**
	 * 班级对象排序规则
	 * 
	 * @return
	 */
	private static Comparator comparator = new Comparator<Cla>() {
		@Override
		public int compare(Cla c1, Cla c2) {
			// 有效>无效
			if (c1.getEffictive() && !c2.getEffictive()) {
				return 1;
			}
			// 先创建>后创建
			if (c1.getCreateTime().before(c1.getCreateTime())) {
				return 1;
			}
			return -1;
		}
	};


	@Override
	public Cla selectClassByPrimaryKey(Long classId) {
		Cla cla = classMapper.selectByPrimaryKey(classId);
		return cla.getEffictive() == true ? cla : null;
	}

	@Override
	public BaseResponse saveClass(Cla cla) {

		// 检查对象
		if(cla==null||cla.getId()!=null){
			return SimpleResponseUtils.error( "您的数据有误,请重试！");
		}

		// 检查年级
		if(cla.getClassGradeId()==null){
			return SimpleResponseUtils.error("您没有选择年级,请重试！");
		}
		
		// 处理年级
		if(cla.getClassGradeId()!=null ){
			Grade grade = gradeMapper.selectByPrimaryKey(cla.getClassGradeId());
			if(grade!=null ){
				cla.setClassGradeId(grade.getId() );
				cla.setClassGradeName(grade.getGradeName() );
			}else{
				return SimpleResponseUtils.error("您选择的年级无效,请重试！");
			}
		}
		
		// 处理教室
		if(cla.getKeyClassroomId()!=null){
			Classroom classroom = classroomService.selectByPrimaryKey(cla.getKeyClassroomId() );
			if(classroom!=null){
				cla.setKeyClassroomId(classroom.getId() );
				cla.setKeyClassroomName(classroom.getRoomName() );
				cla.setKeyClassroomBuldingId(classroom.getRoomBuildingId() );
				cla.setKeyClassroomBuldingName(classroom.getRoomBuildingName() );
			}else{
				return SimpleResponseUtils.error("您选择的主教室无效,请重试！");
			}
		}
		
		if(cla.getTeacher1Id()!=null ){
			// 处理班主任
			Teacher teacher1 = teacherService.selectTeacherByPrimaryKey(cla.getTeacher1Id() );
			if(teacher1!=null){
				cla.setTeacher1Id(teacher1.getId() );
				cla.setTeacher1Name(teacher1.getTeacherName() );
			}else{
				return SimpleResponseUtils.error( "您选择的班主任无效,请重试！");
			}
		}

//		暂不处理
//		if(cla.getTeacher2Id()!=null){
//			// 处理副班主任
//			Teacher teacher2 = teacherService.selectTeacherByPrimaryKey(cla.getTeacher2Id() );
//			if(teacher2!=null){
//				cla.setTeacher2Id(teacher2.getId() );
//				cla.setTeacher2Name(teacher2.getTeacherName() );
//			}else{
//				return SimpleResponseUtils.error("您选择的副班主任无效,请重试！");
//			}
//		}
		
		
		// 处理通用
		Date createTime = new Date();
		cla.setCreateTime(createTime );
		cla.setUpdateTime(createTime );
		cla.setEffictive(true );

		// 是否插入成功
		boolean insertSuccess = classMapper.insert(cla) > 0;

		if (insertSuccess) {
			return SimpleResponseUtils.success("添加班级成功！");
		} else {
			return SimpleResponseUtils.error( "添加班级失败,请联系管理员！");
		}

	}

	@Transactional
	@Override
	public BaseResponse updateClass(Cla cla) {

		Cla claInDB = null;
		BaseResponse response = new BaseResponse();

		// 1.检查有效性
		boolean objEffective = (cla != null && cla.getId() != null
				&& (claInDB = classMapper.selectByPrimaryKey(cla.getId())) != null && claInDB.getEffictive());
		if (!objEffective) {
			return SimpleResponseUtils.error("数据有误,不能更新班级！");
		}
		
		
		// 处理年级
		if(cla.getClassGradeId()!=null){
			Long gradeId = cla.getClassGradeId();
			Grade grade = gradeService.selectByPrimaryKey(gradeId);
			if(grade!=null&&grade.getEffective()==true){
				claInDB.setClassGradeId(gradeId);
				claInDB.setClassGradeName(grade.getGradeName());
			}else{
				return SimpleResponseUtils.error( "您选择的年级不存在,更新失败！");
			}
		}

		// 处理班主任,如果不相同的话,修改
		if(cla.getTeacher1Id()!=null){
			Teacher teacher = teacherService.selectTeacherByPrimaryKey(cla.getTeacher1Id() );
			if(teacher!=null){
				claInDB.setTeacher1Id(teacher.getId() );
				claInDB.setTeacher1Name(teacher.getTeacherName() );
			}else{
				return SimpleResponseUtils.error("班主任不存在,更新失败！");
			}
			
		}
//		// 处理副班主任
//		if(cla.getTeacher2Id()!=null){
//			Teacher teacher = teacherService.selectTeacherByPrimaryKey(cla.getTeacher2Id() );
//			if(teacher!=null ){
//				claInDB.setTeacher2Id(teacher.getId() );
//				claInDB.setTeacher2Name(teacher.getTeacherName() );
//			}else{
//				return SimpleResponseUtils.error( "副班主任不存在,更新失败！");
//				return response;
//			}
//		}
		
		// 处理教室
		if(cla.getKeyClassroomId()!=null ){
			Classroom classroom = classroomService.selectByPrimaryKey(cla.getKeyClassroomId());
			if(classroom!=null){
				claInDB.setKeyClassroomId(classroom.getId() );
				claInDB.setKeyClassroomName(classroom.getRoomName() );
				claInDB.setKeyClassroomBuldingId(classroom.getRoomBuildingId() );
				claInDB.setKeyClassroomBuldingName(classroom.getRoomBuildingName() );
			}else{
				return SimpleResponseUtils.error( "教室不存在,更新失败！");
			}
		}
		
		
		// 处理班级名称
		if(StringUtils.isNotBlank(cla.getClaName())){
			claInDB.setClaName(cla.getClaName());
		}
		
		// 处理班级编号
		if(StringUtils.isNotBlank(cla.getClassCode())){
			claInDB.setClassCode(cla.getClassCode());
		}
		
		// 处理班级类型
		if(StringUtils.isNotBlank(cla.getClassType())){
			claInDB.setClassType(cla.getClassType());
		}

		/*
		 * 处理年级学期
		 * 2018-3-30
		 */
		if(cla.getSchoolYearId()!=null){
			claInDB.setSchoolYearId(cla.getSchoolYearId());
		}
		if(cla.getSemesterId()!=null){
			claInDB.setSemesterId(cla.getSemesterId());
		}

		// 处理通用
		claInDB.setEffictive(true);
		claInDB.setUpdateTime(new Date());
		
		boolean upateSuccess = classMapper.updateByPrimaryKey(claInDB) > 0;

		if (upateSuccess) {
			return SimpleResponseUtils.success( "更新班级成功");
		} else {
			return SimpleResponseUtils.error( "更新班级失败");
		}

	}

	@Override
	public BaseResponse deleteClass(Long claId) {

		BaseResponse response = new BaseResponse();
		Cla claInDB = classMapper.selectByPrimaryKey(claId);
		boolean objEffective = (claInDB != null && claInDB.getEffictive() == true);

		if (objEffective) {
			claInDB.setEffictive(false);
			claInDB.setUpdateTime(new Date());
			boolean updateSuccess = classMapper.updateByPrimaryKey(claInDB) > 0;
			if (updateSuccess) {
				WebUtils.Success(response, "班级删除成功!");
				return response;
			}
		}
		return SimpleResponseUtils.error( "班级删除失败!");
	}

	@Override
	public List<Cla> selectAllClasses() {

		ClaExample example = new ClaExample();
		example.createCriteria().andEffictiveEqualTo(true);
		return classMapper.selectByExample(example);

	}

	@Override
	public List<Cla> selectAllClassesByGradeId(Long gradeId) {
		Grade gradeInDB = null;

		boolean objEffective = (
				gradeId != null
				&& (gradeInDB = gradeService.selectByPrimaryKey(gradeId)) != null
				&& gradeInDB.getEffective() == true);

		if (objEffective) {
			ClaExample example = new ClaExample();
			example.createCriteria().andEffictiveEqualTo(true).andClassGradeIdEqualTo(gradeId);

			return classMapper.selectByExample(example);
		}

		return null;
	}

	@Override
	public BaseResponse appointHeadteacher(Long classId, Long teacherId) {
		
		/*
		 * A.检查数据是否有误
		 */
		if(classId==null||teacherId==null) {
			return SimpleResponseUtils.error( "数据有误!");
		}
		
		Cla claInDB = selectClassByPrimaryKey(classId);
		if(claInDB==null||claInDB.getEffictive()==false) {
			return SimpleResponseUtils.error( "班级不存在!");
		}
		
		Teacher teacherInDB = teacherService.selectTeacherByPrimaryKey(teacherId );
		if(teacherInDB==null ) {
			return SimpleResponseUtils.error( "该教师不存在!");
		}
		
		/*
		 * B.更新数据库
		 */
		claInDB.setTeacher1Id(teacherId );
		claInDB.setTeacher1Name(teacherInDB.getTeacherName() );
		boolean updateSuccess = classMapper.updateByPrimaryKey(claInDB )>0;
		
		/*
		 * C.根据更新是否成功返回不同的提示
		 */
		if(updateSuccess ) {
			return SimpleResponseUtils.success( "修改成功!");
		}else {
			return SimpleResponseUtils.success( "修改失败!");
		}
		
	}

}