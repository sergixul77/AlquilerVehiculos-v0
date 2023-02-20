package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Turismos {
	
	 public List<Turismo> coleccionTurismo; 
	
	public Turismos () {
		
		coleccionTurismo = new ArrayList<>(); // creando la lista
		
	}
	
	public List<Turismo> get() {

		return coleccionTurismo;
	}

	public int getCantidad () {
		
		int cantidadElementos = 0;
		for (Turismo turismos : coleccionTurismo) {

			cantidadElementos++;
		}

		return cantidadElementos; // devuelvo el numero de elementos que contiene la lista
	}
	
	public void insertar(Turismo turismo ) throws OperationNotSupportedException {
	
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		}
		
		if (!coleccionTurismo.contains(turismo)) {
			coleccionTurismo.add(turismo);
		}else {
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		}
	}
	
	public Turismo buscar(Turismo turismo) {

		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
		}

		int indiceTurismo = coleccionTurismo.indexOf(turismo); //Almacenamos los indices de la lista de turismos 

		Turismo TurismoList = null; // lo iniciamos a null

		if (indiceTurismo != -1) { // El -1 en un numerico es como si fuera null, por lo tanto si es diferente de null

			TurismoList = coleccionTurismo.get(indiceTurismo); // Cogemos el indice del turismo 
		}

		return TurismoList; // y lo mostramos 		

	}
	
	public void borrar(Turismo turismo) throws OperationNotSupportedException {

		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		}

		if (coleccionTurismo.contains(turismo)) { // si existe el turismo.

			coleccionTurismo.remove(turismo);

		} else { // si el turismo no existe
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
		}

	}
	
	
			
	}

		
	
	
	
