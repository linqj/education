package com.chinayouthedu.zqzc.config.aop;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.chinayouthedu.zqzc.entity.paike.Cla;
import com.chinayouthedu.zqzc.entity.paike.ClaExample;
import com.chinayouthedu.zqzc.entity.paike.Grade;
import com.chinayouthedu.zqzc.entity.paike.Student;
import com.chinayouthedu.zqzc.entity.paike.StudentExample;
import com.chinayouthedu.zqzc.mapper.paike.ClaMapper;
import com.chinayouthedu.zqzc.mapper.paike.GradeMapper;
import com.chinayouthedu.zqzc.mapper.paike.StudentMapper;
import com.google.common.base.Objects;

/**
 * 用于实现班级表中有数据更新时,根据更新结果执行其它与之相关联的操作
 * @author wangzq
 *
 */
@Component
@Aspect
@ComponentScan
public class ClassLinkage2 {

	private static Logger logger = LoggerFactory.getLogger(ClassLinkage2.class );

	@Autowired
	private ClaMapper claMapper;
	@Autowired
	private StudentMapper studentMapper;
	
	
	@Around("execution( * com.chinayouthedu.zqzc.mapper.paike.ClaMapper.update*(..)) && args(record )")    
	public Object introcepter(ProceedingJoinPoint joinPoint,Cla record) throws Throwable {
		
		
		if(record!=null&&record.getId()!=null) {
			
			String gradeName1 = null;
			String gradeName2 = null;
			String claName1 = null;
			String claName2 = null;
			
			// 更新之前,记录数据库中原本的数据中需要同步更新的数据
			Cla cla1 = claMapper.selectByPrimaryKey(record.getId() );
			if(cla1!=null) {
				gradeName1 = cla1.getClassGradeName();
				claName1 = cla1.getClaName();
			}
			
			// 放行操作,并拦截返回结果
			Object proceed = joinPoint.proceed();
			
			// 更新之后
			Cla cla2 = claMapper.selectByPrimaryKey(record.getId() );
			if(cla2!=null) {
				gradeName2 = cla2.getClassGradeName();
				claName2 = cla2.getClaName();
			}
			
			// 处理空字符为统一的格式,防止null、""、" "对结果产生混淆
			gradeName1 = StringUtils.isBlank(gradeName1)?null:gradeName1.trim();
			gradeName2 = StringUtils.isBlank(gradeName2)?null:gradeName2.trim();
			claName1 = StringUtils.isBlank(claName1)?null:claName1.trim();
			claName2 = StringUtils.isBlank(claName2)?null:claName2.trim();
			
			if(!Objects.equal(gradeName1, gradeName2)||!Objects.equal(claName1, claName2)) {
				
				logger.info("更新前,ID={}的班级(Cla)数据,数据库中claName/gradeName发生了变化,需要同步更新学生中的冗余部分!",cla1.getId() );
				
				StudentExample example = new StudentExample();
				example.createCriteria().andClassIdEqualTo(cla1.getId() );
				List<Student> studentList = studentMapper.selectByExample(example );
				
				int allStudentNum = 0;
				int updateSuccessStudentNum = 0;
				if(studentList!=null&&studentList.size()>0){
					for (Student student : studentList) {
						if(student!=null){
							allStudentNum++;
							student.setClassName(claName2 );
							student.setGradeName(gradeName2 );
							updateSuccessStudentNum += studentMapper.updateByPrimaryKey(student );
						}
					}
				}
				if(allStudentNum>0 ){
					logger.info("学生表student中classId={}的学生数量有{}个,更新了{}个,{}!",cla1.getId(),allStudentNum,updateSuccessStudentNum,allStudentNum==updateSuccessStudentNum?"全部同步更新完成":"未全部同步更新完成");
				}else{
					logger.info("学生表student中无classId={}的学生,无需更新！");
				}
				
			}
			
			// 放行,返回结果
			return proceed;
			
		}else {
			
			return joinPoint.proceed();
		
		}
		
		
	}   
}