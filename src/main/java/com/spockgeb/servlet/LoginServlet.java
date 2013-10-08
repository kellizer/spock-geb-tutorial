package com.spockgeb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Samples for the Spock/Geb Tutorials
 *
 * @author Ian Kelly
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getOutputStream().write("Only Posts allowed".getBytes());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (correctCredentials(req))
            resp.sendRedirect("/loggedIn.html");
        else
            resp.sendRedirect("/loginFailed.html");
    }

    /**
     * Validates the credentials passed in.
     * @param req
     * @return
     */
    private boolean correctCredentials(HttpServletRequest req) {
        return req.getParameter("username").equals("admin") && req.getParameter("password").equals("password");
    }
}