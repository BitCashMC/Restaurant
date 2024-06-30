package com.virtualpairprogrammers.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.data.MenuDao;

@WebServlet("/orderReceived.html")
public class OrderReceivedServlet extends HttpServlet {


    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
        MenuDao menuDao = new MenuDao();

        int maxId = menuDao.getFullMenu().size();
        for (int i = 0; i <maxId; i++) {
            String quantity = request.getParameter("item_" + i);
            try
            {
                int q = Integer.parseInt(quantity);
                if (q > 0) menuDao.addToOrder(menuDao.getItem(i), q);
            }
            catch(NumberFormatException nfe)
            {
                //that's fine it just means there wasn't an order for this item
            }

        }

        System.out.println("A new order has been received.");

        Double total = menuDao.getOrderTotal();

        HttpSession session = request.getSession();
        session.setAttribute("total",total);
        response.sendRedirect("/thankYou.html");

    }
}
