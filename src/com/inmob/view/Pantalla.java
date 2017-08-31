package com.inmob.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.inmob.control.Conexion;

public class Pantalla {

	public static void main(String[] args) throws Throwable   {
		Scanner scanner = new Scanner(System.in);
		Conexion conexion = new Conexion();
		BienView tipoview = new BienView(conexion,scanner);
		
/*		for (int i = 1; i < 3; i++) {
			ClienteView.insertar(conexion, scanner);
		}*/
		
		//tipoview.listar();
		//tipoview.actualizar();
		//tipoview.buscar(1);
		tipoview.insertar();
		
		
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
		
		scanner.close();	
	}	
}
