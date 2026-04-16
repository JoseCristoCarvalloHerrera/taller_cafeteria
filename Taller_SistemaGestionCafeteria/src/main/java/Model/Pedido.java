package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {
    private final Cliente cliente;
    private final List<Producto> productos;

    public Pedido(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente es obligatorio para crear un pedido");
        }
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return Collections.unmodifiableList(productos);
    }

    public void agregarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("No se puede agregar un producto nulo");
        }
        productos.add(producto);
    }
}