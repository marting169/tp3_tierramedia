<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="headAdmin.jsp"></jsp:include>
</head>
<body background="https://sm.ign.com/ign_latam/news/a/amazons-th/amazons-the-lord-of-the-ring-series-will-premiere-in-2022-pl_nanh.jpg">
	<div class="col-lg-5 mx-auto p-3 py-md-5">

		<main>
			<h1>Turismo en la Tierra Media</h1>


			<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>
			
			<c:if test="${success != null}">
				<div class="alert alert-success">
					<p>
						<c:out value="${success}" />
					</p>
				</div>
			</c:if>

			<form action="login" method="post">

				<div class="mb-4">
					<label for="username" class="form-label">Usuario</label> <input
						class="form-control" name="username">
				</div>

				<div class="mb-4">
					<label for="password" class="form-label">Contraseña</label> <input
						type="password" class="form-control" name="password">
				</div>

				<div class="d-grid gap-2">
					<button type="submit" class="btn btn-lg btn-primary">Ingresar</button>
				</div>
			</form>

		</main>
	</div>
</body>
</html>