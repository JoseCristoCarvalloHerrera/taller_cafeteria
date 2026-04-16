import Model.Cliente;
import Model.Producto;
import Model.Pedido;
import Service.PedidoService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PedidoService service = new PedidoService();
        Map<String, Pedido> pedidosPorCliente = new LinkedHashMap<>();

        System.out.println("=== SISTEMA CAFETERIA ===");
        Pedido pedidoActual = registrarNuevoCliente(sc, pedidosPorCliente);

        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar pedido");
            System.out.println("3. Calcular total");
            System.out.println("4. Cambiar o registrar cliente");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = leerEntero(sc);

            switch (opcion) {

                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombreProducto = sc.nextLine();

                    System.out.print("Precio: ");
                    double precio = leerDouble(sc);

                    try {
                        Producto producto = new Producto(nombreProducto, precio);
                        pedidoActual.agregarProducto(producto);
                        System.out.println("Producto agregado.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("No se pudo agregar el producto: " + e.getMessage());
                    }
                    break;

                case 2:
                    service.mostrarPedido(pedidoActual);
                    break;

                case 3:
                    double total = service.calcularTotal(pedidoActual);
                    System.out.println("Total a pagar: $" + total);
                    break;

                case 4:
                    pedidoActual = cambiarORegistrarCliente(sc, pedidosPorCliente, pedidoActual);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

        sc.close();
    }

    private static int leerEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Entrada invalida. Ingrese un numero de opcion: ");
            sc.nextLine();
        }
        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }

    private static double leerDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Entrada invalida. Ingrese un precio numerico: ");
            sc.nextLine();
        }
        double numero = sc.nextDouble();
        sc.nextLine();
        return numero;
    }

    private static Pedido registrarNuevoCliente(Scanner sc, Map<String, Pedido> pedidosPorCliente) {
        while (true) {
            System.out.print("Ingrese nombre del cliente: ");
            String nombre = sc.nextLine();

            try {
                Cliente cliente = new Cliente(nombre);
                String claveCliente = normalizarClaveCliente(cliente.getNombre());

                if (pedidosPorCliente.containsKey(claveCliente)) {
                    System.out.println("Ese cliente ya existe. Se selecciona su pedido actual.");
                    return pedidosPorCliente.get(claveCliente);
                }

                Pedido pedidoNuevo = new Pedido(cliente);
                pedidosPorCliente.put(claveCliente, pedidoNuevo);
                System.out.println("Cliente registrado y seleccionado: " + cliente.getNombre());
                return pedidoNuevo;
            } catch (IllegalArgumentException e) {
                System.out.println("No se pudo registrar el cliente: " + e.getMessage());
            }
        }
    }

    private static Pedido cambiarORegistrarCliente(Scanner sc, Map<String, Pedido> pedidosPorCliente, Pedido pedidoActual) {
        System.out.println("\n--- CLIENTES ---");
        System.out.println("1. Seleccionar cliente existente");
        System.out.println("2. Registrar nuevo cliente");
        System.out.print("Opcion: ");

        int opcion = leerEntero(sc);
        if (opcion == 1) {
            return seleccionarClienteExistente(sc, pedidosPorCliente, pedidoActual);
        }
        if (opcion == 2) {
            return registrarNuevoCliente(sc, pedidosPorCliente);
        }

        System.out.println("Opcion invalida. Se mantiene el cliente actual.");
        return pedidoActual;
    }

    private static Pedido seleccionarClienteExistente(Scanner sc, Map<String, Pedido> pedidosPorCliente, Pedido pedidoActual) {
        int i = 1;
        for (Pedido pedido : pedidosPorCliente.values()) {
            System.out.println(i + ". " + pedido.getCliente().getNombre());
            i++;
        }

        System.out.print("Seleccione cliente: ");
        int seleccion = leerEntero(sc);

        if (seleccion < 1 || seleccion > pedidosPorCliente.size()) {
            System.out.println("Seleccion invalida. Se mantiene el cliente actual.");
            return pedidoActual;
        }

        int indice = 1;
        for (Pedido pedido : pedidosPorCliente.values()) {
            if (indice == seleccion) {
                System.out.println("Cliente seleccionado: " + pedido.getCliente().getNombre());
                return pedido;
            }
            indice++;
        }

        return pedidoActual;
    }

    private static String normalizarClaveCliente(String nombre) {
        return nombre.trim().toLowerCase();
    }
}