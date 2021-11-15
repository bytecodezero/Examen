package programaDos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args)
			throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {

		InetAddress host = InetAddress.getLocalHost();

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		Socket socket = null;

		for (int numeros = 1; numeros <= 11; numeros++) {
			socket = new Socket(host.getHostName(), 9080);

			
			oos = new ObjectOutputStream(socket.getOutputStream());
			if (numeros == 11) {
				oos.writeObject("Finalizar");
			} else {

				oos.writeObject("" + numeros);
			}
			
			
			ois = new ObjectInputStream(socket.getInputStream());
			String respuestaServidor = (String) ois.readObject();

			System.out.println("Respuesta servidor: " + respuestaServidor);
			ois.close();
			oos.close();
			Thread.sleep(100);
		}

	}

}
