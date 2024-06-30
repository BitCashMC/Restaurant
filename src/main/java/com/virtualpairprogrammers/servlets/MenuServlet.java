package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.data.MenuDao;
import com.virtualpairprogrammers.domain.MenuItem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class MenuServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MenuDao menu = new MenuDao();
        List<MenuItem> menuItems = menu.getFullMenu();

        request.setAttribute("menuItems",menuItems);

        ServletContext servletContext = this.getServletContext();

        RequestDispatcher dispatch = servletContext.getRequestDispatcher("/menu.jsp");
        dispatch.forward(request,response);
    }
}
