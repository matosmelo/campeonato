<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Todos contra todos</title>
	</head>
	<body>
		<c:forEach items="${usuarioList }" var="amigo">
			<div>${amigo.nome }</div>
		</c:forEach>
		<form action="<c:url value="/criaJogo" />" method="post">
			<input type="text" name="jogo.nomeDaCompeticao" value="${jogo.nomeDaCompeticao}">
			<button type="submit">Criar jogos</button>
		</form>
	</body>
</html>