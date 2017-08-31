package com.inmob.entity;

import java.util.Date;

public class Contrato_venta {

	private int codigo_contrato_venta;
	private double precio_venta_final;
	private int detalle_venta_id;
	private String nombre_comrador;
	private String telefono_cmprador;
	private String CI_cliente;
	private String referencias;
	private String detalles_pago;
	private Date fecha_venta;
	public Contrato_venta(int codigo_contrato_venta, double precio_venta_final, int detalle_venta_id,
			String nombre_comrador, String telefono_cmprador, String cI_cliente, String referencias,
			String detalles_pago, Date fecha_venta) {
		super();
		this.codigo_contrato_venta = codigo_contrato_venta;
		this.precio_venta_final = precio_venta_final;
		this.detalle_venta_id = detalle_venta_id;
		this.nombre_comrador = nombre_comrador;
		this.telefono_cmprador = telefono_cmprador;
		CI_cliente = cI_cliente;
		this.referencias = referencias;
		this.detalles_pago = detalles_pago;
		this.fecha_venta = fecha_venta;
	}

	
	public int getCodigo_contrato_venta() {
		return codigo_contrato_venta;
	}


	public void setCodigo_contrato_venta(int codigo_contrato_venta) {
		this.codigo_contrato_venta = codigo_contrato_venta;
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


	public String getNombre_comrador() {
		return nombre_comrador;
	}


	public void setNombre_comrador(String nombre_comrador) {
		this.nombre_comrador = nombre_comrador;
	}


	public String getTelefono_cmprador() {
		return telefono_cmprador;
	}


	public void setTelefono_cmprador(String telefono_cmprador) {
		this.telefono_cmprador = telefono_cmprador;
	}


	public String getCI_cliente() {
		return CI_cliente;
	}


	public void setCI_cliente(String cI_cliente) {
		CI_cliente = cI_cliente;
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
		return "Contrato_venta [codigo_contrato_venta=" + codigo_contrato_venta + ", precio_venta_final="
				+ precio_venta_final + ", detalle_venta_id=" + detalle_venta_id + ", nombre_comrador=" + nombre_comrador
				+ ", telefono_cmprador=" + telefono_cmprador + ", CI_cliente=" + CI_cliente + ", referencias="
				+ referencias + ", detalles_pago=" + detalles_pago + ", fecha_venta=" + fecha_venta + "]";
	}
	
	
}
