package Service;

import Model.Cliente;
import Model.Pedido;
import Model.Producto;

class PedidoServiceTest {

    public static void main(String[] args) {
        calcularTotalDebeSumarPreciosDeTodosLosProductos();
        agregarProductoNuloDebeLanzarExcepcion();
        System.out.println("PRUEBAS_OK");
    }

    static void calcularTotalDebeSumarPreciosDeTodosLosProductos() {
        Pedido pedido = new Pedido(new Cliente("Ana"));
        pedido.agregarProducto(new Producto("Cafe", 1200));
        pedido.agregarProducto(new Producto("Medialuna", 800));

        PedidoService service = new PedidoService();
        double total = service.calcularTotal(pedido);

        if (total != 2000) {
            throw new IllegalStateException("Fallo en calcularTotal: esperado 2000, obtenido " + total);
        }
    }

    static void agregarProductoNuloDebeLanzarExcepcion() {
        Pedido pedido = new Pedido(new Cliente("Ana"));
        try {
            pedido.agregarProducto(null);
            throw new IllegalStateException("Se esperaba IllegalArgumentException al agregar producto nulo");
        } catch (IllegalArgumentException expected) {
            // Excepcion esperada
        }
    }
}

