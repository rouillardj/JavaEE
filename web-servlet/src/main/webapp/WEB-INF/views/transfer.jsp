<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>Transfer</title>
</head>
<body>
<c:url var="save" value="/transfer/save" />
<form method="post" action="${save}">
<table>
    <thead>
    <tr>
        <th>Compte de base</th>
        <th>Compte Destinataire</th>
        <th>Montant</th>
    </tr>
    </thead>
    <tbody>
    <tr>
    <td><select name="debit">
        <option></option>
        <c:forEach var="account" items="${accounts}" >
            <option value="${account.id}" >${account.owner.firstName} ${account.owner.lastName}</option>
        </c:forEach>
    </select></td>
    <td><select name="credit" >
        <option></option>
        <c:forEach var="account" items="${accounts}" >
            <option value="${account.id}" >${account.owner.firstName} ${account.owner.lastName}</option>
        </c:forEach>
    </select></td>
        <td><input name="amount" /></td>
        <td><input type="submit" /></td>
    </tr>
    </tbody>
</table>
</form>
</body>
</html>
