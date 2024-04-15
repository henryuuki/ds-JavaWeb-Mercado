<%--
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.sendRedirect("index.htm"); %>
<img src="assets/JBL_FLIP_ESSENTIAL_2_BACK_REFLECTIONS_36400_x3.png" alt=""/>
<img src="assets/JBL_PARTYBOX_ENCORE_ESSENTIAL_HERO_1605x1605px.png" alt=""/>
<img src="assets/JBL_XTREME_3_3_4_RIGHT_BLUE_0072_x1.png" alt=""/>
<img src="assets/JBL_PULSE_5_3_4_LEFT_34343_x2.png" alt=""/>
<a href="WEB-INF/jsp/Carrinho.jsp"></a>