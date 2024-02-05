package Producto;

public class Producto {

	private int codigoProducto;
	private String descripcion;
	private double precioSinIva;
	private Categoria categoria;
	private static int ultimoCodigoGenerado=0;

	public Producto(String descripcion, double precioSinIva, Categoria categoria)throws ProductoException {
		this.codigoProducto=ultimoCodigoGenerado+1;
		this.descripcion = descripcion;
		this.precioSinIva = precioSinIva;
		this.categoria = categoria;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioSinIva() {
		return precioSinIva;
	}

	public void setPrecioSinIva(double precioSinIva)throws ProductoException {
		if (precioSinIva<0) {
			throw new ProductoException("Error el precio no puede ser negativo");
		}
		this.precioSinIva = precioSinIva;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double calcularPrecioConIva() {
		double iva = categoria.getIva();
		double precioConIva = precioSinIva + (precioSinIva * iva / 100);
		return precioConIva;
	}

}
