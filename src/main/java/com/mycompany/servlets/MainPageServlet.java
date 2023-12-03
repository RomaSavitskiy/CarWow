package com.mycompany.servlets;

import com.mycompany.entity.User;
import com.mycompany.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/main")
public class MainPageServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("login"), req.getParameter("password"));

        UserService userService = new UserService();
        userService.addUser(user);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
