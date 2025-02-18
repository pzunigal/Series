<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Serie</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<h1>TV - SERIES</h1>
	<div class="container">
		<header class="d-flex justify-content-between align-items-center">
			<h1>¡Bienvenid@ ${usuarioEnSesion.nombre} !</h1>
			
			
			<a href="/dashboard">Series</a>
			
			<a href="/nuevo">Agregar</a>
			
			<a href="/logout" class="btn btn-danger">Cerrar Sesión</a>
		</header>
		<div class="row">
			<h2>Agregar Serie</h2>
			<form:form action="/crear" method="POST" modelAttribute="nuevaSerie" >
				<div>
					<form:label path="titulo">Título:</form:label>
					<form:input path="titulo" class="form-control" />
					<form:errors path="titulo" class="text-danger" />
				</div>
				<div>
					<form:label path="anio">Año:</form:label>
					<form:input path="anio" class="form-control" />
					<form:errors path="anio" class="text-danger" />
				</div>
				<div>
					<form:label path="descripcion">Descripcion:</form:label>
					<form:textarea path="descripcion" class="form-control" />
					<form:errors path="descripcion" class="text-danger" />
				</div>
				<div>
					<form:label path="urlImagen">URL Imagen:</form:label>
					<form:input path="urlImagen" class="form-control" />
					<form:errors path="urlImagen" class="text-danger" />
				</div>
				<div>
					<form:label path="cantidad">Cantidad:</form:label>
					<form:input path="cantidad" class="form-control" />
					<form:errors path="cantidad" class="text-danger" />
				</div>
				<div>
					<form:label path="precio">Precio:</form:label>
					<form:input path="precio" class="form-control" />
					<form:errors path="precio" class="text-danger" />
				</div>
				<form:hidden path="creador" value="${usuarioEnSesion.id}" />
				<input type="submit" class="btn btn-success mt-3" value="Guardar" >
			</form:form>
		</div>
	</div>
</body>
</html>