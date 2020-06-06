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
	
	public void gestionarMensaje(int n) {
		String mensaje[] = listaMensajes.get(n)[0].split("&&");
		
		
		for (int i = 0; i < mensaje.length; i++) {
			Text text = new Text();
			switch (mensaje[i].charAt(0)) {
			case 'n':
				
				
				break;
			case 't':
			default:
				text.setStyle("-fx-color:#fff; -fx-font-size:15px");
				break;				
				
			}
			this.textFlow.getChildren().add(text);
			System.out.println(text);
		}
		
		
	}

	public TextFlow getText() {
		return textFlow;
	}
	
	

}
