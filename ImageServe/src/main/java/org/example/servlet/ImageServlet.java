package org.example.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet("/image")
@MultipartConfig
public class ImageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //1.接受前端信息请求
        Part p = req.getPart("uploadImage");
        String route = "D://image/test"+p.getSize();
        p.write(route);//保存文件到服务器本地的某个路径
        String type = p.getContentType();//获取每个part的数据格式
        long size = p.getSize();//获取上传文件的大小
        String name = p.getSubmittedFileName();//获取上传文件的名字
//        p.getInputStream();//获取上传文件的输入流
//        System.out.println("类型："+type);
//        System.out.println("大小："+size);
//        System.out.println("名字："+name);

        //2.根据请求操作数据库，完成业务逻辑

        //3.返回业务处理结果给前端
        Map<String,Object> data = new HashMap<>();
//        Map<String,Object> data = new ConcurrentHashMap<>();
        data.put("size",size);
        data.put("type",type);
        data.put("name",name);
        ServletUtils.resp(data,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
