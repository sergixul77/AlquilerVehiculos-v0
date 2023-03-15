package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;

// version 0

public class Vista {

	private Controlador controlador;

	public void setControlador(Controlador controlador) {
		if (controlador != null) { // si el controlador es diferente de null
			this.controlador = controlador;
		}
	}

	public void comenzar() {
		Opcion eligeOpcion = null;

		do {
			Consola.mostrarMenu();
			eligeOpcion = Consola.elegirOpcion(); // este metodo ya lee la opcion y la ejecutara
		} while (eligeOpcion == null); // si la opcion es = null es porque el numero que has introducido no corresponde
										// con ninguna opcion

	}

	public void terminar() {
		System.out.println("Me despido de ti, ha sido un placer!!!");
	}

	public void ejecutar(Opcion opcion) {

		switch (opcion) {
		case BORAR_CLIENTE:
			borrarCliente();
			break;

		case BORRAR_ALQUILER:
			borrarAlquiler();
			break;
		case BORRAR_TURISMO:
			borrarTurismo();
			break;
		case BUSCAR_ALQUILER:
			buscarAlquiler();
			break;
		case BUSCAR_CLIENTE:
			buscarCliente();
			break;
		case BUSCAR_TURISMO:
			buscarTurismo();
			break;
		case DEVOLVER_ALQUILER:
			devolverAlquiler();
			break;
		case INSERTAR_CLIENTE:
			insertarCliente();
			break;
		case INSERTAR_ALQUILER:
			insertarAlquiler();
			break;
		case INSERTAR_TURISMO:
			insertarTurismo();
			break;
		case LISTAR_ALQUILERES:
listarAlquileres();
			break;
		case LISTAR_ALQUILERES_CLIENTE:
listarAlquileresClientes();
			break;
		case LISTAR_ALQUILERES_TURISMO:
listarAlquileresTurismos();
			break;
		case LISTAR_CLIENTES:
listarClientes();
			break;
		case LISTAR_TURISMOS:
listarTurismos();
			break;
		case MODIFICAR_CLIENTE:
modificarCliente();
			break;
		case SALIR:
			terminar(); 
			break;
		}

	}

	  private void borrarCliente() {
	        try {
	            Opcion opcion = Opcion.BORAR_CLIENTE;
	            Consola.mostrarCabecera(opcion.toString());
	            controlador.borrar(Consola.leerCliente());
	            System.out.println("El cliente ha sido borrado correctamente.");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }

	   
	private void borrarAlquiler() {
	        try {
	            Opcion opcion = Opcion.BORRAR_ALQUILER;
	            Consola.mostrarCabecera(opcion.toString());
	            controlador.borrar(Consola.leerAlquiler());
	            System.out.println("El alquiler ha sido borrado correctamente.");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	
	 private void borrarTurismo() {
	        try {
	            Opcion opcion = Opcion.BORRAR_TURISMO;
	            Consola.mostrarCabecera(opcion.toString());
	            controlador.borrar(Consola.leerTurismo());
	            System.out.println("El turismo ha sido borrado correctamente.");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }

	  private void buscarCliente() {
	        try {
	            Opcion opcion = Opcion.BUSCAR_CLIENTE;
	            Consola.mostrarCabecera(opcion.toString());
	            controlador.buscar(Consola.leerCliente());
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    private void buscarTurismo() {
	        try {
	            Opcion opcion = Opcion.BUSCAR_TURISMO;
	            Consola.mostrarCabecera(opcion.toString());
	            controlador.buscar(Consola.leerTurismo());
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }

	private void buscarAlquiler() {
        try {
            Opcion opcion = Opcion.BUSCAR_ALQUILER;
            Consola.mostrarCabecera(opcion.toString());
            controlador.buscar(Consola.leerAlquiler());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

	   private void devolverAlquiler() {
	        try {
	            Opcion opcion = Opcion.DEVOLVER_ALQUILER;
	            Consola.mostrarCabecera(opcion.toString());
	            controlador.devolver(Consola.leerAlquiler(), Consola.leerFechaDevolucion());
	            System.out.println("El alquiler se ha devuelto correctamente.");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }

	   private void insertarCliente() {
	        try {
	            Opcion opcion = Opcion.INSERTAR_CLIENTE;
	            Consola.mostrarCabecera(opcion.toString());
	            controlador.insertar(Consola.leerCliente());
	            System.out.println("El cliente se ha insertado correctamente.");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	   
	   private void insertarAlquiler() {
	        try {
	            Opcion opcion = Opcion.INSERTAR_ALQUILER;
	            Consola.mostrarCabecera(opcion.toString());
	            controlador.insertar(Consola.leerAlquiler());
	            System.out.println("El alquiler se ha insertado correctamente.");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    private void insertarTurismo() {
	        try {
	            Opcion opcion = Opcion.INSERTAR_TURISMO;
	            Consola.mostrarCabecera(opcion.toString());
	            controlador.insertar(Consola.leerTurismo());
	            System.out.println("El turismo se ha insertado correctamente.");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	    
	    private void listarAlquileres() {
	        try {
	            Opcion opcion = Opcion.LISTAR_ALQUILERES;
	            Consola.mostrarCabecera(opcion.toString());
	            controlador.getAlquileres();
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	    
	    
	    private void listarAlquileresClientes() {
	        try {
	            Consola.mostrarCabecera("LISTA DE ALQUILERES DE UN CLIENTE:");
	            Opcion opcion = Opcion.LISTAR_ALQUILERES_CLIENTE;
	            Consola.mostrarCabecera(opcion.toString());
	            controlador.getAlquileres(Consola.leerCliente());
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    private void listarAlquileresTurismos() {
	        try {
	            Consola.mostrarCabecera("LISTA DE ALQUILERES DE UN TURISMO:");
	            Opcion opcion = Opcion.LISTAR_ALQUILERES_TURISMO;
	            Consola.mostrarCabecera(opcion.toString());
	            controlador.getAlquileres(Consola.leerTurismo());
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	    
	    private void listarClientes() {
	        try {
	            Opcion opcion = Opcion.LISTAR_CLIENTES;
	            Consola.mostrarCabecera(opcion.toString());
	            controlador.getClientes();
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	    
	    private void listarTurismos() {
	        try {
	            Opcion opcion = Opcion.LISTAR_TURISMOS;
	            Consola.mostrarCabecera(opcion.toString());
	            controlador.getTurismos();
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	    
	    private void modificarCliente() {
	        try {
	            Opcion opcion = Opcion.MODIFICAR_CLIENTE;
	            Consola.mostrarCabecera(opcion.toString());
	            controlador.modificar(Consola.leerClienteDni(), Consola.leerNombre(), Consola.leerTelefono());
	            System.out.println("El cliente se ha modificado correctamente.");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
}

	   

