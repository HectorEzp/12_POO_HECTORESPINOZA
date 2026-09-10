package vallegrande.edu.pe.miperfil.model;

public class Perfil {

    private String nombre;
    private String carrera;
    private String semestre;
    private String turno;

    public Perfil(String nombre, String carrera, String semestre, String turno) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.semestre = semestre;
        this.turno = turno;
    }

    public String obtenerPresentacion() {
        return "Nombre: " + nombre +
                "\nCarrera: " + carrera +
                "\nSemestre: " + semestre +
                "\nTurno: " + turno;
    }
}