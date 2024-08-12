public class Ejercicio_programacion_02 {
    /*
    * EJERCICIO:
    * - Crea ejemplos de funciones básicas que representen las diferentes
    *   posibilidades del lenguaje:
    *   Sin parámetros ni retorno, con uno o varios parámetros, con retorno...
    * - Comprueba si puedes crear funciones dentro de funciones.
    * - Utiliza algún ejemplo de funciones ya creadas en el lenguaje.
    * - Pon a prueba el concepto de variable LOCAL y GLOBAL.
    * - Debes hacer print por consola del resultado de todos los ejemplos.
    *   (y tener en cuenta que cada lenguaje puede poseer más o menos posibilidades)
    *
    * DIFICULTAD EXTRA (opcional):
    * Crea una función que reciba dos parámetros de tipo cadena de texto y retorne un número.
    * - La función imprime todos los números del 1 al 100. Teniendo en cuenta que:
    *   - Si el número es múltiplo de 3, muestra la cadena de texto del primer parámetro.
    *   - Si el número es múltiplo de 5, muestra la cadena de texto del segundo parámetro.
    *   - Si el número es múltiplo de 3 y de 5, muestra las dos cadenas de texto concatenadas.
    *   - La función retorna el número de veces que se ha impreso el número en lugar de los textos.
    *
    * Presta especial atención a la sintaxis que debes utilizar en cada uno de los casos.
    * Cada lenguaje sigue una convenciones que debes de respetar para que el código se entienda.
    */


    //funcion simple sin parámetros ni retorno y sin necesidad de instanciar (static)
    public static void funcion1(){
        System.out.println("Primera función, no parámetros ni retorno");
    }

    //función con parámetros sin retorno
    public static void funcion2(int numero){
        System.out.println("Función 2, número: " + numero);
    }

    //función sin parámetros pero con retorno
    public static String funcion3(){
        return "esta es la función 3";
    }

    //función con parámetros y retorno
    public static int funcion4(int numero, int numero2){
        return numero + numero2;
    }

    //función con función dentro. No se puede a no ser que sea anónima con una clase dentro
    public static void funcion5(){
        class ClaseInterna{
            void funcionInterna(){
                System.out.println("Función de dentro de la clase interna");
            }
        }

        ClaseInterna claseInterna = new ClaseInterna();
        claseInterna.funcionInterna();

    }

    //variable global
    static int numGlobal = 6;


    public static void main(String[] args) {
        funcion1();
        funcion2(5);
        System.out.println(funcion3());
        System.out.println(funcion4(numGlobal,8));
        funcion5();
        
        //funciones ya creadas en el lenguaje
        System.out.println("Estoy utilizando una función ya creada, la de println");
        System.out.println(Math.max(2, 8));

        //variable local
        int num = 0; //esta variable no puede ser llamada desde fuera de este método
        numGlobal = 4; //esta variable es una variable global y puede ser llamada desde distintos métodos

        System.out.println(funcionDificil("multiplo3", "multiplo5"));
    }

    //---------------------------DIFICULTAD EXTRA-----------------------------------
    public static int funcionDificil(String cadena1, String cadena2){
        int contador = 0;
        for(int i = 1; i<= 100; i++){
           if(i%3 == 0 && i%5 == 0){
                System.out.println(cadena1 + cadena2);
           } 
           else if(i%3 == 0){
                System.out.println(cadena1);
           }
           else if(i%5 == 0){
                System.out.println(cadena2);
           }
           else{
            System.out.println(i);
                contador++;
           }
        }

        return contador;
    }

}
