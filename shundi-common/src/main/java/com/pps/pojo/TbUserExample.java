package com.pps.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TbUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbUserExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andHeadimageIsNull() {
            addCriterion("headImage is null");
            return (Criteria) this;
        }

        public Criteria andHeadimageIsNotNull() {
            addCriterion("headImage is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimageEqualTo(String value) {
            addCriterion("headImage =", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotEqualTo(String value) {
            addCriterion("headImage <>", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageGreaterThan(String value) {
            addCriterion("headImage >", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageGreaterThanOrEqualTo(String value) {
            addCriterion("headImage >=", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageLessThan(String value) {
            addCriterion("headImage <", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageLessThanOrEqualTo(String value) {
            addCriterion("headImage <=", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageLike(String value) {
            addCriterion("headImage like", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotLike(String value) {
            addCriterion("headImage not like", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageIn(List<String> values) {
            addCriterion("headImage in", values, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotIn(List<String> values) {
            addCriterion("headImage not in", values, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageBetween(String value1, String value2) {
            addCriterion("headImage between", value1, value2, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotBetween(String value1, String value2) {
            addCriterion("headImage not between", value1, value2, "headimage");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openId is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openId is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openId =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openId <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openId >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openId >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openId <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openId <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openId like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openId not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openId in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openId not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openId between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openId not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNull() {
            addCriterion("userType is null");
            return (Criteria) this;
        }

        public Criteria andUsertypeIsNotNull() {
            addCriterion("userType is not null");
            return (Criteria) this;
        }

        public Criteria andUsertypeEqualTo(Integer value) {
            addCriterion("userType =", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotEqualTo(Integer value) {
            addCriterion("userType <>", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThan(Integer value) {
            addCriterion("userType >", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("userType >=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThan(Integer value) {
            addCriterion("userType <", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeLessThanOrEqualTo(Integer value) {
            addCriterion("userType <=", value, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeIn(List<Integer> values) {
            addCriterion("userType in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotIn(List<Integer> values) {
            addCriterion("userType not in", values, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeBetween(Integer value1, Integer value2) {
            addCriterion("userType between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andUsertypeNotBetween(Integer value1, Integer value2) {
            addCriterion("userType not between", value1, value2, "usertype");
            return (Criteria) this;
        }

        public Criteria andLerverIsNull() {
            addCriterion("lerver is null");
            return (Criteria) this;
        }

        public Criteria andLerverIsNotNull() {
            addCriterion("lerver is not null");
            return (Criteria) this;
        }

        public Criteria andLerverEqualTo(Integer value) {
            addCriterion("lerver =", value, "lerver");
            return (Criteria) this;
        }

        public Criteria andLerverNotEqualTo(Integer value) {
            addCriterion("lerver <>", value, "lerver");
            return (Criteria) this;
        }

        public Criteria andLerverGreaterThan(Integer value) {
            addCriterion("lerver >", value, "lerver");
            return (Criteria) this;
        }

        public Criteria andLerverGreaterThanOrEqualTo(Integer value) {
            addCriterion("lerver >=", value, "lerver");
            return (Criteria) this;
        }

        public Criteria andLerverLessThan(Integer value) {
            addCriterion("lerver <", value, "lerver");
            return (Criteria) this;
        }

        public Criteria andLerverLessThanOrEqualTo(Integer value) {
            addCriterion("lerver <=", value, "lerver");
            return (Criteria) this;
        }

        public Criteria andLerverIn(List<Integer> values) {
            addCriterion("lerver in", values, "lerver");
            return (Criteria) this;
        }

        public Criteria andLerverNotIn(List<Integer> values) {
            addCriterion("lerver not in", values, "lerver");
            return (Criteria) this;
        }

        public Criteria andLerverBetween(Integer value1, Integer value2) {
            addCriterion("lerver between", value1, value2, "lerver");
            return (Criteria) this;
        }

        public Criteria andLerverNotBetween(Integer value1, Integer value2) {
            addCriterion("lerver not between", value1, value2, "lerver");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(BigDecimal value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(BigDecimal value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(BigDecimal value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(BigDecimal value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<BigDecimal> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<BigDecimal> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andBk1IsNull() {
            addCriterion("bk1 is null");
            return (Criteria) this;
        }

        public Criteria andBk1IsNotNull() {
            addCriterion("bk1 is not null");
            return (Criteria) this;
        }

        public Criteria andBk1EqualTo(String value) {
            addCriterion("bk1 =", value, "bk1");
            return (Criteria) this;
        }

        public Criteria andBk1NotEqualTo(String value) {
            addCriterion("bk1 <>", value, "bk1");
            return (Criteria) this;
        }

        public Criteria andBk1GreaterThan(String value) {
            addCriterion("bk1 >", value, "bk1");
            return (Criteria) this;
        }

        public Criteria andBk1GreaterThanOrEqualTo(String value) {
            addCriterion("bk1 >=", value, "bk1");
            return (Criteria) this;
        }

        public Criteria andBk1LessThan(String value) {
            addCriterion("bk1 <", value, "bk1");
            return (Criteria) this;
        }

        public Criteria andBk1LessThanOrEqualTo(String value) {
            addCriterion("bk1 <=", value, "bk1");
            return (Criteria) this;
        }

        public Criteria andBk1Like(String value) {
            addCriterion("bk1 like", value, "bk1");
            return (Criteria) this;
        }

        public Criteria andBk1NotLike(String value) {
            addCriterion("bk1 not like", value, "bk1");
            return (Criteria) this;
        }

        public Criteria andBk1In(List<String> values) {
            addCriterion("bk1 in", values, "bk1");
            return (Criteria) this;
        }

        public Criteria andBk1NotIn(List<String> values) {
            addCriterion("bk1 not in", values, "bk1");
            return (Criteria) this;
        }

        public Criteria andBk1Between(String value1, String value2) {
            addCriterion("bk1 between", value1, value2, "bk1");
            return (Criteria) this;
        }

        public Criteria andBk1NotBetween(String value1, String value2) {
            addCriterion("bk1 not between", value1, value2, "bk1");
            return (Criteria) this;
        }

        public Criteria andBk2IsNull() {
            addCriterion("bk2 is null");
            return (Criteria) this;
        }

        public Criteria andBk2IsNotNull() {
            addCriterion("bk2 is not null");
            return (Criteria) this;
        }

        public Criteria andBk2EqualTo(String value) {
            addCriterion("bk2 =", value, "bk2");
            return (Criteria) this;
        }

        public Criteria andBk2NotEqualTo(String value) {
            addCriterion("bk2 <>", value, "bk2");
            return (Criteria) this;
        }

        public Criteria andBk2GreaterThan(String value) {
            addCriterion("bk2 >", value, "bk2");
            return (Criteria) this;
        }

        public Criteria andBk2GreaterThanOrEqualTo(String value) {
            addCriterion("bk2 >=", value, "bk2");
            return (Criteria) this;
        }

        public Criteria andBk2LessThan(String value) {
            addCriterion("bk2 <", value, "bk2");
            return (Criteria) this;
        }

        public Criteria andBk2LessThanOrEqualTo(String value) {
            addCriterion("bk2 <=", value, "bk2");
            return (Criteria) this;
        }

        public Criteria andBk2Like(String value) {
            addCriterion("bk2 like", value, "bk2");
            return (Criteria) this;
        }

        public Criteria andBk2NotLike(String value) {
            addCriterion("bk2 not like", value, "bk2");
            return (Criteria) this;
        }

        public Criteria andBk2In(List<String> values) {
            addCriterion("bk2 in", values, "bk2");
            return (Criteria) this;
        }

        public Criteria andBk2NotIn(List<String> values) {
            addCriterion("bk2 not in", values, "bk2");
            return (Criteria) this;
        }

        public Criteria andBk2Between(String value1, String value2) {
            addCriterion("bk2 between", value1, value2, "bk2");
            return (Criteria) this;
        }

        public Criteria andBk2NotBetween(String value1, String value2) {
            addCriterion("bk2 not between", value1, value2, "bk2");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("realName is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realName is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realName =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realName <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realName >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realName >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realName <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realName <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realName like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realName not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realName in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realName not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realName between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realName not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andNativeplaceIsNull() {
            addCriterion("nativePlace is null");
            return (Criteria) this;
        }

        public Criteria andNativeplaceIsNotNull() {
            addCriterion("nativePlace is not null");
            return (Criteria) this;
        }

        public Criteria andNativeplaceEqualTo(String value) {
            addCriterion("nativePlace =", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotEqualTo(String value) {
            addCriterion("nativePlace <>", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceGreaterThan(String value) {
            addCriterion("nativePlace >", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceGreaterThanOrEqualTo(String value) {
            addCriterion("nativePlace >=", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceLessThan(String value) {
            addCriterion("nativePlace <", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceLessThanOrEqualTo(String value) {
            addCriterion("nativePlace <=", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceLike(String value) {
            addCriterion("nativePlace like", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotLike(String value) {
            addCriterion("nativePlace not like", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceIn(List<String> values) {
            addCriterion("nativePlace in", values, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotIn(List<String> values) {
            addCriterion("nativePlace not in", values, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceBetween(String value1, String value2) {
            addCriterion("nativePlace between", value1, value2, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotBetween(String value1, String value2) {
            addCriterion("nativePlace not between", value1, value2, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNowplaceIsNull() {
            addCriterion("nowPlace is null");
            return (Criteria) this;
        }

        public Criteria andNowplaceIsNotNull() {
            addCriterion("nowPlace is not null");
            return (Criteria) this;
        }

        public Criteria andNowplaceEqualTo(String value) {
            addCriterion("nowPlace =", value, "nowplace");
            return (Criteria) this;
        }

        public Criteria andNowplaceNotEqualTo(String value) {
            addCriterion("nowPlace <>", value, "nowplace");
            return (Criteria) this;
        }

        public Criteria andNowplaceGreaterThan(String value) {
            addCriterion("nowPlace >", value, "nowplace");
            return (Criteria) this;
        }

        public Criteria andNowplaceGreaterThanOrEqualTo(String value) {
            addCriterion("nowPlace >=", value, "nowplace");
            return (Criteria) this;
        }

        public Criteria andNowplaceLessThan(String value) {
            addCriterion("nowPlace <", value, "nowplace");
            return (Criteria) this;
        }

        public Criteria andNowplaceLessThanOrEqualTo(String value) {
            addCriterion("nowPlace <=", value, "nowplace");
            return (Criteria) this;
        }

        public Criteria andNowplaceLike(String value) {
            addCriterion("nowPlace like", value, "nowplace");
            return (Criteria) this;
        }

        public Criteria andNowplaceNotLike(String value) {
            addCriterion("nowPlace not like", value, "nowplace");
            return (Criteria) this;
        }

        public Criteria andNowplaceIn(List<String> values) {
            addCriterion("nowPlace in", values, "nowplace");
            return (Criteria) this;
        }

        public Criteria andNowplaceNotIn(List<String> values) {
            addCriterion("nowPlace not in", values, "nowplace");
            return (Criteria) this;
        }

        public Criteria andNowplaceBetween(String value1, String value2) {
            addCriterion("nowPlace between", value1, value2, "nowplace");
            return (Criteria) this;
        }

        public Criteria andNowplaceNotBetween(String value1, String value2) {
            addCriterion("nowPlace not between", value1, value2, "nowplace");
            return (Criteria) this;
        }

        public Criteria andIdcardimage1IsNull() {
            addCriterion("idCardImage1 is null");
            return (Criteria) this;
        }

        public Criteria andIdcardimage1IsNotNull() {
            addCriterion("idCardImage1 is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardimage1EqualTo(String value) {
            addCriterion("idCardImage1 =", value, "idcardimage1");
            return (Criteria) this;
        }

        public Criteria andIdcardimage1NotEqualTo(String value) {
            addCriterion("idCardImage1 <>", value, "idcardimage1");
            return (Criteria) this;
        }

        public Criteria andIdcardimage1GreaterThan(String value) {
            addCriterion("idCardImage1 >", value, "idcardimage1");
            return (Criteria) this;
        }

        public Criteria andIdcardimage1GreaterThanOrEqualTo(String value) {
            addCriterion("idCardImage1 >=", value, "idcardimage1");
            return (Criteria) this;
        }

        public Criteria andIdcardimage1LessThan(String value) {
            addCriterion("idCardImage1 <", value, "idcardimage1");
            return (Criteria) this;
        }

        public Criteria andIdcardimage1LessThanOrEqualTo(String value) {
            addCriterion("idCardImage1 <=", value, "idcardimage1");
            return (Criteria) this;
        }

        public Criteria andIdcardimage1Like(String value) {
            addCriterion("idCardImage1 like", value, "idcardimage1");
            return (Criteria) this;
        }

        public Criteria andIdcardimage1NotLike(String value) {
            addCriterion("idCardImage1 not like", value, "idcardimage1");
            return (Criteria) this;
        }

        public Criteria andIdcardimage1In(List<String> values) {
            addCriterion("idCardImage1 in", values, "idcardimage1");
            return (Criteria) this;
        }

        public Criteria andIdcardimage1NotIn(List<String> values) {
            addCriterion("idCardImage1 not in", values, "idcardimage1");
            return (Criteria) this;
        }

        public Criteria andIdcardimage1Between(String value1, String value2) {
            addCriterion("idCardImage1 between", value1, value2, "idcardimage1");
            return (Criteria) this;
        }

        public Criteria andIdcardimage1NotBetween(String value1, String value2) {
            addCriterion("idCardImage1 not between", value1, value2, "idcardimage1");
            return (Criteria) this;
        }

        public Criteria andIdcardimage2IsNull() {
            addCriterion("idCardImage2 is null");
            return (Criteria) this;
        }

        public Criteria andIdcardimage2IsNotNull() {
            addCriterion("idCardImage2 is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardimage2EqualTo(String value) {
            addCriterion("idCardImage2 =", value, "idcardimage2");
            return (Criteria) this;
        }

        public Criteria andIdcardimage2NotEqualTo(String value) {
            addCriterion("idCardImage2 <>", value, "idcardimage2");
            return (Criteria) this;
        }

        public Criteria andIdcardimage2GreaterThan(String value) {
            addCriterion("idCardImage2 >", value, "idcardimage2");
            return (Criteria) this;
        }

        public Criteria andIdcardimage2GreaterThanOrEqualTo(String value) {
            addCriterion("idCardImage2 >=", value, "idcardimage2");
            return (Criteria) this;
        }

        public Criteria andIdcardimage2LessThan(String value) {
            addCriterion("idCardImage2 <", value, "idcardimage2");
            return (Criteria) this;
        }

        public Criteria andIdcardimage2LessThanOrEqualTo(String value) {
            addCriterion("idCardImage2 <=", value, "idcardimage2");
            return (Criteria) this;
        }

        public Criteria andIdcardimage2Like(String value) {
            addCriterion("idCardImage2 like", value, "idcardimage2");
            return (Criteria) this;
        }

        public Criteria andIdcardimage2NotLike(String value) {
            addCriterion("idCardImage2 not like", value, "idcardimage2");
            return (Criteria) this;
        }

        public Criteria andIdcardimage2In(List<String> values) {
            addCriterion("idCardImage2 in", values, "idcardimage2");
            return (Criteria) this;
        }

        public Criteria andIdcardimage2NotIn(List<String> values) {
            addCriterion("idCardImage2 not in", values, "idcardimage2");
            return (Criteria) this;
        }

        public Criteria andIdcardimage2Between(String value1, String value2) {
            addCriterion("idCardImage2 between", value1, value2, "idcardimage2");
            return (Criteria) this;
        }

        public Criteria andIdcardimage2NotBetween(String value1, String value2) {
            addCriterion("idCardImage2 not between", value1, value2, "idcardimage2");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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