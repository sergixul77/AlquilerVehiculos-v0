package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum Opcion {
	
	SALIR("Salir"),INSERTAR_CLIENTE("insertar cliente"),INSERTAR_TURISMO("Insertar turismos"),INSERTAR_ALQUILER("Insertar alquiler"),BUSCAR_CLIENTE("Buscar cliente"),BUSCAR_TURISMO("Buscar turismo"),BUSCAR_ALQUILER("Buscar alquiler"),MODIFICAR_CLIENTE("Modificar cliente"),DEVOLVER_ALQUILER("Devolver alquiler"),BORARR_CLIENTE("Borrar cliente"),BORRAR_TURISMO("Borrar turismo"),BORRAR_ALQUILER("Borrar alquiler"),LISTAR_CLIENTES("Listar clientes"),LISTAR_TURISMO("Listar turismos"),LISTAR_ALQUILERES("Listar alquileres"),LISTAR_ALQUILERES_CLIENTE("Listar alquiler de un cliente"),LISTAR_ALQUILERES_TURISMO("Lista alquiler de un turismo");
	
	private String texto;
	
	private Opcion (String texto) {
		
		this.texto=texto;
	}
	
	
	@Override 
	public String toString() {
		return String.format("%s",texto);
	}
	
	
	private static boolean esOrdinalValido (int ordinal) {
		
		return ordinal >= 0 && ordinal < Opcion.values().length;
		
	}
	
	public static Opcion (int ordinal) {
		
		Opcion opcion = null;
		
		switch (ordinal) {
		  case 1:
		    opcion= Opcion.SALIR;
		    break;
		  case 2:
		    System.out.println("Tuesday");
		    break;
		  case 3:
		    System.out.println("Wednesday");
		    break;
		  case 4:
		    System.out.println("Thursday");
		    break;
		  case 5:
		    System.out.println("Friday");
		    break;
		  case 6:
		    System.out.println("Saturday");
		    break;
		  case 7:
		    System.out.println("Sunday");
		    break;
		}
		// Outputs "Thursday" (day 4)

		return opcion;

		
	}


	
	
}

