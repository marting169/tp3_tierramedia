package servicios;

import java.util.List;

import model.Atraccion;
import persistencia.*;
import persistencia.commons.DAOFactory;

public class AtraccionService {
	
	public List<Atraccion> list() {
		return DAOFactory.getAtraccionDAO().findAll();
	}

	public Atraccion create(String nombre, double costo, double tiempo, int cupo) {

		Atraccion atraccion = new Atraccion(nombre, costo, tiempo, cupo);

		if (atraccion.isValid()) {
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
			atraccionDAO.insert(atraccion);
		}

		return atraccion;
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
		Atraccion atraccion = new Atraccion(id, null, 0.0, 0.0, 0);

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		atraccionDAO.delete(atraccion);
	}

	public Atraccion find(Integer id) {
		return DAOFactory.getAtraccionDAO().find(id);
	}

}


