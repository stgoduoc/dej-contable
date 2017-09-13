package cl.duoc.dej.servlet;

import cl.duoc.dej.service.EgresosDAO;
import cl.duoc.dej.service.EgresosDAOJdbcImpl;
import cl.duoc.dej.service.EgresosDAOSessionImpl;
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
@WebServlet(name = "ListarEgresosServlet", urlPatterns = {"/app/ListarEgresosServlet"})
public class ListarEgresosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //EgresosDAO egresosDAO = new EgresosDAOSessionImpl(req.getSession());
        EgresosDAO egresosDAO = new EgresosDAOJdbcImpl();
        req.setAttribute("egresos", egresosDAO.getEgresos());
        
        // despacha el control a la vista JSP
        req.getRequestDispatcher("/WEB-INF/jsp/egresos.jsp").forward(req, resp);
    }

    
    
}
