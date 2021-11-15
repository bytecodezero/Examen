
package programaCuatro;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class principal {
	
	private static final String REST_URI =  "http://date.jsontest.com/" ;
	private static Client cliente = ClientBuilder.newClient();
	
	public static Tiempo getJsonTime() {
		return cliente.target(REST_URI).request(MediaType.APPLICATION_JSON).get(Tiempo.class);
		
	}

	public static void main(String[] args) {

		  new Thread(new Runnable() {
			    public void run() {
			        try {
			           for(int i = 0; i<10; i++) {
			        	   
			        		Tiempo tiempo = new Tiempo();
			        		tiempo = getJsonTime();
			         
	
			        		System.out.println(tiempo.getDate());
			        		System.out.println(tiempo.getMilliseconds_since_epoch());
			        		System.out.println(tiempo.getTime());
			        		
			        	
			        	     Thread.sleep(5000);
			            }

			        } catch (InterruptedException e) {
			            // TODO Auto-generated catch block
			            e.printStackTrace();
			        }
			    }
			}).start();

	}
}