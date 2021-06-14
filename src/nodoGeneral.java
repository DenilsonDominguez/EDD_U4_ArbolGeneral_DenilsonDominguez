//Denilson de Jesus Dominguez Herrera
public class nodoGeneral {
    
    char valor;
    NodoHijo ini, fin;
    
    public nodoGeneral(char v){
        valor = v;
        ini = fin = null;
    }
    
    public boolean enlazar(nodoGeneral hijo){
        NodoHijo enlace= new NodoHijo(hijo);
        if(enlace==null)return false;
        
        if(ini==null && fin==null){
            ini = fin = enlace;
            return true;
        }
        
        fin.sig = enlace;
        enlace.ant= fin;
        fin= enlace;
        return true;
    }
    public boolean esHoja(){
        return ini==null&&fin==null;
    }
    
    public nodoGeneral obtenerHijo(char valorHijoBuscado){
        if(esHoja()) return null;
        
        for(NodoHijo buscar= ini; buscar != null; buscar= buscar.sig){
            if(buscar.direccionHijo.valor == valorHijoBuscado){
                return buscar.direccionHijo;
            }
        }
        return null;
    }
    
}
