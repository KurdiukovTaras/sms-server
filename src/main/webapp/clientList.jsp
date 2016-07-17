
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Client List</title>
</head>
<body>
<h2> Client List</h2>
<form method="get" action="client">
    <button type="submit">Отобразить клиентов</button>
</form>
    Клиенты:
    <p>
        <section>
            <table border="1" cellpadding="8" cellspacing="0">
                <thead>
                <tr>
                    <th>client</th>
                    <th>id</th>
                </tr>
                </thead>
                <c:forEach items="${clientList}" var="client">
                    <jsp:useBean id="client" scope="page" type="smsServer.model.Client"/>
                    <tr>
                        <td><a href="sms?action=showsms&id=${client.id}" target="smsName">${client.name}</a></td>
                        <td>${client.phoneNumber}</td>
                    </tr>
                </c:forEach>
            </table>
        </section>

<button onclick="window.history.back()">Cancel</button>
</body>
</html>
