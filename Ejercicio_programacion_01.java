public class Ejercicio_programacion_01 {
    /*
 * EJERCICIO:
 * - Crea ejemplos utilizando todos los tipos de operadores de tu lenguaje:
 *   Aritméticos, lógicos, de comparación, asignación, identidad, pertenencia, bits...
 *   (Ten en cuenta que cada lenguaje puede poseer unos diferentes)
 * - Utilizando las operaciones con operadores que tú quieras, crea ejemplos
 *   que representen todos los tipos de estructuras de control que existan
 *   en tu lenguaje:
 *   Condicionales, iterativas, excepciones...
 * - Debes hacer print por consola del resultado de todos los ejemplos.
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea un programa que imprima por consola todos los números comprendidos
 * entre 10 y 55 (incluidos), pares, y que no son ni el 16 ni múltiplos de 3.
 *
 * Seguro que al revisar detenidamente las posibilidades has descubierto algo nuevo.
 */
    

    public static void main(String[] args) {
        
        //-----------------OPERADORES-----------------
        //OPERADORES ARITMÉTICOS

        System.out.println(2 + 7); //Suma +
        System.out.println(9 - 7); //resta -
        System.out.println(5 * 8); //Multiplicación *
        System.out.println(8 / 4); //División /
        System.out.println(8 % 2); //Resto de una división %

        //OPERADORES INCREMENTALES
        int numero = 0;
        // ++ incrementa en uno un número. 
        System.out.println(numero++); //Si se coloca después, primero imprime el número y luego lo suma.
        System.out.println(++numero); //Si lo hace antes, primero suma y luego imprime.

        // -- decrementa en uno un número.
        System.out.println(numero--); //Si se coloca después, primero imprime el número y luego lo resta.
        System.out.println(--numero); //Si lo hace antes, primero resta y luego imprime.

        //OPERADORES DE COMPARACIÓN
        System.out.println(8>5); //mayor que >
        System.out.println(8<5); //menor que <
        System.out.println(8>=5); //mayor o igual que >=
        System.out.println(8<=5); //menor o igual que <= 
        System.out.println(8==5); //igual que ==
        System.out.println(8!=5); //desigual que !=

        //OPERADORES LÓGICOS
        if(8>5 && 4==5) System.out.println("sí"); // && and: compara dos condiciones, tienen que ser true las dos (& compara los dos operandos)
        if(8>5 || 4==5) System.out.println("sí"); // || or: compara dos condiciones, al menos una tiene que ser true ( | compara los dos operandos)
        if(!(8>5)) System.out.println("sí"); // "!" niega el operando. Devuelve true si no se cumple

        //OPERADORES DE ASIGNACIÓN
        numero = 2;  //numero = 2
        numero += 2; //numero le suma 2 y lo iguala al resultado. numero = numero + 2
        numero -= 2; //numero le resta 2 y lo iguala al resultado. numero = numero - 2
        numero *= 2; //numero lo multiplica 2 y lo iguala al resultado. numero = numero * 2
        numero /= 2; //numero lo divide entre 2 y lo iguala al resultado. numero = numero / 2
        numero %= 2; //calcula el resto de numero entre 2 y lo iguala al resultado. numero = numero % 2

        //OPERADORES DE CONCATENACIÓN
        System.out.println("El numero es"+ numero +"."); //se usa + para concatenar Strings

        //OPERADORES DE NIVEL DE BITS
        //'>>': desplazamiento a la derecha de los bits del operando
        numero = 8; // En binario: 00001000
        int resultado = numero >> 2; // Desplaza los bits 2 posiciones a la derecha
        System.out.println(resultado); // Imprime 2 (en binario: 00000010)

        // '<<': desplazamiento a la izquierda de los bits de operando
        numero = 3; // En binario: 00000011
        resultado = numero << 2; // Desplaza los bits 2 posiciones a la izquierda
        System.out.println(resultado); // Imprime 12 (en binario: 00001100)

        // '&': operador and a nivel de bit.
        int numero1 = 5; // En binario: 00000101
        int numero2 = 3; // En binario: 00000011
        resultado = numero1 & numero2; // Realiza la operación AND a nivel de bit
        System.out.println(resultado); // Imprime 1 (en binario: 00000001)

        // '|': operador or a nivel de bit
        numero1 = 5; // En binario: 00000101
        numero2 = 3; // En binario: 00000011
        resultado = numero1 | numero2; // Realiza la operación OR a nivel de bit
        System.out.println(resultado); // Imprime 7 (en binario: 00000111)

        //-----------------ESTRUCTURAS DE CONTROL----------------------------

        //CONDICIONALES
        //IF - ELSE IF - ELSE
        //si...
        if(numero>2){
            System.out.println("Numero es mayor que 2");
        }
        //sino...si...
        else if(numero>5){
            System.out.println("Numero es mayor que 5"); 
        }
        //sino
        else{
            System.out.println("Pues na mi niño");
        }

        //SWITCH CASE
        switch(numero) {
            case 0:
              System.out.println("El numero es 0");
              break;
            case 1:
              System.out.println("El numero es 1");
              break;
            default:
              System.out.println("El número no es 0 ni 1");
          }
        
        //BUCLES
        //WHILE
        numero = 0;
        while(numero < 4){
            System.out.println("Bucle while. Número = " + numero);
            numero++;
        }

        //DO - WHILE
        do{
            System.out.println("Bucle do-while. Número = " + numero);
            numero++;
        }while(numero < 4);

        //FOR
        for(int i = 1; i <= 5; i++){
            System.out.println("Bucle for " + i + " vez");
        }

        //FOR-EACH
        int [] numeros = new int[]{1,2,3};
        for(int num : numeros){
            System.out.println("Bucle for-each, numero: " + num);
        }

        //Manejo de excepciones
        //try-catch
        int[] myNumbers = {1, 2, 3};
        try{
            System.out.println(myNumbers[10]);
        }
        catch(Exception e){
            System.out.println("no hay tal número en el array");
        }
        //finally no es obligatorio, se ejecuta siempre que termina el manejo del error, de error o no
        finally{
            System.out.println("Se acabó el manejo de excepciones");
        }

        //throw
        // if(myNumbers[2] == 3){
        //     throw new ArithmeticException("No puede valer 3 porque me da la gana");
        // }

        //-------------------DIFICULTAD EXTRA-----------------------------------------
        System.out.println("---------------DIFICULTAD EXTRA------------------------");

        for(int i = 10; i <= 55; i++){
            if(i % 2 == 0){
                if(i != 16 && i%3 != 0){
                    System.out.println(i);
                }
            }
        }

    }

}
