package cl.duoc.dej.validator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago Neira <sant.neira@profesor.duoc.cl>
 */
public class EgresoValidator {

    String tipoEgreso;
    String proveedor;
    String rutProveedor;
    String tipoProveedor;
    boolean esEmpresa;
    String descripcion;
    String monto;

    List<String> mensajes = null;

    public EgresoValidator(String tipoEgreso, String proveedor, String rutProveedor, String tipoProveedor, boolean esEmpresa, String descripcion, String monto) {
        this.tipoEgreso = tipoEgreso;
        this.proveedor = proveedor;
        this.rutProveedor = rutProveedor;
        this.tipoProveedor = tipoProveedor;
        this.esEmpresa = esEmpresa;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    private void validarTipoEgreso() {
        try {
            char tEgreso = this.tipoEgreso.charAt(0);
            if (tEgreso == 'i' || tEgreso == 'h' || tEgreso == 's' || tEgreso == 'o') {

            } else {
                mensajes.add("El valor del tipo de egreso no es válido.");
            }

        } catch (Exception e) {
            mensajes.add("El tipo de egreso es incorrecto");
        }

    }

    private void validarProveedor() {
        if (this.proveedor.length() < 3) {
            mensajes.add("El largo del proveedor debe ser mayor a 3 caracteres.");
        }
    }

    private void validarMonto() {
        try {
            Long m = Long.parseLong(monto);
            if (m < 1) {
                mensajes.add("El monto debe ser positivo");
            }
        } catch (Exception e) {
            mensajes.add("Formato incorrecto para el monto.");
        }
    }

    private void validarTipoProveedor() {
        if(tipoProveedor == null || tipoProveedor.equals("")) {
            mensajes.add("Debe seleccionar un tipo de proveedor");
        }
    }
    
    private void validarDescripcion(){
        this.descripcion = descripcion.trim();
        if(descripcion.length() < 3) {
            mensajes.add("Debe agregar una descripción");
        }
    }
    
    private void validar() {
        this.mensajes = new ArrayList<>();
        validarTipoEgreso();
        validarProveedor();
        validarTipoProveedor();
        validarMonto();
        validarDescripcion();
    }

    public boolean isValid() {
        validar();
        if (mensajes.size() == 0) {
            return true;
        }
        return false;
    }

    public List<String> getMensajes() {
        return mensajes;
    }

}
