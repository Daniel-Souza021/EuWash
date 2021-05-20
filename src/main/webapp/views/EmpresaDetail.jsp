<%@ page import="java.util.List" %>
<%@page import="unoesc.edu.euwash.model.Empresa"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Empresa</title>
</head>
<body>
<form action="cadastraEmpresa" method="post">
    <p>Razão Social: <input type="text" name="razaoSocial" value=<%=e.getRazaoSocial()%>></p>
    <p>Nome Fantasia: <input type="text" name="nomeFantasia" value=<%=e.getNomeFantasia()%>></p>
    <p>CNPJ: <input type="number" name="cnpj" value=<%=e.getCnpj()%>></p>
    <input type="hidden" name="index" value=<%=indexEmpresa%>>
    <button type="submit">Editar</button>
</form>
</body>
</html>