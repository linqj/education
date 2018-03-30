package com.chinayouthedu.zqzc.entity.paike;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SemesterExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public SemesterExample() {
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

        public Criteria andSemesterCodeIsNull() {
            addCriterion("semester_code is null");
            return (Criteria) this;
        }

        public Criteria andSemesterCodeIsNotNull() {
            addCriterion("semester_code is not null");
            return (Criteria) this;
        }

        public Criteria andSemesterCodeEqualTo(String value) {
            addCriterion("semester_code =", value, "semesterCode");
            return (Criteria) this;
        }

        public Criteria andSemesterCodeNotEqualTo(String value) {
            addCriterion("semester_code <>", value, "semesterCode");
            return (Criteria) this;
        }

        public Criteria andSemesterCodeGreaterThan(String value) {
            addCriterion("semester_code >", value, "semesterCode");
            return (Criteria) this;
        }

        public Criteria andSemesterCodeGreaterThanOrEqualTo(String value) {
            addCriterion("semester_code >=", value, "semesterCode");
            return (Criteria) this;
        }

        public Criteria andSemesterCodeLessThan(String value) {
            addCriterion("semester_code <", value, "semesterCode");
            return (Criteria) this;
        }

        public Criteria andSemesterCodeLessThanOrEqualTo(String value) {
            addCriterion("semester_code <=", value, "semesterCode");
            return (Criteria) this;
        }

        public Criteria andSemesterCodeLike(String value) {
            addCriterion("semester_code like", value, "semesterCode");
            return (Criteria) this;
        }

        public Criteria andSemesterCodeNotLike(String value) {
            addCriterion("semester_code not like", value, "semesterCode");
            return (Criteria) this;
        }

        public Criteria andSemesterCodeIn(List<String> values) {
            addCriterion("semester_code in", values, "semesterCode");
            return (Criteria) this;
        }

        public Criteria andSemesterCodeNotIn(List<String> values) {
            addCriterion("semester_code not in", values, "semesterCode");
            return (Criteria) this;
        }

        public Criteria andSemesterCodeBetween(String value1, String value2) {
            addCriterion("semester_code between", value1, value2, "semesterCode");
            return (Criteria) this;
        }

        public Criteria andSemesterCodeNotBetween(String value1, String value2) {
            addCriterion("semester_code not between", value1, value2, "semesterCode");
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

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andSemesterTypeIsNull() {
            addCriterion("semester_type is null");
            return (Criteria) this;
        }

        public Criteria andSemesterTypeIsNotNull() {
            addCriterion("semester_type is not null");
            return (Criteria) this;
        }

        public Criteria andSemesterTypeEqualTo(String value) {
            addCriterion("semester_type =", value, "semesterType");
            return (Criteria) this;
        }

        public Criteria andSemesterTypeNotEqualTo(String value) {
            addCriterion("semester_type <>", value, "semesterType");
            return (Criteria) this;
        }

        public Criteria andSemesterTypeGreaterThan(String value) {
            addCriterion("semester_type >", value, "semesterType");
            return (Criteria) this;
        }

        public Criteria andSemesterTypeGreaterThanOrEqualTo(String value) {
            addCriterion("semester_type >=", value, "semesterType");
            return (Criteria) this;
        }

        public Criteria andSemesterTypeLessThan(String value) {
            addCriterion("semester_type <", value, "semesterType");
            return (Criteria) this;
        }

        public Criteria andSemesterTypeLessThanOrEqualTo(String value) {
            addCriterion("semester_type <=", value, "semesterType");
            return (Criteria) this;
        }

        public Criteria andSemesterTypeLike(String value) {
            addCriterion("semester_type like", value, "semesterType");
            return (Criteria) this;
        }

        public Criteria andSemesterTypeNotLike(String value) {
            addCriterion("semester_type not like", value, "semesterType");
            return (Criteria) this;
        }

        public Criteria andSemesterTypeIn(List<String> values) {
            addCriterion("semester_type in", values, "semesterType");
            return (Criteria) this;
        }

        public Criteria andSemesterTypeNotIn(List<String> values) {
            addCriterion("semester_type not in", values, "semesterType");
            return (Criteria) this;
        }

        public Criteria andSemesterTypeBetween(String value1, String value2) {
            addCriterion("semester_type between", value1, value2, "semesterType");
            return (Criteria) this;
        }

        public Criteria andSemesterTypeNotBetween(String value1, String value2) {
            addCriterion("semester_type not between", value1, value2, "semesterType");
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