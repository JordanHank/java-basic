package com.blackj.leran.java.database;

import java.sql.*;

/**
 * Program Name: java-basic
 * <p>
 * Description: 公共JDBC DAO连接类
 * <p>
 * Created by Zhang.Haixin on 2018/11/21
 *
 * @author Zhang.Haixin
 * @version 1.0
 */
public class BaseDao {

    /**
     * DAO 模式：
     *      隔离了数据访问代码和业务逻辑代码，降低了藕合性，提高了可复用性
     *      隔离了不同数据库实现，采用面向接口编程，提高了代码扩展性和系统的可移植性
     *
     * DAO 模式组成部分：
     *      DAO接口： 把对数据库的所有操作定义成抽象方法，可以提供多种实现
     *      DAO 实现类： 针对不同数据库给出DAO接口定义方法的具体实现
     *      实体类：用于存放与传输对象数据
     *      数据库连接和关闭工具类： 避免了数据库连接和关闭代码的重复使用，方便修改
     */

    //数据库驱动
    private static String driver="com.mysql.jdbc.Driver";

    //数据库连接地址
    private static String url="jdbc:mysql://127.0.0.1:3306/User";

    //数据库用户名
    private static String user="root";

    //数据库密码
    private static String password="123456";
    static {
        try {
            //加载驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return 数据库连接
     * @throws SQLException 抛出sql异常
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 关闭连接资源
     * @param conn 连接
     * @param stmt 声明
     * @param rs 结果集
     * @throws SQLException 抛出sql异常
     */
    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        if(rs!=null) {
            rs.close();
        }
        if(stmt!=null) {
            stmt.close();
        }
        if(conn!=null) {
            conn.close();
        }
    }

    /**
     * 执行SQL
     * @param preparedSql SQL语句
     * @param param 查询参数
     * @return 执行结果条数
     * @throws ClassNotFoundException 抛出异常
     */
    public int executeSQL(String preparedSql, Object[] param) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 得到数据库连接
            conn = getConnection();
            // 得到PreparedStatement对象
            pstmt = conn.prepareStatement(preparedSql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    // 为预编译sql设置参数
                    pstmt.setObject(i + 1, param[i]);
                }
            }
            // 执行SQL语句
            ResultSet num = pstmt.executeQuery();
        } catch (SQLException e) {
            // 处理SQLException异常
            e.printStackTrace();
        } finally {
            try {
                BaseDao.closeAll(conn, pstmt, null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
