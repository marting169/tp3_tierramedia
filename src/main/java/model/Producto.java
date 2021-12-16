package model;

public abstract class Producto {
	
	protected String nombre;
	protected double costo;
	protected double tiempo;
	
	public Producto(String nombre, double costo, double tiempo) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
	}
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		if(costo>=0) {
		this.costo = costo;
		}else {
			throw new Error("Se ingresó un costo negativo");
		}
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

}
