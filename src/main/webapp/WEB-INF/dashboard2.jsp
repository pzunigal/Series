<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<h1>TV - SERIES</h1>
	<div class="container">
		<header class="d-flex justify-content-between align-items-center">
			<h1>¡Bienvenid@ ${usuarioEnSesion.nombre} !</h1>
			
			
			<a href="/dashboard2">Series</a>
			
			<a href="/nuevo">Agregar Serie</a>
			
			<a href="/logout" class="btn btn-danger">Cerrar Sesión</a>
		</header>
		
		<div class="row">
		 	<form action="/buscar" method="GET">
		 		<div class="input-group mb-3">
				  <input type="text" class="form-control" placeholder="Buscar Serie" name="palabra">
				  <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Buscar</button>
				</div>
		 	</form>
		</div>
		
		<main class="row">
			<div class="col-8">
				<c:forEach items="${series}" var="serie" >
					<div class="card mb-3">
					  <div class="row g-0">
					    <div class="col-md-4">
					      <img src="${serie.urlImagen}" class="img-fluid rounded-start" alt="serie">
					    </div>
					    <div class="col-md-8">
					      <div class="card-body">
					        <h5 class="card-title"><a href="/mostrar/${serie.id}">${serie.titulo}</a></h5>
					        <p class="card-text"><small class="text-body-secondary">Año: ${serie.anio}</small></p>
					        <p class="card-text"><small class="text-body-secondary">Precio: ${serie.precio}</small></p>
					      </div>
					    </div>
					  </div>
					  <div class="card-footer text-end">
					    <c:if test="${serie.creador.id == usuarioEnSesion.id }" >
					    	<a href="/editar/${serie.id}" ><i class="fa-solid fa-pen"></i></a>
					    </c:if>
					  </div>
					</div>
				</c:forEach>
			</div>
		</main>
	</div>
</body>
</html>