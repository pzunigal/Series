<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Serie - ${serie.titulo}</title>
<!-- BOOTSTRAP -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<!-- FONT AWESOME (iconos) -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<h1>TV - SERIES</h1>
	<div class="container">
		<header class="d-flex justify-content-between align-items-center">
			<h1>¡Bienvenid@ ${usuarioEnSesion.nombre} !</h1>
			
			
			<a href="/dashboard2">Series</a>
			
			<a href="/nuevo">Agregar</a>
			
			<a href="/logout" class="btn btn-danger">Cerrar Sesión</a>
		</header>
	</div>
	
	<div class="row">
			<h2>${serie.titulo}</h2>
			<div class="card mb-3">
			  <div class="row g-0">
			    <div class="col-md-3">
			      <img src="${serie.urlImagen}" class="img-fluid rounded-start" alt="serie">
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <p class="card-text"><small class="text-body-secondary">Año: ${pelicula.anio}</small></p>
			        <p class="card-text">Usuario creador: ${serie.creador.nombre}</p>
			        <p class="card-text">Sinopsis: ${serie.descripcion}</p>
			        <p class="card-text">Precio: ${serie.precio}</p>
			        <p class="card-text">Cantidad en Inventario: ${serie.cantidad}</p>
			      </div>
			    </div>
			  </div>
			  
			</div>
		</div>
</body>
</html>