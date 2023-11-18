<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="beans.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    div {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    h2 {
        margin-bottom: 20px;
    }

    a {
        color: blue;
        text-decoration: none;
    }
</style>
</head>
<body>
<%
	response.setContentType("text/html");
	Account account = (Account) session.getAttribute("account");
	String usr = account.getEmail();
	int index = usr.indexOf('@');
	String user = usr.substring(0, index);
%>
<div>
    <h2><% out.println("Wellcome " + user); %></h2>
    <a href="<%= response.encodeURL(request.getContextPath() + "/ListServlet")%>">Go to Home page</a>
</div>
</body>
</html>
