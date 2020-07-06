package Modelo;

public class Articulo extends Objeto {

    private String art_codigo;
    private String art_nombre;
    private Float art_precio;

    public Articulo() {
    }

    public Articulo(String art_codigo, String art_nombre, Float art_precio) {
        this.art_codigo = art_codigo;
        this.art_nombre = art_nombre;
        this.art_precio = art_precio;
    }

    public String getArt_codigo() {
        return art_codigo;
    }

    public void setArt_codigo(String art_codigo) {
        this.art_codigo = art_codigo;
    }

    public String getArt_nombre() {
        return art_nombre;
    }

    public void setArt_nombre(String art_nombre) {
        this.art_nombre = art_nombre;
    }

    public Float getArt_precio() {
        return art_precio;
    }

    public void setArt_precio(Float art_precio) {
        this.art_precio = art_precio;
    }

}
