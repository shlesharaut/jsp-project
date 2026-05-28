package com.example.javaapp;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {

    // ✅ LOGIN PAGE (GET)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        response.getWriter().println("""
<!DOCTYPE html>
<html>
<head>
<title>Sign In</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
}

body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(135deg,#0f172a,#020617);
    font-family:Arial;
}

.card{
    width:360px;
    padding:40px;
    border-radius:25px;
    background:rgba(255,255,255,0.05);
    border:1px solid rgba(255,255,255,0.1);
    backdrop-filter:blur(12px);
    text-align:center;
    color:white;
    box-shadow:0 0 25px rgba(0,245,255,0.2);
}

h1{
    color:#00f5ff;
    margin-bottom:20px;
}

input{
    width:90%;
    padding:12px;
    margin:10px 0;
    border:none;
    border-radius:10px;
    background:rgba(255,255,255,0.08);
    color:white;
}

input::placeholder{
    color:#94a3b8;
}

button{
    width:95%;
    padding:12px;
    margin-top:15px;
    border:none;
    border-radius:12px;
    background:#00f5ff;
    color:black;
    font-weight:bold;
    cursor:pointer;
}

button:hover{
    background:#22d3ee;
    transform:scale(1.05);
}

</style>

</head>

<body>

<div class="card">

<h1>SIGN IN</h1>

<form action="signin" method="post">

<input type="text" name="username" placeholder="Username" required>

<input type="password" name="password" placeholder="Password" required>

<button type="submit">LOGIN</button>

</form>

</div>

</body>
</html>
""");
    }

    // ✅ LOGIN PROCESS (POST)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // ✅ SUCCESS LOGIN
        if ("admin".equals(username) && "1234".equals(password)) {

            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            response.sendRedirect("dashboard");

        }

        // ❌ ERROR LOGIN (STYLISH PAGE)
        else {

            response.setContentType("text/html");

            response.getWriter().println("""
<!DOCTYPE html>
<html>
<head>
<title>Login Failed</title>

<style>

body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(135deg,#0f172a,#020617);
    font-family:Arial;
}

.card{
    width:400px;
    padding:40px;
    border-radius:25px;
    background:rgba(255,255,255,0.05);
    border:1px solid rgba(255,0,0,0.3);
    text-align:center;
    box-shadow:0 0 30px rgba(239,68,68,0.25);
}

h1{
    color:#ef4444;
}

p{
    color:#cbd5e1;
    margin:15px 0;
}

a{
    display:inline-block;
    padding:12px 20px;
    background:#00f5ff;
    color:black;
    text-decoration:none;
    border-radius:10px;
    font-weight:bold;
}

a:hover{
    background:#22d3ee;
}

</style>

</head>

<body>

<div class="card">

<h1>❌ LOGIN FAILED</h1>

<p>Wrong username or password</p>

<a href="signin">Try Again</a>

</div>

</body>
</html>
""");
        }
    }
}