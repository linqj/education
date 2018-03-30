package com.chinayouthedu.zqzc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.chinayouthedu.zqzc.common.utils.SimpleResponseUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.config.exception.WebException;
import com.chinayouthedu.zqzc.entity.paike.Cla;
import com.chinayouthedu.zqzc.entity.paike.Grade;
import com.chinayouthedu.zqzc.entity.paike.Student;
import com.chinayouthedu.zqzc.entity.paike.StudentExample;
import com.chinayouthedu.zqzc.entity.paike.StudentExample.Criteria;
import com.chinayouthedu.zqzc.mapper.paike.StudentMapper;
import com.chinayouthedu.zqzc.service.ClassService;
import com.chinayouthedu.zqzc.service.GradeService;
import com.chinayouthedu.zqzc.service.LoginLinkageService;
import com.chinayouthedu.zqzc.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
class StudentServiceceImpl extends BaseServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;		// 学生dao
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private LoginLinkageService loginLinkageService;

	@Transactional
	@Override
	public BaseResponse<Map<String, Object>> saveStudent(Student student) throws WebException{
		
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		
		if(student!=null&&student.getId()==null){
			Date date = new Date();
			student.setCreateTime(date);
			student.setUpdateTime(date);
			student.setEffective(true);

			if(student.getClassId()==null ){
			    return SimpleResponseUtils.error("你没有选择班级!");
            }
            Cla cla = classService.selectClassByPrimaryKey(student.getClassId());
            if(cla==null){
                return SimpleResponseUtils.error("所选班级不存在!");
            }
            student.setClassName(cla.getClaName() );
            student.setGradeName(cla.getClassGradeName() );
            student.setGradeId(cla.getClassGradeId() );
            boolean insertSuccess = studentMapper.insert(student)>0;
			if(insertSuccess ){
				return SimpleResponseUtils.success("保存成功!");
			}else{
			    return SimpleResponseUtils.error("保存失败,请联系管理员!");
            }
		}else{
		    return SimpleResponseUtils.error("数据为空或者有误!");
        }
		
		
	}

	@Override
	public Student selectByPrimaryKey(Long studentId) {
		Student student = studentMapper.selectByPrimaryKey(studentId );
		return student.getEffective()?student:null;
	}

	@Override
	public BaseResponse updateStudent(Student student) {
		
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		
		if(student==null||student.getId()==null){
			WebUtils.Error(response, "数据有误,更新失败!");
			return response;
		}
		
		
		Student studentInDB = studentMapper.selectByPrimaryKey(student.getId());
		if(studentInDB==null||studentInDB.getEffective()==false){
			WebUtils.Error(response, "找不到需要更新的学生信息,修改失败!");
			return response;
		}
		
		
		if(StringUtils.isNotBlank(student.getStuName() )){
			studentInDB.setStuName(student.getStuName() );
		}
		if(StringUtils.isNotBlank(student.getStuLevel() )){
			studentInDB.setStuLevel(student.getStuLevel() );
		}
		if(StringUtils.isNotBlank(student.getStuEmail() )){
			studentInDB.setStuEmail(student.getStuEmail() );
		}
		if(StringUtils.isNotBlank(student.getStuIdcard() )){
			studentInDB.setStuIdcard(student.getStuIdcard() );
		}
		if(StringUtils.isNotBlank(student.getStuNumber() )){
			studentInDB.setStuNumber(student.getStuNumber() );
		}
        if(StringUtils.isNotBlank(student.getStuGender() )){
            studentInDB.setStuGender(student.getStuGender() );
        }
		if(StringUtils.isNotBlank(student.getStuClassPost() )){
			studentInDB.setStuClassPost(student.getStuClassPost() );
		}
		
		
		
		if(!Objects.equals(studentInDB.getClassId(), student.getClassId() )){
			
			Cla classInDB = classService.selectClassByPrimaryKey(student.getClassId() );
			if(classInDB==null||classInDB.getEffictive()==false ){
				WebUtils.Error(response, "选择的班级不存在,请重试!");
				return response;
			}else{
				studentInDB.setClassId(classInDB.getId() );
				studentInDB.setClassName(classInDB.getClaName() );
				studentInDB.setGradeId(classInDB.getClassGradeId() );
				studentInDB.setGradeName(classInDB.getClassGradeName() );
			}
			
			
		}
		
		studentInDB.setUpdateTime(new Date());
		studentInDB.setEffective(true);
		boolean updateSuccess = studentMapper.updateByPrimaryKey(studentInDB )>0;
		if(updateSuccess ){
			WebUtils.Success(response, "学生信息更新成功!");
			return response;
		}else{
			WebUtils.Error(response, "学生信息更新失败!");
			return response;
		}
	}

	@Override
	public PageInfo<Student> pageList(Integer pageNum, Integer pageSize,Long gradeId,Long claId,String name) {
		
		// 1.开始分页
		PageHelper.startPage(pageNum,pageSize);
		
		// 2.组合查询条件
		StudentExample studentPageSelectExample = new StudentExample();
		Criteria studentPageSelectCriteria = studentPageSelectExample.createCriteria();
		studentPageSelectCriteria.andEffectiveEqualTo(true);
		
		// 处理查询范围:年级/班级
		if(claId!=null){
			studentPageSelectCriteria.andClassIdEqualTo(claId);
		}else if(gradeId!=null){
			studentPageSelectCriteria.andGradeIdEqualTo(gradeId);
		}
		
		// 处理名称
		if(StringUtils.isNotBlank(name )){
			studentPageSelectCriteria.andStuNameLike("%"+name+"%");
		}
		
		List<Student> allStudent = studentMapper.selectByExample(studentPageSelectExample );
		
		// 3.添加分页数据并且进行分页查询
		PageInfo<Student> studentPageInfo = new PageInfo<Student>(allStudent);
		
		// 4.返回分页数据
		return studentPageInfo;
		
	}

	@Transactional
	@Override
	public BaseResponse deleteStudent(Long studentId) {
		
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		Student stuInDB = studentMapper.selectByPrimaryKey(studentId);
		if(stuInDB==null||stuInDB.getEffective()==false){
			BaseResponse<Map<String,Object>> badResponse = response;
			WebUtils.Error(badResponse, "无此学生,删除无效!");
			return badResponse;
		}
		
		stuInDB.setEffective(false);
		stuInDB.setUpdateTime(new Date());
		int updateEffectedLines = studentMapper.updateByPrimaryKey(stuInDB);
		if(updateEffectedLines>0){
			
			loginLinkageService.deleteUserAndLoginWithStudent(stuInDB.getStuNumber() );
			
			WebUtils.Success(response, "删除成功!");
			return response;
		}
		WebUtils.Error(response, "删除失败！");
		return response;
		
	}

	@Override
	public List<Student> selectStudentsByClassId(Long classId) {
		
		Cla classInDB = classService.selectClassByPrimaryKey(classId);
		
		if(classInDB==null||classInDB.getEffictive()==false){
			return new ArrayList<Student>();
		}
		
		StudentExample example = new StudentExample();
		example.createCriteria()
				.andClassIdEqualTo(classId );
		
		return studentMapper.selectByExample(example );
		
	}
	
	@Override
	public List<Student> selectStudentsBygradeId(Long gradeId) {
		
		Grade gradeInDB = gradeService.selectByPrimaryKey(gradeId );
		
		if(gradeInDB==null||gradeInDB.getEffective()==false){
			return new ArrayList<Student>();
		}
		
		StudentExample example = new StudentExample();
		example.createCriteria()
				.andGradeIdEqualTo(gradeId );
		
		return studentMapper.selectByExample(example );
		
	}

	@Override
	public BaseResponse batchDeleteStudents(List<Long> idList) {
		for (Long id : idList) {
			deleteStudent(id);
		}		
		BaseResponse response = new BaseResponse();
		WebUtils.Success(response, "删除成功！");
		return response;
	}

	@Override
	public BaseResponse adjustToNewClass(List<Long> studentIds,Long classId ){

		// 1.检查学生ID的有效性
		if(studentIds==null){
			return SimpleResponseUtils.error("您未选择学生，请重试");
		}
		studentIds.remove(null);
		if(studentIds.size()==0){
			return SimpleResponseUtils.error("您未选择学生，请重试");
		}

		// 2.检查班级ID的有效性
		Cla cla = classService.selectClassByPrimaryKey(classId );
		if(cla==null){
			return SimpleResponseUtils.error("班级找不到!");
		}

		// 3.从数据库中查出来所有的学生对象
		StudentExample example = new StudentExample();
		example.createCriteria().andEffectiveEqualTo(true).andIdIn(studentIds) ;
        List<Student> students = studentMapper.selectByExample(example);
        if(students==null){
            return SimpleResponseUtils.error("数据库错误,查询不到学生!");
        }
        students.remove(null );
        if(students.size()==0 ){
            return SimpleResponseUtils.error("查询不到学生,请重试!");
        }

        // 4.将数据库数据更新
        int updateSuccessLines = 0;
        Date updateTime = new Date();

//        // 封装的是约束规则,即满足约束规则的才进行update操作
//        StudentExample updateConstraintRule = new StudentExample();
//        updateConstraintRule.createCriteria()
//                .andClassIdEqualTo(cla.getId() )
//                .andClassNameEqualTo(cla.getClaName())
//                .andUpdateTimeEqualTo(updateTime )
//                .andGradeIdEqualTo(cla.getClassGradeId())
//                .andGradeNameEqualTo(cla.getClassGradeName());
        for (Student student : students ) {
            student.setUpdateTime(updateTime );
            student.setClassId(cla.getId() );
            student.setClassName(cla.getClaName() );
            student.setGradeId(cla.getClassGradeId() );
            student.setGradeName(cla.getClassGradeName() );
            updateSuccessLines += studentMapper.updateByPrimaryKeySelective(student );
        }

        // 5.检查更新结果并返回数据
        int formSize = studentIds.size();
        int dbSize = students.size();
        logger.info("获取学生ID个数:{},查询到数据条数:{},更新成功条数:{}",formSize,dbSize,updateSuccessLines);

        if(formSize==updateSuccessLines){
            return SimpleResponseUtils.success("更新成功!");
        }else{
            return SimpleResponseUtils.error("获取学生ID个数:"+formSize+",查询到数据条数:"+dbSize+",更新成功条数:"+updateSuccessLines+"");
        }

	}

	
	
