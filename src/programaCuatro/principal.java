
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
			        		
			        		Date date = null;
			        		DateFormat formato = null;
			        		
			        		formato = new SimpleDateFormat("mm-dd-yyyy");
			        		     			    
			        		date = formato.parse(tiempo.getDate());
			        	    formato = new SimpleDateFormat("yyyy-mm-dd");
			        		String fecha1Conversion = formato.format(date);
			        		
			        		date = new Date(Long.parseLong(tiempo.getMilliseconds_since_epoch()));
			                formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			                String fecha2Conversion = formato.format((Long.parseLong(tiempo.getMilliseconds_since_epoch())));		           
			                formato.setTimeZone(TimeZone.getTimeZone("America/Mexico_City"));
			                fecha2Conversion = formato.format(date);

			                formato = new SimpleDateFormat("HH:mm:ss");
			                String fecha3Conversion = formato.format(formato.parse(tiempo.getTime()));
			            	
			                System.out.println(tiempo.getDate());  
			            	System.out.println(tiempo.getMilliseconds_since_epoch());
			                System.out.println(tiempo.getTime());
			                
			            	System.out.println("Conversion 1:" + fecha1Conversion);
			            	System.out.println("Conversion 2: " + fecha2Conversion);
			                System.out.println("Conversion 3: " + fecha3Conversion);
			        	
			        	     Thread.sleep(5000);
			            }

			        } catch (InterruptedException e) {
			            // TODO Auto-generated catch block
			            e.printStackTrace();
			        } catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			}).start();
	}
}