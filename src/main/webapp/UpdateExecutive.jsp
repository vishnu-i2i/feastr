<%@page import="com.ideas2it.feastr.model.Executive"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!Doctype html>
<html>
    <head>
        <title>Add Executive</title>
        <link rel = "stylesheet" type = "text/css" href = "/css/add.css">
    </head>
    <body>
        <h1>Update Executive</h1>
        <form:form action="updateExecutive" method = "post" modelAttribute = "executive">
         <div class="container">
            <% Executive executive = (Executive) request.getAttribute("executive"); %>
            <table cellpadding = "5">
                <tr>
                    <td><form:label path = "firstName">First name</form:label></td>
                    <td><form:input type="text" path="firstName" 
                        value="<%=executive.getFirstName()%>" required = "true"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path = "lastName">Last name</form:label></td>
                    <td> <form:input type="text" path="lastName" 
                        value="<%=executive.getLastName()%>" required = "true"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path = "mailId">Mail Id</form:label></td>
                    <td> <form:input type="text" path="mailId" 
                        value="<%=executive.getMailId()%>" required = "true"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path = "phoneNumber">Phone Number</form:label></td>
                    <td> <form:input type="text" path="phoneNumber" 
                        value="<%=executive.getPhoneNumber()%>" required = "true"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path = "dob">Date Of Birth</form:label></td>
                    <td> <form:input type="date" path="dob" required = "true"
                        value="<%=executive.getDob()%>"/></td>
                </tr>
                <tr>
                    <td><form:label path = "vehicleNumber">Vehicle Number</form:label></td>
                    <td> <form:input type="text" path="vehicleNumber" 
                        value="<%=executive.getVehicleNumber()%>" required = "true"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path = "licenseNumber">License Number</form:label></td>
                    <td> <form:input type="text" path="licenseNumber" 
                        value="<%=executive.getLicenseNumber()%>" required = "true"/>
                    </td>
                </tr>
                <tr>
                    <td> <form:input type="hidden" path="executiveId" 
                        value="<%=executive.getExecutiveId()%>" />
                    </td>
                </tr>
               
                <tr>
                    <td><button type="submit"  class="registerbtn">Update</td>
                    <td><button type="Reset" class = "button5"/>Reset</td>
                </tr>
            </table>
            </div>
        </form:form> 
    </body>
</html>
