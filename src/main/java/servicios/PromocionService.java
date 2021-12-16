
package servicios;

import java.util.List;

import model.Promocion;
//import persistencia.PromocionDAO;
import persistencia.commons.DAOFactory;

public class PromocionService {
	public List<Promocion> list() {
		return DAOFactory.getPromocionDAO().findAll();
	}

//	public Promocion create(int id, String name, double cost, double duration, int capacity) {
//
//		Promocion attraction = new Promocion(id, name, cost, duration, capacity);
//
//		if (attraction.isValid()) {
//			AtraccionDAO attractionDAO = DAOFactory.getPromocionDAO();
//			attractionDAO.insert(attraction);
//		}
//
//		return attraction;
//	}

//	public Promocion update(int id, String name, double cost, double duration, int capacity) {
//
//		PromocionDAO attractionDAO = DAOFactory.getPromocionDAO();
//		Promocion attraction = attractionDAO.find(id);
//
//		attraction.setNombreAtraccion(name);
//		attraction.setCosto(cost);
//		attraction.setTiempo(duration);
//		attraction.setCupo(capacity);
//
//		if (attraction.isValid()) {
//			attractionDAO.update(attraction);
//		}
//
//		return attraction;
//	}

//	public void delete(int id) {
//		//Promocion promocion = new Promocion(id, null, null, null, null);
//
//		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
//		promocionDAO.delete(promocion);
//	}

	public Promocion find(Integer id) throws Exception {
		return DAOFactory.getPromocionDAO().find(id);
	}

}
