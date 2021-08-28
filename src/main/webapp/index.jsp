<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="css/login.css">
            <link rel="icon" href="image/iphone.png" type="image/png">
            <title>Login</title>
        </head>

        <body style="font-family: Arial, Helvetica, sans-serif;">
            <div class="header">
                <label id="banner" style="font-size: 50px;">Mobile Store</label>
            </div>
            <div class="center">
                <div id="title">Please sign in</div>
                <form action="validate" method="POST">
                    <input name="username" type="text" placeholder="Username" required>
                    <input name="password" type="password" placeholder="Password" required>
                    <button id="btn" type="submit">Login</button>
                </form>
            </div>
        </body>

        </html>