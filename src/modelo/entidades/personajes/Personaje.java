/*
 * 
 */
package modelo.entidades.personajes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import modelo.Acciones;
import modelo.Main_App;
import modelo.entidades.Entidad;
import modelo.entidades.criaturas.Criatura;

// TODO: Auto-generated Javadoc
/**
 * The Class Personaje.
 */
public abstract class Personaje extends Entidad implements Acciones, AccionesPersonajes {

	// Atributos

	/** The destreza. */
	int destreza;

	/** The inteligencia. */
	int inteligencia;

	/** The experiencia necesaria. */
	long experienciaNecesaria;

	/** The experiencia actual. */
	long experienciaActual;

	/** The calc exp 1. */
	long calcExp1;

	/** The calc exp 2. */
	long calcExp2;

	/** The porcentaje XP. */
	int porcentajeXP;

	int barrera;

	String aspecto;

	Random r1 = new Random();

	// Constructores

	/**
	 * Instantiates a new personaje.
	 */
	public Personaje() {

		this.calcExp1 = 8;
		this.calcExp2 = 13;
		this.experienciaActual = 0;
		this.experienciaNecesaria = this.calcExp1;
		this.porcentajeXP = 0;
		this.destreza = r1.nextInt(20) + 1;
		this.inteligencia = r1.nextInt(20) + 1;

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
				"Nivel %d\nVida - %d\nDa�o - %d\nDefensa - %d\nDestreza - %d\nInteligencia - %d\nExperiencia - %d%% - %d/%d\n",
				this.getNivel(), this.getVida(), this.getDanio(), this.getDefensa(), this.getDestreza(),
				this.getInteligencia(), this.porcentajeXP, this.experienciaActual, this.experienciaNecesaria);
	}

	@Override
	public int atacar(Criatura objetivo) {
		// TODO Añadir daño de arma y/o equipamiento mas adelante

		int dmg;
		Random r1 = new Random();
		// Random entre 0 y 20, + 1
		int randomAtaque = r1.nextInt(20) + 1;
		int randomDefensa = r1.nextInt(20) + 1;

		dmg = (this.getDanio() + randomAtaque) - (objetivo.getDefensa() + randomDefensa);

		if (dmg < 0) {
			System.out.println("Estas confuso, te has herido a ti mismo");

			this.setVida(this.getVida() - (dmg * -1));
		} else {
			if (randomAtaque == 20) {
				System.out.println("El golpe ha sido critico");
			}
			objetivo.setVida(objetivo.getVida() - dmg);
		}

		return dmg;
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

	@Override
	public void subirNivel() {
		super.subirNivel();
		this.destreza += 2;
		this.inteligencia += 1;
		this.setNivel((int) obtenerNivel(this.calcExp2) - 5);

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

			int defensaExtra = 0;

			System.out.printf("%s %d / %d HP\n", c.getNombre(), c.getVida(), c.getVidaMax());
			System.out.printf("Tu %d / %d\n", this.getVida(), this.getVidaMax());

			// Mostrar por pantalla el menú Principal
			imprimirMenuPpal();

			if (c.getVida() <= 0 || this.getVida() <= 0) {
				opcion = 4;
			} else {
				opcion = sc.nextInt();
			}

			switch (opcion) {
			case 1: {
				int dmg;
				dmg = this.atacar(c);

				if (dmg > -1) {

					System.out.printf("Has infligido %d daño al %s\n", dmg, c.getNombre());
				} else {
					System.out.printf("Te has inflingido %d daño\n", dmg * -1);
				}

				break;
			}
			case 2: {

				if (this.getClass().getSimpleName().equals("Guerrero")) {
					defensaExtra = this.defender();

				} else {
					this.defender();
				}

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

				int dmgCriatura = c.atacar(this);

				if (dmgCriatura > -1) {

					System.out.printf("El %s te ha inflingido %d daño\n", c.getNombre(), dmgCriatura);
				} else {
					System.out.printf("El %s esta confuso y se ha inflingido %d de daño a si mismo\n", c.getNombre(),
							dmgCriatura * -1);

				}

				this.setDefensa(this.getDefensa() - defensaExtra);
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

	@Override
	public void combatir(Personaje p, Criatura c) throws IOException {

		Main_App.showCombateView(p, c);
	}

	/* COMBATE POR INTERFAZ ENDS */

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

	public long getExp() {
		return this.experienciaActual;
	}

	public long getExpNecesaria() {
		return this.experienciaNecesaria;
	}

	public void setExp(long exp) {
		this.experienciaActual = exp;
	}

	public void setExpNecesaria(long exp) {
		this.experienciaNecesaria = exp;
	}

	public int getBarrera() {
		return barrera;
	}

	public void setBarrera(int barrera) {
		this.barrera = barrera;
	}

	public void setAspecto(String a) {

		this.aspecto = a;
	}

	public String getAspecto() {

		return this.aspecto;
	}
}
