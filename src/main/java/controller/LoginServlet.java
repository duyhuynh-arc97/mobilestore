package controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LoginDAO;


@WebServlet("/validate")
public class LoginServlet extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter out = resp.getWriter();
        LoginDAO dao = new LoginDAO();
        boolean check = dao.checkLogin(username, password);

        if(check){
            resp.sendRedirect("addproduct.jsp");
        }
        else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert('The credential is invalid!'); window.location = 'index.jsp';");
            out.println("</script>");
        }
    }
}