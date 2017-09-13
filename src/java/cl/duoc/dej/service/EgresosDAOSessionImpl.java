package cl.duoc.dej.service;

import cl.duoc.dej.entity.Egreso;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Santiago Neira <sant.neira@profesor.duoc.cl>
 */
public class EgresosDAOSessionImpl implements EgresosDAO {

    List<Egreso> egresos;
    HttpSession session;
    // constante
    public static final String KEY_EGRESOS = "EGRESOS";

    /**
     * Constructor
     * @param session 
     */
    public EgresosDAOSessionImpl(HttpSession session) {
        this.session = session;
        init();
    }
    
    // ---------------------------------------------------

    private void init() {
        egresos = (List<Egreso>)session.getAttribute(KEY_EGRESOS);
        if(egresos == null) {
            egresos = new ArrayList<>();
        }
    }

    private void guardar() {
        session.setAttribute(KEY_EGRESOS, egresos);
    }

    @Override
    public List<Egreso> getEgresos() {
        return egresos;
    }

    @Override
    public void crearEgreso(Egreso egreso) {
        egresos.add(egreso);
        guardar();
    }

    @Override
    public void eliminarEgreso(Long codigoEgreso) {
        Egreso e = new Egreso(codigoEgreso);
        egresos.remove(e);
        guardar();
    }

    @Override
    public Egreso getEgresoByCodigo(Long codigoEgreso) {
        int lastIndexOf = egresos.lastIndexOf(new Egreso(codigoEgreso));
        if (lastIndexOf < 0) {
            return null;
        }
        return egresos.get(lastIndexOf);
    }

}
