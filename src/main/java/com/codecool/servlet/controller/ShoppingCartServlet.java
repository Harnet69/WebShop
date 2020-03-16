package com.codecool.servlet.controller;

import com.codecool.servlet.model.Cart;
import com.codecool.servlet.model.Item;
import com.codecool.servlet.view.ShoppingCartView;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "shoppingCartServlet", urlPatterns = {"/shopping-cart"}, loadOnStartup = 2)
public class ShoppingCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        String title = "Shopping Cart";
        ShoppingCartView view = new ShoppingCartView(out, title);

        view.showTable();
    }
}
