
package com.emergentes.controlador;

import com.emergentes.DAO.ClienteDAO;
import com.emergentes.DAO.ClienteDAOimpl;
import com.emergentes.modelo.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ClienteControlador", urlPatterns = {"/ClienteControlador"})
public class ClienteControlador extends HttpServlet {

 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           
        try {
            
            
            int id;
            ClienteDAO dao = new ClienteDAOimpl();
            Cliente cli = new Cliente();
            
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            
            switch (action) {
                case "add":
                      request.setAttribute("cliente", cli);
                      request.getRequestDispatcher("frmcliente.jsp").forward(request, response);      
                    break;
                    
                case "edit":
                    id= Integer.parseInt(request.getParameter("id"));
                    cli= dao.getById(id);
                    request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("frmcliente.jsp").forward(request, response);
                    break;
                    
                case "delete":
                     id= Integer.parseInt(request.getParameter("id"));
                     dao.delete(id);
                     response.sendRedirect("ClienteControlador");
                    break;
                    
                case "view":
                    // obtener la lista de registros
                    List<Cliente> lista = dao.getAll();
                    request.setAttribute("clientes", lista);
                    request.getRequestDispatcher("clientes.jsp").forward(request, response);                 
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
        String nombres = request.getParameter("nombres");
        String correo = request.getParameter("correo");
        String direccion = request.getParameter("direccion");
        int celular = Integer.parseInt(request.getParameter("celular"));
    
        Cliente cli = new Cliente();
  
        cli.setId(id);
        cli.setNombres(nombres);
        cli.setCorreo(correo);
        cli.setDireccion(direccion);
        cli.setCelular(celular);
      
        
        ClienteDAO dao = new ClienteDAOimpl();
        if (id==0) {
            //nuevo registro
                try{
                  dao.insert(cli);   
                }catch (Exception ex){
                    System.out.println("Error  al insertar" + ex.getMessage());
                }

            
            
        }else{
            //edicion de registro
           try{
               
             dao.update(cli);  
           }catch (Exception ex){
                    System.out.println("Error  al editar" +ex.getMessage());
             }
            
        }
        
        response.sendRedirect("ClienteControlador");
        
    }

}
