package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chinese")
public class ChineseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Set response content type to text/html with UTF-8 encoding
        response.setContentType("text/html;charset=UTF-8");
        
        // Obtain output stream and write the Chinese characters
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>JavaWeb程序设计任务教程</h1>");
        out.println("</body></html>");
    }
}
