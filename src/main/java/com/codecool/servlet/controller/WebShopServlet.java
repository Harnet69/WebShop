package com.codecool.servlet.controller;

import com.codecool.servlet.model.Cart;
import com.codecool.servlet.model.Item;
import com.codecool.servlet.model.Stock;
import com.codecool.servlet.view.WebShopView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet(name = "webShopServlet", urlPatterns = {"/webshop"}, loadOnStartup = 2)
public class WebShopServlet extends HttpServlet {
    Stock stock = Stock.getInstance();
    Cart cart = Cart.getInstance();

    public void init() throws ServletException {
        stock.addDefaultItemsToStock();
        stock.addItemToStock(new Item("Toilet paper", 0.99));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String title = "WebShop";
        Set<Item> items = Stock.getInstance().getItemsInStock();
        WebShopView view = new WebShopView(out, items, title);

        // get get parameters from user and add item with such id to cart
        String linkAction = request.getParameter("action");
        String linkId = request.getParameter("link_id");
        if(linkId != null){
            if(linkAction.equals("add")){
                cart.addItem(Stock.getInstance().getItemById(Integer.parseInt(linkId)));
            }
            else if(linkAction.equals("remove")){
                cart.removeItem(Stock.getInstance().getItemById(Integer.parseInt(linkId)));
            }
        }
        view.showTable();

    }
}
