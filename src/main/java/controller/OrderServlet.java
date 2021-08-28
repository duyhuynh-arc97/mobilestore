package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DetailDAO;
import model.CartItem;
import model.Product;

@WebServlet("/order")
public class OrderServlet extends HttpServlet{
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            String pname = req.getParameter("pname");   
            DetailDAO dao = new DetailDAO();
            Product a = dao.getDetail(pname);
            CartItem b = new CartItem(a.getName(), 1, a.getUnitprice(), a.getUnitprice());
            HttpSession session = req.getSession();

            if(session.getAttribute("cartitems") == null){
                List<CartItem> list = new ArrayList<CartItem>();
                list.add(b);
                session.setAttribute("cartitems", list);
            }
            else{
                List<CartItem> list = (ArrayList<CartItem>)session.getAttribute("cartitems");
                int count = 0;
                for(CartItem c:list){
                    if(c.getProductname().equals(b.getProductname())){
                        int qty = c.getQuantity() + 1;
                        int up = c.getUnitprice();
                        c.setQuantity(qty);;
                        c.setTotal(qty*up);;
                        count++;
                        break;
                    }
                }
                if(count == 0){
                    list.add(b);
                }
                session.setAttribute("cartitems", list);
            }

            resp.sendRedirect("cart.jsp");
        } catch (Exception e) {

        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        processRequest(request, response);
    }
}
