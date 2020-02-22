package modelo.escenarios;

import java.util.Random;

public class DungeonsGenerator {

	
	
	private static void cofre(char[][] mapa, int y, int z) {
		char[][] cofre = { 	{'#','#','%','%','%','%','%','%','%','%','%','%','%','#','#'},
							{'#','%','#','#','#','#','#','#','#','#','#','#','#','%','#'},
							{'%','#','#','#','#','#','#','#','#','#','#','#','#','#','%'},
							{'%','#','#','#','#','#','#','#','#','#','#','#','#','#','%'},
							{'%','%','%','%','%','%','%','%','%','%','%','%','%','%','%'},
							{'%','#','#','#','#','#','%',' ','%','#','#','#','#','#','%'},
							{'%','#','#','#','#','#','%','%','%','#','#','#','#','#','%'},
							{'%','#','#','#','#','#','#','%','#','#','#','#','#','#','%'},
							{'%','#','#','#','#','#','#','#','#','#','#','#','#','#','%'},
							{'%','#','#','#','#','#','#','#','#','#','#','#','#','#','%'},
							{'%','#','#','#','#','#','#','#','#','#','#','#','#','#','%'},
							{'%','#','#','#','#','#','#','#','#','#','#','#','#','#','%'},
							{'%','#','#','#','#','#','#','#','#','#','#','#','#','#','%'},
							{'#','%','#','#','#','#','#','#','#','#','#','#','#','%','#'},
							{'#','#','%','%','%','%','%','%','%','%','%','%','%','#','#'},
						};
		
		for (int i = 0; i < cofre.length; i++) {
			for (int j = 0; j < cofre[0].length; j++) {
				mapa[y+5+i][z+5+j] = cofre[i][j];
			}
		}
		
	}
	

	private static void DrunkBoyWalk(char[][] mapa, int i) {
		Random r = new Random();
		DrunkBoyWalk(mapa, r.nextInt(9)*50+10, r.nextInt(9)*50+10, i);
	}
	
	private static void DrunkBoyWalk(char[][] mapa, int y, int z, int i) {

		Random r = new Random();

		for (int j = 0; j < i; j++) {
			drawRoom(mapa, y, z);
			
			if (r.nextInt(4) == 1) {
				cofre(mapa, y, z);
			}
			
			if (j == i-1 ) {
				mapa[y+25][z+25] = '@';
				mapa[y+25][z+26] = '@';
				mapa[y+26][z+26] = '@';
				mapa[y+25][z+26] = '@';
			}
			switch (r.nextInt(3)) {
			case 0:
				if(comprobarDentro(y+50, z)) {
					y += 50;
				} else {
					y -=50;
				}
				break;
			case 1:
				if(comprobarDentro(y-50, z)) {
					y -= 50;
				} else {
					y += 50;
				}
				break;
			case 2:
				if(comprobarDentro(y, z+50)) {
					z += 50;
				} else {
					z -= 50;
				}
				break;
			case 3:
				if(comprobarDentro(y, z-50)) {
					z -= 50;
				} else {
					z += 50;
				}
				break;
			}
		}
	}
	
	private static boolean comprobarDentro(int y, int z) {
		boolean valido = false;
		if (y < 449 && y > 0 && z > 0 && z < 449 ) {
			valido = true;
		}
		return valido;
	}
	
	private static void drawRoom(char[][] mapa, int y, int z) {
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				if (i == 0 || j == 0 || i == 49 || j == 49 ) {
					mapa[y+i][z+j] = '@';
				} else {
					mapa[y+i][z+j] = '#';
				}
			}
		}
	}
	
	
}


