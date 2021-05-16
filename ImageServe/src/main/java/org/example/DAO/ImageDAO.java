package org.example.DAO;

import org.example.models.Image;
import org.example.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageDAO {
    private static int ret;

    public static Integer queryCount(String md5) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;
        String sql = "select * from image_table where md5 = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,md5);
            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                ret = 1;
            }
            return ret;
        } catch (SQLException e) {
            throw new RuntimeException("数据库操作异常"+e);
        } finally {
            DBUtils.close(connection,statement);
        }
    }

    public static int insertImage(Image image) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;
        String sql = "insert into image_table values(null,?,?,?,?,?,?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,image.getImage_name());
            statement.setLong(2,image.getSize());
            statement.setString(3,image.getUpload_time());
            statement.setString(4,image.getMd5());
            statement.setString(5,image.getContent_type());
            statement.setString(6,image.getPath());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("插入图片异常！"+e);
        } finally {
            DBUtils.close(connection,statement);
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
            while(resultSet.next()){
                Image image = new Image();
                image.setImage_id(resultSet.getInt("image_id"));
                image.setImage_name(resultSet.getString("image_name"));
                image.setSize(resultSet.getLong("size"));
                image.setUpload_time(resultSet.getString("upload_time"));
                image.setMd5(resultSet.getString("md5"));
                image.setContent_type(resultSet.getString("content_type"));
                image.setPath(resultSet.getString("path"));
                images.add(image);
            }
            return images;
        } catch (SQLException e) {
            throw new RuntimeException("查询所有图片异常！"+e);
        } finally {
            DBUtils.close(connection,statement,resultSet);
        }

    }

    public static Image selectOne(int id) {
        Image image = new Image();
        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from image_table where image_id = ?";
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            statement.setInt(1,id);
            while (resultSet.next()){
                image.setImage_id(resultSet.getInt("image_id"));
                image.setImage_name(resultSet.getString("image_name"));
                image.setSize(resultSet.getLong("size"));
                image.setUpload_time(resultSet.getString("upload_time"));
                image.setMd5(resultSet.getString("md5"));
                image.setContent_type(resultSet.getString("content_type"));
                image.setPath(resultSet.getString("path"));
            }
            return image;
        } catch (SQLException e) {
            throw new RuntimeException("查询一张图片异常！"+e);
        } finally {
            DBUtils.close(connection,statement,resultSet);
        }
    }
}
