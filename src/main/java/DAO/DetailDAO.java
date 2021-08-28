package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;

import model.Product;

public class DetailDAO {
    static Connection connection = null;
    static Statement statement = null;
    ResultSet rs = null;
    Product p = null;

    public Product getDetail(String pname){
        try {
            DBConnection db = new DBConnection();
            connection = db.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery( "select*from product where name='"+pname+"'");
            if(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int unitprice = rs.getInt(3);
                int instock = rs.getInt(4);
                String desc = rs.getString(5);
                int manufacturer_id = rs.getInt(6);
                int category_id = rs.getInt(7);
                int condition_id = rs.getInt(8);
                byte[] i = rs.getBytes(9);
                String image = Base64.getEncoder().encodeToString(i);
                p = new Product(id, name, unitprice, instock, desc, manufacturer_id, category_id, condition_id, image);
             }
             rs.close();
             statement.close();
             connection.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
        return p;
    }
}
