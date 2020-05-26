/*
 * 
 */

package modelo;

import java.io.IOException;

import modelo.entidades.criaturas.Basilisco;
import modelo.entidades.criaturas.Criatura;
import modelo.entidades.criaturas.Sucubo;
import modelo.entidades.criaturas.Trol;
import modelo.entidades.personajes.Guerrero;
import modelo.entidades.personajes.Mago;
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
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

//		Personaje pj1 = new Mago();
//
//		System.out.println("Mago " + pj1.toString());
//
//		Criatura c1 = new Basilisco();
//		Criatura c2 = new Sucubo();
//		Criatura c3 = new Trol();
//
//		System.out.printf("%s %s\n", c3.getNombre(), c3.toString());
//
//		System.out.println("Generando Combates para el Mago");
//
//		pj1.combatir(c3);

		Mapa mapa = new Mapa("1", "PruebaJava7");

		mapa.descargar_crear_XML();
		mapa.leerInformacionXML();

		System.out.println("ID " + mapa.getIdMazmorra());
		System.out.println("Nivel " + mapa.getNivelMazmorra());
		System.out.println("Inicio " + mapa.getInicioMazmorra());
		System.out.println("Boss " + mapa.getBoss(1));
		System.out.println("Cofre " + mapa.getCofre(1));
		System.out.println("MiniBoss " + mapa.getMiniBoss(1));

	}

}
