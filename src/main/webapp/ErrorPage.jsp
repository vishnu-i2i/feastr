<%@page isErrorPage = "true" %>

<html>
   <head>
      <title>Show Error Page</title>
   </head>
   
   <body>
      <h1>Oops...</h1>
      <%exception = (Exception)request.getAttribute("error");%>
      Error:<%=exception.getMessage()%>
      <br>
      <a href = "MainMenu.jsp"> <button type = "button">Back to Main Menu</button></a>

   </body>
</html>
