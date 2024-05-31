public class Ejercicio_programacion_06 {
/*
 * EJERCICIO:
 * Entiende el concepto de recursividad creando una función recursiva que imprima
 * números del 100 al 0.
 *
 * DIFICULTAD EXTRA (opcional):
 * Utiliza el concepto de recursividad para:
 * - Calcular el factorial de un número concreto (la función recibe ese número).
 * - Calcular el valor de un elemento concreto (según su posición) en la 
 *   sucesión de Fibonacci (la función recibe la posición).
 */

    public static void main(String[] args) {
        //imprimeNumero(100);
        //System.out.println(calcularFactorial(5));
        //System.out.println(fibonacci(7));

    }

    //EJERCICIO: imprimirá a partir del número pasado por parámetro, números hasta llegar al 0
    public static void imprimeNumero(int num){
        if(num>=0){
            System.out.print(num + " ");
            imprimeNumero(num - 1);
        }
        else{
            System.out.println("FIN DEL PROGRAMA");
        }
    }

    //DIFICULTAD EXTRA factorial de un número
    public static int calcularFactorial(int num){
        if(num<0){
            throw new IllegalArgumentException("No se puede calcular el factorial de un número negativo");
        }
        else if(num == 0){
            return 1;
        }
        else{
            return num * calcularFactorial(num - 1);
        }
        
    }

    //DIFICULTAD EXTRA fibonacci
    public static int fibonacci(int num){
        
        if(num >=2){
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
        else if(num == 1){
            return 1;
        }else if(num == 0){
            return 0;
        }
        else{
            throw new IllegalArgumentException("No se puede hacer Fibonacci de un número negativo");
        }
        
    }

}
