//package controladores.promociones;
//
//import java.io.IOException;
//import java.util.List;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.Servlet;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import model.Promocion;
//import servicios.PromocionService;
//
//@WebServlet("/promcoiones")
//public class ListarPromocionesServlet extends HttpServlet implements Servlet {
//	private static final long serialVersionUID = 1L;
//	private PromocionService promoService;
//
//	@Override
//	public void init() throws ServletException {
//		super.init();
//		this.promoService = new PromocionService();
//	}
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	
//			List<Promocion> promos = promoService.list();
//			req.setAttribute("promociones", promociones);
//
//			RequestDispatcher dispatcher = getServletContext()
//					.getRequestDispatcher("/atracciones.jsp");
//			dispatcher.forward(req, resp);
//			
//	}
//
//}
