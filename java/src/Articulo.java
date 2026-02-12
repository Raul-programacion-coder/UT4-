public class Articulo {

    private String nombre;
    private int cantidad;
    private double precioX1;

    public Articulo(String nombre, int cantidad, double precioX1) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioX1 = precioX1;
    }

    public double getSubtotal() {
        return cantidad * precioX1;
    }

    public String toString() {
        return nombre + " x" + cantidad + " (" + precioX1 + "€ por unidad)";
    }
}
