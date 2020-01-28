package com.pps.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbOrderExample() {
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

        public Criteria andUserpointidIsNull() {
            addCriterion("userPointId is null");
            return (Criteria) this;
        }

        public Criteria andUserpointidIsNotNull() {
            addCriterion("userPointId is not null");
            return (Criteria) this;
        }

        public Criteria andUserpointidEqualTo(String value) {
            addCriterion("userPointId =", value, "userpointid");
            return (Criteria) this;
        }

        public Criteria andUserpointidNotEqualTo(String value) {
            addCriterion("userPointId <>", value, "userpointid");
            return (Criteria) this;
        }

        public Criteria andUserpointidGreaterThan(String value) {
            addCriterion("userPointId >", value, "userpointid");
            return (Criteria) this;
        }

        public Criteria andUserpointidGreaterThanOrEqualTo(String value) {
            addCriterion("userPointId >=", value, "userpointid");
            return (Criteria) this;
        }

        public Criteria andUserpointidLessThan(String value) {
            addCriterion("userPointId <", value, "userpointid");
            return (Criteria) this;
        }

        public Criteria andUserpointidLessThanOrEqualTo(String value) {
            addCriterion("userPointId <=", value, "userpointid");
            return (Criteria) this;
        }

        public Criteria andUserpointidLike(String value) {
            addCriterion("userPointId like", value, "userpointid");
            return (Criteria) this;
        }

        public Criteria andUserpointidNotLike(String value) {
            addCriterion("userPointId not like", value, "userpointid");
            return (Criteria) this;
        }

        public Criteria andUserpointidIn(List<String> values) {
            addCriterion("userPointId in", values, "userpointid");
            return (Criteria) this;
        }

        public Criteria andUserpointidNotIn(List<String> values) {
            addCriterion("userPointId not in", values, "userpointid");
            return (Criteria) this;
        }

        public Criteria andUserpointidBetween(String value1, String value2) {
            addCriterion("userPointId between", value1, value2, "userpointid");
            return (Criteria) this;
        }

        public Criteria andUserpointidNotBetween(String value1, String value2) {
            addCriterion("userPointId not between", value1, value2, "userpointid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andOwneridIsNull() {
            addCriterion("ownerId is null");
            return (Criteria) this;
        }

        public Criteria andOwneridIsNotNull() {
            addCriterion("ownerId is not null");
            return (Criteria) this;
        }

        public Criteria andOwneridEqualTo(Integer value) {
            addCriterion("ownerId =", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotEqualTo(Integer value) {
            addCriterion("ownerId <>", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridGreaterThan(Integer value) {
            addCriterion("ownerId >", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridGreaterThanOrEqualTo(Integer value) {
            addCriterion("ownerId >=", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridLessThan(Integer value) {
            addCriterion("ownerId <", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridLessThanOrEqualTo(Integer value) {
            addCriterion("ownerId <=", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridIn(List<Integer> values) {
            addCriterion("ownerId in", values, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotIn(List<Integer> values) {
            addCriterion("ownerId not in", values, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridBetween(Integer value1, Integer value2) {
            addCriterion("ownerId between", value1, value2, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotBetween(Integer value1, Integer value2) {
            addCriterion("ownerId not between", value1, value2, "ownerid");
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

        public Criteria andGoodsimageIsNull() {
            addCriterion("goodsImage is null");
            return (Criteria) this;
        }

        public Criteria andGoodsimageIsNotNull() {
            addCriterion("goodsImage is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsimageEqualTo(String value) {
            addCriterion("goodsImage =", value, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsimageNotEqualTo(String value) {
            addCriterion("goodsImage <>", value, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsimageGreaterThan(String value) {
            addCriterion("goodsImage >", value, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsimageGreaterThanOrEqualTo(String value) {
            addCriterion("goodsImage >=", value, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsimageLessThan(String value) {
            addCriterion("goodsImage <", value, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsimageLessThanOrEqualTo(String value) {
            addCriterion("goodsImage <=", value, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsimageLike(String value) {
            addCriterion("goodsImage like", value, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsimageNotLike(String value) {
            addCriterion("goodsImage not like", value, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsimageIn(List<String> values) {
            addCriterion("goodsImage in", values, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsimageNotIn(List<String> values) {
            addCriterion("goodsImage not in", values, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsimageBetween(String value1, String value2) {
            addCriterion("goodsImage between", value1, value2, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsimageNotBetween(String value1, String value2) {
            addCriterion("goodsImage not between", value1, value2, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNull() {
            addCriterion("goodsName is null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNotNull() {
            addCriterion("goodsName is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameEqualTo(String value) {
            addCriterion("goodsName =", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotEqualTo(String value) {
            addCriterion("goodsName <>", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThan(String value) {
            addCriterion("goodsName >", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThanOrEqualTo(String value) {
            addCriterion("goodsName >=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThan(String value) {
            addCriterion("goodsName <", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThanOrEqualTo(String value) {
            addCriterion("goodsName <=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLike(String value) {
            addCriterion("goodsName like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotLike(String value) {
            addCriterion("goodsName not like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIn(List<String> values) {
            addCriterion("goodsName in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotIn(List<String> values) {
            addCriterion("goodsName not in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameBetween(String value1, String value2) {
            addCriterion("goodsName between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotBetween(String value1, String value2) {
            addCriterion("goodsName not between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsweightIsNull() {
            addCriterion("goodsWeight is null");
            return (Criteria) this;
        }

        public Criteria andGoodsweightIsNotNull() {
            addCriterion("goodsWeight is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsweightEqualTo(String value) {
            addCriterion("goodsWeight =", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightNotEqualTo(String value) {
            addCriterion("goodsWeight <>", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightGreaterThan(String value) {
            addCriterion("goodsWeight >", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightGreaterThanOrEqualTo(String value) {
            addCriterion("goodsWeight >=", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightLessThan(String value) {
            addCriterion("goodsWeight <", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightLessThanOrEqualTo(String value) {
            addCriterion("goodsWeight <=", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightLike(String value) {
            addCriterion("goodsWeight like", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightNotLike(String value) {
            addCriterion("goodsWeight not like", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightIn(List<String> values) {
            addCriterion("goodsWeight in", values, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightNotIn(List<String> values) {
            addCriterion("goodsWeight not in", values, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightBetween(String value1, String value2) {
            addCriterion("goodsWeight between", value1, value2, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightNotBetween(String value1, String value2) {
            addCriterion("goodsWeight not between", value1, value2, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsvolumeIsNull() {
            addCriterion("goodsVolume is null");
            return (Criteria) this;
        }

        public Criteria andGoodsvolumeIsNotNull() {
            addCriterion("goodsVolume is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsvolumeEqualTo(String value) {
            addCriterion("goodsVolume =", value, "goodsvolume");
            return (Criteria) this;
        }

        public Criteria andGoodsvolumeNotEqualTo(String value) {
            addCriterion("goodsVolume <>", value, "goodsvolume");
            return (Criteria) this;
        }

        public Criteria andGoodsvolumeGreaterThan(String value) {
            addCriterion("goodsVolume >", value, "goodsvolume");
            return (Criteria) this;
        }

        public Criteria andGoodsvolumeGreaterThanOrEqualTo(String value) {
            addCriterion("goodsVolume >=", value, "goodsvolume");
            return (Criteria) this;
        }

        public Criteria andGoodsvolumeLessThan(String value) {
            addCriterion("goodsVolume <", value, "goodsvolume");
            return (Criteria) this;
        }

        public Criteria andGoodsvolumeLessThanOrEqualTo(String value) {
            addCriterion("goodsVolume <=", value, "goodsvolume");
            return (Criteria) this;
        }

        public Criteria andGoodsvolumeLike(String value) {
            addCriterion("goodsVolume like", value, "goodsvolume");
            return (Criteria) this;
        }

        public Criteria andGoodsvolumeNotLike(String value) {
            addCriterion("goodsVolume not like", value, "goodsvolume");
            return (Criteria) this;
        }

        public Criteria andGoodsvolumeIn(List<String> values) {
            addCriterion("goodsVolume in", values, "goodsvolume");
            return (Criteria) this;
        }

        public Criteria andGoodsvolumeNotIn(List<String> values) {
            addCriterion("goodsVolume not in", values, "goodsvolume");
            return (Criteria) this;
        }

        public Criteria andGoodsvolumeBetween(String value1, String value2) {
            addCriterion("goodsVolume between", value1, value2, "goodsvolume");
            return (Criteria) this;
        }

        public Criteria andGoodsvolumeNotBetween(String value1, String value2) {
            addCriterion("goodsVolume not between", value1, value2, "goodsvolume");
            return (Criteria) this;
        }

        public Criteria andTalkpriceIsNull() {
            addCriterion("talkPrice is null");
            return (Criteria) this;
        }

        public Criteria andTalkpriceIsNotNull() {
            addCriterion("talkPrice is not null");
            return (Criteria) this;
        }

        public Criteria andTalkpriceEqualTo(Double value) {
            addCriterion("talkPrice =", value, "talkprice");
            return (Criteria) this;
        }

        public Criteria andTalkpriceNotEqualTo(Double value) {
            addCriterion("talkPrice <>", value, "talkprice");
            return (Criteria) this;
        }

        public Criteria andTalkpriceGreaterThan(Double value) {
            addCriterion("talkPrice >", value, "talkprice");
            return (Criteria) this;
        }

        public Criteria andTalkpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("talkPrice >=", value, "talkprice");
            return (Criteria) this;
        }

        public Criteria andTalkpriceLessThan(Double value) {
            addCriterion("talkPrice <", value, "talkprice");
            return (Criteria) this;
        }

        public Criteria andTalkpriceLessThanOrEqualTo(Double value) {
            addCriterion("talkPrice <=", value, "talkprice");
            return (Criteria) this;
        }

        public Criteria andTalkpriceIn(List<Double> values) {
            addCriterion("talkPrice in", values, "talkprice");
            return (Criteria) this;
        }

        public Criteria andTalkpriceNotIn(List<Double> values) {
            addCriterion("talkPrice not in", values, "talkprice");
            return (Criteria) this;
        }

        public Criteria andTalkpriceBetween(Double value1, Double value2) {
            addCriterion("talkPrice between", value1, value2, "talkprice");
            return (Criteria) this;
        }

        public Criteria andTalkpriceNotBetween(Double value1, Double value2) {
            addCriterion("talkPrice not between", value1, value2, "talkprice");
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

        public Criteria andBk3IsNull() {
            addCriterion("bk3 is null");
            return (Criteria) this;
        }

        public Criteria andBk3IsNotNull() {
            addCriterion("bk3 is not null");
            return (Criteria) this;
        }

        public Criteria andBk3EqualTo(String value) {
            addCriterion("bk3 =", value, "bk3");
            return (Criteria) this;
        }

        public Criteria andBk3NotEqualTo(String value) {
            addCriterion("bk3 <>", value, "bk3");
            return (Criteria) this;
        }

        public Criteria andBk3GreaterThan(String value) {
            addCriterion("bk3 >", value, "bk3");
            return (Criteria) this;
        }

        public Criteria andBk3GreaterThanOrEqualTo(String value) {
            addCriterion("bk3 >=", value, "bk3");
            return (Criteria) this;
        }

        public Criteria andBk3LessThan(String value) {
            addCriterion("bk3 <", value, "bk3");
            return (Criteria) this;
        }

        public Criteria andBk3LessThanOrEqualTo(String value) {
            addCriterion("bk3 <=", value, "bk3");
            return (Criteria) this;
        }

        public Criteria andBk3Like(String value) {
            addCriterion("bk3 like", value, "bk3");
            return (Criteria) this;
        }

        public Criteria andBk3NotLike(String value) {
            addCriterion("bk3 not like", value, "bk3");
            return (Criteria) this;
        }

        public Criteria andBk3In(List<String> values) {
            addCriterion("bk3 in", values, "bk3");
            return (Criteria) this;
        }

        public Criteria andBk3NotIn(List<String> values) {
            addCriterion("bk3 not in", values, "bk3");
            return (Criteria) this;
        }

        public Criteria andBk3Between(String value1, String value2) {
            addCriterion("bk3 between", value1, value2, "bk3");
            return (Criteria) this;
        }

        public Criteria andBk3NotBetween(String value1, String value2) {
            addCriterion("bk3 not between", value1, value2, "bk3");
            return (Criteria) this;
        }

        public Criteria andGoodsstatusIsNull() {
            addCriterion("goodsStatus is null");
            return (Criteria) this;
        }

        public Criteria andGoodsstatusIsNotNull() {
            addCriterion("goodsStatus is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsstatusEqualTo(Integer value) {
            addCriterion("goodsStatus =", value, "goodsstatus");
            return (Criteria) this;
        }

        public Criteria andGoodsstatusNotEqualTo(Integer value) {
            addCriterion("goodsStatus <>", value, "goodsstatus");
            return (Criteria) this;
        }

        public Criteria andGoodsstatusGreaterThan(Integer value) {
            addCriterion("goodsStatus >", value, "goodsstatus");
            return (Criteria) this;
        }

        public Criteria andGoodsstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsStatus >=", value, "goodsstatus");
            return (Criteria) this;
        }

        public Criteria andGoodsstatusLessThan(Integer value) {
            addCriterion("goodsStatus <", value, "goodsstatus");
            return (Criteria) this;
        }

        public Criteria andGoodsstatusLessThanOrEqualTo(Integer value) {
            addCriterion("goodsStatus <=", value, "goodsstatus");
            return (Criteria) this;
        }

        public Criteria andGoodsstatusIn(List<Integer> values) {
            addCriterion("goodsStatus in", values, "goodsstatus");
            return (Criteria) this;
        }

        public Criteria andGoodsstatusNotIn(List<Integer> values) {
            addCriterion("goodsStatus not in", values, "goodsstatus");
            return (Criteria) this;
        }

        public Criteria andGoodsstatusBetween(Integer value1, Integer value2) {
            addCriterion("goodsStatus between", value1, value2, "goodsstatus");
            return (Criteria) this;
        }

        public Criteria andGoodsstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsStatus not between", value1, value2, "goodsstatus");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCompletiontimeIsNull() {
            addCriterion("completionTime is null");
            return (Criteria) this;
        }

        public Criteria andCompletiontimeIsNotNull() {
            addCriterion("completionTime is not null");
            return (Criteria) this;
        }

        public Criteria andCompletiontimeEqualTo(Date value) {
            addCriterionForJDBCDate("completionTime =", value, "completiontime");
            return (Criteria) this;
        }

        public Criteria andCompletiontimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("completionTime <>", value, "completiontime");
            return (Criteria) this;
        }

        public Criteria andCompletiontimeGreaterThan(Date value) {
            addCriterionForJDBCDate("completionTime >", value, "completiontime");
            return (Criteria) this;
        }

        public Criteria andCompletiontimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("completionTime >=", value, "completiontime");
            return (Criteria) this;
        }

        public Criteria andCompletiontimeLessThan(Date value) {
            addCriterionForJDBCDate("completionTime <", value, "completiontime");
            return (Criteria) this;
        }

        public Criteria andCompletiontimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("completionTime <=", value, "completiontime");
            return (Criteria) this;
        }

        public Criteria andCompletiontimeIn(List<Date> values) {
            addCriterionForJDBCDate("completionTime in", values, "completiontime");
            return (Criteria) this;
        }

        public Criteria andCompletiontimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("completionTime not in", values, "completiontime");
            return (Criteria) this;
        }

        public Criteria andCompletiontimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("completionTime between", value1, value2, "completiontime");
            return (Criteria) this;
        }

        public Criteria andCompletiontimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("completionTime not between", value1, value2, "completiontime");
            return (Criteria) this;
        }

        public Criteria andEstablishedtimeIsNull() {
            addCriterion("establishedTime is null");
            return (Criteria) this;
        }

        public Criteria andEstablishedtimeIsNotNull() {
            addCriterion("establishedTime is not null");
            return (Criteria) this;
        }

        public Criteria andEstablishedtimeEqualTo(Date value) {
            addCriterionForJDBCDate("establishedTime =", value, "establishedtime");
            return (Criteria) this;
        }

        public Criteria andEstablishedtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("establishedTime <>", value, "establishedtime");
            return (Criteria) this;
        }

        public Criteria andEstablishedtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("establishedTime >", value, "establishedtime");
            return (Criteria) this;
        }

        public Criteria andEstablishedtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("establishedTime >=", value, "establishedtime");
            return (Criteria) this;
        }

        public Criteria andEstablishedtimeLessThan(Date value) {
            addCriterionForJDBCDate("establishedTime <", value, "establishedtime");
            return (Criteria) this;
        }

        public Criteria andEstablishedtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("establishedTime <=", value, "establishedtime");
            return (Criteria) this;
        }

        public Criteria andEstablishedtimeIn(List<Date> values) {
            addCriterionForJDBCDate("establishedTime in", values, "establishedtime");
            return (Criteria) this;
        }

        public Criteria andEstablishedtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("establishedTime not in", values, "establishedtime");
            return (Criteria) this;
        }

        public Criteria andEstablishedtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("establishedTime between", value1, value2, "establishedtime");
            return (Criteria) this;
        }

        public Criteria andEstablishedtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("establishedTime not between", value1, value2, "establishedtime");
            return (Criteria) this;
        }

        public Criteria andArrivaltimeIsNull() {
            addCriterion("arrivalTime is null");
            return (Criteria) this;
        }

        public Criteria andArrivaltimeIsNotNull() {
            addCriterion("arrivalTime is not null");
            return (Criteria) this;
        }

        public Criteria andArrivaltimeEqualTo(Date value) {
            addCriterionForJDBCDate("arrivalTime =", value, "arrivaltime");
            return (Criteria) this;
        }

        public Criteria andArrivaltimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("arrivalTime <>", value, "arrivaltime");
            return (Criteria) this;
        }

        public Criteria andArrivaltimeGreaterThan(Date value) {
            addCriterionForJDBCDate("arrivalTime >", value, "arrivaltime");
            return (Criteria) this;
        }

        public Criteria andArrivaltimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("arrivalTime >=", value, "arrivaltime");
            return (Criteria) this;
        }

        public Criteria andArrivaltimeLessThan(Date value) {
            addCriterionForJDBCDate("arrivalTime <", value, "arrivaltime");
            return (Criteria) this;
        }

        public Criteria andArrivaltimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("arrivalTime <=", value, "arrivaltime");
            return (Criteria) this;
        }

        public Criteria andArrivaltimeIn(List<Date> values) {
            addCriterionForJDBCDate("arrivalTime in", values, "arrivaltime");
            return (Criteria) this;
        }

        public Criteria andArrivaltimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("arrivalTime not in", values, "arrivaltime");
            return (Criteria) this;
        }

        public Criteria andArrivaltimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("arrivalTime between", value1, value2, "arrivaltime");
            return (Criteria) this;
        }

        public Criteria andArrivaltimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("arrivalTime not between", value1, value2, "arrivaltime");
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