package vallegrande.edu.pe.miperfil.controller;

import vallegrande.edu.pe.miperfil.model.Perfil;
import vallegrande.edu.pe.miperfil.view.PerfilView;

public class PerfilController {

    private PerfilView view;

    public PerfilController(PerfilView view) {

        this.view = view;

        view.getBtnMostrar().setOnAction(e -> mostrarPerfil());

        // NIVEL 1
        view.getBtnLimpiar().setOnAction(e -> limpiarCampos());
    }

    private void mostrarPerfil() {

        String nombre = view.getTxtNombre().getText();
        String carrera = view.getTxtCarrera().getText();
        String semestre = view.getTxtSemestre().getText();
        String turno = view.getCmbTurno().getValue();

        // NIVEL 2 - Validar nombre
        if (nombre.isEmpty()) {

            view.getLblResultado().setText(
                    "Debe ingresar su nombre"
            );

            return;
        }

        if (turno == null) {
            turno = "No seleccionado";
        }

        Perfil perfil = new Perfil(
                nombre,
                carrera,
                semestre,
                turno
        );

        view.getLblResultado().setText(
                perfil.obtenerPresentacion()
        );
    }

    private void limpiarCampos() {

        view.getTxtNombre().clear();
        view.getTxtCarrera().clear();
        view.getTxtSemestre().clear();

        view.getCmbTurno().setValue(null);

        view.getLblResultado().setText("");
    }
}