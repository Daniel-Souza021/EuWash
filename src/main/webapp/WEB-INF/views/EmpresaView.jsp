<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empresas</title>
</head>
<body>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<c:if test="${listaEmpresa.size() > 0}">
			<table border="2" width="70%" cellpadding="2">
				<tr>
					<th>Razão Social</th>
					<th>Nome Fantasia</th>
					<th>CNPJ</th>
					<th>Edit</th>
					<th>Delete</th>	
				</tr>
				<c:forEach var="e" items="${listaEmpresa}">
					<tr>
						<td>${e.razaoSocial}</td>
						<td>${e.nomeFantasia}</td>
						<td>${e.cnpj}</td>
						<td><a href="/EuWash/empresaEdit/${e.id}">Edit</a></td>
						<td><a href="/EuWash/empresaDelete/${e.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
				<form action="/EuWash/empresaSave" method="POST" modelAttribute="empresa">
					<form:hidden path="empresa.id" />
					<p>
						Razão Social:
						<form:input path="empresa.razaoSocial" />

					</p>

					<p>
						Nome Fantasia:
						<form:input path="empresa.nomeFantasia" />

					</p>
					<p>
						CNPJ:
						<form:input path="empresa.cnpj" />

					</p>
					
					
					<input type="submit" value="Salvar" />

				</form>
			</div>


		<a href="/EuWash"> voltar</a>
</body>
</html>