package controladores.atracciones;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import servicios.AtraccionService;

@WebServlet("/atracciones")
public class ListarAtraccionesServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 6712669684984113823L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			List<Atraccion> atracciones = atraccionService.list();
			req.setAttribute("atracciones", atracciones);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/interfazAdmin/atracciones/atraccionesAdmin.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			resp.getWriter().append("Error" + e);
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
