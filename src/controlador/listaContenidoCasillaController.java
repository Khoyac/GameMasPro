package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
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
			break;
		case 5:
			// TODO Hacer toString de Cofre
			infoCasilla.setText("Cofre");
			break;
		case 6:
			infoCasilla.setText("Miniboss");
			break;
		case 7:
			infoCasilla.setText("Boss");
			break;
		case 8:
			infoCasilla.setText("Key");
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

}
