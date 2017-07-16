package com.yanbin.model;

import java.util.ArrayList;
import java.util.List;

public class CompanyKeyExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table company_key
     *
     * @mbggenerated Sun Jul 16 10:55:59 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table company_key
     *
     * @mbggenerated Sun Jul 16 10:55:59 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table company_key
     *
     * @mbggenerated Sun Jul 16 10:55:59 CST 2017
     */
    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_key
     *
     * @mbggenerated Sun Jul 16 10:55:59 CST 2017
     */
    public CompanyKeyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_key
     *
     * @mbggenerated Sun Jul 16 10:55:59 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_key
     *
     * @mbggenerated Sun Jul 16 10:55:59 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_key
     *
     * @mbggenerated Sun Jul 16 10:55:59 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_key
     *
     * @mbggenerated Sun Jul 16 10:55:59 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_key
     *
     * @mbggenerated Sun Jul 16 10:55:59 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_key
     *
     * @mbggenerated Sun Jul 16 10:55:59 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_key
     *
     * @mbggenerated Sun Jul 16 10:55:59 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_key
     *
     * @mbggenerated Sun Jul 16 10:55:59 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_key
     *
     * @mbggenerated Sun Jul 16 10:55:59 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company_key
     *
     * @mbggenerated Sun Jul 16 10:55:59 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table company_key
     *
     * @mbggenerated Sun Jul 16 10:55:59 CST 2017
     */
    protected abstract static class GeneratedCriteria {
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

        public Criteria andTextKeyIsNull() {
            addCriterion("text_key is null");
            return (Criteria) this;
        }

        public Criteria andTextKeyIsNotNull() {
            addCriterion("text_key is not null");
            return (Criteria) this;
        }

        public Criteria andTextKeyEqualTo(String value) {
            addCriterion("text_key =", value, "textKey");
            return (Criteria) this;
        }

        public Criteria andTextKeyNotEqualTo(String value) {
            addCriterion("text_key <>", value, "textKey");
            return (Criteria) this;
        }

        public Criteria andTextKeyGreaterThan(String value) {
            addCriterion("text_key >", value, "textKey");
            return (Criteria) this;
        }

        public Criteria andTextKeyGreaterThanOrEqualTo(String value) {
            addCriterion("text_key >=", value, "textKey");
            return (Criteria) this;
        }

        public Criteria andTextKeyLessThan(String value) {
            addCriterion("text_key <", value, "textKey");
            return (Criteria) this;
        }

        public Criteria andTextKeyLessThanOrEqualTo(String value) {
            addCriterion("text_key <=", value, "textKey");
            return (Criteria) this;
        }

        public Criteria andTextKeyLike(String value) {
            addCriterion("text_key like", value, "textKey");
            return (Criteria) this;
        }

        public Criteria andTextKeyNotLike(String value) {
            addCriterion("text_key not like", value, "textKey");
            return (Criteria) this;
        }

        public Criteria andTextKeyIn(List<String> values) {
            addCriterion("text_key in", values, "textKey");
            return (Criteria) this;
        }

        public Criteria andTextKeyNotIn(List<String> values) {
            addCriterion("text_key not in", values, "textKey");
            return (Criteria) this;
        }

        public Criteria andTextKeyBetween(String value1, String value2) {
            addCriterion("text_key between", value1, value2, "textKey");
            return (Criteria) this;
        }

        public Criteria andTextKeyNotBetween(String value1, String value2) {
            addCriterion("text_key not between", value1, value2, "textKey");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table company_key
     *
     * @mbggenerated do_not_delete_during_merge Sun Jul 16 10:55:59 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table company_key
     *
     * @mbggenerated Sun Jul 16 10:55:59 CST 2017
     */
    public static class Criterion {
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