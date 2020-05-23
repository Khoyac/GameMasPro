/*
 * 
 */

package modelo;

import modelo.entidades.criaturas.Basilisco;
import modelo.entidades.criaturas.Criatura;
import modelo.entidades.criaturas.Sucubo;
import modelo.entidades.criaturas.Trol;
import modelo.entidades.personajes.Guerrero;
import modelo.entidades.personajes.Personaje;

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

		System.out.println("Guerrero " + pj1.toString());

		Criatura c1 = new Basilisco();
		Criatura c2 = new Sucubo();
		Criatura c3 = new Trol();

		System.out.printf("%s %s\n", c2.getNombre(), c2.toString());

		System.out.println("Generando Combates para el Mago");

		pj1.combatir(c2);

	}

}
