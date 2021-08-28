package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DetailDAO;
import model.Product;

@WebServlet("/details")
public class DetailServlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        resp.setContentType("text/html;charset=UTF-8");
        try {
            String pname = req.getParameter("pname");
            DetailDAO dao = new DetailDAO();
            Product a = dao.getDetail(pname);
            req.setAttribute("data", a);
            RequestDispatcher rd = req.getRequestDispatcher("details.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            //TODO: handle exception
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
