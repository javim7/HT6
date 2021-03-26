
//importando clases externas
import java.io.*;
import java.util.*;

/***************************************
 * @author Javier Mombiela
 * @author Jorge Caballeros
 * 
 * Clase Main, funcionamiento del programa
 * y jalar datos del factory..
 ***************************************/

public class prueba {
    private static Scanner input;
    public static void main(String[] args) throws IOException {

        //creando vairalbles
        input = new Scanner(System.in);
        String link = "cards_desc.txt";

        //creando los mapas
        Map<String, String> myMap;
        Map<String, String> coleccion;
        Map<String, Integer> coleccionCantidad;
        Factory fac = new Factory();

        //menu 1, para que el usuario escoja el tipo de mapa que quiere utilizar
        System.out.println("\nElija el mapa que quiere usar.");
        System.out.println("[1] HashMap");
        System.out.println("[2] TreeMap");
        System.out.println("[3] LinkedHashMap");
        String tipo = (input.nextLine());

        //if para ver que haya escogido una opcion valida
        if ( tipo.equals("3")||tipo.equals("2")||tipo.equals("1")){
            myMap = fac.queMapa(tipo);
            coleccion = fac.queMapa(tipo);
            coleccionCantidad = fac.queMapa(tipo);
            myMap = LeerElDocumento(link, myMap);

            //empezar ciclo infinito de las opciones
            boolean terminar = false;
            while (!terminar){

                 //menu 2: ver que opcion elige el usuario
                System.out.println("\nElija una de las siguientes opciones.");
                System.out.println("[1] Agregar carta a la coleccion.");
                System.out.println("[2] Mostrar tipo de carta especificada.");
                System.out.println("[3] Mostrar, nombre, tipo y cantidad de las cartas en mi coleccion.");
                System.out.println("[4] Mostrar, nombre, tipo y cantidad de las cartas en mi coleccion, ordenadas por tipo.");
                System.out.println("[5] Mostrar nombre y tipo de todas las cartas existentes.");
                System.out.println("[6] Mostrar nombre y tipo de todas las cartas existentes, ordenadas por tipo.");
                System.out.println("[7] Salir del programa.");
                String opcion2 = (input.nextLine());

                //switch para ver que opcion eligio
                switch (opcion2){

                    //empezando opcion 1
                    case "1":
                        System.out.println("Ingrese la carta: ");
                        String cartaNueva = (input.nextLine());

                        //viendo si el nombre de la carta se encuentra entre las cartas existentes o no
                        if(myMap.containsKey(cartaNueva)){
                            if(!coleccion.containsKey(cartaNueva)){
                                coleccion.put(cartaNueva,myMap.get(cartaNueva)); //agregando la carta a la coleccion
                                coleccionCantidad.put(cartaNueva,1);
                                System.out.println("La carta: "+cartaNueva+" se ha ingresado a su collecion");


                            }else{
                                int no = coleccionCantidad.get(cartaNueva); //agregando el numero de coleccion de la carta
                                no++;
                                coleccionCantidad.put(cartaNueva,no);
                                System.out.println("La carta: "+cartaNueva+" se ha ingresado a su collecion");
                            }
                        }else{ //mensaje de error
                            System.out.println("La carta no se encuentra dentro de las cartas existentes");
                        }
                        break;

                        //empezando opcion 2
                    case "2":
                        System.out.println("Ingrese la carta: ");
                        String carta = (input.nextLine());
                        if(myMap.containsKey(carta)){ //viendo si mi coleccion contiene la carta
                            System.out.println("La carta: "+carta+" es de tipo: "+myMap.get(carta));
                        }else{
                            System.out.println("La carta no se encuentra dentro de las cartas existentes");
                        }
                        break;

                        //empezando opcion3
                    case "3":
                        System.out.println("En su coleccion tiene las cartas:");
                        //for para recorrer todas las cartas en mi coleccion
                        for(String key: coleccion.keySet()){
                            System.out.println("Carta: "+key+" ||De tipo: "+coleccion.get(key)+" ||Cantidad: "+coleccionCantidad.get(key));
                        }
                        break;

                        //empezando opcion 4
                    case "4":

                    //haciendo el sort de las cartas
                        coleccion = sort(coleccion);
                        System.out.println("En su coleccion tiene las cartas:");

                        //for para recorrer las cartas en mi coleccion
                        for(String key: coleccion.keySet()){
                            System.out.println("Carta: "+key+" ||De tipo: "+coleccion.get(key)+" ||Cantidad: "+coleccionCantidad.get(key));
                        }
                        break;

                        //empezando opcion5
                    case "5":
                    //for para logar imprimir todas las cartas existentes
                        for(String key: myMap.keySet()){
                            System.out.println("Carta: "+key+" ||De tipo: "+myMap.get(key));
                        }
                        break;

                        //empezando opcion6
                    case "6":

                    //sorteando las cartas
                        myMap= sort(myMap);

                        //for para poder imprimir todas las cartas ya sorteadas
                        for(String key: myMap.keySet()){
                            System.out.println("Carta: "+key+" ||De tipo: "+myMap.get(key));
                        }
                        break;

                        //empezadno opcion 7
                    case "7":
                    System.out.println("Gracias por utilizar el programa!");
                        terminar=true;
                        break;

                        //mensaje de error par opcion incorrecta
                    default:
                        System.out.println("Esa opcion no existe");
                        break;
                }
            }
        }else {
            System.out.println("Esa opcion no existe");
        }
    }


    /**
     * @param nombre nombre del archivo txt
     * @param tipo tipo de map elegido por el usuario
     * @return deseado con las cartas ingresadas
     * @throws IOException  error si el archivo .txt no es encontrado
     */
    private static Map LeerElDocumento(String nombre, Map tipo) throws IOException {
        File file = new File(nombre);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            String[] parts = line.split("\\|");
            String clave = parts[0];
            String valor = parts[1];
            tipo.put(clave,valor);
        }
        return tipo;
    }

    /**
     * @param map recibe un mapa
     * @param <K> recibe las keys del mapa
     * @param <V> recibe los values del mapa
     * @return map devuelve el mapa ordenado por los valores
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sort(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }