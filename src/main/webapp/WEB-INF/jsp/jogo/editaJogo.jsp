<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Edita jogo</title>
	</head>

	<body>
		<form action="<c:url value="/salvaJogo"/>" method="post">
			<input id="id" type="hidden" name="jogo.id" value="${jogo.id }" />
				<select name="jogo.mandante.id">
					<c:forEach items="${usuarios}" var="usuario">
						<c:if test="${jogo.mandante.id == usuario.id }">
							<option selected="selected" value="${usuario.id }">${usuario.login}</option>
						</c:if>
						
						<c:if test="${jogo.mandante.id != usuario.id }">
							<option value="${usuario.id }">${usuario.login}</option>
						</c:if>
					</c:forEach>
				</select>
				
				<input id="golsMandante" type="text" name="jogo.golsMandante" value="${jogo.golsMandante }" />
				X
				<input id="golsVisitante" type="text" name="jogo.golsVisitante" value="${jogo.golsVisitante }" />
				
				<select name="jogo.visitante.id">
				<c:forEach items="${usuarios}" var="usuario">
					<c:if test="${jogo.visitante.id == usuario.id }">
						<option selected="selected" value="${usuario.id }">${usuario.login}</option>
					</c:if>
					
					<c:if test="${jogo.visitante.id != usuario.id }">
							<option value="${usuario.id }">${usuario.login}</option>
						</c:if>
				</c:forEach>
			</select>
			
			<input id="tipoDeCompeticao" type="text" name="jogo.tipoDeCompeticao" value="${jogo.tipoDeCompeticao }"/>
			<input id="nomeDaCompeticao" type="text" name="jogo.nomeDaCompeticao" value="${jogo.nomeDaCompeticao }"/>
			
			<button type="submit" name="_method" value="put">Salvar</button>
		</form>
	</body>
</html>