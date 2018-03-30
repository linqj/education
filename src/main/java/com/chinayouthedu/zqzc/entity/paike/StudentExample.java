package com.chinayouthedu.zqzc.entity.paike;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StudentExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public StudentExample() {
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

        public Criteria andStuNameIsNull() {
            addCriterion("stu_name is null");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNotNull() {
            addCriterion("stu_name is not null");
            return (Criteria) this;
        }

        public Criteria andStuNameEqualTo(String value) {
            addCriterion("stu_name =", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotEqualTo(String value) {
            addCriterion("stu_name <>", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThan(String value) {
            addCriterion("stu_name >", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_name >=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThan(String value) {
            addCriterion("stu_name <", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThanOrEqualTo(String value) {
            addCriterion("stu_name <=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLike(String value) {
            addCriterion("stu_name like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotLike(String value) {
            addCriterion("stu_name not like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameIn(List<String> values) {
            addCriterion("stu_name in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotIn(List<String> values) {
            addCriterion("stu_name not in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameBetween(String value1, String value2) {
            addCriterion("stu_name between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotBetween(String value1, String value2) {
            addCriterion("stu_name not between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuGenderIsNull() {
            addCriterion("stu_gender is null");
            return (Criteria) this;
        }

        public Criteria andStuGenderIsNotNull() {
            addCriterion("stu_gender is not null");
            return (Criteria) this;
        }

        public Criteria andStuGenderEqualTo(String value) {
            addCriterion("stu_gender =", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderNotEqualTo(String value) {
            addCriterion("stu_gender <>", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderGreaterThan(String value) {
            addCriterion("stu_gender >", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderGreaterThanOrEqualTo(String value) {
            addCriterion("stu_gender >=", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderLessThan(String value) {
            addCriterion("stu_gender <", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderLessThanOrEqualTo(String value) {
            addCriterion("stu_gender <=", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderLike(String value) {
            addCriterion("stu_gender like", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderNotLike(String value) {
            addCriterion("stu_gender not like", value, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderIn(List<String> values) {
            addCriterion("stu_gender in", values, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderNotIn(List<String> values) {
            addCriterion("stu_gender not in", values, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderBetween(String value1, String value2) {
            addCriterion("stu_gender between", value1, value2, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuGenderNotBetween(String value1, String value2) {
            addCriterion("stu_gender not between", value1, value2, "stuGender");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayIsNull() {
            addCriterion("stu_birthday is null");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayIsNotNull() {
            addCriterion("stu_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("stu_birthday =", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("stu_birthday <>", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("stu_birthday >", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stu_birthday >=", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("stu_birthday <", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stu_birthday <=", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("stu_birthday in", values, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("stu_birthday not in", values, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stu_birthday between", value1, value2, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stu_birthday not between", value1, value2, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIsNull() {
            addCriterion("stu_phone is null");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIsNotNull() {
            addCriterion("stu_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStuPhoneEqualTo(String value) {
            addCriterion("stu_phone =", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotEqualTo(String value) {
            addCriterion("stu_phone <>", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneGreaterThan(String value) {
            addCriterion("stu_phone >", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("stu_phone >=", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLessThan(String value) {
            addCriterion("stu_phone <", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLessThanOrEqualTo(String value) {
            addCriterion("stu_phone <=", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLike(String value) {
            addCriterion("stu_phone like", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotLike(String value) {
            addCriterion("stu_phone not like", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIn(List<String> values) {
            addCriterion("stu_phone in", values, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotIn(List<String> values) {
            addCriterion("stu_phone not in", values, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneBetween(String value1, String value2) {
            addCriterion("stu_phone between", value1, value2, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotBetween(String value1, String value2) {
            addCriterion("stu_phone not between", value1, value2, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuEmailIsNull() {
            addCriterion("stu_email is null");
            return (Criteria) this;
        }

        public Criteria andStuEmailIsNotNull() {
            addCriterion("stu_email is not null");
            return (Criteria) this;
        }

        public Criteria andStuEmailEqualTo(String value) {
            addCriterion("stu_email =", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailNotEqualTo(String value) {
            addCriterion("stu_email <>", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailGreaterThan(String value) {
            addCriterion("stu_email >", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailGreaterThanOrEqualTo(String value) {
            addCriterion("stu_email >=", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailLessThan(String value) {
            addCriterion("stu_email <", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailLessThanOrEqualTo(String value) {
            addCriterion("stu_email <=", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailLike(String value) {
            addCriterion("stu_email like", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailNotLike(String value) {
            addCriterion("stu_email not like", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailIn(List<String> values) {
            addCriterion("stu_email in", values, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailNotIn(List<String> values) {
            addCriterion("stu_email not in", values, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailBetween(String value1, String value2) {
            addCriterion("stu_email between", value1, value2, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailNotBetween(String value1, String value2) {
            addCriterion("stu_email not between", value1, value2, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuIdcardIsNull() {
            addCriterion("stu_idcard is null");
            return (Criteria) this;
        }

        public Criteria andStuIdcardIsNotNull() {
            addCriterion("stu_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdcardEqualTo(String value) {
            addCriterion("stu_idcard =", value, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardNotEqualTo(String value) {
            addCriterion("stu_idcard <>", value, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardGreaterThan(String value) {
            addCriterion("stu_idcard >", value, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("stu_idcard >=", value, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardLessThan(String value) {
            addCriterion("stu_idcard <", value, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardLessThanOrEqualTo(String value) {
            addCriterion("stu_idcard <=", value, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardLike(String value) {
            addCriterion("stu_idcard like", value, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardNotLike(String value) {
            addCriterion("stu_idcard not like", value, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardIn(List<String> values) {
            addCriterion("stu_idcard in", values, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardNotIn(List<String> values) {
            addCriterion("stu_idcard not in", values, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardBetween(String value1, String value2) {
            addCriterion("stu_idcard between", value1, value2, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuIdcardNotBetween(String value1, String value2) {
            addCriterion("stu_idcard not between", value1, value2, "stuIdcard");
            return (Criteria) this;
        }

        public Criteria andStuNumberIsNull() {
            addCriterion("stu_number is null");
            return (Criteria) this;
        }

        public Criteria andStuNumberIsNotNull() {
            addCriterion("stu_number is not null");
            return (Criteria) this;
        }

        public Criteria andStuNumberEqualTo(String value) {
            addCriterion("stu_number =", value, "stuNumber");
            return (Criteria) this;
        }

        public Criteria andStuNumberNotEqualTo(String value) {
            addCriterion("stu_number <>", value, "stuNumber");
            return (Criteria) this;
        }

        public Criteria andStuNumberGreaterThan(String value) {
            addCriterion("stu_number >", value, "stuNumber");
            return (Criteria) this;
        }

        public Criteria andStuNumberGreaterThanOrEqualTo(String value) {
            addCriterion("stu_number >=", value, "stuNumber");
            return (Criteria) this;
        }

        public Criteria andStuNumberLessThan(String value) {
            addCriterion("stu_number <", value, "stuNumber");
            return (Criteria) this;
        }

        public Criteria andStuNumberLessThanOrEqualTo(String value) {
            addCriterion("stu_number <=", value, "stuNumber");
            return (Criteria) this;
        }

        public Criteria andStuNumberLike(String value) {
            addCriterion("stu_number like", value, "stuNumber");
            return (Criteria) this;
        }

        public Criteria andStuNumberNotLike(String value) {
            addCriterion("stu_number not like", value, "stuNumber");
            return (Criteria) this;
        }

        public Criteria andStuNumberIn(List<String> values) {
            addCriterion("stu_number in", values, "stuNumber");
            return (Criteria) this;
        }

        public Criteria andStuNumberNotIn(List<String> values) {
            addCriterion("stu_number not in", values, "stuNumber");
            return (Criteria) this;
        }

        public Criteria andStuNumberBetween(String value1, String value2) {
            addCriterion("stu_number between", value1, value2, "stuNumber");
            return (Criteria) this;
        }

        public Criteria andStuNumberNotBetween(String value1, String value2) {
            addCriterion("stu_number not between", value1, value2, "stuNumber");
            return (Criteria) this;
        }

        public Criteria andStuHomeAddressIsNull() {
            addCriterion("stu_home_address is null");
            return (Criteria) this;
        }

        public Criteria andStuHomeAddressIsNotNull() {
            addCriterion("stu_home_address is not null");
            return (Criteria) this;
        }

        public Criteria andStuHomeAddressEqualTo(String value) {
            addCriterion("stu_home_address =", value, "stuHomeAddress");
            return (Criteria) this;
        }

        public Criteria andStuHomeAddressNotEqualTo(String value) {
            addCriterion("stu_home_address <>", value, "stuHomeAddress");
            return (Criteria) this;
        }

        public Criteria andStuHomeAddressGreaterThan(String value) {
            addCriterion("stu_home_address >", value, "stuHomeAddress");
            return (Criteria) this;
        }

        public Criteria andStuHomeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("stu_home_address >=", value, "stuHomeAddress");
            return (Criteria) this;
        }

        public Criteria andStuHomeAddressLessThan(String value) {
            addCriterion("stu_home_address <", value, "stuHomeAddress");
            return (Criteria) this;
        }

        public Criteria andStuHomeAddressLessThanOrEqualTo(String value) {
            addCriterion("stu_home_address <=", value, "stuHomeAddress");
            return (Criteria) this;
        }

        public Criteria andStuHomeAddressLike(String value) {
            addCriterion("stu_home_address like", value, "stuHomeAddress");
            return (Criteria) this;
        }

        public Criteria andStuHomeAddressNotLike(String value) {
            addCriterion("stu_home_address not like", value, "stuHomeAddress");
            return (Criteria) this;
        }

        public Criteria andStuHomeAddressIn(List<String> values) {
            addCriterion("stu_home_address in", values, "stuHomeAddress");
            return (Criteria) this;
        }

        public Criteria andStuHomeAddressNotIn(List<String> values) {
            addCriterion("stu_home_address not in", values, "stuHomeAddress");
            return (Criteria) this;
        }

        public Criteria andStuHomeAddressBetween(String value1, String value2) {
            addCriterion("stu_home_address between", value1, value2, "stuHomeAddress");
            return (Criteria) this;
        }

        public Criteria andStuHomeAddressNotBetween(String value1, String value2) {
            addCriterion("stu_home_address not between", value1, value2, "stuHomeAddress");
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

        public Criteria andStuStartTimeIsNull() {
            addCriterion("stu_start_time is null");
            return (Criteria) this;
        }

        public Criteria andStuStartTimeIsNotNull() {
            addCriterion("stu_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStuStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("stu_start_time =", value, "stuStartTime");
            return (Criteria) this;
        }

        public Criteria andStuStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("stu_start_time <>", value, "stuStartTime");
            return (Criteria) this;
        }

        public Criteria andStuStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("stu_start_time >", value, "stuStartTime");
            return (Criteria) this;
        }

        public Criteria andStuStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stu_start_time >=", value, "stuStartTime");
            return (Criteria) this;
        }

        public Criteria andStuStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("stu_start_time <", value, "stuStartTime");
            return (Criteria) this;
        }

        public Criteria andStuStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stu_start_time <=", value, "stuStartTime");
            return (Criteria) this;
        }

        public Criteria andStuStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("stu_start_time in", values, "stuStartTime");
            return (Criteria) this;
        }

        public Criteria andStuStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("stu_start_time not in", values, "stuStartTime");
            return (Criteria) this;
        }

        public Criteria andStuStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stu_start_time between", value1, value2, "stuStartTime");
            return (Criteria) this;
        }

        public Criteria andStuStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stu_start_time not between", value1, value2, "stuStartTime");
            return (Criteria) this;
        }

        public Criteria andStuEndTimeIsNull() {
            addCriterion("stu_end_time is null");
            return (Criteria) this;
        }

        public Criteria andStuEndTimeIsNotNull() {
            addCriterion("stu_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andStuEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("stu_end_time =", value, "stuEndTime");
            return (Criteria) this;
        }

        public Criteria andStuEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("stu_end_time <>", value, "stuEndTime");
            return (Criteria) this;
        }

        public Criteria andStuEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("stu_end_time >", value, "stuEndTime");
            return (Criteria) this;
        }

        public Criteria andStuEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stu_end_time >=", value, "stuEndTime");
            return (Criteria) this;
        }

        public Criteria andStuEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("stu_end_time <", value, "stuEndTime");
            return (Criteria) this;
        }

        public Criteria andStuEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stu_end_time <=", value, "stuEndTime");
            return (Criteria) this;
        }

        public Criteria andStuEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("stu_end_time in", values, "stuEndTime");
            return (Criteria) this;
        }

        public Criteria andStuEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("stu_end_time not in", values, "stuEndTime");
            return (Criteria) this;
        }

        public Criteria andStuEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stu_end_time between", value1, value2, "stuEndTime");
            return (Criteria) this;
        }

        public Criteria andStuEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stu_end_time not between", value1, value2, "stuEndTime");
            return (Criteria) this;
        }

        public Criteria andStuSchoolPostIsNull() {
            addCriterion("stu_school_post is null");
            return (Criteria) this;
        }

        public Criteria andStuSchoolPostIsNotNull() {
            addCriterion("stu_school_post is not null");
            return (Criteria) this;
        }

        public Criteria andStuSchoolPostEqualTo(String value) {
            addCriterion("stu_school_post =", value, "stuSchoolPost");
            return (Criteria) this;
        }

        public Criteria andStuSchoolPostNotEqualTo(String value) {
            addCriterion("stu_school_post <>", value, "stuSchoolPost");
            return (Criteria) this;
        }

        public Criteria andStuSchoolPostGreaterThan(String value) {
            addCriterion("stu_school_post >", value, "stuSchoolPost");
            return (Criteria) this;
        }

        public Criteria andStuSchoolPostGreaterThanOrEqualTo(String value) {
            addCriterion("stu_school_post >=", value, "stuSchoolPost");
            return (Criteria) this;
        }

        public Criteria andStuSchoolPostLessThan(String value) {
            addCriterion("stu_school_post <", value, "stuSchoolPost");
            return (Criteria) this;
        }

        public Criteria andStuSchoolPostLessThanOrEqualTo(String value) {
            addCriterion("stu_school_post <=", value, "stuSchoolPost");
            return (Criteria) this;
        }

        public Criteria andStuSchoolPostLike(String value) {
            addCriterion("stu_school_post like", value, "stuSchoolPost");
            return (Criteria) this;
        }

        public Criteria andStuSchoolPostNotLike(String value) {
            addCriterion("stu_school_post not like", value, "stuSchoolPost");
            return (Criteria) this;
        }

        public Criteria andStuSchoolPostIn(List<String> values) {
            addCriterion("stu_school_post in", values, "stuSchoolPost");
            return (Criteria) this;
        }

        public Criteria andStuSchoolPostNotIn(List<String> values) {
            addCriterion("stu_school_post not in", values, "stuSchoolPost");
            return (Criteria) this;
        }

        public Criteria andStuSchoolPostBetween(String value1, String value2) {
            addCriterion("stu_school_post between", value1, value2, "stuSchoolPost");
            return (Criteria) this;
        }

        public Criteria andStuSchoolPostNotBetween(String value1, String value2) {
            addCriterion("stu_school_post not between", value1, value2, "stuSchoolPost");
            return (Criteria) this;
        }

        public Criteria andStuClassPostIsNull() {
            addCriterion("stu_class_post is null");
            return (Criteria) this;
        }

        public Criteria andStuClassPostIsNotNull() {
            addCriterion("stu_class_post is not null");
            return (Criteria) this;
        }

        public Criteria andStuClassPostEqualTo(String value) {
            addCriterion("stu_class_post =", value, "stuClassPost");
            return (Criteria) this;
        }

        public Criteria andStuClassPostNotEqualTo(String value) {
            addCriterion("stu_class_post <>", value, "stuClassPost");
            return (Criteria) this;
        }

        public Criteria andStuClassPostGreaterThan(String value) {
            addCriterion("stu_class_post >", value, "stuClassPost");
            return (Criteria) this;
        }

        public Criteria andStuClassPostGreaterThanOrEqualTo(String value) {
            addCriterion("stu_class_post >=", value, "stuClassPost");
            return (Criteria) this;
        }

        public Criteria andStuClassPostLessThan(String value) {
            addCriterion("stu_class_post <", value, "stuClassPost");
            return (Criteria) this;
        }

        public Criteria andStuClassPostLessThanOrEqualTo(String value) {
            addCriterion("stu_class_post <=", value, "stuClassPost");
            return (Criteria) this;
        }

        public Criteria andStuClassPostLike(String value) {
            addCriterion("stu_class_post like", value, "stuClassPost");
            return (Criteria) this;
        }

        public Criteria andStuClassPostNotLike(String value) {
            addCriterion("stu_class_post not like", value, "stuClassPost");
            return (Criteria) this;
        }

        public Criteria andStuClassPostIn(List<String> values) {
            addCriterion("stu_class_post in", values, "stuClassPost");
            return (Criteria) this;
        }

        public Criteria andStuClassPostNotIn(List<String> values) {
            addCriterion("stu_class_post not in", values, "stuClassPost");
            return (Criteria) this;
        }

        public Criteria andStuClassPostBetween(String value1, String value2) {
            addCriterion("stu_class_post between", value1, value2, "stuClassPost");
            return (Criteria) this;
        }

        public Criteria andStuClassPostNotBetween(String value1, String value2) {
            addCriterion("stu_class_post not between", value1, value2, "stuClassPost");
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

        public Criteria andStuHostelIsNull() {
            addCriterion("stu_hostel is null");
            return (Criteria) this;
        }

        public Criteria andStuHostelIsNotNull() {
            addCriterion("stu_hostel is not null");
            return (Criteria) this;
        }

        public Criteria andStuHostelEqualTo(String value) {
            addCriterion("stu_hostel =", value, "stuHostel");
            return (Criteria) this;
        }

        public Criteria andStuHostelNotEqualTo(String value) {
            addCriterion("stu_hostel <>", value, "stuHostel");
            return (Criteria) this;
        }

        public Criteria andStuHostelGreaterThan(String value) {
            addCriterion("stu_hostel >", value, "stuHostel");
            return (Criteria) this;
        }

        public Criteria andStuHostelGreaterThanOrEqualTo(String value) {
            addCriterion("stu_hostel >=", value, "stuHostel");
            return (Criteria) this;
        }

        public Criteria andStuHostelLessThan(String value) {
            addCriterion("stu_hostel <", value, "stuHostel");
            return (Criteria) this;
        }

        public Criteria andStuHostelLessThanOrEqualTo(String value) {
            addCriterion("stu_hostel <=", value, "stuHostel");
            return (Criteria) this;
        }

        public Criteria andStuHostelLike(String value) {
            addCriterion("stu_hostel like", value, "stuHostel");
            return (Criteria) this;
        }

        public Criteria andStuHostelNotLike(String value) {
            addCriterion("stu_hostel not like", value, "stuHostel");
            return (Criteria) this;
        }

        public Criteria andStuHostelIn(List<String> values) {
            addCriterion("stu_hostel in", values, "stuHostel");
            return (Criteria) this;
        }

        public Criteria andStuHostelNotIn(List<String> values) {
            addCriterion("stu_hostel not in", values, "stuHostel");
            return (Criteria) this;
        }

        public Criteria andStuHostelBetween(String value1, String value2) {
            addCriterion("stu_hostel between", value1, value2, "stuHostel");
            return (Criteria) this;
        }

        public Criteria andStuHostelNotBetween(String value1, String value2) {
            addCriterion("stu_hostel not between", value1, value2, "stuHostel");
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

        public Criteria andStuLevelIsNull() {
            addCriterion("stu_level is null");
            return (Criteria) this;
        }

        public Criteria andStuLevelIsNotNull() {
            addCriterion("stu_level is not null");
            return (Criteria) this;
        }

        public Criteria andStuLevelEqualTo(String value) {
            addCriterion("stu_level =", value, "stuLevel");
            return (Criteria) this;
        }

        public Criteria andStuLevelNotEqualTo(String value) {
            addCriterion("stu_level <>", value, "stuLevel");
            return (Criteria) this;
        }

        public Criteria andStuLevelGreaterThan(String value) {
            addCriterion("stu_level >", value, "stuLevel");
            return (Criteria) this;
        }

        public Criteria andStuLevelGreaterThanOrEqualTo(String value) {
            addCriterion("stu_level >=", value, "stuLevel");
            return (Criteria) this;
        }

        public Criteria andStuLevelLessThan(String value) {
            addCriterion("stu_level <", value, "stuLevel");
            return (Criteria) this;
        }

        public Criteria andStuLevelLessThanOrEqualTo(String value) {
            addCriterion("stu_level <=", value, "stuLevel");
            return (Criteria) this;
        }

        public Criteria andStuLevelLike(String value) {
            addCriterion("stu_level like", value, "stuLevel");
            return (Criteria) this;
        }

        public Criteria andStuLevelNotLike(String value) {
            addCriterion("stu_level not like", value, "stuLevel");
            return (Criteria) this;
        }

        public Criteria andStuLevelIn(List<String> values) {
            addCriterion("stu_level in", values, "stuLevel");
            return (Criteria) this;
        }

        public Criteria andStuLevelNotIn(List<String> values) {
            addCriterion("stu_level not in", values, "stuLevel");
            return (Criteria) this;
        }

        public Criteria andStuLevelBetween(String value1, String value2) {
            addCriterion("stu_level between", value1, value2, "stuLevel");
            return (Criteria) this;
        }

        public Criteria andStuLevelNotBetween(String value1, String value2) {
            addCriterion("stu_level not between", value1, value2, "stuLevel");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNull() {
            addCriterion("class_id is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(Long value) {
            addCriterion("class_id =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(Long value) {
            addCriterion("class_id <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(Long value) {
            addCriterion("class_id >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(Long value) {
            addCriterion("class_id >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(Long value) {
            addCriterion("class_id <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(Long value) {
            addCriterion("class_id <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<Long> values) {
            addCriterion("class_id in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<Long> values) {
            addCriterion("class_id not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(Long value1, Long value2) {
            addCriterion("class_id between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(Long value1, Long value2) {
            addCriterion("class_id not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "className");
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