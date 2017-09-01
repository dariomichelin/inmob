package com.inmob.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.inmob.entity.Contrato_alquiler;
import com.inmob.entity.Contrato_venta;

public class ContratoVentaControl implements Control<Contrato_venta> {

private Conexion conexion;
	
	public ContratoVentaControl(Conexion conexion) {
		this.conexion = conexion;
	}
//marcelo777
	public ArrayList<Contrato_venta> list() throws Throwable {
		ArrayList<Contrato_venta> Contratos = new ArrayList<Contrato_venta>();
		ResultSet rs;
		int contrato_id;
		double precio_venta_final;
		int detalle_venta_id;
		String nombre_comprador;
		String telefono_comprador;
		String CI_comprador;
		String referencias;
		String detalles_pago;
		Date fecha_venta;
		
		conexion.SQL("Select * from contrato_venta inner join detalle_venta on detalle_venta.detalle_venta_id=contrato_venta.detalle_venta_id");

		rs = conexion.resultSet();

		while (rs.next()) {
			contrato_id=rs.getInt("contrato_id");
			precio_venta_final=rs.getDouble("precio_venta_final");
			detalle_venta_id=rs.getInt("detalle_venta_id");
			nombre_comprador=rs.getString("nombre_inquilino");
			telefono_comprador=rs.getString("telefono");
			referencias=rs.getString("referencias");
			CI_comprador=rs.getString("CI_comprador");
			detalles_pago=rs.getString("detalles_pago");
			fecha_venta=rs.getDate("fecha_venta");
			
			Contratos.add(new Contrato_venta(contrato_id,precio_venta_final,detalle_venta_id,nombre_comprador,telefono_comprador,referencias,CI_comprador,detalles_pago,fecha_venta));
		}

		return Contratos;

	}

	public void insert(Contrato_venta contrato_alq) throws Throwable {

		conexion.SQL("Insert into contrato_venta(precio_venta_final,detalle_venta_id,nombre_comprador,telefono_comprador,referencias,CI_comprador,detalles_pago,fecha_venta) VALUES(?,?,?,?,?,?,?,?)");
		conexion.preparedStatement().setDouble(1, contrato_alq.getPrecio_venta_final());
		conexion.preparedStatement().setInt(2, contrato_alq.getDetalle_venta_id());
		conexion.preparedStatement().setString(3, contrato_alq.getNombre_comprador());
		conexion.preparedStatement().setString(4, contrato_alq.getTelefono_comprador());
		conexion.preparedStatement().setString(5, contrato_alq.getReferencias());
		conexion.preparedStatement().setString(6, contrato_alq.getCI_comprador());
		conexion.preparedStatement().setString(3, contrato_alq.getDetalles_pago());
		conexion.preparedStatement().setDate(8, (java.sql.Date) contrato_alq.getFecha_venta());
		conexion.CUD();

	}


	public int ultimocodigo()throws Throwable {
	 ResultSet rs;
	 int contrato_id=0;
	 conexion.SQL("Select contrato_venta.contrato_id from contrato_venta order by contrato_id desc limit 1");
	 rs=conexion.resultSet();
	 while (rs.next())
	 {
		contrato_id=rs.getInt("contrato_id");
	 }
	 rs.close();
	 return contrato_id;
	}
	
	
	
	public void search(Contrato_venta contrato) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from contrato_venta where codigo_contrato_id=?");
		conexion.preparedStatement().setInt(1, contrato.getContrato_id());
		contrato.setPrecio_venta_final(0);
		contrato.setDetalle_venta_id(0);
		contrato.setNombre_comprador(null);
		contrato.setTelefono_comprador(null);
		contrato.setReferencias(null);
		contrato.setCI_comprador(null);
		contrato.setDetalles_pago(null);
		contrato.setFecha_venta(null);
		
		rs = conexion.resultSet();

		while (rs.next()) {
			contrato.setPrecio_venta_final(rs.getDouble("precio_alquiler_final"));
			contrato.setDetalle_venta_id(rs.getInt("detalle_venta_id"));
			contrato.setNombre_comprador(rs.getString("nombre_comprador"));
			contrato.setTelefono_comprador(rs.getString("telefono_comprador"));
			contrato.setReferencias(rs.getString("referencias"));
			contrato.setCI_comprador(rs.getString("CI_comprador"));
			contrato.setDetalles_pago(rs.getString("detalles_pago"));
			contrato.setFecha_venta(rs.getDate("fecha_venta"));
			}
		rs.close();
	}

	public void update(Contrato_venta contrato) throws Throwable {
		int contrato_id;
		double precio_venta_final;
		int detalle_venta_id;
		String nombre_comprador;
		String telefono_comprador;
		String referencias;
		String CI_comprador;
		String detalles_pago;
		Date fecha_venta;
		if (contrato != null) {
			contrato_id=contrato.getContrato_id();
			precio_venta_final=contrato.getPrecio_venta_final();
			detalle_venta_id=contrato.getDetalle_venta_id();
			nombre_comprador=contrato.getNombre_comprador();
			telefono_comprador=contrato.getTelefono_comprador();
			referencias=contrato.getReferencias();
			CI_comprador=contrato.getCI_comprador();
			detalles_pago=contrato.getDetalles_pago();
			fecha_venta=contrato.getFecha_venta();
			
			conexion.SQL("Update contrato_venta set precio_alquiler_final=?, detalle_alquiler_final=?, nombre_inquilino=?, telefono=?, referencias=?, CI_inquilino=?, detalles_pago=?, fecha_inicio=?, fecha_fin=? where contrato_id=?");
			conexion.preparedStatement().setInt(1, contrato_id);
			conexion.preparedStatement().setDouble(2, precio_venta_final);
			conexion.preparedStatement().setInt(3, detalle_venta_id);
			conexion.preparedStatement().setString(4, nombre_comprador);
			conexion.preparedStatement().setString(5, telefono_comprador);
			conexion.preparedStatement().setString(6, referencias);
			conexion.preparedStatement().setString(7, CI_comprador);
			conexion.preparedStatement().setString(8, detalles_pago);
			conexion.preparedStatement().setDate(9, (java.sql.Date) fecha_venta);
			conexion.CUD();
		}
	}

		
	}