
package servicios;

import java.util.ArrayList;
import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.PromocionAbsoluta;
import persistencia.PromocionDAO;
import persistencia.commons.DAOFactory;

public class PromocionService {
	public List<Promocion> list() {
		return DAOFactory.getPromocionDAO().findAll();
	}

	public Promocion create(String name, double cost, String tipo) {

		ArrayList<Atraccion> atracciones;
		Promocion promocion = new PromocionAbsoluta(null,name, cost, tipo);

		if (promocion.esValida()) {
			PromocionDAO attractionDAO = DAOFactory.setPromocionDAO();
			attractionDAO.insert(promocion);
		}

		return promocion;
	}

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
