<%-- 
    Document   : menu
    Created on : Sep 1, 2017, 2:46:56 PM
    Author     : Santiago Neira <sant.neira@profesor.duoc.cl>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="ruta" value="${pageContext.request.contextPath}"  />

<ul>
    <li>
        <a href="${ruta}/app/ListarEgresosServlet">Lista de Egresos</a>
    </li>
    <li>
        <a href="${ruta}/app/crear-egreso.jsp">Crear Egreso</a>
    </li>
</ul>