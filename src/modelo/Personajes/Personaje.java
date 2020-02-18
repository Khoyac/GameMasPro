/*
 * 
 */
package modelo.Personajes;

import modelo.Acciones;

// TODO: Auto-generated Javadoc
/**
 * The Class Personaje.
 */
public abstract class Personaje implements Acciones, AccionesPersonajes {

	// Atributos

	/** The vida. */
	int vida;

	/** The danio. */
	int danio;

	/** The defensa. */
	int defensa;

	/** The habilidad. */
	int habilidad;

	/** The destreza. */
	int destreza;

	/** The inteligencia. */
	int inteligencia;

	/** The experiencia necesaria. */
	long experienciaNecesaria;

	/** The experiencia actual. */
	long experienciaActual;

	/** The nivel. */
	int nivel;

	/** The calc exp 1. */
	long calcExp1;
	
	/** The calc exp 2. */
	long calcExp2;

	/** The porcentaje XP. */
	int porcentajeXP;

	// Constructores

	/**
	 * Instantiates a new personaje.
	 */
	public Personaje() {

		this.calcExp1 = 8;
		this.calcExp2 = 13;
		this.experienciaActual = 0;
		this.experienciaNecesaria = this.calcExp1;
		this.nivel = 1;
		this.porcentajeXP = 0;

	}

	// Get && Set

	/**
	 * Gets the vida.
	 *
	 * @return the vida
	 */
	public int getVida() {
		return vida;
	}

	
	/**
	 * Sets the vida.
	 *
	 * @param vida the new vida
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}

	
	/**
	 * Gets the danio.
	 *
	 * @return the danio
	 */
	public int getDanio() {
		return danio;
	}

	
	/**
	 * Sets the danio.
	 *
	 * @param danio the new danio
	 */
	public void setDanio(int danio) {
		this.danio = danio;
	}

	
	/**
	 * Gets the defensa.
	 *
	 * @return the defensa
	 */
	public int getDefensa() {
		return defensa;
	}

	
	/**
	 * Sets the defensa.
	 *
	 * @param defensa the new defensa
	 */
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	
	/**
	 * Gets the habilidad.
	 *
	 * @return the habilidad
	 */
	public int getHabilidad() {
		return habilidad;
	}

	
	/**
	 * Sets the habilidad.
	 *
	 * @param habilidad the new habilidad
	 */
	public void setHabilidad(int habilidad) {
		this.habilidad = habilidad;
	}

	
	/**
	 * Gets the destreza.
	 *
	 * @return the destreza
	 */
	public int getDestreza() {
		return destreza;
	}

	/**
	 * Sets the destreza.
	 *
	 * @param destreza the new destreza
	 */
	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	
	/**
	 * Gets the inteligencia.
	 *
	 * @return the inteligencia
	 */
	public int getInteligencia() {
		return inteligencia;
	}

	/**
	 * Gets the experiencia necesaria.
	 *
	 * @return the experiencia necesaria
	 */
	public long getExperienciaNecesaria() {
		return experienciaNecesaria;
	}

	/**
	 * Sets the experiencia necesaria.
	 *
	 * @param experienciaNecesaria the new experiencia necesaria
	 */
	public void setExperienciaNecesaria(long experienciaNecesaria) {
		this.experienciaNecesaria = experienciaNecesaria;
	}

	/**
	 * Gets the experiencia actual.
	 *
	 * @return the experiencia actual
	 */
	public long getExperienciaActual() {
		return experienciaActual;
	}

	/**
	 * Sets the experiencia actual.
	 *
	 * @param experienciaActual the new experiencia actual
	 */
	public void setExperienciaActual(long experienciaActual) {
		this.experienciaActual = experienciaActual;
	}

	
	/**
	 * Sets the inteligencia.
	 *
	 * @param inteligencia the new inteligencia
	 */
	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	// Metodos

	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {

		// Utilizar doble %% para que java lo interprete
		return String.format(
				"Nivel %d\nVida - %d\nDa�o - %d\nDefensa - %d\nDestreza - %d\nHabilidad - %d\nInteligencia - %d\nExperiencia - %d%% - %d/%d\n",
				this.nivel, this.vida, this.danio, this.defensa, this.destreza, this.habilidad, this.inteligencia,
				this.porcentajeXP, this.experienciaActual, this.experienciaNecesaria);
	}

	/**
	 * Obtener experiencia siguiente nivel.
	 *
	 * @return the long
	 */
	public long obtenerExperienciaSiguienteNivel() {

		long suma;

		suma = this.calcExp1 + this.calcExp2;

		this.calcExp1 = this.calcExp2;
		this.calcExp2 = suma;

		return suma;
	}

	/**
	 * Recibir experiencia.
	 *
	 * @param experienciaRecibida the experiencia recibida
	 * @return the int
	 */
	public int recibirExperiencia(int experienciaRecibida) {

		int experienciaRetenida;

		this.experienciaActual += experienciaRecibida;

		// Hago un do While para poder subir mas de 1 nivel de golpe
		do {

			// Retengo la experiencia sobrante al subir de nivel
			experienciaRetenida = (int) (experienciaActual - experienciaNecesaria);

			// A�ado un nivel
			nivel = (int) obtenerNivel(this.calcExp2) - 5;

			// TODO A�adir nueva experiencia Necesaria
			this.experienciaNecesaria = obtenerExperienciaSiguienteNivel();

			// Reinicio la experiencia actual al valor retenido
			this.experienciaActual = experienciaRetenida;
		} while (this.experienciaActual >= this.experienciaNecesaria);

		this.porcentajeXP = (int) ((this.experienciaActual * 100) / this.experienciaNecesaria);

		return 0;
	}

	/**
	 * Obtener nivel.
	 *
	 * @param experienciaNecesaria the experiencia necesaria
	 * @return the long
	 */
	public long obtenerNivel(long experienciaNecesaria) {

		float fibo = 2.078087F * (float) Math.log(experienciaNecesaria) + 1.672276F;

		// retorno el valor del indice redondeado
		return Math.round(fibo);

	}

}
