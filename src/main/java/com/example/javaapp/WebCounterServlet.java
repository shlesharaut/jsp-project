package com.example.javaapp;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tool1")
public class WebCounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(true);

        // 🔢 counter logic
        Integer count = (Integer) session.getAttribute("count");

        if (count == null) {
            count = 1;
        } else {
            count++;
        }

        session.setAttribute("count", count);

        // 🎨 HTML OUTPUT (SAFE STRING CONCAT - NO TEXT BLOCK ERRORS)

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Web Counter</title>");

        out.println("<style>");

        out.println("*{margin:0;padding:0;box-sizing:border-box;}");

        out.println("body{"
                + "height:100vh;"
                + "display:flex;"
                + "justify-content:center;"
                + "align-items:center;"
                + "background:linear-gradient(135deg,#0f172a,#020617);"
                + "font-family:Arial;color:white;"
                + "}");

        out.println(".card{"
                + "width:400px;"
                + "padding:40px;"
                + "border-radius:25px;"
                + "background:rgba(255,255,255,0.05);"
                + "border:1px solid rgba(255,255,255,0.1);"
                + "text-align:center;"
                + "box-shadow:0 0 30px rgba(0,245,255,0.2);"
                + "}");

        out.println("h1{color:#00f5ff;margin-bottom:20px;}");

        out.println(".count{"
                + "font-size:55px;"
                + "color:#22c55e;"
                + "margin:20px 0;"
                + "font-weight:bold;"
                + "}");

        out.println("a{"
                + "display:inline-block;"
                + "margin-top:20px;"
                + "padding:12px 20px;"
                + "background:#00f5ff;"
                + "color:black;"
                + "border-radius:10px;"
                + "text-decoration:none;"
                + "font-weight:bold;"
                + "}");

        out.println("a:hover{background:#22d3ee;transform:scale(1.05);}");

        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='card'>");

        out.println("<h1>📊 WEB COUNTER</h1>");

        out.println("<div class='count'>" + count + "</div>");

        out.println("<p>Session based counter</p>");

        out.println("<a href='tool1'>🔄 Refresh</a>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}