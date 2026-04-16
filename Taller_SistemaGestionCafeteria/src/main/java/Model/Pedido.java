package model;

import Model.Cliente;
import Model.Producto;

import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private ArrayList<Producto> productos;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
}