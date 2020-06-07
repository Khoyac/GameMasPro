package modelo.entidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Dado {
	String tipo;
	ArrayList<String> estados;
	ArrayList<Integer> dado;

	public Dado(String tipo) {
		super();
		this.tipo = tipo;
		this.dado = new ArrayList<>(
				Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

		this.estados = new ArrayList<String>();
	}

	public ArrayList<Integer> getDado() {
		return dado;
	}

	public void setDado(ArrayList<Integer> dado) {
		this.dado = dado;
	}

	public void anyadirEstado(String estado) {

		estados.add(estado);

	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void imprimirDado() {
		for (int i = 0; i < this.dado.size(); i++) {
			System.out.printf("%d - ", this.dado.get(i));
		}
		System.out.println();
	}

	public int obtenerLongitud() {
		return this.dado.size();
	}

	public int obtenerValorDado(int indice) {

		return this.dado.get(indice);

	}

	public int obtenerValorMaximo() {

		ArrayList<Integer> fakeArray = new ArrayList<Integer>(this.dado);

		Collections.sort(fakeArray);

		return fakeArray.get(fakeArray.size() - 1);
	}

	public int obtenerValorMinimo() {

		ArrayList<Integer> fakeArray = new ArrayList<Integer>(this.dado);

		Collections.sort(fakeArray);

		return fakeArray.get(0);
	}

	public int cambiarMinimo(int sumaAlValorMinimo) {

		int minimo = this.obtenerValorMinimo();
		int maximo = this.obtenerValorMaximo();

		if (minimo < maximo) {

			for (int i = 0; i < this.dado.size(); i++) {

				if (this.dado.get(i) == minimo) {
					this.dado.set(i, minimo + sumaAlValorMinimo);
				}

			}
		} else {

			System.out.println("Has alcanzado el maximo de aumento");

		}

		return minimo + 1;

	}

	public int borrarIndiceRandom() {
		int indiceBorrado;
		Random r1 = new Random();
		indiceBorrado = r1.nextInt(this.dado.size());
		int valorIndiceBorrado = this.dado.get(indiceBorrado);
		this.dado.remove(indiceBorrado);
		return valorIndiceBorrado;
	}

}
