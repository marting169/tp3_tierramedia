
package controladores.promociones;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promocion;
import servicios.PromocionService;

@WebServlet("/promociones")
public class ListarPromocionesServlet extends HttpServlet implements Servlet {


	private static final long serialVersionUID = 7042949777456063912L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			List<Promocion> promociones = promocionService.list();
			req.setAttribute("promociones", promociones);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/interfazAdmin/promocionesAdmin.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			resp.getWriter().append("Error" + e);
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
