<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.CartItem"%>
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
    <link rel="stylesheet" href="css/cart.css">
    <title>Cart</title>
</head>

<body style="font-family: Arial, Helvetica, sans-serif;">
    <div class="header">
        <label id="l1" style="font-size: 50px;">Cart</label><br>
        <label>All the selected products in your cart</label>
    </div>
    <div class="container">
        <form action="clear" method="POST">
            <button id="clearbtn" type="submit"><i class="fas fa-times-circle"></i> Clear cart</button>
            <button id="checkoutbtn"><i class="fas fa-shopping-cart"></i> Check out</button>
        </form>
        <table style="width: 100%;">
            <thead>
                <th>Product</th>
                <th>Quantity</th>
                <th>Unit price</th>
                <th>Price</th>
                <th>Action</th>
            </thead>
            <tbody class="item">
                <%
                    List<CartItem> list = (ArrayList<CartItem>)request.getSession().getAttribute("cartitems");
                    int sum = 0;
                    if(list != null){
                        for(CartItem c:list){%>
                            <tr>
                                <td class="name"><%=c.getProductname()%></td>
                                <td class="quantity"><%=c.getQuantity()%></td>
                                <td class="unitprice"><%=c.getUnitprice()%></td>
                                <td class="price"><%=c.getTotal()%></td>
                                <td><form action="remove?name=<%=c.getProductname()%>" method="POST"><button class="removebtn" type="submit"><i class="fas fa-times"></i> Remove</button></form></td>
                            </tr>
                            <%
                            sum+=c.getTotal();
                        }
                    }
                %>
            </tbody>
            <tr>
                <td></td>
                <td></td>
                <th>Grand Total</th>
                <th id="total"><%=sum%></th>
                <td></td>
            </tr>
        </table>
        <form action="home.jsp"><button id=backbtn type="submit"><i class="fas fa-arrow-circle-left"></i> Continue shopping</button></form>
    </div>
</body>

</html>