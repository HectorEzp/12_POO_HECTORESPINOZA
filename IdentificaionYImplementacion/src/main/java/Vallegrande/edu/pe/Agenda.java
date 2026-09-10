package Vallegrande.edu.pe;

import java.util.ArrayList;

public class Agenda {

    private ArrayList<Contacto> contactos;

    // Constructor
    public Agenda() {
        contactos = new ArrayList<>();
    }

    // Registrar contacto
    public void registrarContacto(Contacto contacto) {
        contactos.add(contacto);
        System.out.println("Contacto registrado correctamente.");
    }

    // Mostrar contactos
    public void mostrarContactos() {

        if (contactos.isEmpty()) {
            System.out.println("No existen contactos registrados.");
            return;
        }

        System.out.println("===== LISTA DE CONTACTOS =====");

        for (Contacto contacto : contactos) {
            contacto.mostrarDatos();
        }
    }

    // Buscar contacto
    public void buscarContacto(String nombre) {

        for (Contacto contacto : contactos) {

            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Contacto encontrado:");
                contacto.mostrarDatos();
                return;
            }
        }

        System.out.println("Contacto no encontrado.");
    }
}