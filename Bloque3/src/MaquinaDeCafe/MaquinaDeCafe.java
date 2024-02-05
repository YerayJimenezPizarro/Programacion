package MaquinaDeCafe;

public class MaquinaDeCafe {
	public static double PRECIO_CAFE = 1;
	public static double PRECIO_lECHE = 0.8;
	public static double PRECIO_CAFE_CON_LECHE = 1.5;
	public static int MAXIMO_DOSIS_CAFE = 50;
	public static int MAXIMO_DOSIS_LECHE = 50;
	public static int MAXIMO_DOSIS_VASOS = 80;

	private double monedero;
	private int vasos;
	private int dosisCafe;
	private int dosisLeche;

	public MaquinaDeCafe(double monedero) {
		this.monedero = monedero;
	}

	public double getMonedero() {
		return monedero;
	}

	public int getVasos() {
		return vasos;
	}

	public int getDosisCafe() {
		return dosisCafe;
	}

	public int getDosisLeche() {
		return dosisLeche;
	}

	public void llenarDepositos() {
		dosisCafe = MAXIMO_DOSIS_CAFE;
		dosisLeche = MAXIMO_DOSIS_LECHE;
		vasos = MAXIMO_DOSIS_VASOS;
	}

	public void vaciarMonedero() {
		monedero = 0;
	}

	public void reponerMonedero(double nuevoMonedero) {
		if (nuevoMonedero < 0) {
			System.out.println("Error: el monedero no puede ser negativo");
		} else {
			monedero = nuevoMonedero;
		}
	}

	public double servirCafe(double dineroIntroducido) {
		double cambio = 0;
		if (dineroIntroducido < PRECIO_CAFE) {
			System.out.println("Error: Dinero insuficiente para el café");
		} else {
			cambio = dineroIntroducido - PRECIO_CAFE;
			monedero += PRECIO_CAFE;
			if (MAXIMO_DOSIS_CAFE > 0 && MAXIMO_DOSIS_VASOS > 0) {
				MAXIMO_DOSIS_CAFE--;
				MAXIMO_DOSIS_VASOS--;
			} else {
				System.out.println("Error: No hay suficientes dosis o vasos disponibles");
			}
		}
		return cambio;
	}

	public double servirLeche(double dineroIntroducido) {
		double cambio = 0;
		if (dineroIntroducido < PRECIO_lECHE) {
			System.out.println("Error: Dinero insuficiente para la leche");
		} else {
			cambio = dineroIntroducido - PRECIO_lECHE;
			monedero += PRECIO_lECHE;
			if (MAXIMO_DOSIS_LECHE > 0 && MAXIMO_DOSIS_VASOS > 0) {
				MAXIMO_DOSIS_LECHE--;
				MAXIMO_DOSIS_VASOS--;
			} else {
				System.out.println("Error: No hay suficientes dosis o vasos disponibles");
			}
		}
		return cambio;
	}

	public double servirCafeConLeche(double dineroIntroducido) {
		double cambio = 0;
		if (dineroIntroducido < PRECIO_CAFE_CON_LECHE) {
			System.out.println("Error: Dinero insuficiente para el café con leche");
		} else {
			cambio = dineroIntroducido - PRECIO_CAFE_CON_LECHE;
			monedero += PRECIO_CAFE_CON_LECHE;
			if (MAXIMO_DOSIS_LECHE > 0 && MAXIMO_DOSIS_CAFE > 0 && MAXIMO_DOSIS_VASOS > 0) {
				MAXIMO_DOSIS_LECHE--;
				MAXIMO_DOSIS_CAFE--;
				MAXIMO_DOSIS_VASOS--;
			} else {
				System.out.println("Error: No hay suficientes dosis o vasos disponibles");
			}
		}
		return cambio;
	}
}
