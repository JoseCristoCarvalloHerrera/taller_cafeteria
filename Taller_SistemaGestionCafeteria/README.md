# Sistema de Gestion de Cafeteria

## 1) Analisis del problema
El problema consiste en modelar un sistema simple para registrar pedidos en una cafeteria.
Se necesita:
- Registrar un cliente.
- Registrar multiples clientes y cambiar el cliente activo.
- Agregar productos (nombre y precio) a un pedido.
- Calcular el total del pedido.
- Mostrar el detalle del pedido de forma clara.

La solucion usa Programacion Orientada a Objetos separando datos del dominio (Model) y logica de negocio (Service).

## 2) Contexto y elementos clave
- Contexto: atencion en cafeteria con toma de pedidos por cliente.
- Actor principal: operador que carga datos por consola.
- Entidades clave: cliente, producto, pedido.
- Reglas del sistema:
  - El cliente debe tener nombre valido.
  - Un producto no puede tener nombre vacio ni precio negativo.
  - Un pedido siempre pertenece a un cliente.

## 3) Clases relevantes

### Clase `Cliente` (`src/main/java/Model/Cliente.java`)
Atributos:
- `nombre: String`

Metodos:
- `Cliente(String nombre)`
- `getNombre()`
- `setNombre(String nombre)`

### Clase `Producto` (`src/main/java/Model/Producto.java`)
Atributos:
- `nombre: String`
- `precio: double`

Metodos:
- `Producto(String nombre, double precio)`
- `getNombre()`
- `getPrecio()`

### Clase `Pedido` (`src/main/java/Model/Pedido.java`)
Atributos:
- `cliente: Cliente`
- `productos: List<Producto>`

Metodos:
- `Pedido(Cliente cliente)`
- `getCliente()`
- `getProductos()`
- `agregarProducto(Producto producto)`

### Clase `PedidoService` (`src/main/java/Service/PedidoService.java`)
Atributos:
- No tiene estado interno.

Metodos:
- `calcularTotal(Pedido pedido)`
- `mostrarPedido(Pedido pedido)`
- `generarDetallePedido(Pedido pedido)`

## 4) Relacion entre clases
- `Pedido` se asocia a un `Cliente`.
- `Pedido` contiene multiples `Producto`.
- `PedidoService` utiliza `Pedido` y `Producto` para calcular e informar.

## 5) Documentacion del diagrama (UML textual)

```text
Cliente
- nombre: String
+ Cliente(nombre: String)
+ getNombre(): String
+ setNombre(nombre: String): void

Producto
- nombre: String
- precio: double
+ Producto(nombre: String, precio: double)
+ getNombre(): String
+ getPrecio(): double

Pedido
- cliente: Cliente
- productos: List<Producto>
+ Pedido(cliente: Cliente)
+ getCliente(): Cliente
+ getProductos(): List<Producto>
+ agregarProducto(producto: Producto): void

PedidoService
+ calcularTotal(pedido: Pedido): double
+ mostrarPedido(pedido: Pedido): void
+ generarDetallePedido(pedido: Pedido): String
```

## 6) Estructura del proyecto
- `src/main/java/Model`: clases del dominio.
- `src/main/java/Service`: logica del negocio.
- `src/main/java/Main.java`: menu por consola.
- `src/test/java/Service/PedidoServiceTest.java`: prueba simple ejecutable.

Menu principal actual:
- `1` Agregar producto al cliente activo.
- `2` Mostrar pedido del cliente activo.
- `3` Calcular total del cliente activo.
- `4` Cambiar o registrar cliente.
- `0` Salir.

## 7) Ejecucion y validacion
Con Java:

```bash
javac -d out src/main/java/Main.java src/main/java/Model/*.java src/main/java/Service/*.java
java -cp out Main
```

Prueba simple:

```bash
javac -d out src/main/java/Model/*.java src/main/java/Service/*.java src/test/java/Service/PedidoServiceTest.java
java -cp out Service.PedidoServiceTest
```

Nota: el `pom.xml` esta listo para compilar con Maven cuando `mvn` este instalado en el entorno.

