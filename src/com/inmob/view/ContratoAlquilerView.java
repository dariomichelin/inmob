package com.inmob.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import com.inmob.control.BienControl;
import com.inmob.control.Conexion;
import com.inmob.control.ContratoAlquilerControl;
import com.inmob.control.ContratoVentaControl;
import com.inmob.entity.Bien;
import com.inmob.entity.Contrato_alquiler;
import com.inmob.entity.Contrato_venta;
import com.inmob.view.Menu.MenuBien;
import com.inmob.view.Menu.MenuContratoAlq;


public class ContratoAlquilerView {

	
	private Scanner scanner;
	private Contrato_alquiler contrato;
	private ContratoAlquilerControl control;
	
	public ContratoAlquilerView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		control = new  ContratoAlquilerControl(conexion);
		
	}
	
	public void insertar() throws Throwable {
		int contrato_id;
		double precio_alquiler_final;
		int detalle_alquiler_id;
		String nombre_inquilino;
		String telefono_inquilino;
		int CI_inquilino;
		String referencias;
		String detalles_pago;
		Date fecha_inicio;
		Date fecha_fin;

		contrato_id =control.ultimocodigo();
		precio_alquiler_final = ReadTypes.leerReal(scanner, "Ingrese el precio final: "); 
		nombre_inquilino = ReadTypes.leerCadena(scanner, "Ingrese el nombre del inquilino: ");
		telefono_inquilino = ReadTypes.leerCadena(scanner, "Ingrese el telefono del inquilino: ");
		detalle_alquiler_id=ReadTypes.leerEntero(scanner, "Ingrese el codigo de detalle correspondiente: ");
		CI_inquilino = ReadTypes.leerEntero(scanner, "Ingrese el CI del inquilino: ");
		referencias = ReadTypes.leerCadena(scanner, "Ingrese las referencias del inquilino: (nombre, telefono)");
		detalles_pago = ReadTypes.leerCadena(scanner, "Ingrese detalles de pago: ");
		fecha_inicio=ReadTypes.leerFecha(scanner, "ingrese la fecha de inicio del alquiler: ");
		fecha_fin=ReadTypes.leerFecha(scanner, "ingrese la fecha de fin del alquiler: ");
		contrato = new Contrato_alquiler(contrato_id,precio_alquiler_final,detalle_alquiler_id,nombre_inquilino, telefono_inquilino,referencias,CI_inquilino,detalles_pago,fecha_inicio,fecha_fin);
		try {
			control.insert(contrato);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void listar() {
		ArrayList<Contrato_alquiler> venta;

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
		contrato= new Contrato_alquiler(contrato_id,0,0,"","","",0,"",null,null);
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
		contrato= new Contrato_alquiler(contrato_id,0,0,"","","",0,"",null,null);
	
		try {
			control.search(contrato);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenuContratoAlq.menuModificar(scanner, contrato);

		try {
			control.update(contrato);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
}