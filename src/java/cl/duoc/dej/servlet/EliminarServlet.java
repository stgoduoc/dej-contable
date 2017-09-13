package cl.duoc.dej.servlet;

import cl.duoc.dej.service.EgresosDAO;
import cl.duoc.dej.service.EgresosDAOSessionImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Santiago Neira <sant.neira@profesor.duoc.cl>
 */
@WebServlet(name = "EliminarServlet", urlPatterns = {"/app/EliminarServlet"})
public class EliminarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long codigoEgreso = Long.parseLong( req.getParameter("codigo") );
        EgresosDAO egresosDAO = new EgresosDAOSessionImpl(req.getSession());
        egresosDAO.eliminarEgreso(codigoEgreso);
        resp.sendRedirect(req.getContextPath()+"/app/ListarEgresosServlet");
    }

    
    
}
