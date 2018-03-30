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
import com.chinayouthedu.zqzc.mapper.paike.ClaMapper;
import com.chinayouthedu.zqzc.mapper.paike.GradeMapper;
import com.google.common.base.Objects;

/**
 * 用于实现年级表中有数据更新时,根据更新结果执行其它与之相关联的操作
 * @author wangzq
 *
 */
@Component
@Aspect
@ComponentScan
public class GradeLinkage2 {

	private static Logger logger = LoggerFactory.getLogger(GradeLinkage2.class );

	@Autowired
	private GradeMapper gradeMapper;
	@Autowired
	private ClaMapper claMapper;
	
	
	@Around("execution( * com.chinayouthedu.zqzc.mapper.paike.GradeMapper.update*(..)) && args(record )")    
	public Object introcepter(ProceedingJoinPoint joinPoint,Grade record) throws Throwable {
		
		
		if(record!=null&&record.getId()!=null) {
			
			String gradeName1 = null;
			String gradeName2 = null;
			
			// 更新之前
			Grade grade1 = gradeMapper.selectByPrimaryKey(record.getId() );
			if(grade1!=null) {
				gradeName1 = grade1.getGradeName();
			}
			
			// 放行操作,并拦截返回结果
			Object proceed = joinPoint.proceed();
			
			// 更新之后
			Grade grade2 = gradeMapper.selectByPrimaryKey(record.getId() );
			if(grade2!=null) {
				gradeName2 = grade2.getGradeName();
			}
			
			// 处理空字符为统一的格式,防止null、""、" "对结果产生混淆
			gradeName1 = StringUtils.isBlank(gradeName1)?null:gradeName1.trim();
			gradeName2 = StringUtils.isBlank(gradeName2)?null:gradeName2.trim();
			
			if(!Objects.equal(gradeName1, gradeName2)) {
				
				logger.info("更新前,ID={}的Grade数据,数据库中的的gradeName=\"{}\",更新后的gradeName=\"{}\",发生了变化,需要同步更新班级中的冗余部分!",grade1.getId(),gradeName1,gradeName2);
				
				ClaExample example = new ClaExample();
				example.createCriteria().andClassGradeIdEqualTo(grade1.getId() );
				List<Cla> allClass = claMapper.selectByExample(example );
				
				int allClassNum = 0;
				int updateSuccessClassNum = 0;
				if(allClass!=null&&allClass.size()>0){
					for (Cla cla : allClass) {
						if(cla!=null){
							allClassNum++;
							cla.setClassGradeName(gradeName2 );
							updateSuccessClassNum += claMapper.updateByPrimaryKey(cla );
						}
					}
				}
				if(allClassNum>0){
					logger.info("班级中gradeId={}的班级数量有{}个,更新了{}个,{}!",grade1.getId(),allClassNum,updateSuccessClassNum,allClassNum==updateSuccessClassNum?"全部同步更新完成":"未全部同步更新完成");
				}else{
					logger.info("班级中无gradeId={}的班级,无需更新！");
				}
				
			}
			
			// 放行,返回结果
			return proceed;
			
		}else {
			
			return joinPoint.proceed();
		
		}
		
		
	}   
}