<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>
    Jeff Jiang's resume
</h1>
<%
List result= (List) request.getAttribute("contents");
Iterator it = result.iterator();
while(it.hasNext()){
out.println(it.next()+"<br>");
}
%>
</body>
</html>