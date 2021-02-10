package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author migue
 */
public class Mascota {
    private final List<Cita> citas = new ArrayList<>();
    private String nombre;
    private String edad;
    private String raza;
    private String peso;
    private String id;
    
    public Mascota(String nombre, String edad, String raza, String peso, String id) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.peso = peso;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

    public String getRaza() {
        return raza;
    }

    public String getPeso() {
        return peso;
    }

    public String getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public void setId(String id) {
        this.id = id;
    }


    public List<Cita> getCitas() {
        return citas;
    }
}
