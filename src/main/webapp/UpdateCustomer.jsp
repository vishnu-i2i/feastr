<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ideas2it.feastr.model.Address"%>
<%@page import="com.ideas2it.feastr.model.Customer"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!Doctype html>
<html>
    <head>
        <title>Update Customer</title>
        <link rel = "stylesheet" type = "text/css" href = "/css/add.css">
    </head>
    <body>
        <h1>Update Customer</h1>
        <form action="updateCustomer" method = "post">
         <div class="container">
            <table cellpadding = "5">
                <% Customer customer = (Customer) request.getSession(false).getAttribute("customer"); %>
                <tr>
                    <td>First name:</td>
                    <td><input type="text" name="firstName" 
                        value="<%=customer.getFirstName()%>" required = "true"/>
                    </td>
                </tr>
                <tr>
                    <td>Last name:</td>
                    <td> <input type="text" name="lastName" 
                        value="<%=customer.getLastName()%>" required = "true"/>
                    </td>
                </tr>
                <tr>
                    <td>Mail Id:</td>
                    <td> <input type="text" name="mailId" 
                        value="<%=customer.getMailId()%>" required = "true"/>
                    </td>
                </tr>
                <tr>
                    <td>Phone Number:</td>
                    <td> <input type="text" name="phoneNumber" 
                        value="<%=customer.getPhoneNumber()%>" required = "true"/>
                    </td>
                </tr>
                <tr>
                    <td>Date Of Birth:</td>
                    <td> <input type="date" name="dob" required = "true"
                        value="<%=customer.getDob()%>"/></td>
                </tr>
                <% List<Address> addresses = customer.getAddresses();
                   Address address = addresses.get(0);%>
                <tr>
                    <td>Present Address</td>
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
                        <input type = "text" name = "pincode" maxlength = "6" required
                        placeholder = "Enter Pincode" pattern = "^[0-9]{6}$" 
                        value = "<%=address.getPincode()%>"/>
                    </td>
                </tr>
                <% address = addresses.get(1);%>
                <tr>
                    <td>Permanent Address</td>
                </tr>
                <tr>
                    <td>Street Name:</td>
                    <td> 
                        <input type = "text" name = "street1" required
                        placeholder = "Enter Street Name" maxlength = "30" 
                        value = "<%=address.getStreetName()%>" />
                    </td>
                </tr>
                <tr>
                    <td>City:</td>
                    <td> 
                        <input type = "text" name = "city1" required
                        placeholder = "Enter City Name" maxlength = "15"
                        value = "<%=address.getCity()%>" />
                    </td>
                </tr>
                <tr>
                    <td>Pincode:</td>
                    <td> 
                        <input type = "text" name = "pincode1" maxlength = "6" required
                        placeholder = "Enter Pincode" pattern = "^[0-9]{6}$"
                        value = "<%=address.getPincode()%>" />
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
