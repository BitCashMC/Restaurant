<%Double total;%>

<%{
    total = (Double) session.getAttribute("total");
%>
<html>
<body>
<h1>Thanks for your order!</h1>
<h3>your total: <%=total%></h3>
<%}%>
</body>
</html>