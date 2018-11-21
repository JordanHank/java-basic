package com.blackj.leran.java.database;

import java.sql.*;

/**
 * Program Name: java-basic
 * <p>
 * Description: java JDBC连接数据库介绍
 * <p>
 * Created by Zhang.Haixin on 2018/11/21
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class JDBCIntro {

    /**
     * JDBC连接数据库需要对应的数据库驱动jar包
     * 下面示例是mysql数据库User查询结果
     *
     * User: id name gender
     */

    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/User";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name, gender FROM user";
            //执行查询sql 返回结果集
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                String id = rs.getString("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");

                // 输出数据
                System.out.println("id:" + id + " name:" + name + " gender:" + gender);
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if(stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
