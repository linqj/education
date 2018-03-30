package com.chinayouthedu.zqzc.entity.paike;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ClaExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public ClaExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andClaNameIsNull() {
            addCriterion("cla_name is null");
            return (Criteria) this;
        }

        public Criteria andClaNameIsNotNull() {
            addCriterion("cla_name is not null");
            return (Criteria) this;
        }

        public Criteria andClaNameEqualTo(String value) {
            addCriterion("cla_name =", value, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameNotEqualTo(String value) {
            addCriterion("cla_name <>", value, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameGreaterThan(String value) {
            addCriterion("cla_name >", value, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameGreaterThanOrEqualTo(String value) {
            addCriterion("cla_name >=", value, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameLessThan(String value) {
            addCriterion("cla_name <", value, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameLessThanOrEqualTo(String value) {
            addCriterion("cla_name <=", value, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameLike(String value) {
            addCriterion("cla_name like", value, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameNotLike(String value) {
            addCriterion("cla_name not like", value, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameIn(List<String> values) {
            addCriterion("cla_name in", values, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameNotIn(List<String> values) {
            addCriterion("cla_name not in", values, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameBetween(String value1, String value2) {
            addCriterion("cla_name between", value1, value2, "claName");
            return (Criteria) this;
        }

        public Criteria andClaNameNotBetween(String value1, String value2) {
            addCriterion("cla_name not between", value1, value2, "claName");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEffictiveIsNull() {
            addCriterion("effictive is null");
            return (Criteria) this;
        }

        public Criteria andEffictiveIsNotNull() {
            addCriterion("effictive is not null");
            return (Criteria) this;
        }

        public Criteria andEffictiveEqualTo(Boolean value) {
            addCriterion("effictive =", value, "effictive");
            return (Criteria) this;
        }

        public Criteria andEffictiveNotEqualTo(Boolean value) {
            addCriterion("effictive <>", value, "effictive");
            return (Criteria) this;
        }

        public Criteria andEffictiveGreaterThan(Boolean value) {
            addCriterion("effictive >", value, "effictive");
            return (Criteria) this;
        }

        public Criteria andEffictiveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("effictive >=", value, "effictive");
            return (Criteria) this;
        }

        public Criteria andEffictiveLessThan(Boolean value) {
            addCriterion("effictive <", value, "effictive");
            return (Criteria) this;
        }

        public Criteria andEffictiveLessThanOrEqualTo(Boolean value) {
            addCriterion("effictive <=", value, "effictive");
            return (Criteria) this;
        }

        public Criteria andEffictiveIn(List<Boolean> values) {
            addCriterion("effictive in", values, "effictive");
            return (Criteria) this;
        }

        public Criteria andEffictiveNotIn(List<Boolean> values) {
            addCriterion("effictive not in", values, "effictive");
            return (Criteria) this;
        }

        public Criteria andEffictiveBetween(Boolean value1, Boolean value2) {
            addCriterion("effictive between", value1, value2, "effictive");
            return (Criteria) this;
        }

        public Criteria andEffictiveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("effictive not between", value1, value2, "effictive");
            return (Criteria) this;
        }

        public Criteria andClassCodeIsNull() {
            addCriterion("class_code is null");
            return (Criteria) this;
        }

        public Criteria andClassCodeIsNotNull() {
            addCriterion("class_code is not null");
            return (Criteria) this;
        }

        public Criteria andClassCodeEqualTo(String value) {
            addCriterion("class_code =", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotEqualTo(String value) {
            addCriterion("class_code <>", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeGreaterThan(String value) {
            addCriterion("class_code >", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeGreaterThanOrEqualTo(String value) {
            addCriterion("class_code >=", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeLessThan(String value) {
            addCriterion("class_code <", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeLessThanOrEqualTo(String value) {
            addCriterion("class_code <=", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeLike(String value) {
            addCriterion("class_code like", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotLike(String value) {
            addCriterion("class_code not like", value, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeIn(List<String> values) {
            addCriterion("class_code in", values, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotIn(List<String> values) {
            addCriterion("class_code not in", values, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeBetween(String value1, String value2) {
            addCriterion("class_code between", value1, value2, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassCodeNotBetween(String value1, String value2) {
            addCriterion("class_code not between", value1, value2, "classCode");
            return (Criteria) this;
        }

        public Criteria andClassGradeIdIsNull() {
            addCriterion("class_grade_id is null");
            return (Criteria) this;
        }

        public Criteria andClassGradeIdIsNotNull() {
            addCriterion("class_grade_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassGradeIdEqualTo(Long value) {
            addCriterion("class_grade_id =", value, "classGradeId");
            return (Criteria) this;
        }

        public Criteria andClassGradeIdNotEqualTo(Long value) {
            addCriterion("class_grade_id <>", value, "classGradeId");
            return (Criteria) this;
        }

        public Criteria andClassGradeIdGreaterThan(Long value) {
            addCriterion("class_grade_id >", value, "classGradeId");
            return (Criteria) this;
        }

        public Criteria andClassGradeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("class_grade_id >=", value, "classGradeId");
            return (Criteria) this;
        }

        public Criteria andClassGradeIdLessThan(Long value) {
            addCriterion("class_grade_id <", value, "classGradeId");
            return (Criteria) this;
        }

        public Criteria andClassGradeIdLessThanOrEqualTo(Long value) {
            addCriterion("class_grade_id <=", value, "classGradeId");
            return (Criteria) this;
        }

        public Criteria andClassGradeIdIn(List<Long> values) {
            addCriterion("class_grade_id in", values, "classGradeId");
            return (Criteria) this;
        }

        public Criteria andClassGradeIdNotIn(List<Long> values) {
            addCriterion("class_grade_id not in", values, "classGradeId");
            return (Criteria) this;
        }

        public Criteria andClassGradeIdBetween(Long value1, Long value2) {
            addCriterion("class_grade_id between", value1, value2, "classGradeId");
            return (Criteria) this;
        }

        public Criteria andClassGradeIdNotBetween(Long value1, Long value2) {
            addCriterion("class_grade_id not between", value1, value2, "classGradeId");
            return (Criteria) this;
        }

        public Criteria andClassGradeNameIsNull() {
            addCriterion("class_grade_name is null");
            return (Criteria) this;
        }

        public Criteria andClassGradeNameIsNotNull() {
            addCriterion("class_grade_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassGradeNameEqualTo(String value) {
            addCriterion("class_grade_name =", value, "classGradeName");
            return (Criteria) this;
        }

        public Criteria andClassGradeNameNotEqualTo(String value) {
            addCriterion("class_grade_name <>", value, "classGradeName");
            return (Criteria) this;
        }

        public Criteria andClassGradeNameGreaterThan(String value) {
            addCriterion("class_grade_name >", value, "classGradeName");
            return (Criteria) this;
        }

        public Criteria andClassGradeNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_grade_name >=", value, "classGradeName");
            return (Criteria) this;
        }

        public Criteria andClassGradeNameLessThan(String value) {
            addCriterion("class_grade_name <", value, "classGradeName");
            return (Criteria) this;
        }

        public Criteria andClassGradeNameLessThanOrEqualTo(String value) {
            addCriterion("class_grade_name <=", value, "classGradeName");
            return (Criteria) this;
        }

        public Criteria andClassGradeNameLike(String value) {
            addCriterion("class_grade_name like", value, "classGradeName");
            return (Criteria) this;
        }

        public Criteria andClassGradeNameNotLike(String value) {
            addCriterion("class_grade_name not like", value, "classGradeName");
            return (Criteria) this;
        }

        public Criteria andClassGradeNameIn(List<String> values) {
            addCriterion("class_grade_name in", values, "classGradeName");
            return (Criteria) this;
        }

        public Criteria andClassGradeNameNotIn(List<String> values) {
            addCriterion("class_grade_name not in", values, "classGradeName");
            return (Criteria) this;
        }

        public Criteria andClassGradeNameBetween(String value1, String value2) {
            addCriterion("class_grade_name between", value1, value2, "classGradeName");
            return (Criteria) this;
        }

        public Criteria andClassGradeNameNotBetween(String value1, String value2) {
            addCriterion("class_grade_name not between", value1, value2, "classGradeName");
            return (Criteria) this;
        }

        public Criteria andClassPlanStuNumIsNull() {
            addCriterion("class_plan_stu_num is null");
            return (Criteria) this;
        }

        public Criteria andClassPlanStuNumIsNotNull() {
            addCriterion("class_plan_stu_num is not null");
            return (Criteria) this;
        }

        public Criteria andClassPlanStuNumEqualTo(Short value) {
            addCriterion("class_plan_stu_num =", value, "classPlanStuNum");
            return (Criteria) this;
        }

        public Criteria andClassPlanStuNumNotEqualTo(Short value) {
            addCriterion("class_plan_stu_num <>", value, "classPlanStuNum");
            return (Criteria) this;
        }

        public Criteria andClassPlanStuNumGreaterThan(Short value) {
            addCriterion("class_plan_stu_num >", value, "classPlanStuNum");
            return (Criteria) this;
        }

        public Criteria andClassPlanStuNumGreaterThanOrEqualTo(Short value) {
            addCriterion("class_plan_stu_num >=", value, "classPlanStuNum");
            return (Criteria) this;
        }

        public Criteria andClassPlanStuNumLessThan(Short value) {
            addCriterion("class_plan_stu_num <", value, "classPlanStuNum");
            return (Criteria) this;
        }

        public Criteria andClassPlanStuNumLessThanOrEqualTo(Short value) {
            addCriterion("class_plan_stu_num <=", value, "classPlanStuNum");
            return (Criteria) this;
        }

        public Criteria andClassPlanStuNumIn(List<Short> values) {
            addCriterion("class_plan_stu_num in", values, "classPlanStuNum");
            return (Criteria) this;
        }

        public Criteria andClassPlanStuNumNotIn(List<Short> values) {
            addCriterion("class_plan_stu_num not in", values, "classPlanStuNum");
            return (Criteria) this;
        }

        public Criteria andClassPlanStuNumBetween(Short value1, Short value2) {
            addCriterion("class_plan_stu_num between", value1, value2, "classPlanStuNum");
            return (Criteria) this;
        }

        public Criteria andClassPlanStuNumNotBetween(Short value1, Short value2) {
            addCriterion("class_plan_stu_num not between", value1, value2, "classPlanStuNum");
            return (Criteria) this;
        }

        public Criteria andClassStuNumIsNull() {
            addCriterion("class_stu_num is null");
            return (Criteria) this;
        }

        public Criteria andClassStuNumIsNotNull() {
            addCriterion("class_stu_num is not null");
            return (Criteria) this;
        }

        public Criteria andClassStuNumEqualTo(Short value) {
            addCriterion("class_stu_num =", value, "classStuNum");
            return (Criteria) this;
        }

        public Criteria andClassStuNumNotEqualTo(Short value) {
            addCriterion("class_stu_num <>", value, "classStuNum");
            return (Criteria) this;
        }

        public Criteria andClassStuNumGreaterThan(Short value) {
            addCriterion("class_stu_num >", value, "classStuNum");
            return (Criteria) this;
        }

        public Criteria andClassStuNumGreaterThanOrEqualTo(Short value) {
            addCriterion("class_stu_num >=", value, "classStuNum");
            return (Criteria) this;
        }

        public Criteria andClassStuNumLessThan(Short value) {
            addCriterion("class_stu_num <", value, "classStuNum");
            return (Criteria) this;
        }

        public Criteria andClassStuNumLessThanOrEqualTo(Short value) {
            addCriterion("class_stu_num <=", value, "classStuNum");
            return (Criteria) this;
        }

        public Criteria andClassStuNumIn(List<Short> values) {
            addCriterion("class_stu_num in", values, "classStuNum");
            return (Criteria) this;
        }

        public Criteria andClassStuNumNotIn(List<Short> values) {
            addCriterion("class_stu_num not in", values, "classStuNum");
            return (Criteria) this;
        }

        public Criteria andClassStuNumBetween(Short value1, Short value2) {
            addCriterion("class_stu_num between", value1, value2, "classStuNum");
            return (Criteria) this;
        }

        public Criteria andClassStuNumNotBetween(Short value1, Short value2) {
            addCriterion("class_stu_num not between", value1, value2, "classStuNum");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andClassTypeIsNull() {
            addCriterion("class_type is null");
            return (Criteria) this;
        }

        public Criteria andClassTypeIsNotNull() {
            addCriterion("class_type is not null");
            return (Criteria) this;
        }

        public Criteria andClassTypeEqualTo(String value) {
            addCriterion("class_type =", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeNotEqualTo(String value) {
            addCriterion("class_type <>", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeGreaterThan(String value) {
            addCriterion("class_type >", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeGreaterThanOrEqualTo(String value) {
            addCriterion("class_type >=", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeLessThan(String value) {
            addCriterion("class_type <", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeLessThanOrEqualTo(String value) {
            addCriterion("class_type <=", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeLike(String value) {
            addCriterion("class_type like", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeNotLike(String value) {
            addCriterion("class_type not like", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeIn(List<String> values) {
            addCriterion("class_type in", values, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeNotIn(List<String> values) {
            addCriterion("class_type not in", values, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeBetween(String value1, String value2) {
            addCriterion("class_type between", value1, value2, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeNotBetween(String value1, String value2) {
            addCriterion("class_type not between", value1, value2, "classType");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomIdIsNull() {
            addCriterion("key_classroom_id is null");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomIdIsNotNull() {
            addCriterion("key_classroom_id is not null");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomIdEqualTo(Long value) {
            addCriterion("key_classroom_id =", value, "keyClassroomId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomIdNotEqualTo(Long value) {
            addCriterion("key_classroom_id <>", value, "keyClassroomId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomIdGreaterThan(Long value) {
            addCriterion("key_classroom_id >", value, "keyClassroomId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomIdGreaterThanOrEqualTo(Long value) {
            addCriterion("key_classroom_id >=", value, "keyClassroomId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomIdLessThan(Long value) {
            addCriterion("key_classroom_id <", value, "keyClassroomId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomIdLessThanOrEqualTo(Long value) {
            addCriterion("key_classroom_id <=", value, "keyClassroomId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomIdIn(List<Long> values) {
            addCriterion("key_classroom_id in", values, "keyClassroomId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomIdNotIn(List<Long> values) {
            addCriterion("key_classroom_id not in", values, "keyClassroomId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomIdBetween(Long value1, Long value2) {
            addCriterion("key_classroom_id between", value1, value2, "keyClassroomId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomIdNotBetween(Long value1, Long value2) {
            addCriterion("key_classroom_id not between", value1, value2, "keyClassroomId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomNameIsNull() {
            addCriterion("key_classroom_name is null");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomNameIsNotNull() {
            addCriterion("key_classroom_name is not null");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomNameEqualTo(String value) {
            addCriterion("key_classroom_name =", value, "keyClassroomName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomNameNotEqualTo(String value) {
            addCriterion("key_classroom_name <>", value, "keyClassroomName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomNameGreaterThan(String value) {
            addCriterion("key_classroom_name >", value, "keyClassroomName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomNameGreaterThanOrEqualTo(String value) {
            addCriterion("key_classroom_name >=", value, "keyClassroomName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomNameLessThan(String value) {
            addCriterion("key_classroom_name <", value, "keyClassroomName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomNameLessThanOrEqualTo(String value) {
            addCriterion("key_classroom_name <=", value, "keyClassroomName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomNameLike(String value) {
            addCriterion("key_classroom_name like", value, "keyClassroomName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomNameNotLike(String value) {
            addCriterion("key_classroom_name not like", value, "keyClassroomName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomNameIn(List<String> values) {
            addCriterion("key_classroom_name in", values, "keyClassroomName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomNameNotIn(List<String> values) {
            addCriterion("key_classroom_name not in", values, "keyClassroomName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomNameBetween(String value1, String value2) {
            addCriterion("key_classroom_name between", value1, value2, "keyClassroomName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomNameNotBetween(String value1, String value2) {
            addCriterion("key_classroom_name not between", value1, value2, "keyClassroomName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingIdIsNull() {
            addCriterion("key_classroom_bulding_id is null");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingIdIsNotNull() {
            addCriterion("key_classroom_bulding_id is not null");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingIdEqualTo(Long value) {
            addCriterion("key_classroom_bulding_id =", value, "keyClassroomBuldingId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingIdNotEqualTo(Long value) {
            addCriterion("key_classroom_bulding_id <>", value, "keyClassroomBuldingId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingIdGreaterThan(Long value) {
            addCriterion("key_classroom_bulding_id >", value, "keyClassroomBuldingId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingIdGreaterThanOrEqualTo(Long value) {
            addCriterion("key_classroom_bulding_id >=", value, "keyClassroomBuldingId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingIdLessThan(Long value) {
            addCriterion("key_classroom_bulding_id <", value, "keyClassroomBuldingId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingIdLessThanOrEqualTo(Long value) {
            addCriterion("key_classroom_bulding_id <=", value, "keyClassroomBuldingId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingIdIn(List<Long> values) {
            addCriterion("key_classroom_bulding_id in", values, "keyClassroomBuldingId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingIdNotIn(List<Long> values) {
            addCriterion("key_classroom_bulding_id not in", values, "keyClassroomBuldingId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingIdBetween(Long value1, Long value2) {
            addCriterion("key_classroom_bulding_id between", value1, value2, "keyClassroomBuldingId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingIdNotBetween(Long value1, Long value2) {
            addCriterion("key_classroom_bulding_id not between", value1, value2, "keyClassroomBuldingId");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingNameIsNull() {
            addCriterion("key_classroom_bulding_name is null");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingNameIsNotNull() {
            addCriterion("key_classroom_bulding_name is not null");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingNameEqualTo(String value) {
            addCriterion("key_classroom_bulding_name =", value, "keyClassroomBuldingName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingNameNotEqualTo(String value) {
            addCriterion("key_classroom_bulding_name <>", value, "keyClassroomBuldingName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingNameGreaterThan(String value) {
            addCriterion("key_classroom_bulding_name >", value, "keyClassroomBuldingName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingNameGreaterThanOrEqualTo(String value) {
            addCriterion("key_classroom_bulding_name >=", value, "keyClassroomBuldingName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingNameLessThan(String value) {
            addCriterion("key_classroom_bulding_name <", value, "keyClassroomBuldingName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingNameLessThanOrEqualTo(String value) {
            addCriterion("key_classroom_bulding_name <=", value, "keyClassroomBuldingName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingNameLike(String value) {
            addCriterion("key_classroom_bulding_name like", value, "keyClassroomBuldingName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingNameNotLike(String value) {
            addCriterion("key_classroom_bulding_name not like", value, "keyClassroomBuldingName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingNameIn(List<String> values) {
            addCriterion("key_classroom_bulding_name in", values, "keyClassroomBuldingName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingNameNotIn(List<String> values) {
            addCriterion("key_classroom_bulding_name not in", values, "keyClassroomBuldingName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingNameBetween(String value1, String value2) {
            addCriterion("key_classroom_bulding_name between", value1, value2, "keyClassroomBuldingName");
            return (Criteria) this;
        }

        public Criteria andKeyClassroomBuldingNameNotBetween(String value1, String value2) {
            addCriterion("key_classroom_bulding_name not between", value1, value2, "keyClassroomBuldingName");
            return (Criteria) this;
        }

        public Criteria andTeacher1IdIsNull() {
            addCriterion("teacher1_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacher1IdIsNotNull() {
            addCriterion("teacher1_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacher1IdEqualTo(Long value) {
            addCriterion("teacher1_id =", value, "teacher1Id");
            return (Criteria) this;
        }

        public Criteria andTeacher1IdNotEqualTo(Long value) {
            addCriterion("teacher1_id <>", value, "teacher1Id");
            return (Criteria) this;
        }

        public Criteria andTeacher1IdGreaterThan(Long value) {
            addCriterion("teacher1_id >", value, "teacher1Id");
            return (Criteria) this;
        }

        public Criteria andTeacher1IdGreaterThanOrEqualTo(Long value) {
            addCriterion("teacher1_id >=", value, "teacher1Id");
            return (Criteria) this;
        }

        public Criteria andTeacher1IdLessThan(Long value) {
            addCriterion("teacher1_id <", value, "teacher1Id");
            return (Criteria) this;
        }

        public Criteria andTeacher1IdLessThanOrEqualTo(Long value) {
            addCriterion("teacher1_id <=", value, "teacher1Id");
            return (Criteria) this;
        }

        public Criteria andTeacher1IdIn(List<Long> values) {
            addCriterion("teacher1_id in", values, "teacher1Id");
            return (Criteria) this;
        }

        public Criteria andTeacher1IdNotIn(List<Long> values) {
            addCriterion("teacher1_id not in", values, "teacher1Id");
            return (Criteria) this;
        }

        public Criteria andTeacher1IdBetween(Long value1, Long value2) {
            addCriterion("teacher1_id between", value1, value2, "teacher1Id");
            return (Criteria) this;
        }

        public Criteria andTeacher1IdNotBetween(Long value1, Long value2) {
            addCriterion("teacher1_id not between", value1, value2, "teacher1Id");
            return (Criteria) this;
        }

        public Criteria andTeacher1NameIsNull() {
            addCriterion("teacher1_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacher1NameIsNotNull() {
            addCriterion("teacher1_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacher1NameEqualTo(String value) {
            addCriterion("teacher1_name =", value, "teacher1Name");
            return (Criteria) this;
        }

        public Criteria andTeacher1NameNotEqualTo(String value) {
            addCriterion("teacher1_name <>", value, "teacher1Name");
            return (Criteria) this;
        }

        public Criteria andTeacher1NameGreaterThan(String value) {
            addCriterion("teacher1_name >", value, "teacher1Name");
            return (Criteria) this;
        }

        public Criteria andTeacher1NameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher1_name >=", value, "teacher1Name");
            return (Criteria) this;
        }

        public Criteria andTeacher1NameLessThan(String value) {
            addCriterion("teacher1_name <", value, "teacher1Name");
            return (Criteria) this;
        }

        public Criteria andTeacher1NameLessThanOrEqualTo(String value) {
            addCriterion("teacher1_name <=", value, "teacher1Name");
            return (Criteria) this;
        }

        public Criteria andTeacher1NameLike(String value) {
            addCriterion("teacher1_name like", value, "teacher1Name");
            return (Criteria) this;
        }

        public Criteria andTeacher1NameNotLike(String value) {
            addCriterion("teacher1_name not like", value, "teacher1Name");
            return (Criteria) this;
        }

        public Criteria andTeacher1NameIn(List<String> values) {
            addCriterion("teacher1_name in", values, "teacher1Name");
            return (Criteria) this;
        }

        public Criteria andTeacher1NameNotIn(List<String> values) {
            addCriterion("teacher1_name not in", values, "teacher1Name");
            return (Criteria) this;
        }

        public Criteria andTeacher1NameBetween(String value1, String value2) {
            addCriterion("teacher1_name between", value1, value2, "teacher1Name");
            return (Criteria) this;
        }

        public Criteria andTeacher1NameNotBetween(String value1, String value2) {
            addCriterion("teacher1_name not between", value1, value2, "teacher1Name");
            return (Criteria) this;
        }

        public Criteria andTeacher2IdIsNull() {
            addCriterion("teacher2_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacher2IdIsNotNull() {
            addCriterion("teacher2_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacher2IdEqualTo(Long value) {
            addCriterion("teacher2_id =", value, "teacher2Id");
            return (Criteria) this;
        }

        public Criteria andTeacher2IdNotEqualTo(Long value) {
            addCriterion("teacher2_id <>", value, "teacher2Id");
            return (Criteria) this;
        }

        public Criteria andTeacher2IdGreaterThan(Long value) {
            addCriterion("teacher2_id >", value, "teacher2Id");
            return (Criteria) this;
        }

        public Criteria andTeacher2IdGreaterThanOrEqualTo(Long value) {
            addCriterion("teacher2_id >=", value, "teacher2Id");
            return (Criteria) this;
        }

        public Criteria andTeacher2IdLessThan(Long value) {
            addCriterion("teacher2_id <", value, "teacher2Id");
            return (Criteria) this;
        }

        public Criteria andTeacher2IdLessThanOrEqualTo(Long value) {
            addCriterion("teacher2_id <=", value, "teacher2Id");
            return (Criteria) this;
        }

        public Criteria andTeacher2IdIn(List<Long> values) {
            addCriterion("teacher2_id in", values, "teacher2Id");
            return (Criteria) this;
        }

        public Criteria andTeacher2IdNotIn(List<Long> values) {
            addCriterion("teacher2_id not in", values, "teacher2Id");
            return (Criteria) this;
        }

        public Criteria andTeacher2IdBetween(Long value1, Long value2) {
            addCriterion("teacher2_id between", value1, value2, "teacher2Id");
            return (Criteria) this;
        }

        public Criteria andTeacher2IdNotBetween(Long value1, Long value2) {
            addCriterion("teacher2_id not between", value1, value2, "teacher2Id");
            return (Criteria) this;
        }

        public Criteria andTeacher2NameIsNull() {
            addCriterion("teacher2_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacher2NameIsNotNull() {
            addCriterion("teacher2_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacher2NameEqualTo(String value) {
            addCriterion("teacher2_name =", value, "teacher2Name");
            return (Criteria) this;
        }

        public Criteria andTeacher2NameNotEqualTo(String value) {
            addCriterion("teacher2_name <>", value, "teacher2Name");
            return (Criteria) this;
        }

        public Criteria andTeacher2NameGreaterThan(String value) {
            addCriterion("teacher2_name >", value, "teacher2Name");
            return (Criteria) this;
        }

        public Criteria andTeacher2NameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher2_name >=", value, "teacher2Name");
            return (Criteria) this;
        }

        public Criteria andTeacher2NameLessThan(String value) {
            addCriterion("teacher2_name <", value, "teacher2Name");
            return (Criteria) this;
        }

        public Criteria andTeacher2NameLessThanOrEqualTo(String value) {
            addCriterion("teacher2_name <=", value, "teacher2Name");
            return (Criteria) this;
        }

        public Criteria andTeacher2NameLike(String value) {
            addCriterion("teacher2_name like", value, "teacher2Name");
            return (Criteria) this;
        }

        public Criteria andTeacher2NameNotLike(String value) {
            addCriterion("teacher2_name not like", value, "teacher2Name");
            return (Criteria) this;
        }

        public Criteria andTeacher2NameIn(List<String> values) {
            addCriterion("teacher2_name in", values, "teacher2Name");
            return (Criteria) this;
        }

        public Criteria andTeacher2NameNotIn(List<String> values) {
            addCriterion("teacher2_name not in", values, "teacher2Name");
            return (Criteria) this;
        }

        public Criteria andTeacher2NameBetween(String value1, String value2) {
            addCriterion("teacher2_name between", value1, value2, "teacher2Name");
            return (Criteria) this;
        }

        public Criteria andTeacher2NameNotBetween(String value1, String value2) {
            addCriterion("teacher2_name not between", value1, value2, "teacher2Name");
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