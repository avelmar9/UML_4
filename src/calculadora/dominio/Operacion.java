package calculadora.dominio;

import java.util.List;

/**
 * Clase que realiza operaciones aritméticas sobre listas de números y
 * operadores. Las operaciones se aplican de izquierda a derecha, sin prioridad
 * de operadores.
 */
public class Operacion {

	/**
	 * Calcula el resultado de aplicar secuencialmente los operadores sobre los
	 * números. La lista de números debe tener exactamente un elemento más que la
	 * lista de operadores.
	 * 
	 * @param numeros    lista de operandos
	 * @param operadores lista de operadores
	 * @return resultado de la operación completa
	 */
	public double calcular(List<Double> numeros, List<TipoOperador> operadores) {
		double resultado = numeros.get(0);
		double siguiente;

		for (int i = 0; i < operadores.size(); i++) {
			siguiente = numeros.get(i + 1);
			resultado = aplicarOperador(resultado, siguiente, operadores.get(i));
		}

		return resultado;
	}

	/**
	 * Aplica un operador aritmético sobre dos operandos.
	 *
	 * @param num1         primer operando
	 * @param num2         segundo operando
	 * @param tipoOperador operador a aplicar
	 * @return resultado de la operación
	 */
	private double aplicarOperador(double num1, double num2, TipoOperador tipoOperador) {
		return switch (tipoOperador) {
		case SUMA -> num1 + num2;
		case RESTA -> num1 - num2;
		case MULTIPLICACION -> num1 * num2;
		case DIVISION -> num1 / num2;
		};
	}
}