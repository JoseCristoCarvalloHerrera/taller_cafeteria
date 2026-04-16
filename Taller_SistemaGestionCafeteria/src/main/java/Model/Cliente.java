package Model;

public class Cliente {
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = validarNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = validarNombre(nombre);
    }

    private String validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacio");
        }
        return nombre.trim();
    }
}