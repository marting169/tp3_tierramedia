package sistema;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import persistencia.commons.ConnectionProvider;
import persistencia.impl.AtraccionDAOimpl;
import persistencia.impl.ItinerarioAtraccionDAOimpl;
import persistencia.impl.ItinerarioPromocionDAOimpl;
import persistencia.impl.PromocionDAOimpl;
import persistencia.impl.UsuarioDAOimpl;
import jdbc.Iniciar;
import logica.Ofertador;
import logica.OrdenadorAtraccionXPrecio;
import logica.OrdenadorPromocionXPrecio;
import model.Atraccion;
import model.Promocion;
import model.Usuario;

public class MainTierraMedia {

	public static void main(String[] args) throws SQLException {
		UsuarioDAOimpl usuarioDao = new UsuarioDAOimpl();
		List<Usuario> listaDeUsuarios = usuarioDao.findAll();
		//System.out.println(listaDeUsuarios);

		AtraccionDAOimpl atraccionDao = new AtraccionDAOimpl();
		List<Atraccion> listaDeAtracciones = atraccionDao.findAll();
		Collections.sort(listaDeAtracciones, Collections.reverseOrder(new OrdenadorAtraccionXPrecio()));
		//System.out.println(listaDeAtracciones);

		PromocionDAOimpl promocionDao = new PromocionDAOimpl();
		List<Promocion> listaDePromociones = promocionDao.findAll(listaDeAtracciones);
		Collections.sort(listaDePromociones, Collections.reverseOrder(new OrdenadorPromocionXPrecio()));
		System.out.println(listaDePromociones);
		
		

		ItinerarioPromocionDAOimpl itinerarioPromocionDao = new ItinerarioPromocionDAOimpl();
		ItinerarioAtraccionDAOimpl itinerarioAtraccionDao = new ItinerarioAtraccionDAOimpl();
		Ofertador ofertas = new Ofertador();
		ofertas.generarOferta(listaDeAtracciones, listaDePromociones, listaDeUsuarios, itinerarioPromocionDao,
				itinerarioAtraccionDao);
		System.out.println(listaDeUsuarios);

		Iniciar iniciar=new Iniciar();
		System.out.println(iniciar.reiniciar());
		
		
		ConnectionProvider.close();
	}

}
