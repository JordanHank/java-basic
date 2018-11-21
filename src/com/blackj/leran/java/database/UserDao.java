package com.blackj.leran.java.database;

import java.util.List;

/**
 * Program Name: java-basic
 * <p>
 * Description: 查询用户DAO
 * <p>
 * Created by Zhang.Haixin on 2018/11/21
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public interface UserDao {

    /**
     * 查询用户集合
     * @return 用户集合
     * @throws Exception 抛出异常
     */
    List<User> getUserList() throws Exception;
}
