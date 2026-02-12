public class Main {
    public static void main(String[] args) {

        Pedido pedido = new Pedido("Pepe");

        pedido.agregarArticulo(new Articulo("Pizza", 2, 9.50));
        pedido.agregarArticulo(new Articulo("Refresco", 3, 2.00));
        pedido.agregarArticulo(new Articulo("Postre", 1, 4.50));

        pedido.mostrarResumen();

        pedido.cambiarEstado(EstadoPedido.LISTO_PARA_ENTREGAR);
        pedido.cambiarEstado(EstadoPedido.ENTREGADO);

        pedido.mostrarResumenFinal();

    }
}
