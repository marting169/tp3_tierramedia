package dao;

public class DAOFactory {

	public static UsuarioDAO getUserDAO() {
		return new UsuarioDAO();
	}
	
	public static AtraccionDAO getAttractionDAO() {
		return new AtraccionDAO();
	}
	
	public static PromocionDAO getPromoDAO() {
		return new PromocionDAO();
	}


}
