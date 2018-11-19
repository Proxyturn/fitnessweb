<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema Cadastro</title>
</head>
<body>
<c:import url="/WEB-INF/views/principal/menu.jsp"/>
	<br />
	<a href="novoTreino">Cadastrar novo treino</a>
	<br />
	<br />
	<table>
		<tr>
			<th>Id</th>
			<th>Identificacao</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${treinos}" var="treino">
			<tr>
				<td>${treino.id}</td>
				<td>${treino.idTreinoUsuario}</td>
				<td>${treino.identificacao}</td>
				<td><fmt:formatDate value="${usuario.dataInicio.time}" pattern="dd/MM/yyyy" /></td>
				<td><fmt:formatDate value="${usuario.dataFim.time}" pattern="dd/MM/yyyy" /></td>
				<td><a href="mostraTreino?id=${treino.id}" title="Editar">Editar</a></td>
				<td><a href="removeTreino?id=${treino.id}" title="Excluir">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>