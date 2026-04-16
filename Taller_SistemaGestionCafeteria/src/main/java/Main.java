import Model.Cliente;
import Model.Producto;
import Service.PedidoService;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Jose");

        Producto p1 = new Producto("Cafe", 2.5);
        Producto p2 = new Producto("Pan", 1.5);

        model.Pedido pedido = new model.Pedido(cliente);
        pedido.agregarProducto(p1);
        pedido.agregarProducto(p2);

        PedidoService service = new PedidoService();
        service.mostrarPedido(pedido);
    }
}
