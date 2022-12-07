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
                <jsp:param name="opcion" value="productos" />

            </jsp:include>
        <div class="container">
            <h1>Formulario de productos</h1>
            <br>
            <form action="ProductoControlador" method="post">
                <input type="hidden" name="id" value="${producto.id}"/>
                <div class="form-group">
                    <label for="" class="form-label">Nombre</label>
                    <input type="text" class="form-control" name="nombre" value="${producto.nombre}" id="nombre" placeholder="Escriba el nombre">

                </div>
                <div class="form-group">
                    <label for="" class="form-label">Descripcion</label>
                    <input type="text" class="form-control" name="descripcion" value=" ${producto.descripcion}" id="descripcion" placeholder="Escriba su descripcion">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Vencimiento</label>
                    <input type="text" class="form-control" name="vencimiento" value=" ${producto.vencimiento}" id="vencimiento" placeholder="Escriba su vencimiento">
                </div>
                 <div class="form-group">
                    <label for="" class="form-label">Stock</label>
                    <input type="text" class="form-control" name="stock" value=" ${producto.stock}" id="stock" placeholder="Escriba el stock">
                </div>
                 <div class="form-group">
                    <label for="" class="form-label">Categoria</label>
                     
                    <select name="categoria_id" class="form-control" >
                        
                        <option value="">----seleccione----</option>
                        <c:forEach var="item" items="${lista_categorias}">
                            <option value="${item.id}" <c:if test="${producto.categoria_id == item.id}">
                                    selected
                            </c:if>>${item.nombre}</option>  
                            
                        </c:forEach>
                        
                    </select>

                </div>
               
                

                    <button type="submit" class="btn btn-primary">Enviar</button>
            </form>


        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>
