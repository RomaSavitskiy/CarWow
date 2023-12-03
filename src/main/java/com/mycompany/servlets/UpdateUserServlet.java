package com.mycompany.servlets;

import com.mycompany.entity.User;
import com.mycompany.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.findUserById(Integer.parseInt(req.getParameter("userIdUpdate")))
                .orElseThrow(() -> new NullPointerException("user is null"));

        req.getSession().setAttribute("userIdUpdate", req.getParameter("userIdUpdate"));
        req.getSession().setAttribute("userUpdate", user);
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.findUserById(Integer.parseInt((String) req.getSession().getAttribute("userIdUpdate")))
                .orElseThrow(() -> new NullPointerException("user is null"));
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        userService.updateUser(user);

        req.getSession().setAttribute("userUpdate", user);

        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }
}
