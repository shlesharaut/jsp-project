package com.example.javaapp;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookieManager")
public class CookieManagerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String action = req.getParameter("action");

        resp.setContentType("text/html");

        if ("create".equals(action)) {

            // CREATE COOKIE

            Cookie userCookie = new Cookie("username", "Shlesha");

            userCookie.setMaxAge(60 * 60 * 24);

            resp.addCookie(userCookie);

            // OUTPUT PAGE

            resp.getWriter().println(

                    "<!DOCTYPE html>" +

                            "<html>" +

                            "<head>" +

                            "<title>Cookie Manager</title>" +

                            "<style>" +

                            "*" +
                            "{" +
                            "margin:0;" +
                            "padding:0;" +
                            "box-sizing:border-box;" +
                            "}" +

                            "body{" +
                            "height:100vh;" +
                            "display:flex;" +
                            "justify-content:center;" +
                            "align-items:center;" +

                            "background:linear-gradient(135deg,#0f172a,#020617);" +

                            "font-family:Arial,sans-serif;" +
                            "overflow:hidden;" +
                            "}" +

                            ".card{" +

                            "width:500px;" +

                            "padding:40px;" +

                            "border-radius:25px;" +

                            "background:rgba(255,255,255,0.05);" +

                            "border:1px solid rgba(255,255,255,0.1);" +

                            "backdrop-filter:blur(12px);" +

                            "text-align:center;" +

                            "color:white;" +

                            "box-shadow:" +
                            "0 0 20px rgba(0,255,255,0.2)," +
                            "0 0 50px rgba(139,92,246,0.15);" +

                            "}" +

                            "h1{" +

                            "font-size:42px;" +

                            "margin-bottom:20px;" +

                            "color:#00f5ff;" +

                            "text-shadow:0 0 20px rgba(0,255,255,0.5);" +

                            "}" +

                            "p{" +

                            "font-size:20px;" +

                            "color:#d1d5db;" +

                            "margin:12px 0;" +

                            "}" +

                            "button{" +

                            "margin-top:30px;" +

                            "padding:14px 28px;" +

                            "border:none;" +

                            "border-radius:12px;" +

                            "background:#00f5ff;" +

                            "color:black;" +

                            "font-size:16px;" +

                            "font-weight:bold;" +

                            "cursor:pointer;" +

                            "transition:0.3s;" +

                            "}" +

                            "button:hover{" +

                            "transform:scale(1.05);" +

                            "background:#22d3ee;" +

                            "}" +

                            "</style>" +

                            "</head>" +

                            "<body>" +

                            "<div class='card'>" +

                            "<h1>COOKIE CREATED</h1>" +

                            "<p>User Cookie Added Successfully</p>" +

                            "<p><b>Username :</b> Shlesha</p>" +

                            "<button onclick=\"window.location.href='index.jsp'\">" +

                            "Back to Dashboard" +

                            "</button>" +

                            "</div>" +

                            "</body>" +

                            "</html>"

            );
        }
    }
}