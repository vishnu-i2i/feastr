<%@page import="com.ideas2it.feastr.model.Executive"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!Doctype html>

<html>
    <head>
        <title>Display Executives</title>
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
            <form action = "addExecutive" method="get"><button type = "submit" class = "button">New Executive</button></form>
            <div class = "background"><h1>EXECUTIVES</h1></div>
        </center>
        <table align = "center" border =10>
        <tr>
            <th><b>First Name</b></th>
            <th><b>Last Name</b></th>
            <th><b>Phone Number</b></th>
            <th><b>Email Id</b></th>
            <th><b>DOB</b></th>       
            <th><b>Vehicle Number</b></th>
            <th><b>License Number</b></th>
            <th><b>Status</b></th>
            <th><b>Action</b></th>
        </tr>
        <%List<Executive> executives= new ArrayList<>();
        executives = (ArrayList<Executive>)request.getAttribute("executives");
        for(Executive executive:executives){%> 
        <tr>
            <td><%=executive.getFirstName()%></td> 
            <td><%=executive.getLastName()%></td> 
            <td><%=executive.getPhoneNumber()%></td>
            <td><%=executive.getMailId()%></td>
            <td><%=executive.getDob()%></td> 
            <td><%=executive.getVehicleNumber()%></td>
            <td><%=executive.getLicenseNumber()%></td>
            <td><%=executive.getStatus()%></td>
            <td>
                <form method = "get" action ="fetchExecutive">
                <input type="hidden" name="id" value="<%=executive.getExecutiveId()%>"/>
                <button type="submit">update</button>
                </form>
                <form method = "post" action ="deleteExecutive">
                <input type="hidden" name="id" value="<%=executive.getExecutiveId()%>"/>
                <button type="submit">delete</button>
                </form>
            </td>
        </tr>
        <%}%> 
        </table>
    </body>
</html>
