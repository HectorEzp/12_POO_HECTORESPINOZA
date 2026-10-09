package vallegrande.edu.pe.misistema.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import vallegrande.edu.pe.misistema.model.Producto;

public class MainView extends BorderPane {

    // Botones del menú
    private Button btnInicio;
    private Button btnProductos;

    // Campos del formulario
    private TextField txtNombre;
    private TextField txtCategoria;
    private TextField txtCantidad;
    private TextField txtPrecio;

    // Botones de acción CRUD
    private Button btnRegistrar;
    private Button btnActualizar;
    private Button btnEliminar;
    private Button btnLimpiar;

    // Etiquetas informativas y contador
    private Label lblContadorRegistros;
    private Label lblMensajeEstado;

    // Tabla donde mostraremos los productos
    private TableView<Producto> tablaProductos;

    public MainView() {

        // Creamos el menú lateral
        crearMenu();

        // Creamos la tabla
        crearTabla();

        // Creamos los campos y botones del formulario
        crearFormulario();

        // Fondo general beige claro / crema elegante
        this.setStyle("-fx-background-color: #FAF6F0;");

        // Mostramos la pantalla de productos por defecto
        mostrarProductos();
    }

    // Crea el menú lateral
    private void crearMenu() {

        VBox menu = new VBox();
        menu.setPadding(new Insets(25, 15, 20, 15));
        menu.setPrefWidth(220);

        // Encabezado principal del sistema
        Label lblMarca = new Label("MI SISTEMA");
        lblMarca.setStyle(
                "-fx-font-size: 22px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #FFFFFF;" +
                        "-fx-font-family: 'Segoe UI', 'sans-serif';"
        );

        Label lblSubtitulo = new Label("Gestión de Productos");
        lblSubtitulo.setStyle(
                "-fx-font-size: 12px;" +
                        "-fx-text-fill: #A0C0B0;" +
                        "-fx-padding: 0 0 25 0;"
        );

        VBox boxMarca = new VBox(2, lblMarca, lblSubtitulo);

        // Botones del menú
        btnInicio = new Button("Inicio");
        btnInicio.setPrefWidth(190);
        btnInicio.setPrefHeight(42);
        btnInicio.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-text-fill: #FFFFFF;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-alignment: CENTER_LEFT;" +
                        "-fx-padding: 0 0 0 20;" +
                        "-fx-cursor: hand;"
        );

        btnProductos = new Button("Productos");
        btnProductos.setPrefWidth(190);
        btnProductos.setPrefHeight(42);
        // Estilo activo tipo píldora en naranja
        btnProductos.setStyle(
                "-fx-background-color: #E08709;" +
                        "-fx-text-fill: #FFFFFF;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 21px;" +
                        "-fx-alignment: CENTER_LEFT;" +
                        "-fx-padding: 0 0 0 20;" +
                        "-fx-cursor: hand;"
        );

        VBox boxOpciones = new VBox(10, btnInicio, btnProductos);

        // Widget de Reloj / Fecha en la parte inferior del menú
        VBox boxReloj = crearWidgetReloj();

        // Espaciador vertical
        VBox espaciador = new VBox();
        VBox.setVgrow(espaciador, Priority.ALWAYS);

        menu.getChildren().addAll(boxMarca, boxOpciones, espaciador, boxReloj);

        // Estilo Verde Oscuro Profundo
        menu.setStyle("-fx-background-color: #0F3822;");

