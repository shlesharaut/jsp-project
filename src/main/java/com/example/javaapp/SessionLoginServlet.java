package com.example.javaapp;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class SessionLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // Create session
        HttpSession session = request.getSession();

        // Store username
        String user = "Shlesha";
        session.setAttribute("username", user);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Welcome, " + user + "</h2>");
        out.println("<p>Session Created Successfully.</p>");
        out.println("<a href='Dashboard'>Go to Dashboard</a>");
        out.println("</body></html>");
    }
}