<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page import="com.ideas2it.feastr.model.Hotel"%>
<%@page import="com.ideas2it.feastr.model.Address"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!Doctype html>

<html>
    <head>
        <title>Display Hotels</title>
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
        <center>
            <a href = "AddHotel.jsp"><button type = "button" class = "button">New Hotel</button></a>
            <div class = "background"><h1>HOTELS</h1></div>
        </center>
        <table align = "center" border =10>
        <tr>
            <th><b>First Name</b></th>
            <th><b>Last Name</b></th>
            <th><b>Phone Number</b></th>
            <th><b>Email Id</b></th>
            <th><b>Manager Name</b></th>
            <th><b>Location</b></th>
            <th><b>Address</b></th>   
            <th><b>Status</b></th>
            <th><b>Action</b></th>
        </tr>
        <%List<Hotel> hotels= new ArrayList<>();
        hotels = (ArrayList<Hotel>)request.getAttribute("hotels");
        for(Hotel hotel:hotels){%> 
        <tr>
            <td><%=hotel.getFirstName()%></td> 
            <td><%=hotel.getLastName()%></td> 
            <td><%=hotel.getPhoneNumber()%></td>
            <td><%=hotel.getMailId()%></td>
            <td><%=hotel.getManagerName()%></td>
            <td><%=hotel.getLocation()%></td> 
            <%List<Address> addresses = hotel.getAddresses();
            Address address = addresses.get(0);%>
            <td><%=address.getStreetName()%>
            <%=address.getCity()%>
            <%=address.getPincode()%></td>
            <td><%=hotel.getStatus()%></td>
            <td>
                <form method = "get" action ="fetchHotel">
                <input type="hidden" name="id" value="<%=hotel.getHotelId()%>"/>
                <button type="submit">update</button>
                </form>
                <form method = "post" action ="deleteHotel">
                <input type="hidden" name="id" value="<%=hotel.getHotelId()%>"/>
                <button type="submit">delete</button>
                </form>
                <form method = "get" action = "displayHotelMenu">
                <input type="hidden" name="hotelId" value="<%=hotel.getHotelId()%>"/>
                <button type = "submit">Menu</button>
                </form>
            </td>
        </tr>
        <%}%> 
        </table>
    </body>
</html>
