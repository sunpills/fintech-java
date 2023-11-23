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
                <h2>Adicionar <strong>ganho</strong></h2>
        <form action="/dindingo/BalanceServlet" method="POST" class='expense-form'>
            <label>Quantia:</label>
            <input type="text" class="register-expense">
            <label>Categoria:</label>
            <input type="text" class="register-expense-category">
            <label>Data:</label>
            <input type="text" class="register-expense-date">
            <button id="btn-register" type="submit">Adicionar</button>
        </form>
    </section>
</body>
</html>