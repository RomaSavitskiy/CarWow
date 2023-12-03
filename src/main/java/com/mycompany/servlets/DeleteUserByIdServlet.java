package com.mycompany.servlets;

import com.mycompany.entity.User;
import com.mycompany.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/delete")
public class DeleteUserByIdServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.deleteUserById(Integer.parseInt(req.getParameter("userIdDelete")));

        List<User> userList = new ArrayList<>(userService.findAllUsers());

        req.getSession().setAttribute("userList", userList);
        req.getRequestDispatcher("users.jsp").forward(req, resp);
    }
}
