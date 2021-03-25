//importando clases
import java.util.*; 
import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) {
        
        //creando instancias
        Scanner scan = new Scanner(System.in);


        //creando los mapas
        HashMap<String, String> deck = new HashMap<String, String>(); //mapa que almacena todas las cartas inicialmente
        HashMap<String, String> coleccion = new HashMap<String, String>(); //mapa de la coleccion del usuario

        //se utiliza un try catch para aseguranos que el archivo pueda ser leido correctamente 
        try{

            //creando variables
            File archivoTexto = new File("cards_desc.txt"); //creando nuestro nuevo archivo

            Scanner scanner = new Scanner(archivoTexto); //instanciando la clase scanner con el archivo

            while(scanner.hasNextLine()) { //while para que se lean todas las lineas en el archivo

                String carta = scanner.nextLine(); //guardando los elementos (de cada linea) como variables

                carta = carta.replace("|", "_"); //remplazando el signo
                
                String[] agregar = carta.split("_"); //haciendo split al string

                deck.put(agregar[0], agregar[1]); //agregando las strings al mapa
                 
            }

            scanner.close();

            //se hace un catch por si el archivo no se puede leer
        } catch (FileNotFoundException errorArchivoNoEncontrado) {
            // Se le advierte al usuario que el archivo no es existente, se termina el programa.
            System.out.println("El archivo de texto cards_desc.txt no ha sido encontrado.");
        }

        while(true) {


              //menu 1: ver que mapa va a usar el usuario
        System.out.println("\nElija el mapa que quiere usar.");
        System.out.println("[1] HashMap");
        System.out.println("[2] TreeMap");
        System.out.println("[3] LinkedHashMap");

        int opcion = 0;

        while(true){
            try{
                System.out.print("\nOpcion: ");
                opcion = scan.nextInt();
                //(Programación defensiva)
                //Protección por si el usuario elige un número menor a uno o mayor a dos, seguirá pidiendo la opción. 
                if(opcion > 3 || opcion < 1){
                    System.out.println("Opcion incorrecta, intenta de nuevo..");
                }
                //Si el usuario ingresa los datos correctos terminará el ciclo while
                else{break;}
            }
            //Si el usuario ingresa una letra regresará un mensaje de error. 
            catch(Exception o){
                scan.nextLine();
                System.out.println("Caracter invalido! Intenta de nuevo..");
            }
        } 



        //menu 2: ver que opcion elige el usuario
        System.out.println("\nElija una de las siguientes opciones.");
        System.out.println("[1] Agregar carta a la coleccion.");
        System.out.println("[2] Mostrar tipo de carta especificada.");
        System.out.println("[3] Mostrar, nombre, tipo y cantidad de las cartas en mi coleccion.");
        System.out.println("[4] Mostrar, nombre, tipo y cantidad de las cartas en mi coleccion, ordenadas por tipo.");
        System.out.println("[5] Mostrar nombre y tipo de todas las cartas existentes.");
        System.out.println("[6] Mostrar nombre y tipo de todas las cartas existentes, ordenadas por tipo.");

        int opcion2 = 0;

        while(true){
            try{
                System.out.print("\nOpcion: ");
                opcion2 = scan.nextInt();
                //(Programación defensiva)
                //Protección por si el usuario elige un número menor a uno o mayor a dos, seguirá pidiendo la opción. 
                if(opcion2 > 6 || opcion2 < 1){
                    System.out.println("Opcion incorrecta, intenta de nuevo..");
                }
                //Si el usuario ingresa los datos correctos terminará el ciclo while
                else{break;}
            }
            //Si el usuario ingresa una letra regresará un mensaje de error. 
            catch(Exception o){
                scan.nextLine();
                System.out.println("Caracter invalido! Intenta de nuevo..");
            }
        } 


        //empezando la opcion 1, agregar cartas a la coleccion
        if(opcion2 == 1) {

            //pidiendo el nombre de la carta y guardandola a una variable
            System.out.println("\nIngrese el nombre de la carta que quiere agregar a su coleccion.\n");
            String llave = scan.nextLine();
            llave = scan.nextLine();

            //haciendo un if para ver si la carta existe o no
            if(deck.containsKey(llave)) {

                System.out.println("\nCarta encontrada! " + llave + " agregada a su coleccion!");

                //encontrando el valor de la llave
                String valor = deck.get(llave);

                //agregando llave y valor a la coleccion
                coleccion.put(llave, valor);

            } else{
                System.out.println("\nERROR! " + llave + " no existe!");
            }

        }


        //empezando la opcion 2, mostrando el tipo de la carta seleccionada
        if(opcion2 == 2) {

            //pidiendo el nombre de la carta
            System.out.println("\nIngrese el nombre de la carta del cual quiera ver su tipo.\n");
            String llave = scan.nextLine();
            llave = scan.nextLine();

            //haciendo un if para ver si la carta existe o no
            if(coleccion.containsKey(llave)) {

                String tipo = coleccion.get(llave);

                System.out.println("\nEl tipo de " + llave + " es: " + tipo);

            } else{
                System.out.println("\n" + llave + " no es parte de su coleccion!");
            }

        }


        //empezando opcion 3, mostrar info de las cartes en mi coleccion
        if(opcion2 == 3) {

            ArrayList<String> llaves = new ArrayList<String>();
            ArrayList<String> valores = new ArrayList<String>();

            for (String llave: coleccion.keySet()) {
                String key = llave.toString();
                String value = coleccion.get(llave).toString();
                //System.out.println(key + " " + value);
            }
        }


        //empezando opcion 4, mostrar info de las cartas ordenadas por tipo
        if(opcion2 == 4) {

        }


         //empezando opcion 5 mostrar nombre y tipo de todas las cartas
         if(opcion2 == 5) {

            System.out.println("NOMBRE-------------------------------------------------------------TIPO\n");

            //haciendo for each para poder imprimir todas las cartas
            for (String llave: deck.keySet()) {
                String key = llave.toString();
                String value = deck.get(llave).toString();
                System.out.println(key + "---------------------------------------" + value);
            }
            
        }


         //empezando opcion 6, mostrar nombre y tipo de todas las cartas ordenadas por tipo
         if(opcion2 == 6) {
            
        }



        }
    
      
    }

}