package modelo.entidades;

import java.util.ArrayList;
import java.util.Random;

import modelo.Acciones;

public class Entidad implements Acciones {

	/** The vida. */
	private int vida;

	/** The danio. */
	private int danio;

	/** The defensa. */
	private int defensa;

	private int vidaMax;

	/** The nivel. */
	private int nivel;

	int lastRandom;
	ArrayList<Dado> dados;
	Dado dadoAtaque;
	Dado dadoDefensa;
	Random random = new Random();

	public Entidad() {
		super();

		this.vida = random.nextInt(11) + 10;
		this.danio = random.nextInt(11) + 10;
		this.defensa = random.nextInt(11) + 10;
		this.vidaMax = this.vida;
		this.nivel = 1;
		dadoAtaque = new Dado("Ataque");
		dadoDefensa = new Dado("Defensa");
		dados = new ArrayList<Dado>();
		dados.add(dadoAtaque);
		dados.add(dadoDefensa);

	}

	public void subirNivel() {
		this.vida += 3;
		this.vidaMax = this.vida;
		this.defensa += 1;
		this.danio += 1;

	}

	// TODO Probabilidad de borrar mas adelante

	public void imprimirDadoAtaque() {
		this.dadoAtaque.imprimirDado();
	}

	// TODO Probabilidad de borrar mas adelante

	public void imprimirDadoDefensa() {
		this.dadoDefensa.imprimirDado();
	}

	// Random

	public Dado obtenerDadoAleatorio() {

		return this.dados.get(random.nextInt(this.dados.size()));

	}

	public int obtenerRandom(int maximo, int minimo) {

		return this.random.nextInt(maximo) + minimo;
	}

	// Estados

	public void anyadirEstadoAtaque(String estado) {
		this.dadoAtaque.anyadirEstado(estado);
	}

	public void anyadirEstadoDefensa(String estado) {
		this.dadoDefensa.anyadirEstado(estado);
	}

	// Valores de los Dados

	public int obtenerValorDadoAtaque(int indice) {
		return this.dadoAtaque.obtenerValorDado(indice);
	}

	public int obtenerValorDadoDefensa(int indice) {
		return this.dadoDefensa.obtenerValorDado(indice);
	}

	// Longitud

	public int obtenerLongitudDadoAtaque() {
		return this.dadoAtaque.obtenerLongitud();
	}

	public int obtenerLongitudDadoDefensa() {
		return this.dadoDefensa.obtenerLongitud();
	}

	// Maximo y Minimo

	public int obtenerValorMaximoAtaque() {

		return this.dadoAtaque.obtenerValorMaximo();

	}

	public int obtenerValorMaximoDefensa() {

		return this.dadoDefensa.obtenerValorMaximo();

	}

	public int obtenerValorMinimoAtaque() {

		return this.dadoAtaque.obtenerValorMinimo();

	}

	public int obtenerValorMinimoDefensa() {

		return this.dadoDefensa.obtenerValorMinimo();

	}

	// Modificar el minimo de un dado por el minimo + la suma del valor dado

	public void cambiarMinimoDadoDefensa(int sumaAlValorMinimo) {

		this.dadoDefensa.cambiarMinimo(sumaAlValorMinimo);

	}

	// Getters and Setters

	public ArrayList<Integer> getArrayDadoAtaque() {
		return dadoAtaque.getDado();
	}

	public ArrayList<Integer> getArrayDadoDefensa() {
		return dadoDefensa.getDado();
	}

	public void setArrayDadoAtaque(ArrayList<Integer> arrayAtaque) {
		this.dadoAtaque.setDado(arrayAtaque);
	}

	public void setArrayDadoDefensa(ArrayList<Integer> arrayDefensa) {
		this.dadoDefensa.setDado(arrayDefensa);
	}

	public int getVidaMax() {

		return this.vidaMax;
	}

	public void setVidaMax(int vidaMax) {
		this.vidaMax = vidaMax;
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

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	@Override
	public int defender() {

		return 0;
	}

	@Override
	public int lanzarHabilidad(Entidad e) {

		return 0;
	}

	public int getLastRandom() {

		return lastRandom;
	}

	public void setLastRandom(int lastRandom) {
		this.lastRandom = lastRandom;
	}

}
