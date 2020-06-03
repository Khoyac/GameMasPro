package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Nombre {
	
	String[] criatura = new String[3];
	List<String[]> listaCriaturas = new ArrayList<String[]>();
	
	public Nombre() {
		
		try
		{
			Scanner scanner = new Scanner( new File("src/txt/names.txt"));
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				
				String[] split = linea.split(",");
				
				listaCriaturas.add(split);
			}
			scanner.close();
		}
		catch (FileNotFoundException ex) {
			System.err.println("El fichero no existe. " + ex);
		}



	}
	
	public String generarNombre() {
		Random r1 = new Random();
		
		return listaCriaturas.get( r1.nextInt(listaCriaturas.size()-1) )[1];
	}
}
