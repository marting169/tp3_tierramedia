//package servicios;
//
//import java.util.List;
//
//import model.Atraccion;
//import model.Promocion;
//import persistencia.PromocionDAO;
//import persistencia.commons.DAOFactory;
//
//
//public class PromocionService {
//	
//	public List<Promocion> list() {
//		return DAOFactory.getPromocionDAO().findAll();
//	}
//	
//	public Promocion find(Integer id) {
//		return DAOFactory.getPromocionDAO().find(id);
//	}
//
//	public Promocion create(String nombre, double costo, double tiempo, List<Atraccion> atracciones) {
//
//		Promocion promo = new Promocion(nombre, costo, tiempo, atracciones);
//
//		if (promo.esValida()) {
//			PromocionDAO promoDAO = DAOFactory.getPromocionDAO();
//			promoDAO.insert(promo);
//		}
//
//		return promo;
//	}
//
//	public Promocion update(int id, String nombre, double costo, double duracion, int cupo) {
//
//		PromocionDAO promoDAO = DAOFactory.getPromocionDAO();
//		Promocion promo = promoDAO.find(id);
//
//		promo.setNombreAtraccion(nombre);
//		promo.setCosto(costo);
//		promo.setTiempo(duracion);
//		promo.setCupo(cupo);
//
//		if (promo.esValida()) {
//			promoDAO.update(promo);
//		}
//
//		return promo;
//	}
//
//	public void delete(int id) {
//		Promocion promo = new Promocion(id, null, null, null, null);
//
//		PromocionDAO promoDAO = DAOFactory.getPromocionDAO();
//		promoDAO.delete(promo);
//	}
//
//	
//
//}