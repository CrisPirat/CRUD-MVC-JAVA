package ModeloDAO;

import Configuracion.Conexion;
import Intefaces.CRUD;
import Modelo.Objeto;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements CRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cliente cli = new Cliente();

    @Override
    public List list() {
        ArrayList<Cliente> list = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente obj = new Cliente();
                obj.setId(rs.getInt("id"));
                obj.setCli_nombre(rs.getString("nombre"));
                obj.setCli_apellido(rs.getString("apellido"));
                list.add(obj);
            }
        } catch (Exception e) {
            System.out.println("ERROR: ClienteDao - listar\n" + e);
        }
        return list;
    }

    @Override
    public Objeto show(int id) {
        String sql = "SELECT * FROM cliente WHERE Id=" + id;
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setId(rs.getInt("id"));
                cli.setCli_nombre(rs.getString("nombre"));
                cli.setCli_apellido(rs.getString("apellido"));

            }
        } catch (Exception e) {
            System.out.println("ERROR: ClienteDao - show\n" + e);
        }
        return cli;
    }

    @Override
    public boolean add(Objeto obj) {
        Cliente clie = (Cliente) obj;
        String sql = "INSERT INTO cliente(apellido, nombre) VALUES ('" + clie.getCli_apellido() + "','" + clie.getCli_nombre() + "')";
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR: ClienteDao - add\n" + e);
        }
        return false;
    }

    @Override
    public boolean edit(Objeto obj) {
        Cliente clie = (Cliente) obj;
        String sql = "UPDATE cliente SET apellido='" + clie.getCli_apellido() + "',nombre='" + clie.getCli_nombre() + "' WHERE Id=" + clie.getId();
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR: ClienteDao - edit\n" + e);
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        String sql = "DELETE FROM cliente WHERE id=" + id;
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR: ClienteDao - eliminar\n" + e);
        }
        return false;
    }

}
