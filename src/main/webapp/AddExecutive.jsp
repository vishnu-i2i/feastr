<!Doctype html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <title>Add Executive</title>
        <link rel = "stylesheet" type = "text/css" href = "/css/add.css">
    </head>
    <body>
        <h1>Add new Executive</h1>
        <form:form action="registerExecutive" method = "post" modelAttribute = "executive">
        <div class="container">
            <table cellpadding = "5">
                <tr>
                    <td><form:label path = "firstName">First name</form:label></td>
                    <td>
                        <form:input type = "text" path = "firstName" maxlength = "20"
                        placeholder = "Enter First Name" required = "true"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path = "lastName">Last name</form:label></td>
                    <td> 
                        <form:input type = "text" path = "lastName" maxlength = "20"
                        placeholder = "Enter Last Name" required = "true"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path = "mailId">Mail Id</form:label></td>
                    <td> 
                        <form:input type = "email" path = "mailId" maxlength = "30"
                        placeholder= "Enter Mail Id" required = "true"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path = "phoneNumber">Phone Number</form:label></td>
                    <td> 
                        <form:input type = "text" path = "phoneNumber" 
                        maxlength = "10" placeholder="Eg:8098836199" required = "true"
                        pattern = "^[7-9][0-9]{9}$" />
                    </td>
                </tr>
                <tr>
                    <td><form:label path = "dob">Date Of Birth</form:label></td>
                    <td> 
                        <form:input type = "date" path = "dob" required = "true"
                        max = "2001-01-01" min = "1900-01-01"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path = "vehicleNumber">Vehicle Number</form:label></td>
                    <td> 
                        <form:input type = "text" path = "vehicleNumber" required = "true"
                        placeholder = "Eg:TN 64 J 1215" maxlength = "13"
                        pattern = "^[A-Z]{2} [0-9]{2} [A-Z] [0-9]{4}$" />
                    </td>
                </tr>
                <tr>
                    <td><form:label path = "licenseNumber">License Number</form:label></td>
                    <td> 
                        <form:input type = "text" path = "licenseNumber" required = "true"
                        placeholder = "Eg:TN59 20160009192" maxlength = "16"
                        pattern = "^[A-Z]{2}[0-9]{2} [0-9]{11}$" />
                    </td>
                </tr>
                <tr>
                    <td><button type="submit" class="registerbtn">Register</td>
                    <td><button type="Reset" class = "button5"/>Reset</td>
                </tr>
            </table>
            </div>
        </form:form> 
    </body>
</html>
