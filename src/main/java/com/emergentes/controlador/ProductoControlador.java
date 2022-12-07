
package com.emergentes.controlador;

import com.emergentes.DAO.CategoriaDAO;
import com.emergentes.DAO.CategoriaDAOimpl;
import com.emergentes.DAO.ProductoDAO;
import com.emergentes.DAO.ProductoDAOimpl;
import com.emergentes.modelo.Categoria;
import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ProductoControlador", urlPatterns = {"/ProductoControlador"})
public class ProductoControlador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           try {
    
            ProductoDAO dao = new ProductoDAOimpl();
            
            CategoriaDAO daoCategoria = new CategoriaDAOimpl(); 
            int id;
            List<Categoria> lista_categorias = null;
            Producto pro = new Producto();
            
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            
            switch (action) {
                
                
                case "add":
                    lista_categorias = daoCategoria.getAll();
                    request.setAttribute("lista_categorias",lista_categorias);
                      request.setAttribute("producto", pro);
                      request.getRequestDispatcher("frmproducto.jsp").forward(request, response);      
                    break;
                    
                case "edit":
                    id= Integer.parseInt(request.getParameter("id"));
                    pro= dao.getById(id);
                      lista_categorias = daoCategoria.getAll();
                      request.setAttribute("lista_categorias",lista_categorias);
                    request.setAttribute("producto", pro);
                    
                    request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                    break;
  
                case "delete":
                     id= Integer.parseInt(request.getParameter("id"));
                     dao.delete(id);
                     response.sendRedirect("ProductoControlador");
                    break;
                    
                case "view":
                    // obtener la lista de registros
                    List<Producto> lista = dao.getAll();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("productos.jsp").forward(request, response);                 
                    break;
                
            }
            
        } catch (Exception ex) {
            System.out.println("Error   " + ex.getMessage());
            
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        
                
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String vencimiento = request.getParameter("vencimiento");
        String stock = request.getParameter("stock");
        int categoria_id = Integer.parseInt(request.getParameter("categoria_id"));
        
        Producto pro = new Producto();
        
        pro.setId(id);
        pro.setNombre(nombre);
        pro.setDescripcion(descripcion);
        pro.setVencimiento(convierteFecha(vencimiento));
        pro.setStock(stock);
        pro.setCategoria_id(categoria_id);
        
            if (id == 0 ) {
            //nuevo
            ProductoDAO dao = new ProductoDAOimpl();
          try {
              dao.insert(pro);
              response.sendRedirect("ProductoControlador");
              
          } catch (Exception ex) {
              Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
          }
            
        }else  {
            ///editar
            
             ProductoDAO dao = new ProductoDAOimpl();
          try {
              dao.update(pro);
              response.sendRedirect("ProductoControlador");
              
          } catch (Exception ex) {
              Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
          }
            
            
        } 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

      public Date convierteFecha (String fecha){
      Date fechaBD = null;
      SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
      java.util.Date  fechaTMP;
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new Date(fechaTMP.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(VentaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
      
      return fechaBD;
      
  }
   
  }




 

