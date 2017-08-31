package com.inmob.entity;

public class Tipo {

	private int tipo_id;
	
	private String tipo;
	
	private String descripcion;
	
	public Tipo(int tipo_id, String tipo, String descripcion) {
		super();
		this.tipo_id = tipo_id;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}
	
	public int getTipo_id() {
		return tipo_id;
	}
	
	public void setTipo_id(int tipo_id) {
		this.tipo_id = tipo_id;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Tipo [tipo_id=" + tipo_id + ", tipo=" + tipo + ", descripcion=" + descripcion + "]";
	}
	
}
