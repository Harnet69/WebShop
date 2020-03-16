package com.codecool.servlet.controller;

import com.codecool.servlet.model.Cart;
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

        // get get parameters from user and add item with such id to cart
        String linkId = request.getParameter("link_id");
        if(linkId != null){
            cart.addItem(Stock.getInstance().getItemById(Integer.parseInt(linkId)));
            System.out.println(cart.getOrderedItems());
        }

        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body>\n" +
                        "<a href='/'>Home</a><h1 align = \"center\">" + title + "</h1>" +
                        "<table align='center' border='1'> <tr><th>Name</th><th>Price</th><th>Add</th><th>Remove</th></tr>\n"
        );
        for (Item item : items) {
            out.println(
                    "<tr>" +
                            "<td>" + item.getName() + "</td>" +
                            "<td>" + item.getPrice()+ " USD" + "</td>" +
                            "<td>" + "<a href='/webshop?link_id="+ item.getId()+"'" +">Add</a>" + "</td>" +
                            "<td>" + "<a href='/webshop?link_id="+ item.getId()+"'" +">Remove</a>" + "</td>" +
                    "</tr>");
        }
        out.println(
                "</table>\n" +
                       "<a href=\"/shopping-cart\"><h3 align='center'>Shopping cart</h3></a>" +
                        "</body></html>"
        );
    }
}
