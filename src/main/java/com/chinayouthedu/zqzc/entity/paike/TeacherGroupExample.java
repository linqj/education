package com.chinayouthedu.zqzc.entity.paike;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TeacherGroupExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public TeacherGroupExample() {
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

        public Criteria andTgNameIsNull() {
            addCriterion("tg_name is null");
            return (Criteria) this;
        }

        public Criteria andTgNameIsNotNull() {
            addCriterion("tg_name is not null");
            return (Criteria) this;
        }

        public Criteria andTgNameEqualTo(String value) {
            addCriterion("tg_name =", value, "tgName");
            return (Criteria) this;
        }

        public Criteria andTgNameNotEqualTo(String value) {
            addCriterion("tg_name <>", value, "tgName");
            return (Criteria) this;
        }

        public Criteria andTgNameGreaterThan(String value) {
            addCriterion("tg_name >", value, "tgName");
            return (Criteria) this;
        }

        public Criteria andTgNameGreaterThanOrEqualTo(String value) {
            addCriterion("tg_name >=", value, "tgName");
            return (Criteria) this;
        }

        public Criteria andTgNameLessThan(String value) {
            addCriterion("tg_name <", value, "tgName");
            return (Criteria) this;
        }

        public Criteria andTgNameLessThanOrEqualTo(String value) {
            addCriterion("tg_name <=", value, "tgName");
            return (Criteria) this;
        }

        public Criteria andTgNameLike(String value) {
            addCriterion("tg_name like", value, "tgName");
            return (Criteria) this;
        }

        public Criteria andTgNameNotLike(String value) {
            addCriterion("tg_name not like", value, "tgName");
            return (Criteria) this;
        }

        public Criteria andTgNameIn(List<String> values) {
            addCriterion("tg_name in", values, "tgName");
            return (Criteria) this;
        }

        public Criteria andTgNameNotIn(List<String> values) {
            addCriterion("tg_name not in", values, "tgName");
            return (Criteria) this;
        }

        public Criteria andTgNameBetween(String value1, String value2) {
            addCriterion("tg_name between", value1, value2, "tgName");
            return (Criteria) this;
        }

        public Criteria andTgNameNotBetween(String value1, String value2) {
            addCriterion("tg_name not between", value1, value2, "tgName");
            return (Criteria) this;
        }

        public Criteria andTgLeaderIdIsNull() {
            addCriterion("tg_leader_id is null");
            return (Criteria) this;
        }

        public Criteria andTgLeaderIdIsNotNull() {
            addCriterion("tg_leader_id is not null");
            return (Criteria) this;
        }

        public Criteria andTgLeaderIdEqualTo(Long value) {
            addCriterion("tg_leader_id =", value, "tgLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderIdNotEqualTo(Long value) {
            addCriterion("tg_leader_id <>", value, "tgLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderIdGreaterThan(Long value) {
            addCriterion("tg_leader_id >", value, "tgLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tg_leader_id >=", value, "tgLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderIdLessThan(Long value) {
            addCriterion("tg_leader_id <", value, "tgLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderIdLessThanOrEqualTo(Long value) {
            addCriterion("tg_leader_id <=", value, "tgLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderIdIn(List<Long> values) {
            addCriterion("tg_leader_id in", values, "tgLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderIdNotIn(List<Long> values) {
            addCriterion("tg_leader_id not in", values, "tgLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderIdBetween(Long value1, Long value2) {
            addCriterion("tg_leader_id between", value1, value2, "tgLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderIdNotBetween(Long value1, Long value2) {
            addCriterion("tg_leader_id not between", value1, value2, "tgLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderIsNull() {
            addCriterion("tg_leader is null");
            return (Criteria) this;
        }

        public Criteria andTgLeaderIsNotNull() {
            addCriterion("tg_leader is not null");
            return (Criteria) this;
        }

        public Criteria andTgLeaderEqualTo(String value) {
            addCriterion("tg_leader =", value, "tgLeader");
            return (Criteria) this;
        }

        public Criteria andTgLeaderNotEqualTo(String value) {
            addCriterion("tg_leader <>", value, "tgLeader");
            return (Criteria) this;
        }

        public Criteria andTgLeaderGreaterThan(String value) {
            addCriterion("tg_leader >", value, "tgLeader");
            return (Criteria) this;
        }

        public Criteria andTgLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("tg_leader >=", value, "tgLeader");
            return (Criteria) this;
        }

        public Criteria andTgLeaderLessThan(String value) {
            addCriterion("tg_leader <", value, "tgLeader");
            return (Criteria) this;
        }

        public Criteria andTgLeaderLessThanOrEqualTo(String value) {
            addCriterion("tg_leader <=", value, "tgLeader");
            return (Criteria) this;
        }

        public Criteria andTgLeaderLike(String value) {
            addCriterion("tg_leader like", value, "tgLeader");
            return (Criteria) this;
        }

        public Criteria andTgLeaderNotLike(String value) {
            addCriterion("tg_leader not like", value, "tgLeader");
            return (Criteria) this;
        }

        public Criteria andTgLeaderIn(List<String> values) {
            addCriterion("tg_leader in", values, "tgLeader");
            return (Criteria) this;
        }

        public Criteria andTgLeaderNotIn(List<String> values) {
            addCriterion("tg_leader not in", values, "tgLeader");
            return (Criteria) this;
        }

        public Criteria andTgLeaderBetween(String value1, String value2) {
            addCriterion("tg_leader between", value1, value2, "tgLeader");
            return (Criteria) this;
        }

        public Criteria andTgLeaderNotBetween(String value1, String value2) {
            addCriterion("tg_leader not between", value1, value2, "tgLeader");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoIdIsNull() {
            addCriterion("tg_leader_two_id is null");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoIdIsNotNull() {
            addCriterion("tg_leader_two_id is not null");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoIdEqualTo(Long value) {
            addCriterion("tg_leader_two_id =", value, "tgLeaderTwoId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoIdNotEqualTo(Long value) {
            addCriterion("tg_leader_two_id <>", value, "tgLeaderTwoId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoIdGreaterThan(Long value) {
            addCriterion("tg_leader_two_id >", value, "tgLeaderTwoId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tg_leader_two_id >=", value, "tgLeaderTwoId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoIdLessThan(Long value) {
            addCriterion("tg_leader_two_id <", value, "tgLeaderTwoId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoIdLessThanOrEqualTo(Long value) {
            addCriterion("tg_leader_two_id <=", value, "tgLeaderTwoId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoIdIn(List<Long> values) {
            addCriterion("tg_leader_two_id in", values, "tgLeaderTwoId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoIdNotIn(List<Long> values) {
            addCriterion("tg_leader_two_id not in", values, "tgLeaderTwoId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoIdBetween(Long value1, Long value2) {
            addCriterion("tg_leader_two_id between", value1, value2, "tgLeaderTwoId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoIdNotBetween(Long value1, Long value2) {
            addCriterion("tg_leader_two_id not between", value1, value2, "tgLeaderTwoId");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoIsNull() {
            addCriterion("tg_leader_two is null");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoIsNotNull() {
            addCriterion("tg_leader_two is not null");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoEqualTo(String value) {
            addCriterion("tg_leader_two =", value, "tgLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoNotEqualTo(String value) {
            addCriterion("tg_leader_two <>", value, "tgLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoGreaterThan(String value) {
            addCriterion("tg_leader_two >", value, "tgLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoGreaterThanOrEqualTo(String value) {
            addCriterion("tg_leader_two >=", value, "tgLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoLessThan(String value) {
            addCriterion("tg_leader_two <", value, "tgLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoLessThanOrEqualTo(String value) {
            addCriterion("tg_leader_two <=", value, "tgLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoLike(String value) {
            addCriterion("tg_leader_two like", value, "tgLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoNotLike(String value) {
            addCriterion("tg_leader_two not like", value, "tgLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoIn(List<String> values) {
            addCriterion("tg_leader_two in", values, "tgLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoNotIn(List<String> values) {
            addCriterion("tg_leader_two not in", values, "tgLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoBetween(String value1, String value2) {
            addCriterion("tg_leader_two between", value1, value2, "tgLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andTgLeaderTwoNotBetween(String value1, String value2) {
            addCriterion("tg_leader_two not between", value1, value2, "tgLeaderTwo");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderIdIsNull() {
            addCriterion("tg_lesson_leader_id is null");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderIdIsNotNull() {
            addCriterion("tg_lesson_leader_id is not null");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderIdEqualTo(Long value) {
            addCriterion("tg_lesson_leader_id =", value, "tgLessonLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderIdNotEqualTo(Long value) {
            addCriterion("tg_lesson_leader_id <>", value, "tgLessonLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderIdGreaterThan(Long value) {
            addCriterion("tg_lesson_leader_id >", value, "tgLessonLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tg_lesson_leader_id >=", value, "tgLessonLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderIdLessThan(Long value) {
            addCriterion("tg_lesson_leader_id <", value, "tgLessonLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderIdLessThanOrEqualTo(Long value) {
            addCriterion("tg_lesson_leader_id <=", value, "tgLessonLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderIdIn(List<Long> values) {
            addCriterion("tg_lesson_leader_id in", values, "tgLessonLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderIdNotIn(List<Long> values) {
            addCriterion("tg_lesson_leader_id not in", values, "tgLessonLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderIdBetween(Long value1, Long value2) {
            addCriterion("tg_lesson_leader_id between", value1, value2, "tgLessonLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderIdNotBetween(Long value1, Long value2) {
            addCriterion("tg_lesson_leader_id not between", value1, value2, "tgLessonLeaderId");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderIsNull() {
            addCriterion("tg_lesson_leader is null");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderIsNotNull() {
            addCriterion("tg_lesson_leader is not null");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderEqualTo(String value) {
            addCriterion("tg_lesson_leader =", value, "tgLessonLeader");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderNotEqualTo(String value) {
            addCriterion("tg_lesson_leader <>", value, "tgLessonLeader");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderGreaterThan(String value) {
            addCriterion("tg_lesson_leader >", value, "tgLessonLeader");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("tg_lesson_leader >=", value, "tgLessonLeader");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderLessThan(String value) {
            addCriterion("tg_lesson_leader <", value, "tgLessonLeader");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderLessThanOrEqualTo(String value) {
            addCriterion("tg_lesson_leader <=", value, "tgLessonLeader");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderLike(String value) {
            addCriterion("tg_lesson_leader like", value, "tgLessonLeader");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderNotLike(String value) {
            addCriterion("tg_lesson_leader not like", value, "tgLessonLeader");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderIn(List<String> values) {
            addCriterion("tg_lesson_leader in", values, "tgLessonLeader");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderNotIn(List<String> values) {
            addCriterion("tg_lesson_leader not in", values, "tgLessonLeader");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderBetween(String value1, String value2) {
            addCriterion("tg_lesson_leader between", value1, value2, "tgLessonLeader");
            return (Criteria) this;
        }

        public Criteria andTgLessonLeaderNotBetween(String value1, String value2) {
            addCriterion("tg_lesson_leader not between", value1, value2, "tgLessonLeader");
            return (Criteria) this;
        }

        public Criteria andTgTeacherNumberIsNull() {
            addCriterion("tg_teacher_number is null");
            return (Criteria) this;
        }

        public Criteria andTgTeacherNumberIsNotNull() {
            addCriterion("tg_teacher_number is not null");
            return (Criteria) this;
        }

        public Criteria andTgTeacherNumberEqualTo(Integer value) {
            addCriterion("tg_teacher_number =", value, "tgTeacherNumber");
            return (Criteria) this;
        }

        public Criteria andTgTeacherNumberNotEqualTo(Integer value) {
            addCriterion("tg_teacher_number <>", value, "tgTeacherNumber");
            return (Criteria) this;
        }

        public Criteria andTgTeacherNumberGreaterThan(Integer value) {
            addCriterion("tg_teacher_number >", value, "tgTeacherNumber");
            return (Criteria) this;
        }

        public Criteria andTgTeacherNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("tg_teacher_number >=", value, "tgTeacherNumber");
            return (Criteria) this;
        }

        public Criteria andTgTeacherNumberLessThan(Integer value) {
            addCriterion("tg_teacher_number <", value, "tgTeacherNumber");
            return (Criteria) this;
        }

        public Criteria andTgTeacherNumberLessThanOrEqualTo(Integer value) {
            addCriterion("tg_teacher_number <=", value, "tgTeacherNumber");
            return (Criteria) this;
        }

        public Criteria andTgTeacherNumberIn(List<Integer> values) {
            addCriterion("tg_teacher_number in", values, "tgTeacherNumber");
            return (Criteria) this;
        }

        public Criteria andTgTeacherNumberNotIn(List<Integer> values) {
            addCriterion("tg_teacher_number not in", values, "tgTeacherNumber");
            return (Criteria) this;
        }

        public Criteria andTgTeacherNumberBetween(Integer value1, Integer value2) {
            addCriterion("tg_teacher_number between", value1, value2, "tgTeacherNumber");
            return (Criteria) this;
        }

        public Criteria andTgTeacherNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("tg_teacher_number not between", value1, value2, "tgTeacherNumber");
            return (Criteria) this;
        }

        public Criteria andTgCodeIsNull() {
            addCriterion("tg_code is null");
            return (Criteria) this;
        }

        public Criteria andTgCodeIsNotNull() {
            addCriterion("tg_code is not null");
            return (Criteria) this;
        }

        public Criteria andTgCodeEqualTo(String value) {
            addCriterion("tg_code =", value, "tgCode");
            return (Criteria) this;
        }

        public Criteria andTgCodeNotEqualTo(String value) {
            addCriterion("tg_code <>", value, "tgCode");
            return (Criteria) this;
        }

        public Criteria andTgCodeGreaterThan(String value) {
            addCriterion("tg_code >", value, "tgCode");
            return (Criteria) this;
        }

        public Criteria andTgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tg_code >=", value, "tgCode");
            return (Criteria) this;
        }

        public Criteria andTgCodeLessThan(String value) {
            addCriterion("tg_code <", value, "tgCode");
            return (Criteria) this;
        }

        public Criteria andTgCodeLessThanOrEqualTo(String value) {
            addCriterion("tg_code <=", value, "tgCode");
            return (Criteria) this;
        }

        public Criteria andTgCodeLike(String value) {
            addCriterion("tg_code like", value, "tgCode");
            return (Criteria) this;
        }

        public Criteria andTgCodeNotLike(String value) {
            addCriterion("tg_code not like", value, "tgCode");
            return (Criteria) this;
        }

        public Criteria andTgCodeIn(List<String> values) {
            addCriterion("tg_code in", values, "tgCode");
            return (Criteria) this;
        }

        public Criteria andTgCodeNotIn(List<String> values) {
            addCriterion("tg_code not in", values, "tgCode");
            return (Criteria) this;
        }

        public Criteria andTgCodeBetween(String value1, String value2) {
            addCriterion("tg_code between", value1, value2, "tgCode");
            return (Criteria) this;
        }

        public Criteria andTgCodeNotBetween(String value1, String value2) {
            addCriterion("tg_code not between", value1, value2, "tgCode");
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

        public Criteria andTgCourseNameIsNull() {
            addCriterion("tg_course_name is null");
            return (Criteria) this;
        }

        public Criteria andTgCourseNameIsNotNull() {
            addCriterion("tg_course_name is not null");
            return (Criteria) this;
        }

        public Criteria andTgCourseNameEqualTo(String value) {
            addCriterion("tg_course_name =", value, "tgCourseName");
            return (Criteria) this;
        }

        public Criteria andTgCourseNameNotEqualTo(String value) {
            addCriterion("tg_course_name <>", value, "tgCourseName");
            return (Criteria) this;
        }

        public Criteria andTgCourseNameGreaterThan(String value) {
            addCriterion("tg_course_name >", value, "tgCourseName");
            return (Criteria) this;
        }

        public Criteria andTgCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("tg_course_name >=", value, "tgCourseName");
            return (Criteria) this;
        }

        public Criteria andTgCourseNameLessThan(String value) {
            addCriterion("tg_course_name <", value, "tgCourseName");
            return (Criteria) this;
        }

        public Criteria andTgCourseNameLessThanOrEqualTo(String value) {
            addCriterion("tg_course_name <=", value, "tgCourseName");
            return (Criteria) this;
        }

        public Criteria andTgCourseNameLike(String value) {
            addCriterion("tg_course_name like", value, "tgCourseName");
            return (Criteria) this;
        }

        public Criteria andTgCourseNameNotLike(String value) {
            addCriterion("tg_course_name not like", value, "tgCourseName");
            return (Criteria) this;
        }

        public Criteria andTgCourseNameIn(List<String> values) {
            addCriterion("tg_course_name in", values, "tgCourseName");
            return (Criteria) this;
        }

        public Criteria andTgCourseNameNotIn(List<String> values) {
            addCriterion("tg_course_name not in", values, "tgCourseName");
            return (Criteria) this;
        }

        public Criteria andTgCourseNameBetween(String value1, String value2) {
            addCriterion("tg_course_name between", value1, value2, "tgCourseName");
            return (Criteria) this;
        }

        public Criteria andTgCourseNameNotBetween(String value1, String value2) {
            addCriterion("tg_course_name not between", value1, value2, "tgCourseName");
            return (Criteria) this;
        }

        public Criteria andTgStartTimeIsNull() {
            addCriterion("tg_start_time is null");
            return (Criteria) this;
        }

        public Criteria andTgStartTimeIsNotNull() {
            addCriterion("tg_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andTgStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("tg_start_time =", value, "tgStartTime");
            return (Criteria) this;
        }

        public Criteria andTgStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("tg_start_time <>", value, "tgStartTime");
            return (Criteria) this;
        }

        public Criteria andTgStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("tg_start_time >", value, "tgStartTime");
            return (Criteria) this;
        }

        public Criteria andTgStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tg_start_time >=", value, "tgStartTime");
            return (Criteria) this;
        }

        public Criteria andTgStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("tg_start_time <", value, "tgStartTime");
            return (Criteria) this;
        }

        public Criteria andTgStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tg_start_time <=", value, "tgStartTime");
            return (Criteria) this;
        }

        public Criteria andTgStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("tg_start_time in", values, "tgStartTime");
            return (Criteria) this;
        }

        public Criteria andTgStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("tg_start_time not in", values, "tgStartTime");
            return (Criteria) this;
        }

        public Criteria andTgStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tg_start_time between", value1, value2, "tgStartTime");
            return (Criteria) this;
        }

        public Criteria andTgStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tg_start_time not between", value1, value2, "tgStartTime");
            return (Criteria) this;
        }

        public Criteria andTgEndTimeIsNull() {
            addCriterion("tg_end_time is null");
            return (Criteria) this;
        }

        public Criteria andTgEndTimeIsNotNull() {
            addCriterion("tg_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andTgEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("tg_end_time =", value, "tgEndTime");
            return (Criteria) this;
        }

        public Criteria andTgEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("tg_end_time <>", value, "tgEndTime");
            return (Criteria) this;
        }

        public Criteria andTgEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("tg_end_time >", value, "tgEndTime");
            return (Criteria) this;
        }

        public Criteria andTgEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tg_end_time >=", value, "tgEndTime");
            return (Criteria) this;
        }

        public Criteria andTgEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("tg_end_time <", value, "tgEndTime");
            return (Criteria) this;
        }

        public Criteria andTgEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tg_end_time <=", value, "tgEndTime");
            return (Criteria) this;
        }

        public Criteria andTgEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("tg_end_time in", values, "tgEndTime");
            return (Criteria) this;
        }

        public Criteria andTgEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("tg_end_time not in", values, "tgEndTime");
            return (Criteria) this;
        }

        public Criteria andTgEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tg_end_time between", value1, value2, "tgEndTime");
            return (Criteria) this;
        }

        public Criteria andTgEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tg_end_time not between", value1, value2, "tgEndTime");
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