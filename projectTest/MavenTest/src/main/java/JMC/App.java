package JMC;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *2
 */
public class App 
{
    public static void main(String[] args) throws SQLException {
        //1.获取数据仓库
        MysqlDataSource dataSource = new MysqlDataSource();
        //2.登录
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/singer?characterEncoding=utf8&SSl=true");
        dataSource.setUser("root");
        dataSource.setPassword("052499");
        Connection connection = (Connection) dataSource.getConnection();//创建链接
        //3.拼接sql
        String sql = "select * from singer where age = ?";
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
        statement.setInt(1,29);
        //4.查询sql
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            System.out.printf("%s,%s,%s,%s,%s",
                    resultSet.getString("nickname"),
                    resultSet.getString("name"),
                    resultSet.getString("music"),
                    resultSet.getString("age"),
                    resultSet.getString("birthday")
            );
        }
        resultSet.close();
        statement.close();
        connection.close();

    }
    public static void main1( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
