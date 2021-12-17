package controladores.atracciones;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import servicios.AtraccionService;

@WebServlet("/atraccion-crear")
public class CrearAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = -5273257292233318157L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/interfazAdmin/atracciones/atraccionesAdmin.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Double costo = Double.parseDouble(req.getParameter("costo"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));

		Atraccion atraccion = atraccionService.create(nombre, costo, tiempo, cupo);
		
		if (!atraccion.isValid()) {
			resp.sendRedirect("/atracciones");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/atracciones");
			dispatcher.forward(req, resp);
		}

	}

}
