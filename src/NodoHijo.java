//Denilson de Jesus Dominguez Herrera
public class NodoHijo {
    nodoGeneral direccionHijo;
    NodoHijo ant, sig;
    
    public NodoHijo(nodoGeneral hijoApuntar){
        direccionHijo = hijoApuntar;
        ant = sig = null;
    }
}
