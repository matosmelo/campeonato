<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Jogos Da competicao</title>
	</head>
	<body>
		Competicao: ${jogo.competicao }
		<c:forEach items="${jogoList}" var="jogoDaCompeticao">
			<div>Id do jogo: ${jogoDaCompeticao.id }</div>
			<div>Tipo de Competicao: ${jogoDaCompeticao.tipoDeCompeticao}</div>
		</c:forEach>
	</body>
</html>