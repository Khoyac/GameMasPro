/*
 * 
 */

package modelo;

import modelo.criaturas.Basilisco;
import modelo.criaturas.Criatura;
import modelo.criaturas.Sucubo;
import modelo.criaturas.Trol;
import modelo.personajes.Guerrero;
import modelo.personajes.Mago;
import modelo.personajes.Personaje;

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

		Criatura c1 = new Basilisco();
		Criatura c2 = new Sucubo();
		Criatura c3 = new Trol();	

		System.out.println("Generando Combates para el Mago");

		pj2.combatir(c1);

	}

}
