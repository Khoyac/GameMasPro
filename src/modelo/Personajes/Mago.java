/*
 * 
 */
package modelo.Personajes;

// TODO: Auto-generated Javadoc
/**
 * The Class Mago.
 */
public class Mago extends Humano {

	// Atributos

	// Constructores

	/**
	 * Instantiates a new mago.
	 */
	public Mago() {
		
		// genero stadisticas aleatorias * max min
		this.vida = (int) (Math.random() * 14 + 1);
		this.danio = (int) (Math.random() * 13 + 2);
		this.defensa = (int) (Math.random() * 15);
		this.habilidad = (int) (Math.random() * 10 + 5);
		this.destreza = (int) (Math.random() * 11 + 4);
		this.inteligencia = (int) (Math.random() * 7 + 8);

	}

	/**
	 * Mover.
	 *
	 * @return the int
	 */
	@Override
	public int mover() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Atacar.
	 *
	 * @return the int
	 */
	@Override
	public int atacar() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Defender.
	 *
	 * @return the int
	 */
	@Override
	public int defender() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Lanzar hechizo.
	 *
	 * @return the int
	 */
	@Override
	public int lanzarHechizo() {
		// TODO Auto-generated method stub
		return 0;
	}

	// Get && Set

	// Metodos

}
