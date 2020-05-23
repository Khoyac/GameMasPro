package controlador;

import java.util.Random;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.DatabaseOperaciones;
import modelo.criaturas.Basilisco;
import modelo.criaturas.Criatura;
import modelo.personajes.Personaje;

public class CombateControlador {

    @FXML private ImageView enemyDraw;
    @FXML private ImageView characterDraw;
    @FXML private Button action1;
    @FXML private Button action2;
    @FXML private Button action3;
    @FXML private Button action4; 
    @FXML private Label vidaPersonaje;
    @FXML private Label vidaCriatura;
    @FXML private ProgressBar barraPJ;
    @FXML private ProgressBar barraCriatura;
    
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

			this.barraPJ.setProgress(this.personaje.getVidaMax());
			this.vidaPersonaje.setText( Integer.toString( this.personaje.getVida() ) );

			this.barraCriatura.setProgress(this.criatura.getVidaMax());
			this.vidaCriatura.setText( Integer.toString( this.criatura.getVida() ) );
			this.setPersonajes();
	    });
	}
	 
    
    @FXML
    private void atacar(ActionEvent event) {

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
    private void defender(ActionEvent event) {

    }

    @FXML
    private void habilidad(ActionEvent event) {

    }

    @FXML
    private void huir(ActionEvent event) {

    	System.out.println("Me rindo!");
    }
    
    private void setPersonajes() {

    	// Capturamos la clase de nuestro personaje
		String clase = (this.personaje == null) ? null : personaje.getClass().toString().substring(24);
		String url = this.personaje.getAspecto();
		Image pj;
    	
    	
    	pj = new Image(url);
    	this.characterDraw.setImage(pj);
    	
    	
    	// Capturamos la clase del monstruo
    	clase = (this.criatura == null) ? null : criatura.getClass().toString().substring(23);
    	
    	// Aplicamos la imagen del monstruo
    	if(clase.equals("Basilisco")) { url = "imagenes/criaturas/basilisco.png"; }

    	pj = new Image(url);
    	this.enemyDraw.setImage(pj);
    }
    
    public void setCriatura(Criatura c) {
    	
    	this.criatura = c;
    }
    
    public void setPersonaje(Personaje p) {
    	
    	this.personaje = p;
    }
    
    
    
   
}
