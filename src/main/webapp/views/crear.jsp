<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Producto</title>
</head>
<body>
	<h1>Crear Producto</h1>

	<c:if test="${not empty mensaje}">
		<div style="color: green; font-weight: bold;">${mensaje}</div>
	</c:if>
	<c:if test="${not empty error}">
		<div style="color: red; font-weight: bold;">${error}</div>
	</c:if>

	<form action="productos" method="post">
		<input type="hidden" name="opcion" value="guardar">
		<table border="1">
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" size="50"></td>
			</tr>
			<tr>
				<td>Cantidad:</td>
				<td><input type="text" name="cantidad" size="50"></td>
			</tr>
			<tr>
				<td>Precio:</td>
				<td><input type="text" name="precio" size="50"></td>
			</tr>
		</table>
		<input type="submit" value="Guardar">
	</form>
</body>
</html>