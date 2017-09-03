package com.inmob.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.inmob.entity.Detalles_venta;

public class Detalles_ventaControl {

	private Conexion conexion;

	public Detalles_ventaControl(Conexion conexion) {
		this.conexion = conexion;
	}

	
	public ArrayList<Detalles_venta> list() throws Throwable {
		ArrayList<Detalles_venta> Detalles_venta = new ArrayList<Detalles_venta>();
		ResultSet rs;
		int detalle_venta_id;
		int bien_id;
		double precio_venta;
		double comision;
		String seguimiento_venta;
		int agente_id;
		conexion.SQL("Select * from detalles_venta inner join agentes on agentes.agente_id = detalles_venta.agente_id inner join bienes on bienes.bien_id = detalles_venta.bien_id ");

		rs = conexion.resultSet();

		while (rs.next()) {
			detalle_venta_id = rs.getInt("detalle_venta_id");
			bien_id = rs.getInt("bien_id");
			precio_venta = rs.getDouble("precio_venta");
			comision = rs.getDouble("comision");
			seguimiento_venta = rs.getString("seguimiento_venta");
			agente_id = rs.getInt("agente_id");
			Detalles_venta.add(new Detalles_venta(detalle_venta_id,bien_id,precio_venta,comision,seguimiento_venta,agente_id));
		}

		return Detalles_venta;
	}

	
	public void insert(Detalles_venta detalles_venta) throws Throwable {

		conexion.SQL("Insert into detalles_venta(bien_id,precio_venta,comision,seguimiento_venta,agente_id) VALUES(?,?,?,?,?)");
		conexion.preparedStatement().setInt(1, detalles_venta.getBien_id());
		conexion.preparedStatement().setDouble(2, detalles_venta.getPrecio_venta());
		conexion.preparedStatement().setDouble(3, detalles_venta.getComision());
		conexion.preparedStatement().setString(4, detalles_venta.getSeguimiento_venta());
		conexion.preparedStatement().setInt(5, detalles_venta.getAgente_id());
		conexion.CUD();

	}


	public int ultimocodigo()throws Throwable {
	  
	  ResultSet rs;
	  int detalle_venta_id = 0;
	  conexion.SQL("Select detalles_venta.detalle_venta_id from detalles_venta order by detalle_venta_id desc limit 1");
	  rs = conexion.resultSet();
	  
	  while (rs.next()){
		  detalle_venta_id = rs.getInt("detalle_venta_id");		  
	  }
	  rs.close();
	  return detalle_venta_id;
	}
	

	public void search(Detalles_venta detalles_venta) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from detalles_venta inner join agentes on agentes.agente_id = detalles_venta.agente_id inner join bienes on bienes.bien_id = detalles_venta.bien_id where detalle_venta_id=?");
		conexion.preparedStatement().setInt(1, detalles_venta.getDetalle_venta_id());
		detalles_venta.setBien_id(0);
		detalles_venta.setPrecio_venta(0);
		detalles_venta.setComision(0);
		detalles_venta.setSeguimiento_venta(null);
		detalles_venta.setAgente_id(0);
		
		rs = conexion.resultSet();

		while (rs.next()) {

			detalles_venta.setBien_id(rs.getInt("bien_id"));
			detalles_venta.setPrecio_venta(rs.getDouble("precio_venta"));
			detalles_venta.setComision(rs.getDouble("comision"));
			detalles_venta.setSeguimiento_venta(rs.getString("seguimiento_venta"));
			detalles_venta.setAgente_id(rs.getInt("agente_id"));
		}
		rs.close();
	}


	public void update(Detalles_venta Detalles_venta) throws Throwable {
		int detalle_venta_id;
		int bien_id;
		double precio_venta;
		double comision;
		String seguimiento_venta;
		int agente_id;
		if (Detalles_venta!= null) {
			detalle_venta_id = Detalles_venta.getDetalle_venta_id();
			bien_id = Detalles_venta.getBien_id();
			precio_venta = Detalles_venta.getPrecio_venta();
			comision = Detalles_venta.getComision();
			seguimiento_venta = Detalles_venta.getSeguimiento_venta();
			agente_id = Detalles_venta.getAgente_id();
			
			conexion.SQL("Update detalles_alquiler set bien_id = ?, precio_venta = ?, comsion = ?, seguimiento_venta = ?, agente_id = ?  where detalle_venta_id=?");
			conexion.preparedStatement().setInt(1, bien_id);
			conexion.preparedStatement().setDouble(2, precio_venta);
			conexion.preparedStatement().setDouble(3, comision);
			conexion.preparedStatement().setString(4, seguimiento_venta);
			conexion.preparedStatement().setInt(6, agente_id);
			conexion.preparedStatement().setInt(7, detalle_venta_id);
			conexion.CUD();
		}
	}
}


