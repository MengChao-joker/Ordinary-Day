package org.example.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.example.DAO.ImageDAO;
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

@MultipartConfig
@WebServlet("/image")
public class ImageServlet extends HttpServlet {
    //image路径的常量
    private static final String IMAGE_DIR = "D:\\imageServe";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.从前端获取http请求
        ServletUtils.set(req, resp);
        Part p = req.getPart("uploadImage");
        System.out.println(p.getSubmittedFileName());
        String name = p.getSubmittedFileName();//图片名
        long size = p.getSize();//图片大小
        String content_type = p.getContentType();//正文类型
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
        int num = ImageDAO.queryCount(md5);
        if (num == 0) {
            String path = IMAGE_DIR + "/" + md5 + ".jpg";
            p.write(path);
            Image image = new Image();
            image.setImage_id(5);
            image.setImage_name(name);
            image.setSize(size);
            image.setUpload_time(uploadTime);
            image.setMd5(md5);
            image.setContent_type(content_type);
            image.setPath(path);
            if (ImageDAO.insertImage(image) > 0) {
                resp.setStatus(200);
            } else {
                resp.setStatus(500);
                resp.sendError(500, "数据库插入失败！");
            }
        } else {
            resp.setStatus(500);
            resp.sendError(500, "图片已上传！");
        }
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
        if (image_id == null || image_id.equals("")) {
            doSelectAll(req, resp);
        } else {
            int id = Integer.parseInt(image_id);
            daSelectOne(id, req, resp);
        }


    }

    private void daSelectOne(int id, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("image/jpeg");
        Image image = new Image();
        image = ImageDAO.selectOne(id);
        if (image == null) {
            resp.setStatus(404);
            int status = 404;
            String message = "请求资源不存在！";
            Map<String,Object> map = new HashMap<>();
            map.put("status",status);
            map.put("message",message);
            String jsonRet = ServletUtils.serialize(map);
            resp.getWriter().println(jsonRet);
            return;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("images", image);
        String jsonRet = ServletUtils.serialize(map);
        resp.getWriter().println(jsonRet);
    }

    private void doSelectAll(HttpServletRequest req, HttpServletResponse resp) {
        List<Image> images = ImageDAO.selectAll();
        Map<String, Object> map = new HashMap<>();
        map.put("images", images);
        String jsonRet = ServletUtils.serialize(map);
        try {
            resp.getWriter().println(jsonRet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}


