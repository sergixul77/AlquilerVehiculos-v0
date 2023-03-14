package org.iesalandalus.programacion.alquilervehiculos.vista;

// version 0

public enum Opcion {

	SALIR("Salir"), INSERTAR_CLIENTE("insertar cliente"), INSERTAR_TURISMO("Insertar turismos"),
	INSERTAR_ALQUILER("Insertar alquiler"), BUSCAR_CLIENTE("Buscar cliente"), BUSCAR_TURISMO("Buscar turismo"),
	BUSCAR_ALQUILER("Buscar alquiler"), MODIFICAR_CLIENTE("Modificar cliente"), DEVOLVER_ALQUILER("Devolver alquiler"),
	BORARR_CLIENTE("Borrar cliente"), BORRAR_TURISMO("Borrar turismo"), BORRAR_ALQUILER("Borrar alquiler"),
	LISTAR_CLIENTES("Listar clientes"), LISTAR_TURISMO("Listar turismos"), LISTAR_ALQUILERES("Listar alquileres"),
	LISTAR_ALQUILERES_CLIENTE("Listar alquiler de un cliente"),
	LISTAR_ALQUILERES_TURISMO("Lista alquiler de un turismo");

	private String texto;

	private Opcion(String texto) {

		this.texto = texto;
	}

	private static boolean esOrdinalValido(int ordinal) {

		return ordinal >= 0 && ordinal < Opcion.values().length;

	}

	public static Opcion get(int ordinal) {

		if (!esOrdinalValido(ordinal)) { // si el ordinal pasado no es correcto pues me salta un mensaje de error
			throw new IllegalArgumentException("El ordinal que has pasado no es valido.");
		}

		return Opcion.values()[ordinal];
	}

	@Override
	public String toString() {
		return String.format("%s. %s", ordinal(), texto);

	}

}
