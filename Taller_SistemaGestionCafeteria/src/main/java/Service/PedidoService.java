package Service;

import Model.Producto;

public class PedidoService {

    public double calcularTotal(model.Pedido pedido) {
        double total = 0;

        for (Producto p : pedido.getProductos()) {
            total += p.getPrecio();
        }

        return total;
    }

    public void mostrarPedido(model.Pedido pedido) {
        System.out.println("cliente: " + pedido.getCliente().getNombre());
        System.out.println("Productos:");

        for (Producto p : pedido.getProductos()) {
            System.out.println("- " + p.getNombre() + " $" + p.getPrecio());
        }

        System.out.println("Total: $" + calcularTotal(pedido));
    }
}