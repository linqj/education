package com.chinayouthedu.zqzc.entity.paike;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogsExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public LogsExample() {
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

        public Criteria andVisitorIdIsNull() {
            addCriterion("visitor_id is null");
            return (Criteria) this;
        }

        public Criteria andVisitorIdIsNotNull() {
            addCriterion("visitor_id is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorIdEqualTo(Long value) {
            addCriterion("visitor_id =", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdNotEqualTo(Long value) {
            addCriterion("visitor_id <>", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdGreaterThan(Long value) {
            addCriterion("visitor_id >", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("visitor_id >=", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdLessThan(Long value) {
            addCriterion("visitor_id <", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdLessThanOrEqualTo(Long value) {
            addCriterion("visitor_id <=", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdIn(List<Long> values) {
            addCriterion("visitor_id in", values, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdNotIn(List<Long> values) {
            addCriterion("visitor_id not in", values, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdBetween(Long value1, Long value2) {
            addCriterion("visitor_id between", value1, value2, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdNotBetween(Long value1, Long value2) {
            addCriterion("visitor_id not between", value1, value2, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVistiorNameIsNull() {
            addCriterion("vistior_name is null");
            return (Criteria) this;
        }

        public Criteria andVistiorNameIsNotNull() {
            addCriterion("vistior_name is not null");
            return (Criteria) this;
        }

        public Criteria andVistiorNameEqualTo(String value) {
            addCriterion("vistior_name =", value, "vistiorName");
            return (Criteria) this;
        }

        public Criteria andVistiorNameNotEqualTo(String value) {
            addCriterion("vistior_name <>", value, "vistiorName");
            return (Criteria) this;
        }

        public Criteria andVistiorNameGreaterThan(String value) {
            addCriterion("vistior_name >", value, "vistiorName");
            return (Criteria) this;
        }

        public Criteria andVistiorNameGreaterThanOrEqualTo(String value) {
            addCriterion("vistior_name >=", value, "vistiorName");
            return (Criteria) this;
        }

        public Criteria andVistiorNameLessThan(String value) {
            addCriterion("vistior_name <", value, "vistiorName");
            return (Criteria) this;
        }

        public Criteria andVistiorNameLessThanOrEqualTo(String value) {
            addCriterion("vistior_name <=", value, "vistiorName");
            return (Criteria) this;
        }

        public Criteria andVistiorNameLike(String value) {
            addCriterion("vistior_name like", value, "vistiorName");
            return (Criteria) this;
        }

        public Criteria andVistiorNameNotLike(String value) {
            addCriterion("vistior_name not like", value, "vistiorName");
            return (Criteria) this;
        }

        public Criteria andVistiorNameIn(List<String> values) {
            addCriterion("vistior_name in", values, "vistiorName");
            return (Criteria) this;
        }

        public Criteria andVistiorNameNotIn(List<String> values) {
            addCriterion("vistior_name not in", values, "vistiorName");
            return (Criteria) this;
        }

        public Criteria andVistiorNameBetween(String value1, String value2) {
            addCriterion("vistior_name between", value1, value2, "vistiorName");
            return (Criteria) this;
        }

        public Criteria andVistiorNameNotBetween(String value1, String value2) {
            addCriterion("vistior_name not between", value1, value2, "vistiorName");
            return (Criteria) this;
        }

        public Criteria andVisitUrlIsNull() {
            addCriterion("visit_url is null");
            return (Criteria) this;
        }

        public Criteria andVisitUrlIsNotNull() {
            addCriterion("visit_url is not null");
            return (Criteria) this;
        }

        public Criteria andVisitUrlEqualTo(String value) {
            addCriterion("visit_url =", value, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlNotEqualTo(String value) {
            addCriterion("visit_url <>", value, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlGreaterThan(String value) {
            addCriterion("visit_url >", value, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlGreaterThanOrEqualTo(String value) {
            addCriterion("visit_url >=", value, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlLessThan(String value) {
            addCriterion("visit_url <", value, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlLessThanOrEqualTo(String value) {
            addCriterion("visit_url <=", value, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlLike(String value) {
            addCriterion("visit_url like", value, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlNotLike(String value) {
            addCriterion("visit_url not like", value, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlIn(List<String> values) {
            addCriterion("visit_url in", values, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlNotIn(List<String> values) {
            addCriterion("visit_url not in", values, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlBetween(String value1, String value2) {
            addCriterion("visit_url between", value1, value2, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitUrlNotBetween(String value1, String value2) {
            addCriterion("visit_url not between", value1, value2, "visitUrl");
            return (Criteria) this;
        }

        public Criteria andVisitorIpIsNull() {
            addCriterion("visitor_ip is null");
            return (Criteria) this;
        }

        public Criteria andVisitorIpIsNotNull() {
            addCriterion("visitor_ip is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorIpEqualTo(String value) {
            addCriterion("visitor_ip =", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpNotEqualTo(String value) {
            addCriterion("visitor_ip <>", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpGreaterThan(String value) {
            addCriterion("visitor_ip >", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpGreaterThanOrEqualTo(String value) {
            addCriterion("visitor_ip >=", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpLessThan(String value) {
            addCriterion("visitor_ip <", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpLessThanOrEqualTo(String value) {
            addCriterion("visitor_ip <=", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpLike(String value) {
            addCriterion("visitor_ip like", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpNotLike(String value) {
            addCriterion("visitor_ip not like", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpIn(List<String> values) {
            addCriterion("visitor_ip in", values, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpNotIn(List<String> values) {
            addCriterion("visitor_ip not in", values, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpBetween(String value1, String value2) {
            addCriterion("visitor_ip between", value1, value2, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpNotBetween(String value1, String value2) {
            addCriterion("visitor_ip not between", value1, value2, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorOsIsNull() {
            addCriterion("visitor_os is null");
            return (Criteria) this;
        }

        public Criteria andVisitorOsIsNotNull() {
            addCriterion("visitor_os is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorOsEqualTo(String value) {
            addCriterion("visitor_os =", value, "visitorOs");
            return (Criteria) this;
        }

        public Criteria andVisitorOsNotEqualTo(String value) {
            addCriterion("visitor_os <>", value, "visitorOs");
            return (Criteria) this;
        }

        public Criteria andVisitorOsGreaterThan(String value) {
            addCriterion("visitor_os >", value, "visitorOs");
            return (Criteria) this;
        }

        public Criteria andVisitorOsGreaterThanOrEqualTo(String value) {
            addCriterion("visitor_os >=", value, "visitorOs");
            return (Criteria) this;
        }

        public Criteria andVisitorOsLessThan(String value) {
            addCriterion("visitor_os <", value, "visitorOs");
            return (Criteria) this;
        }

        public Criteria andVisitorOsLessThanOrEqualTo(String value) {
            addCriterion("visitor_os <=", value, "visitorOs");
            return (Criteria) this;
        }

        public Criteria andVisitorOsLike(String value) {
            addCriterion("visitor_os like", value, "visitorOs");
            return (Criteria) this;
        }

        public Criteria andVisitorOsNotLike(String value) {
            addCriterion("visitor_os not like", value, "visitorOs");
            return (Criteria) this;
        }

        public Criteria andVisitorOsIn(List<String> values) {
            addCriterion("visitor_os in", values, "visitorOs");
            return (Criteria) this;
        }

        public Criteria andVisitorOsNotIn(List<String> values) {
            addCriterion("visitor_os not in", values, "visitorOs");
            return (Criteria) this;
        }

        public Criteria andVisitorOsBetween(String value1, String value2) {
            addCriterion("visitor_os between", value1, value2, "visitorOs");
            return (Criteria) this;
        }

        public Criteria andVisitorOsNotBetween(String value1, String value2) {
            addCriterion("visitor_os not between", value1, value2, "visitorOs");
            return (Criteria) this;
        }

        public Criteria andUserAgentIsNull() {
            addCriterion("user_agent is null");
            return (Criteria) this;
        }

        public Criteria andUserAgentIsNotNull() {
            addCriterion("user_agent is not null");
            return (Criteria) this;
        }

        public Criteria andUserAgentEqualTo(String value) {
            addCriterion("user_agent =", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentNotEqualTo(String value) {
            addCriterion("user_agent <>", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentGreaterThan(String value) {
            addCriterion("user_agent >", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentGreaterThanOrEqualTo(String value) {
            addCriterion("user_agent >=", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentLessThan(String value) {
            addCriterion("user_agent <", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentLessThanOrEqualTo(String value) {
            addCriterion("user_agent <=", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentLike(String value) {
            addCriterion("user_agent like", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentNotLike(String value) {
            addCriterion("user_agent not like", value, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentIn(List<String> values) {
            addCriterion("user_agent in", values, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentNotIn(List<String> values) {
            addCriterion("user_agent not in", values, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentBetween(String value1, String value2) {
            addCriterion("user_agent between", value1, value2, "userAgent");
            return (Criteria) this;
        }

        public Criteria andUserAgentNotBetween(String value1, String value2) {
            addCriterion("user_agent not between", value1, value2, "userAgent");
            return (Criteria) this;
        }

        public Criteria andLogInfoIsNull() {
            addCriterion("log_info is null");
            return (Criteria) this;
        }

        public Criteria andLogInfoIsNotNull() {
            addCriterion("log_info is not null");
            return (Criteria) this;
        }

        public Criteria andLogInfoEqualTo(String value) {
            addCriterion("log_info =", value, "logInfo");
            return (Criteria) this;
        }

        public Criteria andLogInfoNotEqualTo(String value) {
            addCriterion("log_info <>", value, "logInfo");
            return (Criteria) this;
        }

        public Criteria andLogInfoGreaterThan(String value) {
            addCriterion("log_info >", value, "logInfo");
            return (Criteria) this;
        }

        public Criteria andLogInfoGreaterThanOrEqualTo(String value) {
            addCriterion("log_info >=", value, "logInfo");
            return (Criteria) this;
        }

        public Criteria andLogInfoLessThan(String value) {
            addCriterion("log_info <", value, "logInfo");
            return (Criteria) this;
        }

        public Criteria andLogInfoLessThanOrEqualTo(String value) {
            addCriterion("log_info <=", value, "logInfo");
            return (Criteria) this;
        }

        public Criteria andLogInfoLike(String value) {
            addCriterion("log_info like", value, "logInfo");
            return (Criteria) this;
        }

        public Criteria andLogInfoNotLike(String value) {
            addCriterion("log_info not like", value, "logInfo");
            return (Criteria) this;
        }

        public Criteria andLogInfoIn(List<String> values) {
            addCriterion("log_info in", values, "logInfo");
            return (Criteria) this;
        }

        public Criteria andLogInfoNotIn(List<String> values) {
            addCriterion("log_info not in", values, "logInfo");
            return (Criteria) this;
        }

        public Criteria andLogInfoBetween(String value1, String value2) {
            addCriterion("log_info between", value1, value2, "logInfo");
            return (Criteria) this;
        }

        public Criteria andLogInfoNotBetween(String value1, String value2) {
            addCriterion("log_info not between", value1, value2, "logInfo");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNull() {
            addCriterion("log_type is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNotNull() {
            addCriterion("log_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeEqualTo(String value) {
            addCriterion("log_type =", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotEqualTo(String value) {
            addCriterion("log_type <>", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThan(String value) {
            addCriterion("log_type >", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThanOrEqualTo(String value) {
            addCriterion("log_type >=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThan(String value) {
            addCriterion("log_type <", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThanOrEqualTo(String value) {
            addCriterion("log_type <=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLike(String value) {
            addCriterion("log_type like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotLike(String value) {
            addCriterion("log_type not like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeIn(List<String> values) {
            addCriterion("log_type in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotIn(List<String> values) {
            addCriterion("log_type not in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeBetween(String value1, String value2) {
            addCriterion("log_type between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotBetween(String value1, String value2) {
            addCriterion("log_type not between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andStoreLocationIsNull() {
            addCriterion("store_location is null");
            return (Criteria) this;
        }

        public Criteria andStoreLocationIsNotNull() {
            addCriterion("store_location is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLocationEqualTo(String value) {
            addCriterion("store_location =", value, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationNotEqualTo(String value) {
            addCriterion("store_location <>", value, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationGreaterThan(String value) {
            addCriterion("store_location >", value, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationGreaterThanOrEqualTo(String value) {
            addCriterion("store_location >=", value, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationLessThan(String value) {
            addCriterion("store_location <", value, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationLessThanOrEqualTo(String value) {
            addCriterion("store_location <=", value, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationLike(String value) {
            addCriterion("store_location like", value, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationNotLike(String value) {
            addCriterion("store_location not like", value, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationIn(List<String> values) {
            addCriterion("store_location in", values, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationNotIn(List<String> values) {
            addCriterion("store_location not in", values, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationBetween(String value1, String value2) {
            addCriterion("store_location between", value1, value2, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreLocationNotBetween(String value1, String value2) {
            addCriterion("store_location not between", value1, value2, "storeLocation");
            return (Criteria) this;
        }

        public Criteria andStoreSuffixIsNull() {
            addCriterion("store_suffix is null");
            return (Criteria) this;
        }

        public Criteria andStoreSuffixIsNotNull() {
            addCriterion("store_suffix is not null");
            return (Criteria) this;
        }

        public Criteria andStoreSuffixEqualTo(String value) {
            addCriterion("store_suffix =", value, "storeSuffix");
            return (Criteria) this;
        }

        public Criteria andStoreSuffixNotEqualTo(String value) {
            addCriterion("store_suffix <>", value, "storeSuffix");
            return (Criteria) this;
        }

        public Criteria andStoreSuffixGreaterThan(String value) {
            addCriterion("store_suffix >", value, "storeSuffix");
            return (Criteria) this;
        }

        public Criteria andStoreSuffixGreaterThanOrEqualTo(String value) {
            addCriterion("store_suffix >=", value, "storeSuffix");
            return (Criteria) this;
        }

        public Criteria andStoreSuffixLessThan(String value) {
            addCriterion("store_suffix <", value, "storeSuffix");
            return (Criteria) this;
        }

        public Criteria andStoreSuffixLessThanOrEqualTo(String value) {
            addCriterion("store_suffix <=", value, "storeSuffix");
            return (Criteria) this;
        }

        public Criteria andStoreSuffixLike(String value) {
            addCriterion("store_suffix like", value, "storeSuffix");
            return (Criteria) this;
        }

        public Criteria andStoreSuffixNotLike(String value) {
            addCriterion("store_suffix not like", value, "storeSuffix");
            return (Criteria) this;
        }

        public Criteria andStoreSuffixIn(List<String> values) {
            addCriterion("store_suffix in", values, "storeSuffix");
            return (Criteria) this;
        }

        public Criteria andStoreSuffixNotIn(List<String> values) {
            addCriterion("store_suffix not in", values, "storeSuffix");
            return (Criteria) this;
        }

        public Criteria andStoreSuffixBetween(String value1, String value2) {
            addCriterion("store_suffix between", value1, value2, "storeSuffix");
            return (Criteria) this;
        }

        public Criteria andStoreSuffixNotBetween(String value1, String value2) {
            addCriterion("store_suffix not between", value1, value2, "storeSuffix");
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