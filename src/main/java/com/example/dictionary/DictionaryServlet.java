package com.example.dictionary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DictionaryServlet", urlPatterns = "/dictionary")
public class DictionaryServlet extends HelloServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("apple","Táo");
        dictionary.put("banana","Chuối");
        dictionary.put("mango","Xoài");
        dictionary.put("strawberry","Dâu Tây");
        dictionary.put("coconut","Dừa");
        String search = req.getParameter("txtSearch");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        String result = dictionary.get(search);
        if (result != null) {
            writer.println("word : " + search );
            writer.println("result : " + result );
        }else {
            writer.println("not found");
        }
        writer.println("</html>");
    }
}
