/*
 * 
 */
package modelo.Personajes;

// TODO: Auto-generated Javadoc
/**
 * The Class Guerrero.
 */
public class Guerrero extends Humano {

	// Atributos

	// Constructores

	/**
	 * Instantiates a new guerrero.
	 */
	public Guerrero() {
		// genero stadisticas aleatorias * max min
		this.vida = (int) (Math.random() * 11 + 4);
		this.danio = (int) (Math.random() * 10 + 5);
		this.defensa = (int) (Math.random() * 7 + 8);
		this.habilidad = (int) (Math.random() * 15);
		this.destreza = (int) (Math.random() * 14 + 1);
		this.inteligencia = (int) (Math.random() * 15);
	}

	/**
	 * Mover.
	 *
	 * @return the int
	 */
	@Override
	public int mover() {
		return 0;
	}

	/**
	 * Atacar.
	 *
	 * @return the int
	 */
	@Override
	public int atacar() {
		return 0;
	}

	/**
	 * Defender.
	 *
	 * @return the int
	 */
	@Override
	public int defender() {
		return 0;
	}

	/**
	 * Lanzar habilidad.
	 *
	 * @return the int
	 */
	@Override
	public int lanzarHabilidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
