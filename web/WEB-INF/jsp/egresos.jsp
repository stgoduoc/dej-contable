<%-- 
    Document   : egresos
    Created on : Sep 1, 2017, 2:27:36 PM
    Author     : Santiago Neira <sant.neira@profesor.duoc.cl>
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Egresos</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/jspf/menu.jsp" />
        <h1>Lista de Egresos</h1>

        <table border="1">
            <tr style="background: cyan;">
                <th>Código</th>
                <th>RUT</th>
                <th>Proveedor</th>
                <th>Tipo Proveedor</th>
                <th>Tipo Egreso</th>
                <th>Monto</th>
                <th>Fecha</th>
                <th>Descripción</th>
                <th>Acciones</th>
            </tr>
            <c:forEach items="${egresos}" var="e">
                <tr>
                    <td>${e.codigoEgreso}</td>
                    <td>${e.rutProveedor}</td>
                    <td>${e.proveedor}</td>
                    <td>${e.esEmpresa?"Empresa":"Persona Natural"}</td>
                    <td>
                        <c:if test="${e.tipoEgreso == 'i'}">
                            Insumo
                        </c:if>
                        <c:if test="${e.tipoEgreso == 'h'}">
                            Hardware
                        </c:if>
                        <c:if test="${e.tipoEgreso == 's'}">
                            Software
                        </c:if>
                        <c:if test="${e.tipoEgreso == 'o'}">
                            Otro
                        </c:if>
                    </td>
                    <td>
                        $<fmt:formatNumber currencyCode="CL" value="${e.monto}" />
                    </td>
                    <td>
                        <fmt:formatDate value="${e.fecha.time}" />
                    </td>
                    <td>${e.descripcion}</td>
                    <td>
                        <form method="get" action="${pageContext.request.contextPath}/app/EliminarServlet">
                            <input type="hidden" name="codigo" value="${e.codigoEgreso}" />
                            <button type="submit">Eliminar</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
