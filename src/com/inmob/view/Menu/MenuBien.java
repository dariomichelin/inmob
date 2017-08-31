package com.inmob.view.Menu;

import java.util.Scanner;


import com.inmob.entity.Bien;
import com.inmob.view.ReadTypes;

public class MenuBien {
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar codigo del tipo");
				System.out.println("2. Actualizar direccion");
				System.out.println("3. Actualizar descripcion");
				System.out.println("4. Actualizar disponibilidad");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 7) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo una palabra que describa el nuevo tipo de bien:");
				System.out.println();
				scanner.nextLine();
			}
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public static void menuModificar(Scanner scanner, Bien bien) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
			case 1:
				System.out.print("Codigo del bien anterior: ");
				System.out.println(bien.getBien_id());
				int tipo_id = ReadTypes.leerEntero(scanner, "Ingrese el codigo del nuevo tipo de bien");
				bien.setTipo_id(tipo_id);
				bien.setDireccion(bien.getDireccion());
				bien.setDescripcion(bien.getDescripcion());
				bien.setDisponibilidad(bien.isDisponibilidad());
				break;
			case 2:
				System.out.print("Codigo del bien anterior: ");
				System.out.println(bien.getBien_id());
				String direccion = ReadTypes.leerCadena(scanner, "Ingrese la nueva direccion: ");
				bien.setDireccion(direccion);
				bien.setTipo_id(bien.getTipo_id());
				bien.setDescripcion(bien.getDescripcion());
				bien.setDisponibilidad(bien.isDisponibilidad());
				break;
			case 3:
				System.out.print("Codigo del bien anterior: ");
				System.out.println(bien.getBien_id());
				String descripcion = ReadTypes.leerCadena(scanner, "Ingrese la nueva descripcion: ");
				bien.setTipo_id(bien.getTipo_id());
				bien.setDireccion(bien.getDireccion());
				bien.setDescripcion(descripcion);
				bien.setDisponibilidad(bien.isDisponibilidad());
				break;
			case 4:
				System.out.print("Codigo del bien anterior: ");
				System.out.println(bien.getBien_id());
				boolean disponibilidad = ReadTypes.leerBoolean(scanner, "Se cambio de estado satisfactoriamente");
				if (disponibilidad=true)
				{
					disponibilidad=false;
				}
				else
				{
					disponibilidad=true;
				}
				bien.setTipo_id(bien.getTipo_id());
				bien.setDescripcion(bien.getDescripcion());
				bien.setDisponibilidad(bien.isDisponibilidad());
				bien.setDisponibilidad(disponibilidad);
				break;
			}
		}
	}
}
