<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ideas2it.feastr.model.Address"%>
<%@page import="com.ideas2it.feastr.model.Hotel"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!Doctype html>
<html>
    <head>
        <title>Update Hotel</title>
        <link rel = "stylesheet" type = "text/css" href = "/css/add.css">
    </head>
    <body>
        <h1>Update Hotel</h1>
        <form action="updateHotel" method = "post">
         <div class="container">
            <table cellpadding = "5">
                <% Hotel hotel = (Hotel) request.getSession(false).getAttribute("hotel"); %>
                <tr>
                    <td>First name:</td>
                    <td><input type="text" name="firstName" 
                        value="<%=hotel.getFirstName()%>" required = "true"/>
                    </td>
                </tr>
                <tr>
                    <td>Last name:</td>
                    <td> <input type="text" name="lastName" 
                        value="<%=hotel.getLastName()%>" required = "true"/>
                    </td>
                </tr>
                <tr>
                    <td>Mail Id:</td>
                    <td> <input type="text" name="mailId" 
                        value="<%=hotel.getMailId()%>" required = "true"/>
                    </td>
                </tr>
                <tr>
                    <td>Phone Number:</td>
                    <td> <input type="text" name="phoneNumber" 
                        value="<%=hotel.getPhoneNumber()%>" required = "true"/>
                    </td>
                </tr>
                <tr>
                    <td>Manager Name:</td>
                    <td> <input type="text" name="managerName" required = "true"
                        value="<%=hotel.getManagerName()%>"/></td>
                </tr>
                <tr>
                    <td>Location:</td>
                    <td> <input type="text" name="location" required = "true"
                        value="<%=hotel.getLocation()%>"/></td>
                </tr>
                <% List<Address> addresses = hotel.getAddresses();
                   Address address = addresses.get(0);%>
                <tr>
                    <td>Address</td>
                </tr>
                <tr>
                    <td>Street Name:</td>
                    <td> 
                        <input type = "text" name = "street" required
                        placeholder = "Enter Street Name" maxlength = "30"
                        value = "<%=address.getStreetName()%>" />
                    </td>
                </tr>
                <tr>
                    <td>City:</td>
                    <td> 
                        <input type = "text" name = "city" required
                        placeholder = "Enter City Name" maxlength = "15"
                        value = "<%=address.getCity()%>" />
                    </td>
                </tr>
                <tr>
                    <td>Pincode:</td>
                    <td> 
                        <input type = "text" name = "pincode" maxlength = "6" 
                        placeholder = "Enter Pincode" pattern = "^[0-9]{6}$" 
                        required value = "<%=address.getPincode()%>"/>
                    </td>
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
