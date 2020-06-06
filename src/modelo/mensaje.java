package modelo;

import java.util.HashMap;

import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class mensaje {
	
	public HashMap<Integer, String[]> listaMensajes;
	TextFlow textFlow;
	
	public mensaje() {
		
		this.listaMensajes = DatabaseOperaciones.listarMensajes();
	}
	
	public void gestionarMensaje(int n) {
		String mensaje = listaMensajes.get(n)[1];
		
		Text text = new Text(mensaje);
		
		this.textFlow.getChildren().add(text);
	}

}
