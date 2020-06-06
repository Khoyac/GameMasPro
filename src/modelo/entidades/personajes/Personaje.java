/*
 * 
 */
package modelo.entidades.personajes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
public abstract class Personaje extends Entidad implements AccionesPersonajes {

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

	ArrayList<Integer> mensajes;

	String aspecto;

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
		this.destreza = this.obtenerRandom(20, 1);
		this.inteligencia = this.obtenerRandom(20, 1);
		this.mensajes = new ArrayList<Integer>();

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
		// Random sacado de su respectivo array
		int randomAtaque = this.obtenerValorDadoAtaque(r1.nextInt(this.obtenerLongitudDadoAtaque()));
		int randomDefensa = this.obtenerValorDadoDefensa(r1.nextInt(objetivo.obtenerLongitudDadoDefensa()));

		dmg = (this.getDanio() + randomAtaque) - (objetivo.getDefensa() + randomDefensa);

		if (dmg > 0) {

			// TODO Borrar
//			if (randomAtaque == this.obtenerValorMaximoAtaque()) {
//
//				System.out.println("El golpe ha sido critico");
//
//			}

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
	public int recibirExperiencia(long experienciaRecibida) {

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

	// Descomentar para usar el combate en texto

	public static void imprimirMenuPpal() {
		System.out.printf("1.-Atacar");
		System.out.printf("\n2.-Defender");
		System.out.printf("\n3.-Habilidad");
		System.out.printf("\n4.-Huir");
		System.out.printf("\nOpcion: ");
	}

	// Descomentar para usar el combate en interfaz

	@Override
	public void combatir(Personaje p, Criatura c) throws IOException {

		Main_App.showCombateView(p, c);
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

	public void setAspecto(String a) {

		this.aspecto = a;
	}

	public String getAspecto() {

		return this.aspecto;
	}

	public int getBarrera() {
		return barrera;
	}

	public void setBarrera(int barrera) {
		this.barrera = barrera;
	}

	public void addMensaje(int n) {
		this.mensajes.add(n);
	}

	public List<Integer> getMensaje() {
		return this.mensajes;
	}

	public boolean comprobarMensaje(int n) {
		return this.getMensaje().contains(n);
	}
}
