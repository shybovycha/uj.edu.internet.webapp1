<%@ page import="main.sources.dao.SimpleDAO" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>YAY!</title>
</head>
<body>
<h1>They're trippin' users:</h1>
<ul>
    <% for (String user : SimpleDAO.getUserNames()) { %>
        <li><%= user %></li>
    <% } %>
</ul>
</body>
</html>