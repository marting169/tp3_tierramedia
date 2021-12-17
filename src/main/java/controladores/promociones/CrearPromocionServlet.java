package controladores.promociones;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promocion;
import servicios.PromocionService;

@WebServlet("/promociones-crear")
public class CrearPromocionServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1329197941654675174L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/crearpromo.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Double descuento = Double.parseDouble(req.getParameter("costo"));
		String tipo = req.getParameter("tipo");
		Integer atracciones = Integer.parseInt(req.getParameter("atracciones"));

		Promocion promocion = promocionService.create(nombre, descuento, tipo);
		
		if (promocion.esValida()) {
			resp.sendRedirect("/tanto.do");
		} else {
			req.setAttribute("promocion", promocion);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/promociones");
			dispatcher.forward(req, resp);
		}

	}

}
