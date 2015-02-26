<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lista Jogo</title>
	</head>
	
	<body>
		<c:forEach items="${jogoList }" var="jogo">
			<div> 
				${jogo.mandante.login}
				${jogo.golsMandante}
				x
				${jogo.golsVisitante}
				${jogo.visitante.login}
			</div>
			
			<div>
				<form action="<c:url value="/removeJogo/${jogo.id}"/>" method="post">
					<button name="_method" value="delete">Remove</button>
				</form>
			</div>
			
			<div>
				<a href="<c:url value="/editaJogo/${jogo.id }"/>">Edita</a>
			</div>
			
			<br>
		</c:forEach>
		
		<div>
			<a href="<c:url value="/classificacaoTodosContraTodos"/>">Tabela</a>
		</div>
	</body>
</html>