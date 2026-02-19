package calculadora.app;

import java.util.Scanner;

import calculadora.dominio.Calculadora;

/**
 * Clase principal de la aplicación. Gestiona el bucle de interacción con el
 * usuario y delega el procesamiento de comandos a calculadora.
 */
public class GestorCalc {

	/** Scanner para leer la entrada del usuario por consola. */
	private Scanner sc = new Scanner(System.in);

	/** Instancia de la calculadora que procesa los comandos. */
	private Calculadora calculadora = new Calculadora();

	/**
	 * Inicia el bucle principal de la calculadora. Lee líneas del usuario y las
	 * pasa a procesarcomando en calculadora hasta que el usuario introduce 'quit'.
	 *
	 */
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
