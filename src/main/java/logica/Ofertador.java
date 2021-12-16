package logica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import persistencia.impl.*;
import model.Atraccion;
import model.Producto;
import model.Promocion;
import model.Usuario;

public class Ofertador {
	private ArrayList<Producto> itinerarios;
	private ArrayList<Atraccion> soloAtracciones;

	public Ofertador() {
	}

	@SuppressWarnings("resource")
	public void generarOferta(List<Atraccion> atraccionesA, List<Promocion> promocionesP,
			List<Usuario> usuariosU,ItinerarioPromocionDAOimpl itinerarioPromocionDao,ItinerarioAtraccionDAOimpl itinerarioAtraccionDaoimpl) throws SQLException {
		double presupuesto = 0;
		double tiempoDisponible = 0;
		System.out.println("Bienvenido/a a la Tierra Media");
		System.out.println("-----------------------------------------------------\n");
		for (Usuario usuario : usuariosU) {
			itinerarios = new ArrayList<Producto>();
			soloAtracciones = new ArrayList<Atraccion>();
			UsuarioDAOimpl usuarioDao = new UsuarioDAOimpl();
			presupuesto = usuario.getPresupuesto();
			tiempoDisponible = usuario.getTiempo_disponible();
			System.out.println("Nombre de visitante: " + usuario.getNombre() + "\n");
			for (Promocion promocion : promocionesP) {
				String input;
				Scanner sc = new Scanner(System.in);
				if (presupuesto >= promocion.getConDescuento() && tiempoDisponible >= promocion.getTiempo()
						&& promocion.obtenerCupoMinimo() > 0
						&& !promocion.atraccionIncluidaEnPromocion(soloAtracciones)) {
					System.out.println(promocion.toString());
					System.out.println("\nAcepta sugerencia? Ingrese S o N");
					input = sc.next();
					boolean band = false;
					while (band == false) {
						if (input.equals("S") || input.equals("s")) {
							this.itinerarios.add(promocion);
							this.soloAtracciones.addAll(promocion.obtenerAtracciones());
							
							System.out.println("Aceptada!");
							band = true;
							promocion.decrementarCupos();
							presupuesto -= promocion.getConDescuento();
							tiempoDisponible -= promocion.getTiempo();
							System.out.println("-----------------------------------------------------\n");
						} else if (input.equals("N") || input.equals("n")) {
							System.out.println("Descartado");
							band = true;
							System.out.println("-----------------------------------------------------\n");
						} else {
							System.out.println("Intente nuevamente: Ingrese S o N");
							input = sc.nextLine();
						}
					}
				}
			}
			for (Atraccion atraccion : atraccionesA) {
				String input;
				Scanner sc = new Scanner(System.in);
				AtraccionDAOimpl atraccionDao = new AtraccionDAOimpl();
				if (presupuesto >= atraccion.getCosto() && tiempoDisponible >= atraccion.getTiempo()
						&& atraccion.getCupo() > 0 && !soloAtracciones.contains(atraccion)) {
					System.out.println(atraccion.toString());
					System.out.println("\nAcepta sugerencia? Ingrese S o N");
					input = sc.nextLine();
					boolean band = false;
					while (band == false) {
						if (input.equals("S") || input.equals("s")) {
							this.itinerarios.add(atraccion);
							this.soloAtracciones.add(atraccion);
							itinerarioAtraccionDaoimpl.insert(atraccion.getId(),usuario.getId());
							System.out.println("Aceptada!");
							band = true;
							atraccion.usarUnCupo();
							presupuesto -= atraccion.getCosto();
							tiempoDisponible -= atraccion.getTiempo();
							atraccionDao.update(atraccion);
							System.out.println("-----------------------------------------------------\n");
						} else if (input.equals("N") || input.equals("n")) {
							System.out.println("Descartado");
							band = true;
							System.out.println("-----------------------------------------------------\n");
						} else {
							System.out.println("Intente nuevamente: Ingrese S o N");
							input = sc.nextLine();
						}
					}
				}
			}
			usuario.setPresupuesto(presupuesto);
			usuario.setTiempo_disponible(tiempoDisponible);
			usuario.setItinerario(itinerarios);
			usuario.setSoloAtracciones(soloAtracciones);
			usuarioDao.update(usuario);
			System.out.println("-----------------------------------------------------\n");
		}
	}
}
