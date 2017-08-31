package com.inmob.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.inmob.entity.Agente;


public class AgenteControl implements Control<Agente> {
	
	private Conexion conexion;

	public AgenteControl(Conexion conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Agente> list() throws Throwable {
		ArrayList<Agente> Agentes = new ArrayList<Agente>();
		ResultSet rs;
		int agente_id;
		 String nombre;
	     String apellidos;
	     String contacto;
		 String telefono;
		
		conexion.SQL("Select * from agentes");

		rs = conexion.resultSet();

		while (rs.next()) {
			agente_id = rs.getInt("agente_id");
			nombre = rs.getString("nombre");
			apellidos = rs.getString("apellidos");
			contacto = rs.getString("contacto");
			telefono = rs.getString("telefono");
			Agentes.add(new Agente(agente_id,nombre,apellidos,contacto,telefono));
		}

		return Agentes;
	}

	public void insert(Agente agente) throws Throwable {

		conexion.SQL("Insert into Agentes(nombre,apellidos,contacto,telefono) VALUES(?,?,?,?)");
		conexion.preparedStatement().setString(1, agente.getNombre());
		conexion.preparedStatement().setString(2, agente.getApellidos());
		conexion.preparedStatement().setString(3, agente.getContacto());
		conexion.preparedStatement().setString(4, agente.getTelefono());
		conexion.CUD();

	}


	public int ultimocodigo()throws Throwable {
	  
	  ResultSet rs;
	  int agente_id = 0;
	  conexion.SQL("Select agentes.agente_id from agentes order by agente_id desc limit 1");
	  rs = conexion.resultSet();
	  
	  while (rs.next()){
		  agente_id = rs.getInt("agente_id");		  
	  }
	  rs.close();
	  return agente_id;
	}
	

	public void search(Agente agente) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from agentes where agente_id=?");
		conexion.preparedStatement().setInt(1, agente.getAgente_id());
		agente.setNombre(null);
		agente.setApellidos(null);
		agente.setContacto(null);
		agente.setTelefono(null);
		
		
		rs = conexion.resultSet();

		while (rs.next()) {

			agente.setNombre(rs.getString("nombre"));
			agente.setApellidos(rs.getString("apellidos"));
			agente.setContacto(rs.getString("contacto"));
			agente.setTelefono(rs.getString("telefono"));
		}
		rs.close();
	}

	public void update(Agente Agente) throws Throwable {
		int agente_id;
		 String nombre;
	     String apellidos;
	     String contacto;
		 String telefono;
		if (Agente != null) {
			agente_id = Agente.getAgente_id();
			nombre = Agente.getNombre();
			apellidos = Agente.getApellidos();
			contacto = Agente.getContacto();
			telefono = Agente.getTelefono();
			
			conexion.SQL("Update agentes set nombre = ?, apellidos = ?, contacto = ?, telefono = ? where agente_id=?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setString(2, apellidos);
			conexion.preparedStatement().setString(3, contacto);
			conexion.preparedStatement().setString(4, telefono);
			conexion.preparedStatement().setInt(5, agente_id);
			conexion.CUD();
		}
	}
}
