package com.inmob.view.Menu;

import java.util.Scanner;


import com.inmob.entity.Tipo;
import com.inmob.view.ReadTypes;

public class MenuTipo {
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar tipo");
				System.out.println("2. Actualizar descripcion");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 5) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo una palabra que describa el nuevo tipo de bien:");
				System.out.println();
				scanner.nextLine();
			}
		}
	}

	public static void menuModificar(Scanner scanner, Tipo tipos) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Codigo del tipo anterior: ");
				System.out.println(tipos.getTipo_id());
				String tipo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo Tipo: ");
				tipos.setTipo(tipo);
				tipos.setDescripcion(tipos.getDescripcion());
				break;
			case 2:
				System.out.print("Codigo del tipo anterior: ");
				System.out.println(tipos.getTipo_id());
				String descripcion = ReadTypes.leerCadena(scanner, "Ingrese la nueva descripcion: ");
				tipos.setTipo(tipos.getTipo());
				tipos.setDescripcion(descripcion);
				break;
			}
		}
	}
}
