package modelo.escenarios;

import java.util.ArrayList;
import java.util.Random;

import modelo.entidades.criaturas.Criatura;

public class Casilla {

	boolean miniBoss;
	boolean boss;
	int criatura;
	int numero;
	boolean N;
	boolean S;
	boolean E;
	boolean O;
	boolean key;
	ArrayList<Criatura> listaCriaturas;
	Cofre cofre;
	Random r1 = new Random();

	@Override
	public String toString() {
		return String.format("Casilla %d , c %b , N %b %b %b %b, ", this.numero, this.cofre, this.isN(), this.isS(),
				this.isE(), this.isO());
	}

	public Casilla() {
		super();

		this.criatura = r1.nextInt(6) + 1;
		listaCriaturas = new ArrayList<Criatura>();
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

	public void anyadirCriatura(Criatura c1) {
		this.listaCriaturas.add(c1);
	}

	public Cofre getCofre() {
		return cofre;
	}

	public void setCofre(Cofre cofre) {
		this.cofre = cofre;
	}

	public ArrayList<Criatura> getCriaturas() {

		return this.listaCriaturas;
	}

	public boolean isKey() {
		return key;
	}

	public void setKey(boolean key) {
		this.key = key;
	}

}
