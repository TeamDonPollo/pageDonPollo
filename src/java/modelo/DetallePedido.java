
package modelo;

public class DetallePedido {
    private String codigo;
    private String idproduc;
    private String nomprod;
    private int cantidad;
    private double precio;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIdproduc() {
        return idproduc;
    }

    public void setIdproduc(String idproduc) {
        this.idproduc = idproduc;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNomprod() {
        return nomprod;
    }

    public void setNomprod(String nomprod) {
        this.nomprod = nomprod;
    }
    
}
