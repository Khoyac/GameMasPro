package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modelo.personajes.Personaje;

public class MazmorraControlador {

    @FXML private Button action1;
    @FXML private Button action2;
    @FXML private Button action3;
    @FXML private Button action4;
    @FXML private Label vidaPJ;
    @FXML private Label defensaPJ;
    @FXML private Label danioPJ;
    @FXML private Label DestrezaPJ;
    @FXML private Label habilidadPJ;
    @FXML private Label InteligenciaPJ;
    @FXML private VBox panelCriatura;
    @FXML private Label vidacCriatura;
    @FXML private Label defensaCriatura;
    @FXML private Label danioCriatura;
    @FXML private Label DestrezaCriatura;
    @FXML private Label habilidadCriatura;
    @FXML  private Label InteligenciaCriatura;

    
    private Personaje personaje;
    
    @FXML
    void atacar(ActionEvent event) {

    	this.personaje.atacar(this.criatura);
		this.barraCriatura.setProgress( this.criatura.getVida() );
		this.vidaCriatura.setText( Integer.toString( this.criatura.getVida() ) );
    	
//    	Random r = new Random();
//		int random = r.nextInt(4) + 1;
//    	Thread.sleep(random);
    	
    	this.criatura.atacar(this.personaje);
		this.barraPJ.setProgress( this.personaje.getVida() );
		this.vidaPersonaje.setText( Integer.toString( this.personaje.getVida() ) );
		
		if (this.personaje.getVida() <= 0) huir(event);
    }

    @FXML
    void defender(ActionEvent event) {

    }

    @FXML
    void habilidad(ActionEvent event) {

    }

    @FXML
    void huir(ActionEvent event) {

    }

}
