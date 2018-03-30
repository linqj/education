package com.chinayouthedu.zqzc.entity.vo;

import com.chinayouthedu.zqzc.common.utils.myexcel.ImportExcel;

import java.io.Serializable;

public class StudentExcel implements Serializable {

    @ImportExcel(rule="[\u4e00-\u9fa5]{0,6}",ruleExplain="最多输入6个汉字", column = "A")
    private String stuName;//姓名

    @ImportExcel(column = "B")
    private String stuGender;//性别

    @ImportExcel(column = "C")
    private String stuNumber;//学号

    @ImportExcel(column = "D")
    private String stuLevel;//学生级别

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getStuLevel() {
        return stuLevel;
    }

    public void setStuLevel(String stuLevel) {
        this.stuLevel = stuLevel;
    }
}
