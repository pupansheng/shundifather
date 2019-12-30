package com.pps.pojo.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @Classname TemporaryStorage
 * @Description
 * @@Author Pupansheng
 * @Date 2019/10/9 10:38
 * @Vestion 1.0
 **/
@Document(collection = "shundiStorage")
public class TemporaryStorage {
    @Id
    private  String _id;

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    private  String key;
    private  Object data;
    private  Date  saveDate;

    @Override
    public String toString() {
        return "TemporaryStorage{" +
                "key='" + key + '\'' +
                ", data=" + data +
                ", saveDate=" + saveDate +
                '}';
    }

    public TemporaryStorage() {

    }

    @PersistenceConstructor
    public TemporaryStorage(String key, Object data, Date saveDate) {
        this.key = key;
        this.data = data;
        this.saveDate = saveDate;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Date getSaveDate() {
        return saveDate;
    }
    public void setSaveDate(Date saveDate) {
        this.saveDate = saveDate;
    }
}
