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
	Alterar treino: ${treino.id}	
	<br />
	<br />
	
	<form action="alteraCatalogo" method="post" class="form-horizontal">
	
				<input type="hidden" name="id" value="${treino.id}" />
				
				<label for="Identificacao">Identificação</label>
				<input type="text" name="identificacao" value="${treino.identificacao}" >
				<form:errors path="treino.identificacao" cssStyle="color:#B71C1C"/><br />
				
				<label for="Status">Status</label>
				<input type="text" name="status" value="${treino.status}" >
				<form:errors path="treino.status" cssStyle="color:#B71C1C"/><br />
				
				<label for="DataInicio">Data de Inicio</label>
				<input type="text" name="dataInicio" value="<fmt:formatDate value="${treino.dataInicio.time}" pattern="dd/MM/yyyy" />" >
				<form:errors path="treino.dataInicio" cssStyle="color:#B71C1C"/><br />
				
				<label for="DataFim">Data Fim</label>
				<input type="text" name="dataFim" value="<fmt:formatDate value="${treino.dataFim.time}" pattern="dd/MM/yyyy" />">
				<form:errors path="treino.dataFim" cssStyle="color:#B71C1C"/><br />
				
	
	<input type="submit" value="Alterar">
	
	</form>
	
</body>
</html>