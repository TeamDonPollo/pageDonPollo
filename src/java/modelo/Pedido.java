package modelo;

public class Pedido {

    private String idPedido; //idp
    private String codCliente; //codc
    private String fecha;
    private String distrito;
    private double total;
    private String formp;
    private String ref;
    private String cel;
    private String recp;
    private String estado;

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFormp() {
        return formp;
    }

    public void setFormp(String formp) {
        this.formp = formp;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getRecp() {
        return recp;
    }

    public void setRecp(String recp) {
        this.recp = recp;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
