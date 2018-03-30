package com.chinayouthedu.zqzc.entity.paike;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CoursePlanExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public CoursePlanExample() {
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

        public Criteria andGradeIdIsNull() {
            addCriterion("grade_id is null");
            return (Criteria) this;
        }

        public Criteria andGradeIdIsNotNull() {
            addCriterion("grade_id is not null");
            return (Criteria) this;
        }

        public Criteria andGradeIdEqualTo(Long value) {
            addCriterion("grade_id =", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotEqualTo(Long value) {
            addCriterion("grade_id <>", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdGreaterThan(Long value) {
            addCriterion("grade_id >", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("grade_id >=", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdLessThan(Long value) {
            addCriterion("grade_id <", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdLessThanOrEqualTo(Long value) {
            addCriterion("grade_id <=", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdIn(List<Long> values) {
            addCriterion("grade_id in", values, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotIn(List<Long> values) {
            addCriterion("grade_id not in", values, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdBetween(Long value1, Long value2) {
            addCriterion("grade_id between", value1, value2, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotBetween(Long value1, Long value2) {
            addCriterion("grade_id not between", value1, value2, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeNameIsNull() {
            addCriterion("grade_name is null");
            return (Criteria) this;
        }

        public Criteria andGradeNameIsNotNull() {
            addCriterion("grade_name is not null");
            return (Criteria) this;
        }

        public Criteria andGradeNameEqualTo(String value) {
            addCriterion("grade_name =", value, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameNotEqualTo(String value) {
            addCriterion("grade_name <>", value, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameGreaterThan(String value) {
            addCriterion("grade_name >", value, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameGreaterThanOrEqualTo(String value) {
            addCriterion("grade_name >=", value, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameLessThan(String value) {
            addCriterion("grade_name <", value, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameLessThanOrEqualTo(String value) {
            addCriterion("grade_name <=", value, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameLike(String value) {
            addCriterion("grade_name like", value, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameNotLike(String value) {
            addCriterion("grade_name not like", value, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameIn(List<String> values) {
            addCriterion("grade_name in", values, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameNotIn(List<String> values) {
            addCriterion("grade_name not in", values, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameBetween(String value1, String value2) {
            addCriterion("grade_name between", value1, value2, "gradeName");
            return (Criteria) this;
        }

        public Criteria andGradeNameNotBetween(String value1, String value2) {
            addCriterion("grade_name not between", value1, value2, "gradeName");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Long value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Long value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Long value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Long value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Long value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Long> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Long> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Long value1, Long value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Long value1, Long value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseDisciplineIsNull() {
            addCriterion("course_discipline is null");
            return (Criteria) this;
        }

        public Criteria andCourseDisciplineIsNotNull() {
            addCriterion("course_discipline is not null");
            return (Criteria) this;
        }

        public Criteria andCourseDisciplineEqualTo(String value) {
            addCriterion("course_discipline =", value, "courseDiscipline");
            return (Criteria) this;
        }

        public Criteria andCourseDisciplineNotEqualTo(String value) {
            addCriterion("course_discipline <>", value, "courseDiscipline");
            return (Criteria) this;
        }

        public Criteria andCourseDisciplineGreaterThan(String value) {
            addCriterion("course_discipline >", value, "courseDiscipline");
            return (Criteria) this;
        }

        public Criteria andCourseDisciplineGreaterThanOrEqualTo(String value) {
            addCriterion("course_discipline >=", value, "courseDiscipline");
            return (Criteria) this;
        }

        public Criteria andCourseDisciplineLessThan(String value) {
            addCriterion("course_discipline <", value, "courseDiscipline");
            return (Criteria) this;
        }

        public Criteria andCourseDisciplineLessThanOrEqualTo(String value) {
            addCriterion("course_discipline <=", value, "courseDiscipline");
            return (Criteria) this;
        }

        public Criteria andCourseDisciplineLike(String value) {
            addCriterion("course_discipline like", value, "courseDiscipline");
            return (Criteria) this;
        }

        public Criteria andCourseDisciplineNotLike(String value) {
            addCriterion("course_discipline not like", value, "courseDiscipline");
            return (Criteria) this;
        }

        public Criteria andCourseDisciplineIn(List<String> values) {
            addCriterion("course_discipline in", values, "courseDiscipline");
            return (Criteria) this;
        }

        public Criteria andCourseDisciplineNotIn(List<String> values) {
            addCriterion("course_discipline not in", values, "courseDiscipline");
            return (Criteria) this;
        }

        public Criteria andCourseDisciplineBetween(String value1, String value2) {
            addCriterion("course_discipline between", value1, value2, "courseDiscipline");
            return (Criteria) this;
        }

        public Criteria andCourseDisciplineNotBetween(String value1, String value2) {
            addCriterion("course_discipline not between", value1, value2, "courseDiscipline");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameIsNull() {
            addCriterion("discipline_name is null");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameIsNotNull() {
            addCriterion("discipline_name is not null");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameEqualTo(String value) {
            addCriterion("discipline_name =", value, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameNotEqualTo(String value) {
            addCriterion("discipline_name <>", value, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameGreaterThan(String value) {
            addCriterion("discipline_name >", value, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameGreaterThanOrEqualTo(String value) {
            addCriterion("discipline_name >=", value, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameLessThan(String value) {
            addCriterion("discipline_name <", value, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameLessThanOrEqualTo(String value) {
            addCriterion("discipline_name <=", value, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameLike(String value) {
            addCriterion("discipline_name like", value, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameNotLike(String value) {
            addCriterion("discipline_name not like", value, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameIn(List<String> values) {
            addCriterion("discipline_name in", values, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameNotIn(List<String> values) {
            addCriterion("discipline_name not in", values, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameBetween(String value1, String value2) {
            addCriterion("discipline_name between", value1, value2, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameNotBetween(String value1, String value2) {
            addCriterion("discipline_name not between", value1, value2, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andSemesterLearnTimeIsNull() {
            addCriterion("semester_learn_time is null");
            return (Criteria) this;
        }

        public Criteria andSemesterLearnTimeIsNotNull() {
            addCriterion("semester_learn_time is not null");
            return (Criteria) this;
        }

        public Criteria andSemesterLearnTimeEqualTo(Integer value) {
            addCriterion("semester_learn_time =", value, "semesterLearnTime");
            return (Criteria) this;
        }

        public Criteria andSemesterLearnTimeNotEqualTo(Integer value) {
            addCriterion("semester_learn_time <>", value, "semesterLearnTime");
            return (Criteria) this;
        }

        public Criteria andSemesterLearnTimeGreaterThan(Integer value) {
            addCriterion("semester_learn_time >", value, "semesterLearnTime");
            return (Criteria) this;
        }

        public Criteria andSemesterLearnTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("semester_learn_time >=", value, "semesterLearnTime");
            return (Criteria) this;
        }

        public Criteria andSemesterLearnTimeLessThan(Integer value) {
            addCriterion("semester_learn_time <", value, "semesterLearnTime");
            return (Criteria) this;
        }

        public Criteria andSemesterLearnTimeLessThanOrEqualTo(Integer value) {
            addCriterion("semester_learn_time <=", value, "semesterLearnTime");
            return (Criteria) this;
        }

        public Criteria andSemesterLearnTimeIn(List<Integer> values) {
            addCriterion("semester_learn_time in", values, "semesterLearnTime");
            return (Criteria) this;
        }

        public Criteria andSemesterLearnTimeNotIn(List<Integer> values) {
            addCriterion("semester_learn_time not in", values, "semesterLearnTime");
            return (Criteria) this;
        }

        public Criteria andSemesterLearnTimeBetween(Integer value1, Integer value2) {
            addCriterion("semester_learn_time between", value1, value2, "semesterLearnTime");
            return (Criteria) this;
        }

        public Criteria andSemesterLearnTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("semester_learn_time not between", value1, value2, "semesterLearnTime");
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

        public Criteria andCourseTeacherIsNull() {
            addCriterion("course_teacher is null");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherIsNotNull() {
            addCriterion("course_teacher is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherEqualTo(String value) {
            addCriterion("course_teacher =", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherNotEqualTo(String value) {
            addCriterion("course_teacher <>", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherGreaterThan(String value) {
            addCriterion("course_teacher >", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherGreaterThanOrEqualTo(String value) {
            addCriterion("course_teacher >=", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherLessThan(String value) {
            addCriterion("course_teacher <", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherLessThanOrEqualTo(String value) {
            addCriterion("course_teacher <=", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherLike(String value) {
            addCriterion("course_teacher like", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherNotLike(String value) {
            addCriterion("course_teacher not like", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherIn(List<String> values) {
            addCriterion("course_teacher in", values, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherNotIn(List<String> values) {
            addCriterion("course_teacher not in", values, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherBetween(String value1, String value2) {
            addCriterion("course_teacher between", value1, value2, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherNotBetween(String value1, String value2) {
            addCriterion("course_teacher not between", value1, value2, "courseTeacher");
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