package org.example.utils;



import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DBUtils {
    //定义数据库连接池
    private static volatile MysqlDataSource dataSource = null;
    //数据库连接参数jdbc:mysql://127.0.0.1:3306/blog?useUnicode=true&characterEncoding=utf8&mysqlEncoding=utf8
    private static final String url = "jdbc:mysql://127.0.0.1:3306/image_system?useUnicode=true&" +
            "characterEncoding=UTF-8&mysqlEncoding=UTF-8";
    private static final String username = "root";
    private static final String password = "052499";

    public static Connection getConnection() {
        //从数据库连接池获取连接
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取数据库连接失败",e);
        }
    }

    private static DataSource getDataSource(){
        //初始化数据库连接池
        if(dataSource==null){
        synchronized (DBUtils.class) {
            if (dataSource == null) {
                dataSource = new MysqlDataSource();
                dataSource.setUrl(url);
                dataSource.setUser(username);
                dataSource.setPassword(password);
                dataSource.setUseSSL(false);
                dataSource.setCharacterEncoding("UTF-8");
            }
        }
        }
        return dataSource;
    }

    public static void close(Connection connection, PreparedStatement statement,
                                ResultSet resultSet){
            try {
                if(resultSet!=null) resultSet.close();
                if(statement!=null) statement.close();
                if(connection!=null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("关闭数据库失败",e);
            }
    }
    public static void close(Connection connection, PreparedStatement statement){
        close(connection,statement,null);
    }


}
