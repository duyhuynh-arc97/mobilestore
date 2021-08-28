package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.DBConnection;


@WebServlet("/add")
@MultipartConfig(maxFileSize = 16177215)  
public class AddPrdtServlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        resp.setContentType("text/html;charset=UTF-8");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String instock = req.getParameter("instock");
        String desc = req.getParameter("desc");
        String mnf = req.getParameter("mnf");
        String ctg = req.getParameter("ctg");
        String cdt = req.getParameter("cdt");
        InputStream inputStream = null;
        Part filePart = req.getPart("image");

        if(filePart != null) {
            inputStream = filePart.getInputStream();
        }
        
        DBConnection db = new DBConnection();
        Connection connection = db.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into product(name, unitprice, instock, description, manufacturer_id, category_id, condition_id, image) values(?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, name);
            stmt.setInt(2, Integer.parseInt(price));
            stmt.setInt(3, Integer.parseInt(instock));
            stmt.setString(4, desc);

            if(mnf.equals("sam")){
                stmt.setInt(5, 1);
            }
            if(mnf.equals("iph")){
                stmt.setInt(5, 2);
            }
            if(mnf.equals("opp")){
                stmt.setInt(5, 3);
            }
            if(mnf.equals("asu")){
                stmt.setInt(5, 4);
            }
            if(mnf.equals("xia")){
                stmt.setInt(5, 5);
            }

            if(ctg.equals("sam")){
                stmt.setInt(6, 1);
            }
            if(ctg.equals("iph")){
                stmt.setInt(6, 2);
            }
            if(ctg.equals("opp")){
                stmt.setInt(6, 3);
            }
            if(ctg.equals("asu")){
                stmt.setInt(6, 4);
            }
            if(ctg.equals("xia")){
                stmt.setInt(6, 5);
            }

            if(cdt.equals("new")){
                stmt.setInt(7, 1);
            }
            if(cdt.equals("old")){
                stmt.setInt(7, 2);
            }
            if(cdt.equals("rfb")){
                stmt.setInt(7, 3);
            }
            
            if(inputStream != null) {
                stmt.setBinaryStream(8, inputStream);
            }
            int i = stmt.executeUpdate();
            if(i>0){
                resp.getWriter().println("<html><body><script>alert('Upload successfully!'); window.location = 'addproduct.jsp';</script></body></html>");
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
