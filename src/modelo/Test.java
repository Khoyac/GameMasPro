/*
 * 
 */

package modelo;

import modelo.Personajes.Guerrero;
import modelo.Personajes.Mago;
import modelo.Personajes.Personaje;

// TODO: Auto-generated Javadoc
/**
 * The Class Test.
 */
public class Test {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		Personaje pj1 = new Guerrero();
		Personaje pj2 = new Mago();

		System.out.println("Guerrero " + pj1.toString());
		System.out.println("Mago " + pj2.toString());

		pj1.recibirExperiencia(10000);
		System.out.println("Guerrero " + pj1.toString());

	}

}
