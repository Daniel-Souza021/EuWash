<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clientes</title>
</head>
<body>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<c:if test="${listaCliente.size() > 0}">
			<table border="2" width="70%" cellpadding="2">
				<tr>
					<th>Nome</th>
					<th>Sobrenome</th>
					<th>Telefone</th>
					<th>Data Nascimento</th>	
					<th>Edit</th>
					<th>Delete</th>	
				</tr>
				<c:forEach var="c" items="${listaCliente}">
					<tr>
						<td>${c.nome}</td>
						<td>${c.sobrenome}</td>
						<td>${c.telefone}</td>
						<td>${c.dataNasc}</td>
						<td><a href="clienteEdit/${c.id}">Edit</a></td>
						<td><a href="clienteDelete/${c.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
				<form action="/EuWash/clienteSave" method="POST" modelAttribute="cliente">
					<form:hidden path="cliente.id" />
					<p>
						Nome:
						<form:input path="cliente.nome" />

					</p>

					<p>
						Sobrenome:
						<form:input path="cliente.sobrenome" />

					</p>
					<p>
						Telefone:
						<form:input path="cliente.telefone" />

					</p>
					<p>
						Data Nascimento:
						<form:input path="cliente.dataNasc" />

					</p>
					
					<input type="submit" value="Salvar" />

				</form>
			</div>


		<a href="/EuWash"> voltar</a>
</body>
</html>