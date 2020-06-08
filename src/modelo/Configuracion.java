package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Configuracion {

	public static HashMap<String, String> config = new HashMap<String, String>();
	
	public Configuracion() {
		
		try
		{
			Scanner scanner = new Scanner( new File("conf.txt"));
			String linea;
			
			while (scanner.hasNextLine()) {
				linea = scanner.nextLine();
				
				String[] aux = linea.split(":");
				
 				Configuracion.config.put(aux[0],aux[1]);
			}
			scanner.close();
		}
		catch (FileNotFoundException ex) {
			System.err.println("El fichero no existe. " + ex);
		}
		
	}
	
	
	
	public static HashMap<String, String> getConfig() {
		return config;
	}


	public static void cambiarConfiguracion(String s, String n) {
		
		config.put(s, n);
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("src/txt/conf.txt");
            pw = new PrintWriter(fichero);

            for (Entry<String, String> entry : config.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                
                pw.println(key+":"+value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	
	
}
