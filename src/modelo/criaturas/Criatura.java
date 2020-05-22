/*
 * 
 */
package modelo.criaturas;

import java.util.Random;

import modelo.Acciones;
import modelo.personajes.Personaje;

/**
 * The Class Criatura.
 */
public abstract class Criatura implements Acciones, AccionesCriaturas {

	/** The vida. */
	int vida;

	/** The danio. */
	int danio;

	/** The defensa. */
	int defensa;

	int vidaMax;

	String nombre;

	int nivel;

	Random r1 = new Random();

	public Criatura(String nombre) {
		super();
		this.nombre = nombre;
		this.vida = r1.nextInt(20) + 20;
		this.danio = r1.nextInt(20) + 10;
		this.defensa = r1.nextInt(20) + 1;
		this.vidaMax = this.vida;

	}

	@Override
	public int atacar(Personaje objetivo) {

		// TODO Añadir daño de arma y/o equipamiento mas adelante
		int dmgInflingido;
		int dmg;
		Random r1 = new Random();
		int randomAtaque = r1.nextInt(10) + 10;
		int randomDefensa = r1.nextInt(20) + 1;
		int barreraObjetivo = objetivo.getBarrera();

		dmg = (this.danio + randomAtaque) - (objetivo.getDefensa() + randomDefensa);
		dmgInflingido = dmg;

		if (dmg < 0) {
			System.out.println("La criatura esta confusa, se ha herido a si misma");
			this.vida -= dmg * -1;
		} else {

			// Si el objetivo tiene barrera, el daño le afecta primero a esta

			if (barreraObjetivo >= 1) {

				dmg -= barreraObjetivo;

				// Si el daño se queda en negativo despues de golpear
				// El daño pasa a ser la barrera restante y asestara un golpe de 0
				if (dmg <= 0) {

					objetivo.setBarrera(dmg * -1);
					dmg = 0;
				} else {
					objetivo.setBarrera(0);
					barreraObjetivo = objetivo.getBarrera();
				}
			}

			// Si el objetivo no tiene barrera, golpea
			if (barreraObjetivo == 0) {

				objetivo.setVida(objetivo.getVida() - (int) dmg);

			}
		}
		return dmgInflingido;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getVida() {
		return this.vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getVidaMax() {
		return vidaMax;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

}
