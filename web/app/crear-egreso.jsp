<%-- 
    Document   : crear-egreso
    Created on : Sep 1, 2017, 2:27:49 PM
    Author     : Santiago Neira <sant.neira@profesor.duoc.cl>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Egreso</title>
    </head>
    <body>

        <jsp:include page="/WEB-INF/jspf/menu.jsp" />

        <h1>Crear Egreso</h1>

        <c:if test="${!empty mensajes}">
            <!-- mensajes de error -->
            <div class="mensaje" style="background: red; color: white; padding: 10px;margin: 10px;">
                <ul>
                    <c:forEach items="${mensajes}" var="m">
                        <li>${m}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>

        <form method="post" action="${pageContext.request.contextPath}/CrearEgresoServlet">
            Tipo de Egreso<br />
            <select name="tipo_egreso">
                <option value="i">Insumo</option>
                <option value="h">Hardware</option>
                <option value="s">Software</option>
                <option value="o">Otro</option>
            </select>

            <br /><br />

            Proveedor<br />
            <input type="text" name="proveedor" />

            <br /><br />

            RUT Proveedor<br />
            <input type="text" name="rut_proveedor" />

            <br /><br />

            Tipo de Proveedor<br />
            <input type="radio" name="tipo_proveedor" value="persona_natural" />
            Persona Natura<br />
            <input type="radio" name="tipo_proveedor" value="empresa" />
            Empresa

            <br /><br />

            Descripción (describa los productos o servicios comprados)<br />
            <textarea name="descripcion"></textarea>

            <br /><br />

            Monto<br />
            <input type="text" name="monto" />

            <br /><br />

            <button type="submit">Guardar Egreso</button>
        </form>
    </body>
</html>
