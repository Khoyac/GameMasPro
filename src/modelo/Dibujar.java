package modelo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

public class Dibujar {
	
	
	public static int[][] colores = {
			{255, 000, 000}, //0.- Rojo
			{000, 255, 000}, //1.- Verde
			{000, 000, 255}, //2.- Azul
	};
	
	public int ROJO = 0;
	
	public static void darColor(BufferedImage image, int a, int b, int c, int x, int y) {
		Color col = new Color(a,b,c); 
		image.setRGB(y, x, col.getRGB());
	}
	
	public static void crearImagen(char[][] data, int tipo){
		long nombre;
		String ruta = "";
		BufferedImage image = new BufferedImage(data.length,data[0].length, BufferedImage.TYPE_INT_RGB);
		
		
		for (int y = 0; y < data.length; y++) {
			for (int x = 0; x < data[0].length; x++) {

				darColor(image, colores[data[y][x]][0], colores[data[y][x]][1], colores[data[y][x]][2], y, x);

			}
		}

		try {
			Date fecha = new Date();
			nombre = fecha.getTime();
			if (tipo == 1 ) {
				ruta = "/dungeons/" + nombre + ".png";
			} else if (tipo == 2 ) {
				ruta = "/maps/" + nombre + ".png";
			}
			// retrieve image
			File outputfile = new File(ruta);
			outputfile.createNewFile();

			ImageIO.write(image, "png", outputfile);
		} catch (IOException e) {
			//o no! Blank catches are bad
			throw new RuntimeException("I didn't handle this very well");
		}
	}

	

}
