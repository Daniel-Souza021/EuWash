<%@ page import="java.util.List" %>
<%@page import="unoesc.edu.euwash.model.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Clientes</title>
</head>
<body>
<form action="cadastraClientes" method="post">
    <p>Nome: <input type="text" name="nome" value=<%=c.getNome()%>></p>
    <p>Sobrenome: <input type="text" name="sobrenome" value=<%=c.getSobrenome()%>></p>
    <p>Telefone: <input type="text" name="telefone" value=<%=c.getTelefone()%>></p>
    <p>DataNasc: <input type="text" name="telefone" value=<%=c.getTelefone()%>></p>
    <input type="hidden" name="index" value=<%=indexCliente%>>
    <button type="submit">Editar</button>
</form>
</body>
</html>