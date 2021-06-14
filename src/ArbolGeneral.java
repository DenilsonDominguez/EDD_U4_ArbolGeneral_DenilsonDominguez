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

    public nodoGeneral buscarNodo(String path) {
        
        path =path.substring(1);
        
        String vector[] = path.split("/");
        
        if(vector[0].charAt(0) == raiz.valor){
            if(vector.length==1) return raiz;
            nodoGeneral padre = raiz;
            
            for(int i= 1;i<vector.length; i++ ){
                padre = padre.obtenerHijo(vector[i].charAt(0));
                if(padre==null) return null;
                
            }
            return padre;
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
