<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>TV - SERIES</h1>
		<header class="d-flex justify-content-between align-center">
			<h1>Registro</h1>
			<a href="/login">Login</a>
			<a href="/">Registro</a>
		</header>
		<div class="row">
			<form:form action="/registro" method="POST" modelAttribute="nuevoUsuario">
				<div>
					<form:label path="nombre" >Nombre:</form:label>
					<form:input path="nombre" class="form-control" />
					<form:errors path="nombre" class="text-danger" />
				</div>
				
				<div>
					<form:label path="apellido" >Apellido:</form:label>
					<form:input path="apellido" class="form-control" />
					<form:errors path="apellido" class="text-danger" />
				</div>
				
				<div>
					<form:label path="email" >E-mail:</form:label>
					<form:input path="email" class="form-control" />
					<form:errors path="email" class="text-danger" />
				</div>
				
				<div>
					<form:label path="password">Password:</form:label>
					<form:password path="password" class="form-control" />
					<form:errors path="password" class="text-danger" />
				</div>
				
				<div>
					<form:label path="confirmacion">Confirmacion:</form:label>
					<form:password path="confirmacion" class="form-control" />
					<form:errors path="confirmacion" class="text-danger" />
				</div>
				<input type="submit" class="btn btn-success mt-3">
			</form:form>
		</div>
	</div>
</body>
</html>