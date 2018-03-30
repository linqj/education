package com.chinayouthedu.zqzc.entity.vo;

import java.io.Serializable;
import java.util.List;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import com.chinayouthedu.zqzc.entity.paike.Course;

/**
 * 课程树
 * @author 张超群
 * @time   2018年3月19日下午4:40:45
 */
public class CourseTreeVo extends BaseBean implements Serializable {
    
    /** @desc 伪字段,构建课程树  */
    private List<Course> childlist;
    
    /** @desc 学科名 ,构建课程树 */
    private String disciplineName;

    /** @desc 学科编码,构建课程树 */
    private String disciplineCode;
    
    private static final long serialVersionUID = 1L;


	public List<Course> getChildlist() {
		return childlist;
	}

	public void setChildlist(List<Course> childlist) {
		this.childlist = childlist;
	}

	public String getDisciplineName() {
		return disciplineName;
	}

	public void setDisciplineName(String disciplineName) {
		this.disciplineName = disciplineName;
	}

	public String getDisciplineCode() {
		return disciplineCode;
	}

	public void setDisciplineCode(String disciplineCode) {
		this.disciplineCode = disciplineCode;
	}
    
}