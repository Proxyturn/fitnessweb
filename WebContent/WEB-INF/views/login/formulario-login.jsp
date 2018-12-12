<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Sistema Cadastro</title>
	<link  href="/fitnessweb/resources/css/style/style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<main class="content">
		<div class="login">
			<div class="logo"></div>
			<br/><br/><br/><br/>
			<h3 class="title">Login</h3>
			<form action="efetuaLogin" method="post">
				<label>Login:</label><br />
				<input id="inputscale" placeholder="Usuário" name="login"> <br/>
				<label>Senha:</label><br />
				<input name="senha" id="inputscale" placeholder="Senha" type="password" value=""><br/><br/>
				<input type="submit" value="Entrar">
			</form>
		<br />
		<a class="link" href="novoUsuario">Criar Usuário</a>
		<br /><br />
		</div>
	</main>
	<footer class="container-fluid text-center"> </footer>
</body>
</html> 