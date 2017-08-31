package com.inmob.view.Menu;

import java.util.Scanner;

import com.inmob.entity.Agente;
import com.inmob.view.ReadTypes;

public class MenuAgente {

	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar nombre de agente");
				System.out.println("2. Actualizar apellidos");
				System.out.println("3. Actualizar contacto");
				System.out.println("4. Actualizar telefono");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 7) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo una palabra que describa el nuevo agente:");
				System.out.println();
				scanner.nextLine();
			}
		}
	}

	public static void menuModificar(Scanner scanner, Agente agente) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Codigo del agente anterior: ");
				System.out.println(agente.getAgente_id());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nuevo nombre del Agente: ");
				agente.setNombre(nombre);
				agente.setApellidos(agente.getApellidos());
				agente.setContacto(agente.getContacto());
				agente.setTelefono(agente.getTelefono());
				break;
			case 2:
				System.out.print("Codigo del agente anterior: ");
				System.out.println(agente.getAgente_id());
				String apellidos = ReadTypes.leerCadena(scanner, "Ingrese el apellido del Agente: ");
				agente.setApellidos(apellidos);
				agente.setNombre(agente.getNombre());
				agente.setContacto(agente.getContacto());
				agente.setTelefono(agente.getTelefono());
				break;
			case 3:
				System.out.print("Codigo del agente anterior: ");
				System.out.println(agente.getAgente_id());
				String contacto = ReadTypes.leerCadena(scanner, "Ingrese el contacto del Agente: ");
				agente.setContacto(contacto);
				agente.setNombre(agente.getNombre());
				agente.setApellidos(agente.getApellidos());
				agente.setTelefono(agente.getTelefono());
				break;
			case 4:
				System.out.print("Codigo del agente anterior: ");
				System.out.println(agente.getAgente_id());
				String telefono = ReadTypes.leerCadena(scanner, "Ingrese el telefono del Agente: ");
				agente.setTelefono(telefono);
				agente.setNombre(agente.getNombre());
				agente.setApellidos(agente.getApellidos());
				agente.setContacto(agente.getContacto());
				break;
			}
		}
	}
}

