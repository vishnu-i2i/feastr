
<!Doctype html>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>Add Hotel</title>
        <link rel = "stylesheet" type = "text/css" href = "/css/add.css">
    </head>
    </head>
    <body>
        <h1>Add new Hotel</h1>
        <form action="registerHotel" method = "post">
        <div class="container">
            <table cellpadding = "5">
                <tr>
                    <td>First name:</td>
                    <td>
                        <input type = "text" name = "firstName" maxlength = "20"
                        placeholder = "Enter First Name" required/>
                    </td>
                </tr>
                <tr>
                    <td>Last name:</td>
                    <td>
                        <input type = "text" name = "lastName" maxlength = "20"
                        placeholder = "Enter Last Name" required />
                    </td>
                </tr>
                <tr>
                    <td>Mail Id:</td>
                    <td>
                        <input type = "email" name = "mailId" maxlength = "30"
                        placeholder= "Enter Mail Id" required />
                    </td>
                </tr>
                <tr>
                    <td>Phone Number:</td>
                    <td>
                        <input type = "text" name = "phoneNumber"
                        maxlength = "10" placeholder="Eg:8098836199" required
                        pattern = "^[7-9][0-9]{9}$" />
                    </td>
                </tr>
                <tr>
                    <td>Manager Name:</td>
                    <td>
                        <input type = "text" name = "managerName" required
                        placeholder = "Enter Manager Name" maxlength = "20"  />
                    </td>
                </tr>
                <tr>
                    <td>Location:</td>
                    <td>
                        <input type = "text" name = "location" required
                        maxlength = "20" placeholder = "Enter Branch Location" />
                    </td>
                </tr>
                <tr>
                    <td>Address</td>
                </tr>
                <tr>
                    <td>Street Name:</td>
                    <td>
                        <input type = "text" name = "street" required
                        placeholder = "Enter Street Name" maxlength = "30" />
                    </td>
                </tr>
                <tr>
                    <td>City:</td>
                    <td>
                        <input type = "text" name = "city" required
                        placeholder = "Enter City Name" maxlength = "15" />
                    </td>
                </tr>
                <tr>
                    <td>Pincode:</td>
                    <td>
                        <input type = "text" name = "pincode" maxlength = "6" required
                        placeholder = "Enter Pincode" pattern = "^[0-9]{6}$" />
                    </td>
                </tr>
                <tr>
                    <td><button type="submit" class="registerbtn">Register</td>
                    <td><button type="Reset" class = "button5"/>Reset</td>
                </tr>
            </table>
             </div>
        </form>
    </body>
</html>
