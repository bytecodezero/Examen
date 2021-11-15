package programaDos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private final static int PUERTO = 9080;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("Servidor Iniciado");

		ServerSocket server = new ServerSocket(PUERTO);

		while (true) {

			System.out.println("Esperando la peticion del cliente");

			Socket socket = server.accept();

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

			String peticionCliente = (String) ois.readObject();

			System.out.println("El cliente envio: " + peticionCliente);

			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			if (peticionCliente.equalsIgnoreCase("Finalizar")) {
				System.out.println("Apagando servidor");
				server.close();
				break;

			} else {
				oos.writeObject(
						"El número recibido " + peticionCliente + " " + esPar(Integer.parseInt(peticionCliente)));
			}
			ois.close();
			oos.close();
			socket.close();
		}
	}

	public static String esPar(int numero) {
		return numero % 2 == 0 ? "es par" : "no es par";
	}

}
