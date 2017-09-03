package com.inmob.view.Menu;

import java.util.Date;
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
				System.out.println("3. Corregir o actualizar el telefono del inquilino");
				System.out.println("4. Cambiar referencias");
				System.out.println("5. Corregir el CI del inquilino");
				System.out.println("6. Cambiar los detalles de pago");
				System.out.println("7. Corregir la fecha de inicio");
				System.out.println("8. Corregir la fecha de fin");
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
				System.out.println(contrato.toString());
				break;
			case 1:
				System.out.print("Precio del alquiler anterior: ");
				System.out.println(contrato.getPrecio_alquiler_final());
				double precio = ReadTypes.leerEntero(scanner, "Ingrese el nuevo precio: ");
				contrato.setPrecio_alquiler_final(precio);
				System.out.println(contrato.toString());
				break;
			case 2:
				System.out.print("Nombre anterior: ");
				System.out.println(contrato.getNombre_inquilino());
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese la correccion: ");
				contrato.setNombre_inquilino(nombre);
				System.out.println(contrato.toString());
				break;
			case 3:
				System.out.print("Telefono anterior: ");
				System.out.println(contrato.getTelefono_inquilino());
				String telefono = ReadTypes.leerCadena(scanner, "Ingrese la correccion: ");
				contrato.setTelefono_inquilino(telefono);
				System.out.println(contrato.toString());
				break;
			case 4:
				System.out.print("Referencias anteriores: ");
				System.out.println(contrato.getReferencias());
				String referencias = ReadTypes.leerCadena(scanner, "Ingrese las nuevas referencias: ");
				contrato.setReferencias(referencias);
				System.out.println(contrato.toString());
				break;
			case 5:
				System.out.print("CI del cliente: ");
				System.out.println(contrato.getCI_inquilino());
				int CI = ReadTypes.leerEntero(scanner, "Ingrese nuevo CI: ");
				contrato.setCI_inquilino(CI);
				System.out.println(contrato.toString());
				break;
			case 6:
				System.out.print("Detalles anteriores: ");
				System.out.println(contrato.getDetalles_pago());
				String detalles = ReadTypes.leerCadena(scanner, "Ingrese los nuevo detalles: ");
				contrato.setDetalles_pago(detalles);
				
				break;	
			case 7:
				System.out.println("Fecha de inicio: ");
				System.out.println(contrato.getFecha_inicio());
				Date fecha=ReadTypes.leerFecha(scanner, "Ingrese la nueva fecha: ");
				contrato.setFecha_inicio(fecha);
				System.out.println(contrato.toString());
				break;
			case 8:
				System.out.println("Fecha de fin: ");
				System.out.println(contrato.getFecha_inicio());
				Date fechaf=ReadTypes.leerFecha(scanner, "Ingrese la nueva fecha: ");
				contrato.setFecha_inicio(fechaf);
				System.out.println(contrato.toString());
				break;
			}
		}
	}
}
