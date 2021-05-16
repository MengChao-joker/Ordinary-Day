package org.example.DAO;

import org.example.models.Image;
import org.example.service.ImageServlet;
import org.example.utils.DBUtils;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageDAO {

    public static Integer queryCount(String md5) {
        //1.获取数据库连接 connection
        //2.获取命令执行指令 statement+sql
        //3.执行sql
        //4.如果是查询操作，需处理结果集 resultSet
        //5.释放资源
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select count(*) c from image_table where md5 = ?";
        try {
            connection = DBUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, md5);
            resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("c");
        } catch (SQLException e) {
            throw new RuntimeException("查询上传图片md5异常:" + md5, e);
        } finally {
            DBUtils.close(connection, statement,resultSet);
        }
    }

    public static int insertImage(Image image) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "insert into image_table values(null,?,?,?,?,?,?)";
        try {
            connection = DBUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, image.getImage_name());
            statement.setLong(2, image.getSize());
            statement.setString(3, image.getUpload_time());
            statement.setString(4, image.getMd5());
            statement.setString(5, image.getContent_type());
            statement.setString(6, image.getPath());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("插入图片异常！" , e);
        } finally {
            DBUtils.close(connection, statement);
        }
    }

    public static List<Image> selectAll() {
        List<Image> images = new ArrayList<>();
        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from image_table";
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            Image image = null;
            while (resultSet.next()) {
                image = new Image();
                image.setImageId(resultSet.getInt("image_id"));
                image.setImage_name(resultSet.getString("image_name"));
//                image.setSize(resultSet.getLong("size"));
//                image.setUpload_time(resultSet.getString("upload_time"));
                image.setMd5(resultSet.getString("md5"));
                image.setContent_type(resultSet.getString("content_type"));
                image.setPath(resultSet.getString("path"));
                images.add(image);
            }
            return images;
        } catch (SQLException e) {
            throw new RuntimeException("查询所有图片异常！" + e);
        } finally {
            DBUtils.close(connection, statement, resultSet);
        }

    }

    public static Image selectOne(int id) {
        Image image = null;
        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from image_table where image_id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                image = new Image();
                image.setImageId(resultSet.getInt("image_id"));
                image.setImage_name(resultSet.getString("image_name"));
//                image.setSize(resultSet.getLong("size"));
//                image.setUpload_time(resultSet.getString("upload_time"));
                image.setMd5(resultSet.getString("md5"));
                image.setContent_type(resultSet.getString("content_type"));
                image.setPath(resultSet.getString("path"));
            }
            return image;
        } catch (SQLException e) {
            throw new RuntimeException("查询一张图片异常！" + e);
        } finally {
            DBUtils.close(connection, statement, resultSet);
        }
    }

    public static int deleteOne(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        int ret = -1;
        try {
            connection = DBUtils.getConnection();
            connection.setAutoCommit(false);//开启事务，系手动提交
            String sql = "delete from image_table where image_id = ?";
            statement  = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ret = statement.executeUpdate();
            //删除服务器本地资源
            File file = new File(ImageServlet.IMAGE_DIR+getPath(id));
            file.delete();
            connection.commit();
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException se) {
                throw new RuntimeException("删除图片回滚异常:"+id,se);
            }
            throw new RuntimeException("删除一张图片异常",exception);
        } finally {
            DBUtils.close(connection,statement);
        }
        return ret;
    }

    private static String getPath(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String ret = null;

        try {
            connection = DBUtils.getConnection();
            String sql = "select path from image_table where image_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                ret = resultSet.getString("path");
            }
        } catch (SQLException exception) {
            throw new RuntimeException("获取图片本地路径异常",exception);
        } finally {
            DBUtils.close(connection,statement,resultSet);
        }
        return ret;
    }
}
