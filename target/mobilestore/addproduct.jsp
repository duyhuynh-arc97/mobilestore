<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="shortcut icon" href="image/iphone.png">
            <link rel="stylesheet" href="css/addprdt.css">
            <title>Add products</title>
        </head>

        <body style="font-family: Arial, Helvetica, sans-serif;">
            <form action="index.jsp">
                <div class="header">
                    <label id="l1" style="font-size: 50px;">Products</label><br>
                    <label>Add products</label>
                    <button id="logout" type="submit">Logout</button>
                </div>
            </form>
            <form action="add" method="POST" enctype="multipart/form-data">
                <div class="container">
                    <label id="l2">Add new products</label>
                    <hr>
                    <table>
                        <tr>
                            <td class="title">Product Name</td>
                            <td><input class="input" type="text" name="name"></td>
                        </tr>
                        <tr>
                            <td class="title">Unit Price</td>
                            <td><input class="input" type="number" name="price"></td>
                        </tr>
                        <tr>
                            <td class="title">Units in Stock</td>
                            <td><input class="input" type="number" placeholder="0" name="instock"></td>
                        </tr>
                        <tr>
                            <td class="title">Description</td>
                            <td><textarea class="input" cols="30" rows="3" style="height: 60px;" name="desc"></textarea></td>
                        </tr>
                        <tr>
                            <td class="title">Manufacturer</td>
                            <td>
                                <select class="input" name="mnf">
                                    <option value="sam">Samsung</option>
                                    <option value="iph">Iphone</option>
                                    <option value="opp">Oppo</option>
                                    <option value="asu">Asus</option>
                                    <option value="xia">Xiaomi</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="title">Category</td>
                            <td>
                                <select class="input" name="ctg">
                                    <option value="sam">samsung</option>
                                    <option value="iph">iphone</option>
                                    <option value="opp">oppo</option>
                                    <option value="asu">asus</option>
                                    <option value="xia">xiaomi</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="title">Condition</td>
                            <td>
                                <div class="input">
                                    <input name="cdt" type="radio" value="new"><label>New</label>
                                    <input name="cdt" type="radio" value="old"><label>Old</label>
                                    <input name="cdt" type="radio" value="rfb"><label>Refurbished</label>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="title">Product Image File</td>
                            <td>
                                <div class="input">
                                    <input type="file" required name="image">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><button id="btn" type="submit">Add Product</button></td>
                        </tr>
                    </table>
                </div>
            </form>
        </body>

        </html>