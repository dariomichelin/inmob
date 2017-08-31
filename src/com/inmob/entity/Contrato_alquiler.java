package com.inmob.entity;
import java.util.Date;
public class Contrato_alquiler {
	
	private int contrato_id;
	private double precio_alquiler_final;
	private int detalle_alquiler_id;
	private String nombre_inquilino;
	private String telefono_inquilino;
	private String referencias;
	private int CI_inquilino;
	private String detalles_pago;
	private Date fecha_inicio;
	private Date fecha_fin;
	public Contrato_alquiler(int contrato_id, double precio_alquiler_final, int detalle_alquiler_id,
			String nombre_inquilino, String telefono_inquilino, String referencias, int cI_inquilino,
			String detalles_pago, Date fecha_inicio, Date fecha_fin) {
		super();
		this.contrato_id = contrato_id;
		this.precio_alquiler_final = precio_alquiler_final;
		this.detalle_alquiler_id = detalle_alquiler_id;
		this.nombre_inquilino = nombre_inquilino;
		this.telefono_inquilino = telefono_inquilino;
		this.referencias = referencias;
		CI_inquilino = cI_inquilino;
		this.detalles_pago = detalles_pago;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}
	
	
	public int getContrato_id() {
		return contrato_id;
	}


	public void setContrato_id(int contrato_id) {
		this.contrato_id = contrato_id;
	}


	public double getPrecio_alquiler_final() {
		return precio_alquiler_final;
	}


	public void setPrecio_alquiler_final(double precio_alquiler_final) {
		this.precio_alquiler_final = precio_alquiler_final;
	}


	public int getDetalle_alquiler_id() {
		return detalle_alquiler_id;
	}


	public void setDetalle_alquiler_id(int detalle_alquiler_id) {
		this.detalle_alquiler_id = detalle_alquiler_id;
	}


	public String getNombre_inquilino() {
		return nombre_inquilino;
	}


	public void setNombre_inquilino(String nombre_inquilino) {
		this.nombre_inquilino = nombre_inquilino;
	}


	public String getTelefono_inquilino() {
		return telefono_inquilino;
	}


	public void setTelefono_inquilino(String telefono_inquilino) {
		this.telefono_inquilino = telefono_inquilino;
	}


	public String getReferencias() {
		return referencias;
	}


	public void setReferencias(String referencias) {
		this.referencias = referencias;
	}


	public int getCI_inquilino() {
		return CI_inquilino;
	}


	public void setCI_inquilino(int cI_inquilino) {
		CI_inquilino = cI_inquilino;
	}


	public String getDetalles_pago() {
		return detalles_pago;
	}


	public void setDetalles_pago(String detalles_pago) {
		this.detalles_pago = detalles_pago;
	}


	public Date getFecha_inicio() {
		return fecha_inicio;
	}


	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}


	public Date getFecha_fin() {
		return fecha_fin;
	}


	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}


	@Override
	public String toString() {
		return "Contrato_alquiler [contrato_id=" + contrato_id + ", precio_alquiler_final=" + precio_alquiler_final
				+ ", detalle_alquiler_id=" + detalle_alquiler_id + ", nombre_inquilino=" + nombre_inquilino
				+ ", telefono_inquilino=" + telefono_inquilino + ", referencias=" + referencias + ", CI_inquilino="
				+ CI_inquilino + ", detalles_pago=" + detalles_pago + ", fecha_inicio=" + fecha_inicio + ", fecha_fin="
				+ fecha_fin + "]";
	}
	
}
