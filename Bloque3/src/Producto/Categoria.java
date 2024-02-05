package Producto;

public class Categoria {
	private String nombre;
	private double iva;

	public Categoria(String nombre, double iva)throws ProductoException {
		this.nombre = nombre;
		this.iva = iva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) throws ProductoException {
		if (iva <0) {
			throw new ProductoException("Error el iva no puede ser negativo");
		}
		this.iva = iva;
	}

}
