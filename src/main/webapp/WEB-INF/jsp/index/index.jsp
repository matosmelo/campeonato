<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Campenota</title>
	</head>
	<body>
		<h1>Bem vindo ao Campeonato</h1>
		<div><a href="<c:url value="/minhaConta"/>">Minha conta</a></div>
		<div><a href="<c:url value="/selecionaCompeticao"/>">Nova competição</a></div>
		<div><a href="<c:url value="/competicoesAntigas"/>">Competições antigas</a></div>
		logado: ${usuarioWeb.nome }
	</body>
</html>