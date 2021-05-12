package Summary;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;

class Books{
    int id;
    String name;
    String author;
    double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}

public class MysqlConnect {

    public static void main(String[] args) throws SQLException {

        MysqlDataSource dataSource = new MysqlDataSource();
//        DataSource dataSource = new MysqlDataSource();
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String username = "root";
        String password = "052499";
        dataSource.setUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        Connection connection = dataSource.getConnection();
        int id = 3;
        String name = "水浒传";
        String author = "施耐庵";
        double price = 88.22;

        //查询语句
        String sql = "insert into books(id,name,author,price) values(?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setString(3,author);
        statement.setDouble(4,price);
        System.out.println("sql:"+statement.toString());
        int ret = statement.executeUpdate();
        if(ret>0){
            System.out.println("更新成功~~");
        }else {
            System.out.println("更新失败~~");
        }
        statement.close();
        connection.close();
       /* //获取查询内容
        Books books = new Books();
        while (resultSet.next()) {
            //实例化结果集
            books.setId(resultSet.getInt("id"));
            books.setName(resultSet.getString("name"));
            books.setAuthor(resultSet.getString("author"));
            books.setPrice(resultSet.getDouble("price"));
            System.out.println(books);

//            System.out.println(resultSet.getInt(1));
//            System.out.println(resultSet.getString(2));
//            System.out.println(resultSet.getString(3));
//            System.out.println(resultSet.getString(4));
//            System.out.println(resultSet.getString(5));
//            System.out.println(resultSet.getString(6));
//            System.out.println(resultSet.getString(7));

        }*/
    }


    public static void main2(String[] args) throws SQLException {

        MysqlDataSource dataSource = new MysqlDataSource();
//        DataSource dataSource = new MysqlDataSource();
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String username = "root";
        String password = "052499";
        dataSource.setUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        Connection connection = dataSource.getConnection();
        int id = 1;
        String name = "'1'or'1'='1'";
        //查询语句
        String sql = "select * from books where name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setInt(1,id);
        statement.setString(1, name);
        System.out.println("sql:"+statement.toString());
        ResultSet resultSet = statement.executeQuery();


        //获取查询内容
        Books books = new Books();
        while (resultSet.next()) {
            //实例化结果集
            books.setId(resultSet.getInt("id"));
            books.setName(resultSet.getString("name"));
            books.setAuthor(resultSet.getString("author"));
            books.setPrice(resultSet.getDouble("price"));
            System.out.println(books);

//            System.out.println(resultSet.getInt(1));
//            System.out.println(resultSet.getString(2));
//            System.out.println(resultSet.getString(3));
//            System.out.println(resultSet.getString(4));
//            System.out.println(resultSet.getString(5));
//            System.out.println(resultSet.getString(6));
//            System.out.println(resultSet.getString(7));

        }
        resultSet.close();
        statement.close();
        connection.close();
    }

        public static void main1(String[]args) throws ClassNotFoundException, SQLException {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.获取连接
            //url username password
            String url = "jdbc:mysql://127.0.0.1:3306/test";
            String username = "root";
            String password = "052499";
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            //3.执行sql语句
            //sql语句拼接 ——》sql注入！！！
            int id = 1;//前端参数
            String sql = "select * from books where id = " + id + "";
            //声明对象
            Statement statement = connection.createStatement();
            //结果集对象
            ResultSet resultSet = statement.executeQuery(sql);
            Books books = new Books();

            //获取查询内容
            while (resultSet.next()) {
                //实例化结果集
                books.setId(resultSet.getInt("id"));
                books.setName(resultSet.getString("name"));
                books.setAuthor(resultSet.getString("author"));
                books.setPrice(resultSet.getDouble("price"));
                System.out.println(books);

//            System.out.println(resultSet.getInt(1));
//            System.out.println(resultSet.getString(2));
//            System.out.println(resultSet.getString(3));
//            System.out.println(resultSet.getString(4));
//            System.out.println(resultSet.getString(5));
//            System.out.println(resultSet.getString(6));
//            System.out.println(resultSet.getString(7));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
}
