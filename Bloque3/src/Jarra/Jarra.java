package Jarra;

public class Jarra {

	private double capacidad;
	private double cantidadDeAgua;
	private static double totalAguaConsumida = 0;

	public Jarra(double capacidad) throws JarraException {

		if (capacidad < 0) {
			throw new JarraException("Error la capacidad no puede ser negativa");
		}
		this.capacidad = capacidad;
		this.cantidadDeAgua = 0;
	}

	public double getCapacidad() {
		return capacidad;
	}

	public double getCantidadDeAgua() {
		return cantidadDeAgua;
	}

	public static double getTotalAguaConsumida() {
		return totalAguaConsumida;
	}

	public void llenarJarra() {
		double resto;
		
		resto=capacidad-cantidadDeAgua;
		this.cantidadDeAgua = this.capacidad;
		totalAguaConsumida = totalAguaConsumida + resto;
	}

	public void vaciarJarra() {
		// poner la jarra a 0
		this.capacidad = 0;
	}

	public void volcarJarra(Jarra otraJarra) {
		// Verificar si la otra jarra no es nula
		if (otraJarra != null) {
			// Calcular cuánta agua podemos volcar de esta jarra a la otra
			double aguaAVolcar = Math.min(this.cantidadDeAgua, otraJarra.capacidad - otraJarra.cantidadDeAgua);

			// Verificar que haya agua para volcar
			if (aguaAVolcar > 0) {
				// Realizar el volcado
				this.cantidadDeAgua -= aguaAVolcar;
				otraJarra.cantidadDeAgua += aguaAVolcar;
			}
		}
	}
}
