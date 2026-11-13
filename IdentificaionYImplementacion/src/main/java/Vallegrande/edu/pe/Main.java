package Vallegrande.edu.pe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // PRUEBA DE LA CLASE PRODUCTO

        Producto producto1 = new Producto(
                "Laptop Lenovo",
                "P001",
                2500.00,
                10,
                "Tecnología"
        );

        producto1.mostrarDatos();

        // AGENDA DE CONTACTOS

        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        int opcion;

        do {

            System.out.println("\n===== AGENDA DE CONTACTOS =====");
            System.out.println("1. Registrar contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese el teléfono: ");
                    String telefono = scanner.nextLine();

                    System.out.print("Ingrese el correo: ");
                    String correo = scanner.nextLine();

                    Contacto nuevoContacto =
                            new Contacto(nombre, telefono, correo);

                    agenda.registrarContacto(nuevoContacto);
                    break;

                case 2:
                    agenda.mostrarContactos();
                    break;

                case 3:
                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombreBuscar = scanner.nextLine();

                    agenda.buscarContacto(nombreBuscar);
                    break;

                case 4:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}