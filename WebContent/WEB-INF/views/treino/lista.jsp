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


		<c:forEach items="${usuarios}" var="usuario">
		 	<c:if test="${usuario.login == usuarioLogado.login}">
 					<c:set var="idUsuario" value="${usuario.id}"></c:set>
 			</c:if>
		</c:forEach>
 
 
	<br />
	<a href="novoTreino?id=${idUsuario}">Cadastrar novo treino</a>
	<br />
	<br />
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Id Usuario</th>
			<th>Identificacao</th>
			<th>Status</th>
			<th>Data de Inicio</th>
			<th>Data Fim</th>
			<th></th>
			<th></th>
			<th></th>
		
		</tr>
		<c:forEach items="${treinos}" var="treino">
				<c:if test="${idUsuario == treino.idTreinoUsuario}">
					<tr <c:if test="${treino.status == 0}">style="background: #C0C0C0;"</c:if> >
						<td>${treino.id}</td>
						<td>${treino.idTreinoUsuario}</td>
						<td>${treino.identificacao}</td>
						<td>
						<c:if test="${treino.status == 1}">
						<a href="ativaTreino?id=${treino.id}&status=0" title="Desativar">Desativar</a>
						</c:if>
						<c:if test="${treino.status == 0}">
						<a href="ativaTreino?id=${treino.id}&status=1" title="Ativar">Ativar</a>
						</c:if>
						</td>
						<td><fmt:formatDate value="${treino.dataInicio.time}" pattern="dd/MM/yyyy" /></td>
						<td><fmt:formatDate value="${treino.dataFim.time}" pattern="dd/MM/yyyy" /></td>
						<td><a href="listaDias?id=${treino.id}" title="Inserir Dias">Inserir Dias</a></td>
						<td><a href="mostraTreino?id=${treino.id}" title="Editar">Editar</a></td>
						<td><a href="removeTreino?id=${treino.id}" title="Excluir">Excluir</a></td>
					</tr>
				</c:if>
		</c:forEach>
	</table>
</body>
</html>