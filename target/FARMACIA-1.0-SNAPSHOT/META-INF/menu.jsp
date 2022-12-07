<%
    
    String opcion = request.getParameter("opcion");
    
 %>


</ul>
      <!-- Fixed navbar -->
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container">
        <a class="navbar-brand btn btn-info" href="#"><h4><strong>FARMACIA</strong></h4></a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
          <li class="nav-item">
            <a class="nav-link <%=(opcion.equals("clientes") ? "active" : "")%>" aria-current="page" href="ClienteControlador">CLIENTE</a>
          </li>
          <li class="nav-item">
            <a class="nav-link <%=(opcion.equals("ventas") ? "active" : "")%>" href="VentaControlador">VENTA</a>
          </li>
           <li class="nav-item">
            <a class="nav-link <%=(opcion.equals("productos") ? "active" : "")%>" href="ProductoControlador">PRODUCTO</a>
          </li>
           <li class="nav-item">
            <a class="nav-link <%=(opcion.equals("compras") ? "active" : "")%>" href="CompraControlador">COMPRA</a>
          </li>
           <li class="nav-item">
            <a class="nav-link <%=(opcion.equals("proveedores") ? "active" : "")%>" href="ProveedorControlador">EMPRESA/LABORATORIO</a>
          </li>
          <li class="nav-item">
            <a class="nav-link <%=(opcion.equals("categorias") ? "active" : "")%>" href="CategoriaControlador">CATEGORIA</a>
          </li>
          <li class="nav-item">
            <a class="nav-link <%=(opcion.equals("usuarios") ? "active" : "")%>" href="UsuarioControlador">USUARIOS</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="reportes.jsp">REPORTES</a>
          </li>
        </ul>
          <a class="btn btn-outline-danger"  href="LoginControlador?action=logout">Cerrar sesion</a>
       
      </div>
    </div>
  </nav>