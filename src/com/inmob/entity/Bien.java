package com.inmob.entity;

public class Bien {
	private int bien_id;
		
	private int tipo_id;
	
	private String direccion;
	
	private String descripcion;
	
	private boolean disponibilidad;
	
	private Tipo tipo;
	

	public Bien(int bien_id, int tipo_id, String direccion,
			String descripcion, boolean disponibilidad) {
		
		//super();
		this.bien_id = bien_id;
		this.tipo_id = tipo_id;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.disponibilidad = disponibilidad;
	}

	
	public int getBien_id() {
		return bien_id;
	}


	public void setBien_id(int bien_id) {
		this.bien_id = bien_id;
	}


	public int getTipo_id() {
		return tipo_id;
	}


	public void setTipo_id(int tipo_id) {
		this.tipo_id = tipo_id;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public boolean isDisponibilidad() {
		return disponibilidad;
	}


	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}


	@Override
	public String toString() {
		return "Bien [bien_id=" + bien_id + ", tipo_id=" + tipo_id + ", direccion="
				+ direccion + ", descripcion=" + descripcion + ", disponibilidad=" + disponibilidad + "]";
	}
	
}
