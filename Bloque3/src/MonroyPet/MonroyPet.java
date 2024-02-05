package MonroyPet;

import java.util.Objects;

public class MonroyPet {

	private static final int COMIDA_INICIAL = 2;
	private static final int PUNTOS_INCIALES = 0;
	private static final int MAX_MINUTOS_JUGAR = 20;
	private static final int COSTO_COMIDA = 30;

	private String nombre;
	private String tipo;
	private int puntos;
	private int comida;

	private static int totalJugadoEntreTodasMascotas = 0;

	public MonroyPet(String nombre, String tipo) throws MonroyPetException {

		if (!(tipo.equals("PERRO") || tipo.equals("GATO"))) {
			throw new MonroyPetException("Tipo de mascota incorrecto");
		}

		this.nombre = nombre;
		this.tipo = tipo;
		this.puntos = PUNTOS_INCIALES;
		this.comida = COMIDA_INICIAL;
	}

	// Métodos getter y setter

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	private void setTipo(String tipo) throws MonroyPetException {
		if (!(tipo.equals("PERRO") || tipo.equals("GATO"))) {
			throw new MonroyPetException("Tipo de mascota incorrecto");
		}
		this.tipo = tipo;
	}

	public int getPuntos() {
		return puntos;
	}

	private void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getComida() {
		return comida;
	}

	private void setComida(int comida) {
		this.comida = comida;
	}

	// Método para dar comida a la mascota
	public void darComida() throws MonroyPetException {
		if (comida > 0) {
			comida--;
		} else {
			throw new MonroyPetException("No hay comida disponible");
		}
	}

	// Método para comprar comida
	public void comprarComida(int cantidad) throws MonroyPetException {
		int costoTotal = COSTO_COMIDA * cantidad;
		if (puntos >= costoTotal) {
			comida += cantidad;
			puntos -= costoTotal;
		} else {
			throw new MonroyPetException("No tienes puntos suficientes para comprar esa cantidad de comida");
		}
	}

	// Método para jugar
	public void jugar(int minutos) throws MonroyPetException {
		if (minutos > MAX_MINUTOS_JUGAR) {
			throw new MonroyPetException("No puedes jugar más de 20 minutos");
		}
		int puntosGanados = minutos * 3;
		puntos += puntosGanados;
		totalJugadoEntreTodasMascotas += minutos;
	}
	// Método para mostrar todos los datos de la mascota
	@Override
	public String toString() {
		String mensaje = "Nombre: " + nombre + " Tipo: " + tipo + " Puntos: " + puntos + "Comida: " + comida + " "
				+ (tipo.equals("PERRO") ? "huesos" : "pescado");
		return mensaje;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(nombre, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonroyPet other = (MonroyPet) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(tipo, other.tipo);
	}

}
