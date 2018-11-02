<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table h5 {margin: 10px; font-size: 14px}
table td {text-align: left;}
</style>
</head>
<body>
<h2 align=center><%@ page import="hello.Message" %>
      <% Message C0 = new Message();
        String message = C0.sayHello();
        out.println(message);%></h2>
<h1 align=center><%@ page import="hello.GreetingMessage" %>
      <% GreetingMessage C1 = new GreetingMessage();
        String greeting = C1.printMessage();
        out.println(greeting);%></h1>
</body>
</html>
