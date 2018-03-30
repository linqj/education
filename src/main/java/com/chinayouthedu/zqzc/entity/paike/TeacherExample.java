package com.chinayouthedu.zqzc.entity.paike;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TeacherExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public TeacherExample() {
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

        public Criteria andTeacherGenderIsNull() {
            addCriterion("teacher_gender is null");
            return (Criteria) this;
        }

        public Criteria andTeacherGenderIsNotNull() {
            addCriterion("teacher_gender is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherGenderEqualTo(String value) {
            addCriterion("teacher_gender =", value, "teacherGender");
            return (Criteria) this;
        }

        public Criteria andTeacherGenderNotEqualTo(String value) {
            addCriterion("teacher_gender <>", value, "teacherGender");
            return (Criteria) this;
        }

        public Criteria andTeacherGenderGreaterThan(String value) {
            addCriterion("teacher_gender >", value, "teacherGender");
            return (Criteria) this;
        }

        public Criteria andTeacherGenderGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_gender >=", value, "teacherGender");
            return (Criteria) this;
        }

        public Criteria andTeacherGenderLessThan(String value) {
            addCriterion("teacher_gender <", value, "teacherGender");
            return (Criteria) this;
        }

        public Criteria andTeacherGenderLessThanOrEqualTo(String value) {
            addCriterion("teacher_gender <=", value, "teacherGender");
            return (Criteria) this;
        }

        public Criteria andTeacherGenderLike(String value) {
            addCriterion("teacher_gender like", value, "teacherGender");
            return (Criteria) this;
        }

        public Criteria andTeacherGenderNotLike(String value) {
            addCriterion("teacher_gender not like", value, "teacherGender");
            return (Criteria) this;
        }

        public Criteria andTeacherGenderIn(List<String> values) {
            addCriterion("teacher_gender in", values, "teacherGender");
            return (Criteria) this;
        }

        public Criteria andTeacherGenderNotIn(List<String> values) {
            addCriterion("teacher_gender not in", values, "teacherGender");
            return (Criteria) this;
        }

        public Criteria andTeacherGenderBetween(String value1, String value2) {
            addCriterion("teacher_gender between", value1, value2, "teacherGender");
            return (Criteria) this;
        }

        public Criteria andTeacherGenderNotBetween(String value1, String value2) {
            addCriterion("teacher_gender not between", value1, value2, "teacherGender");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayIsNull() {
            addCriterion("teacher_birthday is null");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayIsNotNull() {
            addCriterion("teacher_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_birthday =", value, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_birthday <>", value, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("teacher_birthday >", value, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_birthday >=", value, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("teacher_birthday <", value, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_birthday <=", value, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("teacher_birthday in", values, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("teacher_birthday not in", values, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("teacher_birthday between", value1, value2, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("teacher_birthday not between", value1, value2, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneIsNull() {
            addCriterion("teacher_phone is null");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneIsNotNull() {
            addCriterion("teacher_phone is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneEqualTo(String value) {
            addCriterion("teacher_phone =", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotEqualTo(String value) {
            addCriterion("teacher_phone <>", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneGreaterThan(String value) {
            addCriterion("teacher_phone >", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_phone >=", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneLessThan(String value) {
            addCriterion("teacher_phone <", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneLessThanOrEqualTo(String value) {
            addCriterion("teacher_phone <=", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneLike(String value) {
            addCriterion("teacher_phone like", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotLike(String value) {
            addCriterion("teacher_phone not like", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneIn(List<String> values) {
            addCriterion("teacher_phone in", values, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotIn(List<String> values) {
            addCriterion("teacher_phone not in", values, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneBetween(String value1, String value2) {
            addCriterion("teacher_phone between", value1, value2, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotBetween(String value1, String value2) {
            addCriterion("teacher_phone not between", value1, value2, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailIsNull() {
            addCriterion("teacher_email is null");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailIsNotNull() {
            addCriterion("teacher_email is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailEqualTo(String value) {
            addCriterion("teacher_email =", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailNotEqualTo(String value) {
            addCriterion("teacher_email <>", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailGreaterThan(String value) {
            addCriterion("teacher_email >", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_email >=", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailLessThan(String value) {
            addCriterion("teacher_email <", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailLessThanOrEqualTo(String value) {
            addCriterion("teacher_email <=", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailLike(String value) {
            addCriterion("teacher_email like", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailNotLike(String value) {
            addCriterion("teacher_email not like", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailIn(List<String> values) {
            addCriterion("teacher_email in", values, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailNotIn(List<String> values) {
            addCriterion("teacher_email not in", values, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailBetween(String value1, String value2) {
            addCriterion("teacher_email between", value1, value2, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailNotBetween(String value1, String value2) {
            addCriterion("teacher_email not between", value1, value2, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherIdcardIsNull() {
            addCriterion("teacher_idcard is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdcardIsNotNull() {
            addCriterion("teacher_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdcardEqualTo(String value) {
            addCriterion("teacher_idcard =", value, "teacherIdcard");
            return (Criteria) this;
        }

        public Criteria andTeacherIdcardNotEqualTo(String value) {
            addCriterion("teacher_idcard <>", value, "teacherIdcard");
            return (Criteria) this;
        }

        public Criteria andTeacherIdcardGreaterThan(String value) {
            addCriterion("teacher_idcard >", value, "teacherIdcard");
            return (Criteria) this;
        }

        public Criteria andTeacherIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_idcard >=", value, "teacherIdcard");
            return (Criteria) this;
        }

        public Criteria andTeacherIdcardLessThan(String value) {
            addCriterion("teacher_idcard <", value, "teacherIdcard");
            return (Criteria) this;
        }

        public Criteria andTeacherIdcardLessThanOrEqualTo(String value) {
            addCriterion("teacher_idcard <=", value, "teacherIdcard");
            return (Criteria) this;
        }

        public Criteria andTeacherIdcardLike(String value) {
            addCriterion("teacher_idcard like", value, "teacherIdcard");
            return (Criteria) this;
        }

        public Criteria andTeacherIdcardNotLike(String value) {
            addCriterion("teacher_idcard not like", value, "teacherIdcard");
            return (Criteria) this;
        }

        public Criteria andTeacherIdcardIn(List<String> values) {
            addCriterion("teacher_idcard in", values, "teacherIdcard");
            return (Criteria) this;
        }

        public Criteria andTeacherIdcardNotIn(List<String> values) {
            addCriterion("teacher_idcard not in", values, "teacherIdcard");
            return (Criteria) this;
        }

        public Criteria andTeacherIdcardBetween(String value1, String value2) {
            addCriterion("teacher_idcard between", value1, value2, "teacherIdcard");
            return (Criteria) this;
        }

        public Criteria andTeacherIdcardNotBetween(String value1, String value2) {
            addCriterion("teacher_idcard not between", value1, value2, "teacherIdcard");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberIsNull() {
            addCriterion("teacher_number is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberIsNotNull() {
            addCriterion("teacher_number is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberEqualTo(String value) {
            addCriterion("teacher_number =", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberNotEqualTo(String value) {
            addCriterion("teacher_number <>", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberGreaterThan(String value) {
            addCriterion("teacher_number >", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_number >=", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberLessThan(String value) {
            addCriterion("teacher_number <", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberLessThanOrEqualTo(String value) {
            addCriterion("teacher_number <=", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberLike(String value) {
            addCriterion("teacher_number like", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberNotLike(String value) {
            addCriterion("teacher_number not like", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberIn(List<String> values) {
            addCriterion("teacher_number in", values, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberNotIn(List<String> values) {
            addCriterion("teacher_number not in", values, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberBetween(String value1, String value2) {
            addCriterion("teacher_number between", value1, value2, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberNotBetween(String value1, String value2) {
            addCriterion("teacher_number not between", value1, value2, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeIsNull() {
            addCriterion("teacher_degree is null");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeIsNotNull() {
            addCriterion("teacher_degree is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeEqualTo(String value) {
            addCriterion("teacher_degree =", value, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeNotEqualTo(String value) {
            addCriterion("teacher_degree <>", value, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeGreaterThan(String value) {
            addCriterion("teacher_degree >", value, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_degree >=", value, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeLessThan(String value) {
            addCriterion("teacher_degree <", value, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeLessThanOrEqualTo(String value) {
            addCriterion("teacher_degree <=", value, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeLike(String value) {
            addCriterion("teacher_degree like", value, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeNotLike(String value) {
            addCriterion("teacher_degree not like", value, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeIn(List<String> values) {
            addCriterion("teacher_degree in", values, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeNotIn(List<String> values) {
            addCriterion("teacher_degree not in", values, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeBetween(String value1, String value2) {
            addCriterion("teacher_degree between", value1, value2, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeNotBetween(String value1, String value2) {
            addCriterion("teacher_degree not between", value1, value2, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherPropertyIsNull() {
            addCriterion("teacher_property is null");
            return (Criteria) this;
        }

        public Criteria andTeacherPropertyIsNotNull() {
            addCriterion("teacher_property is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherPropertyEqualTo(String value) {
            addCriterion("teacher_property =", value, "teacherProperty");
            return (Criteria) this;
        }

        public Criteria andTeacherPropertyNotEqualTo(String value) {
            addCriterion("teacher_property <>", value, "teacherProperty");
            return (Criteria) this;
        }

        public Criteria andTeacherPropertyGreaterThan(String value) {
            addCriterion("teacher_property >", value, "teacherProperty");
            return (Criteria) this;
        }

        public Criteria andTeacherPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_property >=", value, "teacherProperty");
            return (Criteria) this;
        }

        public Criteria andTeacherPropertyLessThan(String value) {
            addCriterion("teacher_property <", value, "teacherProperty");
            return (Criteria) this;
        }

        public Criteria andTeacherPropertyLessThanOrEqualTo(String value) {
            addCriterion("teacher_property <=", value, "teacherProperty");
            return (Criteria) this;
        }

        public Criteria andTeacherPropertyLike(String value) {
            addCriterion("teacher_property like", value, "teacherProperty");
            return (Criteria) this;
        }

        public Criteria andTeacherPropertyNotLike(String value) {
            addCriterion("teacher_property not like", value, "teacherProperty");
            return (Criteria) this;
        }

        public Criteria andTeacherPropertyIn(List<String> values) {
            addCriterion("teacher_property in", values, "teacherProperty");
            return (Criteria) this;
        }

        public Criteria andTeacherPropertyNotIn(List<String> values) {
            addCriterion("teacher_property not in", values, "teacherProperty");
            return (Criteria) this;
        }

        public Criteria andTeacherPropertyBetween(String value1, String value2) {
            addCriterion("teacher_property between", value1, value2, "teacherProperty");
            return (Criteria) this;
        }

        public Criteria andTeacherPropertyNotBetween(String value1, String value2) {
            addCriterion("teacher_property not between", value1, value2, "teacherProperty");
            return (Criteria) this;
        }

        public Criteria andTeacherLevelIsNull() {
            addCriterion("teacher_level is null");
            return (Criteria) this;
        }

        public Criteria andTeacherLevelIsNotNull() {
            addCriterion("teacher_level is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherLevelEqualTo(String value) {
            addCriterion("teacher_level =", value, "teacherLevel");
            return (Criteria) this;
        }

        public Criteria andTeacherLevelNotEqualTo(String value) {
            addCriterion("teacher_level <>", value, "teacherLevel");
            return (Criteria) this;
        }

        public Criteria andTeacherLevelGreaterThan(String value) {
            addCriterion("teacher_level >", value, "teacherLevel");
            return (Criteria) this;
        }

        public Criteria andTeacherLevelGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_level >=", value, "teacherLevel");
            return (Criteria) this;
        }

        public Criteria andTeacherLevelLessThan(String value) {
            addCriterion("teacher_level <", value, "teacherLevel");
            return (Criteria) this;
        }

        public Criteria andTeacherLevelLessThanOrEqualTo(String value) {
            addCriterion("teacher_level <=", value, "teacherLevel");
            return (Criteria) this;
        }

        public Criteria andTeacherLevelLike(String value) {
            addCriterion("teacher_level like", value, "teacherLevel");
            return (Criteria) this;
        }

        public Criteria andTeacherLevelNotLike(String value) {
            addCriterion("teacher_level not like", value, "teacherLevel");
            return (Criteria) this;
        }

        public Criteria andTeacherLevelIn(List<String> values) {
            addCriterion("teacher_level in", values, "teacherLevel");
            return (Criteria) this;
        }

        public Criteria andTeacherLevelNotIn(List<String> values) {
            addCriterion("teacher_level not in", values, "teacherLevel");
            return (Criteria) this;
        }

        public Criteria andTeacherLevelBetween(String value1, String value2) {
            addCriterion("teacher_level between", value1, value2, "teacherLevel");
            return (Criteria) this;
        }

        public Criteria andTeacherLevelNotBetween(String value1, String value2) {
            addCriterion("teacher_level not between", value1, value2, "teacherLevel");
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

        public Criteria andTeacherStartTimeIsNull() {
            addCriterion("teacher_start_time is null");
            return (Criteria) this;
        }

        public Criteria andTeacherStartTimeIsNotNull() {
            addCriterion("teacher_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_start_time =", value, "teacherStartTime");
            return (Criteria) this;
        }

        public Criteria andTeacherStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_start_time <>", value, "teacherStartTime");
            return (Criteria) this;
        }

        public Criteria andTeacherStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("teacher_start_time >", value, "teacherStartTime");
            return (Criteria) this;
        }

        public Criteria andTeacherStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_start_time >=", value, "teacherStartTime");
            return (Criteria) this;
        }

        public Criteria andTeacherStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("teacher_start_time <", value, "teacherStartTime");
            return (Criteria) this;
        }

        public Criteria andTeacherStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_start_time <=", value, "teacherStartTime");
            return (Criteria) this;
        }

        public Criteria andTeacherStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("teacher_start_time in", values, "teacherStartTime");
            return (Criteria) this;
        }

        public Criteria andTeacherStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("teacher_start_time not in", values, "teacherStartTime");
            return (Criteria) this;
        }

        public Criteria andTeacherStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("teacher_start_time between", value1, value2, "teacherStartTime");
            return (Criteria) this;
        }

        public Criteria andTeacherStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("teacher_start_time not between", value1, value2, "teacherStartTime");
            return (Criteria) this;
        }

        public Criteria andTeacherEndTimeIsNull() {
            addCriterion("teacher_end_time is null");
            return (Criteria) this;
        }

        public Criteria andTeacherEndTimeIsNotNull() {
            addCriterion("teacher_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_end_time =", value, "teacherEndTime");
            return (Criteria) this;
        }

        public Criteria andTeacherEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_end_time <>", value, "teacherEndTime");
            return (Criteria) this;
        }

        public Criteria andTeacherEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("teacher_end_time >", value, "teacherEndTime");
            return (Criteria) this;
        }

        public Criteria andTeacherEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_end_time >=", value, "teacherEndTime");
            return (Criteria) this;
        }

        public Criteria andTeacherEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("teacher_end_time <", value, "teacherEndTime");
            return (Criteria) this;
        }

        public Criteria andTeacherEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_end_time <=", value, "teacherEndTime");
            return (Criteria) this;
        }

        public Criteria andTeacherEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("teacher_end_time in", values, "teacherEndTime");
            return (Criteria) this;
        }

        public Criteria andTeacherEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("teacher_end_time not in", values, "teacherEndTime");
            return (Criteria) this;
        }

        public Criteria andTeacherEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("teacher_end_time between", value1, value2, "teacherEndTime");
            return (Criteria) this;
        }

        public Criteria andTeacherEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("teacher_end_time not between", value1, value2, "teacherEndTime");
            return (Criteria) this;
        }

        public Criteria andTeacherLiveAddressIsNull() {
            addCriterion("teacher_live_address is null");
            return (Criteria) this;
        }

        public Criteria andTeacherLiveAddressIsNotNull() {
            addCriterion("teacher_live_address is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherLiveAddressEqualTo(String value) {
            addCriterion("teacher_live_address =", value, "teacherLiveAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherLiveAddressNotEqualTo(String value) {
            addCriterion("teacher_live_address <>", value, "teacherLiveAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherLiveAddressGreaterThan(String value) {
            addCriterion("teacher_live_address >", value, "teacherLiveAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherLiveAddressGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_live_address >=", value, "teacherLiveAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherLiveAddressLessThan(String value) {
            addCriterion("teacher_live_address <", value, "teacherLiveAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherLiveAddressLessThanOrEqualTo(String value) {
            addCriterion("teacher_live_address <=", value, "teacherLiveAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherLiveAddressLike(String value) {
            addCriterion("teacher_live_address like", value, "teacherLiveAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherLiveAddressNotLike(String value) {
            addCriterion("teacher_live_address not like", value, "teacherLiveAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherLiveAddressIn(List<String> values) {
            addCriterion("teacher_live_address in", values, "teacherLiveAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherLiveAddressNotIn(List<String> values) {
            addCriterion("teacher_live_address not in", values, "teacherLiveAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherLiveAddressBetween(String value1, String value2) {
            addCriterion("teacher_live_address between", value1, value2, "teacherLiveAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherLiveAddressNotBetween(String value1, String value2) {
            addCriterion("teacher_live_address not between", value1, value2, "teacherLiveAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherHomeAddressIsNull() {
            addCriterion("teacher_home_address is null");
            return (Criteria) this;
        }

        public Criteria andTeacherHomeAddressIsNotNull() {
            addCriterion("teacher_home_address is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherHomeAddressEqualTo(String value) {
            addCriterion("teacher_home_address =", value, "teacherHomeAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherHomeAddressNotEqualTo(String value) {
            addCriterion("teacher_home_address <>", value, "teacherHomeAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherHomeAddressGreaterThan(String value) {
            addCriterion("teacher_home_address >", value, "teacherHomeAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherHomeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_home_address >=", value, "teacherHomeAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherHomeAddressLessThan(String value) {
            addCriterion("teacher_home_address <", value, "teacherHomeAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherHomeAddressLessThanOrEqualTo(String value) {
            addCriterion("teacher_home_address <=", value, "teacherHomeAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherHomeAddressLike(String value) {
            addCriterion("teacher_home_address like", value, "teacherHomeAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherHomeAddressNotLike(String value) {
            addCriterion("teacher_home_address not like", value, "teacherHomeAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherHomeAddressIn(List<String> values) {
            addCriterion("teacher_home_address in", values, "teacherHomeAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherHomeAddressNotIn(List<String> values) {
            addCriterion("teacher_home_address not in", values, "teacherHomeAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherHomeAddressBetween(String value1, String value2) {
            addCriterion("teacher_home_address between", value1, value2, "teacherHomeAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherHomeAddressNotBetween(String value1, String value2) {
            addCriterion("teacher_home_address not between", value1, value2, "teacherHomeAddress");
            return (Criteria) this;
        }

        public Criteria andIsLeaderIsNull() {
            addCriterion("is_leader is null");
            return (Criteria) this;
        }

        public Criteria andIsLeaderIsNotNull() {
            addCriterion("is_leader is not null");
            return (Criteria) this;
        }

        public Criteria andIsLeaderEqualTo(Boolean value) {
            addCriterion("is_leader =", value, "isLeader");
            return (Criteria) this;
        }

        public Criteria andIsLeaderNotEqualTo(Boolean value) {
            addCriterion("is_leader <>", value, "isLeader");
            return (Criteria) this;
        }

        public Criteria andIsLeaderGreaterThan(Boolean value) {
            addCriterion("is_leader >", value, "isLeader");
            return (Criteria) this;
        }

        public Criteria andIsLeaderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_leader >=", value, "isLeader");
            return (Criteria) this;
        }

        public Criteria andIsLeaderLessThan(Boolean value) {
            addCriterion("is_leader <", value, "isLeader");
            return (Criteria) this;
        }

        public Criteria andIsLeaderLessThanOrEqualTo(Boolean value) {
            addCriterion("is_leader <=", value, "isLeader");
            return (Criteria) this;
        }

        public Criteria andIsLeaderIn(List<Boolean> values) {
            addCriterion("is_leader in", values, "isLeader");
            return (Criteria) this;
        }

        public Criteria andIsLeaderNotIn(List<Boolean> values) {
            addCriterion("is_leader not in", values, "isLeader");
            return (Criteria) this;
        }

        public Criteria andIsLeaderBetween(Boolean value1, Boolean value2) {
            addCriterion("is_leader between", value1, value2, "isLeader");
            return (Criteria) this;
        }

        public Criteria andIsLeaderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_leader not between", value1, value2, "isLeader");
            return (Criteria) this;
        }

        public Criteria andIsLeaderTwoIsNull() {
            addCriterion("is_leader_two is null");
            return (Criteria) this;
        }

        public Criteria andIsLeaderTwoIsNotNull() {
            addCriterion("is_leader_two is not null");
            return (Criteria) this;
        }

        public Criteria andIsLeaderTwoEqualTo(Boolean value) {
            addCriterion("is_leader_two =", value, "isLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andIsLeaderTwoNotEqualTo(Boolean value) {
            addCriterion("is_leader_two <>", value, "isLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andIsLeaderTwoGreaterThan(Boolean value) {
            addCriterion("is_leader_two >", value, "isLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andIsLeaderTwoGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_leader_two >=", value, "isLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andIsLeaderTwoLessThan(Boolean value) {
            addCriterion("is_leader_two <", value, "isLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andIsLeaderTwoLessThanOrEqualTo(Boolean value) {
            addCriterion("is_leader_two <=", value, "isLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andIsLeaderTwoIn(List<Boolean> values) {
            addCriterion("is_leader_two in", values, "isLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andIsLeaderTwoNotIn(List<Boolean> values) {
            addCriterion("is_leader_two not in", values, "isLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andIsLeaderTwoBetween(Boolean value1, Boolean value2) {
            addCriterion("is_leader_two between", value1, value2, "isLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andIsLeaderTwoNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_leader_two not between", value1, value2, "isLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andIsClassManagerIsNull() {
            addCriterion("is_class_manager is null");
            return (Criteria) this;
        }

        public Criteria andIsClassManagerIsNotNull() {
            addCriterion("is_class_manager is not null");
            return (Criteria) this;
        }

        public Criteria andIsClassManagerEqualTo(Boolean value) {
            addCriterion("is_class_manager =", value, "isClassManager");
            return (Criteria) this;
        }

        public Criteria andIsClassManagerNotEqualTo(Boolean value) {
            addCriterion("is_class_manager <>", value, "isClassManager");
            return (Criteria) this;
        }

        public Criteria andIsClassManagerGreaterThan(Boolean value) {
            addCriterion("is_class_manager >", value, "isClassManager");
            return (Criteria) this;
        }

        public Criteria andIsClassManagerGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_class_manager >=", value, "isClassManager");
            return (Criteria) this;
        }

        public Criteria andIsClassManagerLessThan(Boolean value) {
            addCriterion("is_class_manager <", value, "isClassManager");
            return (Criteria) this;
        }

        public Criteria andIsClassManagerLessThanOrEqualTo(Boolean value) {
            addCriterion("is_class_manager <=", value, "isClassManager");
            return (Criteria) this;
        }

        public Criteria andIsClassManagerIn(List<Boolean> values) {
            addCriterion("is_class_manager in", values, "isClassManager");
            return (Criteria) this;
        }

        public Criteria andIsClassManagerNotIn(List<Boolean> values) {
            addCriterion("is_class_manager not in", values, "isClassManager");
            return (Criteria) this;
        }

        public Criteria andIsClassManagerBetween(Boolean value1, Boolean value2) {
            addCriterion("is_class_manager between", value1, value2, "isClassManager");
            return (Criteria) this;
        }

        public Criteria andIsClassManagerNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_class_manager not between", value1, value2, "isClassManager");
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

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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