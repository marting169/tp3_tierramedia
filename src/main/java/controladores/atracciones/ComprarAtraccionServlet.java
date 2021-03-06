//package controladores.atracciones;
//
//import java.io.IOException;
//import java.util.Map;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import model.Usuario;
//import persistencia.commons.DAOFactory;
//import servicios.ComprarAtraccionService;
//
//@WebServlet("/index")
//public class ComprarAtraccionServlet extends HttpServlet {
//
//	private static final long serialVersionUID = 1L;
//	private ComprarAtraccionService buyAttractionService;
//
//	@Override
//	public void init() throws ServletException {
//		super.init();
//		this.buyAttractionService = new ComprarAtraccionService();
//	}
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		Integer attractionId = Integer.parseInt(req.getParameter("id"));
//		Usuario user = (Usuario) req.getSession().getAttribute("user");
//		Map<String, String> errors = buyAttractionService.buy(user.getId(), attractionId);
//		
//		Usuario user2 = DAOFactory.getUsuarioDAO().find(user.getId());
//		req.getSession().setAttribute("user", user2);
//		
//		if (errors.isEmpty()) {
//			req.setAttribute("success", "¡Gracias por tu compra!");
//		} else {
//			req.setAttribute("errors", errors);
//			req.setAttribute("flash", "No se pudo realizar la compra, intenta nuevamente.");
//		}
//
//		RequestDispatcher dispatcher = getServletContext()
//				.getRequestDispatcher("/index.jsp");
//		dispatcher.forward(req, resp);
//	}
//}
