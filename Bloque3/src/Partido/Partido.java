package Partido;

public class Partido {

	private static final int MAXIMA_JORNADA = 38;
	private static final int MINIMA_JORNADA = 1;
	// Atributos
	private int jornada;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private int golesLocal;
	private int golesVisitante;
	private char resultadoQuiniela; // '1', 'X', '2'

	// Constructor
	public Partido(int jornada, Equipo equipoLocal, Equipo equipoVisitante) throws PartidoException {
	setJornada(jornada);
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.golesLocal = -1; // Valor por defecto indicando que el partido no se ha jugado
		this.golesVisitante = -1;
		this.resultadoQuiniela = '-';
	}

	
	
	private void setJornada(int jornada) throws PartidoException {
		if (jornada<MINIMA_JORNADA||jornada <MAXIMA_JORNADA) {
			throw new PartidoException("Jornada fuera de rango");
		}
		this.jornada = jornada;
	}



	public int getJornada() {
		return jornada;
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public char getResultadoQuiniela() {
		return resultadoQuiniela;
	}

	// Método para establecer el resultado del partido
	public void ponerResultado(String resultado) throws PartidoException {
		if (resultadosValidos(resultado)) {
			String[] goles = resultado.split("-");
			this.golesLocal = Integer.parseInt(goles[0]);
			this.golesVisitante = Integer.parseInt(goles[1]);

			actualizarResultados();
		} else {
			throw new PartidoException("Formato de resultado incorrecto");
		}
	}

	// Método privado para verificar la validez del resultado
	private boolean resultadosValidos(String resultado) {
		boolean formatoCorrecto = true;

		// Verificar longitud de la cadena
		if (resultado.length() != 3) {
			formatoCorrecto = false;
		} else {
			// Verificar que los caracteres sean válidos
			char[] caracteres = resultado.toCharArray();
			if (!Character.isDigit(caracteres[0]) || caracteres[1] != '-' || !Character.isDigit(caracteres[2])) {
				formatoCorrecto = false;
			}
		}

		return formatoCorrecto;
	}

	// Método privado para actualizar los resultados y partidos ganados de los
	// equipos
	private void actualizarResultados() {
		// Actualizar partidos ganados de los equipos
		if (golesLocal > golesVisitante) {
			equipoLocal.incrementarPartidosGanados();
		} else if (golesLocal < golesVisitante) {
			equipoVisitante.incrementarPartidosGanados();
		}

		// Calcular resultado de la quiniela
		if (golesLocal > golesVisitante) {
			resultadoQuiniela = '1';
		} else if (golesLocal < golesVisitante) {
			resultadoQuiniela = '2';
		} else {
			resultadoQuiniela = 'X';
		}
	}

	@Override
	public String toString() {
		if (golesLocal == -1 || golesVisitante == -1) {
			return "Partido entre equipo local " + equipoLocal.getNombreEquipo() + " y equipo visitante "
					+ equipoVisitante.getNombreEquipo() + " todavía no se ha jugado";
		} else {
			return "Partido entre equipo local " + equipoLocal.getNombreEquipo() + " y equipo visitante "
					+ equipoVisitante.getNombreEquipo() + " jugado en el estadio " + equipoLocal.getNombreEstadio()
					+ " de la ciudad " + equipoLocal.getCiudad() + " ha finalizado con " + golesLocal
					+ " goles de equipo local y " + golesVisitante + " goles de equipo visitante. Resultado quiniela= "
					+ resultadoQuiniela;
		}
	}
}
