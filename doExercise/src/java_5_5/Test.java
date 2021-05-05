package java_5_5;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    //数据库连接操作（curd）
    static class Books{
        int id;
        String name;
        String author;
        String type;
        double price;

        @Override
        public String toString() {
            return "Books{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", author='" + author + '\'' +
                    ", type='" + type + '\'' +
                    ", price=" + price +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }


    public static void main1(String[] args) throws SQLException {
        //数据库连接池中获取连接
        MysqlDataSource dataSource = new MysqlDataSource();
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String username = "root";
        String password = "052499";
        dataSource.setUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        Connection connection = dataSource.getConnection();

        String sql = "select * from books";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Books> list = new ArrayList<>();
        while(resultSet.next()){
            Books book = new Books();
            book.setId(resultSet.getInt("id"));
            book.setName(resultSet.getString("name"));
            book.setAuthor(resultSet.getString("author"));
            book.setPrice(resultSet.getDouble("price"));
            book.setType(resultSet.getString("type"));
            list.add(book);
        }
        for (Books books:list) {
            System.out.println(books);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动，静态获取连接
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "052499";
        Connection connection = DriverManager.getConnection(url,username,password);
        //操作数据库
        String name = "三国演义";
        String sql = "select * from books where name = ?";
        /**
         * 执行带参数或不带参数的sql语句
         * 可使用占位符在sql语句中
         * 更为安全，防止sql注入
         * 会预编译，速度更快点
         */
//        Statement statement = connection.createStatement();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        ResultSet resultSet = statement.executeQuery();
        List<Books> list = new ArrayList<>();
        System.out.println(sql);
        while(resultSet.next()){
            Books book = new Books();
            book.setId(resultSet.getInt("id"));
            book.setName(resultSet.getString("name"));
            book.setAuthor(resultSet.getString("author"));
            book.setPrice(resultSet.getDouble("price"));
            book.setType(resultSet.getString("type"));
            list.add(book);
        }
        //迭代器遍历
        Iterator<Books> iterator = list.iterator();
        while(iterator.hasNext()){
            Books books = iterator.next();
            System.out.println(books);
//            System.out.println(iterator.next());

        }







    }
}
