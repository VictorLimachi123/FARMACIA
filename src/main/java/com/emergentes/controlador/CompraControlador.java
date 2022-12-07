
package com.emergentes.controlador;


import com.emergentes.DAO.CompraDAO;
import com.emergentes.DAO.CompraDAOimpl;
import com.emergentes.DAO.ProductoDAO;
import com.emergentes.DAO.ProductoDAOimpl;
import com.emergentes.DAO.ProveedorDAO;
import com.emergentes.DAO.ProveedorDAOimpl;
import com.emergentes.modelo.Compra;
import com.emergentes.modelo.Producto;
import com.emergentes.modelo.Proveedor;
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

@WebServlet(name = "CompraControlador", urlPatterns = {"/CompraControlador"})
public class CompraControlador extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        
            try {
            
           
            CompraDAO dao = new CompraDAOimpl();
            ProductoDAO daoProducto = new ProductoDAOimpl();
            ProveedorDAO daoProveedor = new ProveedorDAOimpl();
            int id;
            
            List<Producto> lista_productos = null;
            List<Proveedor> lista_proveedores = null;
            
            //Venta  venta = new Venta();
            Compra compra = new Compra();
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            
            switch (action) {
                case "add":
                 lista_productos = daoProducto.getAll();
                  lista_proveedores = daoProveedor.getAll();
                  request.setAttribute("lista_productos",lista_productos);
                   request.setAttribute("lista_proveedores", lista_proveedores);
                     
                      request.setAttribute("compra",compra);
                      request.getRequestDispatcher("frmcompra.jsp").forward(request, response);      
                    break;
                    
                case "edit":
                    id= Integer.parseInt(request.getParameter("id"));
                    compra = dao.getById(id);
                     lista_productos = daoProducto.getAll();
                    lista_proveedores = daoProveedor.getAll();
                    request.setAttribute("lista_productos",lista_productos);
                    request.setAttribute("lista_proveedores", lista_proveedores);
                    
                    request.setAttribute("compra",compra);
                    request.getRequestDispatcher("frmcompra.jsp").forward(request, response);
                    break;
                    
                case "delete":
                     id= Integer.parseInt(request.getParameter("id"));
                     dao.delete(id);
                     response.sendRedirect("CompraControlador");
                    break;
                    
                case "view":
                    // obtener la lista de registros
                    List<Compra> lista = dao.getAll();
                    request.setAttribute("compras",lista);
                    request.getRequestDispatcher("compras.jsp").forward(request, response);                 
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
      String  factura = request.getParameter("factura");
      int cantidad = Integer.parseInt(request.getParameter("cantidad"));
      float precio = Float.parseFloat(request.getParameter("precio"));
       String fecha = request.getParameter("fecha");
       String  descripcion = request.getParameter("descripcion");
      
       int producto_id = Integer.parseInt(request.getParameter("producto_id")); 
      int proveedor_id = Integer.parseInt(request.getParameter("proveedor_id"));
    
 
   Compra compra = new Compra();
      
    compra.setId(id);
    compra.setFactura(factura);
    compra.setCantidad(cantidad);
    compra.setPrecio(precio);
    compra.setFecha(convierteFecha(fecha));
    compra.setDescripcion(descripcion);
     
    compra.setProducto_id(producto_id);
    compra.setProveedor_id(proveedor_id);
  
        if (id == 0 ) {
            //nuevo
            CompraDAO dao = new CompraDAOimpl();
          try {
              dao.insert(compra);
              response.sendRedirect("CompraControlador");
              
          } catch (Exception ex) {
              Logger.getLogger(CompraControlador.class.getName()).log(Level.SEVERE, null, ex);
          }
            
        }else  {
            ///editar
            
             CompraDAO dao = new CompraDAOimpl();
          try {
              dao.update(compra);
              response.sendRedirect("CompraControlador");
              
          } catch (Exception ex) {
              Logger.getLogger(CompraControlador.class.getName()).log(Level.SEVERE, null, ex);
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
