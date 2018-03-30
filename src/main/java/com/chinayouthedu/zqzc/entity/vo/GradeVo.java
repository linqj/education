package com.chinayouthedu.zqzc.entity.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.chinayouthedu.zqzc.entity.paike.Cla;
import com.chinayouthedu.zqzc.entity.paike.Grade;

public class GradeVo implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Grade grade;
	private List<Cla> classList;
	
	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public List<Cla> getClassList() {
		return classList==null?new ArrayList<Cla>():classList;
	}

	public void setClassList(List<Cla> classList) {
		this.classList = classList;
	}

	public GradeVo(Grade grade) {
		super();
		this.grade = grade;
		this.classList = new ArrayList<Cla>();
	}
	
	public GradeVo() {
		super();
		this.classList = new ArrayList<Cla>();
	}
	
}