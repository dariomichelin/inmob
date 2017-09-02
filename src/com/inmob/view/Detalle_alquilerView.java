package com.inmob.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.inmob.control.Detalle_alquilerControl;
import com.inmob.control.Conexion;
import com.inmob.entity.Detalle_alquiler;
import com.inmob.view.Menu.MenuDetalle_alquiler;

public class Detalle_alquilerView {

	private Scanner scanner;
	private Detalle_alquiler detalle_alquiler;
	private Detalle_alquilerControl detalle_alquilercontrol;
	
	
	public Detalle_alquilerView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		detalle_alquilercontrol = new  Detalle_alquilerControl(conexion);
		
	}
	
	public void insertar() throws Throwable {
		int detalle_alquiler_id;
		int bien_id;
		double precio_alquiler;
		double comision;
		String seguimiento_alquiler;
		String datos_dueño;
		int agente_id;
		
		bien_id = ReadTypes.leerEntero(scanner, "Ingrese el id del Bien: ");
		precio_alquiler = ReadTypes.leerEntero(scanner, "Ingrese el precio del Alquiler: ");
		comision = ReadTypes.leerEntero(scanner, "Ingrese la comision: ");
		seguimiento_alquiler = ReadTypes.leerCadena(scanner, "Ingrese el seguimiento del alquiler: ");
		datos_dueño = ReadTypes.leerCadena(scanner, "Ingrese los datos del dueño: ");
		agente_id = ReadTypes.leerEntero(scanner, "Ingrese el id del Agente: ");
		detalle_alquiler_id = detalle_alquilercontrol.ultimocodigo();
		detalle_alquiler = new Detalle_alquiler(detalle_alquiler_id,bien_id,precio_alquiler,comision,seguimiento_alquiler,datos_dueño,agente_id);
		try {
			detalle_alquilercontrol.insert(detalle_alquiler);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<Detalle_alquiler> detalle_alquiler;

		try {
			detalle_alquiler = detalle_alquilercontrol.list();
			for (int i = 0; i < detalle_alquiler.size(); i++) {
				System.out.println(detalle_alquiler.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int detalle_alquiler_id) {
		detalle_alquiler= new Detalle_alquiler(detalle_alquiler_id,0,0,0,"","",0);
		try {
			detalle_alquilercontrol.search(detalle_alquiler);
			System.out.println(detalle_alquiler);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	
	public void actualizar() {
		int detalle_alquiler_id;
	
		detalle_alquiler_id = ReadTypes.leerEntero(scanner, "Ingrese el codigo del alquiler a modificar: ");
		detalle_alquiler= new Detalle_alquiler(detalle_alquiler_id,0,0,0,"","",0);
	
		try {
			detalle_alquilercontrol.search(detalle_alquiler);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenuDetalle_alquiler.menuModificar(scanner, detalle_alquiler);

		try {
			detalle_alquilercontrol.update(detalle_alquiler);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
}
