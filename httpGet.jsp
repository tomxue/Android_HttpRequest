<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head> 
  <body>
    <%
    	String type = request.getParameter("par");
    	String result = new String(type.getBytes("iso-8859-1"),"gb2312");
    	out.println("<h1>parameters:"+result+"</h1>");
     %>
  </body>
</html>
