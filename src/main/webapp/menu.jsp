<%@ page import = "com.virtualpairprogrammers.domain.MenuItem" %>
<%@ page import = "java.util.List" %>

<html>
    <body>
    <c:out value="hello world"/>

        <jsp:include page="/header.jsp" />
        <%
        List<MenuItem> menuItems = (List<MenuItem>) request.getAttribute("menuItems");
            for (MenuItem item : menuItems) {
        %>
        <li><%=item%></li>
        <%
        }
        %>
        <jsp:include page="/footer.jsp" />
    </body>
</html>