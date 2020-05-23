package modelo.entidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Entidad {

	/** The vida. */
	private int vida;

	/** The danio. */
	private int danio;

	/** The defensa. */
	private int defensa;

	private int vidaMax;

	/** The nivel. */
	private int nivel;

	ArrayList<String> estados;
	ArrayList<Integer> dadoAtaque;
	ArrayList<Integer> dadoDefensa;

	Random r1 = new Random();

	public Entidad() {
		super();

		this.vida = r1.nextInt(11) + 10;
		this.danio = r1.nextInt(11) + 10;
		this.defensa = r1.nextInt(11) + 10;
		this.vidaMax = this.vida;
		this.nivel = 1;

		this.dadoAtaque = new ArrayList<>(
				Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

		this.dadoDefensa = new ArrayList<Integer>();

		this.estados = new ArrayList<String>();
	}

	public void subirNivel() {
		this.vida += 3;
		this.vidaMax = this.vida;
		this.defensa += 1;
		this.danio += 1;

	}

	public void anyadirEstado(String estado) {
		this.estados.add(estado);
	}

	public ArrayList<Integer> getDadoAtaque() {
		return dadoAtaque;
	}

	public void setDadoAtaque(ArrayList<Integer> dadoAtaque) {
		this.dadoAtaque = dadoAtaque;
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

}
