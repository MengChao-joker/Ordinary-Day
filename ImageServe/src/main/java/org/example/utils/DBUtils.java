package org.example.utils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class DBUtils {
    //数据库连接的参数
    private static volatile DataSource dataSource = null;
    private static String username = "root";
    private static String password = "052499";//useUnicode=true&characterEncoding=utf8&mysqlEncoding=utf8
    private static String url = "jdbc:mysql://127.0.0.1:3306/image_system?useUnicode=true&characterEncoding=utf8" +
            "&mysqlEncoding=utf8&useSSL=true";

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    private static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DBUtils.class) {
                if (dataSource == null) {
                    //初始化dataSource
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource) dataSource).setUrl(url);
                    ((MysqlDataSource) dataSource).setUser(username);
                    ((MysqlDataSource) dataSource).setPassword(password);
                }
            }
        }
        return dataSource;
    }

    private static void close(Connection connection, PreparedStatement statement,
                                 ResultSet resultSet) {
        //关闭数据库相关操作
        try {
            if(resultSet!=null)resultSet.close();
            if(statement!=null) statement.close();
            if(connection!=null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
