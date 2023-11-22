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
                 <h3>Cadastre-se</h3>
        <form action="/UserServlet" method="POST" class='register-form'>
            <label>Nome:</label>
            <input type="text" class="register-name">
            <label>Sobrenome:</label>
            <input type="text" class="register-lastname">
             <label>E-mail:</label>
            <input type="text" class="register-email">
            <label>Senha:</label>
            <input type="text" class="register-password">
            <button id="btn-register" type="submit">Sign Up</button>
            <p style="font-size: 10px;">J� possui uma conta? <a href="login.jsp">Log In</a></p>
        </form>
    </section>
</body>
</html>