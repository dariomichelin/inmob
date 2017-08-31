package com.inmob.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.inmob.control.TipoControl;
import com.inmob.control.BienControl;
import com.inmob.control.Conexion;
import com.inmob.entity.Bien;
import com.inmob.entity.Tipo;
import com.inmob.view.Menu.MenuBien;
import com.inmob.view.Menu.MenuTipo;


public class BienView {

	
	private Scanner scanner;
	private Bien bien;
	private BienControl biencontrol;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public BienView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		biencontrol = new  BienControl(conexion);
		
	}
	/**
	 * ********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() throws Throwable {
		int bien_id;
		int tipo_id;
		String direccion;
		String descripcion;
		boolean disponibilidad;

		tipo_id = ReadTypes.leerEntero(scanner, "Ingrese el codigo del tipo: "); 
		direccion = ReadTypes.leerCadena(scanner, "Ingrese la direccion del tipo: ");
		descripcion = ReadTypes.leerCadena(scanner, "Ingrese la descripcion del tipo: ");
		bien_id =biencontrol.ultimocodigo();
		disponibilidad=true;
		bien = new Bien(bien_id,tipo_id,direccion,descripcion,disponibilidad);
		try {
			biencontrol.insert(bien);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<Bien> bienes;

		try {
			bienes = biencontrol.list();
			for (int i = 0; i < bienes.size(); i++) {
				System.out.println(bienes.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int bien_id) {
		bien= new Bien(bien_id,0,"","",false);
		try {
			biencontrol.search(bien);
			System.out.println(bien);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		int bien_id;
	
		bien_id = ReadTypes.leerEntero(scanner, "Ingrese el codigo del bien a modificar: ");
		bien=new Bien(bien_id,0,"","",false);
	
		try {
			biencontrol.search(bien);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenuBien.menuModificar(scanner, bien);

		try {
			biencontrol.update(bien);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
}

