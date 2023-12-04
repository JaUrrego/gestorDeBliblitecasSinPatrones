package co.edu.poli.biblioteca.model;



public class Usuario {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void notificarLibroAgregado(Libro libro) {
        System.out.println("Hola, " + nombre + "! El libro '" + libro.getTitulo() + "' ha sido agregado a la biblioteca.");
    }
}

