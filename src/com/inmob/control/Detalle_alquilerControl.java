package com.inmob.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.inmob.entity.Detalle_alquiler;

public class Detalle_alquilerControl {

	private Conexion conexion;

	public Detalle_alquilerControl(Conexion conexion) {
		this.conexion = conexion;
	}

	
	public ArrayList<Detalle_alquiler> list() throws Throwable {
		ArrayList<Detalle_alquiler> Detalle_alquiler = new ArrayList<Detalle_alquiler>();
		ResultSet rs;
		int detalle_alquiler_id;
		int bien_id;
		double precio_alquiler;
		double comision;
		String seguimiento_alquiler;
		String datos_dueño;
		int agente_id;
		conexion.SQL("Select * from detalle_alquiler inner join agentes on agentes.agente_id = detalle_alquiler.agente_id inner join bienes on bienes.bien_id = detalle_alquiler.bien_id ");

		rs = conexion.resultSet();

		while (rs.next()) {
			detalle_alquiler_id = rs.getInt("detalle_alquiler_id");
			bien_id = rs.getInt("bien_id");
			precio_alquiler = rs.getDouble("precio_alquiler");
			comision = rs.getDouble("comision");
			seguimiento_alquiler = rs.getString("seguimiento_alquiler");
			datos_dueño = rs.getString("datos_dueño");
			agente_id = rs.getInt("agente_id");
			Detalle_alquiler.add(new Detalle_alquiler(detalle_alquiler_id,bien_id,precio_alquiler,comision,seguimiento_alquiler,datos_dueño,agente_id));
		}

		return Detalle_alquiler;
	}

	
	public void insert(Detalle_alquiler detalle_alquiler) throws Throwable {

		conexion.SQL("Insert into detalle_alquiler(bien_id,precio_alquiler,comision,seguimiento_alquiler,datos_dueño,agente_id) VALUES(?,?,?,?,?,?)");
		conexion.preparedStatement().setInt(1, detalle_alquiler.getBien_id());
		conexion.preparedStatement().setDouble(2, detalle_alquiler.getPrecio_alquiler());
		conexion.preparedStatement().setDouble(3, detalle_alquiler.getComision());
		conexion.preparedStatement().setString(4, detalle_alquiler.getSeguimiento_alquiler());
		conexion.preparedStatement().setString(5, detalle_alquiler.getDatos_dueño());
		conexion.preparedStatement().setInt(6, detalle_alquiler.getAgente_id());
		conexion.CUD();

	}


	public int ultimocodigo()throws Throwable {
	  
	  ResultSet rs;
	  int detalle_alquiler_id = 0;
	  conexion.SQL("Select detalle_alquiler.detalle_alquiler_id from detalle_alquiler order by detalle_alquiler_id desc limit 1");
	  rs = conexion.resultSet();
	  
	  while (rs.next()){
		  detalle_alquiler_id = rs.getInt("detalle_alquiler_id");		  
	  }
	  rs.close();
	  return detalle_alquiler_id;
	}
	

	public void search(Detalle_alquiler detalle_alquiler) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from detalle_alquiler inner join agentes on agentes.agente_id = detalle_alquiler.agente_id inner join bienes on bienes.bien_id = detalle_alquiler.bien_id where detalle_alquiler_id=?");
		conexion.preparedStatement().setInt(1, detalle_alquiler.getDetalle_alquiler_id());
		detalle_alquiler.setBien_id(0);
		detalle_alquiler.setPrecio_alquiler(0);
		detalle_alquiler.setComision(0);
		detalle_alquiler.setSeguimiento_alquiler(null);
		detalle_alquiler.setDatos_dueño(null);
		detalle_alquiler.setAgente_id(0);
		
		rs = conexion.resultSet();

		while (rs.next()) {

			detalle_alquiler.setBien_id(rs.getInt("bien_id"));
			detalle_alquiler.setPrecio_alquiler(rs.getDouble("precio_alquiler"));
			detalle_alquiler.setComision(rs.getDouble("comision"));
			detalle_alquiler.setSeguimiento_alquiler(rs.getString("seguimiento_alquiler"));
			detalle_alquiler.setDatos_dueño(rs.getString("datos_dueño"));
			detalle_alquiler.setAgente_id(rs.getInt("agente_id"));
		}
		rs.close();
	}


	public void update(Detalle_alquiler Detalle_alquiler) throws Throwable {
		int detalle_alquiler_id;
		int bien_id;
		double precio_alquiler;
		double comision;
		String seguimiento_alquiler;
		String datos_dueño;
		int agente_id;
		if (Detalle_alquiler!= null) {
			detalle_alquiler_id = Detalle_alquiler.getDetalle_alquiler_id();
			bien_id = Detalle_alquiler.getBien_id();
			precio_alquiler = Detalle_alquiler.getPrecio_alquiler();
			comision = Detalle_alquiler.getComision();
			seguimiento_alquiler = Detalle_alquiler.getSeguimiento_alquiler();
			datos_dueño = Detalle_alquiler.getDatos_dueño();
			agente_id = Detalle_alquiler.getAgente_id();
			
			conexion.SQL("Update detalle_alquiler set bien_id = ?, precio_alquiler = ?, comision = ?, seguimiento_alquiler = ?, datos_dueño = ?, agente_id = ?  where detalle_alquiler_id=?");
			conexion.preparedStatement().setInt(1, bien_id);
			conexion.preparedStatement().setDouble(2, precio_alquiler);
			conexion.preparedStatement().setDouble(3, comision);
			conexion.preparedStatement().setString(4, seguimiento_alquiler);
			conexion.preparedStatement().setString(5, datos_dueño);
			conexion.preparedStatement().setInt(6, agente_id);
			conexion.preparedStatement().setInt(7, detalle_alquiler_id);
			conexion.CUD();
		}
	}
}
