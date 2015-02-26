<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Edita jogo</title>
	</head>
	
	<body>
		<form action="<c:url value="/salvaJogoTodosContraTodos"/>" method="post">
			<input id="id" type="hidden" name="jogo.id" value="${jogo.id }" />
			<input id="mandante" type="hidden" name="jogo.mandante.id" value="${jogo.mandante.id}">${jogo.mandante.login}
			<input id="golsMandante" type="text" name="jogo.golsMandante" value="${jogo.golsMandante }" />
			X
			<input id="golsVisitante" type="text" name="jogo.golsVisitante" value="${jogo.golsVisitante }" />
			<input id="visitante" type="hidden" name="jogo.visitante.id" value="${jogo.visitante.id}">${jogo.visitante.login}
			<input id="tipoDeCompeticao" type="hidden" name="jogo.tipoDeCompeticao" value="${jogo.tipoDeCompeticao }"/>
			<input id="nomeDaCompeticao" type="hidden" name="jogo.nomeDaCompeticao" value="${jogo.nomeDaCompeticao }"/>
			
			<button type="submit" name="_method" value="put">Salvar</button>
		</form>
	</body>
</html>