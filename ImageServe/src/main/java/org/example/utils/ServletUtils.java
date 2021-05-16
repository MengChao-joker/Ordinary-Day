package org.example.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class ServletUtils {
    private static final ObjectMapper M = new ObjectMapper();

    //java对象序列化为json字符串
    public static String serialize(Object o) {
        try {
            return M.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("序列化java对象失败："+o,e);
        }
    }

    public static void set(HttpServletRequest req,HttpServletResponse resp){
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("不支持编码异常！"+e);
        }
        resp.setCharacterEncoding("UTF-8");
    }
}
