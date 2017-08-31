package com.inmob.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.inmob.control.TipoControl;
import com.inmob.control.Conexion;
import com.inmob.entity.Tipo;
import com.inmob.view.Menu.MenuTipo;


public class TipoView {

	
	private Scanner scanner;
	private Tipo tipo;
	private TipoControl tipocontrol;
	
	public TipoView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		tipocontrol = new  TipoControl(conexion);
		
	}
	public void insertar() {
		int tipo_id;
		String tipos;
		String descripcion;

		tipos = ReadTypes.leerCadena(scanner, "Ingrese el nombre del tipo: ");
		descripcion = ReadTypes.leerCadena(scanner, "Ingrese la descripcion del tipo: ");
		tipo_id = tipo.getTipo_id();
		tipo = new Tipo(tipo_id,tipos,descripcion);
		try {
			tipocontrol.insert(tipo);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	public void listar() {
		ArrayList<Tipo> tipos;

		try {
			tipos = tipocontrol.list();
			for (int i = 0; i < tipos.size(); i++) {
				System.out.println(tipos.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscar(int tipo_id) {
		tipo= new Tipo(tipo_id,"","");
		try {
			tipocontrol.search(tipo);
			System.out.println(tipo);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void actualizar() {
		int tipo_id;
	
		tipo_id = ReadTypes.leerEntero(scanner, "Ingrese el codigo del tipo a modificar: ");
		tipo=new Tipo(tipo_id,"","");
	
		try {
			tipocontrol.search(tipo);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenuTipo.menuModificar(scanner, tipo);

		try {
			tipocontrol.update(tipo);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
}
