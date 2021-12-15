//package controladores.promociones;
//
//import java.io.IOException;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/promociones")
//public class EditarPromocioncionServlet extends HttpServlet {
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
//		Promocion promo = promoService.find(id);
//		req.setAttribute("promocion", promocion);
//
//		RequestDispatcher dispatcher = getServletContext()
//				.getRequestDispatcher("/promociones.jsp");
//		dispatcher.forward(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		Integer id = Integer.parseInt(req.getParameter("id"));
//		String name = req.getParameter("name");
//		Integer cost = Integer.parseInt(req.getParameter("cost"));
//		// Integer cost = req.getParameter("cost").trim() == "" ? null : Integer.parseInt(req.getParameter("cost"));
//		Double duration = Double.parseDouble(req.getParameter("duration"));
//		Integer capacity = Integer.parseInt(req.getParameter("capacity"));
//
//		Promocion promo = promoService.update(id, name, cost, duration, capacity);
//
//		if (promo.esValida()) {
//			resp.sendRedirect("/tanto.jsp");
//		} else {
//			req.setAttribute("promocion", promocion);
//
//			RequestDispatcher dispatcher = getServletContext()
//					.getRequestDispatcher("/editarpromo.jsp");
//			dispatcher.forward(req, resp);
//		}
//	}
//}
