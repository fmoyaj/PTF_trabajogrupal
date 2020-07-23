package collections;

import java.util.List;
import java.util.Objects;

public class Pais {
    private String nombre;
    private List<Pais> paisesVecinos;


    public Pais(String nombre) {
        this.nombre = nombre;
    }

    public void setPaisesVecinos(List<Pais> paisesVecinos) {
        this.paisesVecinos = paisesVecinos;
    }

    public List<Pais> getPaisesVecinos() {
        return paisesVecinos;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return nombre.equals(pais.nombre) &&
                paisesVecinos.equals(pais.paisesVecinos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, paisesVecinos);
    }
}