package dao;

public class DAOFactory {

    public static UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAOImpl();
    }

    public static AtraccionDAO getAtraccionDAO() {
        return new AtraccionDAOImpl();
    }

    public static PromocionDAO getPromocionDAO() {
        return new PromocionDAOImpl();
    }

    public static ItinerarioAtraccionDAO getItinerarioAtraccionDAO() {
        return new ItinerarioAtraccionDAOImpl();
    }

    public static ItinerarioPromocionDAO getItinerarioPromocionDAO() {
        return new ItinerarioPromocionDAOImpl();
    }
}