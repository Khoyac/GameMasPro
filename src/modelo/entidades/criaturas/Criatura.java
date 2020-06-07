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

	String tipo;
	String nombre;

	int nivel;
	int inteligencia;
	int destreza;

	public Criatura() {
		super();

		this.setVida(this.obtenerRandom(11, 10));
		this.setDanio(this.obtenerRandom(11, 5));
		this.setDefensa(this.obtenerRandom(11, 0));
		this.setVidaMax(this.getVida());
		this.tipo = "Golem";
	}

	public Criatura(int nivelMapa) {
		this();

	}

	public Criatura(String tipo) {
		this();
		this.tipo = tipo;

	}

	public String toString() {

		// Utilizar doble %% para que java lo interprete
		return String.format("%s:\nNivel %d\nVida - %d\nDa�o - %d\nDefensa - %d\n", this.tipo, this.getNivel(),
				this.getVida(), this.getDanio(), this.getDefensa());
	}

	@Override
	public int atacar(Personaje objetivo) throws InterruptedException {

		// TODO Añadir daño de arma y/o equipamiento mas adelante
		int dmgInflingido;
		int dmg;
		Random r1 = new Random();
		int randomAtaque = this.obtenerValorDadoAtaque(r1.nextInt(this.obtenerLongitudDadoAtaque()));
		this.setLastRandom(randomAtaque);
		int randomDefensa = objetivo.obtenerValorDadoDefensa(r1.nextInt(objetivo.obtenerLongitudDadoDefensa()));
		objetivo.setLastRandom(randomDefensa);

		int barreraObjetivo = objetivo.getBarrera();

		dmg = (this.getDanio() + randomAtaque) - (objetivo.getDefensa() + randomDefensa);
		dmgInflingido = dmg;

		// Si el objetivo tiene barrera, el daño le afecta primero a esta
		if (dmg > 0) {

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

	public String getTipo() {
		return this.tipo;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void subirNivel(int nivel) {

		Random r1 = new Random();

		this.setNivel(nivel + r1.nextInt(2) - r1.nextInt(2));
		this.setVida(this.getVida() + (3 * this.getNivel()));
		this.setVidaMax(this.getVida());
		this.setDanio(this.getDanio() + (1 * this.getNivel()));
		this.setDefensa(this.getDefensa() + (1 * this.getNivel()));

		if (this.getTipo().equals("Ent")) {

			this.inteligencia += 1 * this.getNivel();

		} else if (this.getTipo().equals("Trol")) {

			this.destreza += 1 * this.getNivel();

		}

	}

}
