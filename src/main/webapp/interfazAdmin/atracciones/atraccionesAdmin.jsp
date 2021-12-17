<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<jsp:include page="/partes/headAdmin.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="/partes/navAdmin.jsp"></jsp:include>

	<div class="container-lg shadow-lg p-3 mb-5 bg-body">

		<div class="bg-light p-4 mb-3 rounded shadow">
			<h1>Administracion de Atracciones</h1>
		</div>

		<!-- Button trigger modal -->
		<button type="button" id="abrirModal" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#modalCrearAtraccion">
			<i class="bi bi-plus-lg"></i>Crear nueva atracción
		</button>

		<!-- Modal -->
		<div class="modal fade" id="modalCrearAtraccion" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Completar
							datos de atracción</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
						<c:if test="${atraccion != null && !atraccion.isValid()}">
							<div class="alert alert-danger">
								<p>Se encontraron errores al crear la atracción.</p>
							</div>
						</c:if>
					</div>
					<div class="modal-body">
						<form action="/TierraMediaApp/atraccion-crear" method="post">
							<div class="mb-3">
								<label for="nombre" class="form-label">Nombre</label> <input
									type="text" class="form-control" id="nombre" name="nombre"
									aria-describedby="nombre promocion" required value="${attraction.nombre}">
							</div>
							<div class="mb-3">
								<label for="costo" class="form-label">Valor</label> <input
									type="number" class="form-control" id="costo" name="costo"
									aria-describedby="Costo" required value="${attraction.costo}">
							</div>

							<div class="mb-3">
								<label for="tiempo" class="form-label">Duración</label> <input
									type="number" class="form-control" id="tiempo" name="tiempo"
									aria-describedby="Duracion" required value="${attraction.tiempo}">
							</div>

							<div class="mb-3">
								<label for="cupo" class="form-label">Cupo</label> <input
									type="text" class="form-control" id="cupo" name="cupo"
									aria-describedby="Cupo" required value="${attraction.cupo}">
							</div>
							<hr>
							<div class="mb-3">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal" id="descartar">Descartar</button>
								<button type="submit" class="btn btn-primary">Guardar
									cambios</button>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>


		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Atracci&oacute;n</th>
					<th>Costo</th>
					<th>Duraci&oacute;n</th>
					<th>Cupo</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${atracciones}" var="atraccion">
					<tr>
						<td><strong><c:out value="${atraccion.nombre}"></c:out></strong></td>
						<td><c:out value="${atraccion.costo}"></c:out></td>
						<td><c:out value="${atraccion.tiempo}"></c:out></td>
						<td><c:out value="${atraccion.cupo}"></c:out></td>

						<td><a href="/TierraMediaApp/atraccion-editar?id=${atraccion.id}" class="btn btn-primary rounded-0"
							role="button" data-bs-toggle="modal"
			data-bs-target="#modalCrearAtraccion"> <i class="bi bi-pencil-fill"></i>
						</a> <a href="/TierraMediaApp/atraccion-borrar?id=${atraccion.id}" class="btn btn-secondary rounded" role="button">
								<i class="bi bi-x-circle-fill"></i>
						</a>
						<td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>
<script type="text/javascript">

$(function() {
	$('#abrirModal').on('click',function(){
		$('#modalCrearAtraccion').modal('show');
	});
	
	$('#modalCrearAtraccion').on('hidden.bs.modal',function(event){
		console.log($('#modalCrearAtraccion'));
// 		$('#modalCrearAtraccion').find('form')[0].reset();
	});
	
	
// 	$('#descartar').click(function() {
// 		$("#modalCrearAtraccion")[0].reset();
// 	});
});

</script>
</body>

</html>
