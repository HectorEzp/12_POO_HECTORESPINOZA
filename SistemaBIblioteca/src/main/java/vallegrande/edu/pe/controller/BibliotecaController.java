package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Libro;

import java.util.ArrayList;

public class BibliotecaController {

    // LISTA DONDE ALMACENAREMOS NUESTROS LIBROS
    private ArrayList<Libro> libros;

    // CONSTRUCTOR
    public BibliotecaController() {
        libros = new ArrayList<>();
    }

    // REGISTRAR
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro registrado correctamente");
    }

    // LISTAR
    public void listarLibros() {

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados");
            return;
        }

        System.out.println("===== LISTA DE LIBROS =====");

        for (Libro libro : libros) {
            libro.mostrarLibro();
        }
    }

    // BUSCAR
    public void buscarLibro(String criterio) {

        boolean encontrado = false;
        String texto = criterio.toLowerCase();

        for (Libro libro : libros) {

            if (libro.getTitulo().toLowerCase().contains(texto)
                    || libro.getAutor().toLowerCase().contains(texto)) {

                libro.mostrarLibro();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontro ningun libro");
        }
    }
}