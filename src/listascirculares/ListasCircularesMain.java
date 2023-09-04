
package listascirculares;

import java.util.Iterator;

/**
 *
 * @author Tomás Chiriví
 */
public class ListasCircularesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListasCirculares<Persona> personas = new ListasCirculares<Persona>();
        
        System.out.println("La lista esta vacia? "+personas.isEmpty()+"\n");
        Persona per1 = new Persona("Jorge", 15);
        Persona per2 = new Persona("Tomas", 32);
        personas.addLast(per1);
        personas.addLast(per2);
        System.out.println("Lista 1: ");
        
        personas.showList();

        
        System.out.println("");
        

        ListasCirculares<Persona> persona = new ListasCirculares<Persona>();
        Persona per3 = new Persona("Juan", 15);
        Persona per4 = new Persona("Andres", 32);
        Persona per5 = new Persona("Carlos", 15);
        Persona per6 = new Persona("Luisa", 32);
        Persona per7 = new Persona("Santiago", 20);
        
        persona.addLast(per3);
        persona.addLast(per4);
        persona.addLast(per5);
        persona.addLast(per6);
        persona.addFirst(per7);

        
        System.out.println("Lista 2: ");
        
        persona.showList();
        System.out.println("");

        
        Iterator<Persona> ManecillasReloj = persona.ManecillasReloj();
        System.out.println("Recorrido en sentido contrario de las manecillas del reloj:");
        while (ManecillasReloj.hasNext()) {
            System.out.print(ManecillasReloj.next() + " ");
        }
        System.out.println();
        System.out.println();
        
        
        Iterator<Persona> ContrarioManecillas = persona.ContrarioManecillas();
        System.out.println("Recorrido en sentido de las manecillas del reloj:");
        while (ContrarioManecillas.hasNext()) {
            System.out.print(ContrarioManecillas.next() + " ");
        }
        System.out.println();
    }
    
}
