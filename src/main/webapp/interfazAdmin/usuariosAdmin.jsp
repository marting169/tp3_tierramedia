<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<jsp:include page="/partes/headAdmin.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="/partes/navAdmin.jsp"></jsp:include>

	<div class="container-fluid">

	<div class="bg-light p-4 mb-3 rounded">
			<h1>Administracion de Usuarios</h1>
		</div>

		
			<div class="mb-3">
				<a href="#" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i>+ Crear nuevo Usuario
				</a>
			</div>
		
		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Usuario</th>
					<th>Presupuesto</th>
					<th>Tiempo disponible</th>
					<th>Password</th>
					<th>Rol de usuario</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><strong><c:out value="${user.nombre}"></c:out></strong></td>
						<td><c:out value="${user.presupuesto}"></c:out></td>
						<td><c:out value="${user.tiempo_disponible}"></c:out></td>
						<td><c:out value="${user.password}"></c:out></td>
						<td><c:out value="${user.rol}"></c:out></td>

						<td>
								<a href="#"
									class="btn btn-light rounded-0" role="button">
									<i class="bi bi-pencil-fill"></i></a>
								<a href="#"
									class="btn btn-danger rounded" role="button">
									<i class="bi bi-x-circle-fill"></i></a>
						<td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>

</html>