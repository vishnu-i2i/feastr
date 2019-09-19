<!DOCTYPE html >
<html>
    <head>
        <title>Customer Login</title>
    </head>
    <body>
        <form action = "customerLogin" method = "post">
        <table>
            <tr>
                <td>Customer Id:</td>
                <td>
                    <input type="text" name="customerId" required="true" />
                </td>
            </tr>
            <tr>
                <td>Phone Number:</td>
                <td> 
                    <input type="text" name="phoneNumber" required="true" />
                </td>
            </tr>
                <%if(request.getAttribute("incorrect") != null) {%>
                <%=request.getAttribute("incorrect")%>
                <br>
               <%}%>
            <tr>
                <td>
                    <input type="submit" value="Login"/>
                </td>
                <td>
                    <input type="Reset" value="Clear"/>
                </td>
            </tr>
        </form>
    </body>
</html>
