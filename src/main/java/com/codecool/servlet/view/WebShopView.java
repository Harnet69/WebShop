package com.codecool.servlet.view;

import com.codecool.servlet.model.Cart;
import com.codecool.servlet.model.Item;

import java.io.PrintWriter;
import java.util.Set;

public class WebShopView {
    PrintWriter out;
    Set<Item> items;
    String title;

    public WebShopView(PrintWriter out, Set<Item> items, String title) {
        this.out = out;
        this.items = items;
        this.title = title;
    }

    public void showStockItems(){
        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body>\n" +
                        "<a href='/'>Home</a><h1 align = \"center\">" + title + "</h1>" +
                        "<table align='center' border='1'> <tr><th>Name</th><th>Price</th><th>Add</th></tr>\n"
        );
        for (Item item : items) {
            out.println(
                    "<tr>" +
                            "<td>" + item.getName() + "</td>" +
                            "<td>" + item.getPrice()+ " USD" + "</td>" +
                            "<td>" + "<a href='/webshop?link_id="+ item.getId()+"&action=add'" +">Add</a>" + "</td>" +
                            "</tr>");
        }
        out.println(
                "</table>\n" +
                        "<a href=\"/shopping-cart\"><h3 align='center'>Shopping cart</h3></a>" +
                        "</body></html>"
        );
    }
}
