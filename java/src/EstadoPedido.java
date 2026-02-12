public enum EstadoPedido {
    EN_PREPARACION,
    LISTO_PARA_ENTREGAR,
    ENTREGADO;


    public boolean puedeAvanzarA(EstadoPedido nuevoEstado) {
        switch (this) {
            case EN_PREPARACION:
                return nuevoEstado == LISTO_PARA_ENTREGAR || nuevoEstado == ENTREGADO;
            case LISTO_PARA_ENTREGAR:
                return nuevoEstado == ENTREGADO;
            case ENTREGADO:
                return false;
            default:
                return false;
        }
    }
}
