package com.chinayouthedu.zqzc.entity.paike;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrganizationExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public OrganizationExample() {
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

        public Criteria andParentOrganizationIdIsNull() {
            addCriterion("parent_organization_id is null");
            return (Criteria) this;
        }

        public Criteria andParentOrganizationIdIsNotNull() {
            addCriterion("parent_organization_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentOrganizationIdEqualTo(Long value) {
            addCriterion("parent_organization_id =", value, "parentOrganizationId");
            return (Criteria) this;
        }

        public Criteria andParentOrganizationIdNotEqualTo(Long value) {
            addCriterion("parent_organization_id <>", value, "parentOrganizationId");
            return (Criteria) this;
        }

        public Criteria andParentOrganizationIdGreaterThan(Long value) {
            addCriterion("parent_organization_id >", value, "parentOrganizationId");
            return (Criteria) this;
        }

        public Criteria andParentOrganizationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_organization_id >=", value, "parentOrganizationId");
            return (Criteria) this;
        }

        public Criteria andParentOrganizationIdLessThan(Long value) {
            addCriterion("parent_organization_id <", value, "parentOrganizationId");
            return (Criteria) this;
        }

        public Criteria andParentOrganizationIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_organization_id <=", value, "parentOrganizationId");
            return (Criteria) this;
        }

        public Criteria andParentOrganizationIdIn(List<Long> values) {
            addCriterion("parent_organization_id in", values, "parentOrganizationId");
            return (Criteria) this;
        }

        public Criteria andParentOrganizationIdNotIn(List<Long> values) {
            addCriterion("parent_organization_id not in", values, "parentOrganizationId");
            return (Criteria) this;
        }

        public Criteria andParentOrganizationIdBetween(Long value1, Long value2) {
            addCriterion("parent_organization_id between", value1, value2, "parentOrganizationId");
            return (Criteria) this;
        }

        public Criteria andParentOrganizationIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_organization_id not between", value1, value2, "parentOrganizationId");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameIsNull() {
            addCriterion("organization_name is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameIsNotNull() {
            addCriterion("organization_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameEqualTo(String value) {
            addCriterion("organization_name =", value, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameNotEqualTo(String value) {
            addCriterion("organization_name <>", value, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameGreaterThan(String value) {
            addCriterion("organization_name >", value, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameGreaterThanOrEqualTo(String value) {
            addCriterion("organization_name >=", value, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameLessThan(String value) {
            addCriterion("organization_name <", value, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameLessThanOrEqualTo(String value) {
            addCriterion("organization_name <=", value, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameLike(String value) {
            addCriterion("organization_name like", value, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameNotLike(String value) {
            addCriterion("organization_name not like", value, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameIn(List<String> values) {
            addCriterion("organization_name in", values, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameNotIn(List<String> values) {
            addCriterion("organization_name not in", values, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameBetween(String value1, String value2) {
            addCriterion("organization_name between", value1, value2, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameNotBetween(String value1, String value2) {
            addCriterion("organization_name not between", value1, value2, "organizationName");
            return (Criteria) this;
        }

        public Criteria andForeignLanguageNameIsNull() {
            addCriterion("foreign_language_name is null");
            return (Criteria) this;
        }

        public Criteria andForeignLanguageNameIsNotNull() {
            addCriterion("foreign_language_name is not null");
            return (Criteria) this;
        }

        public Criteria andForeignLanguageNameEqualTo(String value) {
            addCriterion("foreign_language_name =", value, "foreignLanguageName");
            return (Criteria) this;
        }

        public Criteria andForeignLanguageNameNotEqualTo(String value) {
            addCriterion("foreign_language_name <>", value, "foreignLanguageName");
            return (Criteria) this;
        }

        public Criteria andForeignLanguageNameGreaterThan(String value) {
            addCriterion("foreign_language_name >", value, "foreignLanguageName");
            return (Criteria) this;
        }

        public Criteria andForeignLanguageNameGreaterThanOrEqualTo(String value) {
            addCriterion("foreign_language_name >=", value, "foreignLanguageName");
            return (Criteria) this;
        }

        public Criteria andForeignLanguageNameLessThan(String value) {
            addCriterion("foreign_language_name <", value, "foreignLanguageName");
            return (Criteria) this;
        }

        public Criteria andForeignLanguageNameLessThanOrEqualTo(String value) {
            addCriterion("foreign_language_name <=", value, "foreignLanguageName");
            return (Criteria) this;
        }

        public Criteria andForeignLanguageNameLike(String value) {
            addCriterion("foreign_language_name like", value, "foreignLanguageName");
            return (Criteria) this;
        }

        public Criteria andForeignLanguageNameNotLike(String value) {
            addCriterion("foreign_language_name not like", value, "foreignLanguageName");
            return (Criteria) this;
        }

        public Criteria andForeignLanguageNameIn(List<String> values) {
            addCriterion("foreign_language_name in", values, "foreignLanguageName");
            return (Criteria) this;
        }

        public Criteria andForeignLanguageNameNotIn(List<String> values) {
            addCriterion("foreign_language_name not in", values, "foreignLanguageName");
            return (Criteria) this;
        }

        public Criteria andForeignLanguageNameBetween(String value1, String value2) {
            addCriterion("foreign_language_name between", value1, value2, "foreignLanguageName");
            return (Criteria) this;
        }

        public Criteria andForeignLanguageNameNotBetween(String value1, String value2) {
            addCriterion("foreign_language_name not between", value1, value2, "foreignLanguageName");
            return (Criteria) this;
        }

        public Criteria andOrganizationAbbreviationIsNull() {
            addCriterion("organization_abbreviation is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationAbbreviationIsNotNull() {
            addCriterion("organization_abbreviation is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationAbbreviationEqualTo(String value) {
            addCriterion("organization_abbreviation =", value, "organizationAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOrganizationAbbreviationNotEqualTo(String value) {
            addCriterion("organization_abbreviation <>", value, "organizationAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOrganizationAbbreviationGreaterThan(String value) {
            addCriterion("organization_abbreviation >", value, "organizationAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOrganizationAbbreviationGreaterThanOrEqualTo(String value) {
            addCriterion("organization_abbreviation >=", value, "organizationAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOrganizationAbbreviationLessThan(String value) {
            addCriterion("organization_abbreviation <", value, "organizationAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOrganizationAbbreviationLessThanOrEqualTo(String value) {
            addCriterion("organization_abbreviation <=", value, "organizationAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOrganizationAbbreviationLike(String value) {
            addCriterion("organization_abbreviation like", value, "organizationAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOrganizationAbbreviationNotLike(String value) {
            addCriterion("organization_abbreviation not like", value, "organizationAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOrganizationAbbreviationIn(List<String> values) {
            addCriterion("organization_abbreviation in", values, "organizationAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOrganizationAbbreviationNotIn(List<String> values) {
            addCriterion("organization_abbreviation not in", values, "organizationAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOrganizationAbbreviationBetween(String value1, String value2) {
            addCriterion("organization_abbreviation between", value1, value2, "organizationAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOrganizationAbbreviationNotBetween(String value1, String value2) {
            addCriterion("organization_abbreviation not between", value1, value2, "organizationAbbreviation");
            return (Criteria) this;
        }

        public Criteria andOrganizationNatureIsNull() {
            addCriterion("organization_nature is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationNatureIsNotNull() {
            addCriterion("organization_nature is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationNatureEqualTo(String value) {
            addCriterion("organization_nature =", value, "organizationNature");
            return (Criteria) this;
        }

        public Criteria andOrganizationNatureNotEqualTo(String value) {
            addCriterion("organization_nature <>", value, "organizationNature");
            return (Criteria) this;
        }

        public Criteria andOrganizationNatureGreaterThan(String value) {
            addCriterion("organization_nature >", value, "organizationNature");
            return (Criteria) this;
        }

        public Criteria andOrganizationNatureGreaterThanOrEqualTo(String value) {
            addCriterion("organization_nature >=", value, "organizationNature");
            return (Criteria) this;
        }

        public Criteria andOrganizationNatureLessThan(String value) {
            addCriterion("organization_nature <", value, "organizationNature");
            return (Criteria) this;
        }

        public Criteria andOrganizationNatureLessThanOrEqualTo(String value) {
            addCriterion("organization_nature <=", value, "organizationNature");
            return (Criteria) this;
        }

        public Criteria andOrganizationNatureLike(String value) {
            addCriterion("organization_nature like", value, "organizationNature");
            return (Criteria) this;
        }

        public Criteria andOrganizationNatureNotLike(String value) {
            addCriterion("organization_nature not like", value, "organizationNature");
            return (Criteria) this;
        }

        public Criteria andOrganizationNatureIn(List<String> values) {
            addCriterion("organization_nature in", values, "organizationNature");
            return (Criteria) this;
        }

        public Criteria andOrganizationNatureNotIn(List<String> values) {
            addCriterion("organization_nature not in", values, "organizationNature");
            return (Criteria) this;
        }

        public Criteria andOrganizationNatureBetween(String value1, String value2) {
            addCriterion("organization_nature between", value1, value2, "organizationNature");
            return (Criteria) this;
        }

        public Criteria andOrganizationNatureNotBetween(String value1, String value2) {
            addCriterion("organization_nature not between", value1, value2, "organizationNature");
            return (Criteria) this;
        }

        public Criteria andOrganizationAddressIsNull() {
            addCriterion("organization_address is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationAddressIsNotNull() {
            addCriterion("organization_address is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationAddressEqualTo(String value) {
            addCriterion("organization_address =", value, "organizationAddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationAddressNotEqualTo(String value) {
            addCriterion("organization_address <>", value, "organizationAddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationAddressGreaterThan(String value) {
            addCriterion("organization_address >", value, "organizationAddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationAddressGreaterThanOrEqualTo(String value) {
            addCriterion("organization_address >=", value, "organizationAddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationAddressLessThan(String value) {
            addCriterion("organization_address <", value, "organizationAddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationAddressLessThanOrEqualTo(String value) {
            addCriterion("organization_address <=", value, "organizationAddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationAddressLike(String value) {
            addCriterion("organization_address like", value, "organizationAddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationAddressNotLike(String value) {
            addCriterion("organization_address not like", value, "organizationAddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationAddressIn(List<String> values) {
            addCriterion("organization_address in", values, "organizationAddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationAddressNotIn(List<String> values) {
            addCriterion("organization_address not in", values, "organizationAddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationAddressBetween(String value1, String value2) {
            addCriterion("organization_address between", value1, value2, "organizationAddress");
            return (Criteria) this;
        }

        public Criteria andOrganizationAddressNotBetween(String value1, String value2) {
            addCriterion("organization_address not between", value1, value2, "organizationAddress");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNull() {
            addCriterion("legal_person is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNotNull() {
            addCriterion("legal_person is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonEqualTo(String value) {
            addCriterion("legal_person =", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotEqualTo(String value) {
            addCriterion("legal_person <>", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThan(String value) {
            addCriterion("legal_person >", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person >=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThan(String value) {
            addCriterion("legal_person <", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThanOrEqualTo(String value) {
            addCriterion("legal_person <=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLike(String value) {
            addCriterion("legal_person like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotLike(String value) {
            addCriterion("legal_person not like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIn(List<String> values) {
            addCriterion("legal_person in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotIn(List<String> values) {
            addCriterion("legal_person not in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonBetween(String value1, String value2) {
            addCriterion("legal_person between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotBetween(String value1, String value2) {
            addCriterion("legal_person not between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andOrganizationFounderIsNull() {
            addCriterion("organization_founder is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationFounderIsNotNull() {
            addCriterion("organization_founder is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationFounderEqualTo(String value) {
            addCriterion("organization_founder =", value, "organizationFounder");
            return (Criteria) this;
        }

        public Criteria andOrganizationFounderNotEqualTo(String value) {
            addCriterion("organization_founder <>", value, "organizationFounder");
            return (Criteria) this;
        }

        public Criteria andOrganizationFounderGreaterThan(String value) {
            addCriterion("organization_founder >", value, "organizationFounder");
            return (Criteria) this;
        }

        public Criteria andOrganizationFounderGreaterThanOrEqualTo(String value) {
            addCriterion("organization_founder >=", value, "organizationFounder");
            return (Criteria) this;
        }

        public Criteria andOrganizationFounderLessThan(String value) {
            addCriterion("organization_founder <", value, "organizationFounder");
            return (Criteria) this;
        }

        public Criteria andOrganizationFounderLessThanOrEqualTo(String value) {
            addCriterion("organization_founder <=", value, "organizationFounder");
            return (Criteria) this;
        }

        public Criteria andOrganizationFounderLike(String value) {
            addCriterion("organization_founder like", value, "organizationFounder");
            return (Criteria) this;
        }

        public Criteria andOrganizationFounderNotLike(String value) {
            addCriterion("organization_founder not like", value, "organizationFounder");
            return (Criteria) this;
        }

        public Criteria andOrganizationFounderIn(List<String> values) {
            addCriterion("organization_founder in", values, "organizationFounder");
            return (Criteria) this;
        }

        public Criteria andOrganizationFounderNotIn(List<String> values) {
            addCriterion("organization_founder not in", values, "organizationFounder");
            return (Criteria) this;
        }

        public Criteria andOrganizationFounderBetween(String value1, String value2) {
            addCriterion("organization_founder between", value1, value2, "organizationFounder");
            return (Criteria) this;
        }

        public Criteria andOrganizationFounderNotBetween(String value1, String value2) {
            addCriterion("organization_founder not between", value1, value2, "organizationFounder");
            return (Criteria) this;
        }

        public Criteria andSetupTimeIsNull() {
            addCriterion("setup_time is null");
            return (Criteria) this;
        }

        public Criteria andSetupTimeIsNotNull() {
            addCriterion("setup_time is not null");
            return (Criteria) this;
        }

        public Criteria andSetupTimeEqualTo(Date value) {
            addCriterion("setup_time =", value, "setupTime");
            return (Criteria) this;
        }

        public Criteria andSetupTimeNotEqualTo(Date value) {
            addCriterion("setup_time <>", value, "setupTime");
            return (Criteria) this;
        }

        public Criteria andSetupTimeGreaterThan(Date value) {
            addCriterion("setup_time >", value, "setupTime");
            return (Criteria) this;
        }

        public Criteria andSetupTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("setup_time >=", value, "setupTime");
            return (Criteria) this;
        }

        public Criteria andSetupTimeLessThan(Date value) {
            addCriterion("setup_time <", value, "setupTime");
            return (Criteria) this;
        }

        public Criteria andSetupTimeLessThanOrEqualTo(Date value) {
            addCriterion("setup_time <=", value, "setupTime");
            return (Criteria) this;
        }

        public Criteria andSetupTimeIn(List<Date> values) {
            addCriterion("setup_time in", values, "setupTime");
            return (Criteria) this;
        }

        public Criteria andSetupTimeNotIn(List<Date> values) {
            addCriterion("setup_time not in", values, "setupTime");
            return (Criteria) this;
        }

        public Criteria andSetupTimeBetween(Date value1, Date value2) {
            addCriterion("setup_time between", value1, value2, "setupTime");
            return (Criteria) this;
        }

        public Criteria andSetupTimeNotBetween(Date value1, Date value2) {
            addCriterion("setup_time not between", value1, value2, "setupTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeIsNull() {
            addCriterion("listing_time is null");
            return (Criteria) this;
        }

        public Criteria andListingTimeIsNotNull() {
            addCriterion("listing_time is not null");
            return (Criteria) this;
        }

        public Criteria andListingTimeEqualTo(Date value) {
            addCriterion("listing_time =", value, "listingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeNotEqualTo(Date value) {
            addCriterion("listing_time <>", value, "listingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeGreaterThan(Date value) {
            addCriterion("listing_time >", value, "listingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("listing_time >=", value, "listingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeLessThan(Date value) {
            addCriterion("listing_time <", value, "listingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeLessThanOrEqualTo(Date value) {
            addCriterion("listing_time <=", value, "listingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeIn(List<Date> values) {
            addCriterion("listing_time in", values, "listingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeNotIn(List<Date> values) {
            addCriterion("listing_time not in", values, "listingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeBetween(Date value1, Date value2) {
            addCriterion("listing_time between", value1, value2, "listingTime");
            return (Criteria) this;
        }

        public Criteria andListingTimeNotBetween(Date value1, Date value2) {
            addCriterion("listing_time not between", value1, value2, "listingTime");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeIsNull() {
            addCriterion("organization_type is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeIsNotNull() {
            addCriterion("organization_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeEqualTo(String value) {
            addCriterion("organization_type =", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeNotEqualTo(String value) {
            addCriterion("organization_type <>", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeGreaterThan(String value) {
            addCriterion("organization_type >", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("organization_type >=", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeLessThan(String value) {
            addCriterion("organization_type <", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeLessThanOrEqualTo(String value) {
            addCriterion("organization_type <=", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeLike(String value) {
            addCriterion("organization_type like", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeNotLike(String value) {
            addCriterion("organization_type not like", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeIn(List<String> values) {
            addCriterion("organization_type in", values, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeNotIn(List<String> values) {
            addCriterion("organization_type not in", values, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeBetween(String value1, String value2) {
            addCriterion("organization_type between", value1, value2, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeNotBetween(String value1, String value2) {
            addCriterion("organization_type not between", value1, value2, "organizationType");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("industry like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("industry not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("industry not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNull() {
            addCriterion("credit_code is null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNotNull() {
            addCriterion("credit_code is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeEqualTo(String value) {
            addCriterion("credit_code =", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotEqualTo(String value) {
            addCriterion("credit_code <>", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThan(String value) {
            addCriterion("credit_code >", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("credit_code >=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThan(String value) {
            addCriterion("credit_code <", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThanOrEqualTo(String value) {
            addCriterion("credit_code <=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLike(String value) {
            addCriterion("credit_code like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotLike(String value) {
            addCriterion("credit_code not like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIn(List<String> values) {
            addCriterion("credit_code in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotIn(List<String> values) {
            addCriterion("credit_code not in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeBetween(String value1, String value2) {
            addCriterion("credit_code between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotBetween(String value1, String value2) {
            addCriterion("credit_code not between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeIsNull() {
            addCriterion("organization_code is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeIsNotNull() {
            addCriterion("organization_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeEqualTo(String value) {
            addCriterion("organization_code =", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotEqualTo(String value) {
            addCriterion("organization_code <>", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeGreaterThan(String value) {
            addCriterion("organization_code >", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("organization_code >=", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeLessThan(String value) {
            addCriterion("organization_code <", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeLessThanOrEqualTo(String value) {
            addCriterion("organization_code <=", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeLike(String value) {
            addCriterion("organization_code like", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotLike(String value) {
            addCriterion("organization_code not like", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeIn(List<String> values) {
            addCriterion("organization_code in", values, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotIn(List<String> values) {
            addCriterion("organization_code not in", values, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeBetween(String value1, String value2) {
            addCriterion("organization_code between", value1, value2, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotBetween(String value1, String value2) {
            addCriterion("organization_code not between", value1, value2, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andZczxCodeIsNull() {
            addCriterion("zczx_code is null");
            return (Criteria) this;
        }

        public Criteria andZczxCodeIsNotNull() {
            addCriterion("zczx_code is not null");
            return (Criteria) this;
        }

        public Criteria andZczxCodeEqualTo(String value) {
            addCriterion("zczx_code =", value, "zczxCode");
            return (Criteria) this;
        }

        public Criteria andZczxCodeNotEqualTo(String value) {
            addCriterion("zczx_code <>", value, "zczxCode");
            return (Criteria) this;
        }

        public Criteria andZczxCodeGreaterThan(String value) {
            addCriterion("zczx_code >", value, "zczxCode");
            return (Criteria) this;
        }

        public Criteria andZczxCodeGreaterThanOrEqualTo(String value) {
            addCriterion("zczx_code >=", value, "zczxCode");
            return (Criteria) this;
        }

        public Criteria andZczxCodeLessThan(String value) {
            addCriterion("zczx_code <", value, "zczxCode");
            return (Criteria) this;
        }

        public Criteria andZczxCodeLessThanOrEqualTo(String value) {
            addCriterion("zczx_code <=", value, "zczxCode");
            return (Criteria) this;
        }

        public Criteria andZczxCodeLike(String value) {
            addCriterion("zczx_code like", value, "zczxCode");
            return (Criteria) this;
        }

        public Criteria andZczxCodeNotLike(String value) {
            addCriterion("zczx_code not like", value, "zczxCode");
            return (Criteria) this;
        }

        public Criteria andZczxCodeIn(List<String> values) {
            addCriterion("zczx_code in", values, "zczxCode");
            return (Criteria) this;
        }

        public Criteria andZczxCodeNotIn(List<String> values) {
            addCriterion("zczx_code not in", values, "zczxCode");
            return (Criteria) this;
        }

        public Criteria andZczxCodeBetween(String value1, String value2) {
            addCriterion("zczx_code between", value1, value2, "zczxCode");
            return (Criteria) this;
        }

        public Criteria andZczxCodeNotBetween(String value1, String value2) {
            addCriterion("zczx_code not between", value1, value2, "zczxCode");
            return (Criteria) this;
        }

        public Criteria andManagementStatusIsNull() {
            addCriterion("management_status is null");
            return (Criteria) this;
        }

        public Criteria andManagementStatusIsNotNull() {
            addCriterion("management_status is not null");
            return (Criteria) this;
        }

        public Criteria andManagementStatusEqualTo(String value) {
            addCriterion("management_status =", value, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusNotEqualTo(String value) {
            addCriterion("management_status <>", value, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusGreaterThan(String value) {
            addCriterion("management_status >", value, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusGreaterThanOrEqualTo(String value) {
            addCriterion("management_status >=", value, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusLessThan(String value) {
            addCriterion("management_status <", value, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusLessThanOrEqualTo(String value) {
            addCriterion("management_status <=", value, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusLike(String value) {
            addCriterion("management_status like", value, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusNotLike(String value) {
            addCriterion("management_status not like", value, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusIn(List<String> values) {
            addCriterion("management_status in", values, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusNotIn(List<String> values) {
            addCriterion("management_status not in", values, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusBetween(String value1, String value2) {
            addCriterion("management_status between", value1, value2, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andManagementStatusNotBetween(String value1, String value2) {
            addCriterion("management_status not between", value1, value2, "managementStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessTermIsNull() {
            addCriterion("business_term is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTermIsNotNull() {
            addCriterion("business_term is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTermEqualTo(String value) {
            addCriterion("business_term =", value, "businessTerm");
            return (Criteria) this;
        }

        public Criteria andBusinessTermNotEqualTo(String value) {
            addCriterion("business_term <>", value, "businessTerm");
            return (Criteria) this;
        }

        public Criteria andBusinessTermGreaterThan(String value) {
            addCriterion("business_term >", value, "businessTerm");
            return (Criteria) this;
        }

        public Criteria andBusinessTermGreaterThanOrEqualTo(String value) {
            addCriterion("business_term >=", value, "businessTerm");
            return (Criteria) this;
        }

        public Criteria andBusinessTermLessThan(String value) {
            addCriterion("business_term <", value, "businessTerm");
            return (Criteria) this;
        }

        public Criteria andBusinessTermLessThanOrEqualTo(String value) {
            addCriterion("business_term <=", value, "businessTerm");
            return (Criteria) this;
        }

        public Criteria andBusinessTermLike(String value) {
            addCriterion("business_term like", value, "businessTerm");
            return (Criteria) this;
        }

        public Criteria andBusinessTermNotLike(String value) {
            addCriterion("business_term not like", value, "businessTerm");
            return (Criteria) this;
        }

        public Criteria andBusinessTermIn(List<String> values) {
            addCriterion("business_term in", values, "businessTerm");
            return (Criteria) this;
        }

        public Criteria andBusinessTermNotIn(List<String> values) {
            addCriterion("business_term not in", values, "businessTerm");
            return (Criteria) this;
        }

        public Criteria andBusinessTermBetween(String value1, String value2) {
            addCriterion("business_term between", value1, value2, "businessTerm");
            return (Criteria) this;
        }

        public Criteria andBusinessTermNotBetween(String value1, String value2) {
            addCriterion("business_term not between", value1, value2, "businessTerm");
            return (Criteria) this;
        }

        public Criteria andLicenseTimeIsNull() {
            addCriterion("license_time is null");
            return (Criteria) this;
        }

        public Criteria andLicenseTimeIsNotNull() {
            addCriterion("license_time is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseTimeEqualTo(Date value) {
            addCriterion("license_time =", value, "licenseTime");
            return (Criteria) this;
        }

        public Criteria andLicenseTimeNotEqualTo(Date value) {
            addCriterion("license_time <>", value, "licenseTime");
            return (Criteria) this;
        }

        public Criteria andLicenseTimeGreaterThan(Date value) {
            addCriterion("license_time >", value, "licenseTime");
            return (Criteria) this;
        }

        public Criteria andLicenseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("license_time >=", value, "licenseTime");
            return (Criteria) this;
        }

        public Criteria andLicenseTimeLessThan(Date value) {
            addCriterion("license_time <", value, "licenseTime");
            return (Criteria) this;
        }

        public Criteria andLicenseTimeLessThanOrEqualTo(Date value) {
            addCriterion("license_time <=", value, "licenseTime");
            return (Criteria) this;
        }

        public Criteria andLicenseTimeIn(List<Date> values) {
            addCriterion("license_time in", values, "licenseTime");
            return (Criteria) this;
        }

        public Criteria andLicenseTimeNotIn(List<Date> values) {
            addCriterion("license_time not in", values, "licenseTime");
            return (Criteria) this;
        }

        public Criteria andLicenseTimeBetween(Date value1, Date value2) {
            addCriterion("license_time between", value1, value2, "licenseTime");
            return (Criteria) this;
        }

        public Criteria andLicenseTimeNotBetween(Date value1, Date value2) {
            addCriterion("license_time not between", value1, value2, "licenseTime");
            return (Criteria) this;
        }

        public Criteria andZczxCapitalIsNull() {
            addCriterion("zczx_capital is null");
            return (Criteria) this;
        }

        public Criteria andZczxCapitalIsNotNull() {
            addCriterion("zczx_capital is not null");
            return (Criteria) this;
        }

        public Criteria andZczxCapitalEqualTo(String value) {
            addCriterion("zczx_capital =", value, "zczxCapital");
            return (Criteria) this;
        }

        public Criteria andZczxCapitalNotEqualTo(String value) {
            addCriterion("zczx_capital <>", value, "zczxCapital");
            return (Criteria) this;
        }

        public Criteria andZczxCapitalGreaterThan(String value) {
            addCriterion("zczx_capital >", value, "zczxCapital");
            return (Criteria) this;
        }

        public Criteria andZczxCapitalGreaterThanOrEqualTo(String value) {
            addCriterion("zczx_capital >=", value, "zczxCapital");
            return (Criteria) this;
        }

        public Criteria andZczxCapitalLessThan(String value) {
            addCriterion("zczx_capital <", value, "zczxCapital");
            return (Criteria) this;
        }

        public Criteria andZczxCapitalLessThanOrEqualTo(String value) {
            addCriterion("zczx_capital <=", value, "zczxCapital");
            return (Criteria) this;
        }

        public Criteria andZczxCapitalLike(String value) {
            addCriterion("zczx_capital like", value, "zczxCapital");
            return (Criteria) this;
        }

        public Criteria andZczxCapitalNotLike(String value) {
            addCriterion("zczx_capital not like", value, "zczxCapital");
            return (Criteria) this;
        }

        public Criteria andZczxCapitalIn(List<String> values) {
            addCriterion("zczx_capital in", values, "zczxCapital");
            return (Criteria) this;
        }

        public Criteria andZczxCapitalNotIn(List<String> values) {
            addCriterion("zczx_capital not in", values, "zczxCapital");
            return (Criteria) this;
        }

        public Criteria andZczxCapitalBetween(String value1, String value2) {
            addCriterion("zczx_capital between", value1, value2, "zczxCapital");
            return (Criteria) this;
        }

        public Criteria andZczxCapitalNotBetween(String value1, String value2) {
            addCriterion("zczx_capital not between", value1, value2, "zczxCapital");
            return (Criteria) this;
        }

        public Criteria andZczxOfficeIsNull() {
            addCriterion("zczx_office is null");
            return (Criteria) this;
        }

        public Criteria andZczxOfficeIsNotNull() {
            addCriterion("zczx_office is not null");
            return (Criteria) this;
        }

        public Criteria andZczxOfficeEqualTo(String value) {
            addCriterion("zczx_office =", value, "zczxOffice");
            return (Criteria) this;
        }

        public Criteria andZczxOfficeNotEqualTo(String value) {
            addCriterion("zczx_office <>", value, "zczxOffice");
            return (Criteria) this;
        }

        public Criteria andZczxOfficeGreaterThan(String value) {
            addCriterion("zczx_office >", value, "zczxOffice");
            return (Criteria) this;
        }

        public Criteria andZczxOfficeGreaterThanOrEqualTo(String value) {
            addCriterion("zczx_office >=", value, "zczxOffice");
            return (Criteria) this;
        }

        public Criteria andZczxOfficeLessThan(String value) {
            addCriterion("zczx_office <", value, "zczxOffice");
            return (Criteria) this;
        }

        public Criteria andZczxOfficeLessThanOrEqualTo(String value) {
            addCriterion("zczx_office <=", value, "zczxOffice");
            return (Criteria) this;
        }

        public Criteria andZczxOfficeLike(String value) {
            addCriterion("zczx_office like", value, "zczxOffice");
            return (Criteria) this;
        }

        public Criteria andZczxOfficeNotLike(String value) {
            addCriterion("zczx_office not like", value, "zczxOffice");
            return (Criteria) this;
        }

        public Criteria andZczxOfficeIn(List<String> values) {
            addCriterion("zczx_office in", values, "zczxOffice");
            return (Criteria) this;
        }

        public Criteria andZczxOfficeNotIn(List<String> values) {
            addCriterion("zczx_office not in", values, "zczxOffice");
            return (Criteria) this;
        }

        public Criteria andZczxOfficeBetween(String value1, String value2) {
            addCriterion("zczx_office between", value1, value2, "zczxOffice");
            return (Criteria) this;
        }

        public Criteria andZczxOfficeNotBetween(String value1, String value2) {
            addCriterion("zczx_office not between", value1, value2, "zczxOffice");
            return (Criteria) this;
        }

        public Criteria andStockCodeIsNull() {
            addCriterion("stock_code is null");
            return (Criteria) this;
        }

        public Criteria andStockCodeIsNotNull() {
            addCriterion("stock_code is not null");
            return (Criteria) this;
        }

        public Criteria andStockCodeEqualTo(String value) {
            addCriterion("stock_code =", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotEqualTo(String value) {
            addCriterion("stock_code <>", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeGreaterThan(String value) {
            addCriterion("stock_code >", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeGreaterThanOrEqualTo(String value) {
            addCriterion("stock_code >=", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLessThan(String value) {
            addCriterion("stock_code <", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLessThanOrEqualTo(String value) {
            addCriterion("stock_code <=", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLike(String value) {
            addCriterion("stock_code like", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotLike(String value) {
            addCriterion("stock_code not like", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeIn(List<String> values) {
            addCriterion("stock_code in", values, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotIn(List<String> values) {
            addCriterion("stock_code not in", values, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeBetween(String value1, String value2) {
            addCriterion("stock_code between", value1, value2, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotBetween(String value1, String value2) {
            addCriterion("stock_code not between", value1, value2, "stockCode");
            return (Criteria) this;
        }

        public Criteria andYearlyTurnoverIsNull() {
            addCriterion("yearly_turnover is null");
            return (Criteria) this;
        }

        public Criteria andYearlyTurnoverIsNotNull() {
            addCriterion("yearly_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andYearlyTurnoverEqualTo(String value) {
            addCriterion("yearly_turnover =", value, "yearlyTurnover");
            return (Criteria) this;
        }

        public Criteria andYearlyTurnoverNotEqualTo(String value) {
            addCriterion("yearly_turnover <>", value, "yearlyTurnover");
            return (Criteria) this;
        }

        public Criteria andYearlyTurnoverGreaterThan(String value) {
            addCriterion("yearly_turnover >", value, "yearlyTurnover");
            return (Criteria) this;
        }

        public Criteria andYearlyTurnoverGreaterThanOrEqualTo(String value) {
            addCriterion("yearly_turnover >=", value, "yearlyTurnover");
            return (Criteria) this;
        }

        public Criteria andYearlyTurnoverLessThan(String value) {
            addCriterion("yearly_turnover <", value, "yearlyTurnover");
            return (Criteria) this;
        }

        public Criteria andYearlyTurnoverLessThanOrEqualTo(String value) {
            addCriterion("yearly_turnover <=", value, "yearlyTurnover");
            return (Criteria) this;
        }

        public Criteria andYearlyTurnoverLike(String value) {
            addCriterion("yearly_turnover like", value, "yearlyTurnover");
            return (Criteria) this;
        }

        public Criteria andYearlyTurnoverNotLike(String value) {
            addCriterion("yearly_turnover not like", value, "yearlyTurnover");
            return (Criteria) this;
        }

        public Criteria andYearlyTurnoverIn(List<String> values) {
            addCriterion("yearly_turnover in", values, "yearlyTurnover");
            return (Criteria) this;
        }

        public Criteria andYearlyTurnoverNotIn(List<String> values) {
            addCriterion("yearly_turnover not in", values, "yearlyTurnover");
            return (Criteria) this;
        }

        public Criteria andYearlyTurnoverBetween(String value1, String value2) {
            addCriterion("yearly_turnover between", value1, value2, "yearlyTurnover");
            return (Criteria) this;
        }

        public Criteria andYearlyTurnoverNotBetween(String value1, String value2) {
            addCriterion("yearly_turnover not between", value1, value2, "yearlyTurnover");
            return (Criteria) this;
        }

        public Criteria andOrganizationMissionIsNull() {
            addCriterion("organization_mission is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationMissionIsNotNull() {
            addCriterion("organization_mission is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationMissionEqualTo(String value) {
            addCriterion("organization_mission =", value, "organizationMission");
            return (Criteria) this;
        }

        public Criteria andOrganizationMissionNotEqualTo(String value) {
            addCriterion("organization_mission <>", value, "organizationMission");
            return (Criteria) this;
        }

        public Criteria andOrganizationMissionGreaterThan(String value) {
            addCriterion("organization_mission >", value, "organizationMission");
            return (Criteria) this;
        }

        public Criteria andOrganizationMissionGreaterThanOrEqualTo(String value) {
            addCriterion("organization_mission >=", value, "organizationMission");
            return (Criteria) this;
        }

        public Criteria andOrganizationMissionLessThan(String value) {
            addCriterion("organization_mission <", value, "organizationMission");
            return (Criteria) this;
        }

        public Criteria andOrganizationMissionLessThanOrEqualTo(String value) {
            addCriterion("organization_mission <=", value, "organizationMission");
            return (Criteria) this;
        }

        public Criteria andOrganizationMissionLike(String value) {
            addCriterion("organization_mission like", value, "organizationMission");
            return (Criteria) this;
        }

        public Criteria andOrganizationMissionNotLike(String value) {
            addCriterion("organization_mission not like", value, "organizationMission");
            return (Criteria) this;
        }

        public Criteria andOrganizationMissionIn(List<String> values) {
            addCriterion("organization_mission in", values, "organizationMission");
            return (Criteria) this;
        }

        public Criteria andOrganizationMissionNotIn(List<String> values) {
            addCriterion("organization_mission not in", values, "organizationMission");
            return (Criteria) this;
        }

        public Criteria andOrganizationMissionBetween(String value1, String value2) {
            addCriterion("organization_mission between", value1, value2, "organizationMission");
            return (Criteria) this;
        }

        public Criteria andOrganizationMissionNotBetween(String value1, String value2) {
            addCriterion("organization_mission not between", value1, value2, "organizationMission");
            return (Criteria) this;
        }

        public Criteria andOrganizationHttpIsNull() {
            addCriterion("organization_http is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationHttpIsNotNull() {
            addCriterion("organization_http is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationHttpEqualTo(String value) {
            addCriterion("organization_http =", value, "organizationHttp");
            return (Criteria) this;
        }

        public Criteria andOrganizationHttpNotEqualTo(String value) {
            addCriterion("organization_http <>", value, "organizationHttp");
            return (Criteria) this;
        }

        public Criteria andOrganizationHttpGreaterThan(String value) {
            addCriterion("organization_http >", value, "organizationHttp");
            return (Criteria) this;
        }

        public Criteria andOrganizationHttpGreaterThanOrEqualTo(String value) {
            addCriterion("organization_http >=", value, "organizationHttp");
            return (Criteria) this;
        }

        public Criteria andOrganizationHttpLessThan(String value) {
            addCriterion("organization_http <", value, "organizationHttp");
            return (Criteria) this;
        }

        public Criteria andOrganizationHttpLessThanOrEqualTo(String value) {
            addCriterion("organization_http <=", value, "organizationHttp");
            return (Criteria) this;
        }

        public Criteria andOrganizationHttpLike(String value) {
            addCriterion("organization_http like", value, "organizationHttp");
            return (Criteria) this;
        }

        public Criteria andOrganizationHttpNotLike(String value) {
            addCriterion("organization_http not like", value, "organizationHttp");
            return (Criteria) this;
        }

        public Criteria andOrganizationHttpIn(List<String> values) {
            addCriterion("organization_http in", values, "organizationHttp");
            return (Criteria) this;
        }

        public Criteria andOrganizationHttpNotIn(List<String> values) {
            addCriterion("organization_http not in", values, "organizationHttp");
            return (Criteria) this;
        }

        public Criteria andOrganizationHttpBetween(String value1, String value2) {
            addCriterion("organization_http between", value1, value2, "organizationHttp");
            return (Criteria) this;
        }

        public Criteria andOrganizationHttpNotBetween(String value1, String value2) {
            addCriterion("organization_http not between", value1, value2, "organizationHttp");
            return (Criteria) this;
        }

        public Criteria andOrganizationCultureIsNull() {
            addCriterion("organization_culture is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationCultureIsNotNull() {
            addCriterion("organization_culture is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationCultureEqualTo(String value) {
            addCriterion("organization_culture =", value, "organizationCulture");
            return (Criteria) this;
        }

        public Criteria andOrganizationCultureNotEqualTo(String value) {
            addCriterion("organization_culture <>", value, "organizationCulture");
            return (Criteria) this;
        }

        public Criteria andOrganizationCultureGreaterThan(String value) {
            addCriterion("organization_culture >", value, "organizationCulture");
            return (Criteria) this;
        }

        public Criteria andOrganizationCultureGreaterThanOrEqualTo(String value) {
            addCriterion("organization_culture >=", value, "organizationCulture");
            return (Criteria) this;
        }

        public Criteria andOrganizationCultureLessThan(String value) {
            addCriterion("organization_culture <", value, "organizationCulture");
            return (Criteria) this;
        }

        public Criteria andOrganizationCultureLessThanOrEqualTo(String value) {
            addCriterion("organization_culture <=", value, "organizationCulture");
            return (Criteria) this;
        }

        public Criteria andOrganizationCultureLike(String value) {
            addCriterion("organization_culture like", value, "organizationCulture");
            return (Criteria) this;
        }

        public Criteria andOrganizationCultureNotLike(String value) {
            addCriterion("organization_culture not like", value, "organizationCulture");
            return (Criteria) this;
        }

        public Criteria andOrganizationCultureIn(List<String> values) {
            addCriterion("organization_culture in", values, "organizationCulture");
            return (Criteria) this;
        }

        public Criteria andOrganizationCultureNotIn(List<String> values) {
            addCriterion("organization_culture not in", values, "organizationCulture");
            return (Criteria) this;
        }

        public Criteria andOrganizationCultureBetween(String value1, String value2) {
            addCriterion("organization_culture between", value1, value2, "organizationCulture");
            return (Criteria) this;
        }

        public Criteria andOrganizationCultureNotBetween(String value1, String value2) {
            addCriterion("organization_culture not between", value1, value2, "organizationCulture");
            return (Criteria) this;
        }

        public Criteria andOrganizationPartnerIsNull() {
            addCriterion("organization_partner is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationPartnerIsNotNull() {
            addCriterion("organization_partner is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationPartnerEqualTo(String value) {
            addCriterion("organization_partner =", value, "organizationPartner");
            return (Criteria) this;
        }

        public Criteria andOrganizationPartnerNotEqualTo(String value) {
            addCriterion("organization_partner <>", value, "organizationPartner");
            return (Criteria) this;
        }

        public Criteria andOrganizationPartnerGreaterThan(String value) {
            addCriterion("organization_partner >", value, "organizationPartner");
            return (Criteria) this;
        }

        public Criteria andOrganizationPartnerGreaterThanOrEqualTo(String value) {
            addCriterion("organization_partner >=", value, "organizationPartner");
            return (Criteria) this;
        }

        public Criteria andOrganizationPartnerLessThan(String value) {
            addCriterion("organization_partner <", value, "organizationPartner");
            return (Criteria) this;
        }

        public Criteria andOrganizationPartnerLessThanOrEqualTo(String value) {
            addCriterion("organization_partner <=", value, "organizationPartner");
            return (Criteria) this;
        }

        public Criteria andOrganizationPartnerLike(String value) {
            addCriterion("organization_partner like", value, "organizationPartner");
            return (Criteria) this;
        }

        public Criteria andOrganizationPartnerNotLike(String value) {
            addCriterion("organization_partner not like", value, "organizationPartner");
            return (Criteria) this;
        }

        public Criteria andOrganizationPartnerIn(List<String> values) {
            addCriterion("organization_partner in", values, "organizationPartner");
            return (Criteria) this;
        }

        public Criteria andOrganizationPartnerNotIn(List<String> values) {
            addCriterion("organization_partner not in", values, "organizationPartner");
            return (Criteria) this;
        }

        public Criteria andOrganizationPartnerBetween(String value1, String value2) {
            addCriterion("organization_partner between", value1, value2, "organizationPartner");
            return (Criteria) this;
        }

        public Criteria andOrganizationPartnerNotBetween(String value1, String value2) {
            addCriterion("organization_partner not between", value1, value2, "organizationPartner");
            return (Criteria) this;
        }

        public Criteria andOrganizationShareholderIsNull() {
            addCriterion("organization_shareholder is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationShareholderIsNotNull() {
            addCriterion("organization_shareholder is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationShareholderEqualTo(String value) {
            addCriterion("organization_shareholder =", value, "organizationShareholder");
            return (Criteria) this;
        }

        public Criteria andOrganizationShareholderNotEqualTo(String value) {
            addCriterion("organization_shareholder <>", value, "organizationShareholder");
            return (Criteria) this;
        }

        public Criteria andOrganizationShareholderGreaterThan(String value) {
            addCriterion("organization_shareholder >", value, "organizationShareholder");
            return (Criteria) this;
        }

        public Criteria andOrganizationShareholderGreaterThanOrEqualTo(String value) {
            addCriterion("organization_shareholder >=", value, "organizationShareholder");
            return (Criteria) this;
        }

        public Criteria andOrganizationShareholderLessThan(String value) {
            addCriterion("organization_shareholder <", value, "organizationShareholder");
            return (Criteria) this;
        }

        public Criteria andOrganizationShareholderLessThanOrEqualTo(String value) {
            addCriterion("organization_shareholder <=", value, "organizationShareholder");
            return (Criteria) this;
        }

        public Criteria andOrganizationShareholderLike(String value) {
            addCriterion("organization_shareholder like", value, "organizationShareholder");
            return (Criteria) this;
        }

        public Criteria andOrganizationShareholderNotLike(String value) {
            addCriterion("organization_shareholder not like", value, "organizationShareholder");
            return (Criteria) this;
        }

        public Criteria andOrganizationShareholderIn(List<String> values) {
            addCriterion("organization_shareholder in", values, "organizationShareholder");
            return (Criteria) this;
        }

        public Criteria andOrganizationShareholderNotIn(List<String> values) {
            addCriterion("organization_shareholder not in", values, "organizationShareholder");
            return (Criteria) this;
        }

        public Criteria andOrganizationShareholderBetween(String value1, String value2) {
            addCriterion("organization_shareholder between", value1, value2, "organizationShareholder");
            return (Criteria) this;
        }

        public Criteria andOrganizationShareholderNotBetween(String value1, String value2) {
            addCriterion("organization_shareholder not between", value1, value2, "organizationShareholder");
            return (Criteria) this;
        }

        public Criteria andOrganizationManagerIsNull() {
            addCriterion("organization_manager is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationManagerIsNotNull() {
            addCriterion("organization_manager is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationManagerEqualTo(String value) {
            addCriterion("organization_manager =", value, "organizationManager");
            return (Criteria) this;
        }

        public Criteria andOrganizationManagerNotEqualTo(String value) {
            addCriterion("organization_manager <>", value, "organizationManager");
            return (Criteria) this;
        }

        public Criteria andOrganizationManagerGreaterThan(String value) {
            addCriterion("organization_manager >", value, "organizationManager");
            return (Criteria) this;
        }

        public Criteria andOrganizationManagerGreaterThanOrEqualTo(String value) {
            addCriterion("organization_manager >=", value, "organizationManager");
            return (Criteria) this;
        }

        public Criteria andOrganizationManagerLessThan(String value) {
            addCriterion("organization_manager <", value, "organizationManager");
            return (Criteria) this;
        }

        public Criteria andOrganizationManagerLessThanOrEqualTo(String value) {
            addCriterion("organization_manager <=", value, "organizationManager");
            return (Criteria) this;
        }

        public Criteria andOrganizationManagerLike(String value) {
            addCriterion("organization_manager like", value, "organizationManager");
            return (Criteria) this;
        }

        public Criteria andOrganizationManagerNotLike(String value) {
            addCriterion("organization_manager not like", value, "organizationManager");
            return (Criteria) this;
        }

        public Criteria andOrganizationManagerIn(List<String> values) {
            addCriterion("organization_manager in", values, "organizationManager");
            return (Criteria) this;
        }

        public Criteria andOrganizationManagerNotIn(List<String> values) {
            addCriterion("organization_manager not in", values, "organizationManager");
            return (Criteria) this;
        }

        public Criteria andOrganizationManagerBetween(String value1, String value2) {
            addCriterion("organization_manager between", value1, value2, "organizationManager");
            return (Criteria) this;
        }

        public Criteria andOrganizationManagerNotBetween(String value1, String value2) {
            addCriterion("organization_manager not between", value1, value2, "organizationManager");
            return (Criteria) this;
        }

        public Criteria andOrganizationOtherInfoIsNull() {
            addCriterion("organization_other_info is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationOtherInfoIsNotNull() {
            addCriterion("organization_other_info is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationOtherInfoEqualTo(String value) {
            addCriterion("organization_other_info =", value, "organizationOtherInfo");
            return (Criteria) this;
        }

        public Criteria andOrganizationOtherInfoNotEqualTo(String value) {
            addCriterion("organization_other_info <>", value, "organizationOtherInfo");
            return (Criteria) this;
        }

        public Criteria andOrganizationOtherInfoGreaterThan(String value) {
            addCriterion("organization_other_info >", value, "organizationOtherInfo");
            return (Criteria) this;
        }

        public Criteria andOrganizationOtherInfoGreaterThanOrEqualTo(String value) {
            addCriterion("organization_other_info >=", value, "organizationOtherInfo");
            return (Criteria) this;
        }

        public Criteria andOrganizationOtherInfoLessThan(String value) {
            addCriterion("organization_other_info <", value, "organizationOtherInfo");
            return (Criteria) this;
        }

        public Criteria andOrganizationOtherInfoLessThanOrEqualTo(String value) {
            addCriterion("organization_other_info <=", value, "organizationOtherInfo");
            return (Criteria) this;
        }

        public Criteria andOrganizationOtherInfoLike(String value) {
            addCriterion("organization_other_info like", value, "organizationOtherInfo");
            return (Criteria) this;
        }

        public Criteria andOrganizationOtherInfoNotLike(String value) {
            addCriterion("organization_other_info not like", value, "organizationOtherInfo");
            return (Criteria) this;
        }

        public Criteria andOrganizationOtherInfoIn(List<String> values) {
            addCriterion("organization_other_info in", values, "organizationOtherInfo");
            return (Criteria) this;
        }

        public Criteria andOrganizationOtherInfoNotIn(List<String> values) {
            addCriterion("organization_other_info not in", values, "organizationOtherInfo");
            return (Criteria) this;
        }

        public Criteria andOrganizationOtherInfoBetween(String value1, String value2) {
            addCriterion("organization_other_info between", value1, value2, "organizationOtherInfo");
            return (Criteria) this;
        }

        public Criteria andOrganizationOtherInfoNotBetween(String value1, String value2) {
            addCriterion("organization_other_info not between", value1, value2, "organizationOtherInfo");
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

        public Criteria andBusinessScopeIsNull() {
            addCriterion("business_scope is null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNotNull() {
            addCriterion("business_scope is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeEqualTo(String value) {
            addCriterion("business_scope =", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotEqualTo(String value) {
            addCriterion("business_scope <>", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThan(String value) {
            addCriterion("business_scope >", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThanOrEqualTo(String value) {
            addCriterion("business_scope >=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThan(String value) {
            addCriterion("business_scope <", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThanOrEqualTo(String value) {
            addCriterion("business_scope <=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLike(String value) {
            addCriterion("business_scope like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotLike(String value) {
            addCriterion("business_scope not like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIn(List<String> values) {
            addCriterion("business_scope in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotIn(List<String> values) {
            addCriterion("business_scope not in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeBetween(String value1, String value2) {
            addCriterion("business_scope between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotBetween(String value1, String value2) {
            addCriterion("business_scope not between", value1, value2, "businessScope");
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

        public Criteria andOrganizationSortIsNull() {
            addCriterion("organization_sort is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationSortIsNotNull() {
            addCriterion("organization_sort is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationSortEqualTo(Integer value) {
            addCriterion("organization_sort =", value, "organizationSort");
            return (Criteria) this;
        }

        public Criteria andOrganizationSortNotEqualTo(Integer value) {
            addCriterion("organization_sort <>", value, "organizationSort");
            return (Criteria) this;
        }

        public Criteria andOrganizationSortGreaterThan(Integer value) {
            addCriterion("organization_sort >", value, "organizationSort");
            return (Criteria) this;
        }

        public Criteria andOrganizationSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("organization_sort >=", value, "organizationSort");
            return (Criteria) this;
        }

        public Criteria andOrganizationSortLessThan(Integer value) {
            addCriterion("organization_sort <", value, "organizationSort");
            return (Criteria) this;
        }

        public Criteria andOrganizationSortLessThanOrEqualTo(Integer value) {
            addCriterion("organization_sort <=", value, "organizationSort");
            return (Criteria) this;
        }

        public Criteria andOrganizationSortIn(List<Integer> values) {
            addCriterion("organization_sort in", values, "organizationSort");
            return (Criteria) this;
        }

        public Criteria andOrganizationSortNotIn(List<Integer> values) {
            addCriterion("organization_sort not in", values, "organizationSort");
            return (Criteria) this;
        }

        public Criteria andOrganizationSortBetween(Integer value1, Integer value2) {
            addCriterion("organization_sort between", value1, value2, "organizationSort");
            return (Criteria) this;
        }

        public Criteria andOrganizationSortNotBetween(Integer value1, Integer value2) {
            addCriterion("organization_sort not between", value1, value2, "organizationSort");
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