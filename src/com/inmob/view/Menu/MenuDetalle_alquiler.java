package com.inmob.view.Menu;

import java.util.Scanner;

import com.inmob.entity.Detalle_alquiler;
import com.inmob.view.ReadTypes;

public class MenuDetalle_alquiler {

	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar el codigo del bien");
				System.out.println("2. Actualizar el precio de alquiler");
				System.out.println("3. Actualizar la comision");
				System.out.println("4. Actualizar el seguimiento");
				System.out.println("5. Actualizar los datos del dueño");
				System.out.println("6. Actualizar el codigo del agente");
				System.out.println("0. Salir");
				System.out.println();
				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 9) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo una palabra que describa el nuevo alquiler:");
				System.out.println();
				scanner.nextLine();
			}
		}
	}

        public static void menuModificar(Scanner scanner, Detalle_alquiler detalle_alquiler) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Codigo del alquiler anterior: ");
				System.out.println(detalle_alquiler.getDetalle_alquiler_id());
				int bien_id = ReadTypes.leerEntero(scanner, "Ingrese el nuevo codigo del Bien: ");
				detalle_alquiler.setBien_id(bien_id);
				detalle_alquiler.setPrecio_alquiler(detalle_alquiler.getPrecio_alquiler());
				detalle_alquiler.setComision(detalle_alquiler.getComision());
				detalle_alquiler.setSeguimiento_alquiler(detalle_alquiler.getSeguimiento_alquiler());
				detalle_alquiler.setDatos_dueño(detalle_alquiler.getDatos_dueño());
				detalle_alquiler.setAgente_id(detalle_alquiler.getAgente_id());
				break;
			case 2:
				System.out.print("Codigo del alquiler anterior: ");
				System.out.println(detalle_alquiler.getDetalle_alquiler_id());
				double precio_alquiler = ReadTypes.leerEntero(scanner, "Ingrese el precio del alquiler: ");
				detalle_alquiler.setPrecio_alquiler(precio_alquiler);;
				detalle_alquiler.setBien_id(detalle_alquiler.getBien_id());
				detalle_alquiler.setComision(detalle_alquiler.getComision());
				detalle_alquiler.setSeguimiento_alquiler(detalle_alquiler.getSeguimiento_alquiler());
				detalle_alquiler.setDatos_dueño(detalle_alquiler.getDatos_dueño());
				detalle_alquiler.setAgente_id(detalle_alquiler.getAgente_id());
				break;
			case 3:
				System.out.print("Codigo del alquiler anterior: ");
				System.out.println(detalle_alquiler.getDetalle_alquiler_id());
				double comision = ReadTypes.leerEntero(scanner, "Ingrese el comision del Alquiler: ");
				detalle_alquiler.setComision(comision);
				detalle_alquiler.setBien_id(detalle_alquiler.getBien_id());
				detalle_alquiler.setPrecio_alquiler(detalle_alquiler.getPrecio_alquiler());
				detalle_alquiler.setSeguimiento_alquiler(detalle_alquiler.getSeguimiento_alquiler());
				detalle_alquiler.setDatos_dueño(detalle_alquiler.getDatos_dueño());
				detalle_alquiler.setAgente_id(detalle_alquiler.getAgente_id());
				break;
			case 4:
				System.out.print("Codigo del alquiler anterior: ");
				System.out.println(detalle_alquiler.getDetalle_alquiler_id());
				String seguimiento_alquiler = ReadTypes.leerCadena(scanner, "Ingrese el seguimiento del Alquiler: ");
				detalle_alquiler.setSeguimiento_alquiler(seguimiento_alquiler);
				detalle_alquiler.setBien_id(detalle_alquiler.getBien_id());
				detalle_alquiler.setPrecio_alquiler(detalle_alquiler.getPrecio_alquiler());
				detalle_alquiler.setComision(detalle_alquiler.getComision());
				detalle_alquiler.setDatos_dueño(detalle_alquiler.getDatos_dueño());
				detalle_alquiler.setAgente_id(detalle_alquiler.getAgente_id());
				break;
			case 5:
				System.out.print("Codigo del alquiler anterior: ");
				System.out.println(detalle_alquiler.getDetalle_alquiler_id());
				String datos_dueño = ReadTypes.leerCadena(scanner, "Ingrese los datos del dueño: ");
				detalle_alquiler.setDatos_dueño(datos_dueño);
				detalle_alquiler.setBien_id(detalle_alquiler.getBien_id());
				detalle_alquiler.setPrecio_alquiler(detalle_alquiler.getPrecio_alquiler());
				detalle_alquiler.setComision(detalle_alquiler.getComision());
				detalle_alquiler.setSeguimiento_alquiler(detalle_alquiler.getSeguimiento_alquiler());
				detalle_alquiler.setAgente_id(detalle_alquiler.getAgente_id());
				break;
			case 6:
				System.out.print("Codigo del alquiler anterior: ");
				System.out.println(detalle_alquiler.getDetalle_alquiler_id());
				int agente_id = ReadTypes.leerEntero(scanner, "Ingrese el codigo del agente: ");
				detalle_alquiler.setAgente_id(agente_id);
				detalle_alquiler.setBien_id(detalle_alquiler.getBien_id());
				detalle_alquiler.setPrecio_alquiler(detalle_alquiler.getPrecio_alquiler());
				detalle_alquiler.setComision(detalle_alquiler.getComision());
				detalle_alquiler.setSeguimiento_alquiler(detalle_alquiler.getSeguimiento_alquiler());
				detalle_alquiler.setDatos_dueño(detalle_alquiler.getDatos_dueño());
				break;	
			}
		}
	}
}
