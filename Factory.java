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
    public Map queMapa (String opcion){
        
        if (opcion.equals("1")) {

            System.out.println("Ha seleccionado Hashmap");
            return new HashMap();
        }
           
        
        if (opcion.equals("2")) {

            System.out.println("Ha seleccionado Treemap");
            return new TreeMap();

        }
            
        
        if (opcion.equals("3")) {
            
        System.out.println("Ha seleccionado LinkedHashmap");
        return new LinkedHashMap();

        }
        
        
        return null;
        
    }
    
}
