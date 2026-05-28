package com.example.javaapp;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/dashboard")
public class SessionDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        HttpSession session = request.getSession(false);

        response.getWriter().println("""
<!DOCTYPE html>
<html>
<head>
<title>Dashboard</title>

<style>

body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(135deg,#0f172a,#020617);
    font-family:Arial;
    color:white;
}

.card{
    width:500px;
    padding:40px;
    border-radius:25px;
    background:rgba(255,255,255,0.05);
    border:1px solid rgba(255,255,255,0.1);
    text-align:center;
    box-shadow:0 0 30px rgba(0,245,255,0.15);
}

h1{
    color:#00f5ff;
}

.ok{color:#22c55e;font-size:20px;}
.bad{color:#ef4444;font-size:20px;}

a{
    display:inline-block;
    margin-top:20px;
    padding:12px 20px;
    background:#00f5ff;
    color:black;
    border-radius:10px;
    text-decoration:none;
    font-weight:bold;
}

a:hover{
    background:#22d3ee;
}

</style>

</head>

<body>

<div class="card">

<h1>DASHBOARD</h1>
""");

        if (session != null && session.getAttribute("username") != null) {

            String name = (String) session.getAttribute("username");

            response.getWriter().println("<p class='ok'>Welcome " + name + "</p>");
            response.getWriter().println("<a href='Logout'>Logout</a>");

        } else {

            response.getWriter().println("<p class='bad'>Session Expired</p>");
            response.getWriter().println("<a href='signin'>Go Login</a>");
        }

        response.getWriter().println("""
</div>

</body>
</html>
""");
    }
}