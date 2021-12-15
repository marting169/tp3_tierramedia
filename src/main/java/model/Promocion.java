package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Promocion extends Producto{
	
	protected List<Atraccion> atracciones;
	protected int id;
	private Map<String, String> errors;

	public Promocion(int id,String nombreAtraccion, double costo, double tiempo, List<Atraccion> atracciones) {
		super(nombreAtraccion, costo, tiempo);
		this.atracciones = atracciones;
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void decrementarCupos() {
		for (Atraccion atraccion : atracciones) {
			atraccion.usarUnCupo();
		}
	}

	
	public int obtenerCupoMinimo() {
		int minimo = 1000;
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getCupo() < minimo) {
				minimo = atraccion.getCupo();
			}
		}
		return minimo;
	}

	
	public List<Atraccion> obtenerAtracciones() {
		return atracciones;
	}

	public String getAtracciones() {
		String respuesta = "[";
		for (Atraccion atraccionA : atracciones) {
			respuesta = respuesta + atraccionA.getNombreAtraccion() + ", ";
		}
		respuesta = respuesta.substring(0, respuesta.length() - 2);
		return respuesta + "]";
	}

	public abstract double getConDescuento();
	
	public boolean atraccionIncluida(Atraccion nuevaAtraccion) {
		return this.atracciones.contains(nuevaAtraccion);
	}

	public boolean atraccionIncluidaEnPromocion(List<Atraccion> soloAtracciones) {
		boolean existe=false;
		int i=0;
		while(i< soloAtracciones.size() && !existe) {
			existe = this.atraccionIncluida(soloAtracciones.get(i));
			i++;
		}
		return existe;
	}
	
	public boolean esValida() {
		validar();
		return errors.isEmpty();
	}
	
	public void validar() {
		errors = new HashMap<String, String>();

		if (costo <= 0) {
			errors.put("cost", "Debe ser positivo");
		}
		if (tiempo <= 0) {
			errors.put("duration", "Debe ser positivo");
		}
		if (tiempo > 60) {
			errors.put("duration", "Excede el tiempo mÃ¡ximo");
		}
		
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public boolean canHost(int i) {
		return obtenerCupoMinimo() >= i;
	}

	
}
