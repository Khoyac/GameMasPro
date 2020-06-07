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

		String criatura;
		Image image;
		ImageView iv;

		switch (numeroCriatura) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:

			infoCasilla.setText(this.casillaActual.getCriaturas().get(numeroCriatura).getNombre());

			criatura = this.casillaActual.getCriaturas().get(numeroCriatura).getTipo();
			image = new Image(getClass().getResourceAsStream("/imagenes/assets/" + criatura + "head.png"));
			iv = new ImageView(image);
			iv.setFitHeight(35);
			iv.setFitWidth(35);
			this.infoCasilla.setGraphic(iv);

			if (this.casillaActual.getCriaturas().get(numeroCriatura).getVida() <= 0) {

				this.infoCasilla.setStyle("-fx-text-decoration:line-through;");

			} else {

				this.infoCasilla.setStyle("-fx-background-image:url(/imagenes/assets/fondobtnmazmo.png)");

			}

			break;
		case 5:
			// TODO Hacer toString de Cofre en el futuro, cuando contenga objetos
			infoCasilla.setText("Cofre");
			break;
		case 6:
			infoCasilla.setText("MiniJefe");
			// TODO borrar cuando el minijefe exista
			infoCasilla.setDisable(true);
			break;
		case 7:

			criatura = this.casillaActual.getBoss().getTipo();
			image = new Image(getClass().getResourceAsStream("/imagenes/assets/" + criatura + "head.png"));
			iv = new ImageView(image);
			infoCasilla.setText("Jefe");
			this.infoCasilla.setGraphic(iv);
			iv.setFitHeight(35);
			iv.setFitWidth(35);
			break;
		case 8:
			image = new Image(getClass().getResourceAsStream("/imagenes/assets/gem1.png"));
			iv = new ImageView(image);
			this.infoCasilla.setGraphic(iv);
			infoCasilla.setText("Llave");
			iv.setFitHeight(35);
			iv.setFitWidth(35);
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
