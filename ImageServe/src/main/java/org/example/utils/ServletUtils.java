package org.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ServletUtils {

    public static void resp(Map<String,Object> data, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        String jsonResp = mapper.writeValueAsString(data);
        resp.getWriter().println(jsonResp);
    }
}
