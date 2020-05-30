package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import modelo.escenarios.Casilla;

public class listaContenidoCasillaController extends Pane {

	Casilla casillaActual;

	@FXML
	private Label infoCasilla;

	@FXML
	void initialize() {
		infoCasilla.prefHeight(10);
	}

	public listaContenidoCasillaController(Casilla casillaActual) {
		super();
		this.casillaActual = casillaActual;
	}

	public void setLabelText(int numeroCriatura) {

		switch (numeroCriatura) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			infoCasilla.setText(this.casillaActual.getCriaturas().get(numeroCriatura).getNombre());
			break;
		case 6:
			// TODO Hacer toString de Cofre
			infoCasilla.setText("Cofre");
			break;
		case 7:
			infoCasilla.setText("Miniboss");
			break;
		case 8:
			infoCasilla.setText("Boss");
			break;
		
		default:
			break;
		}

	}

}
