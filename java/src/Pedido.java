public class Pedido {

    // ATRIBUTO ESTÁTICO
    private static int contadorPedidos = 1;

    // ATRIBUTOS
    private int id;
    private String nombreCliente;
    private Articulo[] articulos;
    private int numArticulos;
    private EstadoPedido estado;

    //  CONSTANTE
    private static final int MAX_ARTICULOS = 5;

    //  CONSTRUCTOR
    public Pedido(String nombreCliente) {
        this.id = contadorPedidos++;
        this.nombreCliente = nombreCliente;
        this.articulos = new Articulo[MAX_ARTICULOS];
        this.numArticulos = 0;
        this.estado = EstadoPedido.EN_PREPARACION;
    }

    //  MÉTODOS

    public boolean agregarArticulo(Articulo articulo) {
        if (numArticulos >= MAX_ARTICULOS) {
            System.out.println(">>>>>>>>>>  No se pueden añadir más de 5 articulos");
            return false;
        }
        articulos[numArticulos++] = articulo;
        return true;
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < numArticulos; i++) {
            total += articulos[i].getSubtotal();
        }
        return total;
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        if (!estado.puedeAvanzarA(nuevoEstado)) {
            System.out.println(">>>>>>>>>>  No se puede retroceder o saltar al estado desde " + estado + " a " + nuevoEstado);
            return;
        }
        estado = nuevoEstado;
        System.out.println("-> Estado cambiado a " + estado);
    }


    public void mostrarResumen() {
        System.out.println("===== PEDIDO #" + id + " =====");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Estado: " + estado);
        System.out.println("Articulos:");

        for (int i = 0; i < numArticulos; i++) {
            System.out.println(" - " + articulos[i]);
        }

        System.out.printf("TOTAL: %.2f €\n", calcularTotal());
        System.out.println("=====================");
    }

    public void mostrarResumenFinal() {
        System.out.println();
        System.out.println("===== PEDIDO #" + id + " =====");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Estado: " + estado);
    }
}
