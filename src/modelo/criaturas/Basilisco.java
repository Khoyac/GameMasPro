/*
 * 
 */
package modelo.criaturas;

import java.util.Random;

import modelo.personajes.Personaje;

/**
 * The Class Basilisco.
 */
public class Basilisco extends Criatura {

	public Basilisco() {
		super("Basilisco");

		this.danio = 2;

	}

	@Override
	public int mover() {
		// TODO Auto-generated method stub
		return 0;
	}
//
//	@Override
//	public int atacar(Personaje objetivo) {
//
//		int dmg;
//		Random r1 = new Random();
//		int random = r1.nextInt(4) + 1;
//
//		dmg = (this.danio / random);
//		if (random == 1) {
//			System.out.println("El golpe ha sido Critico!");
//		}
//
//		objetivo.setVida(objetivo.getVida() - dmg);
//		return dmg;
//
//	}
	
	
	@Override
	public int atacar(Personaje objetivo) {

		// TODO Añadir daño de arma y/o equipamiento mas adelante

		int dmg;
		Random r1 = new Random();
		int random = r1.nextInt(4) + 1;

		dmg = (this.danio / random);
		objetivo.setVida(objetivo.getVida() - dmg);

		return dmg;
	}
	

	@Override
	public int defender() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lanzarHabilidad() {
		// TODO Auto-generated method stub
		return 0;
	}

}
