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
<br />
	<main class="content">
		<div class="login">
			<h2 class="title">Registro de Usuário</h2> <br /><br />
			
			<form action="adicionaUsuario" method="post">
						<label class="title" for="Nome">Nome</label> <br/> 
						<input id="inputscale" type="text" name="nome" value="${usuario.nome}" >
						<form:errors path="usuario.nome" cssStyle="color:#B71C1C"/><br />
						<br/> 
						<label class="title" for="Login">Login</label>  <br/> 
						<input id="inputscale" type="text" name="login" value="${usuario.login}" >
						<form:errors path="usuario.login" cssStyle="color:#B71C1C"/><br />
						<br/> 
						<label class="title" for="Senha">Senha</label>  <br/> 
						<input id="inputscale" type="password" name="senha" value="${usuario.senha}">
						<form:errors path="usuario.senha" cssStyle="color:#B71C1C"/><br />
						<br/> 
						<label class="title" for="DataNascimento">Data Nascimento</label>  <br/> 
						<input id="inputscale" type="text" name="dataNascimento" value ="<fmt:formatDate value="${dataNascimento}" pattern="dd/MM/yyyy" />">
						<form:errors path="usuario.dataNascimento" cssStyle="color:#B71C1C"/><br />
						<br/> 
						<label class="title" for="Altura">Altura</label>  <br/> 
						<input id="inputscale" type="text" name="altura" value="${usuario.altura}" >
						<form:errors path="usuario.altura" cssStyle="color:#B71C1C"/><br />
						<br/> <br/> 
						<input type="submit" value="Criar">
				
			</form>
		</div>
	</main>
</body>
</html>