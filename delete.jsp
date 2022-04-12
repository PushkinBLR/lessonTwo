<%@ page import="dao.UserDAOImpl" %>
<jsp:useBean id="user" class="entity.User"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>

<%
    UserDAOImpl.delete(user);
    response.sendRedirect("list.jsp");
%>