<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FARMACIA</title>
        
        <<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/> 

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="css/signin.css" rel="stylesheet">
    </head>
    <body>

        <main class="form-signin w-100 m-auto">
            <form  action="LoginControlador" method="post" >
                <img class="mb-4" src="https://farmaciacentralplus.com/logo@2x.png" alt="" width="300" height="200">
                <center><h1 class="text-primary"><u>" FARMACIA "</u></h1></center>

                <div class="form-floating">
                    <input type="email"  name="correo"class="form-control" id="floatingInput" placeholder="nombre@mail.com">
                    <label for="floatingInput">Correo electronico</label>
                </div>
                <div class="form-floating">
                    <input type="password"name="password" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Password</label>
                </div>
           
                <%--<div class="checkbox mb-3">
                    <label>
                       <input type="checkbox" value="remember-me"> Recuerdame
                    </label>
                </div> --%>
                <button class="w-100 btn btn-lg btn-warning" type="submit">Ingresar</button>
                <p class="mt-5 mb-3 text-muted">&copy; farmacia-2022</p>
            </form>
        </main>
        
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>
