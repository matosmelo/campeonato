<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Usuarios</title>
	</head>
	
	<body>
		<c:forEach items="${usuarioList }" var="usuario">
			<div>Nome: ${usuario.nome }</div>
			<div>Login: ${usuario.login }</div>
			<div>ID: ${usuario.id }</div>
			<div>
				<form action="<c:url value="/removeUsuario/${usuario.id }"/>" method="post">
					<button name="_method" value="delete">Remove</button>
				</form>
			</div>
			
			<div>
				<a href="<c:url value="/editaUsuario/${usuario.id }"/>">Edita</a>
			</div>
			
			<div>
				<a href="<c:url value="/novoAmigo/${usuario.id }"/>">Adiciona amigo</a>
			</div>
			
			<br>
		</c:forEach>
		
		<a href="<c:url value="/criaJogo" />">Cria Jogo</a>
	</body>
</html>