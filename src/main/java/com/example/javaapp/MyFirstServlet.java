package com.example.javaapp;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/hello")
public class MyFirstServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");

        out.println("<head>");

        out.println("<title>My First Servlet</title>");

        out.println("<style>");

        out.println("body{");
        out.println("margin:0;");
        out.println("height:100vh;");
        out.println("display:flex;");
        out.println("justify-content:center;");
        out.println("align-items:center;");
        out.println("background:linear-gradient(135deg,#0f172a,#020617);");
        out.println("font-family:Arial,sans-serif;");
        out.println("color:white;");
        out.println("}");

        out.println(".card{");
        out.println("width:600px;");
        out.println("padding:40px;");
        out.println("border-radius:25px;");
        out.println("background:rgba(255,255,255,0.05);");
        out.println("border:1px solid rgba(255,255,255,0.1);");
        out.println("text-align:center;");
        out.println("box-shadow:0 0 30px rgba(0,255,255,0.2);");
        out.println("backdrop-filter:blur(10px);");
        out.println("}");

        out.println("h1{");
        out.println("font-size:42px;");
        out.println("color:#00f5ff;");
        out.println("margin-bottom:20px;");
        out.println("}");

        out.println("p{");
        out.println("font-size:20px;");
        out.println("color:#d1d5db;");
        out.println("}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='card'>");

        out.println("<h1>Welcome to Advanced Java!</h1>");

        out.println("<p>This is my first Servlet program.</p>");

        out.println("</div>");

        out.println("</body>");

        out.println("</html>");
    }
}