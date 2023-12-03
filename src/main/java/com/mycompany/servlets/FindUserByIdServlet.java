package com.mycompany.servlets;

import com.mycompany.entity.User;
import com.mycompany.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/user")
public class FindUserByIdServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        int userId = Integer.parseInt(req.getParameter("userId"));
        Optional<User> user = userService.findUserById(userId);

        if (user.isPresent()) {
            session.setAttribute("UserNotFoundExc", "false");
            session.setAttribute("user", user.get());
        } else {
            session.setAttribute("UserNotFoundExc", "true");
        }

        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }
}
