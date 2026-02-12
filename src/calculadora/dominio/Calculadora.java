package calculadora.dominio;

import calculadora.app.Analizador;

public class Calculadora {
	private double resultadoActual = 0.0;
	private Analizador analizador = new Analizador();

	public void procesar(String entrada) {
		ResultadoAnalisis analisis;
		Operacion operacion2 = new Operacion();
		analisis = analizador.analizar(entrada, resultadoActual);

		System.out.println(operacion2.calcular(analisis.numeros(), analisis.operadores()));
	}
}
