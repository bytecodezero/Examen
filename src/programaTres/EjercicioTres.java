package programaTres;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EjercicioTres {

	public static void main(String[] args) throws IOException {
		
		Path currentRelativePath = Paths.get("");
		String currentPath = currentRelativePath.toAbsolutePath().toString();
		System.out.println(currentPath);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");  
		Date date = new Date();  
		
		String nombreArchivo = sdf.format(date).toString();
		String ruta = currentPath + "/" + nombreArchivo + ".txt";
		
		
		String contenido="Hola mundo";
		
		File file = new File(ruta);
		
		if(!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter fw = new FileWriter(file);
		
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(contenido);
		bw.close();
		
		
	}
	
}
