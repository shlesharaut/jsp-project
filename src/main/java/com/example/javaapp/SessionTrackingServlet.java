package com.example.javaapp;

import java.io.*;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/sessiontrack")
public class SessionTrackingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        HttpSession session = req.getSession(true);

        // TRACK PAGE VISITS

        Integer visitCount = (Integer) session.getAttribute("visitCount");

        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }

        session.setAttribute("visitCount", visitCount);

        // TRACK FIRST VISIT

        Date firstVisit = (Date) session.getAttribute("firstVisit");

        if (firstVisit == null) {
            firstVisit = new Date();
            session.setAttribute("firstVisit", firstVisit);
        }

        // HANDLE SESSION INVALIDATE

        if (req.getParameter("invalidate") != null) {

            session.invalidate();

            resp.sendRedirect("sessiontrack");

            return;
        }

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");

        out.println("<html>");

        out.println("<head>");

        out.println("<title>Session Tracking</title>");

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

        out.println("color:white;");

        out.println("overflow:hidden;");

        out.println("}");

        out.println(".card{");

        out.println("width:850px;");

        out.println("padding:40px;");

        out.println("border-radius:25px;");

        out.println("background:rgba(255,255,255,0.05);");

        out.println("border:1px solid rgba(255,255,255,0.1);");

        out.println("backdrop-filter:blur(12px);");

        out.println("box-shadow:");
        out.println("0 0 25px rgba(0,255,255,0.2),");
        out.println("0 0 50px rgba(139,92,246,0.15);");

        out.println("text-align:center;");

        out.println("}");

        out.println("h1{");

        out.println("font-size:40px;");

        out.println("margin-bottom:30px;");

        out.println("color:#00f5ff;");

        out.println("text-shadow:0 0 20px rgba(0,255,255,0.5);");

        out.println("}");

        out.println("table{");

        out.println("width:100%;");

        out.println("border-collapse:collapse;");

        out.println("margin-top:20px;");

        out.println("overflow:hidden;");

        out.println("border-radius:15px;");

        out.println("}");

        out.println("th{");

        out.println("background:#00f5ff;");

        out.println("color:black;");

        out.println("padding:16px;");

        out.println("font-size:18px;");

        out.println("}");

        out.println("td{");

        out.println("padding:15px;");

        out.println("border-bottom:1px solid rgba(255,255,255,0.08);");

        out.println("color:#d1d5db;");

        out.println("}");

        out.println("tr:hover{");

        out.println("background:rgba(255,255,255,0.05);");

        out.println("}");

        out.println(".btn-container{");

        out.println("margin-top:30px;");

        out.println("}");

        out.println("a{");

        out.println("text-decoration:none;");

        out.println("padding:14px 24px;");

        out.println("margin:10px;");

        out.println("display:inline-block;");

        out.println("border-radius:12px;");

        out.println("background:#00f5ff;");

        out.println("color:black;");

        out.println("font-weight:bold;");

        out.println("transition:0.3s;");

        out.println("}");

        out.println("a:hover{");

        out.println("transform:scale(1.05);");

        out.println("background:#22d3ee;");

        out.println("}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='card'>");

        out.println("<h1>📊 Session Tracking Dashboard</h1>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>Session Property</th>");
        out.println("<th>Value</th>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Session ID</td>");
        out.println("<td>" + session.getId() + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Creation Time</td>");
        out.println("<td>" + new Date(session.getCreationTime()) + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Last Accessed</td>");
        out.println("<td>" + new Date(session.getLastAccessedTime()) + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Visit Count</td>");
        out.println("<td>" + visitCount + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>First Visit</td>");
        out.println("<td>" + firstVisit + "</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>Is New Session?</td>");
        out.println("<td>" + session.isNew() + "</td>");
        out.println("</tr>");

        out.println("</table>");

        out.println("<div class='btn-container'>");

        out.println("<a href='" + resp.encodeURL("sessiontrack") + "'>");
        out.println("🔄 Refresh Page");
        out.println("</a>");

        out.println("<a href='sessiontrack?invalidate=true'>");
        out.println("🗑 Invalidate Session");
        out.println("</a>");

        out.println("</div>");

        out.println("</div>");

        out.println("</body>");

        out.println("</html>");
    }
}