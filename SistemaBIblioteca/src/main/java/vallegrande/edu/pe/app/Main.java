package vallegrande.edu.pe.app;

import vallegrande.edu.pe.controller.AutorController;
import vallegrande.edu.pe.controller.BibliotecaController;
import vallegrande.edu.pe.model.Autor;
import vallegrande.edu.pe.model.Libro;
import vallegrande.edu.pe.view.BibliotecaView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BibliotecaController controller = new BibliotecaController();
        AutorController autorController = new AutorController();
        BibliotecaView view = new BibliotecaView();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        view.mostrarTitulo();
        do {
            view.mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                // REGISTRAR LIBRO
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Autor: ");
                    String autorLibro = scanner.nextLine();

                    System.out.print("Año: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine();
                    // VALIDAR DATOS
                    if (titulo.isEmpty() || autorLibro.isEmpty() || anio <= 0) {
                        System.out.println("Datos no validos");
                    } else {
                        Libro libro = new Libro(
                                id,
                                titulo,
                                autorLibro,
                                anio
                        );
                        controller.agregarLibro(libro);
                    }
                    break;
                // LISTAR LIBROS
                case 2:
                    controller.listarLibros();
                    break;
                // BUSCAR LIBRO
                case 3:
                    System.out.print("Ingrese Titulo o Autor: ");
                    String criterio = scanner.nextLine();
                    controller.buscarLibro(criterio);
                    break;
                // REGISTRAR AUTOR
                case 4:
                    System.out.print("ID del Autor: ");
                    int idAutor = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre del Autor: ");
                    String nombreAutor = scanner.nextLine();
                    // VALIDACION OBLIGATORIA
                    if (nombreAutor.trim().isEmpty()) {

                        System.out.println("El nombre del autor no puede estar vacio.");
                        break;
                    }
                    System.out.print("Nacionalidad: ");
                    String nacionalidad = scanner.nextLine();
                    Autor nuevoAutor = new Autor(
                            idAutor,
                            nombreAutor,
                            nacionalidad
                    );
                    autorController.agregarAutor(nuevoAutor);
                    break;
                // LISTAR AUTORES
                case 5:
                    autorController.listarAutores();
                    break;
                // SALIR
                case 6:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 6);
        scanner.close();
    }
}