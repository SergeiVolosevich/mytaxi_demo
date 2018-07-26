<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Simple JSP App</title>
	</head>
	<body>
        <h1>Счетчик времени</h1>
   <jsp:useBean id="calendar" class="java.util.GregorianCalendar" />
        <form name="Simple" action="timeaction" method="POST">
        <input type="hidden" name ="time" value="${calendar.timeInMillis}"/>
        <input type="submit" name="button" value="Посчитать время"/>
        </form>

        <%
        int a = 2;
        int b = 3;
out.println("IP addres is " + request.getRemoteAddr());
out.println("Sum = " + (a + b));
         %>

         <jsp:include page="pages/data.jsp"/>
	</body>
</html>