package com.inmob.entity;

public class Detalle_alquiler {

	private int detalle_alquiler_id;
	
	private int bien_id;
		
	private double precio_alquiler;
	
	private double comision;
	
	private String seguimiento_alquiler;
	
	private String datos_dueño;
	
	private int agente_id;
	
	public Detalle_alquiler(int detalle_alquiler_id, int bien_id, double precio_alquiler, double comision,
			String seguimiento_alquiler, String datos_dueño, int agente_id) {
		super();
		this.detalle_alquiler_id = detalle_alquiler_id;
		this.bien_id = bien_id;
		this.precio_alquiler = precio_alquiler;
		this.comision = comision;
		this.seguimiento_alquiler = seguimiento_alquiler;
		this.datos_dueño = datos_dueño;
		this.agente_id = agente_id;
	}
	
		
		
	public int getDetalle_alquiler_id() {
		return detalle_alquiler_id;
	}



	public void setDetalle_alquiler_id(int detalle_alquiler_id) {
		this.detalle_alquiler_id = detalle_alquiler_id;
	}



	public int getBien_id() {
		return bien_id;
	}



	public void setBien_id(int bien_id) {
		this.bien_id = bien_id;
	}



	public double getPrecio_alquiler() {
		return precio_alquiler;
	}



	public void setPrecio_alquiler(double precio_alquiler) {
		this.precio_alquiler = precio_alquiler;
	}



	public double getComision() {
		return comision;
	}



	public void setComision(double comision) {
		this.comision = comision;
	}



	public String getSeguimiento_alquiler() {
		return seguimiento_alquiler;
	}



	public void setSeguimiento_alquiler(String seguimiento_alquiler) {
		this.seguimiento_alquiler = seguimiento_alquiler;
	}



	public String getDatos_dueño() {
		return datos_dueño;
	}



	public void setDatos_dueño(String datos_dueño) {
		this.datos_dueño = datos_dueño;
	}



	public int getAgente_id() {
		return agente_id;
	}



	public void setAgente_id(int agente_id) {
		this.agente_id = agente_id;
	}



	@Override
	public String toString() {
		return "Detalle_alquiler [detalle_alquiler_id=" + detalle_alquiler_id + ", bien_id=" + bien_id
				+ ", precio_alquiler=" + precio_alquiler + ", comision=" + comision + ", seguimiento_alquiler="
				+ seguimiento_alquiler + ", datos_dueño=" + datos_dueño + ", agente_id=" + agente_id + "]";
	}
	
}
