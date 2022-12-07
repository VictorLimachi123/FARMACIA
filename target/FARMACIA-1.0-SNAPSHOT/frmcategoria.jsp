
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
                <jsp:param name="opcion" value="categorias" />

            </jsp:include>
           <div class="container">
            <h1>Formulario de categorias</h1>
            <br>
            <form action="CategoriaControlador" method="post">
                <input type="hidden" name="id" value="${categoria.id}"/>
                 
                
                 <div class="form-group">
                    <label for="" class="form-label">Nombre</label>
                    <input type="text" class="form-control" name="nombre" value="${categoria.nombre}" id="nombre" placeholder="Escribael nombre">
                </div> 
           
                <div class="form-group">
                    <label for="" class="form-label">Descripcion</label>
                    <input type="text" class="form-control" name="descripcion" value="${categoria.descripcion}" id="descripcion" placeholder="Escriba su descripcion">

                </div> 
                <div class="form-group">
                    <label for="" class="form-label">Tipo</label>
                    <input type="text" class="form-control" name="tipo" value="${categoria.tipo}" id="tipo" placeholder="Escriba el tipo">

                </div> 
                
                 <button type="submit" class="btn btn-primary">Enviar</button>
            </form>


        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>
