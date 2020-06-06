package modelo;

import java.util.HashMap;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class mensaje {
	
	public HashMap<Integer, String[]> listaMensajes;
	TextFlow textFlow;
	
	public mensaje() {
		
		this.listaMensajes = DatabaseOperaciones.listarMensajes();
		this.textFlow = new TextFlow();
		
	}
	
	public TextFlow gestionarMensaje(int n) {
		String msg = listaMensajes.get(n)[0];
		
		String mensaje[] = msg.split("\\[");
		
		
		for (int i = 0; i < mensaje.length; i++) {
			Text text = new Text(mensaje[i].substring(1));
			switch (mensaje[i].charAt(0)) {
			case 'n':
				text.setStyle("-fx-font-size:18px");
				text.setFill(Color.GREEN);
				break;
			case 'f':
				text.setStyle("-fx-font-size:18px");
				text.setFill(Color.YELLOW);
				break;
			case 't':
			default:
				text.setStyle("-fx-font-size:15px");
				text.setFill(Color.WHITE);
				break;				
				
			}
			this.textFlow.getChildren().add(text);
		}
		return textFlow;
		
	}

	public TextFlow getText() {
		return textFlow;
	}
	
	

}
