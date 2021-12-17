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

@WebServlet("/atraccion-editar")
public class EditarAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 1780266793265896223L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Atraccion atraccion = atraccionService.find(id);
		req.setAttribute("atraccion", atraccion);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/atracciones");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		Integer costo = Integer.parseInt(req.getParameter("costo"));
		// Integer cost = req.getParameter("cost").trim() == "" ? null : Integer.parseInt(req.getParameter("cost"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));

		Atraccion atraccion= atraccionService.update(id, nombre, costo, tiempo, cupo);

		if (!atraccion.isValid()) {
			resp.sendRedirect("/atracciones");
		} else {
			req.setAttribute("attraction", atraccion);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/atracciones");
			dispatcher.forward(req, resp);
		}
	}
}