        setLeft(menu);
    }

    // Widget inferior para mostrar Hora y Fecha dinámica
    private VBox crearWidgetReloj() {
        Label lblHora = new Label();
        lblHora.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #FFFFFF;");

        Label lblFecha = new Label();
        lblFecha.setStyle("-fx-font-size: 11px; -fx-text-fill: #C0D8C8;");

        DateTimeFormatter fmtHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter fmtFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Timeline reloj = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalDateTime ahora = LocalDateTime.now();
            lblHora.setText(ahora.format(fmtHora));
            lblFecha.setText(ahora.format(fmtFecha));
        }), new KeyFrame(Duration.seconds(1)));
        reloj.setCycleCount(Animation.INDEFINITE);
        reloj.play();

        VBox box = new VBox(3, lblHora, lblFecha);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(10));
        box.setStyle(
                "-fx-background-color: rgba(0, 0, 0, 0.2);" +
                        "-fx-background-radius: 12px;"
        );
        return box;
    }

    // Estiliza campos de texto con bordes redondeados suaves y fondo beige tenue
    private VBox crearCampoConEtiqueta(String titulo, TextField campo, String prompt) {
        Label lbl = new Label(titulo);
        lbl.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #222222;");

        campo.setPromptText(prompt);
        campo.setStyle(
                "-fx-pref-height: 38px;" +
                        "-fx-font-size: 13px;" +
                        "-fx-background-color: #F8EFE0;" +
                        "-fx-background-radius: 10px;" +
                        "-fx-border-color: #E2D5C3;" +
                        "-fx-border-radius: 10px;" +
                        "-fx-padding: 0 12px;"
        );

        return new VBox(5, lbl, campo);
    }

    // Muestra la pantalla de inicio
    public void mostrarInicio() {
        VBox contenido = new VBox(15);
        contenido.setAlignment(Pos.CENTER);

        Label titulo = new Label("BIENVENIDO");
        titulo.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: #0F3822;");

        Label texto = new Label("Sistema de Gestión de Productos");
        texto.setStyle("-fx-font-size: 16px; -fx-text-fill: #666666;");

        contenido.getChildren().addAll(titulo, texto);
        setCenter(contenido);
    }

    // Muestra la pantalla principal con panel de formulario (izq) y tabla (der)
    public void mostrarProductos() {

        HBox layoutPrincipal = new HBox(20);
        layoutPrincipal.setPadding(new Insets(20));

        // --- PANEL IZQUIERDO: FORMULARIO ---
        VBox panelIzquierdo = new VBox(14);
        panelIzquierdo.setPadding(new Insets(20));
        panelIzquierdo.setPrefWidth(340);
        panelIzquierdo.setStyle(
                "-fx-background-color: #FFFFFF;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 10, 0, 0, 2);"
        );

        Label lblTituloForm = new Label("Registra o edita un producto");
        lblTituloForm.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0F3822;");

        Label lblSubForm = new Label("Ingrese los datos correspondientes del inventario.");
        lblSubForm.setStyle("-fx-font-size: 12px; -fx-text-fill: #777777; -fx-padding: 0 0 10 0;");

        VBox boxFormHeader = new VBox(3, lblTituloForm, lblSubForm);

        VBox fNombre = crearCampoConEtiqueta("Nombre del producto *", txtNombre, "Ej. Café Orgánico");
        VBox fCategoria = crearCampoConEtiqueta("Categoría *", txtCategoria, "Ej. Bebidas / Frutas");
        VBox fCantidad = crearCampoConEtiqueta("Cantidad en Stock *", txtCantidad, "Ej. 50");
        VBox fPrecio = crearCampoConEtiqueta("Precio Unitario (S/) *", txtPrecio, "Ej. 25.50");

        // Botones estilo píldora
        GridPane gridBotones = new GridPane();
        gridBotones.setHgap(10);
        gridBotones.setVgap(10);
        gridBotones.setPadding(new Insets(10, 0, 0, 0));

        gridBotones.add(btnRegistrar, 0, 0);
        gridBotones.add(btnActualizar, 1, 0);
        gridBotones.add(btnEliminar, 0, 1);
        gridBotones.add(btnLimpiar, 1, 1);

        lblMensajeEstado = new Label("✓ Listo para registrar");
        lblMensajeEstado.setStyle("-fx-font-size: 12px; -fx-text-fill: #0F3822; -fx-font-weight: bold;");

        panelIzquierdo.getChildren().addAll(
                boxFormHeader,
                fNombre,
                fCategoria,
                fCantidad,
                fPrecio,
                gridBotones,
                lblMensajeEstado
        );

        // --- PANEL DERECHO: TABLA ---
        VBox panelDerecho = new VBox(12);
        panelDerecho.setPadding(new Insets(20));
        panelDerecho.setStyle(
                "-fx-background-color: #FFFFFF;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 10, 0, 0, 2);"
        );
        HBox.setHgrow(panelDerecho, Priority.ALWAYS);

        Label lblTituloTabla = new Label("Productos registrados");
        lblTituloTabla.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0F3822;");

        lblContadorRegistros = new Label("0 registros");
        lblContadorRegistros.setStyle("-fx-font-size: 12px; -fx-text-fill: #888888;");

        HBox headerTabla = new HBox(lblTituloTabla, new VBox(), lblContadorRegistros);
        HBox.setHgrow(headerTabla.getChildren().get(1), Priority.ALWAYS);
        headerTabla.setAlignment(Pos.CENTER_LEFT);

        VBox.setVgrow(tablaProductos, Priority.ALWAYS);
        panelDerecho.getChildren().addAll(headerTabla, tablaProductos);

        layoutPrincipal.getChildren().addAll(panelIzquierdo, panelDerecho);
        setCenter(layoutPrincipal);
    }

    // Crea los campos y botones del formulario
    private void crearFormulario() {

        txtNombre = new TextField();
        txtCategoria = new TextField();
        txtCantidad = new TextField();
        txtPrecio = new TextField();

        // Botón Registrar (Naranja)
        btnRegistrar = new Button("Registrar");
        btnRegistrar.setPrefWidth(125);
        btnRegistrar.setPrefHeight(36);
        btnRegistrar.setStyle(
                "-fx-background-color: #E08709;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 18px;" +
                        "-fx-cursor: hand;"
        );

        // Botón Actualizar (Verde oscuro)
        btnActualizar = new Button("Actualizar");
        btnActualizar.setPrefWidth(125);
        btnActualizar.setPrefHeight(36);
        btnActualizar.setStyle(
                "-fx-background-color: #0F3822;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 18px;" +
                        "-fx-cursor: hand;"
        );

        // Botón Eliminar (Borde rojo)
        btnEliminar = new Button("Eliminar");
        btnEliminar.setPrefWidth(125);
        btnEliminar.setPrefHeight(36);
        btnEliminar.setStyle(
                "-fx-background-color: #FFFFFF;" +
                        "-fx-text-fill: #D93838;" +
                        "-fx-border-color: #D93838;" +
                        "-fx-border-width: 1.5px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 18px;" +
                        "-fx-border-radius: 18px;" +
                        "-fx-cursor: hand;"
        );

        // Botón Limpiar (Borde verde)
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setPrefWidth(125);
        btnLimpiar.setPrefHeight(36);
        btnLimpiar.setStyle(
                "-fx-background-color: #FFFFFF;" +
                        "-fx-text-fill: #0F3822;" +
                        "-fx-border-color: #0F3822;" +
                        "-fx-border-width: 1.5px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 18px;" +
                        "-fx-border-radius: 18px;" +
                        "-fx-cursor: hand;"
        );

        btnLimpiar.setOnAction(e -> limpiarFormulario());
    }

    // Crea la tabla de productos
    private void crearTabla() {

        tablaProductos = new TableView<>();

        TableColumn<Producto, Integer> colId = new TableColumn<>("ID");
        TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");
        TableColumn<Producto, String> colCategoria = new TableColumn<>("Categoría");
        TableColumn<Producto, Integer> colCantidad = new TableColumn<>("Cantidad");
        TableColumn<Producto, Double> colPrecio = new TableColumn<>("Precio (S/)");

        colId.setPrefWidth(50);
        colNombre.setPrefWidth(150);
        colCategoria.setPrefWidth(120);
        colCantidad.setPrefWidth(80);
        colPrecio.setPrefWidth(90);

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        tablaProductos.getColumns().addAll(colId, colNombre, colCategoria, colCantidad, colPrecio);
    }

    // Recibe los productos y los muestra en la tabla
    public void mostrarDatosProductos(List<Producto> productos) {
        tablaProductos.setItems(FXCollections.observableArrayList(productos));
        if (lblContadorRegistros != null) {
            lblContadorRegistros.setText(productos.size() + " registros");
        }
    }

    public void limpiarFormulario() {
        txtNombre.clear();
        txtCategoria.clear();
        txtCantidad.clear();
        txtPrecio.clear();
        if (lblMensajeEstado != null) {
            lblMensajeEstado.setText("✓ Formulario limpiado");
        }
    }

    public void setMensajeEstado(String mensaje) {
        if (lblMensajeEstado != null) {
            lblMensajeEstado.setText(mensaje);
        }
    }

    // Getters para el controlador
    public Button getBtnInicio() { return btnInicio; }
    public Button getBtnProductos() { return btnProductos; }
    public Button getBtnRegistrar() { return btnRegistrar; }
    public Button getBtnActualizar() { return btnActualizar; }
    public Button getBtnEliminar() { return btnEliminar; }
    public Button getBtnLimpiar() { return btnLimpiar; }

    public String getNombre() { return txtNombre.getText(); }
    public String getCategoria() { return txtCategoria.getText(); }
    public String getCantidad() { return txtCantidad.getText(); }
    public String getPrecio() { return txtPrecio.getText(); }

    public Producto getProductoSeleccionado() {
        return tablaProductos.getSelectionModel().getSelectedItem();
    }

    public void cargarProductoEnFormulario(Producto producto) {
        if (producto != null) {
            txtNombre.setText(producto.getNombre() != null ? producto.getNombre() : "");
            txtCategoria.setText(producto.getCategoria() != null ? producto.getCategoria() : "");
            txtCantidad.setText(producto.getCantidad() > 0 ? String.valueOf(producto.getCantidad()) : "");
            txtPrecio.setText(producto.getPrecio() > 0 ? String.valueOf(producto.getPrecio()) : "");
            setMensajeEstado("✓ Producto #" + producto.getId() + " seleccionado");
        }
    }

    public TableView<Producto> getTablaProductos() {
        return tablaProductos;
    }
}