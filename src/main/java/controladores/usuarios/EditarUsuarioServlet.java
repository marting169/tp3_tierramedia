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
//@WebServlet("/mmm")
//public class EditarUsuarioServlet extends HttpServlet {
//
//	private static final long serialVersionUID = 1L;
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
//		Integer id = Integer.parseInt(req.getParameter("id"));
//
//		Usuario user = userService.find(id);
//		req.setAttribute("user", user);
//
//		RequestDispatcher dispatcher = getServletContext()
//				.getRequestDispatcher("/mmm");
//		dispatcher.forward(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		Integer id = Integer.parseInt(req.getParameter("id"));
//		String nombre = req.getParameter("nombre");
//		Integer presupuesto = Integer.parseInt(req.getParameter("presupuesto"));
//		Double tiempo_disponible = Double.parseDouble(req.getParameter("tiempo_disponible"));
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		Boolean admin = Boolean.parseBoolean(req.getParameter("admin"));
//
//		Usuario user = userService.update(id, nombre, presupuesto, tiempo_disponible, username, password, admin);
//
//		if (user.esValido()) {
//			resp.sendRedirect("/mmm");
//		} else {
//			req.setAttribute("user", user);
//
//			RequestDispatcher dispatcher = getServletContext()
//					.getRequestDispatcher("mmm");
//			dispatcher.forward(req, resp);
//		}
//	}
//}
