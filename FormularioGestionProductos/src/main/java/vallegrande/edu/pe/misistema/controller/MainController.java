package vallegrande.edu.pe.misistema.controller;

import java.util.List;
import javafx.scene.control.Alert;
import vallegrande.edu.pe.misistema.model.Producto;
import vallegrande.edu.pe.misistema.model.ProductoDAO;
import vallegrande.edu.pe.misistema.view.MainView;

public class MainController {

    private MainView view;
    private ProductoDAO dao;

    public MainController(MainView view) {
        this.view = view;
        this.dao = new ProductoDAO();
        initController();
    }

    private void initController() {
        // Eventos de los botones del menú lateral
        view.getBtnInicio().setOnAction(e -> view.mostrarInicio());
        view.getBtnProductos().setOnAction(e -> {
            view.mostrarProductos();
            cargarTabla();
        });

        // Eventos CRUD
        view.getBtnRegistrar().setOnAction(e -> registrar());
        view.getBtnActualizar().setOnAction(e -> actualizar());
        view.getBtnEliminar().setOnAction(e -> eliminar());

        // Al hacer clic en una fila de la tabla, se cargan los datos en el formulario
        view.getTablaProductos().getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                view.cargarProductoEnFormulario(newSel);
            }
        });
    }

    private void cargarTabla() {
        List<Producto> lista = dao.listar();
        view.mostrarDatosProductos(lista);
    }

    private void registrar() {
        try {
            String nombre = view.getNombre();
            String categoria = view.getCategoria();
            int cantidad = Integer.parseInt(view.getCantidad());
            double precio = Double.parseDouble(view.getPrecio());

            Producto p = new Producto(nombre, categoria, cantidad, precio);

            if (dao.registrar(p)) {
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Producto registrado correctamente.");
                limpiarCampos();
                cargarTabla();
            } else {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo registrar el producto.");
            }
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.WARNING, "Validación", "Verifique que la cantidad y precio sean valores numéricos.");
        }
    }

    private void actualizar() {
        Producto seleccionado = view.getProductoSeleccionado();
        if (seleccionado == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Seleccione un producto de la tabla.");
            return;
        }

        try {
            int id = seleccionado.getId();
            String nombre = view.getNombre();
            String categoria = view.getCategoria();
            int cantidad = Integer.parseInt(view.getCantidad());
            double precio = Double.parseDouble(view.getPrecio());

            Producto p = new Producto(id, nombre, categoria, cantidad, precio);

            if (dao.actualizar(p)) {
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Producto actualizado correctamente.");
                limpiarCampos();
                cargarTabla();
            } else {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo actualizar el producto.");
            }
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.WARNING, "Validación", "Verifique los campos numéricos.");
        }
    }

    private void eliminar() {
        Producto seleccionado = view.getProductoSeleccionado();
        if (seleccionado == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Seleccione un producto de la tabla.");
            return;
        }

        if (dao.eliminar(seleccionado.getId())) {
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Producto eliminado correctamente.");
            limpiarCampos();
            cargarTabla();
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo eliminar el producto.");
        }
    }

    private void limpiarCampos() {
        view.cargarProductoEnFormulario(new Producto("", "", 0, 0.0));
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}