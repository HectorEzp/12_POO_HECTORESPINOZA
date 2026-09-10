package vallegrande.edu.pe.misistema.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainView extends BorderPane {
    private Button btnInicio;
    private Button btnUsuarios;
    private Button btnProductos;
    private Button btnVentas;
    private Button btnReportes;
    private Button btnConfiguracion;

    private Button btnClientes;
    private Button btnProveedores;
    private Button btnAyuda;

    public MainView() {
        crearMenu();
        mostrarInicio();
    }

    private void crearMenu() {
        VBox menu = new VBox(12);
        menu.setPadding(new Insets(20));
        menu.setPrefWidth(220);

        Label titulo = new Label("🖥️ MI SISTEMA");
        titulo.setStyle(
                "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;"
        );

        btnInicio = crearBoton("Inicio");
        btnUsuarios = crearBoton("Usuarios");
        btnProductos = crearBoton("Productos");
        btnVentas = crearBoton("Ventas");
        btnReportes = crearBoton("Reportes");
        btnClientes = crearBoton("Clientes");
        btnProveedores = crearBoton("Proveedores");
        btnConfiguracion = crearBoton("Configuración");
        btnAyuda = crearBoton("Ayuda");

        menu.getChildren().addAll(
                titulo,
                btnInicio,
                btnUsuarios,
                btnProductos,
                btnVentas,
                btnReportes,
                btnClientes,
                btnProveedores,
                btnConfiguracion,
                btnAyuda
        );

        // CAMBIO DE COLOR: Verde Oscuro Elegante (#064E3B)
        menu.setStyle("-fx-background-color: #064E3B;");
        setLeft(menu);
    }

    private Button crearBoton(String texto) {
        Button boton = new Button(texto);
        boton.setPrefWidth(170);
        boton.setPrefHeight(38);
        boton.setStyle(
                "-fx-background-color: white;" +
                        "-fx-text-fill: #064E3B;" + // Texto verde oscuro para combinar con el menú
                        "-fx-font-size: 13px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 8;" +
                        "-fx-cursor: hand;"
        );
        return boton;
    }

    public void mostrarInicio() {
        VBox contenido = new VBox(10);
        contenido.setAlignment(Pos.CENTER);

        Label titulo = new Label("BIENVENIDO");
        titulo.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;");

        Label texto = new Label("Panel principal de mi sistema");

        contenido.getChildren().addAll(titulo, texto);
        setCenter(contenido);
    }

    public void mostrarUsuarios() {
        VBox contenido = crearContenedorBase("USUARIOS");
        HBox tarjetas = new HBox(15);
        tarjetas.getChildren().addAll(
                crearTarjeta("Carlos Perez", "Administrador"),
                crearTarjeta("Maria Lopez", "Vendedora"),
                crearTarjeta("Piero Ramos", "Supervisor")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(contenido);
    }

    public void mostrarProductos() {
        VBox contenido = crearContenedorBase("PRODUCTOS");
        HBox tarjetas = new HBox(15);
        tarjetas.getChildren().addAll(
                crearTarjeta("Laptop Lenovo", "S/ 2500"),
                crearTarjeta("Mouse Logitech", "S/ 80"),
                crearTarjeta("Teclado Mecánico", "S/ 180")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(contenido);
    }

    public void mostrarVentas() {
        VBox contenido = crearContenedorBase("VENTAS");
        HBox tarjetas = new HBox(15);
        tarjetas.getChildren().addAll(
                crearTarjeta("Venta #001", "S/ 2580"),
                crearTarjeta("Venta #002", "S/ 1240"),
                crearTarjeta("Venta #003", "S/ 890")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(contenido);
    }

    public void mostrarReportes() {
        VBox contenido = crearContenedorBase("REPORTES");
        HBox tarjetas = new HBox(15);
        tarjetas.getChildren().addAll(
                crearTarjeta("Ventas del mes", "S/ 15,250"),
                crearTarjeta("Productos", "128 registrados"),
                crearTarjeta("Usuarios", "25 activos")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(contenido);
    }

    public void mostrarClientes() {
        VBox contenido = crearContenedorBase("CLIENTES");
        HBox tarjetas = new HBox(15);
        tarjetas.getChildren().addAll(
                crearTarjeta("Empresa Alfa", "RUC: 20123456789"),
                crearTarjeta("Juan Mendoza", "DNI: 45896321"),
                crearTarjeta("Tech Solutions", "RUC: 20987654321")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(contenido);
    }

    public void mostrarProveedores() {
        VBox contenido = crearContenedorBase("PROVEEDORES");
        HBox tarjetas = new HBox(15);
        tarjetas.getChildren().addAll(
                crearTarjeta("Distribuidora Lima", "Tel: 987-654-321"),
                crearTarjeta("Import de Perú", "Tel: 912-345-678"),
                crearTarjeta("Global Logistics", "Tel: 955-443-322")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(contenido);
    }

    public void mostrarConfiguracion() {
        VBox contenido = crearContenedorBase("CONFIGURACIÓN");
        HBox tarjetas = new HBox(15);
        tarjetas.getChildren().addAll(
                crearTarjeta("Perfil", "Administrar perfil"),
                crearTarjeta("Seguridad", "Configuración de acceso"),
                crearTarjeta("Sistema", "Preferencias")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(contenido);
    }

    public void mostrarAyuda() {
        VBox contenido = crearContenedorBase("CENTRO DE AYUDA");
        HBox tarjetas = new HBox(15);
        tarjetas.getChildren().addAll(
                crearTarjeta("Manual de Uso", "Guía paso a paso"),
                crearTarjeta("Soporte Técnico", "soporte@vallegrande.edu.pe"),
                crearTarjeta("Acerca de", "Versión 1.0.0")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(contenido);
    }

    private VBox crearContenedorBase(String tituloTexto) {
        VBox contenedor = new VBox(20);
        contenedor.setPadding(new Insets(30));
        Label titulo = new Label(tituloTexto);
        titulo.setStyle("-fx-font-size: 26px; -fx-font-weight: bold;");
        contenedor.getChildren().add(titulo);
        return contenedor;
    }

    private VBox crearTarjeta(String titulo, String detalle) {
        VBox tarjeta = new VBox(8);
        tarjeta.setPadding(new Insets(20));
        tarjeta.setPrefWidth(180);

        // Tarjetas con fondo verde claro muy suave (#E6F4EA)
        tarjeta.setStyle("-fx-background-color: #E6F4EA; -fx-background-radius: 12;");

        Label nombre = new Label(titulo);
        nombre.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: #064E3B;");

        Label info = new Label(detalle);
        info.setStyle("-fx-font-size: 12px; -fx-text-fill: #374151;");

        tarjeta.getChildren().addAll(nombre, info);
        return tarjeta;
    }

    public Button getBtnInicio() { return btnInicio; }
    public Button getBtnUsuarios() { return btnUsuarios; }
    public Button getBtnProductos() { return btnProductos; }
    public Button getBtnVentas() { return btnVentas; }
    public Button getBtnReportes() { return btnReportes; }
    public Button getBtnConfiguracion() { return btnConfiguracion; }
    public Button getBtnClientes() { return btnClientes; }
    public Button getBtnProveedores() { return btnProveedores; }
    public Button getBtnAyuda() { return btnAyuda; }
}