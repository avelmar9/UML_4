package calculadora.dominio;

/**
 * Enumeración de los tipos de comando que puede interpretar la calculadora.
 */
public enum TipoComando {
	/** Reinicia el historial y el resultado actual. */
	RESET,

	/** Muestra el historial de operaciones. */
	LIST,

	/** Devuelve el resultado actual. */
	RESULT,

	/** Apaga la calculadora. */
	QUIT,

	/** Indica que la entrada es una operación aritmética. */
	CALCULO,

	/** Indica que la entrada contiene un error. */
	ERROR
}
