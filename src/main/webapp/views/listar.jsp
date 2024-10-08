<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Productos</title>
<link rel="stylesheet" type="text/css" href="./styles/style.css">
</head>
<body>

	<h1>Crear Producto</h1>

	<c:if test="${not empty mensajeExito}">
		<div class="alerta-exito">
			${mensajeExito}
		</div>
	</c:if>
	<c:if test="${not empty mensajeError}">
		<div class="alerta-error">
			${mensajeError}
		</div>
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

	<h1>Listar Productos</h1>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Nombre</td>
			<td>Cantidad</td>
			<td>Precio</td>
			<td>Fecha Creacion</td>
			<td>Fecha Actualizacion</td>
			<td>Accion</td>
			<td>Accion</td>
		</tr>
		<c:forEach var="producto" items="${lista}">
			<tr>
				<td><a
					href="productos?opcion=meditar&id=<c:out value="${ producto.id}"></c:out>">
						<c:out value="${ producto.id}"></c:out>
				</a></td>
				<td><c:out value="${ producto.nombre}"></c:out></td>
				<td><c:out value="${ producto.cantidad}"></c:out></td>
				<td><c:out value="${ producto.precio}"></c:out></td>
				<td><fmt:formatDate value="${producto.fechaCrear}"
						pattern="EEEE, d 'de' MMMM 'de' yyyy, h:mm:ss a" /></td>
				<td><fmt:formatDate value="${producto.fechaActualizar}"
						pattern="EEEE, d 'de' MMMM 'de' yyyy, h:mm:ss a" /></td>
				<td><a
					href="productos?opcion=eliminar&id=<c:out value="${ producto.id}"></c:out>">
						Eliminar </a></td>
				<td><a
					href="productos?opcion=meditar&id=<c:out value="${ producto.id}"></c:out>">
						Editar </a></td>
			</tr>
		</c:forEach>
	</table>
	
	<table border="1">
		<tr>
			<td><a href="productos?opcion=crear"> Crear un Producto</a></td>
		</tr>
	</table>
</body>
</html>