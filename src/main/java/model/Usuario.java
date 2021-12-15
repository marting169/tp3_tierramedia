package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import utils.Crypt;

public class Usuario {
	private Integer id;
	private String nombre;
	private Double presupuesto;
	private Double tiempo_disponible;
	private ArrayList<Producto> itinerario;
	private ArrayList<Atraccion> soloAtracciones;
	private String username, password;
	private Boolean admin;
	private HashMap<String, String> errors;

	public Usuario(Integer id, String nombre, Double presupuesto, Double tiempo_disponible, String username, String password, 
			Boolean admin) {
		this.id = id;
		this.nombre = nombre;
		this.setPresupuesto(presupuesto);
		this.setTiempo_disponible(tiempo_disponible);
		this.soloAtracciones = new ArrayList<Atraccion>();
		this.username = username;
		this.password = password;
		this.admin = admin;
	}
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getPresupuesto() {
		return this.presupuesto;
	}
	
	public String getUsername() {
		return username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPresupuesto(Double presupuesto) {
		if (presupuesto >= 0) {
			this.presupuesto = presupuesto;
		} else {
			throw new Error("Se ingresó un presupuesto negativo");
		}
	}

	public Double getTiempo_disponible() {
		return this.tiempo_disponible;
	}

	public void setTiempo_disponible(Double tiempo_disponible) {
		if (tiempo_disponible >= 0) {
			this.tiempo_disponible = tiempo_disponible;
		} else {
			throw new Error("Se ingresó un presupuesto negativo");
		}
	}

	public String getNombre() {
		return this.nombre;
	}

	public ArrayList<Producto> getItinerario() {
		return itinerario;
	}

	public void listarItinerarios() {
		for (Producto itinerarioA : this.itinerario) {
			System.out.println(itinerarioA.toString());
		}
	}

	public void setItinerario(ArrayList<Producto> itinerarios) {
		this.itinerario = itinerarios;
	}

	public ArrayList<Atraccion> getSoloAtracciones() {
		return soloAtracciones;
	}
	
	public boolean isNull() {
		return false;
	}
	
	public Boolean isAdmin() {
		return admin;
	}
	
	public Boolean getAdmin() {
		return admin;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	public void setPassword(String password) {
		this.password = Crypt.hash(password);
	}
	
	public boolean checkPassword(String password) {
		return Crypt.match(password, this.password);
	}

	@Override
	public String toString() {
		return "\nUSUARIO: [Nombre=" + nombre + ", Presupuesto=" + presupuesto + ", Tiempo_disponible="
				+ tiempo_disponible + "]" + "\nITINERARIO:\n" + itinerario;
	}

	public void setSoloAtracciones(ArrayList<Atraccion> soloAtracciones) {
		this.soloAtracciones = soloAtracciones;
	}
	
	public void agregarAlItinerario(Atraccion attraction) {
		this.presupuesto -= attraction.getCosto();
		this.tiempo_disponible -= attraction.getTiempo();
	}
	
	public void agregarPromoAlItinerario(Promocion promo) {
		this.presupuesto -= promo.getCosto();
		this.tiempo_disponible -= promo.getTiempo();
	}

	public boolean puedePagar(Atraccion attraction) {
		return attraction.getCosto() <= this.presupuesto;
	}

	public boolean tieneTiempo(Atraccion attraction) {
		return attraction.getTiempo() <= this.tiempo_disponible;
	}
	
	public boolean puedePagarPromo(Promocion promo) {
		return promo.getCosto() <= this.presupuesto;
	}

	public boolean tieneTiempoPromo(Promocion promo) {
		return promo.getTiempo() <= this.tiempo_disponible;
	}
	

	public boolean esValido() {
		validar();
		return errors.isEmpty();
	}
	
	public void validar() {
		errors = new HashMap<String, String>();

		if (presupuesto < 0) {
			errors.put("coins", "No debe ser negativo");
		}
		if (tiempo_disponible < 0) {
			errors.put("time", "No debe ser negativo");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}

}
