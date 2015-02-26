<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>X1</title>
	</head>
	
	<body>
		<div>
			<c:forEach items="${jogoList }" var="jogo">
				<div> 
					${jogo.mandante.login}
					${jogo.golsMandante}
					x
					${jogo.golsVisitante}
					${jogo.visitante.login}
					${jogo.tipoDeCompeticao}
					${jogo.nomeDaCompeticao}
				</div>
				<br>
			</c:forEach>
		</div>
	</body>
</html>