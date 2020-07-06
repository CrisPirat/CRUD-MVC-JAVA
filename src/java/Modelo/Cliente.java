package Modelo;

public class Cliente extends Objeto {

    private String cli_nombre;
    private String cli_apellido;

    public Cliente() {
    }

    public Cliente(String cli_nombre, String cli_apellido) {
        this.cli_nombre = cli_nombre;
        this.cli_apellido = cli_apellido;
    }

    public String getCli_nombre() {
        return cli_nombre;
    }

    public void setCli_nombre(String cli_nombre) {
        this.cli_nombre = cli_nombre;
    }

    public String getCli_apellido() {
        return cli_apellido;
    }

    public void setCli_apellido(String cli_apellido) {
        this.cli_apellido = cli_apellido;
    }

}
