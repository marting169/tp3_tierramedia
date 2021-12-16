package servicios;

import java.util.HashMap;
import java.util.Map;

import model.Atraccion;
import model.Usuario;
import persistencia.AtraccionDAO;
import persistencia.UsuarioDAO;
import persistencia.commons.DAOFactory;

public class ComprarAtraccionService {

	AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
	UsuarioDAO userDAO = DAOFactory.getUsuarioDAO();

	public Map<String, String> buy(Integer userId, Integer attractionId) {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario user = userDAO.find(userId);
		Atraccion attraction = attractionDAO.find(attractionId);

		if (!attraction.canHost(1)) {
			errors.put("attraction", "No hay cupo disponible");
		}
		if (!user.puedePagar(attraction)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!user.tieneTiempo(attraction)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			user.agregarAlItinerario(attraction);
			attraction.host(1);

			attractionDAO.update(attraction);
			userDAO.update(user);
		}

		return errors;

	}

}