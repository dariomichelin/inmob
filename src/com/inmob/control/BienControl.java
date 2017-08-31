package com.inmob.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.inmob.entity.Bien;

public class BienControl implements Control<Bien> {

private Conexion conexion;
	
	public BienControl(Conexion conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Bien> list() throws Throwable {
		ArrayList<Bien> Bienes = new ArrayList<Bien>();
		ResultSet rs;
		int bien_id;
		int tipo_id;
		String direccion;
		String descripcion;
		boolean disponibilidad;
		
		conexion.SQL("Select * from bienes inner join tipo on tipo.tipo_id=bienes.tipo_id");

		rs = conexion.resultSet();

		while (rs.next()) {
			bien_id = rs.getInt("bien_id");
			tipo_id = rs.getInt("tipo_id");
			direccion = rs.getString("direccion");
			descripcion = rs.getString("descripcion");
			disponibilidad=true;
			Bienes.add(new Bien(bien_id,tipo_id,direccion,descripcion,disponibilidad));
		}

		return Bienes;

	}

	public void insert(Bien bien) throws Throwable {

		conexion.SQL("Insert into bienes(tipo_id,direccion,descripcion,disponibilidad) VALUES(?,?,?,?)");
		conexion.preparedStatement().setInt(1, bien.getTipo_id());
		conexion.preparedStatement().setString(2, bien.getDireccion());
		conexion.preparedStatement().setString(3, bien.getDescripcion());
		conexion.preparedStatement().setBoolean(4, bien.isDisponibilidad());
		conexion.CUD();

	}


	public int ultimocodigo()throws Throwable {
	 ResultSet rs;
	 int bien_id=0;
	 conexion.SQL("Select bienes.bien_id from bienes order by bien_id desc limit 1");
	 rs=conexion.resultSet();
	 while (rs.next())
	 {
		 bien_id=rs.getInt("bien_id");
	 }
	 rs.close();
	 return bien_id;
	}
	
	
	
	public void search(Bien bien) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from bienes where bien_id=?");
		conexion.preparedStatement().setInt(1, bien.getBien_id());
		bien.setTipo_id(0);
		bien.setDireccion(null);
		bien.setDescripcion(null);
		bien.setDisponibilidad(true);
		
		rs = conexion.resultSet();

		while (rs.next()) {

			bien.setTipo_id(rs.getInt("tipo_id"));
			bien.setDireccion(rs.getString("direccion"));
			bien.setDescripcion(rs.getString("descripcion"));
			bien.setDisponibilidad(rs.getBoolean("disponibilidad"));
		}
		rs.close();
	}

	public void update(Bien bien) throws Throwable {
		int bien_id;
		int tipo_id;
		String direccion;
		String descripcion;
		boolean disponibilidad;
		if (bien != null) {
			bien_id = bien.getTipo_id();
			tipo_id = bien.getTipo_id();
			direccion = bien.getDireccion();
			descripcion = bien.getDescripcion();
			disponibilidad=bien.isDisponibilidad();
			
			conexion.SQL("Update bienes set tipo_id = ?, direccion = ?, descripcion = ?, disponibilidad = ? where bien_id=?");
			conexion.preparedStatement().setInt(1, tipo_id);
			conexion.preparedStatement().setString(2, direccion);
			conexion.preparedStatement().setString(3, descripcion);
			conexion.preparedStatement().setBoolean(4, disponibilidad);
			conexion.preparedStatement().setInt(3, bien_id);
			conexion.CUD();
		}
	}	
}
