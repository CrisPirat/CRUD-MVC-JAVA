/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Articulo;
import ModeloDAO.ArticuloDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author crist
 */
public class ArticuloCon extends HttpServlet {

    String listar = "articulo/listar.jsp";
    String add = "articulo/add.jsp";
    String edit = "articulo/edit.jsp";
    Articulo obj = new Articulo();
    ArticuloDAO dao = new ArticuloDAO();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Articulo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Articulo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String cod = request.getParameter("txtCod");
            String nom = request.getParameter("txtNom");
            Float pre = Float.parseFloat(request.getParameter("txtPre"));
            obj.setArt_codigo(cod);
            obj.setArt_nombre(nom);
            obj.setArt_precio(pre);
            dao.add(obj);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idart", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtid"));
            String cod = request.getParameter("txtCod");
            String nom = request.getParameter("txtNom");
            Float pre = Float.parseFloat(request.getParameter("txtPre"));
            obj.setId(id);
            obj.setArt_codigo(cod);
            obj.setArt_nombre(nom);
            obj.setArt_precio(pre);
            dao.edit(obj);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            obj.setId(id);
            dao.remove(id);
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
