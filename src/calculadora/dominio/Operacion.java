package calculadora.dominio;

import java.util.List;

public class Operacion {

	public double calcular(List<Double> numeros, List<TipoOperador> operadores) {
		double resultado = numeros.get(0);
		double siguiente;

		for (int i = 0; i < operadores.size(); i++) {
			siguiente = numeros.get(i + 1);
			resultado = aplicarOperador(resultado, siguiente, operadores.get(i));
		}

		return resultado;
	}

	private double aplicarOperador(double num1, double num2, TipoOperador tipoOperador) {
		return switch (tipoOperador) {
		case SUMA -> num1 + num2;
		case RESTA -> num1 - num2;
		case MULTIPLICACION -> num1 * num2;
		case DIVISION -> num1 / num2;
		};

	}

}
