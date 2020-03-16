package com.codecool.servlet.controller;

import com.codecool.servlet.model.Item;
import com.codecool.servlet.model.Stock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet(name = "shoppingCartServlet", urlPatterns = {"/shopping-cart"}, loadOnStartup = 1)
public class ShoppingCartServlet extends HttpServlet {
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        String title = "Shopping Cart";
//        Set<Item> items = Stock.getInstance().getItemsInStock();

        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body>\n" +
                        "<a href='/'>Home</a><h1 align = \"center\">" + title + "</h1>" +
                        "<table align='center' border='1'> <tr><th>Name</th><th>Price</th><th>Add</th><th>Remove</th></tr>\n"
        );
//        for (Item item : items) {
//            out.println(
//                    "<tr>" +
//                            "<td>" + item.getName() + "</td>" +
//                            "<td>" + item.getPrice()+ " USD" + "</td>" +
//                            "<td>" + "<a href='#'>Add</a>" + "</td>" +
//                            "<td>" + "<a href='#'>Remove</a>" + "</td>" +
//                            "</tr>");
//        }
        out.println(
                "</table>\n" +
                        "</body></html>"
        );
    }
}
