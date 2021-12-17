package controladores.atracciones;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicios.AtraccionService;

@WebServlet("/atraccion-borrar")
public class BorrarAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = -5709372563235617326L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		atraccionService.delete(id);

		resp.sendRedirect("/TierraMediaApp/atracciones");
	}


}
