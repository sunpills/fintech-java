<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="fintech.css">
<title>DinDinGo - Fintech</title>
</head>
<body>
	<nav><%@ include file="nav.jsp" %></nav>
	 <section class="container-login">
        <h1>DinDinGo</h1>
                <h2>Seu guia de economia</h2>
                 <h3>Entre com seu login :)</h3>
        <form action="/dindingo/LoginServlet" method="POST" class='login-form'>
            <label>E-mail:</label>
            <input type="text" class="login-email">
            <label>Senha:</label>
            <input type="text" class="login-password">
            <button id="btn-login" type="submit">Log In</button>
            <p style="font-size: 10px;">Não possui conta ainda? <a href="register.jsp">Sign Up</a></p>
        </form>
    </section>
</body>
</html>