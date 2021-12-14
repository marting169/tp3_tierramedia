package servicios;

import java.util.List;

import model.Atraccion;
import persistencia.*;
import persistencia.commons.DAOFactory;

public class AtraccionService {
	
	public List<Atraccion> list() {
		return DAOFactory.getAtraccionDAO().findAll();
	}

	public Atraccion create(int id, String name, double cost, double duration, int capacity) {

		Atraccion attraction = new Atraccion(id, name, cost, duration, capacity);

		if (attraction.isValid()) {
			AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
			attractionDAO.insert(attraction);
		}

		return attraction;
	}

	public Atraccion update(int id, String name, double cost, double duration, int capacity) {

		AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
		Atraccion attraction = attractionDAO.find(id);

		attraction.setNombreAtraccion(name);
		attraction.setCosto(cost);
		attraction.setTiempo(duration);
		attraction.setCupo(capacity);

		if (attraction.isValid()) {
			attractionDAO.update(attraction);
		}

		return attraction;
	}

	public void delete(int id) {
		Atraccion attraction = new Atraccion(id, null, null, null, null);

		AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
		attractionDAO.delete(attraction);
	}

	public Atraccion find(Integer id) throws Exception {
		return DAOFactory.getAtraccionDAO().find(id);
	}

}


