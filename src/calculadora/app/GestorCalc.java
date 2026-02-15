package calculadora.app;

import java.util.Scanner;

import calculadora.dominio.Calculadora;

public class GestorCalc {

	private Scanner sc = new Scanner(System.in);
	private Calculadora calculadora = new Calculadora();

	public void iniciar() {

		boolean continuar = true;

		while (continuar) {
			System.out.println("------------------");
			System.out.println(">");
			String entrada = sc.nextLine();
			calculadora.procesarComando(entrada);

			if (entrada.equals("quit")) {
				continuar = false;
			}
		}

	}

	public static void main(String[] args) {
		System.out.println("CALCULADORA");

		new GestorCalc().iniciar();
	}
}
