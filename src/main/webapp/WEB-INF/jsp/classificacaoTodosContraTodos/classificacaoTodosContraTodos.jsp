<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Classificacao todos contra todos</title>
	</head>

	<body>
	<h1>${nomeDaCompeticao}</h1>
	
		<table border="2">
			<tr>
				<td>Posicao</td>
				<td>Nome</td>
				<td>Pontos</td>
				<td>Jogos</td>
				<td>Vitorias</td>
				<td>Empates</td>
				<td>Derrotas</td>
				<td>GolsPor</td>
				<td>GolsContra</td>
				<td>Saldo</td>
			</tr>
			<c:forEach items="${classificacaoList }" var="classificacao" varStatus="posicao">
				<tr>
					<td>${posicao.count }</td>
					<td>${classificacao.usuario.nome }</td>
					<td>${classificacao.pontos }</td>
					<td>${classificacao.jogos }</td>
					<td>${classificacao.vitorias }</td>
					<td>${classificacao.empates }</td>
					<td>${classificacao.derrotas }</td>
					<td>${classificacao.golsPro }</td>
					<td>${classificacao.golsContra }</td>
					<td>${classificacao.saldoDeGols }</td>
				</tr>
			</c:forEach>		
		</table>
		
		<c:forEach items="${jogoList }" var="jogo">
			<div> 
				${jogo.mandante.login}
				${jogo.golsMandante}
				x
				${jogo.golsVisitante}
				${jogo.visitante.login}
				<a href="<c:url value="/editaJogoTodosContraTodos/${jogo.id }"/>">Edita</a>
			</div>
			<br>
		</c:forEach>
	</body>
</html>