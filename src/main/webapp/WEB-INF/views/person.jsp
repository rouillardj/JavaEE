<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="utf-8" />
  <title></title>
</head>
<body>
<c:url var="context" value="/person/" />
<form method="post" action="${context}save">
  <table>
    <thead>
      <tr>
        <th>Id</th>
        <th>Prénom</th>
        <th>Nom</th>
        <th>Email</th>
        <th>Date de naissance</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>*</td>
        <td><input name="firstName" /></td>
        <td><input name="lastName" /></td>
        <td><input name="email" /></td>
        <td><input name="birthDate" /></td>
        <td><input type="submit" /></td>
      </tr>
      <c:forEach var="person" items="${persons}">
        <tr>
          <td>${person.id}</td>
          <td>${person.firstName}</td>
          <td>${person.lastName}</td>
          <td>${person.email}</td>
          <td>${person.birthDate}</td>
          <td>modifier</td>
          <td><a href="${context}delete/${person.id}">Supprimer</a></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</form>
</body>
</html>
