package com.blackj.leran.java.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Program Name: java-basic
 * <p>
 * Description: 用户DAO实现
 * <p>
 * Created by Zhang.Haixin on 2018/11/21
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class UserDaoImpl extends BaseDao implements UserDao{

    @Override
    public List<User> getUserList() throws Exception {

        // 得到数据库连接
        Connection conn = BaseDao.getConnection();
        String sql = "select * from User";
        //预编译声明
        PreparedStatement stmt= conn.prepareStatement(sql);
        //执行SQL返回结果集
        ResultSet rs = stmt.executeQuery();
        List<User> userList = new ArrayList<User>();
        while(rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String gender = rs.getString("gender");
            User user = new User(id, name, gender);
            userList.add(user);
        }
        //关闭资源
        BaseDao.closeAll(conn, stmt, rs);
        return userList;
    }
}
