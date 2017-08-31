package com.inmob.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.inmob.control.Conexion;
import com.inmob.control.AgenteControl;
import com.inmob.entity.Agente;
import com.inmob.view.Menu.MenuAgente;

public class AgenteView {
	private Scanner scanner;
	private Agente agente;
	private AgenteControl agentecontrol;
	
	public AgenteView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		agentecontrol = new  AgenteControl(conexion);
		
	}
		
	public void insertar() throws Throwable {
		int agente_id;
		 String nombre;
	     String apellidos;
	     String contacto;
		 String telefono;

		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre del agente: ");
		apellidos = ReadTypes.leerCadena(scanner, "Ingrese el apellido del agente: ");
		contacto = ReadTypes.leerCadena(scanner, "Ingrese el contacto del agente: ");
		telefono = ReadTypes.leerCadena(scanner, "Ingrese el telefono del agente: ");
		agente_id = agentecontrol.ultimocodigo();
		agente = new Agente(agente_id,nombre,apellidos,contacto,telefono);
		try {
			agentecontrol.insert(agente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}

	public void listar() {
		ArrayList<Agente> agente;

		try {
			agente = agentecontrol.list();
			for (int i = 0; i < agente.size(); i++) {
				System.out.println(agente.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


	public void buscar(int agente_id) {
		agente= new Agente(agente_id,"","","","");
		try {
			agentecontrol.search(agente);
			System.out.println(agente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	public void actualizar() {
		int agente_id;
	
		agente_id = ReadTypes.leerEntero(scanner, "Ingrese el codigo del agente a modificar: ");
		agente= new Agente(agente_id,"","","","");
	
		try {
			agentecontrol.search(agente);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenuAgente.menuModificar(scanner, agente);

		try {
			agentecontrol.update(agente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}
	
}
