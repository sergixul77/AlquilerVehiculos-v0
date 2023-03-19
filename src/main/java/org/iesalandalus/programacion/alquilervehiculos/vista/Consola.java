package org.iesalandalus.programacion.alquilervehiculos.vista;

// version 0

import java.time.LocalDate;

/*Version 0*/

import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private static final String PATRON_FECHA = "dd/MM/yyyy";
	/*
	 * private static final String PATRON_MES = "MM/yyyy"; esto es de la version 1
	 */

	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);

	private Consola() {

	}

	public static void mostrarCabecera(String mensaje) {

		System.out.println(mensaje);
		System.out.println("-".repeat(mensaje.length())); // imprime una linea de guiones igual que la longitud del
															// mensaje
	}

	public static void mostrarMenu() {

		mostrarCabecera("Alquiler de vehículos Sergio");

		for (Opcion menu : Opcion.values()) {
			System.out.println(menu.toString());

		}

	}

	private static String leerCadena(String mensaje) {

		System.out.print(mensaje); // devuelvo el mensaje pasado por parametro

		return Entrada.cadena(); // Almaceno en la variable cadena lo que me escribe el usuario; //
	}

	private static Integer leerEntero(String mensaje) {

		System.out.print(mensaje); // devuelvo el mensaje pasado por parametro

		return Entrada.entero(); // Almaceno en la variable entero lo que me escribe el usuario; //
	}

	private static LocalDate leerFecha(String mensaje) {

		LocalDate fecha;

		try {
			fecha = LocalDate.parse(leerCadena(mensaje), FORMATO_FECHA);

		} catch (Exception e) {
			fecha = null;
		}

		return fecha;
	}

	public static Opcion elegirOpcion() {

		Opcion opcion = null;

		do {

			try {

				opcion = Opcion.get(leerEntero("Introduce una opción: "));

			} catch (Exception e) {

				System.out.println("Error: " + e.getMessage());
			}

		} while (opcion == null && opcion != Opcion.SALIR); // si la opcion es = null es porque la opcion que le has
															// pasado por parametro no
		// esta definida

		return opcion;

	}

	public static Cliente leerCliente() {

		return new Cliente(leerCadena("Introduce tu nombre: "), (leerCadena("Introduce tu dni: ")),
				(leerCadena("Introduce tu número de teléfono: ")));

	}

	public static Cliente leerClienteDni() {
		return Cliente.getClienteConDni(leerCadena("Introduce el dni del cliente: ")); // crea un nuevo cliente con dni
																						// segun lo que el usuario mete
																						// por teclado

	}

	public static String leerNombre() {

		return leerCadena("Introduce tu nombre:  ");

	}

	public static String leerTelefono() {

		return leerCadena("Introduce tu teléfono: ");

	}

	public static Turismo leerTurismo() {

		return new Turismo(leerCadena("Introduce la marca: "), (leerCadena("Introduce el modelo: ")),
				(leerEntero("Introduce la cilindrada: ")), (leerCadena("introduce la matrícula: ")));

	}

	public static Turismo leerTurismoMatricula() {

		return Turismo.getTurismoConMatricula(leerCadena("Introduce la matrícula del vehículo: "));
	}

	public static Alquiler leerAlquiler() {

		return new Alquiler(leerClienteDni(), leerTurismoMatricula(), leerFecha("Introduzca la fecha de alquiler: ")); // he
																														// quitado
																														// el
																														// mensaje
																														// de
																														// dentro

	}

	public static LocalDate leerFechaDevolucion() {

		return leerFecha("Introduceme la fecha de devolución: ");
	}

}
