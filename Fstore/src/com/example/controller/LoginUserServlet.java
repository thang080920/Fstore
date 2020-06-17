package com.example.controller;

import com.example.da.UserDataAccess;
import com.example.entity.Product;
import com.example.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginUserServlet")
public class LoginUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        HttpSession session = request.getSession();
        try {
            if (UserDataAccess.checkUser(username,password)){
                session.setAttribute("user",user);
                response.sendRedirect("Products.jsp");
            }else {
                response.sendRedirect("fail.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
