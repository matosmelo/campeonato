<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Minha conta</title>
	</head>
	
	<body>
		<div>Nome: ${usuario.nome }</div>
		<div>Login: ${usuario.login }</div>
		<div>Senha: ${usuario.senha }</div>
		<div><a href="<c:url value="/editaUsuario/${usuario.id }"/>">Edita</a></div>
		
		Amigos: 
		<div>
			<c:forEach items="${usuario.amigos}" var="amigo">
				<div>${amigo.nome }</div>
			</c:forEach>
		</div>
		
		<div><a href="<c:url value="/novoAmigo/${usuario.id }"/>">Adiciona amigo</a></div>
	</body>
</html>