package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Nombre {
	
	HashMap<String, List<String[]>> listaNombres = new HashMap<String, List<String[]>>();
	
	public Nombre() {
				
		try
		{
			Scanner scanner = new Scanner( new File("src/txt/names.txt"));
			String linea = scanner.nextLine();
			
			String[] tipos = linea.split(",");
			
			for (int i = 0; i < tipos.length; i++) {
				List<String[]> nombreTipo = new ArrayList<String[]>();
				listaNombres.put(tipos[i],  nombreTipo);
			}
			
			while (scanner.hasNextLine()) {
				linea = scanner.nextLine();
				
				String[] split = linea.split(",");
				
				listaNombres.get(split[0]).add(split);
				
			}
			scanner.close();
		}
		catch (FileNotFoundException ex) {
			System.err.println("El fichero no existe. " + ex);
		}



	}
	
	public String getNombre(String c, int n) {
		
		return this.listaNombres.get(c).get(n)[1];
	}
	
	public String generarNombre(String b) {
		Random r1 = new Random();
		return this.listaNombres.get(b).get(r1.nextInt(this.listaNombres.get(b).size()))[1];
	}
}
