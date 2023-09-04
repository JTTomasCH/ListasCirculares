/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listascirculares;

import java.util.Objects;

/**
 *
 * @author SG702-21
 */
public class Persona implements Comparable<Persona> {
    
    private String nombre;
    private int edad;

    public Persona() {
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }

    
    @Override
    public int compareTo(Persona p) {
        int resultado=0;
        if (this.edad<p.getEdad())
            return -1;
        else
            if (this.edad>p.getEdad())
                return 1;
        return 0;
    }
    
    public boolean equals(Object contenido) {
        if (this == contenido) {
            return true;
        }
        if (contenido == null || getClass() != contenido.getClass()) {
            return false;
        }
        Persona persona = (Persona) contenido;
        return edad == persona.edad && Objects.equals(nombre, persona.nombre);
    }
        
}
