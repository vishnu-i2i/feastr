<!Doctype html>
<html>
    <head>
        <title>Add Dish</title>
        <link rel = "stylesheet" type = "text/css" href = "/css/add.css">
    </head>
    <body>
        <h1>Add new Dish</h1>
        <form action="registerDish" method = "post">
        <div class="container">
            <table cellpadding = "5">
                <input type="hidden" name="hotelId" value = "<%=session.getAttribute("hotelId")%>"/>
                <tr>
                    <td>Name:</td>
                    <td>
                        <input type = "text" name = "name" maxlength = "30"
                        placeholder = "Enter Dish Name" required/>
                    </td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td>
                        <input type = "number" name = "price" step = "0.01" min = "0.01"
                        placeholder = "Enter Price" min = "0.01" required />
                    </td>
                </tr>
                <tr>
                    <td>Category:</td>
                    <td>
                        <input type = "radio" name = "category" value = "Veg" required/> Veg &nbsp             
                        <input type = "radio" name = "category" value = "Non-Veg"/> Non-Veg
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type = "submit" class="registerbtn" value="Submit">
                    </td>
                    <td>
                        <input type = "Reset" value = "Reset" class = "button5">
                    </td>
                </tr>
                </div>
            </table>
        </form>
    </body>
</html>
