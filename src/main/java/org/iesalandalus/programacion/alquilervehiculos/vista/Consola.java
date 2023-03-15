package org.iesalandalus.programacion.alquilervehiculos.vista;

// version 0

import java.time.LocalDate;

/*Version 0*/

import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
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

		mostrarCabecera("Alquiler de vehiculos");

		for (Opcion menu : Opcion.values()) {
			System.out.println(menu.toString());

		}

	}

	private static String leerCadena(String mensaje) {

		System.out.println(mensaje); // devuelvo el mensaje pasado por parametro

		return Entrada.cadena(); // Almaceno en la variable cadena lo que me escribe el usuario; //
	}

	private static Integer leerEntero(String mensaje) {

		System.out.println(mensaje); // devuelvo el mensaje pasado por parametro

		return Entrada.entero(); // Almaceno en la variable cadena lo que me escribe el usuario; //
	}

	private static LocalDate leerFecha(String mensaje) {

		System.out.println(mensaje);

		String fecha;

		do {

			fecha = Entrada.cadena(); // almaceno en la variable fecha lo que me pasa el usuario por teclado

		} while (fecha.equals(PATRON_FECHA)); // mientras que la fecha no sea igual que el patron que se le pasa

		return LocalDate.parse(fecha, FORMATO_FECHA);

	}

	public static Opcion elegirOpcion() {

		Opcion opcion = null;

		do {

			try {

				opcion = Opcion.get(leerEntero("Introduce una opción"));

			} catch (Exception e) {

				System.out.println("Error: " + e.getMessage());
			}

		} while (opcion == null); // si la opcion es = null es porque la opcion que le has pasado por parametro no
									// esta definida

		return opcion;

	}

	public static Cliente leerCliente() {

		return new Cliente(leerCadena("Introduce tu nombre"), (leerCadena("Introduce tu dni")),
				(leerCadena("Introduce tu numero de telefono")));

	}

	public static Cliente leerClienteDni() {
		return Cliente.getClienteConDni(leerCadena("Introduce el dni del cliente")); // crea un nuevo cliente con dni
																						// segun lo que el usuario mete
																						// por teclado

	}

	public static String leerNombre() {

		return leerCadena("Introduce tu nombre");

	}

	public static String leerTelefono() {

		return leerCadena("Introduce tu telefono");

	}
	
	public static Turismo leerTurismo () {
		
		return new Turismo(leerCadena("Introduce la marca"),(leerCadena("Introduce el modelo")),(leerEntero("Introduce la cilindrada")),(leerCadena("introduce la matrícula")));
		
	}
	
	
	public static Turismo leerTurismoMatricula () {
		
		return Turismo.getTurismoConMatricula(leerCadena("Introduce la matrícula del vehiculo"));
	}
	
	public static Alquiler leerAlquiler() {
		
		return new Alquiler(leerClienteDni(), leerTurismoMatricula(),leerFecha("Introduzca la fecha de alquiler"));
		
	}
	
	public static LocalDate leerFechaDevolucion() {
		
		return leerAlquiler().getFechaDevolucion(); // nose si esto esta bien
	}

}
