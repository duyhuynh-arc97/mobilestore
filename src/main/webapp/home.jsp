<%@page import="java.util.List"%>
<%@page import="DAO.ProductDAO"%>
<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="image/iphone.png">
    <script src="https://kit.fontawesome.com/117f86ddac.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/home.css">
    <title>Home</title>
</head>

<body style="font-family: Arial, Helvetica, sans-serif;">
    <form action="cart.jsp">
        <div class="header">
            <label id="l1" style="font-size: 50px;">Products</label><br>
            <label>All the available products in our store</label>
            <button id="cart" type="submit"><i class="fas fa-shopping-cart"></i> View cart</button>
        </div>
    </form>

    <div class="container">

        <%
            ProductDAO dao = new ProductDAO();
            List<Product> list = dao.getProduct();
            for(Product p: list){
            %>
            <div class="prdt_tag">
                <div class="name">
                    <%=p.getName()%>
                </div>
                <div><img class="image" style="max-width: 100%; max-height: 250px; margin-top: 10px; margin-bottom: 10px;" src="data:image/jpeg;base64,<%=p.getImage()%>"></div>
                <div class="desc">
                    <%=p.getDesc()%>
                </div>
                <div class="price">
                    <%=p.getUnitprice()%> USD</div>
                <div class="stock">
                    <%=p.getInstock()%> units in stock</div>
                <div class="button" style="margin-top: 10px; margin-bottom: 10px; display: flex;">
                    <div>
                        <form action="details?pname=<%=p.getName()%>" method="POST"><button class="detailbtn" type="submit"><i class="fas fa-info-circle"></i> Details</button></form>
                    </div>
                    <div>
                        <form action="order?pname=<%=p.getName()%>" method="POST"><button class="orderbtn" type="submit" style="margin-left: 5px;"><i class="fas fa-shopping-cart"></i> Order Now</button></form>
                    </div>
                </div>
            </div>
            <%}
        %>
    </div>
</body>

</html>