<%@page import = "java.util.ArrayList"%>
<%@page import = "java.util.List"%>

<%@page import = "com.ideas2it.feastr.model.Dish"%>
<%@page import = "com.ideas2it.feastr.model.Hotel"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!Doctype html>
<html>
    <head>
        <title>Place Order</title>
    </head>
    <body>
        <center>
        <h1>Order Food</h1>
        <%  session = request.getSession(false);
            if (null != session.getAttribute("hotels")) { %>
            <form action="displayAvailableMenu" method = "get">
                <select name="hotelId">
                <%  List <Hotel> hotels = (ArrayList<Hotel>) session.getAttribute("hotels");
                    for (Hotel hotel : hotels) { %>
                    <option value="<%=hotel.getHotelId()%>">
                        <%=hotel.getFirstName()%> <%=hotel.getLastName()%>
                    </option>
                <%}%>
                </select>
                <input type = "radio" name = "category" value = "Veg" required/> Veg &nbsp             
                <input type = "radio" name = "category" value = "Non-Veg"/> Non-Veg
                <input type = "submit" value = "Show Menu" >
            </form>
        <%}%>
        
        <% if (null != session.getAttribute("menu")) { %>
        <form action = "placeOrder" method = "post">
            <select id="dishDetails" name ="dishDetails" onclick >
            <% List<Dish> menu = (ArrayList<Dish>) session.getAttribute("menu");
               for (Dish dish : menu) { 
                    if (session.getAttribute("category").equals(dish.getCategory())
                            && (true == dish.getAvailability()) ) {%>
                    <option value = "<%=dish.getPrice()%>,<%=dish.getDishId()%>">
                        <%=dish.getName()%> <%=dish.getPrice()%>
                    </option>
                    <%}
               }%>
            </select>
            Quantity:
            <input type = "number" id = "quantity" name = "quantity" placeholder = "Enter Quantity"
            min = "1" max = "10" value = "1" required />
            <br> <p id = "totalDisplay"></p> <br>
            <input type = "button" value = "Calculate Amount" onclick = "calculateAmount()">
            <input type = "submit" value = "Place Order">
        </form>
        <%}%>
        <script>
            function calculateAmount() {
                var dish = document.getElementById("dishDetails").value.split(",");
                var x =  dish[0] * document.getElementById("quantity").value;
                document.getElementById("totalDisplay").innerHTML = "Amount = Rs. " + x;
            }
        </script>
        </center>
    </body>
</html>
