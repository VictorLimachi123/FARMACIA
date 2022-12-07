<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/> 

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="css/signin.css" rel="stylesheet">
    </head>
    <body>
             
            <jsp:include page="META-INF/menu.jsp">
                <jsp:param name="opcion" value="compras" />

            </jsp:include>
           <div class="container">
            <h1>Formulario de compras</h1>
            <br>
            <form action="CompraControlador" method="post">
                <input type="hidden" name="id" value="${compra.id}"/>
                 
                
                 <div class="form-group">
                    <label for="" class="form-label">Factura</label>
                    <input type="text" class="form-control" name="factura" value="${compra.factura}" id="factura" placeholder="Escriba la factura">

                </div> 
                <div class="form-group">
                    <label for="" class="form-label">Cantidad</label>
                    <input type="number" class="form-control" name="cantidad" value="${compra.cantidad}" id="cantidad" placeholder="Escriba la cantidad">

                </div> 
                <div class="form-group">
                    <label for="" class="form-label">Precio</label>
                    <input type="number" class="form-control" name="precio" value="${compra.precio}" id="precio" placeholder="Escriba su precio">

                </div> 
                <div class="form-group">
                    <label for="" class="form-label">Fecha</label>
                    <input type="text" class="form-control" name="fecha" value="${compra.fecha}" id="fecha" placeholder="Escriba escriba la fecha">

                </div> 
                <div class="form-group">
                    <label for="" class="form-label">Descripcion</label>
                    <input type="text" class="form-control" name="descripcion" value="${compra.descripcion}" id="descripcion" placeholder="Escriba su descripcion">

                </div> 
                
                    
                
                
                
                
                
                
                <div class="form-group">
                    <label for="" class="form-label">Producto</label>
                     
                    <select name="producto_id" class="form-control" >
                        
                        <option value="">--------</option>
                        <c:forEach var="item" items="${lista_productos}">
                            <option value="${item.id}" <c:if test="${compra.producto_id == item.id}">
                                    selected
                            </c:if>>${item.nombre}</option>  
                            
                        </c:forEach>
                        
                    </select>

                </div>
                
                
                
                
                <div class="form-group">
                    <label for="" class="form-label">Proveedor</label>
                    
                    <select name="proveedor_id" class="form-control" >
                        
                        <option value="">--------</option>
                        <c:forEach var="item" items="${lista_proveedores}">
                            
                            <option value="${item.id}" 
                           <c:if test="${compra.proveedor_id == item.id}">
                                    selected
                            </c:if>>${item.nombres}</option>
                             
                        </c:forEach>
                    </select>
                    
                    
                </div>
              
      
                    <button type="submit" class="btn btn-primary">Enviar</button>
            </form>


        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>
