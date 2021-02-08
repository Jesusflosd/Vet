package modelo;

/**
 *
 * @author migue
 */
public class Cita {
    private String fecha;
    private String nombreMedico;
    private String motivo;

    public Cita(String fecha, String nombreMedico, String motivo) {
        this.fecha = fecha;
        this.nombreMedico = nombreMedico;
        this.motivo = motivo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    
    
}
