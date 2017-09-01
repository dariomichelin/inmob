package com.inmob.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import com.inmob.control.BienControl;
import com.inmob.control.Conexion;
import com.inmob.control.ContratoVentaControl;
import com.inmob.entity.Bien;
import com.inmob.entity.Contrato_venta;
import com.inmob.view.Menu.MenuBien;


public class ContratoVentasView {

	
	private Scanner scanner;
	private Contrato_venta contrato;
	private ContratoVentaControl control;
	
	public ContratoVentasView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		control = new  ContratoVentaControl(conexion);
		
	}
	
	public void insertar() throws Throwable {
		int contrato_id;
		double precio_venta_final;
		int detalle_venta_id;
		String nombre_comprador;
		String telefono_comprador;
		String CI_comprador;
		String referencias;
		String detalles_pago;
		Date fecha_venta;

		contrato_id =control.ultimocodigo();
		precio_venta_final = ReadTypes.leerReal(scanner, "Ingrese el precio final: "); 
		nombre_comprador = ReadTypes.leerCadena(scanner, "Ingrese el nombre del comprador: ");
		telefono_comprador = ReadTypes.leerCadena(scanner, "Ingrese el telefono del comprador: ");
		detalle_venta_id=ReadTypes.leerEntero(scanner, "Ingrese el codigo de detalle correspondiente: ");
		CI_comprador = ReadTypes.leerCadena(scanner, "Ingrese el CI del comprador: ");
		referencias = ReadTypes.leerCadena(scanner, "Ingrese las referencias del comprador: (nombre, telefono)");
		detalles_pago = ReadTypes.leerCadena(scanner, "Ingrese detalles de pago: ");
		fecha_venta=new Date();
		contrato = new Contrato_venta(contrato_id,precio_venta_final,detalle_venta_id,nombre_comprador, telefono_comprador,CI_comprador,referencias,detalles_pago,fecha_venta);
		try {
			control.insert(contrato);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void listar() {
		ArrayList<Contrato_venta> venta;

		try {
			venta = control.list();
			for (int i = 0; i < venta.size(); i++) {
				System.out.println(venta.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscar(int contrato_id) {
		contrato= new Contrato_venta(contrato_id,0,0,"","","","","",null);
		try {
			control.search(contrato);
			System.out.println(contrato);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

		public void actualizar() {
		int contrato_id;
	
		contrato_id = ReadTypes.leerEntero(scanner, "Ingrese el codigo del contrato a modificar: ");
		contrato= new Contrato_venta(contrato_id,0,0,"","","","","",null);;
	
		try {
			control.search(contrato);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenuContratoVenta.menuModificar(scanner, contrato);

		try {
			control.update(contrato);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
}