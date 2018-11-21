package com.blackj.leran.java.database;

import java.io.Serializable;

/**
 * Program Name: java-basic
 * <p>
 * Description: 用户实体
 * <p>
 * Created by Zhang.Haixin on 2018/11/21
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class User implements Serializable {

    private String id;

    private String name;

    private String gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User(String id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
