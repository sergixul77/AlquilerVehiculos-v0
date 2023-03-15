package org.iesalandalus.programacion.alquilervehiculos.controlador;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class Controlador {

	private Vista vista;

	private Modelo modelo;

	public Controlador(Modelo modelo, Vista vista) {
		if (modelo == null) {
			throw new NullPointerException("ERROR: no puedes crear un modelo nulo");
		}
		if (vista == null) {
			throw new NullPointerException("ERROR: no puedes crear una vista  nula");
		}

		this.modelo = modelo;
		this.vista = vista;
		vista.setControlador(this); // para que vista pueda mandar a ejecutar opciones al controlador y pueda
									// manejarla correctamente. Con el this te estas refiriendo a una instancia de
									// la clase?

	}

	public void comenzar() {

		vista.comenzar();
		modelo.comenzar();

	}

	public void terminar() {

		vista.terminar();
		modelo.terminar();

	}

	/*------       Inserta un cliente o un turismo o un alquiler           --------*/

	public void insertar(Cliente cliente) throws OperationNotSupportedException {

		modelo.insertar(cliente);
	}

	public void insertar(Turismo turismo) throws OperationNotSupportedException {

		modelo.insertar(turismo);

	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		modelo.insertar(alquiler);
	}

	/*------       Busca un cliente o un turismo o un alquiler           --------*/

	public void buscar(Cliente cliente) {

		modelo.buscar(cliente);

	}

	public void buscar(Turismo turismo) {

		modelo.buscar(turismo);

	}

	public void buscar(Alquiler alquiler) {

		modelo.buscar(alquiler);

	}

	/* Modifica un clinente el nombre */

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {

		modelo.modificar(cliente, nombre, telefono);

	}

	/* Devuelve el alquiler con la fecha de devolucion */

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {

		modelo.devolver(alquiler, fechaDevolucion);

	}

	/* Borrar un cliente, un turismo y un alquiler */

	public void borrar(Cliente cliente) throws OperationNotSupportedException {

		modelo.borrar(cliente);

	}

	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		modelo.borrar(turismo);

	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {

		modelo.borrar(alquiler);

	}

	// no entiendo esto.

	public List<Cliente> getClientes() {
		for (Cliente cliente : modelo.getClientes()) {
			System.out.println(cliente.toString());
		}
		return modelo.getClientes();
	}

	public List<Turismo> getTurismos() {
		for (Turismo turismo : modelo.getTurismos()) {
			System.out.println(turismo.toString());
		}
		return modelo.getTurismos();
	}

	public List<Alquiler> getAlquileres() {
		for (Alquiler alquiler : modelo.getAlquileres()) {
			System.out.println(alquiler.toString());
		}

		return modelo.getAlquileres();
	}

	public List<Alquiler> getAlquileres(Cliente cliente) {

		for (Alquiler alquiler : modelo.getAlquileres(cliente)) {
			System.out.println(alquiler.toString());

		}

		return modelo.getAlquileres(cliente);

	}

	public List<Alquiler> getAlquileres(Turismo turismo) {
		for (Alquiler alquiler : modelo.getAlquileres(turismo)) {
			System.out.println(alquiler.toString());
		}
		return modelo.getAlquileres(turismo);

	}

}