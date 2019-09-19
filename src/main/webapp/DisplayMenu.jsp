<%@page import="com.ideas2it.feastr.model.Dish"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!Doctype html>

<html>
    <head>
        <title>Display Menu</title>
        <link rel = "stylesheet" type = "text/css" href = "/css/display.css">
        <link rel = "stylesheet" type = "text/css" href = "/css/MainMenu.css">
    </head>
    <body>
      <div class="topnav">
        <form method = "get" action = "displayAllCustomers"><button type = "submit" class = "button button5">Customer</button></form>
        <form method = "get" action = "displayAllHotels"><button type = "submit" class = "button button5">Hotel</button></form>
        <form method = "get" action = "displayAllExecutives"><button type = "submit" class= "button button5">Executive</button></form>
        <form method = "get" action = "logout"><button type = "submit" class= "button button5">Logout</button></form>
      </div>
        <%String hotelId = request.getParameter("hotelId");
            session.setAttribute("hotelId",hotelId);%>
        <center>
            <a href = "AddDish.jsp"><button type = "button"  class = "button">New Dish</button></a>
            <div class = "background"><h1>MENU</h1></div>
        </center>
        <table align = "center">
        <tr>
            <th><b>Name</b></th>
            <th><b>Price</b></th>
            <th><b>Category</b></th>
            <th><b>Availability</b></th>
            <th><b>Action</b></th>
        </tr>
        <%List<Dish> dishes= new ArrayList<>();
        dishes = (ArrayList<Dish>)request.getAttribute("menu");
        for(Dish dish:dishes){%> 
        <tr>
            <td><%=dish.getName()%></td> 
            <td><%=dish.getPrice()%></td> 
            <td><%=dish.getCategory()%></td>
            <td><%=dish.getAvailability()?"Available":"Out of Stock"%></td>
            <td>
                <form method = "get" action = "fetchDish">
                <input type = "hidden" name = "id" value = "<%=dish.getDishId()%>"/>
                <button type = "submit">update</button>
                </form>

                <form method = "post" action = "deleteDish">
                <input type = "hidden" name= "hotelId" value = "<%=session.getAttribute("hotelId")%>"/>
                <input type = "hidden" name= "id" value = "<%=dish.getDishId()%>"/>
                <button type="submit">delete</button>
                </form>
            </td>
        </tr>
        <%}%> 
        </table>
    </body>
</html>
