package org.example.service;


import org.apache.commons.codec.digest.DigestUtils;
import org.example.DAO.ImageDAO;
import org.example.exception.AppException;
import org.example.models.Image;
import org.example.utils.ServletUtils;


import javax.servlet.ServletException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 1. @WebServlet
 * 2. 继承HttpServlet
 * 3. 重写doXXX方法
 */
@MultipartConfig
@WebServlet("/image")
public class ImageServlet extends HttpServlet {
    //image路径的常量
    public static final String IMAGE_DIR = "D:\\imageServe";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1.从前端获取http请求
        ServletUtils.set(req, resp);
        resp.setContentType("application/json");

        Map<String,Object> map = new HashMap<>();//返回响应体
        try {
            Part p = req.getPart("uploadImage");
            String name = p.getSubmittedFileName();//图片名
            long size = p.getSize();//图片大小
            String content_type = p.getContentType();//正文类型
            System.out.println(content_type);
            //图片上传时间，数据库是以字符串格式保存，因此用日期格式化来转换
            Date date = new Date();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String uploadTime = df.format(date);
            //获取part(上传图片)的输入流
            InputStream is = p.getInputStream();
            //根据输入流转为md5校验码
            String md5 = DigestUtils.md5Hex(is);
            //如果已上传该图片（md5数据库中已存在），则不能插入数据和保存图片到本地

            /**
             * 操作数据库，判断照片是否重合，
             */
            //2.根据请求信息处理相应业务
            if (ImageDAO.queryCount(md5) >= 1) {
                throw new AppException("上传图片重复异常！");
            }
            String path = "/" + md5 + ".jpg";
            Image image = new Image();
            image.setImageId(5);
            image.setImage_name(name);
            image.setSize(size);
            image.setUpload_time(uploadTime);
            image.setMd5(md5);
            image.setContent_type(content_type);
            image.setPath(path);
            if (ImageDAO.insertImage(image) > 0) {
                p.write(IMAGE_DIR + "/" + md5 + ".jpg");
                resp.setStatus(200);
                map.put("ok", true);
            } else {
                resp.setStatus(500);
                resp.sendError(500, "数据库插入失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("ok",false);
            if(e instanceof AppException){
                map.put("msg",e.getMessage());
            }else {
                map.put("msg","未知错误，请联系管理员！");
            }
        }
        String retJson = ServletUtils.serialize(map);
        resp.getWriter().println(retJson);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.set(req, resp);
        resp.setContentType("application/json");
        /**
         * 根据前端请求决定获取一张，或所有图片
         * 获取所有照片id
         * json序列化后传给前端
         * 前端解析，显示图片内容
         */
        String image_id = req.getParameter("image_id");
        Object ret = null;//接受查询结果，一张图片或图片集用Object
        if (image_id == null || image_id.equals("")) {
            ret= ImageDAO.selectAll();
        } else {
            int id = Integer.parseInt(image_id);
            ret= ImageDAO.selectOne(id);
        }
        resp.getWriter().println(ServletUtils.serialize(ret));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.set(req, resp);
        resp.setContentType("application/json");
        Map<String,Object> map = new HashMap<>();
        //1.获取前端参数即要删除的图片ID
        //  a.删除数据库的图片
        //  b.删除本地图片资源
        try {
            int id = Integer.parseInt(req.getParameter("imageId"));
            if (ImageDAO.deleteOne(id) == 1) {
                resp.setStatus(200);
                map.put("ok",true);
            } else {
                resp.setStatus(403);
                resp.sendError(403, "删除图片失败！");
                map.put("ok",false);
                throw new AppException("删除图片异常！");
            }
        } catch (Exception e) {
            if(e instanceof AppException){
                map.put("msg",e.getMessage());
            }else {
                map.put("msg","未知错误，请联系管理员！");
            }
        } finally {
            resp.getWriter().println(ServletUtils.serialize(map));
        }
    }
}


