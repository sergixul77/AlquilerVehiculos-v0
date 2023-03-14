package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;


// version 0

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;

public class Clientes {

	private List<Cliente> coleccionClientes;

	public Clientes() {
		coleccionClientes = new ArrayList<>(); // creando la lista
	}

	public List<Cliente> get() {

		return new ArrayList<>(coleccionClientes);
	}

	public int getCantidad() { // tengo que recorrer la lista y incrementar en cada paso
		
		return coleccionClientes.size(); // devuelvo el tamaño de la coleccion
	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}
		if (!coleccionClientes.contains(cliente)) {
			coleccionClientes.add(cliente);
		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
		}
	}

	public Cliente buscar(Cliente cliente) {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}

		int indiceCliente = coleccionClientes.indexOf(cliente);

		Cliente clienteList = null;

		if (indiceCliente != -1) { // El -1 en un numerico es como si fuera null

			clienteList = coleccionClientes.get(indiceCliente);
		}

		return clienteList;

	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}

		if (coleccionClientes.contains(cliente)) { // si existe el cliente.

			coleccionClientes.remove(cliente);

		} else { // si el cliente no existe
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}

	}

	

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		}
		
		
		Cliente clienteEncontrado = buscar(cliente); // esto busca al cliente.
		
		
		if (clienteEncontrado == null) { // si el cliente que buscamos no esta en la lista salta la excepcion 
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}

		if (telefono != null && !telefono.isBlank()) { // si el telefono no es nulo ni tampoco tiene espacios en blanco

			clienteEncontrado.setTelefono(telefono);

		}
		if (nombre != null && !nombre.isBlank()) { // si el nombre es diferente a nulo y no tiene espacios ya que lo
													// quito con el isBlank

			clienteEncontrado.setNombre(nombre); // del cliente encontrado modifico el nombre
		}

		

	}

}
