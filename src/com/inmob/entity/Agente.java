package com.inmob.entity;

public class Agente {

	private int agente_id;
	
	private String nombre;
	
	private String apellidos;
	
	private String contacto;
	
	private String telefono;
	
	public Agente(int agente_id, String nombre, String apellidos, String contacto, String telefono) {
		super();
		this.agente_id = agente_id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contacto = contacto;
		this.telefono = telefono;
	}
	
	public int getAgente_id() {
		return agente_id;
	}
	
	public void setAgente_id(int agente_id) {
		this.agente_id = agente_id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getContacto() {
		return contacto;
	}
	
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Agente [agente_id=" + agente_id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", contacto="
				+ contacto + ", telefono=" + telefono + "]";
	}
	
}
