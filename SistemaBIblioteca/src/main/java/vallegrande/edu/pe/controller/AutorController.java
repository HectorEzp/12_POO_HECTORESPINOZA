package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Autor;

import java.util.ArrayList;

public class AutorController {

    // LISTA PARA ALMACENAR AUTORES
    private ArrayList<Autor> autores;

    // CONSTRUCTOR
    public AutorController() {
        autores = new ArrayList<>();
    }

    // REGISTRAR AUTOR
    public void agregarAutor(Autor autor) {
        autores.add(autor);
        System.out.println("Autor registrado correctamente");
    }

    // LISTAR AUTORES
    public void listarAutores() {
        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados");
            return;
        }

        System.out.println("===== LISTA DE AUTORES =====");

        for (Autor autor : autores) {
            autor.mostrarAutor();
        }
    }
}