package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;

// version 0

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;

// version 0

public class Modelo {
	private Clientes clientes;
	private Alquileres alquileres;
	private Turismos turismos;

	public Modelo() { // preguntar al profesor

	}

	public void comenzar() { // estoy creado nuevas instancias para cada clase.

		clientes = new Clientes();
		alquileres = new Alquileres();
		turismos = new Turismos();

	}

	public void terminar() {
		System.out.println("El modelo ha terminado");

	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {

		clientes.insertar(new Cliente(cliente));
	}

	public void insertar(Turismo turismo) throws OperationNotSupportedException {

		turismos.insertar(new Turismo(turismo));

	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}

		Cliente clienteEncontrado = clientes.buscar(alquiler.getCliente()); // busco el cliente

		if (clienteEncontrado == null) { // Compruebo si el cliente que se pasa por parametro esta
											// en la coleccion o lista de clientes
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");

		}

		Turismo turismoEncontrado = turismos.buscar(alquiler.getTurismo()); // busco el turismo

		if (turismoEncontrado == null) { // compruebo si el turismo que me pasan por parametro esta
											// en la lista o coleccion
			throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
		}

		alquiler = new Alquiler(clienteEncontrado, turismoEncontrado, alquiler.getFechaAlquiler());

		alquileres.insertar(alquiler); // insertar alquileres.

	}

	public Cliente buscar(Cliente cliente) {

		return new Cliente(clientes.buscar(cliente));

	}

	public Turismo buscar(Turismo turismo) {

		return new Turismo(turismos.buscar(turismo));

	}

	public Alquiler buscar(Alquiler alquiler) {

		return new Alquiler(alquileres.buscar(alquiler));

	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		clientes.modificar(cliente, nombre, telefono);
	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {

		Alquiler encontradoAlquiler = alquileres.buscar(alquiler); // busco el alquiler

		if (encontradoAlquiler == null) {
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		} else {
			encontradoAlquiler.devolver(fechaDevolucion);
		}

	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		for (Alquiler alquilerTurismo : alquileres.get(cliente)) {
			alquileres.borrar(alquilerTurismo);
		}
		clientes.borrar(cliente);
	}

	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		for (Alquiler alquilerTurismo : alquileres.get(turismo)) {
			alquileres.borrar(alquilerTurismo);
		}
		turismos.borrar(turismo);
	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		alquileres.borrar(alquiler);

	}

	public List<Cliente> getClientes() {

		List<Cliente> listaDeClientes = new ArrayList<>(); // hago una nueva lista
		for (Cliente unCliente : clientes.get()) { // recorro la lista
			Cliente cliente = new Cliente(unCliente); // creo una nueva instancia utilizando el constructor copia
			listaDeClientes.add(cliente); // añado el cliente creado a la lista.
		}
		return listaDeClientes; // devuelvo la lista de clientes

	}

	public List<Turismo> getTurismos() {
		List<Turismo> listaDeTurismos = new ArrayList<>();
		for (Turismo unTurismo : turismos.get()) {
			Turismo turismo = new Turismo(unTurismo);
			listaDeTurismos.add(turismo);

		}
		return listaDeTurismos;
	}

	public List<Alquiler> getAlquileres() {
		List<Alquiler> listaDeAlquileres = new ArrayList<>();
		for (Alquiler unAlquiler : alquileres.get()) {
			Alquiler alquiler = new Alquiler(unAlquiler);
			listaDeAlquileres.add(alquiler);

		}
		return listaDeAlquileres;
	}

	public List<Alquiler> getAlquileres(Cliente cliente) {
		List<Alquiler> listaDeAlquiler = new ArrayList<>();
		for (Alquiler unAlquiler : alquileres.get(cliente)) {
			Alquiler alquiler = new Alquiler(unAlquiler);
			listaDeAlquiler.add(alquiler);

		}

		return listaDeAlquiler;
	}

	public List<Alquiler> getAlquileres(Turismo turismo) {
		List<Alquiler> listaDeAlquiler = new ArrayList<>();
		for (Alquiler unAlquiler : alquileres.get(turismo)) {
			Alquiler alquiler = new Alquiler(unAlquiler);
			listaDeAlquiler.add(alquiler);

		}
		return listaDeAlquiler;
	}

}
