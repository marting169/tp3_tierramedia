package persistencia.commons;

import persistencia.AtraccionDAO;
import persistencia.UsuarioDAO;
import persistencia.PromocionDAO;
import persistencia.impl.AtraccionDAOimpl;
import persistencia.impl.UsuarioDAOimpl;
import persistencia.impl.PromocionDAOimpl;

public class DAOFactory {

	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOimpl();
	} 
	
	public static AtraccionDAO getAtraccionDAO() {
		return new AtraccionDAOimpl();
	}
	
	public static PromocionDAO getPromocionDAO() {
		return new PromocionDAOimpl();
	}


}
