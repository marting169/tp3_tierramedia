package controladores.usuarios;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import servicios.UsuarioService;

@WebServlet("/usuarios")
public class ListarUsuariosServlet extends HttpServlet implements Servlet {

	
	private static final long serialVersionUID = 7148396040525093384L;
	private UsuarioService userService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.userService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Usuario> users = userService.list();
		req.setAttribute("users", users);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/interfazAdmin/usuariosAdmin.jsp");
		dispatcher.forward(req, resp);

	}

}