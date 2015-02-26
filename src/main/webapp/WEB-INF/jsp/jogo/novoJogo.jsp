<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Novo Jogo</title>
	</head>
	
	<body>
		<div>
			<form action="<c:url value="/adicionaJogo"/>" method="post">
				<div>
					<input type="hidden" name="jogo.mandante.id" value="${usuarioWeb.id }">${usuarioWeb.nome }
					<input type="text" name="jogo.golsMandante" >
					x
					<input type="text" name="jogo.golsVisitante" >
					<select name="jogo.visitante.id"> 
						<c:forEach items="${usuarioList}" var="usuario">
							<option value="${usuario.id}">${usuario.login}</option>							
						</c:forEach>
					</select>
				</div>
				<input type="hidden" name="jogo.tipoDeCompeticao" value="2"/>
				<button type="submit">Enviar</button>
			</form>
		</div>
	</body>
</html>