/*
 * 
 */
package modelo.entidades.personajes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import modelo.entidades.criaturas.Criatura;

// TODO: Auto-generated Javadoc
/**
 * The Class Guerrero.
 */
public class Guerrero extends Humano {

	// Atributos
	int defensaExtra;

	// Constructores

	/**
	 * Instantiates a new guerrero.
	 */
	public Guerrero() {

	}

	/**
	 * Defender.
	 *
	 * @return the int
	 */
	@Override
	public int defender() {

		Random r1 = new Random();
		int randomDefensa = this.obtenerValorDadoDefensa(r1.nextInt(this.obtenerLongitudDadoDefensa() / 2));

		this.setDefensa(this.getDefensa() + randomDefensa);

		System.out.printf("Tu defensa ha aumentado en %d puntos\n", randomDefensa);
		System.out.printf("Tu defensa %d\n", this.getDefensa());
		return randomDefensa;

	}

	@Override
	public void combatir(Criatura c) {

		// Hago una copia de los arrays de los dados originales del personaje para poder
		// modificarlos temporalmente durante el combate y al finalizar restaurarlos
		ArrayList<Integer> dadoAtaqueOriginal = new ArrayList<Integer>(this.getArrayDadoAtaque());
		ArrayList<Integer> dadoDefensaOriginal = new ArrayList<Integer>(this.getArrayDadoDefensa());

		System.out.printf("Luchando contra %s\n", c.getTipo());

		Scanner sc = new Scanner(System.in);

		int opcion = 0;

		while (opcion != 4) {

			this.setDefensaExtra(0);

			System.out.printf("%s %d / %d HP\n", c.getTipo(), c.getVida(), c.getVidaMax());
			System.out.printf("Tu Vida: %d / %d\n", this.getVida(), this.getVidaMax());

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

					System.out.printf("Has infligido %d daño al %s\n", dmg, c.getTipo());
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
				c.imprimirDadoAtaque();
				c.imprimirDadoDefensa();
				System.out.println(this.lanzarHabilidad());
				c.imprimirDadoAtaque();
				c.imprimirDadoDefensa();
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

					System.out.printf("El %s te ha inflingido %d daño\n", c.getTipo(), dmgCriatura);

				} else {

					System.out.println("La criatura ha fallado");

				}

				this.setDefensa(this.getDefensa() - defensaExtra);
			}

		}

	}

	/**
	 * Lanzar habilidad.
	 *
	 * @return the int
	 */

	public int lanzarHabilidad() {

		// Aumenta en 1 el minimo del dado de Defensa durante el combate
		this.cambiarMinimoDadoDefensa(1);
		return this.obtenerValorMinimoDefensa();
	}

	/**
	 * Mover.
	 *
	 * @return the int
	 */
	@Override
	public int mover() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getDefensaExtra() {
		return defensaExtra;
	}

	public void setDefensaExtra(int defensaExtra) {
		this.defensaExtra = defensaExtra;
	}

}
