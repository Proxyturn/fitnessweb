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
	Alterar dia: ${dia.id}	
	<br />
	<br />
	
	<form action="alteraDia?id=${dia.idDiasTreino}" method="post" class="form-horizontal">
	
	<input type="hidden" name="id" value="${dia.id}" />
				
		<label for="Identificacao">Identificação</label>  
		<input type="text" name="identificacao" value="${dia.identificacao}" >
		<form:errors path="dia.identificacao" cssStyle="color:#B71C1C"/><br />
	
		<input type="hidden" name="idDiasTreino" value="${dia.idDiasTreino}" >
		<form:errors path="dia.idDiasTreino" cssStyle="color:#B71C1C"/><br />
	
	<input type="submit" value="Alterar">
	
	</form>
	
</body>
</html>