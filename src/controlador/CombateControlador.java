package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import modelo.DatabaseOperaciones;
import modelo.criaturas.Basilisco;
import modelo.criaturas.Criatura;
import modelo.personajes.Personaje;

public class CombateControlador {

    @FXML private ImageView enemyDraw;
    @FXML private ImageView characterDraw;
    @FXML private Button Action1;
    @FXML private Button Action2;
    @FXML private Button Action3;
    @FXML private Button Action4;
    
    private Personaje personaje;
    private Criatura criatura;
    

	@FXML
	void initialize(){

		this.personaje = DatabaseOperaciones.getPersonaje();
		this.criatura = new Basilisco();
		
		setPersonajes();

	}
	 
    
    @FXML
    private void atacar(ActionEvent event) {

    	this.personaje.atacar(this.criatura);
    }

    @FXML
    private void defender(ActionEvent event) {

    }

    @FXML
    private void habilidad(ActionEvent event) {

    }

    @FXML
    private void huir(ActionEvent event) {

    }
    
    private void setPersonajes() {

		String clase = (personaje == null) ? null : personaje.getClass().toString().substring(24);
		String url = "/basico.png";
    	
		// Aplicamos la imagen del personaje
    	if(clase.equals("Guerrero") || clase.equals("Mago")) {

			this.characterDraw.setStyle("-fx-background-image: url('imagenes/humano" + url + "'); "
					+ "-fx-background-size: cover");
		}

		else if(clase.equals("Asesino") || clase.equals("Arquero")) {

			this.characterDraw.setStyle("-fx-background-image: url('imagenes/elfo" + url + "'); "
					+ "-fx-background-size: cover");
		}

		else if(clase.equals("Chaman") || clase.equals("Tanke")) {

			this.characterDraw.setStyle("-fx-background-image: url('imagenes/orco" + url + "'); "
					+ "-fx-background-size: cover");
		}
    	
    	
    	clase = (criatura == null) ? null : criatura.getClass().toString().substring(23);
    	
    	// Aplicamos la imagen del monstruo
    	if(clase.equals("Basilisco")) {

			this.enemyDraw.setStyle("-fx-background-image: url('imagenes/basilisco" + url + "'); "
					+ "-fx-background-size: cover");
		}

    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
