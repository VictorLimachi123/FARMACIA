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
                <jsp:param name="opcion" value="usuarios" />

            </jsp:include>
       <div class="container">
            <h1>Formulario de Usuarios</h1>     
            
            <br>
            <form action="UsuarioControlador" method="post">
                <input type="hidden" name="id" value="${usuario.id}"/>
                <div class="form-group">
                    <label for="" class="form-label">Nombres</label>
                    <input type="text" class="form-control" name="nombres" value="${usuario.nombres}"  id="nombres"   placeholder="Escriba su nombres">

                </div>
                <div class="form-group">
                    <label for="" class="form-label">Apellidos</label>
                    <input type="text" class="form-control" name="apellidos" value="${usuario.apellidos}" id="apellidos"  placeholder="Escriba su apellidos">

                </div>
                <div class="form-group">
                    <label for="" class="form-label">Correo</label>
                    <input type="email" class="form-control" name="correo" value=" ${usuario.correo}" id="correo" placeholder="Escriba su correo electronico">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Password</label>
                    <input type="text" class="form-control" name="password"  value="${usuario.password}" id="password" placeholder="Escriba su password">
                </div>
               
                

                    <button type="submit" class="btn btn-primary">Enviar</button>
            </form>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
 
    </body>
</html>
