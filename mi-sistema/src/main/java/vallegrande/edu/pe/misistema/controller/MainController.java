package vallegrande.edu.pe.misistema.controller;

import vallegrande.edu.pe.misistema.view.MainView;

public class MainController {
    private MainView view;

    public MainController(MainView view) {
        this.view = view;
        configurarEventos();
    }

    private void configurarEventos() {
        view.getBtnInicio().setOnAction(e -> view.mostrarInicio());
        view.getBtnUsuarios().setOnAction(e -> view.mostrarUsuarios());
        view.getBtnProductos().setOnAction(e -> view.mostrarProductos());
        view.getBtnVentas().setOnAction(e -> view.mostrarVentas());
        view.getBtnReportes().setOnAction(e -> view.mostrarReportes());

        // Configuración de eventos para las 3 nuevas opciones
        view.getBtnClientes().setOnAction(e -> view.mostrarClientes());
        view.getBtnProveedores().setOnAction(e -> view.mostrarProveedores());

        view.getBtnConfiguracion().setOnAction(e -> view.mostrarConfiguracion());

        // Evento para la tercera nueva opción
        view.getBtnAyuda().setOnAction(e -> view.mostrarAyuda());
    }
}