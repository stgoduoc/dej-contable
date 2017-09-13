package cl.duoc.dej.servlet;

import cl.duoc.dej.entity.Egreso;
import cl.duoc.dej.service.EgresosDAO;
import cl.duoc.dej.service.EgresosDAOJdbcImpl;
import cl.duoc.dej.service.EgresosDAOSessionImpl;
import cl.duoc.dej.validator.EgresoValidator;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Santiago Neira <sant.neira@profesor.duoc.cl>
 */
@WebServlet(name = "CrearEgresoServlet", urlPatterns = {"/CrearEgresoServlet"})
public class CrearEgresoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // recupero valores del formulario
        String tipoEgreso = req.getParameter("tipo_egreso");
        String proveedor = req.getParameter("proveedor");
        String rutProveedor = req.getParameter("rut_proveedor");
        String tipoProveedor = req.getParameter("tipo_proveedor");
        boolean esEmpresa = "empresa".equalsIgnoreCase(tipoProveedor) ? true : false;
        String descripcion = req.getParameter("descripcion");
        String monto = req.getParameter("monto");

        // valido el input del usuario
        EgresoValidator egresoValidator = new EgresoValidator(tipoEgreso, proveedor, rutProveedor, tipoProveedor, esEmpresa, descripcion, monto);
        boolean valid = egresoValidator.isValid();
        if (!valid) {
            req.setAttribute("mensajes", egresoValidator.getMensajes());
            req.getRequestDispatcher("/app/crear-egreso.jsp").forward(req, resp);
            return;
        }

        // creo el objeto del tipo Egreso
        Egreso egreso = new Egreso(tipoEgreso.charAt(0), proveedor, esEmpresa, descripcion, Long.parseLong(monto), rutProveedor);

        // instancio servicio DAO y guardo el egreso
        //EgresosDAO egresoDAO = new EgresosDAOSessionImpl(req.getSession());
        EgresosDAO egresoDAO = new EgresosDAOJdbcImpl();
        egresoDAO.crearEgreso(egreso);

        resp.sendRedirect(req.getContextPath() + "/app/ListarEgresosServlet");
    }

}
