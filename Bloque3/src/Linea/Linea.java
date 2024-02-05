package Linea;

public class Linea {
	private Punto puntoA;
	private Punto puntoB;

	public Linea(Punto puntoA, Punto puntoB) throws LineaException {
		if (puntoA.equals(puntoB)) {
			throw new LineaException("Los puntos no deben ser iguales.");
		}
		this.puntoA = puntoA;
		this.puntoB = puntoB;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Linea otraLinea = (Linea) obj;
		return puntoA.equals(otraLinea.puntoA) && puntoB.equals(otraLinea.puntoB);
	}

	public void moverDerecha(double distancia) {
		puntoA.moverDerecha(distancia);
		puntoB.moverDerecha(distancia);
	}

	public void moverIzquierda(double distancia) {
		puntoA.moverIzquierda(distancia);
		puntoB.moverIzquierda(distancia);

	}

	public void moverArriba(double distancia) {
		puntoA.moverArriba(distancia);
		puntoB.moverArriba(distancia);
	}

	public void moverAbajo(double distancia) {
		puntoA.moverAbajo(distancia);
		puntoB.moverAbajo(distancia);
	}

	public String toString() {
		return "[" + puntoA + "," + puntoB + "]";
	}
}
