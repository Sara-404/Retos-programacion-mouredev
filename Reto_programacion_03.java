/*
 * EJERCICIO:
 * - Muestra ejemplos de creación de todas las estructuras soportadas por defecto
 *   en tu lenguaje. HECHO
 * - Utiliza operaciones de inserción, borrado, actualización y ordenación. HECHO
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea una agenda de contactos por terminal.
 * - Debes implementar funcionalidades de búsqueda, inserción, actualización
 *   y eliminación de contactos.
 * - Cada contacto debe tener un nombre y un número de teléfono.
 * - El programa solicita en primer lugar cuál es la operación que se quiere realizar,
 *   y a continuación los datos necesarios para llevarla a cabo.
 * - El programa no puede dejar introducir números de teléfono no númericos y con más
 *   de 11 dígitos (o el número de dígitos que quieras).
 * - También se debe proponer una operación de finalización del programa.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Reto_programacion_03{
    
    /*
     * Las estructuras de datos soportadas en java son:
     * - ArrayList
     * - LinkedList
     * - HashMap
     * - HashSet
     * - TreeMap
     * - TreeSet
     */

     //agenda de contactos
    public static HashMap<String, Integer> contactos = new HashMap<String, Integer>();

    public static void main(String[] args) {
        //mostrarArrayList();
        //mostrarLinkedList();
        //mostrarHashMap();
        //mostrarHashSet();
        //mostrarTreeMap();
        //mostrarTreeSet();

        //Agenda de contactos
        String input;
        int respuesta = 0;
        Scanner sc = new Scanner(System.in);
        
        do{
            
            System.out.println("Selecciona una opción, escribe el número correspondiente:" +
            "\n\t [1] Ver lista de contactos" +
            "\n\t [2] Buscar contacto" +
            "\n\t [3] Agregar contacto" +
            "\n\t [4] Actualizar contacto" +
            "\n\t [5] Borrar contacto" + 
            "\n\t [0] Finalizar programa");

            input = sc.nextLine();

            try{
                respuesta = Integer.parseInt(input);
                if(!(respuesta >= 0 && respuesta<= 5)) System.out.println("Debe escribir un número de la lista");
                else{
                    switch(respuesta) {
                        case 1:
                          mostrarListaContactos(sc);
                          break;
                        case 2:
                          buscarContacto(sc);
                          break;
                        case 3:
                          agregarContacto(sc);
                        break;
                        case 4:
                          actualizarContacto(sc);
                        break;
                        case 5:
                          borrarContacto(sc);
                        break;
                        case 0:
                          System.out.println("FIN DEL PROGRAMA");
                        break;
                      }
                }
                
            }catch(NumberFormatException e){
                System.out.println("Debe escribir el número que corresponda a la acción que quiera hacer");
            }
            

        }while(respuesta != 0);

        sc.close();
    }

    public static void mostrarListaContactos(Scanner sc){
        System.out.println("Mostrando lista de contactos: \n" + contactos);
        System.out.println("------------------------------------------------");
    }

    //busca un contacto en la lista a través del nombre proporcionado por el usuario
    public static void buscarContacto(Scanner sc){
        System.out.println("Escribe el nombre (correctamente) del contacto que quieres buscar");
        String nombre = sc.nextLine();

        if(contactos.containsKey(nombre)) System.out.println("Teléfono de " + nombre +": " + contactos.get(nombre.toString()));
        else System.out.println("Ese contacto no existe");
    }

    //comprueba que el teléfono sea un número y tenga 9 dígitos
    public static Integer validarTelefono(Scanner sc){
        Integer telefono = 0;
        boolean telefonoValido = false;
        String input;

        do{
            try{
                System.out.println("Escribe su teléfono");
                input = sc.nextLine();
                telefono = Integer.parseInt(input);

                //si el teléfono tiene 9 dígitos, es válido, sino no
                if((telefono.toString().length()) == 9) telefonoValido = true;
                else System.out.println("El número de teléfono debe contener 9 dígitos, vuelve a escribir:");

            }
            //dará error en caso de escribir otro tipo de datos en vez de un número
            catch(NumberFormatException e){
                System.out.println("El número de teléfono debe ser un número y contener 9 dígitos");
                telefono = 0;
            }
        }while(!telefonoValido);

        return telefono;

    }
    
    //borra un contacto a través del nombre que dé el usuario
    public static void borrarContacto(Scanner sc){
        System.out.println("Escribe el nombre del contacto que deseas borrar");
        String nombre;
        nombre = sc.nextLine();
        if(contactos.containsKey(nombre)) {
            contactos.remove(nombre);
            System.out.println("Contacto borrado");
        }
        else System.out.println("No existe ese contacto");
    }
    
    //actualiza el teléfono de un contacto
    public static void actualizarContacto(Scanner sc){
        Integer telefono = 0;
        String nombre;
        
        System.out.println("Escribe el nombre de quien deseas actualizar su teléfono");
        nombre = sc.nextLine();
        
        if(contactos.containsKey(nombre)) {
            telefono = validarTelefono(sc);
            contactos.replace(nombre, telefono);
            System.out.println("Contacto actualizado");
        }
        else System.out.println("No existe ese contacto");

    }

    //agrega un nuevo contacto en la lista
    public static void agregarContacto(Scanner sc){
        String nombre;
        Integer telefono = 0;
        
        //Esto evita que el nombre esté vacío
        do{
            System.out.println("Escribe el nombre del nuevo contacto");
            nombre = sc.nextLine();
        }while(nombre.isEmpty());
        
        telefono = validarTelefono(sc);

        contactos.put(nombre, telefono);
        System.out.println("Contacto añadido");
    }

    //ejemplo TreeSet
    public static void mostrarTreeSet(){
        //TreeSet
        TreeSet<Integer> treeset = new TreeSet<Integer>();

        //inserción y ordenación ya que ordena los elementos
        treeset.add(1);
        treeset.add(30);
        treeset.add(12);
        treeset.add(25);
        treeset.add(64);
        System.out.println("Inserción");
        System.out.println(treeset);

        //borrado
        treeset.remove(25); //borra el elemento 3 si existe
        System.out.println("Borrado");
        System.out.println(treeset);

        //actualización. Hashset no puede reemplazar objetos o actualizarlos, la manera de hacerlo es borrando e insertando
        treeset.remove(12); //se borra el 4
        treeset.add(13);//se añade el 3
        System.out.println("Actualización");
        System.out.println(treeset);

    }

    //ejemplo TreeMap
    public static void mostrarTreeMap(){
        //TreeMap
        TreeMap<Integer, String> treemap = new TreeMap<Integer, String>();

        //inserción y ordenación porque lo ordena solo
        treemap.put(1, "uno");
        treemap.put(4, "cuatro");
        treemap.put(2, "dos");
        treemap.put(5, "cinco");
        treemap.put(3, "quince");
        System.out.println("Inserción");
        System.out.println(treemap);

        //borrado
        treemap.remove(1); //borra el elemento en la key 1, sería 1="uno"
        System.out.println("Borrado");
        System.out.println(treemap);

        //actualización
        treemap.replace(3, "tres"); //se corrige el valor de 3
        System.out.println("Actualización");
        System.out.println(treemap);
    }

    //ejemplo HashSet
    public static void mostrarHashSet(){
        //HashSet
        HashSet<Integer> hashset = new HashSet<Integer>();

        //inserción
        hashset.add(1);
        hashset.add(30);
        hashset.add(12);
        hashset.add(25);
        hashset.add(64);
        System.out.println("Inserción");
        System.out.println(hashset);

        //borrado
        hashset.remove(25); //borra el elemento 3 si existe
        System.out.println("Borrado");
        System.out.println(hashset);

        //actualización. Hashset no puede reemplazar objetos o actualizarlos, la manera de hacerlo es borrando e insertando
        hashset.remove(12); //se borra el 4
        hashset.add(13);//se añade el 3
        System.out.println("Actualización");
        System.out.println(hashset);

        //ordenación: no se puede ordenar los elementos de un hashset
    }

    //ejemplo HashMap
    public static void mostrarHashMap(){
        //HashMap
        HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
        
        //inserción y ordenación
        hashmap.put(1, "uno");
        hashmap.put(4, "cuatro");
        hashmap.put(2, "dos");
        hashmap.put(5, "cinco");
        hashmap.put(3, "quince");
        System.out.println("Inserción");
        System.out.println(hashmap); //vemos que se ordena solo a través de la key

        //borrado
        hashmap.remove(1); //borra el elemento en la key 1, sería 1="uno"
        System.out.println("Borrado");
        System.out.println(hashmap);

        //actualización
        hashmap.replace(3, "tres"); //se corrige el valor de 3
        System.out.println("Actualización");
        System.out.println(hashmap);

    }

    //ejemplo LinkedList
    public static void mostrarLinkedList(){
        //LinkedList
        LinkedList <Integer> linkedlist = new LinkedList<>();
        //inserción
        linkedlist.add(1);
        linkedlist.addFirst(30);
        linkedlist.add(12);
        linkedlist.addFirst(25);
        linkedlist.addLast(64);
        System.out.println("Inserción");
        System.out.println(linkedlist);

        //borrado
        linkedlist.remove(1); //borra el elemento en el índice 1, sería el 30
        System.out.println("Borrado");
        System.out.println(linkedlist);

        //actualización
        linkedlist.set(0, 45); //en la posición 0 (donde estaba el 25) ahora es un 45
        System.out.println("Actualización");
        System.out.println(linkedlist);

        //ordenación
        linkedlist.sort(null);
        System.out.println("Ordenación");
        System.out.println(linkedlist);
    }

    //ejemplo ArrayList
    public static void mostrarArrayList(){
        //ArrayList
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        //inserción
        arraylist.add(1);
        arraylist.add(30);
        arraylist.add(12);
        arraylist.add(25);
        arraylist.add(64);
        System.out.println("Inserción");
        System.out.println(arraylist);

        //borrado
        arraylist.remove(1); //borra el elemento en el índice 1, sería el 30
        System.out.println("Borrado");
        System.out.println(arraylist);

        //actualización
        arraylist.set(0, 45); //en la posición 0 (donde estaba el 1) ahora es un 45
        System.out.println("Actualización");
        System.out.println(arraylist);

        //ordenación
        arraylist.sort(null);
        System.out.println("Ordenación");
        System.out.println(arraylist);
    }

}