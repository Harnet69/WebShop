package com.codecool.servlet.view;

import com.codecool.servlet.model.Cart;
import com.codecool.servlet.model.Item;

import java.io.PrintWriter;
import java.util.Set;

public class ShoppingCartView {
    PrintWriter out;
    Set<Item> items;
    String title;

    public ShoppingCartView(PrintWriter out, String title) {
        this.out = out;
        this.title = title;
    }

    public void showCart() {
        out.println(
                "<html>\n" +
//                        "<head><title>" + title + "</title></head>\n" +
                        "<body>\n"
//                        "<a href='/'>Home</a><h1 align = \"center\">" + title + "</h1>"
        );
        if (Cart.getInstance().getItemPriceAmount() > 0) {
            out.println(
                    "<table align='center' border='1'> <tr><th>Name</th><th>Price</th><th>Remove</th></tr>\n"
            );
            for (Item item : Cart.getInstance().getOrderedItems()) {
                out.println(
                        "<tr>" +
                                "<td>" + item.getName() + "</td>" +
                                "<td>" + item.getPrice() + " USD" + "</td>" +
                                "<td>" + "<a href='/webshop?link_id=" + item.getId() + "&action=remove'" + ">Remove</a>" + "</td>" +
                                "</tr>");
            }
            out.println(
                    "<tr><td><b>Amount</b></td><td><b>" + Cart.getInstance().getItemPriceAmount() + " USD" + "</b></td></tr></table>\n" +
                            "</body></html>"
            );
        }
        out.println(
                "</table>\n" +
                        "</body></html>"
        );
    }
}
