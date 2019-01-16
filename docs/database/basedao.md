# DAO 模式

DAO (DataAccessobjects 数据存取对象)是指位于业务逻辑和持久化数据之间实现对持久化数据的访问。通俗来讲，就是将数据库操作都封装起来，
对外提供相应的接口。在面向对象设计过程中，有一些"套路”用于解决特定问题称为模式。
DAO 模式提供了访问关系型数据库系统所需操作的接口，将数据访问和业务逻辑分离对上层提供面向对象的数据访问接口。

## 双重隔离

使用DAO 模式连接数据库操作，它主要的优势在于提供了下面的双重隔离。

+ 隔离了数据访问代码和业务逻辑代码，降低了藕合性，提高了可复用性。

+ 隔离了不同数据库实现，采用面向接口编程，提高了代码扩展性和系统的可移植性。

## 组成

DAO 模式组成部分：

+ DAO接口： 把对数据库的所有操作定义成抽象方法，可以提供多种实现。

+ DAO 实现类： 针对不同数据库给出DAO接口定义方法的具体实现。

+ 实体类：用于存放与传输对象数据。

+ 数据库连接和关闭工具类： 避免了数据库连接和关闭代码的重复使用，方便修改。

## 示例

下面以读取用户信息为例，展示怎样使用DAO 模式操作数据库。

#### User 类

``` java
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
```

#### User DAO接口

``` java
public interface UserDao {

    /**
     * 查询用户集合
     * @return 用户集合
     * @throws Exception 抛出异常
     */
    List<User> getUserList() throws Exception;
}
```

#### 数据库连接

``` java
public class BaseDao {

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
```

#### User DAO实现

``` java
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
```