//
//  backup
//  new : user delete one to apply linkage with table operation ligin and user
//	@Override
//	public BaseResponse batchDeleteStudents(List<Long> idList) {
//		
//		int deleteSuccessNumbers = 0;
//		Date deleteTime = new Date();
//		
//		// 处理null
//		if(idList!=null){
//			for (int i=0;i<idList.size();i++) {
//				if(idList.get(i)==null){
//					idList.remove(i);
//				}
//			}
//		}
//		
//		// 查询对象
//		if(idList!=null&&idList.size()>0){
//			StudentExample stuDeleteExample = new StudentExample();
//			stuDeleteExample.createCriteria()
//			.andEffectiveEqualTo(true)
//			.andIdIn(idList );
//			
//			
//			List<Student> needDeleteStudents = studentMapper.selectByExample(stuDeleteExample );
//			
//			// 更新对象
//			if(needDeleteStudents!=null&&needDeleteStudents.size()>0){
//				for (Student stu : needDeleteStudents) {
//					if(stu!=null){
//						stu.setEffective(false);
//						stu.setUpdateTime(deleteTime );
//						deleteSuccessNumbers += studentMapper.updateByPrimaryKey(stu );
//					}
//				}
//			}
//		}
//		
//		// 返回结果
//		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
//		if(deleteSuccessNumbers==idList.size()){
//			WebUtils.Success(response, "删除成功！共删除"+deleteSuccessNumbers+"条!");
//			return response;
//		}else{
//			WebUtils.Error(response, "删除失败！共删除"+deleteSuccessNumbers+"条!");
//			return response;
//		}
//		
//		
//	}


}
