package com.chinayouthedu.zqzc.entity.vo;

import com.chinayouthedu.zqzc.common.utils.myexcel.ImportExcel;

import java.io.Serializable;

public class TeacherExcel implements Serializable {

//    @ImportExcel(rule = "[\u4e00-\u9fa5]{0,6}", ruleExplain = "最多输入6个汉字", column = "A")
//    private String stuName;//姓名



    /** @desc 姓名(可选项) (无默认值) */
    @ImportExcel(column = "A")
    private String teacherName;

    /** @desc 性别(可选项) (无默认值) */
    @ImportExcel(column = "B")
    private String teacherGender;

    /** @desc 教师编号(可选项) (无默认值) */
    @ImportExcel(column = "C")
    private String teacherNumber;

    /** @decs 教师级别(可选项) (无默认值) */
    @ImportExcel(column = "D")
    private String teacherLevel;

    /** @decs 教研组(可选项) (无默认值) */
    @ImportExcel(column = "E")
    private String teacherGroupName;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(String teacherGender) {
        this.teacherGender = teacherGender;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getTeacherLevel() {
        return teacherLevel;
    }

    public void setTeacherLevel(String teacherLevel) {
        this.teacherLevel = teacherLevel;
    }

    public String getTeacherGroupName() {
        return teacherGroupName;
    }

    public void setTeacherGroupName(String teacherGroupName) {
        this.teacherGroupName = teacherGroupName;
    }
}