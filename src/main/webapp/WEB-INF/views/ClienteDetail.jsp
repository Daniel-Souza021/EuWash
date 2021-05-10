<%@page import="java.util.ArrayList"%>
<%@page import="unoesc.edu.euwash.model.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clientes</title>
</head>
<body>

	<%
			List<Cliente> clientes;
			if (session.getAttribute("clientes") == null) {
			clientes = new ArrayList<Cliente>();
			session.setAttribute("clientes", clientes);
			} else
			clientes = (ArrayList<Cliente>) session.getAttribute("clientes");
			int clientesId = Integer.parseInt(request.getParameter("clientesId"));

			if (clientes.size() < 1 || clientes.size() < clientesId) {
				request.getRequestDispatcher("ClienteView.jsp").forward(request, response);
			}

			Cliente c = clientes.get(clientesId);
	%>
	
	

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<form action="cadastroProfessor" method="POST">
			<p>
				Nome:<input type="text" name="txtnome" value=<%=c.getNome()%> />
			</p>

			<p>
				Sobrenome:<input type="text" name="txtsobrenome" value=<%=c.getSobrenome()%> />
			</p>
			
			<p>Telefone:<input type="text" name="txttelefone" value=<%=c.getTelefone() %>/></p>

			<p>
				Data de Nascimento:<input type="date" id="txtdtnasc"
					name="txtdtnasc" value="<%=c.getDataNasDateInput()%>" />
			</p>
			
			<input type="hidden" name="updateCliente" value=<%=clientesId%> /> 
			
			<input type="submit" value="Salvar" />

		</form>
	</div>

	<a href="ClienteView.jsp"> Voltar</a>
</body>
</html>