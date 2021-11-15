package programaUno;

public class EjercicioUno {

	public static void main(String[] args) {

		String palabras[] = { "OSO", "luz azul", "somos o no somos", "ana", "paraguas" };

		for (String palabra : palabras) {
			System.out.println("La palabra " + palabra + " " + esPalindroma(palabra.replace(" ", "")));

		}

	}

	public static String esPalindroma(String palabra) {
		
	
		String respuesta = "no es palindroma";

		String palababraInvertida = new StringBuilder(palabra).reverse().toString();

		if (palabra.equalsIgnoreCase(palababraInvertida)) {
			respuesta = "si es palindroma";
		}

		return respuesta;
	}

}
