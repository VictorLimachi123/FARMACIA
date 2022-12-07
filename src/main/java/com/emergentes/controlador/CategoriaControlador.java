
package com.emergentes.controlador;

import com.emergentes.DAO.CategoriaDAO;
import com.emergentes.DAO.CategoriaDAOimpl;
import com.emergentes.DAO.ProductoDAO;
import com.emergentes.DAO.ProductoDAOimpl;
import com.emergentes.modelo.Categoria;
import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CategoriaControlador", urlPatterns = {"/CategoriaControlador"})
public class CategoriaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
            try {

            CategoriaDAO dao = new CategoriaDAOimpl();
                
            int id;
 
            Categoria categoria = new Categoria();
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            
            switch (action) {
                case "add":       
                      request.setAttribute("categoria",categoria);
                      request.getRequestDispatcher("frmcategoria.jsp").forward(request, response);      
                    break;
                    
                case "edit":
                    id= Integer.parseInt(request.getParameter("id"));
                    categoria = dao.getById(id);
                    request.setAttribute("categoria",categoria);
                    request.getRequestDispatcher("frmcategoria.jsp").forward(request, response);
                    break;
                    
                case "delete":
                     id= Integer.parseInt(request.getParameter("id"));
                     dao.delete(id);
                     response.sendRedirect("CategoriaControlador");
                    break;
                    
                case "view":
                    // obtener la lista de registros
                    List<Categoria> lista = dao.getAll();
                    request.setAttribute("categorias",lista);
                    request.getRequestDispatcher("categorias.jsp").forward(request, response);                 
                    break; 
            }
            
        } catch (Exception ex) {
            System.out.println("Error fatal" + ex.getMessage());
            
        }    
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String tipo = request.getParameter("tipo");
       

        Categoria categoria = new Categoria();

        categoria.setId(id);
        categoria.setNombre(nombre);
        categoria.setDescripcion(descripcion);
        categoria.setTipo(tipo);
 
        if (id == 0) {
            //nuevo
            CategoriaDAO dao = new CategoriaDAOimpl();
            try {
                dao.insert(categoria);
                response.sendRedirect("CategoriaControlador");

            } catch (Exception ex) {
                Logger.getLogger(CompraControlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            ///editar

            CategoriaDAO dao = new CategoriaDAOimpl();
            try {
                dao.update(categoria);
                response.sendRedirect("CategoriaControlador");

            } catch (Exception ex) {
                Logger.getLogger(CompraControlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
