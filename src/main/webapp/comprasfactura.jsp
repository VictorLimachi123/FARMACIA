
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.emergentes.utiles.ConexionDB"%>

 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/> 
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
    
     <%
            ConexionDB con = new ConexionDB();
            Statement smt;
            ResultSet rs ;
            smt = con.conectar().createStatement();
              rs = smt.executeQuery("SELECT m.*,p.nombre as producto, c.nombres as proveedor FROM compras m LEFT JOIN productos p ON m.producto_id = p.id LEFT JOIN proveedores c ON m.proveedor_id = c.id"); 

            %>
     
        <div class="container buscar">
            <h1>Compras buscar por facturas</h1>
            <br>

            <form >
                <input type="text" name ="txtfact">
                <input type="submit" name ="buscar" >
            </form>
            <%
                 
                String nomfact =request.getParameter("txtfact");
                if(nomfact != null){
                
                smt=con.conectar().createStatement();
                rs=smt.executeQuery("SELECT m.*,p.nombre as producto, c.nombres as proveedor FROM compras m LEFT JOIN productos p ON m.producto_id = p.id LEFT JOIN proveedores c ON m.proveedor_id = c.id where factura LIKE"+"'%"+nomfact+"%'");
                }else{
                System.out.println("error");
                }
                
             %> 
            
            
            
            </p>
            
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Factura</th>
                    <th>Cantidad</th>
                    <th>Precio</th>
                    <th>Fecha</th>
                     <th>Descripcion</th>
                     <th>ID-Producto</th>
                    <th>ID-Proveedor</th> 
                    <th>Producto</th>
                    <th>Proveedor</th>
                
                    
                    
                </tr>
                <tbody id ="tbodys">
                    <%
                        while (rs.next()){
                        %>
               
                     <tr>

                      <td  class="text-center"><%=rs.getInt("id")%></td>   
                       <td  class="text-center"><%=rs.getString("factura")%></td>  
                      <td  class="text-center"><%=rs.getInt("cantidad")%></td>   
                     <td  class="text-center"><%=rs.getFloat("precio")%></td>
                     <td  class="text-center"><%=rs.getDate("fecha")%></td>
                     <td  class="text-center"><%=rs.getString("descripcion")%></td>
                     <td  class="text-center"><%=rs.getInt("producto_id")%></td>
                     <td  class="text-center"><%=rs.getInt("proveedor_id")%></td>
                     <td  class="text-center"><%=rs.getString("producto")%></td>
                     <td  class="text-center"><%=rs.getString("proveedor")%></td>
                     
                      
                </tr> 
              <% } %>
                
            </table>
        <a class="w-100 btn btn-lg btn-warning center" href="reportes.jsp" role="button"> Volver</a> 
        </div>     
              
              
              

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>
