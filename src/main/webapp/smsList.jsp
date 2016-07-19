<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <style>
        .new {color:green}
        .old {color:red}
    </style>
    <title>Sms - server</title>
</head>
<body>

<form method="get" action="sms">
    <button type="submit">Отобразить все смски</button>
</form>
<section>
    <table border="0" cellpadding="0" cellspacing="0">

        <c:forEach items="${smsList}" var="sms">
            <jsp:useBean id="sms" scope="page" type="smsServer.model.Sms"/>
            <tr class="${sms.readed?'new':'old'}">
                <td><h2>${sms.message}</h2></td>
            </tr>
            <tr>
                <td><h6>from <a href="sms?action=showsmsbyid&id=${sms.client.id}">${sms.client.name}</a></h6></td>
                <td><h6>${sms.datetime.toLocalDateTime().toLocalTime()}</h6></td>
            </tr>
        </c:forEach>
    </table>
</section>


<%--<button onclick="window.history.back()">Cancel</button>--%>
</body>
</html>
