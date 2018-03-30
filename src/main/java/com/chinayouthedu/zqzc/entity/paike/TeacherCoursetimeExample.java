package com.chinayouthedu.zqzc.entity.paike;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherCoursetimeExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public TeacherCoursetimeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIdIsNull() {
            addCriterion("school_year_id is null");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIdIsNotNull() {
            addCriterion("school_year_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIdEqualTo(Long value) {
            addCriterion("school_year_id =", value, "schoolYearId");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIdNotEqualTo(Long value) {
            addCriterion("school_year_id <>", value, "schoolYearId");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIdGreaterThan(Long value) {
            addCriterion("school_year_id >", value, "schoolYearId");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIdGreaterThanOrEqualTo(Long value) {
            addCriterion("school_year_id >=", value, "schoolYearId");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIdLessThan(Long value) {
            addCriterion("school_year_id <", value, "schoolYearId");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIdLessThanOrEqualTo(Long value) {
            addCriterion("school_year_id <=", value, "schoolYearId");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIdIn(List<Long> values) {
            addCriterion("school_year_id in", values, "schoolYearId");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIdNotIn(List<Long> values) {
            addCriterion("school_year_id not in", values, "schoolYearId");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIdBetween(Long value1, Long value2) {
            addCriterion("school_year_id between", value1, value2, "schoolYearId");
            return (Criteria) this;
        }

        public Criteria andSchoolYearIdNotBetween(Long value1, Long value2) {
            addCriterion("school_year_id not between", value1, value2, "schoolYearId");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNameIsNull() {
            addCriterion("school_year_name is null");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNameIsNotNull() {
            addCriterion("school_year_name is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNameEqualTo(String value) {
            addCriterion("school_year_name =", value, "schoolYearName");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNameNotEqualTo(String value) {
            addCriterion("school_year_name <>", value, "schoolYearName");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNameGreaterThan(String value) {
            addCriterion("school_year_name >", value, "schoolYearName");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNameGreaterThanOrEqualTo(String value) {
            addCriterion("school_year_name >=", value, "schoolYearName");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNameLessThan(String value) {
            addCriterion("school_year_name <", value, "schoolYearName");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNameLessThanOrEqualTo(String value) {
            addCriterion("school_year_name <=", value, "schoolYearName");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNameLike(String value) {
            addCriterion("school_year_name like", value, "schoolYearName");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNameNotLike(String value) {
            addCriterion("school_year_name not like", value, "schoolYearName");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNameIn(List<String> values) {
            addCriterion("school_year_name in", values, "schoolYearName");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNameNotIn(List<String> values) {
            addCriterion("school_year_name not in", values, "schoolYearName");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNameBetween(String value1, String value2) {
            addCriterion("school_year_name between", value1, value2, "schoolYearName");
            return (Criteria) this;
        }

        public Criteria andSchoolYearNameNotBetween(String value1, String value2) {
            addCriterion("school_year_name not between", value1, value2, "schoolYearName");
            return (Criteria) this;
        }

        public Criteria andSemesterIdIsNull() {
            addCriterion("semester_id is null");
            return (Criteria) this;
        }

        public Criteria andSemesterIdIsNotNull() {
            addCriterion("semester_id is not null");
            return (Criteria) this;
        }

        public Criteria andSemesterIdEqualTo(Long value) {
            addCriterion("semester_id =", value, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterIdNotEqualTo(Long value) {
            addCriterion("semester_id <>", value, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterIdGreaterThan(Long value) {
            addCriterion("semester_id >", value, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("semester_id >=", value, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterIdLessThan(Long value) {
            addCriterion("semester_id <", value, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterIdLessThanOrEqualTo(Long value) {
            addCriterion("semester_id <=", value, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterIdIn(List<Long> values) {
            addCriterion("semester_id in", values, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterIdNotIn(List<Long> values) {
            addCriterion("semester_id not in", values, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterIdBetween(Long value1, Long value2) {
            addCriterion("semester_id between", value1, value2, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterIdNotBetween(Long value1, Long value2) {
            addCriterion("semester_id not between", value1, value2, "semesterId");
            return (Criteria) this;
        }

        public Criteria andSemesterNameIsNull() {
            addCriterion("semester_name is null");
            return (Criteria) this;
        }

        public Criteria andSemesterNameIsNotNull() {
            addCriterion("semester_name is not null");
            return (Criteria) this;
        }

        public Criteria andSemesterNameEqualTo(String value) {
            addCriterion("semester_name =", value, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameNotEqualTo(String value) {
            addCriterion("semester_name <>", value, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameGreaterThan(String value) {
            addCriterion("semester_name >", value, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameGreaterThanOrEqualTo(String value) {
            addCriterion("semester_name >=", value, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameLessThan(String value) {
            addCriterion("semester_name <", value, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameLessThanOrEqualTo(String value) {
            addCriterion("semester_name <=", value, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameLike(String value) {
            addCriterion("semester_name like", value, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameNotLike(String value) {
            addCriterion("semester_name not like", value, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameIn(List<String> values) {
            addCriterion("semester_name in", values, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameNotIn(List<String> values) {
            addCriterion("semester_name not in", values, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameBetween(String value1, String value2) {
            addCriterion("semester_name between", value1, value2, "semesterName");
            return (Criteria) this;
        }

        public Criteria andSemesterNameNotBetween(String value1, String value2) {
            addCriterion("semester_name not between", value1, value2, "semesterName");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupIdIsNull() {
            addCriterion("teacher_group_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupIdIsNotNull() {
            addCriterion("teacher_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupIdEqualTo(Long value) {
            addCriterion("teacher_group_id =", value, "teacherGroupId");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupIdNotEqualTo(Long value) {
            addCriterion("teacher_group_id <>", value, "teacherGroupId");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupIdGreaterThan(Long value) {
            addCriterion("teacher_group_id >", value, "teacherGroupId");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("teacher_group_id >=", value, "teacherGroupId");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupIdLessThan(Long value) {
            addCriterion("teacher_group_id <", value, "teacherGroupId");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("teacher_group_id <=", value, "teacherGroupId");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupIdIn(List<Long> values) {
            addCriterion("teacher_group_id in", values, "teacherGroupId");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupIdNotIn(List<Long> values) {
            addCriterion("teacher_group_id not in", values, "teacherGroupId");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupIdBetween(Long value1, Long value2) {
            addCriterion("teacher_group_id between", value1, value2, "teacherGroupId");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("teacher_group_id not between", value1, value2, "teacherGroupId");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupNameIsNull() {
            addCriterion("teacher_group_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupNameIsNotNull() {
            addCriterion("teacher_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupNameEqualTo(String value) {
            addCriterion("teacher_group_name =", value, "teacherGroupName");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupNameNotEqualTo(String value) {
            addCriterion("teacher_group_name <>", value, "teacherGroupName");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupNameGreaterThan(String value) {
            addCriterion("teacher_group_name >", value, "teacherGroupName");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_group_name >=", value, "teacherGroupName");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupNameLessThan(String value) {
            addCriterion("teacher_group_name <", value, "teacherGroupName");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupNameLessThanOrEqualTo(String value) {
            addCriterion("teacher_group_name <=", value, "teacherGroupName");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupNameLike(String value) {
            addCriterion("teacher_group_name like", value, "teacherGroupName");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupNameNotLike(String value) {
            addCriterion("teacher_group_name not like", value, "teacherGroupName");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupNameIn(List<String> values) {
            addCriterion("teacher_group_name in", values, "teacherGroupName");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupNameNotIn(List<String> values) {
            addCriterion("teacher_group_name not in", values, "teacherGroupName");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupNameBetween(String value1, String value2) {
            addCriterion("teacher_group_name between", value1, value2, "teacherGroupName");
            return (Criteria) this;
        }

        public Criteria andTeacherGroupNameNotBetween(String value1, String value2) {
            addCriterion("teacher_group_name not between", value1, value2, "teacherGroupName");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNull() {
            addCriterion("teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(Long value) {
            addCriterion("teacher_id =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(Long value) {
            addCriterion("teacher_id <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(Long value) {
            addCriterion("teacher_id >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(Long value) {
            addCriterion("teacher_id >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(Long value) {
            addCriterion("teacher_id <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(Long value) {
            addCriterion("teacher_id <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<Long> values) {
            addCriterion("teacher_id in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<Long> values) {
            addCriterion("teacher_id not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(Long value1, Long value2) {
            addCriterion("teacher_id between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(Long value1, Long value2) {
            addCriterion("teacher_id not between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNull() {
            addCriterion("teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNotNull() {
            addCriterion("teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameEqualTo(String value) {
            addCriterion("teacher_name =", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotEqualTo(String value) {
            addCriterion("teacher_name <>", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThan(String value) {
            addCriterion("teacher_name >", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_name >=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThan(String value) {
            addCriterion("teacher_name <", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("teacher_name <=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLike(String value) {
            addCriterion("teacher_name like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotLike(String value) {
            addCriterion("teacher_name not like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIn(List<String> values) {
            addCriterion("teacher_name in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotIn(List<String> values) {
            addCriterion("teacher_name not in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameBetween(String value1, String value2) {
            addCriterion("teacher_name between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotBetween(String value1, String value2) {
            addCriterion("teacher_name not between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andAllLearnTimeIsNull() {
            addCriterion("all_learn_time is null");
            return (Criteria) this;
        }

        public Criteria andAllLearnTimeIsNotNull() {
            addCriterion("all_learn_time is not null");
            return (Criteria) this;
        }

        public Criteria andAllLearnTimeEqualTo(Integer value) {
            addCriterion("all_learn_time =", value, "allLearnTime");
            return (Criteria) this;
        }

        public Criteria andAllLearnTimeNotEqualTo(Integer value) {
            addCriterion("all_learn_time <>", value, "allLearnTime");
            return (Criteria) this;
        }

        public Criteria andAllLearnTimeGreaterThan(Integer value) {
            addCriterion("all_learn_time >", value, "allLearnTime");
            return (Criteria) this;
        }

        public Criteria andAllLearnTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("all_learn_time >=", value, "allLearnTime");
            return (Criteria) this;
        }

        public Criteria andAllLearnTimeLessThan(Integer value) {
            addCriterion("all_learn_time <", value, "allLearnTime");
            return (Criteria) this;
        }

        public Criteria andAllLearnTimeLessThanOrEqualTo(Integer value) {
            addCriterion("all_learn_time <=", value, "allLearnTime");
            return (Criteria) this;
        }

        public Criteria andAllLearnTimeIn(List<Integer> values) {
            addCriterion("all_learn_time in", values, "allLearnTime");
            return (Criteria) this;
        }

        public Criteria andAllLearnTimeNotIn(List<Integer> values) {
            addCriterion("all_learn_time not in", values, "allLearnTime");
            return (Criteria) this;
        }

        public Criteria andAllLearnTimeBetween(Integer value1, Integer value2) {
            addCriterion("all_learn_time between", value1, value2, "allLearnTime");
            return (Criteria) this;
        }

        public Criteria andAllLearnTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("all_learn_time not between", value1, value2, "allLearnTime");
            return (Criteria) this;
        }

        public Criteria andWeekLearnTimeIsNull() {
            addCriterion("week_learn_time is null");
            return (Criteria) this;
        }

        public Criteria andWeekLearnTimeIsNotNull() {
            addCriterion("week_learn_time is not null");
            return (Criteria) this;
        }

        public Criteria andWeekLearnTimeEqualTo(Integer value) {
            addCriterion("week_learn_time =", value, "weekLearnTime");
            return (Criteria) this;
        }

        public Criteria andWeekLearnTimeNotEqualTo(Integer value) {
            addCriterion("week_learn_time <>", value, "weekLearnTime");
            return (Criteria) this;
        }

        public Criteria andWeekLearnTimeGreaterThan(Integer value) {
            addCriterion("week_learn_time >", value, "weekLearnTime");
            return (Criteria) this;
        }

        public Criteria andWeekLearnTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("week_learn_time >=", value, "weekLearnTime");
            return (Criteria) this;
        }

        public Criteria andWeekLearnTimeLessThan(Integer value) {
            addCriterion("week_learn_time <", value, "weekLearnTime");
            return (Criteria) this;
        }

        public Criteria andWeekLearnTimeLessThanOrEqualTo(Integer value) {
            addCriterion("week_learn_time <=", value, "weekLearnTime");
            return (Criteria) this;
        }

        public Criteria andWeekLearnTimeIn(List<Integer> values) {
            addCriterion("week_learn_time in", values, "weekLearnTime");
            return (Criteria) this;
        }

        public Criteria andWeekLearnTimeNotIn(List<Integer> values) {
            addCriterion("week_learn_time not in", values, "weekLearnTime");
            return (Criteria) this;
        }

        public Criteria andWeekLearnTimeBetween(Integer value1, Integer value2) {
            addCriterion("week_learn_time between", value1, value2, "weekLearnTime");
            return (Criteria) this;
        }

        public Criteria andWeekLearnTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("week_learn_time not between", value1, value2, "weekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMinWeekLearnTimeIsNull() {
            addCriterion("min_week_learn_time is null");
            return (Criteria) this;
        }

        public Criteria andMinWeekLearnTimeIsNotNull() {
            addCriterion("min_week_learn_time is not null");
            return (Criteria) this;
        }

        public Criteria andMinWeekLearnTimeEqualTo(Integer value) {
            addCriterion("min_week_learn_time =", value, "minWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMinWeekLearnTimeNotEqualTo(Integer value) {
            addCriterion("min_week_learn_time <>", value, "minWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMinWeekLearnTimeGreaterThan(Integer value) {
            addCriterion("min_week_learn_time >", value, "minWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMinWeekLearnTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_week_learn_time >=", value, "minWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMinWeekLearnTimeLessThan(Integer value) {
            addCriterion("min_week_learn_time <", value, "minWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMinWeekLearnTimeLessThanOrEqualTo(Integer value) {
            addCriterion("min_week_learn_time <=", value, "minWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMinWeekLearnTimeIn(List<Integer> values) {
            addCriterion("min_week_learn_time in", values, "minWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMinWeekLearnTimeNotIn(List<Integer> values) {
            addCriterion("min_week_learn_time not in", values, "minWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMinWeekLearnTimeBetween(Integer value1, Integer value2) {
            addCriterion("min_week_learn_time between", value1, value2, "minWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMinWeekLearnTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("min_week_learn_time not between", value1, value2, "minWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMaxWeekLearnTimeIsNull() {
            addCriterion("max_week_learn_time is null");
            return (Criteria) this;
        }

        public Criteria andMaxWeekLearnTimeIsNotNull() {
            addCriterion("max_week_learn_time is not null");
            return (Criteria) this;
        }

        public Criteria andMaxWeekLearnTimeEqualTo(Integer value) {
            addCriterion("max_week_learn_time =", value, "maxWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMaxWeekLearnTimeNotEqualTo(Integer value) {
            addCriterion("max_week_learn_time <>", value, "maxWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMaxWeekLearnTimeGreaterThan(Integer value) {
            addCriterion("max_week_learn_time >", value, "maxWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMaxWeekLearnTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_week_learn_time >=", value, "maxWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMaxWeekLearnTimeLessThan(Integer value) {
            addCriterion("max_week_learn_time <", value, "maxWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMaxWeekLearnTimeLessThanOrEqualTo(Integer value) {
            addCriterion("max_week_learn_time <=", value, "maxWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMaxWeekLearnTimeIn(List<Integer> values) {
            addCriterion("max_week_learn_time in", values, "maxWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMaxWeekLearnTimeNotIn(List<Integer> values) {
            addCriterion("max_week_learn_time not in", values, "maxWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMaxWeekLearnTimeBetween(Integer value1, Integer value2) {
            addCriterion("max_week_learn_time between", value1, value2, "maxWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andMaxWeekLearnTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("max_week_learn_time not between", value1, value2, "maxWeekLearnTime");
            return (Criteria) this;
        }

        public Criteria andActualCourseTimeIsNull() {
            addCriterion("actual_course_time is null");
            return (Criteria) this;
        }

        public Criteria andActualCourseTimeIsNotNull() {
            addCriterion("actual_course_time is not null");
            return (Criteria) this;
        }

        public Criteria andActualCourseTimeEqualTo(Integer value) {
            addCriterion("actual_course_time =", value, "actualCourseTime");
            return (Criteria) this;
        }

        public Criteria andActualCourseTimeNotEqualTo(Integer value) {
            addCriterion("actual_course_time <>", value, "actualCourseTime");
            return (Criteria) this;
        }

        public Criteria andActualCourseTimeGreaterThan(Integer value) {
            addCriterion("actual_course_time >", value, "actualCourseTime");
            return (Criteria) this;
        }

        public Criteria andActualCourseTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("actual_course_time >=", value, "actualCourseTime");
            return (Criteria) this;
        }

        public Criteria andActualCourseTimeLessThan(Integer value) {
            addCriterion("actual_course_time <", value, "actualCourseTime");
            return (Criteria) this;
        }

        public Criteria andActualCourseTimeLessThanOrEqualTo(Integer value) {
            addCriterion("actual_course_time <=", value, "actualCourseTime");
            return (Criteria) this;
        }

        public Criteria andActualCourseTimeIn(List<Integer> values) {
            addCriterion("actual_course_time in", values, "actualCourseTime");
            return (Criteria) this;
        }

        public Criteria andActualCourseTimeNotIn(List<Integer> values) {
            addCriterion("actual_course_time not in", values, "actualCourseTime");
            return (Criteria) this;
        }

        public Criteria andActualCourseTimeBetween(Integer value1, Integer value2) {
            addCriterion("actual_course_time between", value1, value2, "actualCourseTime");
            return (Criteria) this;
        }

        public Criteria andActualCourseTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("actual_course_time not between", value1, value2, "actualCourseTime");
            return (Criteria) this;
        }

        public Criteria andTeachClassNumberIsNull() {
            addCriterion("teach_class_number is null");
            return (Criteria) this;
        }

        public Criteria andTeachClassNumberIsNotNull() {
            addCriterion("teach_class_number is not null");
            return (Criteria) this;
        }

        public Criteria andTeachClassNumberEqualTo(Integer value) {
            addCriterion("teach_class_number =", value, "teachClassNumber");
            return (Criteria) this;
        }

        public Criteria andTeachClassNumberNotEqualTo(Integer value) {
            addCriterion("teach_class_number <>", value, "teachClassNumber");
            return (Criteria) this;
        }

        public Criteria andTeachClassNumberGreaterThan(Integer value) {
            addCriterion("teach_class_number >", value, "teachClassNumber");
            return (Criteria) this;
        }

        public Criteria andTeachClassNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("teach_class_number >=", value, "teachClassNumber");
            return (Criteria) this;
        }

        public Criteria andTeachClassNumberLessThan(Integer value) {
            addCriterion("teach_class_number <", value, "teachClassNumber");
            return (Criteria) this;
        }

        public Criteria andTeachClassNumberLessThanOrEqualTo(Integer value) {
            addCriterion("teach_class_number <=", value, "teachClassNumber");
            return (Criteria) this;
        }

        public Criteria andTeachClassNumberIn(List<Integer> values) {
            addCriterion("teach_class_number in", values, "teachClassNumber");
            return (Criteria) this;
        }

        public Criteria andTeachClassNumberNotIn(List<Integer> values) {
            addCriterion("teach_class_number not in", values, "teachClassNumber");
            return (Criteria) this;
        }

        public Criteria andTeachClassNumberBetween(Integer value1, Integer value2) {
            addCriterion("teach_class_number between", value1, value2, "teachClassNumber");
            return (Criteria) this;
        }

        public Criteria andTeachClassNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("teach_class_number not between", value1, value2, "teachClassNumber");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andSystemStatusIsNull() {
            addCriterion("system_status is null");
            return (Criteria) this;
        }

        public Criteria andSystemStatusIsNotNull() {
            addCriterion("system_status is not null");
            return (Criteria) this;
        }

        public Criteria andSystemStatusEqualTo(String value) {
            addCriterion("system_status =", value, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusNotEqualTo(String value) {
            addCriterion("system_status <>", value, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusGreaterThan(String value) {
            addCriterion("system_status >", value, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusGreaterThanOrEqualTo(String value) {
            addCriterion("system_status >=", value, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusLessThan(String value) {
            addCriterion("system_status <", value, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusLessThanOrEqualTo(String value) {
            addCriterion("system_status <=", value, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusLike(String value) {
            addCriterion("system_status like", value, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusNotLike(String value) {
            addCriterion("system_status not like", value, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusIn(List<String> values) {
            addCriterion("system_status in", values, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusNotIn(List<String> values) {
            addCriterion("system_status not in", values, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusBetween(String value1, String value2) {
            addCriterion("system_status between", value1, value2, "systemStatus");
            return (Criteria) this;
        }

        public Criteria andSystemStatusNotBetween(String value1, String value2) {
            addCriterion("system_status not between", value1, value2, "systemStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}