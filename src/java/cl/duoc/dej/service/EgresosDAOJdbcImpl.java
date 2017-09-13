package cl.duoc.dej.service;

import cl.duoc.dej.entity.Egreso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago Neira <sant.neira@profesor.duoc.cl>
 */
public class EgresosDAOJdbcImpl implements EgresosDAO {

    Connection conexion;
    
    private Connection getConexion() throws SQLException, ClassNotFoundException {
        return ConexionDb.getConexion();
    }
    
    @Override
    public void crearEgreso(Egreso egreso) {
        try {
            conexion = getConexion();
            PreparedStatement prepareStatement = conexion.prepareStatement("INSERT INTO egresos(tipo_egreso, proveedor, es_empresa, descripcion, monto, rut_proveedor) values(?,?,?,?,?,?)");
            prepareStatement.setString(1, egreso.getTipoEgreso()+""); // tipo_egreso
            prepareStatement.setString(2, egreso.getProveedor()); // proveedor
            prepareStatement.setInt(3, egreso.isEsEmpresa()?1:0); // es_empresa
            prepareStatement.setString(4, egreso.getDescripcion()); // descripcion
            prepareStatement.setLong(5, egreso.getMonto()); // monto
            prepareStatement.setString(6, egreso.getRutProveedor()); // rut proveedor
            prepareStatement.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EgresosDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Egreso> getEgresos() {
        try {
            conexion = getConexion();
            PreparedStatement prepareStatement = conexion.prepareStatement("SELECT * FROM egresos");
            ResultSet rs = prepareStatement.executeQuery();
            List<Egreso> egresos = new ArrayList<>();
            while(rs.next()) {
                Egreso egreso = new Egreso();
                egreso.setCodigoEgreso( rs.getLong("id") );
                egreso.setDescripcion(rs.getString("descripcion") );
                egreso.setTipoEgreso(rs.getString("tipo_egreso").charAt(0) );
                egreso.setMonto(rs.getLong("monto") );
                egreso.setRutProveedor(rs.getString("rut_proveedor") );
                egreso.setProveedor(rs.getString("proveedor"));
                egreso.setEsEmpresa(rs.getBoolean("es_empresa"));
                
                egresos.add(egreso);
            }
            return egresos;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EgresosDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void eliminarEgreso(Long codigoEgreso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Egreso getEgresoByCodigo(Long codigoEgreso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
