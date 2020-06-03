package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import modelo.escenarios.Casilla;

public class listaContenidoCasillaController extends Label {

	Casilla casillaActual;
	private MazmorraControlador mazmorraControlador;
	int numeroLabel;

	@FXML
	private Label infoCasilla;

	@FXML
	void initialize() {

	}

	public void setCasillaActual(Casilla casillaActual) {
		this.casillaActual = casillaActual;
	}

	public void setLabelVisible() {

		this.infoCasilla.setVisible(true);

	}

	public void setLabelInvisible() {

		this.infoCasilla.setVisible(false);

	}

	public void setLabelText(int numeroCriatura) {

		switch (numeroCriatura) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			infoCasilla.setText(this.casillaActual.getCriaturas().get(numeroCriatura).getNombre());
			
			// TODO Metodo añadir cabeza del bicho, ¿Lo dejamos así o creamos metodo? 
			String criatura = this.casillaActual.getCriaturas().get(numeroCriatura).getTipo();
			Image image = new Image(getClass().getResourceAsStream("/imagenes/assets/"+criatura+"head.png"));
			ImageView iv = new ImageView(image);
			iv.setFitHeight(35);
			iv.setFitWidth(35);
			this.infoCasilla.setGraphic(iv);
			
			break;
		case 5:
			// TODO Hacer toString de Cofre
			infoCasilla.setText("Cofre");
			break;
		case 6:
			infoCasilla.setText("MiniJefe");
			break;
		case 7:
			infoCasilla.setText("Jefe");
			break;
		case 8:
			infoCasilla.setText("Llave");
			break;
		default:
			break;
		}

	}

	public void setLabelActual(MazmorraControlador mazmorraControlador, int numeroLabel) {

		this.mazmorraControlador = mazmorraControlador;
		this.numeroLabel = numeroLabel;

	}

	public void checkLabel() {

		if (this.infoCasilla.isVisible()) {
			this.infoCasilla.toBack();
		} else {
			this.infoCasilla.toFront();
		}
	}

	@FXML
	void imprimirLabel(MouseEvent event) {

		this.mazmorraControlador.mostrarInfoLabelExtendida(this.numeroLabel);

	}

	public void crearLabelCofre() {
		Image image = new Image(getClass().getResourceAsStream("/imagenes/assets/cofrelvl1.png"));
		ImageView iv = new ImageView(image);
		iv.setFitHeight(35);
		iv.setFitWidth(35);
		this.infoCasilla.setGraphic(iv);
	}

	public void setNumeroLabel(int numeroLabel) {
		this.numeroLabel = numeroLabel;
	}

}
