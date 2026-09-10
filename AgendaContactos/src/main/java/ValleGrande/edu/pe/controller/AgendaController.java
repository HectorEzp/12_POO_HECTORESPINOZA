package ValleGrande.edu.pe.controller;

import ValleGrande.edu.pe.model.Contacto;
import java.util.ArrayList;

public class AgendaController {
    private ArrayList<Contacto> contactos;

    public AgendaController() {
        contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
        System.out.println("Contacto registrado correctamente.");
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No existen contactos registrados.");
            return;
        }
        System.out.println("===== LISTA DE CONTACTOS =====");
        for (Contacto contacto : contactos) {
            contacto.mostrarContacto();
        }
    }

    public void buscarContacto(String texto) {
        boolean encontrado = false;
        for (Contacto contacto : contactos) {
            if (contacto.getNombres().toLowerCase().contains(texto.toLowerCase()) ||
                    contacto.getApellidos().toLowerCase().contains(texto.toLowerCase())) {
                contacto.mostrarContacto();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron contactos.");
        }
    }

    public void eliminarContacto(int id) {
        Contacto contactoEliminar = null;
        for (Contacto contacto : contactos) {
            if (contacto.getId() == id) {
                contactoEliminar = contacto;
                break;
            }
        }
        if (contactoEliminar != null) {
            contactos.remove(contactoEliminar);
            System.out.println("Contacto eliminado correctamente.");
        } else {
            System.out.println("No existe un contacto con el ID " + id);
        }
    }
}