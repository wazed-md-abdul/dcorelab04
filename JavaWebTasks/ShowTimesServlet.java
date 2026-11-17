package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showtimes")
public class ShowTimesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Redirect doPost calls to doGet
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Obtain ServletContext to store the counter
        ServletContext context = getServletContext();
        
        // Retrieve current count
        Integer count = (Integer) context.getAttribute("visitCount");
        
        // If it's the first time, initialize count to 1; otherwise, increment
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        
        // Store the updated count back in ServletContext
        context.setAttribute("visitCount", count);
        
        // Respond to the user
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Website has been accessed " + count + " times.</h2>");
        out.println("</body></html>");
    }
}
