/*
 * 
 */
package modelo.entidades.criaturas;

import java.util.Random;

import modelo.Acciones;
import modelo.entidades.Entidad;
import modelo.entidades.personajes.Personaje;

/**
 * The Class Criatura.
 */
public abstract class Criatura extends Entidad implements Acciones, AccionesCriaturas {

	String nombre;

	int nivel;

	Random r1 = new Random();

	public Criatura(String nombre) {
		super();
		this.nombre = nombre;
		this.setVida(r1.nextInt(11) + 10);
		this.setDanio(r1.nextInt(11) + 10);
		this.setDefensa(r1.nextInt(11) + 10);
		this.setVidaMax(this.getVida());

	}

	public String toString() {

		// Utilizar doble %% para que java lo interprete
		return String.format("Nivel %d\nVida - %d\nDa�o - %d\nDefensa - %d\n", this.getNivel(), this.getVida(),
				this.getDanio(), this.getDefensa());
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

		dmg = (this.getDanio() + randomAtaque) - (objetivo.getDefensa() + randomDefensa);
		dmgInflingido = dmg;

		if (dmg < 0) {
			System.out.println("La criatura esta confusa, se ha herido a si misma");
			this.setVida(this.getVida() - (dmg * -1));
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

}
