package com.inmob.view.Menu;

import java.util.Scanner;

import com.inmob.entity.Contrato_alquiler;
import com.inmob.entity.Detalle_alquiler;
import com.inmob.view.ReadTypes;

public class MenuContratoAlq {

	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar el precio de alquiler");
				System.out.println("2. Corregir el precio de nombre de inquilino");
				System.out.println("3. Corregir el telefono del inquilino");
				System.out.println("4. Corregir las referencias");
				System.out.println("5. Corregir el CI del inquilino");
				System.out.println("6. Actualizar los detalles de pago");
				System.out.println("7. Actualizar la fecha de inicio");
				System.out.println("8. Actualizar la fecha de fin");
				System.out.println("0. Salir");
				System.out.println();
				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 11) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo una palabra que describa el nuevo alquiler:");
				System.out.println();
				scanner.nextLine();
			}
		}
	}

        public static void menuModificar(Scanner scanner, Contrato_alquiler contrato) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Precio del alquiler anterior: ");
				System.out.println(contrato.getPrecio_alquiler_final());
				double precio = ReadTypes.leerEntero(scanner, "Ingrese el nuevo precio: ");
				contrato.setPrecio_alquiler_final(precio);
				contrato.toString();
				break;
			case 2:
				System.out.print("Nombre anterior: ");
				System.out.println(contrato.getNombre_inquilino());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese la correccion: ");
				contrato.setNombre_inquilino(nombre);
				contrato.toString();
				break;
			case 3:
				System.out.print("Telefono anterior: ");
				System.out.println(contrato.getTelefono_inquilino());
				String telefono = ReadTypes.leerCadena(scanner, "Ingrese la correccion: ");
				contrato.setTelefono_inquilino(telefono);
				contrato.toString();
				break;
			/*case 4:
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
				break;	*/
			}
		}
	}
}
