package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.time.LocalDate;

/*version v0*/

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Alquiler {

	
	  static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	 
	 private static final int PRECIO_DIA = 20;
	 
	 private LocalDate fechaAlquiler;
	 
	 private LocalDate fechaDevolucion;
	 
	 private Turismo turismo; 
	 
	 private Cliente cliente;
	 
	 public Alquiler ( Cliente cliente, Turismo turismo, LocalDate fechaAlquiler ) {
		 
		 setCliente(cliente);
		 setFechaAlquiler(fechaAlquiler);
		 setTurismo(turismo);
		 
		 
	 }
	 
	 public Alquiler (Alquiler alquiler ) { // constructor copia
		 
			if (alquiler == null) { 
				throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo.");
			}
			
			
			cliente=new Cliente(alquiler.getCliente());
			turismo = new Turismo(alquiler.getTurismo());
			fechaAlquiler = alquiler.getFechaAlquiler();
			fechaDevolucion = alquiler.getFechaDevolucion();
			
			
				
	 }

	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}

	private void setFechaAlquiler(LocalDate fechaAlquiler) {
		
		if (fechaAlquiler == null) {
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
		}
		if (fechaAlquiler.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura.");
		}
		
		
		this.fechaAlquiler = fechaAlquiler;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	private void setFechaDevolucion(LocalDate fechaDevolucion) {
		
		if (fechaDevolucion == null) {
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		}
		if(fechaDevolucion.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");
		}
		if (fechaDevolucion.isBefore(fechaAlquiler) || fechaDevolucion.isEqual(getFechaAlquiler()) )  {
			throw new IllegalArgumentException("ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");
		}
		
		
		
		this.fechaDevolucion = fechaDevolucion;
	}

	public Turismo getTurismo() {
		return turismo;
	}

	private void setTurismo(Turismo turismo) {
		if (turismo == null) {
			throw new NullPointerException("ERROR: El turismo no puede ser nulo.");
		}

		
		this.turismo = turismo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	private void setCliente(Cliente cliente) {
		
		
		if (cliente == null) {
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
		}
		
		
		this.cliente = cliente;
	}
	 
	public void devolver (LocalDate fechaDevolucion) throws OperationNotSupportedException {
		
		if(this.fechaDevolucion != null) {
			throw new OperationNotSupportedException("ERROR: La devolución ya estaba registrada."); 
		}
		
		setFechaDevolucion(fechaDevolucion); // llamo al metodo que hace las comprobaciones para la devolucion? 
		
	}
	
	


	
	public int getPrecio () {
		int precio = 0;
		
		if (this.fechaDevolucion != null) {
			
			int factorCilindrada = turismo.getCilindrada() / 10;
			
			int calcularNumDias = (int) (ChronoUnit.DAYS.between(fechaAlquiler,fechaDevolucion)); // Devuelve la diferencia en dias de dos fechas. 
			
			 precio = (PRECIO_DIA + factorCilindrada) * calcularNumDias;
		}
			
		return precio;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, turismo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(turismo, other.turismo);
	}

	

	
	@Override
	public String toString() {
		String cadenaFrase = null;
		if (this.fechaDevolucion == null) {
			
			cadenaFrase = String.format("%s <---> %s, %s - %s (%d€)" , cliente , turismo , getFechaAlquiler().format(FORMATO_FECHA),"Aún no devuelto",getPrecio());
			
		}else {
			cadenaFrase = String.format("%s <---> %s, %s - %s (%d€)" ,cliente , turismo , getFechaAlquiler().format(FORMATO_FECHA),getFechaDevolucion().format(FORMATO_FECHA),getPrecio());
		}
		
		return cadenaFrase;
	}

		 
	 
	
	
	
}
