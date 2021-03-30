import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LocalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        if(pwd!=null&name!=null&&name.equals("root")&&pwd.equals("root")){
            resp.setStatus(301);
//            resp.setHeader("location","https://www.baidu.com/");
            resp.sendRedirect("https://www.baidu.com/");
        }else {
            PrintWriter writer = resp.getWriter();
            writer.println("<H1>输入错误！</H1>");
        }
    }
}
