package com.example.javaapp;

import java.io.*;
import java.util.Date;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/datetime")
public class DateTimeServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("✅ DateTimeServlet initialized at " + new Date());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        System.out.println("✅ DateTimeServlet.doGet() called at " + new Date());

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        Date now = new Date();

        out.println("<!DOCTYPE html>");

        out.println("<html>");

        out.println("<head>");

        out.println("<title>Date Time Servlet</title>");

        out.println("<meta http-equiv='refresh' content='5'>");

        out.println("<style>");

        out.println("*{");
        out.println("margin:0;");
        out.println("padding:0;");
        out.println("box-sizing:border-box;");
        out.println("}");

        out.println("body{");

        out.println("height:100vh;");

        out.println("display:flex;");

        out.println("justify-content:center;");

        out.println("align-items:center;");

        out.println("background:linear-gradient(135deg,#0f172a,#020617);");

        out.println("font-family:Arial,sans-serif;");

        out.println("overflow:hidden;");

        out.println("color:white;");

        out.println("}");

        out.println(".card{");

        out.println("width:700px;");

        out.println("padding:50px;");

        out.println("border-radius:25px;");

        out.println("background:rgba(255,255,255,0.05);");

        out.println("border:1px solid rgba(255,255,255,0.1);");

        out.println("backdrop-filter:blur(12px);");

        out.println("text-align:center;");

        out.println("box-shadow:");
        out.println("0 0 25px rgba(0,255,255,0.2),");
        out.println("0 0 50px rgba(139,92,246,0.15);");

        out.println("}");

        out.println("h1{");

        out.println("font-size:42px;");

        out.println("margin-bottom:25px;");

        out.println("color:#00f5ff;");

        out.println("text-shadow:0 0 20px rgba(0,255,255,0.5);");

        out.println("}");

        out.println(".date{");

        out.println("font-size:28px;");

        out.println("margin:20px 0;");

        out.println("color:#d1d5db;");

        out.println("}");

        out.println("p{");

        out.println("font-size:18px;");

        out.println("margin-top:15px;");

        out.println("color:#94a3b8;");

        out.println("}");

        out.println(".refresh{");

        out.println("margin-top:25px;");

        out.println("font-size:16px;");

        out.println("color:#22d3ee;");

        out.println("}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='card'>");

        out.println("<h1>Current Date & Time</h1>");

        out.println("<div class='date'>" + now + "</div>");

        out.println("<p>Servlet Path : " + req.getServletPath() + "</p>");

        out.println("<p>Context Path : " + req.getContextPath() + "</p>");

        out.println("<div class='refresh'>⟳ Page auto-refreshes every 5 seconds</div>");

        out.println("</div>");

        out.println("</body>");

        out.println("</html>");
    }
}