/***************************************
 * @author Javier Mombiela
 * @author Jorge Caballeros
 * 
 * Clase Cartas, es la clase que utilizamos
 * para poder ver la informacion de las 
 * cartas.
 ***************************************/
public class Cartas {
    private String nombre;
    private String tipo;
    /**
     * 
     * @param nombre
     * @param tipo 
     */
      public Cartas(String nombre, String tipo){
       this.nombre = nombre;
       this.tipo = tipo;
   }
      /**
       * 
       * @return nombre de la carta
       */
      public String getNombre() {
       return nombre;
   }
/**
* 
* @param nombre 
*/
   public void setNombre(String nombre) {
       this.nombre = nombre;
   }
/**
* 
* @return tipo de carta
*/
   public String getTipo() {
       return tipo;
   }
/**
* 
* @param tipo 
*/
   public void setTipo(String tipo) {
       this.tipo = tipo;
   }
/**
* 
* @return 
*/
   @Override
   public String toString() {
       return nombre + " | " + tipo;
   }
   
   /**
    * Imprime las cortas por tipo.
    * @return: El string de las cartas
    */
   public String porTipo(){
       return tipo + " | " + nombre;
   }
   
   
}