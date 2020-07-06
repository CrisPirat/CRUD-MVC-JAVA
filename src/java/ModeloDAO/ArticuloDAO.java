package ModeloDAO;

import Configuracion.Conexion;
import Intefaces.CRUD;
import Modelo.Articulo;
import Modelo.Objeto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAO implements CRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Articulo art = new Articulo();

    @Override
    public List list() {
        ArrayList<Articulo> list = new ArrayList<>();
        String sql = "SELECT * FROM articulo";
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Articulo obj = new Articulo();
                obj.setId(rs.getInt("id"));
                obj.setArt_codigo(rs.getString("codigo"));
                obj.setArt_nombre(rs.getString("nombre"));
                obj.setArt_precio(rs.getFloat("precio"));
                list.add(obj);
            }
        } catch (Exception e) {
            System.out.println("ERROR: ArticuloDao - listar\n" + e);
        }
        return list;
    }

    @Override
    public Objeto show(int id) {
        String sql = "SELECT * FROM articulo WHERE Id=" + id;
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                art.setId(rs.getInt("id"));
                art.setArt_codigo(rs.getString("codigo"));
                art.setArt_nombre(rs.getString("nombre"));
                art.setArt_precio(rs.getFloat("precio"));
            }
        } catch (Exception e) {
            System.out.println("ERROR: ArticuloDao - show\n" + e);
        }
        return art;
    }

    @Override
    public boolean add(Objeto obj) {
        Articulo arti = (Articulo) obj;
        String sql = "INSERT INTO articulo(codigo, nombre, precio) VALUES ('" + arti.getArt_codigo() + "','" + arti.getArt_nombre() + "'," + arti.getArt_precio() + ")";
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR: ArticuloDao - add\n" + e);
        }
        return false;
    }

    @Override
    public boolean edit(Objeto obj) {
        Articulo arti = (Articulo) obj;
        String sql = "UPDATE articulo SET codigo='" + arti.getArt_codigo() + "',nombre='" + arti.getArt_nombre() + "',precio=" + arti.getArt_precio() + " WHERE Id=" + arti.getId();
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR: ArticuloDao - edit\n" + e);
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        String sql = "DELETE FROM articulo WHERE id=" + id;
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR: ArticuloDao - eliminar\n" + e);
        }
        return false;
    }

}
