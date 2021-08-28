package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CartItem;

@WebServlet("/remove")
public class RemoveServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            String pname = req.getParameter("name");
            List<CartItem> list = (ArrayList<CartItem>)req.getSession().getAttribute("cartitems");
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).getProductname().equals(pname)){
                    list.remove(i);
                    break;
                }
            }
            resp.sendRedirect("cart.jsp");
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
