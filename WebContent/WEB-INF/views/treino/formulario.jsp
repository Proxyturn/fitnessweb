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
	
	<form action="adicionaTreino" method="post">
				<label for="Identificacao">Identificação</label>  
				<input type="text" name="identificacao" value="${treino.identificacao}" >
				<form:errors path="treino.identificacao" cssStyle="color:#B71C1C"/><br />
		
				<input type="submit" value="Criar">
		
	</form>
</body>
</html>