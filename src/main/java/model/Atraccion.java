package model;

import java.util.HashMap;
import java.util.Map;

public class Atraccion extends Producto {

	protected Integer cupo;
	protected Integer id;
	private Map<String, String> errors;
	
	
	public Atraccion(String nombre, Double costo, Double tiempo, Integer cupo) {
		super(nombre, costo, tiempo);
		this.cupo = cupo;
	}
	
	public Atraccion(Integer id, String nombre, Double costo, Double tiempo, Integer cupo) {
		super(nombre, costo, tiempo);
		this.setCupo(cupo);
		this.setId(id);
	}
	
	

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		if (cupo >=0) {
			this.cupo = cupo;
		} else {
			throw new Error("Se ingresó un cupo negativo");
		}
	}

	public void usarUnCupo() {
		this.cupo--;
	}

	
	
	public void setId(int id) {
		this.id = id;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "\nAtraccion" + "\n-Nombre [" + nombre + "]" + "\n-Precio: $" + costo + "\n-Duracion: " + tiempo
				+ " horas";
	}

	public String toString2() {
		return nombre + " ";
	}

	public Integer getId() {
		return this.id;
	}
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
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
		if (cupo <= 0) {
			errors.put("capacity", "Debe ser positivo");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public boolean canHost(int i) {
		return cupo >= i;
	}

	public void host(int i) {
		this.cupo -= i;
	}
}
