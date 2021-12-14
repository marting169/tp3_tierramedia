<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<jsp:include page="headAdmin.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="navAdmin.jsp"></jsp:include>

	<div class="container-fluid">

		<div class="card">
			<h5 class="card-header">Bienvenido al Sistema Interno de Administracion del Parque Tierra Media</h5>
			<div class="card-body">
				<h5 class="card-title">Administrar Atracciones</h5>
				<p class="card-text">Ingrese para dar de alta, modificar, eliminar y ver el listado de las atracciones disponibles.
				<a href="atracciones.jsp" class="btn btn-primary" target="_blank">Ir</a></p>
			</div>
			<div class="card-body">
				<h5 class="card-title">Administrar Promociones</h5>
				<p class="card-text">Ingrese para dar de alta, modificar, eliminar y ver el listado de las promociones disponibles.
				<a href="promociones.jsp" class="btn btn-primary" target="_blank">Ir</a></p>
			</div>
			<div class="card-body">
				<h5 class="card-title">Administrar Usuarios</h5>
				<p class="card-text">Ingrese para dar de alta, modificar, eliminar y ver el listado de los usuarios disponibles.
				<a href="usuarios.jsp" class="btn btn-primary" target="_blank">Ir</a></p>
			</div>
			
		</div>

	</div>

</body>

</html>