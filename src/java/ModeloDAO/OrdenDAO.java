/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Configuracion.Conexion;
import Intefaces.CRUD;
import Modelo.Orden;
import Modelo.Cliente;
import Modelo.Objeto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author crist
 */
public class OrdenDAO implements CRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Orden cli = new Orden();
    ClienteDAO clienteDao = new ClienteDAO();

    @Override
    public List list() {
        ArrayList<Orden> list = new ArrayList<>();
        String sql = "SELECT * FROM orden";
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Orden obj = new Orden();
                obj.setId(rs.getInt("id"));
                obj.setOrd_cliente((Cliente) clienteDao.show(rs.getInt("clienteId")));
                obj.setOrd_fecha(rs.getDate("fecha"));
                list.add(obj);
            }
        } catch (Exception e) {
            System.out.println("ERROR: OrdenDao - listar\n" + e);
        }
        return list;
    }

    @Override
    public Objeto show(int id) {
        String sql = "SELECT * FROM orden WHERE Id=" + id;
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setId(rs.getInt("id"));
                cli.setOrd_cliente((Cliente) clienteDao.show(rs.getInt("clienteId")));
                cli.setOrd_fecha(rs.getDate("fecha"));
            }
        } catch (Exception e) {
            System.out.println("ERROR: OrdenDao - show\n" + e);
        }
        return cli;
    }

    @Override
    public boolean add(Objeto obj) {
        Orden orde = (Orden) obj;
        String sql = "INSERT INTO orden(clienteId, fecha) VALUES (" + orde.getOrd_cliente().getId() + ",'" + orde.getOrd_fecha() + "')";
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR: OrdenDao - add\n" + e);
        }
        return false;
    }

    @Override
    public boolean edit(Objeto obj) {
        Orden orde = (Orden) obj;
        String sql = "UPDATE orden SET clienteId=" + orde.getOrd_cliente().getId() + ",fecha='" + orde.getOrd_fecha() + "' WHERE Id=" + orde.getId();
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR: OrdenDao - edit\n" + e);
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        String sql = "DELETE FROM orden WHERE id=" + id;
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR: OrdenDao - eliminar\n" + e);
        }
        return false;
    }

}
