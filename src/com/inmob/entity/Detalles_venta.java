package com.inmob.entity;

public class Detalles_venta {

	private int detalle_venta_id;
	private int bien_id;
	private double precio_venta;
	private double comision;
	private String seguimiento_venta;
	private int agente_id;
	public Detalles_venta(int detalle_venta_id, int bien_id, double precio_venta, double comision,
			String seguimiento_venta, int agente_id) {
		super();
		this.detalle_venta_id = detalle_venta_id;
		this.bien_id = bien_id;
		this.precio_venta = precio_venta;
		this.comision = comision;
		this.seguimiento_venta = seguimiento_venta;
		this.agente_id = agente_id;
	}
	
	
	public int getDetalle_venta_id() {
		return detalle_venta_id;
	}


	public void setDetalle_venta_id(int detalle_venta_id) {
		this.detalle_venta_id = detalle_venta_id;
	}


	public int getBien_id() {
		return bien_id;
	}


	public void setBien_id(int bien_id) {
		this.bien_id = bien_id;
	}


	public double getPrecio_venta() {
		return precio_venta;
	}


	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}


	public double getComision() {
		return comision;
	}


	public void setComision(double comision) {
		this.comision = comision;
	}


	public String getSeguimiento_venta() {
		return seguimiento_venta;
	}


	public void setSeguimiento_venta(String seguimiento_venta) {
		this.seguimiento_venta = seguimiento_venta;
	}


	public int getAgente_id() {
		return agente_id;
	}


	public void setAgente_id(int agente_id) {
		this.agente_id = agente_id;
	}


	@Override
	public String toString() {
		return "Detalles_venta [detalle_venta_id=" + detalle_venta_id + ", bien_id=" + bien_id + ", precio_venta="
				+ precio_venta + ", comision=" + comision + ", seguimiento_venta=" + seguimiento_venta + ", agente_id="
				+ agente_id + "]";
	}
	
	
}
