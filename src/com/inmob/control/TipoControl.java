package com.inmob.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.inmob.entity.Tipo;

public class TipoControl implements Control<Tipo> {

private Conexion conexion;
	
	public TipoControl(Conexion conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Tipo> list() throws Throwable {
		ArrayList<Tipo> Tipos = new ArrayList<Tipo>();
		ResultSet rs;
		int tipo_id;
		String tipo;
		String descripcion;
		
		conexion.SQL("Select * from tipo");

		rs = conexion.resultSet();

		while (rs.next()) {
			tipo_id = rs.getInt("tipo_id");
			tipo = rs.getString("tipo");
			descripcion = rs.getString("descripcion");
			Tipos.add(new Tipo(tipo_id,tipo,descripcion));
		}

		return Tipos;

	}

	public void insert(Tipo tipo) throws Throwable {

		conexion.SQL("Insert into Tipo(tipo_id,tipo,descripcion) VALUES(?,?,?)");
		conexion.preparedStatement().setInt(1, tipo.getTipo_id());
		conexion.preparedStatement().setString(2, tipo.getTipo());
		conexion.preparedStatement().setString(3, tipo.getDescripcion());
		conexion.CUD();

	}


	public int ultimocodigo()throws Throwable {
	 ResultSet rs;
	 int tipo_id=0;
	 conexion.SQL("Select tipo.tipo_id from tipo order by tipo_id desc limit 1");
	 rs=conexion.resultSet();
	 while (rs.next())
	 {
		 tipo_id=rs.getInt("tipo_id");
	 }
	 rs.close();
	 return tipo_id;
	}
	
	
	
	public void search(Tipo tipo) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from tipo where tipo_id=?");
		conexion.preparedStatement().setInt(1, tipo.getTipo_id());
		tipo.setTipo(null);
		tipo.setDescripcion(null);
		
		
		rs = conexion.resultSet();

		while (rs.next()) {

			tipo.setTipo(rs.getString("tipo"));
			tipo.setTipo(rs.getString("descripcion"));
		}
		rs.close();
	}

	public void update(Tipo Tipo) throws Throwable {
		int tipo_id;
		String tipo;
		String descripcion;
		if (Tipo != null) {
			tipo_id = Tipo.getTipo_id();
			tipo = Tipo.getTipo();
			descripcion = Tipo.getDescripcion();
			
			conexion.SQL("Update tipo set tipo = ?, descripcion = ? where tipo_id=?");
			conexion.preparedStatement().setString(1, tipo);
			conexion.preparedStatement().setString(2, descripcion);
			conexion.preparedStatement().setInt(3, tipo_id);
			conexion.CUD();
		}
	}	
}

