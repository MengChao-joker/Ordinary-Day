import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端提交过来的参数
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        String s = req.getParameter("s");
        PrintWriter write = resp.getWriter();
        write.println("<H1>获得的参数：</H1>"+s);
        //设置页面编码


    }
}
