<!DOCTYPE html >
<html>
    <head>
        <title> Login Form</title>
        <link rel = "stylesheet" type = "text/css" href = "/css/add.css">
        <link rel = "stylesheet" type = "text/css" href = "/css/MainMenu.css">
    </head>
    <body>
        <center><h1>Login</h1></center>
        <form action = "validateLogin" method = "post">
          <table align = "center">
            <tr><td>&nbsp </td></tr>
            <tr><td>&nbsp </td></tr>
            <tr><td>&nbsp </td></tr>
            <tr><td>&nbsp </td></tr>
            <tr>
               <td> <input type="text" name="username" required="true" placeholder = "Enter UserName"/> </td>
            </tr>
            <tr> 
              <td> <input type="password" name="password" required="true" placeholder = "Enter Password"/> </td>
            </tr>
        <center><%if(request.getAttribute("message") != null) {%>
        <%=request.getAttribute("message")%></center>
        <%}%>
            <tr>
               <td> <input type="submit" value="Login" color = "black" class = "registerbtn"/> &nbsp
            </tr>
        </form>
    </right>
    </body>
</html>
