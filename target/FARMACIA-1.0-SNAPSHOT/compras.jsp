
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
    </head>
    <body>

        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="compras" />

        </jsp:include>


        <div class="container">
            <h1 class="text-primary"><em><u>COMPRA</u></em></h1>       

            <br>
            <p>

                <a href="CompraControlador?action=add" class="btn btn-success btn-sm"><i class="fa-sharp fa-solid fa-circle-plus"></i> Nuevo </a>

            </p>

            <table class="table table-striped">
                <tr>
                    <th class="p-3 mb-2 bg-warning text-dark">Id</th>
                    <th class="p-3 mb-2 bg-warning text-dark">Factura</th>
                    <th class="p-3 mb-2 bg-warning text-dark">Cantidad</th>
                    <th class="p-3 mb-2 bg-warning text-dark">Precio</th>
                    <th class="p-3 mb-2 bg-warning text-dark">Fecha</th>
                    <th class="p-3 mb-2 bg-warning text-dark">Descripcion</th>
                    <th class="p-3 mb-2 bg-warning text-dark">Producto</th>
                    <th class="p-3 mb-2 bg-warning text-dark">Empresa</th>
                    <th class="p-3 mb-2 bg-warning text-dark">Editar</th>
                    <th class="p-3 mb-2 bg-warning text-dark">Eliminar</th>

                </tr>
                <c:forEach var="item" items="${compras}">

                    <tr>
                        <td class="p-3 mb-2 bg-white text-dark">${item.id}</td>
                        <td class="p-3 mb-2 bg-white text-dark">${item.factura}</td>
                        <td class="p-3 mb-2 bg-white text-dark">${item.cantidad}</td>
                        <td class="p-3 mb-2 bg-white text-dark">${item.precio}</td>
                        <td class="p-3 mb-2 bg-white text-dark">${item.fecha}</td>
                        <td class="p-3 mb-2 bg-white text-dark">${item.descripcion}</td>
                        <td class="p-3 mb-2 bg-white text-dark">${item.producto}</td>
                        <td class="p-3 mb-2 bg-white text-dark">${item.proveedor}</td>

                        <td class="p-3 mb-2 bg-white text-dark"><a href="CompraControlador?action=edit&id=${item.id}" >
                                <i class="fa fa-edit"></i></a></td>
                        <td class="p-3 mb-2 bg-white text-dark"><a href="CompraControlador?action=delete&id=${item.id}" onclick="return(confirm('Estas seguro de eliminar'))" >
                                <i class=" text-danger fas fa-trash-alt"></i></a></td>


                    </tr> 
                </c:forEach>


            </table>

        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>
