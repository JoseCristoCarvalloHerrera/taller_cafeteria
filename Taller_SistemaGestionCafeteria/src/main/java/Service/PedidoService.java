package Service;

import Model.Pedido;
import Model.Producto;

public class PedidoService {

    public double calcularTotal(Pedido pedido) {
        double total = 0;

        for (Producto p : pedido.getProductos()) {
            total += p.getPrecio();
        }

        return total;
    }

    public void mostrarPedido(Pedido pedido) {
        System.out.println(generarDetallePedido(pedido));
    }

    public String generarDetallePedido(Pedido pedido) {
        StringBuilder detalle = new StringBuilder();
        detalle.append("\nCliente: ").append(pedido.getCliente().getNombre()).append("\n");
        detalle.append("Productos:\n");

        for (Producto p : pedido.getProductos()) {
            detalle.append("- ").append(p.getNombre()).append(" $").append(p.getPrecio()).append("\n");
        }

        detalle.append("Total: $").append(calcularTotal(pedido));
        return detalle.toString();
    }
}