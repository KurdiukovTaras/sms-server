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
<h1> Содержание смсок</h1>

<form method="get" action="sms">
    <button type="submit">Отобразить все смски</button>
</form>
<section>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>client</th>
            <th>id</th>
            <th>datetime</th>
            <th>message</th>
        </tr>
        </thead>
        <c:forEach items="${smsList}" var="sms">
            <jsp:useBean id="sms" scope="page" type="smsServer.model.Sms"/>
            <tr class="${sms.isNew?'new':'old'}">
            <td>${sms.client.name}</td>
            <td>${sms.id}</td>
            <td>${sms.datetime}</td>
            <td>${sms.message}</td>
            </tr>
        </c:forEach>
    </table>
</section>


<button onclick="window.history.back()">Cancel</button>
</body>
</html>
