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
	
	Cadastro de Usuarios <br /><br />
	
	<form action="adicionaCatalogo" method="post">
				<label for="repeticoes">Repeti��es</label>  
				<input type="text" name="repeticoes" value="${exercicio.repeticoes}" >
				<form:errors path="exercicio.repeticoes" cssStyle="color:#B71C1C"/><br />
	
				<label for="idExerciciosDias">Dias</label>  
				<input type="text" name="idExerciciosDias" value="${exercicio.idExerciciosDias}" >
				<form:errors path="exercicio.idExerciciosDias" cssStyle="color:#B71C1C"/><br />
				
				<label for="idExerciciosCatalogo">Exercicio</label>  
				<input type="text" name="idExerciciosCatalogo" value="${exercicio.idExerciciosCatalogo}" >
				<form:errors path="exercicio.idExerciciosCatalogo" cssStyle="color:#B71C1C"/><br />
		
				<input type="submit" value="Criar">
		
	</form>
</body>
</html>