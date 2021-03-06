package com.inmob.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.inmob.entity.Contrato_alquiler;

public class ContratoAlquilerControl implements Control<Contrato_alquiler> {

private Conexion conexion;
	public ContratoAlquilerControl(Conexion conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Contrato_alquiler> list() throws Throwable {
		ArrayList<Contrato_alquiler> Contratos = new ArrayList<Contrato_alquiler>();
		ResultSet rs;
		int contrato_id;
		double precio_alquiler_final;
		int detalle_alquiler_id;
		String nombre_inquilino;
		String telefono_inquilino;
		String referencias;
		int CI_inquilino;
		String detalles_pago;
		java.sql.Date fecha_inicio;
		java.sql.Date fecha_fin;
		
		conexion.SQL("Select * from contrato_alquiler inner join detalle_alquiler on detalle_alquiler.detalle_alquiler_id=contrato_alquiler.detalle_alquiler_id");

		rs = conexion.resultSet();

		while (rs.next()) {
			contrato_id=rs.getInt("contrato_id");
			precio_alquiler_final=rs.getDouble("precio_alquiler_final");
			detalle_alquiler_id=rs.getInt("detalle_alquiler_id");
			nombre_inquilino=rs.getString("nombre_inquilino");
			telefono_inquilino=rs.getString("telefono_inquilino");
			referencias=rs.getString("referencias");
			CI_inquilino=rs.getInt("CI_inquilino");
			detalles_pago=rs.getString("detalles_pago");
			fecha_inicio=rs.getDate("fecha_inicio");
			fecha_fin=rs.getDate("fecha_fin");
			Contratos.add(new Contrato_alquiler(contrato_id,precio_alquiler_final,detalle_alquiler_id,nombre_inquilino,telefono_inquilino,referencias,CI_inquilino,detalles_pago,fecha_inicio,fecha_fin));
		}

		return Contratos;

	}


	public void insert(Contrato_alquiler contrato_alq) throws Throwable {

		conexion.SQL("Insert into contrato_alquiler(precio_alquiler_final,detalle_alquiler_id,nombre_inquilino,telefono_inquilino,referencias,CI_inquilino,detalles_pago,fecha_inicio,fecha_fin) VALUES(?,?,?,?,?,?,?,?,?)");
		conexion.preparedStatement().setDouble(1, contrato_alq.getPrecio_alquiler_final());
		conexion.preparedStatement().setInt(2, contrato_alq.getDetalle_alquiler_id());
		conexion.preparedStatement().setString(3, contrato_alq.getNombre_inquilino());
		conexion.preparedStatement().setString(4, contrato_alq.getTelefono_inquilino());
		conexion.preparedStatement().setString(5, contrato_alq.getReferencias());
		conexion.preparedStatement().setInt(6, contrato_alq.getCI_inquilino());
		conexion.preparedStatement().setString(7, contrato_alq.getDetalles_pago());

		conexion.preparedStatement().setDate(8, sqlDate(contrato_alq.getFecha_inicio())) ;
		conexion.preparedStatement().setDate(9, sqlDate(contrato_alq.getFecha_inicio()));
		conexion.CUD();
		

	}

	@SuppressWarnings("deprecation")
	public java.sql.Date sqlDate (Date date) 
	{
		int year = date.getYear();
		int month = date.getMonth();
		int day =date.getDay();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, day);

		java.sql.Date sqldate = new java.sql.Date(cal.getTimeInMillis());
		return sqldate;
	}

	public int ultimocodigo()throws Throwable {
	 ResultSet rs;
	 int contrato_id=0;
	 conexion.SQL("Select contrato_alquiler.contrato_id from contrato_alquiler order by contrato_id desc limit 1");
	 rs=conexion.resultSet();
	 while (rs.next())
	 {
		 contrato_id=rs.getInt("contrato_id");
	 }
	 rs.close();
	 return contrato_id;
	}
	
	
	
	public void search(Contrato_alquiler contrato) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from contrato_alquiler where contrato_id=?");
		conexion.preparedStatement().setInt(1, contrato.getContrato_id());
		contrato.setPrecio_alquiler_final(0);
		contrato.setDetalle_alquiler_id(0);
		contrato.setNombre_inquilino(null);
		contrato.setTelefono_inquilino(null);
		contrato.setReferencias(null);
		contrato.setCI_inquilino(0);
		contrato.setDetalles_pago(null);
		contrato.setFecha_inicio(null);
		contrato.setFecha_fin(null);
		
		rs = conexion.resultSet();

		while (rs.next()) {
			contrato.setPrecio_alquiler_final(rs.getDouble("precio_alquiler_final"));
			contrato.setDetalle_alquiler_id(rs.getInt("detalle_alquiler_id"));
			contrato.setNombre_inquilino(rs.getString("nombre_inquilino"));
			contrato.setTelefono_inquilino(rs.getString("telefono_inquilino"));
			contrato.setReferencias(rs.getString("referencias"));
			contrato.setCI_inquilino(rs.getInt("CI_inquilino"));
			contrato.setDetalles_pago(rs.getString("detalles_pago"));
			contrato.setFecha_inicio(rs.getDate("fecha_inicio"));
			contrato.setFecha_fin(rs.getDate("fecha_fin"));
		}
		rs.close();
	}

	public void update(Contrato_alquiler contrato) throws Throwable {
		int contrato_id;
		double precio_alquiler_final;
		int detalle_alquiler_id;
		String nombre_inquilino;
		String telefono_inquilino;
		String referencias;
		int CI_inquilino;
		String detalles_pago;
		Date fecha_inicio;
		Date fecha_fin;
		if (contrato != null) {
			contrato_id=contrato.getContrato_id();
			precio_alquiler_final=contrato.getPrecio_alquiler_final();
			detalle_alquiler_id=contrato.getDetalle_alquiler_id();
			nombre_inquilino=contrato.getNombre_inquilino();
			telefono_inquilino=contrato.getTelefono_inquilino();
			referencias=contrato.getReferencias();
			CI_inquilino=contrato.getCI_inquilino();
			detalles_pago=contrato.getDetalles_pago();
			fecha_inicio=contrato.getFecha_inicio();
			fecha_fin=contrato.getFecha_fin();
			
			conexion.SQL("Update contrato_alquiler set precio_alquiler_final=?, detalle_alquiler_id=?, nombre_inquilino=?, telefono_inquilino=?, referencias=?, CI_inquilino=?, detalles_pago=?, fecha_inicio=?, fecha_fin=? where contrato_id=?");
			conexion.preparedStatement().setInt(10, contrato_id);
			conexion.preparedStatement().setDouble(1, precio_alquiler_final);
			conexion.preparedStatement().setInt(2, detalle_alquiler_id);
			conexion.preparedStatement().setString(3, nombre_inquilino);
			conexion.preparedStatement().setString(4, telefono_inquilino);
			conexion.preparedStatement().setString(5, referencias);
			conexion.preparedStatement().setInt(6, CI_inquilino);
			conexion.preparedStatement().setString(7, detalles_pago);
			conexion.preparedStatement().setDate(8, sqlDate(fecha_inicio));
			conexion.preparedStatement().setDate(9, sqlDate(fecha_fin));
			conexion.CUD();
		}
	}	
}
