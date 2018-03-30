package com.chinayouthedu.zqzc.entity.paike;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public CourseExample() {
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

        public Criteria andGradeCodeIsNull() {
            addCriterion("grade_code is null");
            return (Criteria) this;
        }

        public Criteria andGradeCodeIsNotNull() {
            addCriterion("grade_code is not null");
            return (Criteria) this;
        }

        public Criteria andGradeCodeEqualTo(String value) {
            addCriterion("grade_code =", value, "gradeCode");
            return (Criteria) this;
        }

        public Criteria andGradeCodeNotEqualTo(String value) {
            addCriterion("grade_code <>", value, "gradeCode");
            return (Criteria) this;
        }

        public Criteria andGradeCodeGreaterThan(String value) {
            addCriterion("grade_code >", value, "gradeCode");
            return (Criteria) this;
        }

        public Criteria andGradeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("grade_code >=", value, "gradeCode");
            return (Criteria) this;
        }

        public Criteria andGradeCodeLessThan(String value) {
            addCriterion("grade_code <", value, "gradeCode");
            return (Criteria) this;
        }

        public Criteria andGradeCodeLessThanOrEqualTo(String value) {
            addCriterion("grade_code <=", value, "gradeCode");
            return (Criteria) this;
        }

        public Criteria andGradeCodeLike(String value) {
            addCriterion("grade_code like", value, "gradeCode");
            return (Criteria) this;
        }

        public Criteria andGradeCodeNotLike(String value) {
            addCriterion("grade_code not like", value, "gradeCode");
            return (Criteria) this;
        }

        public Criteria andGradeCodeIn(List<String> values) {
            addCriterion("grade_code in", values, "gradeCode");
            return (Criteria) this;
        }

        public Criteria andGradeCodeNotIn(List<String> values) {
            addCriterion("grade_code not in", values, "gradeCode");
            return (Criteria) this;
        }

        public Criteria andGradeCodeBetween(String value1, String value2) {
            addCriterion("grade_code between", value1, value2, "gradeCode");
            return (Criteria) this;
        }

        public Criteria andGradeCodeNotBetween(String value1, String value2) {
            addCriterion("grade_code not between", value1, value2, "gradeCode");
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

        public Criteria andCourseNumberIsNull() {
            addCriterion("course_number is null");
            return (Criteria) this;
        }

        public Criteria andCourseNumberIsNotNull() {
            addCriterion("course_number is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNumberEqualTo(String value) {
            addCriterion("course_number =", value, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberNotEqualTo(String value) {
            addCriterion("course_number <>", value, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberGreaterThan(String value) {
            addCriterion("course_number >", value, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberGreaterThanOrEqualTo(String value) {
            addCriterion("course_number >=", value, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberLessThan(String value) {
            addCriterion("course_number <", value, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberLessThanOrEqualTo(String value) {
            addCriterion("course_number <=", value, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberLike(String value) {
            addCriterion("course_number like", value, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberNotLike(String value) {
            addCriterion("course_number not like", value, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberIn(List<String> values) {
            addCriterion("course_number in", values, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberNotIn(List<String> values) {
            addCriterion("course_number not in", values, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberBetween(String value1, String value2) {
            addCriterion("course_number between", value1, value2, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseNumberNotBetween(String value1, String value2) {
            addCriterion("course_number not between", value1, value2, "courseNumber");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNull() {
            addCriterion("course_type is null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNotNull() {
            addCriterion("course_type is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeEqualTo(String value) {
            addCriterion("course_type =", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotEqualTo(String value) {
            addCriterion("course_type <>", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThan(String value) {
            addCriterion("course_type >", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("course_type >=", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThan(String value) {
            addCriterion("course_type <", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThanOrEqualTo(String value) {
            addCriterion("course_type <=", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLike(String value) {
            addCriterion("course_type like", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotLike(String value) {
            addCriterion("course_type not like", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIn(List<String> values) {
            addCriterion("course_type in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotIn(List<String> values) {
            addCriterion("course_type not in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeBetween(String value1, String value2) {
            addCriterion("course_type between", value1, value2, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotBetween(String value1, String value2) {
            addCriterion("course_type not between", value1, value2, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseLengthIsNull() {
            addCriterion("course_length is null");
            return (Criteria) this;
        }

        public Criteria andCourseLengthIsNotNull() {
            addCriterion("course_length is not null");
            return (Criteria) this;
        }

        public Criteria andCourseLengthEqualTo(Integer value) {
            addCriterion("course_length =", value, "courseLength");
            return (Criteria) this;
        }

        public Criteria andCourseLengthNotEqualTo(Integer value) {
            addCriterion("course_length <>", value, "courseLength");
            return (Criteria) this;
        }

        public Criteria andCourseLengthGreaterThan(Integer value) {
            addCriterion("course_length >", value, "courseLength");
            return (Criteria) this;
        }

        public Criteria andCourseLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_length >=", value, "courseLength");
            return (Criteria) this;
        }

        public Criteria andCourseLengthLessThan(Integer value) {
            addCriterion("course_length <", value, "courseLength");
            return (Criteria) this;
        }

        public Criteria andCourseLengthLessThanOrEqualTo(Integer value) {
            addCriterion("course_length <=", value, "courseLength");
            return (Criteria) this;
        }

        public Criteria andCourseLengthIn(List<Integer> values) {
            addCriterion("course_length in", values, "courseLength");
            return (Criteria) this;
        }

        public Criteria andCourseLengthNotIn(List<Integer> values) {
            addCriterion("course_length not in", values, "courseLength");
            return (Criteria) this;
        }

        public Criteria andCourseLengthBetween(Integer value1, Integer value2) {
            addCriterion("course_length between", value1, value2, "courseLength");
            return (Criteria) this;
        }

        public Criteria andCourseLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("course_length not between", value1, value2, "courseLength");
            return (Criteria) this;
        }

        public Criteria andCoursePlanLengthIsNull() {
            addCriterion("course_plan_length is null");
            return (Criteria) this;
        }

        public Criteria andCoursePlanLengthIsNotNull() {
            addCriterion("course_plan_length is not null");
            return (Criteria) this;
        }

        public Criteria andCoursePlanLengthEqualTo(Integer value) {
            addCriterion("course_plan_length =", value, "coursePlanLength");
            return (Criteria) this;
        }

        public Criteria andCoursePlanLengthNotEqualTo(Integer value) {
            addCriterion("course_plan_length <>", value, "coursePlanLength");
            return (Criteria) this;
        }

        public Criteria andCoursePlanLengthGreaterThan(Integer value) {
            addCriterion("course_plan_length >", value, "coursePlanLength");
            return (Criteria) this;
        }

        public Criteria andCoursePlanLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_plan_length >=", value, "coursePlanLength");
            return (Criteria) this;
        }

        public Criteria andCoursePlanLengthLessThan(Integer value) {
            addCriterion("course_plan_length <", value, "coursePlanLength");
            return (Criteria) this;
        }

        public Criteria andCoursePlanLengthLessThanOrEqualTo(Integer value) {
            addCriterion("course_plan_length <=", value, "coursePlanLength");
            return (Criteria) this;
        }

        public Criteria andCoursePlanLengthIn(List<Integer> values) {
            addCriterion("course_plan_length in", values, "coursePlanLength");
            return (Criteria) this;
        }

        public Criteria andCoursePlanLengthNotIn(List<Integer> values) {
            addCriterion("course_plan_length not in", values, "coursePlanLength");
            return (Criteria) this;
        }

        public Criteria andCoursePlanLengthBetween(Integer value1, Integer value2) {
            addCriterion("course_plan_length between", value1, value2, "coursePlanLength");
            return (Criteria) this;
        }

        public Criteria andCoursePlanLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("course_plan_length not between", value1, value2, "coursePlanLength");
            return (Criteria) this;
        }

        public Criteria andCourseLevelIsNull() {
            addCriterion("course_level is null");
            return (Criteria) this;
        }

        public Criteria andCourseLevelIsNotNull() {
            addCriterion("course_level is not null");
            return (Criteria) this;
        }

        public Criteria andCourseLevelEqualTo(Integer value) {
            addCriterion("course_level =", value, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseLevelNotEqualTo(Integer value) {
            addCriterion("course_level <>", value, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseLevelGreaterThan(Integer value) {
            addCriterion("course_level >", value, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_level >=", value, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseLevelLessThan(Integer value) {
            addCriterion("course_level <", value, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseLevelLessThanOrEqualTo(Integer value) {
            addCriterion("course_level <=", value, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseLevelIn(List<Integer> values) {
            addCriterion("course_level in", values, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseLevelNotIn(List<Integer> values) {
            addCriterion("course_level not in", values, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseLevelBetween(Integer value1, Integer value2) {
            addCriterion("course_level between", value1, value2, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("course_level not between", value1, value2, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseTypeFixedIsNull() {
            addCriterion("course_type_fixed is null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeFixedIsNotNull() {
            addCriterion("course_type_fixed is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeFixedEqualTo(Boolean value) {
            addCriterion("course_type_fixed =", value, "courseTypeFixed");
            return (Criteria) this;
        }

        public Criteria andCourseTypeFixedNotEqualTo(Boolean value) {
            addCriterion("course_type_fixed <>", value, "courseTypeFixed");
            return (Criteria) this;
        }

        public Criteria andCourseTypeFixedGreaterThan(Boolean value) {
            addCriterion("course_type_fixed >", value, "courseTypeFixed");
            return (Criteria) this;
        }

        public Criteria andCourseTypeFixedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("course_type_fixed >=", value, "courseTypeFixed");
            return (Criteria) this;
        }

        public Criteria andCourseTypeFixedLessThan(Boolean value) {
            addCriterion("course_type_fixed <", value, "courseTypeFixed");
            return (Criteria) this;
        }

        public Criteria andCourseTypeFixedLessThanOrEqualTo(Boolean value) {
            addCriterion("course_type_fixed <=", value, "courseTypeFixed");
            return (Criteria) this;
        }

        public Criteria andCourseTypeFixedIn(List<Boolean> values) {
            addCriterion("course_type_fixed in", values, "courseTypeFixed");
            return (Criteria) this;
        }

        public Criteria andCourseTypeFixedNotIn(List<Boolean> values) {
            addCriterion("course_type_fixed not in", values, "courseTypeFixed");
            return (Criteria) this;
        }

        public Criteria andCourseTypeFixedBetween(Boolean value1, Boolean value2) {
            addCriterion("course_type_fixed between", value1, value2, "courseTypeFixed");
            return (Criteria) this;
        }

        public Criteria andCourseTypeFixedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("course_type_fixed not between", value1, value2, "courseTypeFixed");
            return (Criteria) this;
        }

        public Criteria andCourseStatusIsNull() {
            addCriterion("course_status is null");
            return (Criteria) this;
        }

        public Criteria andCourseStatusIsNotNull() {
            addCriterion("course_status is not null");
            return (Criteria) this;
        }

        public Criteria andCourseStatusEqualTo(String value) {
            addCriterion("course_status =", value, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusNotEqualTo(String value) {
            addCriterion("course_status <>", value, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusGreaterThan(String value) {
            addCriterion("course_status >", value, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("course_status >=", value, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusLessThan(String value) {
            addCriterion("course_status <", value, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusLessThanOrEqualTo(String value) {
            addCriterion("course_status <=", value, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusLike(String value) {
            addCriterion("course_status like", value, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusNotLike(String value) {
            addCriterion("course_status not like", value, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusIn(List<String> values) {
            addCriterion("course_status in", values, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusNotIn(List<String> values) {
            addCriterion("course_status not in", values, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusBetween(String value1, String value2) {
            addCriterion("course_status between", value1, value2, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusNotBetween(String value1, String value2) {
            addCriterion("course_status not between", value1, value2, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusIsNull() {
            addCriterion("sys_status is null");
            return (Criteria) this;
        }

        public Criteria andSysStatusIsNotNull() {
            addCriterion("sys_status is not null");
            return (Criteria) this;
        }

        public Criteria andSysStatusEqualTo(String value) {
            addCriterion("sys_status =", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusNotEqualTo(String value) {
            addCriterion("sys_status <>", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusGreaterThan(String value) {
            addCriterion("sys_status >", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusGreaterThanOrEqualTo(String value) {
            addCriterion("sys_status >=", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusLessThan(String value) {
            addCriterion("sys_status <", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusLessThanOrEqualTo(String value) {
            addCriterion("sys_status <=", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusLike(String value) {
            addCriterion("sys_status like", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusNotLike(String value) {
            addCriterion("sys_status not like", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusIn(List<String> values) {
            addCriterion("sys_status in", values, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusNotIn(List<String> values) {
            addCriterion("sys_status not in", values, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusBetween(String value1, String value2) {
            addCriterion("sys_status between", value1, value2, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusNotBetween(String value1, String value2) {
            addCriterion("sys_status not between", value1, value2, "sysStatus");
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

        public Criteria andEffectiveIsNull() {
            addCriterion("effective is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveIsNotNull() {
            addCriterion("effective is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveEqualTo(Boolean value) {
            addCriterion("effective =", value, "effective");
            return (Criteria) this;
        }

        public Criteria andEffectiveNotEqualTo(Boolean value) {
            addCriterion("effective <>", value, "effective");
            return (Criteria) this;
        }

        public Criteria andEffectiveGreaterThan(Boolean value) {
            addCriterion("effective >", value, "effective");
            return (Criteria) this;
        }

        public Criteria andEffectiveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("effective >=", value, "effective");
            return (Criteria) this;
        }

        public Criteria andEffectiveLessThan(Boolean value) {
            addCriterion("effective <", value, "effective");
            return (Criteria) this;
        }

        public Criteria andEffectiveLessThanOrEqualTo(Boolean value) {
            addCriterion("effective <=", value, "effective");
            return (Criteria) this;
        }

        public Criteria andEffectiveIn(List<Boolean> values) {
            addCriterion("effective in", values, "effective");
            return (Criteria) this;
        }

        public Criteria andEffectiveNotIn(List<Boolean> values) {
            addCriterion("effective not in", values, "effective");
            return (Criteria) this;
        }

        public Criteria andEffectiveBetween(Boolean value1, Boolean value2) {
            addCriterion("effective between", value1, value2, "effective");
            return (Criteria) this;
        }

        public Criteria andEffectiveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("effective not between", value1, value2, "effective");
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
