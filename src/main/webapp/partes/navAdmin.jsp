<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="indexAdmin.jsp">ADMINISTRACION TIERRA MEDIA</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarText"
				aria-controls="navbarText" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarText">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
<<<<<<< HEAD:src/main/webapp/partes/navAdmin.jsp
					<li class="nav-item"><a class="nav-link" href="atraccionesAdmin.jsp" target="_blank">Atracciones</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="promocionesAdmin.jsp" target="_blank">Promociones</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="usuariosAdmin.jsp" target="_blank">Usuarios</a>
=======
					<li class="nav-item"><a class="nav-link" href="atracciones" >Atracciones</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="promociones" target="_blank">Promociones</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="usuarios" target="_blank">Usuarios</a>
>>>>>>> martin:src/main/webapp/navAdmin.jsp
					</li>
				</ul>
			</div>

			<div class="dropdown">
				<button class="btn btn-secondary dropdown-toggle" type="button"
					id="dropdownMenu2" data-bs-toggle="dropdown" aria-expanded="false">
					User</button>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
<<<<<<< HEAD:src/main/webapp/partes/navAdmin.jsp
					<li><button class="dropdown-item" type="button"><a class="nav-link" href="#">Salir</a></button></li>
=======
					<li><button class="dropdown-item" type="button"><a class="nav-link" href="logout">Salir</a></button></li>
>>>>>>> martin:src/main/webapp/navAdmin.jsp
				</ul>
			</div>
		</div>
	</nav>