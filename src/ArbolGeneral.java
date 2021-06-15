//Denilson de Jesus Dominguez Herrera
public class ArbolGeneral {
    nodoGeneral raiz;
    
    public ArbolGeneral(){
        raiz = null;
    }
    
    public boolean insertar(char dato, String path){
        /*
        1.- reiz es null
        2.- path vacio
        3.- buscar padre
        4.- crear hijo
        5.- enlazar padre con hijo
        */


        if (raiz== null){
            raiz = new nodoGeneral(dato);
            if(raiz== null) return false;
            return true;
        }
        
        if(path.isEmpty()) return false;
        
        nodoGeneral padre = buscarNodo(path);
        if(padre==null) return false;
        
        nodoGeneral hijoYaExiste= buscarNodo(path+"/"+dato);
        if(hijoYaExiste != null) return false;
        
        nodoGeneral nuevo = new nodoGeneral(dato);
        return padre.enlazar(nuevo);
    }

    public NodoGeneral buscarNodo(String path){
        
        if(path.isEmpty()){
            return null;
        }
        
        path = path.substring(1);
        
        String[] vector = path.split("/");
        
        if(raiz.valor == vector[0].charAt(0)){
           
            if(vector.length == 1){
                return raiz;
            }
            for(NodoLiga temp = raiz.ini; temp != null; temp = temp.sig){
                if(temp.direccion.valor == vector[1].charAt(0)){
                    if(vector.length == 2){
                        return temp.direccion;
                    }
                    return buscarNodo(temp.direccion, path.substring(3));
                }
            }
        }
        
        return null;
    }
    
    protected nodoGeneral buscarNodo(nodoGeneral nodoEncontrado, String path){        
        if(path.isEmpty()){
            return nodoEncontrado;
        }  
        path = path.substring(1);
        String[] vector;
        if(path.length() == 1){
            vector = new String[1];
            vector[0] = path;
        }else{
            vector = path.split("/");
        }
        
        for(NodoHijo temp = nodoEncontrado.ini; temp != null; temp = temp.sig){
            if(temp.direccionHijo.valor == vector[0].charAt(0)){
                buscarNodo(temp.direccionHijo,path.substring(1));
            }
        }
        
        return null;
    }
    
    
}
