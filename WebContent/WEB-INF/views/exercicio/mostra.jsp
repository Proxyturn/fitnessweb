<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema Cadastro</title>
</head>
<body>
	<c:import url="/WEB-INF/views/principal/menu.jsp"/>
	<br />
	Alterar exercicio: ${exercicio.id}	
	<br />
	<br />
	
	<form action="alteraExercicio" method="post" class="form-horizontal">
	
	<input type="hidden" name="id" value="${exercicio.id}" />
				
		<label for="Repeticoes">Repetições</label>  
		<input type="text" name="repeticoes" value="${exercicio.repeticoes}" >
		<form:errors path="exercicio.repeticoes" cssStyle="color:#B71C1C"/><br />
	
		<label for="IdExerciciosDias">ID do Dia</label>  
		<input type="text" name="idExerciciosDias" value="${exercicio.idExerciciosDias}" >
		<form:errors path="exercicio.idExerciciosDias" cssStyle="color:#B71C1C"/><br />
		
		<label for="IdExerciciosCatalogos">Exercício  </label>  
		<input type="text" name="idExerciciosCatalogos" value="${exercicio.idExerciciosCatalogos}" >
		<form:errors path="exercicio.idExerciciosCatalogos" cssStyle="color:#B71C1C"/><br />
	
	<input type="submit" value="Alterar">
	
	</form>
	
</body>
</html>