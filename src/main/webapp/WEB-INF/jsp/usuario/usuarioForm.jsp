<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>login</title>
	</head>
	
	<body>
		<form action="<c:url value="/login"/>" method="POST">
			<fieldset>
				<div>Login: </div>
				<div><input id="login" type="text" name="usuario.login" /></div>
				<div>Senha: </div>
				<div><input id="senha" type="password" name="usuario.senha" /></div>	
				<button type="submit">Login</button>	
				
				<a href="<c:url value="/novoUsuario"/>">Novo usuario</a>
			</fieldset>
		</form>
	</body>
</html>