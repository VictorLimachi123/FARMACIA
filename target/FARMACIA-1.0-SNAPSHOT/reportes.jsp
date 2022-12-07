
<%
    if (session.getAttribute("logueado") != "OK") {
        response.sendRedirect("login.jsp");

    }

%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/> 

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="css/signin.css" rel="stylesheet">

    <body>

        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="clientes" />               
        </jsp:include>


        <div class="container">
            <h1 class="text-primary"><em><u>CONSULTAS</u></em></h1>
            <br>
            <main class="container">

                    <table border="4" class="form-floating"> 
                        <tr>
                            <td></td>
                            <td><a class="w-100 btn btn-lg btn-info" href="ventasfecha.jsp" role="button">CONSULTA POR FECHA-VENTAS</a></td>
                            <td></td>
                            <td><a class="w-100 btn btn-lg btn-info" href="comprasfecha.jsp" role="button">CONSULTA POR FECHA-COMPRAS</a></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><a class="w-100 btn btn-lg btn-info" href="ventasfactura.jsp" role="button">CONSULTA POR FACTURA-VENTAS</a></td>
                            <td></td>
                            <td><a class="w-100 btn btn-lg btn-info" href="comprasfactura.jsp" role="button">CONSULTA POR FACTURA-COMPRAS</a></td>

                        </tr>
                        <tr>
                            <td></td>
                            <td><a class="w-100 btn btn-lg btn-info" href="clientesnombres.jsp" role="button">CONSULTA POR NOMBRE-CLIENTES</a></td>
                            <td></td>
                            <td><a class="w-100 btn btn-lg btn-info" href="productosnombres.jsp" role="button">CONSULTA POR NOMBRE-PRODUCTO</a></td>

                        </tr>
                        <tr>
                            <td></td>
                            <td><a class="w-100 btn btn-lg btn-info" href="categoriasnombres.jsp" role="button">CONSULTA POR NOMBRE-CATEGORIA</a></td>
                            <td></td>
                            <td><a class="w-100 btn btn-lg btn-info" href="empresasnombres.jsp" role="button">CONSULTA POR NOMBRE -EMPRESA</a></td>

                        </tr>



                    </table>


                    <br>
                    <a class=" btn btn-lg btn-warning center" href="ClienteControlador" role="button"> Volver</a>
             
            </main>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>



    </body>
</html>
