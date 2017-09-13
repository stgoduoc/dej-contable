package cl.duoc.dej.service;

import cl.duoc.dej.entity.Egreso;
import java.util.List;

/**
 *
 * @author Santiago Neira <sant.neira@profesor.duoc.cl>
 */
public interface EgresosDAO {
    
    public List<Egreso> getEgresos();
    
    public void crearEgreso(Egreso egreso);
    
    public void eliminarEgreso(Long codigoEgreso);
    
    public Egreso getEgresoByCodigo(Long codigoEgreso);
    
}
