package com.chinayouthedu.zqzc.entity.paike;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataDictionaryExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public DataDictionaryExample() {
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

        public Criteria andDictionaryCodeIsNull() {
            addCriterion("dictionary_code is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeIsNotNull() {
            addCriterion("dictionary_code is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeEqualTo(String value) {
            addCriterion("dictionary_code =", value, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeNotEqualTo(String value) {
            addCriterion("dictionary_code <>", value, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeGreaterThan(String value) {
            addCriterion("dictionary_code >", value, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dictionary_code >=", value, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeLessThan(String value) {
            addCriterion("dictionary_code <", value, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeLessThanOrEqualTo(String value) {
            addCriterion("dictionary_code <=", value, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeLike(String value) {
            addCriterion("dictionary_code like", value, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeNotLike(String value) {
            addCriterion("dictionary_code not like", value, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeIn(List<String> values) {
            addCriterion("dictionary_code in", values, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeNotIn(List<String> values) {
            addCriterion("dictionary_code not in", values, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeBetween(String value1, String value2) {
            addCriterion("dictionary_code between", value1, value2, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryCodeNotBetween(String value1, String value2) {
            addCriterion("dictionary_code not between", value1, value2, "dictionaryCode");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeIsNull() {
            addCriterion("dictionary_type is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeIsNotNull() {
            addCriterion("dictionary_type is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeEqualTo(String value) {
            addCriterion("dictionary_type =", value, "dictionaryType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNotEqualTo(String value) {
            addCriterion("dictionary_type <>", value, "dictionaryType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeGreaterThan(String value) {
            addCriterion("dictionary_type >", value, "dictionaryType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("dictionary_type >=", value, "dictionaryType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeLessThan(String value) {
            addCriterion("dictionary_type <", value, "dictionaryType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeLessThanOrEqualTo(String value) {
            addCriterion("dictionary_type <=", value, "dictionaryType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeLike(String value) {
            addCriterion("dictionary_type like", value, "dictionaryType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNotLike(String value) {
            addCriterion("dictionary_type not like", value, "dictionaryType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeIn(List<String> values) {
            addCriterion("dictionary_type in", values, "dictionaryType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNotIn(List<String> values) {
            addCriterion("dictionary_type not in", values, "dictionaryType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeBetween(String value1, String value2) {
            addCriterion("dictionary_type between", value1, value2, "dictionaryType");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNotBetween(String value1, String value2) {
            addCriterion("dictionary_type not between", value1, value2, "dictionaryType");
            return (Criteria) this;
        }

        public Criteria andDictionaryIconIsNull() {
            addCriterion("dictionary_icon is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryIconIsNotNull() {
            addCriterion("dictionary_icon is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryIconEqualTo(String value) {
            addCriterion("dictionary_icon =", value, "dictionaryIcon");
            return (Criteria) this;
        }

        public Criteria andDictionaryIconNotEqualTo(String value) {
            addCriterion("dictionary_icon <>", value, "dictionaryIcon");
            return (Criteria) this;
        }

        public Criteria andDictionaryIconGreaterThan(String value) {
            addCriterion("dictionary_icon >", value, "dictionaryIcon");
            return (Criteria) this;
        }

        public Criteria andDictionaryIconGreaterThanOrEqualTo(String value) {
            addCriterion("dictionary_icon >=", value, "dictionaryIcon");
            return (Criteria) this;
        }

        public Criteria andDictionaryIconLessThan(String value) {
            addCriterion("dictionary_icon <", value, "dictionaryIcon");
            return (Criteria) this;
        }

        public Criteria andDictionaryIconLessThanOrEqualTo(String value) {
            addCriterion("dictionary_icon <=", value, "dictionaryIcon");
            return (Criteria) this;
        }

        public Criteria andDictionaryIconLike(String value) {
            addCriterion("dictionary_icon like", value, "dictionaryIcon");
            return (Criteria) this;
        }

        public Criteria andDictionaryIconNotLike(String value) {
            addCriterion("dictionary_icon not like", value, "dictionaryIcon");
            return (Criteria) this;
        }

        public Criteria andDictionaryIconIn(List<String> values) {
            addCriterion("dictionary_icon in", values, "dictionaryIcon");
            return (Criteria) this;
        }

        public Criteria andDictionaryIconNotIn(List<String> values) {
            addCriterion("dictionary_icon not in", values, "dictionaryIcon");
            return (Criteria) this;
        }

        public Criteria andDictionaryIconBetween(String value1, String value2) {
            addCriterion("dictionary_icon between", value1, value2, "dictionaryIcon");
            return (Criteria) this;
        }

        public Criteria andDictionaryIconNotBetween(String value1, String value2) {
            addCriterion("dictionary_icon not between", value1, value2, "dictionaryIcon");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameIsNull() {
            addCriterion("dictionary_name is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameIsNotNull() {
            addCriterion("dictionary_name is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameEqualTo(String value) {
            addCriterion("dictionary_name =", value, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameNotEqualTo(String value) {
            addCriterion("dictionary_name <>", value, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameGreaterThan(String value) {
            addCriterion("dictionary_name >", value, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameGreaterThanOrEqualTo(String value) {
            addCriterion("dictionary_name >=", value, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameLessThan(String value) {
            addCriterion("dictionary_name <", value, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameLessThanOrEqualTo(String value) {
            addCriterion("dictionary_name <=", value, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameLike(String value) {
            addCriterion("dictionary_name like", value, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameNotLike(String value) {
            addCriterion("dictionary_name not like", value, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameIn(List<String> values) {
            addCriterion("dictionary_name in", values, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameNotIn(List<String> values) {
            addCriterion("dictionary_name not in", values, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameBetween(String value1, String value2) {
            addCriterion("dictionary_name between", value1, value2, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameNotBetween(String value1, String value2) {
            addCriterion("dictionary_name not between", value1, value2, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionarySortIsNull() {
            addCriterion("dictionary_sort is null");
            return (Criteria) this;
        }

        public Criteria andDictionarySortIsNotNull() {
            addCriterion("dictionary_sort is not null");
            return (Criteria) this;
        }

        public Criteria andDictionarySortEqualTo(Integer value) {
            addCriterion("dictionary_sort =", value, "dictionarySort");
            return (Criteria) this;
        }

        public Criteria andDictionarySortNotEqualTo(Integer value) {
            addCriterion("dictionary_sort <>", value, "dictionarySort");
            return (Criteria) this;
        }

        public Criteria andDictionarySortGreaterThan(Integer value) {
            addCriterion("dictionary_sort >", value, "dictionarySort");
            return (Criteria) this;
        }

        public Criteria andDictionarySortGreaterThanOrEqualTo(Integer value) {
            addCriterion("dictionary_sort >=", value, "dictionarySort");
            return (Criteria) this;
        }

        public Criteria andDictionarySortLessThan(Integer value) {
            addCriterion("dictionary_sort <", value, "dictionarySort");
            return (Criteria) this;
        }

        public Criteria andDictionarySortLessThanOrEqualTo(Integer value) {
            addCriterion("dictionary_sort <=", value, "dictionarySort");
            return (Criteria) this;
        }

        public Criteria andDictionarySortIn(List<Integer> values) {
            addCriterion("dictionary_sort in", values, "dictionarySort");
            return (Criteria) this;
        }

        public Criteria andDictionarySortNotIn(List<Integer> values) {
            addCriterion("dictionary_sort not in", values, "dictionarySort");
            return (Criteria) this;
        }

        public Criteria andDictionarySortBetween(Integer value1, Integer value2) {
            addCriterion("dictionary_sort between", value1, value2, "dictionarySort");
            return (Criteria) this;
        }

        public Criteria andDictionarySortNotBetween(Integer value1, Integer value2) {
            addCriterion("dictionary_sort not between", value1, value2, "dictionarySort");
            return (Criteria) this;
        }

        public Criteria andDictionarySourceIsNull() {
            addCriterion("dictionary_source is null");
            return (Criteria) this;
        }

        public Criteria andDictionarySourceIsNotNull() {
            addCriterion("dictionary_source is not null");
            return (Criteria) this;
        }

        public Criteria andDictionarySourceEqualTo(Long value) {
            addCriterion("dictionary_source =", value, "dictionarySource");
            return (Criteria) this;
        }

        public Criteria andDictionarySourceNotEqualTo(Long value) {
            addCriterion("dictionary_source <>", value, "dictionarySource");
            return (Criteria) this;
        }

        public Criteria andDictionarySourceGreaterThan(Long value) {
            addCriterion("dictionary_source >", value, "dictionarySource");
            return (Criteria) this;
        }

        public Criteria andDictionarySourceGreaterThanOrEqualTo(Long value) {
            addCriterion("dictionary_source >=", value, "dictionarySource");
            return (Criteria) this;
        }

        public Criteria andDictionarySourceLessThan(Long value) {
            addCriterion("dictionary_source <", value, "dictionarySource");
            return (Criteria) this;
        }

        public Criteria andDictionarySourceLessThanOrEqualTo(Long value) {
            addCriterion("dictionary_source <=", value, "dictionarySource");
            return (Criteria) this;
        }

        public Criteria andDictionarySourceIn(List<Long> values) {
            addCriterion("dictionary_source in", values, "dictionarySource");
            return (Criteria) this;
        }

        public Criteria andDictionarySourceNotIn(List<Long> values) {
            addCriterion("dictionary_source not in", values, "dictionarySource");
            return (Criteria) this;
        }

        public Criteria andDictionarySourceBetween(Long value1, Long value2) {
            addCriterion("dictionary_source between", value1, value2, "dictionarySource");
            return (Criteria) this;
        }

        public Criteria andDictionarySourceNotBetween(Long value1, Long value2) {
            addCriterion("dictionary_source not between", value1, value2, "dictionarySource");
            return (Criteria) this;
        }

        public Criteria andDictionaryOtherIsNull() {
            addCriterion("dictionary_other is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryOtherIsNotNull() {
            addCriterion("dictionary_other is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryOtherEqualTo(String value) {
            addCriterion("dictionary_other =", value, "dictionaryOther");
            return (Criteria) this;
        }

        public Criteria andDictionaryOtherNotEqualTo(String value) {
            addCriterion("dictionary_other <>", value, "dictionaryOther");
            return (Criteria) this;
        }

        public Criteria andDictionaryOtherGreaterThan(String value) {
            addCriterion("dictionary_other >", value, "dictionaryOther");
            return (Criteria) this;
        }

        public Criteria andDictionaryOtherGreaterThanOrEqualTo(String value) {
            addCriterion("dictionary_other >=", value, "dictionaryOther");
            return (Criteria) this;
        }

        public Criteria andDictionaryOtherLessThan(String value) {
            addCriterion("dictionary_other <", value, "dictionaryOther");
            return (Criteria) this;
        }

        public Criteria andDictionaryOtherLessThanOrEqualTo(String value) {
            addCriterion("dictionary_other <=", value, "dictionaryOther");
            return (Criteria) this;
        }

        public Criteria andDictionaryOtherLike(String value) {
            addCriterion("dictionary_other like", value, "dictionaryOther");
            return (Criteria) this;
        }

        public Criteria andDictionaryOtherNotLike(String value) {
            addCriterion("dictionary_other not like", value, "dictionaryOther");
            return (Criteria) this;
        }

        public Criteria andDictionaryOtherIn(List<String> values) {
            addCriterion("dictionary_other in", values, "dictionaryOther");
            return (Criteria) this;
        }

        public Criteria andDictionaryOtherNotIn(List<String> values) {
            addCriterion("dictionary_other not in", values, "dictionaryOther");
            return (Criteria) this;
        }

        public Criteria andDictionaryOtherBetween(String value1, String value2) {
            addCriterion("dictionary_other between", value1, value2, "dictionaryOther");
            return (Criteria) this;
        }

        public Criteria andDictionaryOtherNotBetween(String value1, String value2) {
            addCriterion("dictionary_other not between", value1, value2, "dictionaryOther");
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