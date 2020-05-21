package controlador;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modelo.criaturas.Criatura;
import modelo.personajes.Personaje;

public class MazmorraControlador {

    @FXML private Button action1;
    @FXML private Button action2;
    @FXML private Button action3;
    @FXML private Button action4;
    @FXML private Label vidaPJ;
    @FXML private Label defensaPJ;
    @FXML private Label danioPJ;
    @FXML private Label destrezaPJ;
    @FXML private Label inteligenciaPJ;
    @FXML private VBox panelCriatura;
    @FXML private Label vidaCriatura;
    @FXML private Label defensaCriatura;
    @FXML private Label danioCriatura;

    
    private Personaje personaje;
    private Criatura criatura;
    


	@FXML
	void initialize(){

		
		/* 			Ejecutar cosas en último lugar
		 * 
		 * Necesario para que la criatura pasada como parametro en 
		 * Personaje.combatir() pueda ser procesada correctamente.
		 */
		
		Platform.runLater(() -> {

			this.vidaPJ.setText( Integer.toString( this.personaje.getVida() ) );
			this.defensaPJ.setText( Integer.toString( this.personaje.getDefensa() ) );
			this.danioPJ.setText( Integer.toString( this.personaje.getDanio() ) );
			this.destrezaPJ.setText( Integer.toString( this.personaje.getDestreza() ) );
			this.inteligenciaPJ.setText( Integer.toString( this.personaje.getInteligencia() ) );
	    });
	}
    
    @FXML
    void atacar(ActionEvent event) {

    	this.personaje.atacar(this.criatura);
		this.vidaCriatura.setText( Integer.toString( this.criatura.getVida() ) );
    	
//    	Random r = new Random();
//		int random = r.nextInt(4) + 1;
//    	Thread.sleep(random);
    	
    	this.criatura.atacar(this.personaje);
		this.vidaPJ.setText( Integer.toString( this.personaje.getVida() ) );
		
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
    

    
    public void setCriatura(Criatura c) {
    	
    	this.criatura = c;
    }
    
    public void setPersonaje(Personaje p) {
    	
    	this.personaje = p;
    }

}
