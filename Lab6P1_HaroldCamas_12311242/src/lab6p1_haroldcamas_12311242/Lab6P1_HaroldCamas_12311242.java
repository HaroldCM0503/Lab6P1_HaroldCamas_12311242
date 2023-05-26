/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_haroldcamas_12311242;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author harol
 */
public class Lab6P1_HaroldCamas_12311242 {

    /**
     * @param args the command line arguments
     */
    static Scanner leer = new Scanner(System.in);
    static Scanner cadena = new Scanner(System.in);
    static Random ran = new Random();
    
    public static void main(String[] args) {
        int opcion = 0;
        boolean seguir = true;
        
        while(seguir){
            opcion = menu();
            
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el tamaño del arreglo: ");
                    int tamaño = leer.nextInt();
                    
                    //Validacion del tamaño.
                    if (tamaño <= 0){
                        System.out.println("El tamaño tiene que ser superior a 0.");
                        break;
                    }
                    
                    //Validacion del limite inferior.
                    System.out.println("Ingrese el limite inferior de los numeros: ");
                    int inferior = leer.nextInt();
                    if (inferior <= 0){
                        System.out.println("El limite inferior debe de ser mayor que 0.");
                        break;
                    }
                    
                    //Validacion del limite superior.
                    System.out.println("Ingrese el limite superior de los numeros: ");
                    int superior = leer.nextInt();
                    if (superior <= 0 || superior <= inferior){
                        if (superior <= 0){
                            System.out.println("El limite superior debe de ser mayor que 0.");
                        }
                        else{
                            System.out.println("El limite superior debe de ser mayor que el inferior.");
                        }
                        break;
                    }
                    //Fin validaciones.
                    
                    int [] array = genRandArray(tamaño,inferior,superior);
                    System.out.println("El arreglo generado es: ");
                    Imprimir(array);
                    
                    int [] arreglo_primos = getTotalPrimeCount(array);
                    System.out.println("El conteo de primos es: ");
                    Imprimir (arreglo_primos);
                    break;
                    
                case 2:
                    System.out.println("Introduzca su palabra: ");
                    String palabra = cadena.next();
                    int codigo = 0;
                    boolean valido = false;
                    
                    //Validacion
                    for (int i = 0; i < palabra.length(); i++){
                        codigo = palabra.charAt(i);
                        if ((codigo >= 97 && codigo <= 122) || (codigo == 65533)){
                            valido = true;
                        }
                        else{
                            valido = false;
                            break;
                        }
                    }
                    if (valido == false){
                        System.out.println("La cadena no es valida");
                        break;
                    }
                    else{
                        System.out.println("La cadena es valida.");
                    }
                    //Fin validacion.
                    
                    Imprimir_2(ArrayLetras());
                    int[] Frecuencia = extraerFrecuencias(palabra);
                    Imprimir(Frecuencia);
                    
                    break;
                    
                case 3:
                    seguir = false;
                    break;
                    
                default:
                    System.out.println("Elija una opcion valida");
                    break;
            }
        }
       
    }
    
    public static int menu(){
        int op = 0;
        System.out.println("");
        System.out.println("1.)Ejercicio 1");
        System.out.println("2.)Ejercicio 2");
        System.out.println("3.)Salir");
        op = leer.nextInt();
        return op;
    }
    
    public static int[] genRandArray(int tamaño, int inferior, int superior){
        int [] array = new int[tamaño];
        for (int i = 0; i < array.length; i++ ){
            int randInt = ran.nextInt(superior - inferior) + inferior;
            array[i] = randInt;
        }
        return array;
        
    }
    
    public static void Imprimir(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++){
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }
    
    public static void Imprimir_2(char[] arreglo){
        for (int i = 0; i < arreglo.length; i++){
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }
    
    public static boolean isPrime(int numero){
        boolean es_primo = true;
        for (int i = 2; i < numero; i++){
            if (numero%i == 0){
                es_primo = false;
            }
        }
        return es_primo;
    }
    
    public static int countPrimeFactors(int numero){
        int contador = 0;
        boolean primo = true;
        for (int i = 2; i <= numero; i++){
            if (numero%i == 0){
                primo = isPrime(i);
                if (primo == true){
                contador++;
                }
            }
            
        }
        return contador;
    }
    
    public static int[] getTotalPrimeCount(int[] arreglo){
        int[] conteo = new int[arreglo.length];
        for (int i = 0; i < arreglo.length; i++){
            conteo[i] = countPrimeFactors(arreglo[i]);
        }
        return conteo;
    }
    
    public static char [] ArrayLetras(){
        char [] letras = new char[27];
        char codigo_char = 97;
        for (int i = 0; i < 26; i++){
            letras[i] = codigo_char;
            codigo_char ++;
        }
        letras[26] = 65535;
        return letras;
    }
    
    public static int[] extraerFrecuencias(String cadena){
        int [] Frecuencias = new int[27];
        int contador = 0;
        int ASCII = 97;
        int charpal = 0;
        
        //Aqui hago un for principal que representa las letras a-z y que por cada una de esas lea la palabra entera y cuente cuantas veces sale la letra de turno.
        for (int i = 0; i < 26; i++){
            for (int j = 0; j < cadena.length(); j++){
                charpal = cadena.charAt(j);
                if (charpal == ASCII){
                    contador++; 
                }
            }
            Frecuencias[i] = contador;
            contador = 0;
            ASCII++;
        }
        //Por ultimo un for especial para leer los caracteres especiales.
        for (int j = 0; j < cadena.length(); j++){
            charpal = cadena.charAt(j);
            if (charpal == 65533){
                contador++;
            }
        }
        Frecuencias[26] = contador;
        return Frecuencias;
    }
        
}
