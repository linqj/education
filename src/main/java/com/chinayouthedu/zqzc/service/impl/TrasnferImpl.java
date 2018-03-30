package com.chinayouthedu.zqzc.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinayouthedu.zqzc.common.utils.cye.CyeConverter;
import com.chinayouthedu.zqzc.entity.paike.Cla;
import com.chinayouthedu.zqzc.entity.paike.Dictionary;
import com.chinayouthedu.zqzc.entity.paike.Student;
import com.chinayouthedu.zqzc.service.DictionaryService;
import com.chinayouthedu.zqzc.service.Transfer;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;


@Service
public class TrasnferImpl extends BaseServiceImpl implements Transfer {

	// 分隔符
	private static final String STRING_ARRAY_SEPARATOR = ",";
	// 性别的CODE
	private static final String CODE_GENDER = "paike_gender_type";
	// 学生类型(级别)的CODE
	private static final String CODE_STUDENT_TYPE = "paike_student_type";
	// 学生在班级的职务的CODE
	private static final String CODE_STUDENT_POSITION_IN_CLASS = "paike_class_position";
	// 班级类型
	private static final String CODE_CLASS_TYPE = "paike_class_type";
	
	
	@Autowired
	private DictionaryService dictionaryService;
	
	@Override
	public PageInfo<Student> transfer(PageInfo<Student> pageInfo) {
		
		Map<String, String> genderMap =  dictionaryService.selectMapByCode(CODE_GENDER );
		Map<String, String> studentTypeMap =  dictionaryService.selectMapByCode(CODE_STUDENT_TYPE );
		Map<String, String> studentCPositionMap =  dictionaryService.selectMapByCode(CODE_STUDENT_POSITION_IN_CLASS );
		
		List<Student> studentList = pageInfo.getList();
		
		if(studentList!=null){
			studentList.forEach(student->{


//				logger.info("studentCPositionMap:{}",new Gson().toJson(studentCPositionMap));

				// 处理性别
				handle2(student, "stuGender","stuGenderShow", genderMap);
				// 处理职务
				handle2(student, "stuClassPost", "stuClassPostShow", studentCPositionMap);
				// 处理级别
				handle2(student, "stuLevel","stuLevelShow", studentTypeMap);
			});
		}
		return pageInfo;
	}
	
	
	

	@Override
	public List<Cla> transfer(List<Cla> classList) {
		
		if(classList!=null&&classList.size()>0){
			classList.forEach(cla->{
				// 处理班级类型
				handle(cla, "classType", dictionaryService.selectMapByCode(CODE_CLASS_TYPE ));
			});
		}
		
		return classList;
	}
	
	
	
	private void handle(Object bean,String name,Map relationshipMap){
		try {
			if(bean!=null){
				String value = String.valueOf(PropertyUtils.getProperty(bean, name));
				List<String> list = CyeConverter.toList(value , STRING_ARRAY_SEPARATOR);
				StringBuilder sb = new StringBuilder();
				list.forEach(key->{
					sb.append(relationshipMap.get(key) )
						.append(STRING_ARRAY_SEPARATOR );
					
				});
				String string = sb.toString();
				if(string.endsWith(STRING_ARRAY_SEPARATOR)){
					string = string.substring(0, string.length()-1);
				}
				PropertyUtils.setProperty(bean, name, string.trim());
			}
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			// e.printStackTrace();
		}
	}

	/**
	 * 将对象bean中的property1属性的值通过relationshipMap进行映射之后，将映射的结果设置到属性property2上,值支持拼接
	 * @param bean 对象
	 * @param property1
	 * @param property2
	 * @param relationshipMap
	 * 目前只能处理字符串的参数
	 */
	private void handle2(Object bean,String property1,String property2,Map<String,String> relationshipMap){
		try {
			if(bean!=null){

				// 1.获取bean中指定property的value
				String value = String.valueOf(PropertyUtils.getProperty(bean, property1));

				// 2.将value切分成字符串集合
				List<String> list = CyeConverter.toList(value , STRING_ARRAY_SEPARATOR);

				// 3.检查切分后的结果是否为空
				if(list!=null&&list.size()>0){
					List<String> valueList = new ArrayList<>();
					list.forEach(str->{
						// 4.通过map的key找到value,加入集合valueList
						valueList.add(relationshipMap.get(str));
					});
					valueList.remove(null);		// 删除集合中所有的null

					// 5.将valueList与分隔符生成新的字符串
					String finalValue = CyeConverter.toString(valueList, STRING_ARRAY_SEPARATOR);

					// 6.将新的字符串设置到bean的目标property属性上
					if(finalValue!=null){
						PropertyUtils.setProperty(bean, property2, finalValue.trim());
					}
				}
			}
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			 e.printStackTrace();
		}
	}

}