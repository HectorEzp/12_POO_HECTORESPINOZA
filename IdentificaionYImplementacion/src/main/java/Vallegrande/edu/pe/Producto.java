package Vallegrande.edu.pe;

public class Producto {

    // Atributos
    private String nombre;
    private String codigo;
    private double precio;
    private int stock;
    private String categoria;

    // Constructor
    public Producto(String nombre, String codigo, double precio,
                    int stock, String categoria) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    // Métodos Get y Set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Método para mostrar los datos del producto
    public void mostrarDatos() {
        System.out.println("===== DATOS DEL PRODUCTO =====");
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Precio: S/ " + precio);
        System.out.println("Stock: " + stock);
        System.out.println("Categoría: " + categoria);
    }
}