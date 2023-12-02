package com.mycompany.controller;

import com.mycompany.entity.User;
import com.mycompany.repository.UserRepository;
import com.mycompany.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(login, password);

        UserService userService = new UserService();
        userService.addUser(user);

        ArrayList<User> userList = new ArrayList<>(userService.findAllUsers());
        session.setAttribute("userList", userList);

        session.setAttribute("Hello", "Hello");

        resp.sendRedirect("main.jsp");
    }

}
