package MaquinaDeCafe;

/**
 * Realizar una programa en Java que sirva para simular una máquina de café. La
 * máquina tiene varios depósitos: - Un depósito de café con capacidad para 50
 * dosis. - Un depósito de leche con capacidad para 50 dosis. - Un depósito de
 * vasos con capacidad para 80 vasos.
 * 
 * También dispone de monedero con una cantidad de euros. Cuando se cree una
 * nueva máquina se hará con un monedero inicial y con los depósitos llenos. El
 * café cuesta 1 euro, la leche 0.8 euros y el café con leche 1.5 euros. Al
 * servir cada bebida debe descontarse una dosis de los depósitos
 * correspondientes, un vaso y añadir al monedero lo recaudado.
 * 
 * Cuando se sirva una bebida habrá que solicitar el dinero que va a introducir
 * el usuario. Si introduce una cantidad inferior al precio o no hay existencias
 * debe informarse con el error correspondiente. También debe producirse un
 * error si la máquina no tiene cambio de esa cantidad. Si puede dar cambio
 * informará con el mensaje “Recoge tu cambio de XX euros”.
 * 
 * La clase Maquina debe disponer al menos de los siguientes métodos. - Método
 * para llenar depósitos. No pueden llenarse los depósitos por separado. -
 * Método para vaciar monedero. - Método para consultar el estado de la máquina.
 * - Método para servir café sólo, leche o café con leche. Este método mostrará
 * los mensajes de error correspondientes o el mensaje "Producto servido".
 *
 */
public class MaquinaCafe {

	private static final int MAXIMO_CAFE = 50;
	private static final int MAXIMO_LECHE = 50;
	private static final int MAXIMO_VASOS = 5;
	public static final double PRECIO_CAFE = 1;
	public static final double PRECIO_LECHE = 0.8;
	public static final double PRECIO_CAFE_CON_LECHE = 1.5;

	private int depositoCafe;
	private int depositoLeche;
	private int depositoVasos;
	private double monedero;

	// Contructor
	public MaquinaCafe(double monederoInicial) throws MaquinaCafeException {
		llenarDepositos();
		setMonedero(monederoInicial);

	}

	/**
	 * Método setMonedero
	 * 
	 * @param monedero
	 * @throws MaquinaCafeException
	 */
	private void setMonedero(double monedero) throws MaquinaCafeException {
		if (monedero <= 0) {
			throw new MaquinaCafeException("No puede darse valor " + monedero + " al monedero");
		} else {
			this.monedero = monedero;
		}

	}

	public void llenarDepositos() {
		depositoCafe = MAXIMO_CAFE;
		depositoLeche = MAXIMO_LECHE;
		depositoVasos = MAXIMO_VASOS;
	}

	// Métodos gets
	public int getDepositoCafe() {
		return depositoCafe;
	}

	public int getDepositoLeche() {
		return depositoLeche;
	}

	public int getDepositoVasos() {
		return depositoVasos;
	}

	public double getMonedero() {
		return monedero;
	}

	public double servirCafe(double dinero) throws MaquinaCafeException {
		double cambio = 0;

		if (dinero < PRECIO_CAFE) {
			cambio = dinero;
			throw new MaquinaCafeException("No has introducido suficiente dinero. Cuesta: " + PRECIO_CAFE);
			
		} else {
			cambio = dinero - PRECIO_CAFE;
			if (cambio > monedero) {
				throw new MaquinaCafeException("No puedo servir porque no tengo cambio. Recoge tu dinero.");
			} else {
				if (depositoVasos == 0 || depositoCafe == 0) {
					cambio = dinero;
					throw new MaquinaCafeException("Producto o vasos agotados.");
					
				} else {
					depositoCafe--;
					depositoVasos--;
					monedero = monedero + PRECIO_CAFE;
				}
			}

		}

		return cambio;
	}

	public double servirLeche(double dinero) throws MaquinaCafeException {
		double cambio = 0;
		if (dinero < PRECIO_LECHE) {
				cambio = dinero;
				throw new MaquinaCafeException("No has introducido suficiente dinero. Cuesta: " + PRECIO_LECHE);
		
		} else {
			cambio = dinero - PRECIO_CAFE;
			if (cambio > monedero) {
				throw new MaquinaCafeException("No puedo servir porque no tengo cambio. Recoge tu dinero.");
			} else {
				if (depositoVasos == 0 || depositoLeche == 0) {
					cambio = dinero;
					throw new MaquinaCafeException("Producto o vasos agotados.");
					
				} else {

					depositoLeche--;
					depositoVasos--;
					monedero = monedero + PRECIO_LECHE;
				}
			}

		}

		return cambio;
	}

	public double servirCafeconLeche(double dinero) throws MaquinaCafeException {
		double cambio = 0;

		if (dinero < PRECIO_CAFE_CON_LECHE) {
			cambio = dinero;
			throw new MaquinaCafeException("No has introducido suficiente dinero. Cuesta: " + PRECIO_LECHE);

		} else {
			cambio = dinero - PRECIO_CAFE_CON_LECHE;
			if (cambio > monedero) {
				throw new MaquinaCafeException("No puedo servir porque no tengo cambio. Recoge tu dinero.");
			} else {
				if (depositoVasos == 0 || depositoLeche == 0 || depositoCafe == 0) {
					cambio = dinero;
					throw new MaquinaCafeException("Producto o vasos agotados.");

				} else {
					depositoCafe--;
					depositoLeche--;
					depositoVasos--;
					monedero = monedero + PRECIO_CAFE_CON_LECHE;
				}
			}

		}
		return cambio;

	}

	public double vaciarMonedero() {
		double monederoAVaciar;
		monederoAVaciar = this.monedero;
		this.monedero = 0;
		return monederoAVaciar;
	}

	public void incrementarMonedero(double cantidad) throws MaquinaCafeException {
		if (cantidad <= 0) {
			throw new MaquinaCafeException("La cantidad debe ser positiva ");
		} else {
			monedero = monedero + cantidad;
		}
	}

	public String toString() {
		return "Máquina:\n Depósito de café: " + depositoCafe + "\n Depósito de leche: " + depositoLeche
				+ "\n Depósito de vasos: " + depositoVasos + "\n Monedero: " + monedero + "€";
	}
}