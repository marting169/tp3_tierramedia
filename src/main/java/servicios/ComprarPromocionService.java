package servicios;

import java.util.HashMap;
import java.util.Map;

import model.Promocion;
import model.Usuario;
import persistencia.PromocionDAO;
import persistencia.UsuarioDAO;
import persistencia.commons.DAOFactory;


public class ComprarPromocionService {

	PromocionDAO promoDAO = DAOFactory.getPromocionDAO();
	UsuarioDAO userDAO = DAOFactory.getUsuarioDAO();

	public Map<String, String> buy(Integer userId, Integer promoId) {
		
		Map<String, String> errors = new HashMap<String, String>();

		Usuario user = userDAO.find(userId);
		Promocion promo = promoDAO.find(promoId);

		if (!promo.canHost(1)) {
			errors.put("promocion", "No hay cupo disponible");
		}
		if (!user.puedePagarPromo(promo)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!user.tieneTiempoPromo(promo)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			user.agregarPromoAlItinerario(promo);
			promo.decrementarCupos();

			promoDAO.update(promo);
			userDAO.update(user);
		}

		return errors;

	}

}