<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<jsp:include page="/partes/headAdmin.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="/partes/navAdmin.jsp"></jsp:include>

	<div class="container-lg shadow-lg p-3 mb-5 bg-body">

		<div class="bg-light p-4 mb-3 rounded shadow">
			<h1>Administracion de Promociones</h1>
		</div>

		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#exampleModal"><i class="bi bi-plus-lg"></i>Crear nueva promoción</button>

		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Completar
							datos de promoción</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form action="/promociones-crear" method="post">
							<div class="mb-3">
								<label for="nombre" class="form-label">Nombre</label> <input
									type="text" class="form-control" id="nombre"
									aria-describedby="nombre promocion">
							</div>
							<div class="mb-3">
								<label for="tipo" class="form-label">Tipo de descuento</label> 
								<select id="tipo" class="form-select" aria-label="Default select example">
									<option selected>Seleccinar tipo</option>
									<option value="AXB">A por B</option>
									<option value="PORCENTUAL">Porcentual</option>
									<option value="ABSOLUTO">Absoluto</option>
								</select>
							</div>
							<div class="mb-3">
								<label for="costo" class="form-label">Descuento</label> <input
									type="text" class="form-control" id="costo"
									aria-describedby="Descuento">
							</div>
							<div class="mb-3">
								<label for="atracciones" class="form-label">Atracciones</label> 
								<select id="atracciones" class="form-select" multiple aria-label="multiple select example">
									<option selected>Seleccinar...</option>
									<option value="1">Moria</option>
									<option value="2">Abismo de Helm</option>
									<option value="3">Lothlörien</option>
								</select>
							</div>
							<button type="submit" class="btn btn-primary">Guardar
								cambios</button>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Descartar</button>
						<button type="button" class="btn btn-primary">Guardar
							cambios</button>
					</div>
				</div>
			</div>
		</div>

		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Promoci&oacute;n</th>
					<th>Costo</th>
					<th>Duraci&oacute;n</th>
					<th>Atacciones Incluidas</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${promociones}" var="promocion">
					<tr>

						<td><c:out value="${promocion.nombre}"></c:out></td>
						<td><c:out value="${promocion.costo}"></c:out></td>
						<td><c:out value="${promocion.tiempo}"></c:out></td>

						<td><c:out value="${promocion.atracciones}"></c:out></td>

						<td><a href="#" class="btn btn-light rounded-0" role="button">
								<i class="bi bi-pencil-fill"></i>
						</a> <a href="#" class="btn btn-danger rounded" role="button"> <i
								class="bi bi-x-circle-fill"></i></a>
						<td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>


</body>

</html>