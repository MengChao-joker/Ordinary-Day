import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/singer?useSSL=true";
        String name = "root";
        String password = "052499";
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUrl(url);
        mysqlDataSource.setUser(name);
        mysqlDataSource.setPassword(password);
        Connection connection = mysqlDataSource.getConnection();
        String sql = "update singer set age = 26 where name = '毛不易'";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        String sql1 = "select age from singer";
        ResultSet resultSet = preparedStatement.executeQuery(sql1);
        while(resultSet.next()){
        System.out.println(resultSet.getInt(1));
    }
    }
    public static void main4(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        //jdbc:mysql://ip地址:短空/数据库名？useSSl = false
        String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=true";
        String username = "root";//数据库名称
        String password = "052499";//数据库密码
        MysqlDataSource dataSource = new MysqlDataSource();//获取数据源
        //登录
        dataSource.setUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        Connection connection = dataSource.getConnection();
        //3.执行SQl语句
        String uname = "更名";
        String sql = "select * from user";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //结果集
//        preparedStatement.setString(1,uname);
//        preparedStatement.setInt(2,1);
//        System.out.println(preparedStatement.toString());
//        int ret = preparedStatement.executeUpdate();
//        if(ret != 0){
//            System.out.println("更新成功");
//        }
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = new User();
        while(resultSet.next()) {
//            System.out.println(resultSet.getInt(1));
//            System.out.println(resultSet.getString(2));
//            System.out.println(resultSet.getString(3));
            user.setId(resultSet.getInt(1));
            user.setUsedName(resultSet.getString(2));
            user.setPassWord(resultSet.getString(3));
            System.out.println("查询的结果是：" + user);
        }
    }
    public static void main3(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        //jdbc:mysql://ip地址:短空/数据库名？useSSl = false
        String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=true";
        String username = "root";//数据库名称
        String password = "052499";//数据库密码
        MysqlDataSource dataSource = new MysqlDataSource();//获取数据源
        //登录
        dataSource.setUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        Connection connection = dataSource.getConnection();
        //3.执行SQl语句
        String sql = "select * from user where name = ? and password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //结果集
        preparedStatement.setString(1, "jmc");
        preparedStatement.setString(2, "123456");
        System.out.println(preparedStatement.toString());
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = new User();
        if (resultSet.next()) {
//            System.out.println(resultSet.getInt(1));
//            System.out.println(resultSet.getString(2));
//            System.out.println(resultSet.getString(3));
            user.setId(resultSet.getInt(1));
            user.setUsedName(resultSet.getString(3));
            user.setPassWord(resultSet.getString(2));
        }
        System.out.println("查询的结果是：" + user);
    }
    public static void main2(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        //jdbc:mysql://ip地址:短空/数据库名？useSSl = false
        String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=true";
        String username = "root";
        String password = "052499";
        Connection connection = DriverManager.getConnection(url,username,password);
        //3.执行SQl语句
        String uname = "jmc";
        String pass = "2' or '2' = '2";
        String sql = "select * from user where name = '"+uname+"' and password = '"+pass+"'";

        Statement statement = connection.createStatement();
        //结果集
        ResultSet resultSet = statement.executeQuery(sql);
        User user = new User();
        if(resultSet.next()){
//            System.out.println(resultSet.getInt(1));
//            System.out.println(resultSet.getString(2));
//            System.out.println(resultSet.getString(3));
            user.setId(resultSet.getInt(1));
            user.setUsedName(resultSet.getString(3));
            user.setPassWord(resultSet.getString(2));
        }
        System.out.println("查询的结果是："+user);

    }
    public static void main1(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        //jdbc:mysql://ip地址:短空/数据库名？useSSl = false
        String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=true";
        String username = "root";
        String password = "052499";
        Connection connection = DriverManager.getConnection(url,username,password);
        //3.执行SQl语句
        String sql = "select * from user";

        Statement statement = connection.createStatement();
        //结果集
        ResultSet resultSet = statement.executeQuery(sql);
        User user = new User();
        if(resultSet.next()){
//            System.out.println(resultSet.getInt(1));
//            System.out.println(resultSet.getString(2));
//            System.out.println(resultSet.getString(3));
            user.setId(resultSet.getInt(1));
            user.setUsedName(resultSet.getString(3));
            user.setPassWord(resultSet.getString(2));
        }
        System.out.println("查询的结果是："+user);

    }

}
