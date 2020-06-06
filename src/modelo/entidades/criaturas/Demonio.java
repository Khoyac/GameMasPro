package modelo.entidades.criaturas;

import java.util.Random;

import modelo.entidades.Entidad;
import modelo.entidades.personajes.Personaje;

public class Demonio extends Criatura {

	Random r1;

	public Demonio() {
		super("Demonio");
		r1 = new Random();

		this.inteligencia = this.obtenerRandom(20, 1);
		this.setVida(this.getVida() + r1.nextInt(this.getNivel() * 2) + 40);
		this.setDefensa(this.getDefensa() + r1.nextInt(5));
		this.setDanio(this.getDanio() + 5);
		this.setVidaMax(this.getVida());
		}

	public Demonio(int nivel) {
		this();
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("Inteligencia - %d\n", this.inteligencia);

	}

	public void defender(Personaje objetivo) {

		// Charm, Seduce por 1 turno, y evita el daño recibido del personaje seducido
		objetivo.anyadirEstadoAtaque("Seducido");
	}

	/**
	 * Lanzar habilidad.
	 *
	 * @return the int
	 */
	@Override
	public int lanzarHabilidad(Entidad e) {
		return destreza;

	}

}
