package cl.duoc.dej.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.TimeZone;

/**
 *
 * @author Santiago Neira <sant.neira@profesor.duoc.cl>
 */
public class Egreso {

    private Long codigoEgreso;
    /**
     * i=insumo
     * h=hardware
     * s=software
     * o=otro
     */
    private char tipoEgreso;
    /**
     * razón social empresa
     */
    private String proveedor;
    private boolean esEmpresa;
    /**
     * Lista separada por comas
     * de los productos o servicios comprados
     */
    private String descripcion;
    /**
     * fecha de registro del egreso
     */
    private Calendar fecha = Calendar.getInstance();
    private Long monto;
    private String rutProveedor;

    
    // ###############################
    // Constructores
    // ###############################
    public Egreso() {
        init();
    }

    public Egreso(Long codigoEgreso) {
        init();
        this.codigoEgreso = codigoEgreso;
    }
    
    public Egreso(char tipoEgreso, String proveedor, boolean esEmpresa, String descripcion, Long monto, String rutProveedor) {
        this.tipoEgreso = tipoEgreso;
        this.proveedor = proveedor;
        this.esEmpresa = esEmpresa;
        this.descripcion = descripcion;
        this.monto = monto;
        this.rutProveedor = rutProveedor;
        init();
    }
    
    // ###############################
    // Métodos
    // ###############################

    private void init(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Santiago"));
        String format = simpleDateFormat.format(fecha.getTime());
        this.codigoEgreso = Long.parseLong(format);
    }
    
    public Long getCodigoEgreso() {
        return codigoEgreso;
    }

    public void setCodigoEgreso(Long codigoEgreso) {
        this.codigoEgreso = codigoEgreso;
    }

    
    
    public char getTipoEgreso() {
        return tipoEgreso;
    }

    public void setTipoEgreso(char tipoEgreso) {
        this.tipoEgreso = tipoEgreso;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public boolean isEsEmpresa() {
        return esEmpresa;
    }

    public void setEsEmpresa(boolean esEmpresa) {
        this.esEmpresa = esEmpresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public String getRutProveedor() {
        return rutProveedor;
    }

    public void setRutProveedor(String rutProveedor) {
        this.rutProveedor = rutProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigoEgreso);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Egreso other = (Egreso) obj;
        if (!Objects.equals(this.getCodigoEgreso(), other.getCodigoEgreso())) {
            return false;
        }
        return true;
    }
    
    
}
