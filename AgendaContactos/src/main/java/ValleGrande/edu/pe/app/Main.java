package ValleGrande.edu.pe.app;

import ValleGrande.edu.pe.controller.AgendaController;
import ValleGrande.edu.pe.model.Contacto;
import ValleGrande.edu.pe.view.AgendaView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AgendaController controller = new AgendaController();
        AgendaView view = new AgendaView();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        int idAutomatico = 6;

        controller.agregarContacto(new Contacto(1, "Ana", "Torres", "Cañete", "983745656", "ana@gmail.com"));
        controller.agregarContacto(new Contacto(2, "Carlos", "Perez", "Imperial", "951264456", "carlos@gmail.com"));
        controller.agregarContacto(new Contacto(3, "Luis", "Gomez", "San Vicente", "987654321", "luis@gmail.com"));
        controller.agregarContacto(new Contacto(4, "Maria", "Lopez", "Nuevo Imperial", "965874123", "maria@gmail.com"));
        controller.agregarContacto(new Contacto(5, "Jose", "Ramirez", "Lunahuaná", "978541236", "jose@gmail.com"));

        view.mostrarTitulo();

        do {
            view.mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombres: ");
                    String nombres = scanner.nextLine();
                    System.out.print("Ingrese apellidos: ");
                    String apellidos = scanner.nextLine();
                    System.out.print("Ingrese dirección: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Ingrese teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Ingrese correo electrónico: ");
                    String correo = scanner.nextLine();

                    Contacto nuevoContacto = new Contacto(idAutomatico, nombres, apellidos, direccion, telefono, correo);
                    controller.agregarContacto(nuevoContacto);
                    idAutomatico++;
                    break;

                case 2:
                    controller.listarContactos();
                    break;

                case 3:
                    System.out.print("Ingrese nombre o apellido: ");
                    String busqueda = scanner.nextLine();
                    controller.buscarContacto(busqueda);
                    break;

                case 4:
                    controller.listarContactos();
                    System.out.print("Ingrese el ID del contacto a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine();
                    controller.eliminarContacto(idEliminar);
                    break;

                case 5:
                    System.out.println("Saliendo de la agenda...");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}