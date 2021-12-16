package servicios;

import java.util.List;

import model.Atraccion;
import persistencia.*;
import persistencia.commons.DAOFactory;

public class AtraccionService {
	
	public List<Atraccion> list() {
		return DAOFactory.getAtraccionDAO().findAll();
	}

	public Atraccion create(String nombre, double costo, double duracion, int cupo) {

		Atraccion attraction = new Atraccion(nombre, costo, duracion, cupo);

		if (attraction.isValid()) {
			AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
			attractionDAO.insert(attraction);
		}

		return attraction;
	}

	public Atraccion update(int id, String nombre, double costo, double duracion, int cupo) {

		AtraccionDAO attractionDAO = DAOFactory.getAtraccionDAO();
		Atraccion attraction = attractionDAO.find(id);

		attraction.setNombre(nombre);
		attraction.setCosto(costo);
		attraction.setTiempo(duracion);
		attraction.setCupo(cupo);

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

	public Atraccion find(Integer id) {
		return DAOFactory.getAtraccionDAO().find(id);
	}

}


