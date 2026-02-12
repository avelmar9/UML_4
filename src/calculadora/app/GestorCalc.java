package calculadora.app;

import java.util.Scanner;

import calculadora.dominio.Calculadora;

public class GestorCalc {
	Calculadora calculadora = new Calculadora();

	public void iniciar() {
		Scanner sc = new Scanner(System.in);

		System.out.println(">");
		String entrada = sc.nextLine();// condicionar comportamiento en funcion de si es un comando o una operacion
		calculadora.procesar(entrada);

	}

	public static void main(String[] args) {
		System.out.println("CALCULADORA");
		new GestorCalc().iniciar();
	}
}
