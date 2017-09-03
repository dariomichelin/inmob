package com.inmob.view.Menu;

import java.util.Scanner;

import com.inmob.entity.Detalles_venta;
import com.inmob.view.ReadTypes;

public class MenuDetalles_venta {

	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar el codigo del bien");
				System.out.println("2. Actualizar el precio de la venta");
				System.out.println("3. Actualizar la comision");
				System.out.println("4. Actualizar el seguimiento");
				System.out.println("5. Actualizar el codigo del agente");
				System.out.println("0. Salir");
				System.out.println();
				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 8) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo una palabra que describa la nueva venta:");
				System.out.println();
				scanner.nextLine();
			}
		}
	}

        public static void menuModificar(Scanner scanner, Detalles_venta detalles_venta) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Codigo de la venta anterior: ");
				System.out.println(detalles_venta.getDetalle_venta_id());
				int bien_id = ReadTypes.leerEntero(scanner, "Ingrese el nuevo codigo del Bien: ");
				detalles_venta.setBien_id(bien_id);
				detalles_venta.setPrecio_venta(detalles_venta.getPrecio_venta());
				detalles_venta.setComision(detalles_venta.getComision());
				detalles_venta.setSeguimiento_venta(detalles_venta.getSeguimiento_venta());
				detalles_venta.setAgente_id(detalles_venta.getAgente_id());
				break;
			case 2:
				System.out.print("Codigo de la venta anterior: ");
				System.out.println(detalles_venta.getDetalle_venta_id());
				double precio_venta = ReadTypes.leerEntero(scanner, "Ingrese el precio de la venta: ");
				detalles_venta.setPrecio_venta(precio_venta);;
				detalles_venta.setBien_id(detalles_venta.getBien_id());
				detalles_venta.setComision(detalles_venta.getComision());
				detalles_venta.setSeguimiento_venta(detalles_venta.getSeguimiento_venta());
				detalles_venta.setAgente_id(detalles_venta.getAgente_id());
				break;
			case 3:
				System.out.print("Codigo de la venta anterior: ");
				System.out.println(detalles_venta.getDetalle_venta_id());
				double comision = ReadTypes.leerEntero(scanner, "Ingrese el comision de la venta: ");
				detalles_venta.setComision(comision);
				detalles_venta.setBien_id(detalles_venta.getBien_id());
				detalles_venta.setPrecio_venta(detalles_venta.getPrecio_venta());
				detalles_venta.setSeguimiento_venta(detalles_venta.getSeguimiento_venta());
				detalles_venta.setAgente_id(detalles_venta.getAgente_id());
				break;
			case 4:
				System.out.print("Codigo de la venta anterior: ");
				System.out.println(detalles_venta.getDetalle_venta_id());
				String seguimiento_venta = ReadTypes.leerCadena(scanner, "Ingrese el seguimiento de la venta: ");
				detalles_venta.setSeguimiento_venta(seguimiento_venta);
				detalles_venta.setBien_id(detalles_venta.getBien_id());
				detalles_venta.setPrecio_venta(detalles_venta.getPrecio_venta());
				detalles_venta.setComision(detalles_venta.getComision());
				detalles_venta.setAgente_id(detalles_venta.getAgente_id());
				break;
			case 5:
				System.out.print("Codigo de la venta anterior: ");
				System.out.println(detalles_venta.getDetalle_venta_id());
				int agente_id = ReadTypes.leerEntero(scanner, "Ingrese el codigo del agente: ");
				detalles_venta.setAgente_id(agente_id);
				detalles_venta.setBien_id(detalles_venta.getBien_id());
				detalles_venta.setPrecio_venta(detalles_venta.getPrecio_venta());
				detalles_venta.setComision(detalles_venta.getComision());
				detalles_venta.setSeguimiento_venta(detalles_venta.getSeguimiento_venta());
				break;	
			}
		}
	}
}