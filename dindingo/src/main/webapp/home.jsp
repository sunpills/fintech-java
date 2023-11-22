<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Date"%>
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
	 <h2 style="text-align: left; padding-top: 2rem; padding-left: 80px;">Olá, ###. O que vai ser hoje? :)</h2>	
	<div class="container-blocks" style="display: grid;justify-content: center;">
	<section class="container-login" style="background: black;">
    <div>Quero registrar meus <strong>Ganhos <img src="plus.png"/> </strong>
    </div>
    <p><img src="cash.png"/> Ganhos Totais:</p>
    <p style="font-size: 10px;">Data: <%=new Date()%></p>
  	</section>
	<section class="container-login" style="background: black;">
    <div>Quero registrar meus <strong>Gastos <img src="plus.png"/> </strong>
    </div>
    <p><img src="cash.png"/> Gastos Totais:</p>
    <p style="font-size: 10px;">Data: <%=new Date()%></p>
  	</section>
  	</div>
</body>
</html>