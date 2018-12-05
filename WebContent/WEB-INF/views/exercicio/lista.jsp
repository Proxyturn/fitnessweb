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
	<a href="novoExercicio?id=${dia.id}">Cadastrar novo exercicios</a>
	<br />
	<br />
	<table border="1">
		<tr>
			<th>ID do Dia</th>
			<th>Repetições</th>
			<th>Exercícios</th>
		</tr>
		<c:forEach items="${exercicios}" var="exercicio">
			<c:if test="${exercicio.idExerciciosDias == dia.id}">
				<tr>
					<td>${exercicio.id}</td>
					<td>${exercicio.repeticoes}</td>
					<td>
						<c:forEach items="${catalogos}" var="catalogo">
							<c:if test="${exercicio.idExerciciosCatalogos == catalogo.id}">
								${catalogo.identificacao}
							</c:if>
						</c:forEach>
					</td>
					<td><a href="mostraExercicio?id=${exercicio.id}" title="Editar">Editar</a></td>
					<td><a href="removeExercicio?id=${exercicio.id}" title="Excluir">Excluir</a></td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>