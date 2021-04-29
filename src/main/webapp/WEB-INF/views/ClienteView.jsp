<%@page import="java.util.ArrayList"%>
<%@page import="unoesc.edu.euwash.model.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Clientes</title>
</head>
<body>

	<%
		List<Cliente> clientes;
		if (session.getAttribute("clientes") == null) {
			clientes = new ArrayList<Cliente>();
			session.setAttribute("clientes", clientes);
		} else
			clientes = (ArrayList<Cliente>) session.getAttribute("clientes");
	%>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">

		<%
			if (clientes.size() > 0) {
				System.out.println(clientes.size());
		%>
		<table style="width: 100%">
			<tr>
				<th>Nome</th>
				<th>Sobrenome</th>
				<th>Telefone</th>
				<th>Data Nascimento</th>
			</tr>
			<%
				for (Cliente c : clientes) {
						out.print("<tr style=\"border: 1px solid black;\"> " 
								+ "<td style=\"border: 1px solid black;\"> "+ c.getNome() + "</td>" + "<td style=\"border: 1px solid black;\"> " + c.getSobrenome() + "</td>" 
								+ "<td style=\"border: 1px solid black;\"> " + c.getTelefone() + "</td>"
								+ "<td style=\"border: 1px solid black;\"> " + c.getDataNasFormated() + "</td>"
								+ "<td style=\"border: 1px solid black;\">  <a href=\"ClienteDetail.jsp?clientesId=" + clientes.indexOf(c) + "\"> Edit</a></td>" + "</tr>");
					}
			%>
		</table>
		<%
			} else {
		%>
			<p>Não há Clientes Cadastrados</p>
		<%
			}
		%>
	</div>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">

		<form action="cadastroClientes" method="POST">
			<p>
				Nome:<input type="text" name="txtnome" />
			</p>

			<p>
				Sobrenome:<input type="text" name="txtsobrenome" />
			</p>

			<p>
				Telefone:<input type="text" name="txttelefone" />
			</p>

			<p>
				Data de Nascimento:<input type="date" name="txtdtnasc" />
			</p>

			<input type="submit" value="Cadastrar" />

		</form>
	</div>

	<a href="index.jsp"> Voltar</a>
</body>

</html>