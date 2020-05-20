/*
 * 
 */
package modelo.personajes;

import java.io.IOException;
import java.util.Scanner;

import modelo.Acciones;
import modelo.Main_App;
import modelo.criaturas.Criatura;

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

	int vidaMax;

	int barrera;

	int puntosCritico;

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
		this.puntosCritico = 0;

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
			subirNivel();

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

	public int subirNivel() {
		this.vida += 3;
		this.vidaMax = this.vida;
		this.defensa += 1;
		this.destreza += 2;
		this.danio += 1;
		this.habilidad += 1;
		this.inteligencia += 1;
		return nivel = (int) obtenerNivel(this.calcExp2) - 5;

	}

	public long obtenerNivel(long experienciaNecesaria) {

		float fibo = 2.078087F * (float) Math.log(experienciaNecesaria) + 1.672276F;

		// retorno el valor del indice redondeado
		return Math.round(fibo);

	}

	/* PRUEBAS COMBATE GRAFICO START */

	// Descomentar para usar el combate en texto

	@Override
	public void combatir(Criatura c) {

		System.out.printf("Luchando contra %s\n", c.getNombre());

		Scanner sc = new Scanner(System.in);

		int opcion = 0;

		while (opcion != 4) {

			System.out.printf("%s %d / %d HP\n", c.getNombre(), c.getVida(), c.getVidaMax());
			System.out.printf("Tu %d / %d\n", this.getVida(), this.getVidaMax());
			System.out.printf("Tu Barrera %d\n", this.getBarrera());
			// Mostrar por pantalla el menú Principal
			imprimirMenuPpal();

			if (c.getVida() <= 0 || this.getVida() <= 0) {
				opcion = 4;
			} else {
				opcion = sc.nextInt();
			}

			switch (opcion) {
			case 1: {
				System.out.printf("Has infligido %d daño al %s\n", this.atacar(c), c.getNombre());

				break;
			}
			case 2: {
				this.defender();
				break;
			}
			case 3: {

				break;
			}
			case 4: {
				System.out.println("\nFin del combate");
				break;
			}
			default: {
				System.out.printf("\n\nOpción incorrecta\n");
				break;
			}
			}

			if (opcion != 4) {

				System.out.printf("El %s te ha inflingido %d daño\n", c.getNombre(), c.atacar(this));
			}

		}

	}

	public static void imprimirMenuPpal() {
		System.out.printf("1.-Atacar");
		System.out.printf("\n2.-Defender");
		System.out.printf("\n3.-Habilidad");
		System.out.printf("\n4.-Huir");
		System.out.printf("\nOpcion: ");
	}

	/* PRUEBAS COMBATE GRAFICO ENDS */

	/* COMBATE POR INTERFAZ START */

	// Descomentar para usar el combate en interfaz

//	@Override
//	public void combatir(Criatura c) throws IOException {
//
//		Main_App.showCombateView(c);
//	}

	/* COMBATE POR INTERFAZ ENDS */

	public int getVidaMax() {

		return this.vidaMax;
	}

	public int getVida() {
		return this.vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDanio() {
		return this.danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}

	public int getDefensa() {
		return this.defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getHabilidad() {
		return this.habilidad;
	}

	public void setHabilidad(int habilidad) {
		this.habilidad = habilidad;
	}

	public int getDestreza() {
		return this.destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getInteligencia() {
		return this.inteligencia;
	}

	public void setInteligencia(int iq) {
		this.inteligencia = iq;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getBarrera() {
		return barrera;
	}

	public void setBarrera(int barrera) {
		this.barrera = barrera;
	}

	public int getPuntosCriticos() {
		return puntosCritico;
	}

	public void setPuntosCriticos(int puntosCriticos) {
		this.puntosCritico = puntosCriticos;
	}
}
