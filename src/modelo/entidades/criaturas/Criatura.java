/*
 * 
 */
package modelo.entidades.criaturas;

import java.util.Random;

import modelo.Acciones;
import modelo.nombres;
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
		this.setDanio(this.obtenerRandom(11, 10));
		this.setDefensa(this.obtenerRandom(11, 10));
		this.setVidaMax(this.getVida());
		this.tipo = "Basilisco";
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
	public int atacar(Personaje objetivo) {

		// TODO Añadir daño de arma y/o equipamiento mas adelante
		int dmgInflingido;
		int dmg;
		Random r1 = new Random();
		int randomAtaque = this.obtenerValorDadoAtaque(r1.nextInt(this.obtenerLongitudDadoAtaque()));
		int randomDefensa = this.obtenerValorDadoDefensa(r1.nextInt(this.obtenerLongitudDadoDefensa()));
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
	

	
	
}
