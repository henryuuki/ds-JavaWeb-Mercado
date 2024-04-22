<%--
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.sendRedirect("index.htm"); %>
<img src="assets/cart-white64px.png" alt=""/>
<link href="css/footer.css" rel="stylesheet" type="text/css"/>
<script src="js/dropdown.js" type="text/javascript"></script>
<link href="css/header-cadastro.css" rel="stylesheet" type="text/css"/>