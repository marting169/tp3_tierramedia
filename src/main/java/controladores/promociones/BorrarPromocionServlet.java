//package controladores.promociones;
//
//import java.io.IOException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import servicios.PromocionService;
//
//@WebServlet("/index")
//public class BorrarPromocionServlet extends HttpServlet {
//
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
//		Integer id = Integer.parseInt(req.getParameter("id"));
//
//		promoService.delete(id);
//
//		resp.sendRedirect("/index.jsp");
//	}
//
//
//}
