package calculadora.dominio;

import java.util.ArrayList;
import java.util.List;

import calculadora.app.Analizador;

public class Calculadora {
	private double resultadoActual;
	private Analizador analizador = new Analizador();
	private List<String> historial;;

	public Calculadora() {
		this.resultadoActual = 0;
		this.historial = new ArrayList<>();
	}

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

	public void mostrarHistorial() {
		for (int i = 0; i < historial.size(); i++) {
			System.out.println(historial.get(i));
		}
		System.out.println("Resultado actual: " + resultadoActual);
	}

	public void limpiarHistorial() {
		historial.clear();
		resultadoActual = 0;
	}

	public double getResultadoActual() {
		return resultadoActual;

	}
}
