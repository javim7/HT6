//importando clases
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.LinkedHashMap;

/***************************************
 * @author Javier Mombiela
 * @author Jorge Caballeros
 * 
 * Clase Factory, sirve para poder jalar
 * una de las tres implementaciones de
 * java HashMap.
 ***************************************/
public class Factory {


     /**
     * @param opcion
     * @return tipo de implementacion
     */
    public Map<String, String> getStack (int opcion){
        
        if (opcion==1) {

            System.out.println("Ha seleccionado Hashmap");
            return new HashMap<String, String>();
        }
           
        
        if (opcion==2) {

            System.out.println("Ha seleccionado Treemap");
            return new TreeMap<String, String>();

        }
            
        
        if (opcion==3) {
            
        System.out.println("Ha seleccionado LinkedHashmap");
        return new LinkedHashMap<String, String>();
        
        }
        
        
        return null;
        
    }
    
}
