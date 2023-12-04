package co.edu.poli.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;



public class Biblioteca {
    private List<Libro> inventario = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        inventario.add(libro);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Libro> buscarLibrosPorTitulo(String criterio) {
    	long tiempoInicial = System.currentTimeMillis();
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : inventario) {
            if (libro.getTitulo().contains(criterio)) {
                resultados.add(libro);
            }
        }
        long tiempoFinal = System.currentTimeMillis();
        long tiempoTranscurrido = tiempoFinal - tiempoInicial;
        System.out.println("El método tomó " + tiempoTranscurrido + " milisegundos en ejecutarse.");
        return resultados;
    }
    public List<Libro> buscarLibrosPorAutor(String criterio) {
    	long tiempoInicial = System.currentTimeMillis();
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : inventario) {
            if (libro.getAutor().contains(criterio)) {
                resultados.add(libro);
            }
        }
        long tiempoFinal = System.currentTimeMillis();
        long tiempoTranscurrido = tiempoFinal - tiempoInicial;
        System.out.println("El método tomó " + tiempoTranscurrido + " milisegundos en ejecutarse.");
        return resultados;
    }


    public void realizarPrestamo(Usuario usuario, Libro libro) {
    	long tiempoInicial = System.currentTimeMillis();
        if (!libro.estaPrestado()) {
            libro.prestar();
            JOptionPane.showMessageDialog(null,usuario.getNombre() + " ha tomado prestado el libro: " + libro.getTitulo());
        } else {
        	JOptionPane.showMessageDialog(null,"El libro " + libro.getTitulo() + " ya está prestado.");
        }
        long tiempoFinal = System.currentTimeMillis();
        long tiempoTranscurrido = tiempoFinal - tiempoInicial;
        System.out.println("El método PRESTAMO tomó " + tiempoTranscurrido + " milisegundos en ejecutarse.");
    }

    public void realizarDevolucion(Usuario usuario, Libro libro) {
    	long tiempoInicial = System.currentTimeMillis();
        if (libro.estaPrestado()) {
            libro.devolver();
            JOptionPane.showMessageDialog(null,usuario.getNombre() + " ha devuelto el libro: " + libro.getTitulo());
        
        } else {
            
            JOptionPane.showMessageDialog(null,"El libro " + libro.getTitulo() + " no está prestado.");
        }
        long tiempoFinal = System.currentTimeMillis();
        long tiempoTranscurrido = tiempoFinal - tiempoInicial;
        System.out.println("El método PRESTAMO tomó " + tiempoTranscurrido + " milisegundos en ejecutarse.");
    }

    public void notificarUsuariosLibroAgregado() {
    	long tiempoInicial = System.currentTimeMillis();
        if (!inventario.isEmpty()) {
            Libro libroAgregado = inventario.get(inventario.size() - 1);
            for (Usuario usuario : usuarios) {
                usuario.notificarLibroAgregado(libroAgregado);
            }
        }
        long tiempoFinal = System.currentTimeMillis();
        long tiempoTranscurrido = tiempoFinal - tiempoInicial;
        System.out.println("El método tomó " + tiempoTranscurrido + " milisegundos en ejecutarse.");
    }
}