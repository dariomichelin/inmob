package com.inmob.entity;

import java.util.Date;

public class Contrato_venta {

	private int contrato_id;
	private double precio_venta_final;
	private int detalle_venta_id;
	private String nombre_comprador;
	private String telefono_comprador;
	private String CI_comprador;
	private String referencias;
	private String detalles_pago;
	private Date fecha_venta;
	public Contrato_venta(int contrato_id, double precio_venta_final, int detalle_venta_id,
			String nombre_comprador, String telefono_comprador,  String referencias,String CI_comprador,
			String detalles_pago, Date fecha_venta) {
		super();
		this.contrato_id = contrato_id;
		this.precio_venta_final = precio_venta_final;
		this.detalle_venta_id = detalle_venta_id;
		this.nombre_comprador = nombre_comprador;
		this.telefono_comprador = telefono_comprador;
		this.CI_comprador = CI_comprador;
		this.referencias = referencias;
		this.detalles_pago = detalles_pago;
		this.fecha_venta = fecha_venta;
	}

	
	public int getContrato_id() {
		return contrato_id;
	}


	public void setContrato_id(int contrato_id) {
		this.contrato_id = contrato_id;
	}


	public double getPrecio_venta_final() {
		return precio_venta_final;
	}


	public void setPrecio_venta_final(double precio_venta_final) {
		this.precio_venta_final = precio_venta_final;
	}


	public int getDetalle_venta_id() {
		return detalle_venta_id;
	}


	public void setDetalle_venta_id(int detalle_venta_id) {
		this.detalle_venta_id = detalle_venta_id;
	}


	public String getNombre_comprador() {
		return nombre_comprador;
	}


	public void setNombre_comprador(String nombre_comprador) {
		this.nombre_comprador = nombre_comprador;
	}


	public String getTelefono_comprador() {
		return telefono_comprador;
	}


	public void setTelefono_comprador(String telefono_comprador) {
		this.telefono_comprador = telefono_comprador;
	}


	public String getCI_comprador() {
		return CI_comprador;
	}


	public void setCI_comprador(String CI_comprador) {
		this.CI_comprador = CI_comprador;
	}


	public String getReferencias() {
		return referencias;
	}


	public void setReferencias(String referencias) {
		this.referencias = referencias;
	}


	public String getDetalles_pago() {
		return detalles_pago;
	}


	public void setDetalles_pago(String detalles_pago) {
		this.detalles_pago = detalles_pago;
	}


	public Date getFecha_venta() {
		return fecha_venta;
	}


	public void setFecha_venta(Date fecha_venta) {
		this.fecha_venta = fecha_venta;
	}


	@Override
	public String toString() {
		return "Contrato_venta [contrato_id=" + contrato_id + ", precio_venta_final="
				+ precio_venta_final + ", detalle_venta_id=" + detalle_venta_id + ", nombre_comprador=" + nombre_comprador
				+ ", telefono_comprador=" + telefono_comprador + ", CI_comprador=" + CI_comprador + ", referencias="
				+ referencias + ", detalles_pago=" + detalles_pago + ", fecha_venta=" + fecha_venta + "]";
	}
	
	
}
