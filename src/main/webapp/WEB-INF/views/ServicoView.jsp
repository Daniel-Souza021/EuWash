<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servicos</title>
</head>
<body>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<c:if test="${listaServico.size() > 0}">
			<table border="2" width="70%" cellpadding="2">
				<tr>
					<th>Descrição</th>
					<th>Preço</th>
					<th>Categoria</th>
					<th>Edit</th>
					<th>Delete</th>	
				</tr>
				<c:forEach var="s" items="${listaServico}">
					<tr>
						<td>${s.descricao}</td>
						<td>${s.preco}</td>
						<td>${s.categoria}</td>
						<td><a href="/EuWash/servicoEdit/${s.id}">Edit</a></td>
						<td><a href="/EuWash/servicoDelete/${s.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
				<form action="/EuWash/servicoSave" method="POST" modelAttribute="servico">
					<form:hidden path="servico.id" />
					<p>
						Descrição:
						<form:input path="servico.descricao" />

					</p>

					<p>
						Preço:
						<form:input path="servico.preco" />

					</p>
					<p>
						Categoria:
						<form:input path="servico.categoria" />

					</p>
					
					<input type="submit" value="Salvar" />

				</form>
			</div>


		<a href="/EuWash"> voltar</a>
</body>
</html>