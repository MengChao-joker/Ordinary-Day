import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        String url = req.getRequestURI();
        String method = req.getMethod();
        String contentType = req.getContentType();

        PrintWriter writer = resp.getWriter();
        writer.println(String.format("<H1>method:%s</H1>",method));

    }
}
