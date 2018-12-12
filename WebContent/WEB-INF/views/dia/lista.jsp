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
	<div class="botao-treino">
	<a class="btn" href="novoDia?id=${treino.id}">Cadastrar novo dia</a>
	</div>
	<br />
	<br />
	<table class="tabela-principal" border="1">
		<tr>
			<th>Id</th>
			<th>Identificacao</th>
			<th>idDiasTreino</th>
		</tr>
		<c:forEach items="${dias}" var="dia">
			<c:if test="${dia.idDiasTreino == treino.id}">
				<tr>
					<td>${dia.id}</td>
					<td>${dia.identificacao}</td>
					<td>${dia.idDiasTreino}</td>
					<td><a class="botao-tabela" href="listaExercicios?id=${dia.id}" title="Inserir Exercícios">Inserir Exercícios</a></td>
					<td><a class="botao-tabela" href="mostraDia?id=${dia.id}" title="Editar">Editar</a></td>
					<td><a class="botao-tabela" href="removeDia?id=${dia.id}&idTreino=${dia.idDiasTreino}" title="Excluir">Excluir</a></td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>