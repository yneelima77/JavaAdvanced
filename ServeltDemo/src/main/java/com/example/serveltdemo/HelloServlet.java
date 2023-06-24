package com.example.serveltdemo;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// Servlet 3.0
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    //manage resources that are held for the life of the servlet
    public void init() {
        message = "Hello World!";
    }

    //HTTP Get request
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");


        //Prints formatted representations of objects to a text-output stream. This class implements all of the print methods found in PrintStream.
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    //HTTP Post request
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String username = request.getParameter("myname");
        String password = request.getParameter("password");
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        pw.print("<html><head>");
        pw.print("<title> Welcome to the Web World </title>");
        pw.println("<h2> username is :" + username +"</h2> \n");
        pw.println("<h2> password is :" + password + "</h2> \n");
        pw.println("</head></html>");
    }

    //manage resources that are held for the life of the servlet
    public void destroy() {
    }
}
