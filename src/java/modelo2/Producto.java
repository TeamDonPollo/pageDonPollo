package modelo2;

import java.io.InputStream;

public class Producto {

    private String idprod;
    private String nom;
    private String descrip;
    private double precio;
    private int stock;
    private String codtip;
    private int dscto;
    private InputStream foto;

    public Producto() {
    }

    public Producto(String idprod, String nom, String descrip, double precio, int stock, String codtip, int dscto, InputStream foto) {
        this.idprod = idprod;
        this.nom = nom;
        this.descrip = descrip;
        this.precio = precio;
        this.stock = stock;
        this.codtip = codtip;
        this.dscto = dscto;
        this.foto = foto;
    }

    public String getIdprod() {
        return idprod;
    }

    public void setIdprod(String idprod) {
        this.idprod = idprod;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCodtip() {
        return codtip;
    }

    public void setCodtip(String codtip) {
        this.codtip = codtip;
    }

    public int getDscto() {
        return dscto;
    }

    public void setDscto(int dscto) {
        this.dscto = dscto;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

}
