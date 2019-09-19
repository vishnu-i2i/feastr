<%@page import="com.ideas2it.feastr.model.Dish"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!Doctype html>
<html>
    <head>
        <title>Add Dish</title>
        <link rel = "stylesheet" type = "text/css" href = "/css/add.css">
    </head>
    <body>
        <h1>Update Dish</h1>
        <form action="updateDish" method = "post">
         <div class="container">
            <table cellpadding = "5">
                <input type="hidden" name="hotelId" value = "<%=session.getAttribute("hotelId")%>"/>
                <% Dish dish = (Dish) request.getSession(false).getAttribute("dish"); %>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" 
                        value="<%=dish.getName()%>" required/>
                    </td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td> <input type="text" name="price" 
                        value="<%=dish.getPrice()%>" required/>
                    </td>
                </tr>
                <tr>
                    <td>Category:</td>
                    <td>
                        <input type = "radio" name = "category" value = "Veg" required /> Veg &nbsp             
                        <input type = "radio" name = "category" value = "Non-Veg"/> Non-Veg
                    </td>
                    <td>
                </tr>
                <tr>
                    <td><button type="submit"  class="registerbtn">Update</td>
                    <td><button type="Reset" class = "button5"/>Reset</td>
                </tr>
            </table>
            </div>
        </form> 
    </body>
</html>
