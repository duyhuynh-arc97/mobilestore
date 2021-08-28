<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/details.css">
    <script src="https://kit.fontawesome.com/117f86ddac.js" crossorigin="anonymous"></script>
    <link rel="shortcut icon" href="image/iphone.png">
    <title>Details</title>
</head>

<body style="font-family: Arial, Helvetica, sans-serif;">
    <div class="header">
        <label id="l1" style="font-size: 50px;">Products</label><br>
    </div>
        <div class="container">
            <%
                Product a = (Product)request.getAttribute("data");  
                String ctg = null;
                String mnf = null;

                if(a.getCtg_id()==1){
                    ctg="samsung";
                }
                if(a.getCtg_id()==2){
                    ctg="iphone";
                }
                if(a.getCtg_id()==3){
                    ctg="oppo";
                }
                if(a.getCtg_id()==4){
                    ctg="asus";
                }
                if(a.getCtg_id()==5){
                    ctg="xiaomi";
                }

                if(a.getManu_id()==1){
                    mnf="Samsung";
                }
                if(a.getManu_id()==2){
                    mnf="Iphone";
                }
                if(a.getManu_id()==3){
                    mnf="Oppo";
                }
                if(a.getManu_id()==4){
                    mnf="Asus";
                }
                if(a.getManu_id()==5){
                    mnf="Xiaomi";
                }
            %>
                <img id="image" src="data:image/jpeg;base64,<%=a.getImage()%>">
                <div class="info">
                    <p id="name" style="font-size: 25px; font-weight: bold;">
                        <%=a.getName()%>
                    </p>
                    <p id="desc">
                        <%=a.getDesc()%>
                    </p>
                    <p id="manufact"><b>Manufacturer: </b>
                        <%=mnf%>
                    </p>
                    <p id="category"><b>Category: </b>
                        <a style="color: rgb(25, 103, 248);">
                            <%=ctg%>
                        </a>
                    </p>
                    <p id="stock"><b>Available units in stock: </b>
                        <%=a.getInstock()%>
                    </p>
                    <p id="price" style="font-size: 25px;">
                        <%=a.getUnitprice()%> USD</p>
                    <%   
                
                    %>
                        <div style="margin-top: 10px; margin-bottom: 10px; display: flex;">
                            <form action="home.jsp"><button id="backbtn" type="submit"><i class="fas fa-arrow-circle-left"></i> Back</button></form>
                            <form action="order?pname=<%=a.getName()%>" method="POST"><button id="orderbtn" type="submit" style="margin-left: 5px;"><i class="fas fa-shopping-cart"></i> Order Now</button></form>
                        </div>
                </div>
        </div>
    <script src="script/details.js"></script>
</body>

</html>