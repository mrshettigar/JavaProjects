<%-- 
    Document   : listcustomer
    Created on : Apr 12, 2018, 12:31:41 PM
    Author     : Mangesh
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="shettigardblib.Reservation, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel ="stylesheet" type="text/css" href="shettigar.css"/>
        <title>Customer List</title>
    </head>
    <body>
        <%
            Reservation db = new Reservation("ism6236", "ism6236bo");
            List<String> cust = db.getCustomerList();

        %>
         <form ACTION="Reservation" METHOD="POST">
            <fieldset id="info">
                <legend > Customer List: </legend>
               

                <select id = "reservation" name ="customerlist" size="10"> 
                    <%  for (String cid : cust) {
                            String line = String.format("<option>%s </option>", cid);
                            out.println(line);
                        }
                    %>

                </select>
                <br>            
              
            </fieldset>
        </form>
                    
                       <div>
            <a href="reservations.html"> Reservations </a> <br>
            <a href="book.html"> Book </a> <br>
            <a href="index.html"> Main Menu </a> <br>
        </div>

    </body>
</html>
