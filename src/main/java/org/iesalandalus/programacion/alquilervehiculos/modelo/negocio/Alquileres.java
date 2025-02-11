package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

//version 0 

import java.time.LocalDate;

//version 0

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Alquileres {

	private List<Alquiler> coleccionAlquileres;

	public Alquileres() {

		coleccionAlquileres = new ArrayList<>(); // creando la lista

	}

	public List<Alquiler> get() {

		return new ArrayList<>(coleccionAlquileres); // devuelvo un nuevo arraylist
	}

	public List<Alquiler> get(Cliente cliente) {

		List<Alquiler> listaNuevaCliente = new ArrayList<>();

		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getCliente().equals(cliente)) {
				listaNuevaCliente.add(alquiler);
			}
		}
		return listaNuevaCliente;

	}

	public List<Alquiler> get(Turismo turismo) {

		List<Alquiler> listaNuevaTurismo = new ArrayList<>(); // creo una nueva list

		for (Alquiler alquiler : coleccionAlquileres) { // recorro la lista
			if (alquiler.getTurismo().equals(turismo)) {
				// Si el turismo del alquiler es el mismo turismo que pasamos por parametro lo
				// almacenamos?
				listaNuevaTurismo.add(alquiler);

			}

		}
		return listaNuevaTurismo; // devolvemos la lista.

	}

	public int getCantidad() {

		return coleccionAlquileres.size();

	}

	private void comprobarAlquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler)
			throws OperationNotSupportedException {
		for (Alquiler alquiler : coleccionAlquileres) {
			// con equal compruebo si el el objeto cliente y turismo pasados son los mismos
			// que los objetors y turismos de alquiler.
			if (alquiler.getFechaDevolucion() == null) {

				if (alquiler.getCliente().equals(cliente)) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
				}
				if (alquiler.getTurismo().equals(turismo)) {

					throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
				}

			} else {
				// alquileres que son devueltos
				if (alquiler.getCliente().equals(cliente) && (alquiler.getFechaDevolucion().isAfter(fechaAlquiler)
						|| alquiler.getFechaDevolucion().isEqual(fechaAlquiler))) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
				}
				if (alquiler.getTurismo().equals(turismo) && (alquiler.getFechaDevolucion().isAfter(fechaAlquiler)
						|| alquiler.getFechaDevolucion().isEqual(fechaAlquiler))) {
					throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
				}
			}
		}
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}

		if (!coleccionAlquileres.contains(alquiler)) {
			comprobarAlquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler());
			coleccionAlquileres.add(alquiler);
		}

	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
		}

		Alquiler encontradoAlquiler = buscar(alquiler); // busco el alquiler

		if (encontradoAlquiler != null) { // si es diferente de null lo devuelvo

			encontradoAlquiler.devolver(fechaDevolucion); // devuelvo el alquiler que he encontrado gracias al metodo
															// buscar(alquiler)

		} else {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}

	}

	public Alquiler buscar(Alquiler alquiler) {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		}

		int alquilerIndice = coleccionAlquileres.indexOf(alquiler);

		if (alquilerIndice == -1) { // El -1 en un numerico es como si fuera null, por lo tanto si es diferente de
									// null
			alquiler = null;
		} else {
			alquiler = coleccionAlquileres.get(alquilerIndice);

		}

		return alquiler; // devolvemos el valor que hay dentro del indice de la lista.

	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		}

		if (coleccionAlquileres.contains(alquiler)) { // si existe en la lista
			coleccionAlquileres.remove(alquiler);
		} else {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}

	}

}
