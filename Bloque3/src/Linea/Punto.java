package Linea;

import java.util.Objects;

public class Punto {

	private double x;
	private double y;

	public Punto(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}

	public void moverDerecha(double distancia) {
		this.x = this.x + distancia;
	}

	public void moverIzquierda(double distancia) {
		this.x = this.x - distancia;
	}

	public void moverArriba(double distancia) {
		this.y = this.y + distancia;
	}

	public void moverAbajo(double distancia) {
		this.y = this.y - distancia;
	}

}
