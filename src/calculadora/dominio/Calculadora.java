package calculadora.dominio;

import java.util.ArrayList;
import java.util.List;

import calculadora.app.Analizador;

/**
 * Clase principal de la calculadora. Gestiona el resultado actual, el historial
 * de operaciones y delega el análisis de entradas al Analizador.
 */
public class Calculadora {

	/** Último resultado calculado. Se inicializa a 0. */
	private double resultadoActual;

	/** Analizador encargado de interpretar la entrada del usuario. */
	private Analizador analizador = new Analizador();

	/** Historial de operaciones realizadas. */
	private List<String> historial;

	/**
	 * Constructor por defecto. Inicializa el resultado actual a 0 y el historial
	 * vacío.
	 */
	public Calculadora() {
		this.resultadoActual = 0;
		this.historial = new ArrayList<>();
	}

	/**
	 * Procesa una línea de entrada del usuario. Según el comando detectado por el
	 * Analizador, ejecuta: RESET: limpia el historial y reinicia el resultado.
	 * QUIT: muestra mensaje de apagado. LIST: muestra el historial. RESULT:devuelve
	 * el resultado actual. CALCULO: realiza la operación y guarda en historial.
	 * ERROR: muestra el mensaje de error.
	 * 
	 * @param entrada introducida por el usuario
	 */
	public void procesarComando(String entrada) {
		ResultadoAnalisis analisis = analizador.analizar(entrada, resultadoActual);
		Operacion operacion = new Operacion();

		switch (analisis.comando()) {
		case RESET -> limpiarHistorial();
		case QUIT -> System.out.println("Apagando calculadora zzz");
		case LIST -> mostrarHistorial();
		case RESULT -> getResultadoActual();
		case CALCULO -> {
			double result;
			result = operacion.calcular(analisis.numeros(), analisis.operadores());
			System.out.println(result);
			historial.add(entrada + " = " + result);
			resultadoActual = result;
		}
		case ERROR -> System.out.println("ERROR: " + analisis.mensajeError());
		}
	}

	/**
	 * Muestra por pantalla todas las operaciones del historial y el resultado
	 * actual al final.
	 */
	public void mostrarHistorial() {
		for (int i = 0; i < historial.size(); i++) {
			System.out.println(historial.get(i));
		}
		System.out.println("Resultado actual: " + resultadoActual);
	}

	/**
	 * Limpia el historial de operaciones y reinicia el resultado actual a 0.
	 */
	public void limpiarHistorial() {
		historial.clear();
		resultadoActual = 0;
	}

	/**
	 * Devuelve el último resultado calculado.
	 *
	 * @return el resultado actual
	 */
	public double getResultadoActual() {
		return resultadoActual;
	}
}