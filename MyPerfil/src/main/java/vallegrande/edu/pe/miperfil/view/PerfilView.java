package vallegrande.edu.pe.miperfil.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PerfilView {

    private VBox contenedor;
    private Label titulo;
    private TextField txtNombre;
    private TextField txtCarrera;
    private TextField txtSemestre;
    private ComboBox<String> cmbTurno;
    private Button btnMostrar;
    private Button btnLimpiar;
    private Label lblResultado;

    public PerfilView() {

        titulo = new Label("MI PERFIL");
        titulo.setId("titulo");

        txtNombre = new TextField();
        txtNombre.setPromptText("Ingrese su nombre");

        txtCarrera = new TextField();
        txtCarrera.setPromptText("Ingrese su carrera");

        txtSemestre = new TextField();
        txtSemestre.setPromptText("Ingrese su semestre");

        // NIVEL 3 - ComboBox
        cmbTurno = new ComboBox<>();

        cmbTurno.getItems().addAll(
                "Mañana",
                "Tarde",
                "Noche"
        );

        cmbTurno.setPromptText("Seleccione su turno");

        btnMostrar = new Button("Mostrar Perfil");

        // NIVEL 1 - Botón limpiar
        btnLimpiar = new Button("Limpiar");

        lblResultado = new Label();

        contenedor = new VBox(10);

        contenedor.setPadding(new Insets(20));
        contenedor.setAlignment(Pos.CENTER);

        contenedor.getChildren().addAll(
                titulo,
                txtNombre,
                txtCarrera,
                txtSemestre,
                cmbTurno,
                btnMostrar,
                btnLimpiar,
                lblResultado
        );
    }

    public VBox getContenedor() {
        return contenedor;
    }

    public TextField getTxtNombre() {
        return txtNombre;
    }

    public TextField getTxtCarrera() {
        return txtCarrera;
    }

    public TextField getTxtSemestre() {
        return txtSemestre;
    }

    public ComboBox<String> getCmbTurno() {
        return cmbTurno;
    }

    public Button getBtnMostrar() {
        return btnMostrar;
    }

    public Button getBtnLimpiar() {
        return btnLimpiar;
    }

    public Label getLblResultado() {
        return lblResultado;
    }
}
