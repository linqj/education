package com.chinayouthedu.zqzc.entity.paike;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimetableRuleExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public TimetableRuleExample() {
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

        public Criteria andCourseNumIsNull() {
            addCriterion("course_num is null");
            return (Criteria) this;
        }

        public Criteria andCourseNumIsNotNull() {
            addCriterion("course_num is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNumEqualTo(Integer value) {
            addCriterion("course_num =", value, "courseNum");
            return (Criteria) this;
        }

        public Criteria andCourseNumNotEqualTo(Integer value) {
            addCriterion("course_num <>", value, "courseNum");
            return (Criteria) this;
        }

        public Criteria andCourseNumGreaterThan(Integer value) {
            addCriterion("course_num >", value, "courseNum");
            return (Criteria) this;
        }

        public Criteria andCourseNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_num >=", value, "courseNum");
            return (Criteria) this;
        }

        public Criteria andCourseNumLessThan(Integer value) {
            addCriterion("course_num <", value, "courseNum");
            return (Criteria) this;
        }

        public Criteria andCourseNumLessThanOrEqualTo(Integer value) {
            addCriterion("course_num <=", value, "courseNum");
            return (Criteria) this;
        }

        public Criteria andCourseNumIn(List<Integer> values) {
            addCriterion("course_num in", values, "courseNum");
            return (Criteria) this;
        }

        public Criteria andCourseNumNotIn(List<Integer> values) {
            addCriterion("course_num not in", values, "courseNum");
            return (Criteria) this;
        }

        public Criteria andCourseNumBetween(Integer value1, Integer value2) {
            addCriterion("course_num between", value1, value2, "courseNum");
            return (Criteria) this;
        }

        public Criteria andCourseNumNotBetween(Integer value1, Integer value2) {
            addCriterion("course_num not between", value1, value2, "courseNum");
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

        public Criteria andFirstCourseTimeIsNull() {
            addCriterion("first_course_time is null");
            return (Criteria) this;
        }

        public Criteria andFirstCourseTimeIsNotNull() {
            addCriterion("first_course_time is not null");
            return (Criteria) this;
        }

        public Criteria andFirstCourseTimeEqualTo(String value) {
            addCriterion("first_course_time =", value, "firstCourseTime");
            return (Criteria) this;
        }

        public Criteria andFirstCourseTimeNotEqualTo(String value) {
            addCriterion("first_course_time <>", value, "firstCourseTime");
            return (Criteria) this;
        }

        public Criteria andFirstCourseTimeGreaterThan(String value) {
            addCriterion("first_course_time >", value, "firstCourseTime");
            return (Criteria) this;
        }

        public Criteria andFirstCourseTimeGreaterThanOrEqualTo(String value) {
            addCriterion("first_course_time >=", value, "firstCourseTime");
            return (Criteria) this;
        }

        public Criteria andFirstCourseTimeLessThan(String value) {
            addCriterion("first_course_time <", value, "firstCourseTime");
            return (Criteria) this;
        }

        public Criteria andFirstCourseTimeLessThanOrEqualTo(String value) {
            addCriterion("first_course_time <=", value, "firstCourseTime");
            return (Criteria) this;
        }

        public Criteria andFirstCourseTimeLike(String value) {
            addCriterion("first_course_time like", value, "firstCourseTime");
            return (Criteria) this;
        }

        public Criteria andFirstCourseTimeNotLike(String value) {
            addCriterion("first_course_time not like", value, "firstCourseTime");
            return (Criteria) this;
        }

        public Criteria andFirstCourseTimeIn(List<String> values) {
            addCriterion("first_course_time in", values, "firstCourseTime");
            return (Criteria) this;
        }

        public Criteria andFirstCourseTimeNotIn(List<String> values) {
            addCriterion("first_course_time not in", values, "firstCourseTime");
            return (Criteria) this;
        }

        public Criteria andFirstCourseTimeBetween(String value1, String value2) {
            addCriterion("first_course_time between", value1, value2, "firstCourseTime");
            return (Criteria) this;
        }

        public Criteria andFirstCourseTimeNotBetween(String value1, String value2) {
            addCriterion("first_course_time not between", value1, value2, "firstCourseTime");
            return (Criteria) this;
        }

        public Criteria andGymnasticsSortIsNull() {
            addCriterion("gymnastics_sort is null");
            return (Criteria) this;
        }

        public Criteria andGymnasticsSortIsNotNull() {
            addCriterion("gymnastics_sort is not null");
            return (Criteria) this;
        }

        public Criteria andGymnasticsSortEqualTo(Integer value) {
            addCriterion("gymnastics_sort =", value, "gymnasticsSort");
            return (Criteria) this;
        }

        public Criteria andGymnasticsSortNotEqualTo(Integer value) {
            addCriterion("gymnastics_sort <>", value, "gymnasticsSort");
            return (Criteria) this;
        }

        public Criteria andGymnasticsSortGreaterThan(Integer value) {
            addCriterion("gymnastics_sort >", value, "gymnasticsSort");
            return (Criteria) this;
        }

        public Criteria andGymnasticsSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("gymnastics_sort >=", value, "gymnasticsSort");
            return (Criteria) this;
        }

        public Criteria andGymnasticsSortLessThan(Integer value) {
            addCriterion("gymnastics_sort <", value, "gymnasticsSort");
            return (Criteria) this;
        }

        public Criteria andGymnasticsSortLessThanOrEqualTo(Integer value) {
            addCriterion("gymnastics_sort <=", value, "gymnasticsSort");
            return (Criteria) this;
        }

        public Criteria andGymnasticsSortIn(List<Integer> values) {
            addCriterion("gymnastics_sort in", values, "gymnasticsSort");
            return (Criteria) this;
        }

        public Criteria andGymnasticsSortNotIn(List<Integer> values) {
            addCriterion("gymnastics_sort not in", values, "gymnasticsSort");
            return (Criteria) this;
        }

        public Criteria andGymnasticsSortBetween(Integer value1, Integer value2) {
            addCriterion("gymnastics_sort between", value1, value2, "gymnasticsSort");
            return (Criteria) this;
        }

        public Criteria andGymnasticsSortNotBetween(Integer value1, Integer value2) {
            addCriterion("gymnastics_sort not between", value1, value2, "gymnasticsSort");
            return (Criteria) this;
        }

        public Criteria andGymnasticsLengthIsNull() {
            addCriterion("gymnastics_length is null");
            return (Criteria) this;
        }

        public Criteria andGymnasticsLengthIsNotNull() {
            addCriterion("gymnastics_length is not null");
            return (Criteria) this;
        }

        public Criteria andGymnasticsLengthEqualTo(Integer value) {
            addCriterion("gymnastics_length =", value, "gymnasticsLength");
            return (Criteria) this;
        }

        public Criteria andGymnasticsLengthNotEqualTo(Integer value) {
            addCriterion("gymnastics_length <>", value, "gymnasticsLength");
            return (Criteria) this;
        }

        public Criteria andGymnasticsLengthGreaterThan(Integer value) {
            addCriterion("gymnastics_length >", value, "gymnasticsLength");
            return (Criteria) this;
        }

        public Criteria andGymnasticsLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("gymnastics_length >=", value, "gymnasticsLength");
            return (Criteria) this;
        }

        public Criteria andGymnasticsLengthLessThan(Integer value) {
            addCriterion("gymnastics_length <", value, "gymnasticsLength");
            return (Criteria) this;
        }

        public Criteria andGymnasticsLengthLessThanOrEqualTo(Integer value) {
            addCriterion("gymnastics_length <=", value, "gymnasticsLength");
            return (Criteria) this;
        }

        public Criteria andGymnasticsLengthIn(List<Integer> values) {
            addCriterion("gymnastics_length in", values, "gymnasticsLength");
            return (Criteria) this;
        }

        public Criteria andGymnasticsLengthNotIn(List<Integer> values) {
            addCriterion("gymnastics_length not in", values, "gymnasticsLength");
            return (Criteria) this;
        }

        public Criteria andGymnasticsLengthBetween(Integer value1, Integer value2) {
            addCriterion("gymnastics_length between", value1, value2, "gymnasticsLength");
            return (Criteria) this;
        }

        public Criteria andGymnasticsLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("gymnastics_length not between", value1, value2, "gymnasticsLength");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseTimeIsNull() {
            addCriterion("pm_first_course_time is null");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseTimeIsNotNull() {
            addCriterion("pm_first_course_time is not null");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseTimeEqualTo(String value) {
            addCriterion("pm_first_course_time =", value, "pmFirstCourseTime");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseTimeNotEqualTo(String value) {
            addCriterion("pm_first_course_time <>", value, "pmFirstCourseTime");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseTimeGreaterThan(String value) {
            addCriterion("pm_first_course_time >", value, "pmFirstCourseTime");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseTimeGreaterThanOrEqualTo(String value) {
            addCriterion("pm_first_course_time >=", value, "pmFirstCourseTime");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseTimeLessThan(String value) {
            addCriterion("pm_first_course_time <", value, "pmFirstCourseTime");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseTimeLessThanOrEqualTo(String value) {
            addCriterion("pm_first_course_time <=", value, "pmFirstCourseTime");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseTimeLike(String value) {
            addCriterion("pm_first_course_time like", value, "pmFirstCourseTime");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseTimeNotLike(String value) {
            addCriterion("pm_first_course_time not like", value, "pmFirstCourseTime");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseTimeIn(List<String> values) {
            addCriterion("pm_first_course_time in", values, "pmFirstCourseTime");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseTimeNotIn(List<String> values) {
            addCriterion("pm_first_course_time not in", values, "pmFirstCourseTime");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseTimeBetween(String value1, String value2) {
            addCriterion("pm_first_course_time between", value1, value2, "pmFirstCourseTime");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseTimeNotBetween(String value1, String value2) {
            addCriterion("pm_first_course_time not between", value1, value2, "pmFirstCourseTime");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseSortIsNull() {
            addCriterion("pm_first_course_sort is null");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseSortIsNotNull() {
            addCriterion("pm_first_course_sort is not null");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseSortEqualTo(Integer value) {
            addCriterion("pm_first_course_sort =", value, "pmFirstCourseSort");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseSortNotEqualTo(Integer value) {
            addCriterion("pm_first_course_sort <>", value, "pmFirstCourseSort");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseSortGreaterThan(Integer value) {
            addCriterion("pm_first_course_sort >", value, "pmFirstCourseSort");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("pm_first_course_sort >=", value, "pmFirstCourseSort");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseSortLessThan(Integer value) {
            addCriterion("pm_first_course_sort <", value, "pmFirstCourseSort");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseSortLessThanOrEqualTo(Integer value) {
            addCriterion("pm_first_course_sort <=", value, "pmFirstCourseSort");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseSortIn(List<Integer> values) {
            addCriterion("pm_first_course_sort in", values, "pmFirstCourseSort");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseSortNotIn(List<Integer> values) {
            addCriterion("pm_first_course_sort not in", values, "pmFirstCourseSort");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseSortBetween(Integer value1, Integer value2) {
            addCriterion("pm_first_course_sort between", value1, value2, "pmFirstCourseSort");
            return (Criteria) this;
        }

        public Criteria andPmFirstCourseSortNotBetween(Integer value1, Integer value2) {
            addCriterion("pm_first_course_sort not between", value1, value2, "pmFirstCourseSort");
            return (Criteria) this;
        }

        public Criteria andRecessIsNull() {
            addCriterion("recess is null");
            return (Criteria) this;
        }

        public Criteria andRecessIsNotNull() {
            addCriterion("recess is not null");
            return (Criteria) this;
        }

        public Criteria andRecessEqualTo(Integer value) {
            addCriterion("recess =", value, "recess");
            return (Criteria) this;
        }

        public Criteria andRecessNotEqualTo(Integer value) {
            addCriterion("recess <>", value, "recess");
            return (Criteria) this;
        }

        public Criteria andRecessGreaterThan(Integer value) {
            addCriterion("recess >", value, "recess");
            return (Criteria) this;
        }

        public Criteria andRecessGreaterThanOrEqualTo(Integer value) {
            addCriterion("recess >=", value, "recess");
            return (Criteria) this;
        }

        public Criteria andRecessLessThan(Integer value) {
            addCriterion("recess <", value, "recess");
            return (Criteria) this;
        }

        public Criteria andRecessLessThanOrEqualTo(Integer value) {
            addCriterion("recess <=", value, "recess");
            return (Criteria) this;
        }

        public Criteria andRecessIn(List<Integer> values) {
            addCriterion("recess in", values, "recess");
            return (Criteria) this;
        }

        public Criteria andRecessNotIn(List<Integer> values) {
            addCriterion("recess not in", values, "recess");
            return (Criteria) this;
        }

        public Criteria andRecessBetween(Integer value1, Integer value2) {
            addCriterion("recess between", value1, value2, "recess");
            return (Criteria) this;
        }

        public Criteria andRecessNotBetween(Integer value1, Integer value2) {
            addCriterion("recess not between", value1, value2, "recess");
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