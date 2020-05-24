/*
 * 
 */
package modelo.entidades.personajes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import modelo.entidades.criaturas.Criatura;

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

	}

	/*
	 * 
	 * /** Defender.
	 *
	 * @return the int
	 */
	@Override
	public int defender() {

		// Obtiene la barrera del valor de un indice de la primera mitad de la longitug
		// del array

		Random r1 = new Random();
		int randomBarrera = this.obtenerValorDadoDefensa(r1.nextInt(this.obtenerLongitudDadoDefensa() / 2));

		this.setBarrera(this.getBarrera() + randomBarrera);

		return randomBarrera;

	}

	/**
	 * Lanzar habilidad.
	 *
	 * @return the int
	 */
	@Override
	public int lanzarHabilidad(Criatura c) {

		// Borra un indice aleatorio de un dado aleatorio del objetivo

		Dado dado = c.obtenerDadoAleatorio();
		int valorBorrado = dado.borrarIndiceRandom();
		System.out.printf("Has cambiado el dado de %s y le has quitado el valor %d\n", dado.getTipo(), valorBorrado);

		return valorBorrado;

	}

	@Override
	public void combatir(Criatura c) {

		// Hago una copia de los arrays de los dados originales del personaje para poder
		// modificarlos temporalmente durante el combate y al finalizar restaurarlos
		ArrayList<Integer> dadoAtaqueOriginal = new ArrayList<Integer>(this.getArrayDadoAtaque());
		ArrayList<Integer> dadoDefensaOriginal = new ArrayList<Integer>(this.getArrayDadoDefensa());

		System.out.printf("Luchando contra %s\n", c.getNombre());

		Scanner sc = new Scanner(System.in);

		int opcion = 0;

		while (opcion != 4) {

			System.out.printf("%s %d / %d HP\n", c.getNombre(), c.getVida(), c.getVidaMax());
			System.out.printf("Tu Vida: %d / %d, Barrera: %d\n", this.getVida(), this.getVidaMax(), this.getBarrera());

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
					System.out.println("Has fallado");
				}

				break;
			}
			case 2: {

				this.defender();

				break;
			}
			case 3: {

				System.out.println(this.lanzarHabilidad(c));

				break;
			}
			case 4: {
				System.out.println("\nFin del combate");
				this.setArrayDadoAtaque(dadoAtaqueOriginal);
				this.setArrayDadoDefensa(dadoDefensaOriginal);

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

					System.out.println("La criatura ha fallado");

				}

			}

		}

	}

}
