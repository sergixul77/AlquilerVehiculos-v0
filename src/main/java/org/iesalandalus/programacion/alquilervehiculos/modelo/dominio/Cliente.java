package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

// version 0


public class Cliente {

	private static final String ER_NOMBRE = "[A-Z][a-zñ]+( [A-Z][a-zñ]+)*";

	private static final String ER_DNI = "\\d{8}[A-HJ-NP-TV-Z]";

	private static final String ER_TELEFONO = "[6-9]\\d{8}";

	private String nombre;
	private String dni;
	private String telefono;

	 
	public Cliente (String nombre, String dni , String telefono) {
		setNombre(nombre);
		setDni(dni);
		setTelefono(telefono);
		
	}
	
	
	public Cliente (Cliente cliente) { /*Constructor copia*/
		
			if (cliente == null) { /*Tengo que revisar que el cliente sea nulo, si es nulo, salta una excepcion */
				throw new NullPointerException("ERROR: No es posible copiar un cliente nulo.");
			}
			
				nombre = cliente.getNombre();
				dni = cliente.getDni();
				telefono = cliente.getTelefono();
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		
		if (nombre == null) {
			throw new NullPointerException("ERROR: El nombre no puede ser nulo.");
		} 
		if(!nombre.matches(ER_NOMBRE)) {
			throw new IllegalArgumentException("ERROR: El nombre no tiene un formato válido.");
		}		
			this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		
		if (dni == null) {
			throw new NullPointerException("ERROR: El DNI no puede ser nulo.");
		} if (!dni.matches(ER_DNI)) {
			throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");
		}if (!comprobarLetraDni(dni)) {
			throw new IllegalArgumentException("ERROR: La letra del DNI no es correcta.");
		}
		
		this.dni = dni;
	}
	
	
	
	private boolean comprobarLetraDni(String dni) {
		
		char[] letrasDni = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'}; /*array con las letras*/
		 
		 int numeroDni = Integer.parseInt(dni.substring(0, 8)); // Utilizo el parseInt para convertir la cadena de numeros a numerico y solo cojo los numeros en este caso del 0 al 8, porque la 9 es la letra.
		 
		 int calcularLetra = letrasDni[numeroDni % 23];
		 
		 return dni.charAt(8) == calcularLetra; // Compruebo si la letra del dni es igual que la que ha calculado, si es verdadero devuelve True, y si es falso devuelve False. 	
		 
	}

	

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		
		if (telefono == null) {
			throw new NullPointerException("ERROR: El teléfono no puede ser nulo.");
		}
		if (!telefono.matches(ER_TELEFONO)) { // si el telefono que pasamos por parametro es distinto al de la expresion regular salta una excepcion
			throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido.");
		}
		
		this.telefono = telefono;
	}
	
	public static Cliente getClienteConDni(String dni) {
		
		return new Cliente ("Sergio" , dni , "950224506");
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}


	@Override
	public String toString() {
		return String.format("%s - %s (%s)", nombre, dni, telefono);
	}
	
	
}
