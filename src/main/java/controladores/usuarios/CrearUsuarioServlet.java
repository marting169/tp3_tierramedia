//package controladores.usuarios;
//
//import java.io.IOException;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import model.Usuario;
//import servicios.UsuarioService;
//
//@WebServlet("/users/create.do")
//public class CrearUsuarioServlet extends HttpServlet {
//
//	private static final long serialVersionUID = 3455721046062278592L;
//	private UsuarioService userService;
//
//	@Override
//	public void init() throws ServletException {
//		super.init();
//		this.userService = new UsuarioService();
//	}
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		RequestDispatcher dispatcher = getServletContext()
//				.getRequestDispatcher("/views/users/create.jsp");
//		dispatcher.forward(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String nombre = req.getParameter("nombre");
//		Integer presupuesto = Integer.parseInt(req.getParameter("presupuesto"));
//		Double tiempo_disponible = Double.parseDouble(req.getParameter("tiempo_disponible"));
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		Boolean admin = Boolean.parseBoolean(req.getParameter("admin"));
//
//		Usuario tmp_user = userService.create(nombre, presupuesto, tiempo_disponible, username, password, admin);
//		
//		if (tmp_user.esValido()) {
//			resp.sendRedirect("/turismo/users/index.do");
//		} else {
//			req.setAttribute("tmp_user", tmp_user);
//
//			RequestDispatcher dispatcher = getServletContext()
//					.getRequestDispatcher("/views/users/create.jsp");
//			dispatcher.forward(req, resp);
//		}
//
//	}
//
//}
