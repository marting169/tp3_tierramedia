//package controladores.atracciones;
//
//import java.io.IOException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import servicios.AtraccionService;
//
//@WebServlet("/index")
//public class BorrarAtraccionServlet extends HttpServlet {
//
//	private static final long serialVersionUID = 1L;
//	private AtraccionService attractionService;
//
//	@Override
//	public void init() throws ServletException {
//		super.init();
//		this.attractionService = new AtraccionService();
//	}
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Integer id = Integer.parseInt(req.getParameter("id"));
//
//		attractionService.delete(id);
//
//		resp.sendRedirect("/index.jsp");
//	}
//
//
//}
