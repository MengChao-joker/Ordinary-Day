package org.example.service;


import com.sun.scenario.effect.ImageData;
import org.example.DAO.ImageDAO;
import org.example.models.Image;
import org.example.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/imageShow")
public class ImageShowServlet extends HttpServlet {
    private static final Set<String> whiteList = new HashSet<>();
    static {
        whiteList.add("http://localhost:8080/imageserver/index.html");
        whiteList.add("http://localhost:8080/imageserver/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取前端传的图片id
        String referer = req.getHeader("Referer");
        if(!whiteList.contains(referer)){
            resp.setStatus(403);
            return;
        }
        int id = Integer.parseInt(req.getParameter("imageId"));
        //2.处理业务
        //根据id在数据库中查询图片保存的路径和类型
        Image image = ImageDAO.selectOne(id);
        String path = ImageServlet.IMAGE_DIR+image.getPath();
        resp.setContentType(image.getContent_type());
        //获取文件输入流
        FileInputStream fis = new FileInputStream(path);
        int len = 0;
        byte[] bytes = new byte[1024*8];
        //3.返回结果
        //以二进制流的格式返回给前端
        //获取响应输出流
        OutputStream os = resp.getOutputStream();//输出流输出到body
        while ((len = fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        os.flush();
        os.close();
        fis.close();

    }
}
