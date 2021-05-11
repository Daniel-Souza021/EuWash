<%@ page import="java.util.List" %>
<%@page import="unoesc.edu.euwash.model.Servico"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Serviço</title>
</head>
<body>
<form action="cadastraServico" method="post">
    <p>Descrição: <input type="text" name="descricao" value=<%=s.getDescricao()%>></p>
    <p>Preço: <input type="text" name="preco" value=<%=s.getPreco()%>></p>
    <p>Categoria: <input type="number" name="categoria" value=<%=s.getCategoria()%>></p>
    <input type="hidden" name="index" value=<%=indexServico%>>
    <button type="submit">Editar</button>
</form>
</body>
</html>