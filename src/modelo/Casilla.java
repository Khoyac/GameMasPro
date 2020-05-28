package modelo;

import java.util.Random;

import javafx.scene.control.Button;

public class Casilla extends Button {

	boolean cofre;
	boolean miniBoss;
	boolean boss;
	int criatura;
	int numero;
	boolean N;
	boolean S;
	boolean E;
	boolean O;

	Random r1 = new Random();

	public Casilla() {
		super();

		this.criatura = r1.nextInt(6) + 1;

	}

	public boolean isCofre() {
		return cofre;
	}

	public void setCofre(boolean cofre) {
		this.cofre = cofre;
	}

	public boolean isMiniBoss() {
		return miniBoss;
	}

	public void setMiniBoss(boolean miniBoss) {
		this.miniBoss = miniBoss;
	}

	public boolean isBoss() {
		return boss;
	}

	public void setBoss(boolean boss) {
		this.boss = boss;
	}

	public int getCriatura() {
		return criatura;
	}

	public void setCriatura(int criatura) {
		this.criatura = criatura;
	}

	public int getNumero() {
		return numero;
	}

	public boolean isN() {
		return N;
	}

	public void setN(boolean n) {
		N = n;
	}

	public boolean isS() {
		return S;
	}

	public void setS(boolean s) {
		S = s;
	}

	public boolean isE() {
		return E;
	}

	public void setE(boolean e) {
		E = e;
	}

	public boolean isO() {
		return O;
	}

	public void setO(boolean o) {
		O = o;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
