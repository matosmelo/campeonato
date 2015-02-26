<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Edita Usuario</title>
	</head>
	
	<body>
		<form action="<c:url value="/salvaUsuario"/>" method="post">
			<input id="id" type="hidden" name="usuario.id" value="${usuario.id }"/>
			<div>Nome:<input id="nome" type="text" name="usuario.nome" value="${usuario.nome }"/> </div>
			<div>Login:<input id="login" type="text" name="usuario.login" value="${usuario.login }"/> </div>
			<div>Senha:<input id="senha" type="text" name="usuario.senha" value="${usuario.senha }"/> </div>
			
			<button type="submit" name="_method" value="put">Salvar</button>
		</form>
	</body>
</html>