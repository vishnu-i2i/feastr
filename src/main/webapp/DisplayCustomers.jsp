<%@page import="com.ideas2it.feastr.model.Customer"%>
<%@page import="com.ideas2it.feastr.model.Address"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!Doctype html>

<html>
    <head>
        <title>Display Customers</title>
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
            <a href = "AddCustomer.jsp"><button type = "button" class = "button">New Customer</button></a>
            <div class = "background"><h1>CUSTOMERS</h1></div>
        </center>
        <table align = "center" border =10>
        <tr>
            <th><b>First Name</b></th>
            <th><b>Last Name</b></th>
            <th><b>Phone Number</b></th>
            <th><b>Email Id</b></th>
            <th><b>DOB</b></th>       
            <th><b>Present Address</b></th>
            <th><b>Permanent Address</b></th>
            <th><b>Status</b></th>
            <th><b>Action</b></th>
            </tr>
        <%List<Customer> customers= new ArrayList<>();
        customers = (ArrayList<Customer>)request.getAttribute("customers");
        for(Customer customer:customers){%> 
        <tr>
            <td><%=customer.getFirstName()%></td> 
            <td><%=customer.getLastName()%></td> 
            <td><%=customer.getPhoneNumber()%></td>
            <td><%=customer.getMailId()%></td>
            <td><%=customer.getDob()%></td> 
            <%List<Address> addresses = customer.getAddresses();
            Address address = addresses.get(0);%>
            <td><%=address.getStreetName()%>
            <%=address.getCity()%>
            <%=address.getPincode()%></td>
            <% address = addresses.get(1);%>
            <td><%=address.getStreetName()%>
            <%=address.getCity()%>
            <%=address.getPincode()%></td>
            <td><%=customer.getStatus()%></td>
            <td>
                <form method = "get" action ="fetchCustomer">
                <input type="hidden" name="id" value="<%=customer.getCustomerId()%>"/>
                <button type="submit">update</button>
                </form>
                <form method = "post" action ="deleteCustomer">
                <input type="hidden" name="id" value="<%=customer.getCustomerId()%>"/>
                <button type="submit">delete</button>
                </form>
            </td>
        </tr>
        <%}%> 
        </table>
    </body>
</html>
