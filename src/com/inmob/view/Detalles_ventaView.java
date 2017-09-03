package com.inmob.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.inmob.control.Conexion;
import com.inmob.control.Detalles_ventaControl;
import com.inmob.entity.Detalles_venta;
import com.inmob.view.Menu.MenuDetalles_venta;

public class Detalles_ventaView {

	private Scanner scanner;
	private Detalles_venta detalles_venta;
	private Detalles_ventaControl detalles_ventacontrol;
	
	
	public Detalles_ventaView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		detalles_ventacontrol = new  Detalles_ventaControl(conexion);
		
	}
	
	public void insertar() throws Throwable {
		int detalle_venta_id;
		int bien_id;
		double precio_venta;
		double comision;
		String seguimiento_venta;
		int agente_id;
		
		bien_id = ReadTypes.leerEntero(scanner, "Ingrese el id del Bien: ");
		precio_venta = ReadTypes.leerEntero(scanner, "Ingrese el precio de la Venta: ");
		comision = ReadTypes.leerEntero(scanner, "Ingrese la comision: ");
		seguimiento_venta = ReadTypes.leerCadena(scanner, "Ingrese el seguimiento de la venta: ");
	    agente_id = ReadTypes.leerEntero(scanner, "Ingrese el id del Agente: ");
		detalle_venta_id = detalles_ventacontrol.ultimocodigo();
		detalles_venta = new Detalles_venta(detalle_venta_id,bien_id,precio_venta,comision,seguimiento_venta,agente_id);
		try {
			detalles_ventacontrol.insert(detalles_venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<Detalles_venta> detalles_venta;

		try {
			detalles_venta = detalles_ventacontrol.list();
			for (int i = 0; i < detalles_venta.size(); i++) {
				System.out.println(detalles_venta.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int detalle_venta_id) {
		detalles_venta= new Detalles_venta(detalle_venta_id,0,0,0,"",0);
		try {
			detalles_ventacontrol.search(detalles_venta);
			System.out.println(detalles_venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	
	public void actualizar() {
		int detalle_venta_id;
	
		detalle_venta_id = ReadTypes.leerEntero(scanner, "Ingrese el codigo de la venta a modificar: ");
		detalles_venta= new Detalles_venta(detalle_venta_id,0,0,0,"",0);
	
		try {
			detalles_ventacontrol.search(detalles_venta);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenuDetalles_venta.menuModificar(scanner, detalles_venta);

		try {
			detalles_ventacontrol.update(detalles_venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
}
