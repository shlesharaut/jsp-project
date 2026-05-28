package com.example.javaapp;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/autorefresh")
public class AutoRefreshServlet extends HttpServlet {

    private int visitCount = 0;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        visitCount++;

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Auto Refresh Demo</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; text-align: center; margin-top: 50px; }");
        out.println(".counter { font-size: 72px; color: #4CAF50; }");
        out.println("</style>");
        out.println("<meta http-equiv='refresh' content='3'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Page Visit Counter</h1>");
        out.println("<div class='counter'>" + visitCount + "</div>");
        out.println("<p>Page auto-refreshes every 3 seconds</p>");
        out.println("</body>");
        out.println("</html>");
    }
}