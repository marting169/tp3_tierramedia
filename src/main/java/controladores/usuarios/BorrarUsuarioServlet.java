//package controladores.usuarios;
//
//import java.io.IOException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import servicios.UsuarioService;
//
//@WebServlet("/index")
//public class BorrarUsuarioServlet extends HttpServlet {
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
//		userService.delete(id);
//
//		resp.sendRedirect("/index.jsp");
//	}
//
//
//}
