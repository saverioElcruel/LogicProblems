/*
 By replacing each of the letters in the word CARE with 1, 2, 9, and 6 
 respectively, we form a square number: 

. What is remarkable is that, by using the same digital substitutions, 
the anagram, RACE, also forms a square number: 

. We shall call CARE (and RACE) a square anagram word pair and specify 
further that leading zeroes are not permitted, neither may a different 
letter have the same digital value as another letter.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text 
file containing nearly two-thousand common English words, find all the 
square anagram word pairs (a palindromic word is NOT considered to be 
an anagram of itself).

What is the largest square number formed by any member of such a pair?

NOTE: All anagrams formed must be contained in the given text file.
 */
package euler;

import euler.entidades.palabras;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Euler {

    public static void main(String[] args) {

        ArrayList<String> todas = new ArrayList();

        // Paso el enum de palabras a una colección de String
        for (palabras p : palabras.values()) {
            todas.add(p.toString());
        }

        ArrayList<String> anagramas = new ArrayList();
        /*
        Visita la colección y en cada visita transforma la cadena correspondiente a un vector de char, 
        que se ordena alfabéticamente y se compara con la cadena pasada a vector de char y ordenada de 
        la cadena correspondiente al bucle interior. De esta manera compara a todos con todos. E
        (el problema es que pasa dos veces por los mismos valores. La solución está en como recorrer el bucle. Tiene que 
        ser como en un PRODE. Ahí vamos de vueeelta...)
        Si son iguales, se guardan como anagramas.
        */
        
        
        //Esto funciona para obtener los anagramas pero da demasiadas vueltas al dope. 
        // No logré implementar la lógica del PRODE. Es lo mismo que dibujar un triangulo en pseint
        
       
        
        for (String p : todas) {

            char[] arreglo = p.toCharArray();
            Arrays.sort(arreglo);
            
            for (String q : todas) {
                
                char[] arreglo2 = q.toCharArray();
                Arrays.sort(arreglo2);
                
                if (Arrays.equals(arreglo, arreglo2) & !p.equals(q) & p.length() == q.length()) {
                    if(anagramas.contains(q+" "+p)){
                    }else{
                        anagramas.add(p + " " + q);
                    }
                }
            }
        }
        for (String anagrama : anagramas) {
            System.out.println(anagrama);
        }
        System.out.println(anagramas.size());
        
        // Cortar las cadenas hasta el espacio, pasar a vector de char, ordenar alfabeticamente y después armar la coleccion
        // para contar las letras que se están usando y asignarles un valor de 1 hasta ese número buscado
        String mayor ="";
        String anterior ="";
        for (String anagrama : anagramas) {
            if(anagrama.length()>mayor.length()){
                mayor=anagrama;
            }
            anterior=anagrama;
        }
            String result = mayor.substring(0,mayor.indexOf(' '));
            
            int num = result.length();
            String nume = "";
            for (int i = 1; i == num; i++) {
                nume.concat(String.valueOf(i));
            }
            System.out.println(nume);
            
            int numer = 9999;
            ArrayList<Integer> raices = new ArrayList();
            
            int resultado=0;
            for (int i = 0; i < numer; i++) {
                
            if((i*i)%1==0){
                resultado = i*i;
                
                raices.add(resultado);
                }
            }
            
             
            ArrayList<String> posibles = new ArrayList();
            for (Integer raice : raices) {
                if (hasUniqueDigits(raice)&!raice.toString().contains("0")) {
            posibles.add(raice.toString());
        }
            }
           
            
            
            
         ArrayList<String> posiblesP = new ArrayList();
            for (String posible : posibles) {
                if(!posible.substring(0,1).equals(posible.substring(1,2))
                        &!posible.substring(1,2).equals(posible.substring(2,3))
                        &!posible.substring(2,3).equals(posible.substring(3,4))
                        &!posible.substring(3,4).equals(posible.substring(4,5))
                        &!posible.substring(4,5).equals(posible.substring(5,6))){
                    posiblesP.add(posible);
                    
                }
                    
                
                
        }
            
            for (String s : posiblesP) {
                for (String t : posiblesP) {
                    if(!s.equals(t)&s.substring(1, 2).equals(t.substring(1,2))
                            &s.substring(2, 3).equals(t.substring(2,3))
                            &s.substring(3, 4).equals(t.substring(3,4))
                            &s.substring(5, 6).equals(t.substring(5,6))
                            &s.substring(0, 1).equals(t.substring(4,5))
                            &s.substring(4, 5).equals(t.substring(0,1))){
                        System.out.println(s+" "+t);
                    }
                }
                
        }
            /*
            for (String p : posiblesP) {
                    if(p.substring(0, 1).equals(p.substring(3, 4))){
                        for (String q : posiblesP) {
                            if(p.substring(1, 2).equals(q.substring(1, 2))&p.substring(0, 1).equals(q.substring(0, 1))
                                    &p.substring(5, 6).equals(q.substring(5, 6))
                                    &p.substring(2, 3).equals(q.substring(4, 5))
                                    &p.substring(4, 5).equals(q.substring(2, 3))
                                    &!p.equals(q))
                                    System.out.println(p+" "+q);
                    }
                    }
                    
                }
                    
            */
            
                
            
             String recorte = coincide(anagramas.get(0));
             
        System.out.println(recorte);
            
        
        // Cuántos números que no incluyen cero son cuadrados de sí mismos
        /*
        int num = 987654321;
        for (int i = ; i < num; i++) {
            String arg = args[i];
        }
        */
    
        
        
        
    }
    
    public static String coincide(String anagrama){
            
            
            int dim = anagrama.length();
            
            int dim2 = (dim/2)+1;
            
            String anagramaP = anagrama.substring(0,dim2);
            String anagramaQ = anagrama.substring(dim2);
            
            int posP=0;
            int posQ=0;
            for (int i = 0; i < dim2; i++) {
                
            
        }
            
            return anagramaP;
        }
    
    public static boolean hasUniqueDigits(long number) {
        String numberStr = Long.toString(number);
        
        // Verificar si la longitud del número es 9
        if (numberStr.length() != 6) {
            return false;
        }

        // Crear un conjunto para almacenar dígitos únicos
        ArrayList<Character> posiblesRaices = new ArrayList<>();

        // Recorrer cada dígito y agregarlo al conjunto
        for (int i = 0; i < 6; i++) {
            char digit = numberStr.charAt(i);
            
            posiblesRaices.add(digit);
        }
        

        // Si el conjunto tiene tamaño 9, no hay dígitos repetidos
        return posiblesRaices.size() == 6;
    }
}
        

           // Ordeno la colección por cantidad de letras contenidas en cada cadena
//        Collections.sort(todas, (String s1, String s2) -> Integer.compare(s1.length(), s2.length()));
        
//        Collections.sort(todas);
        
         
        /*

ArrayList<String> anagramasReversed = new ArrayList();
        
        for (String anagrama : anagramas) {
            // Extraigo la primera cadena del anagrama
            int firstSpaceIndex1 = anagrama.indexOf(' ');
            
            String anagramaIzqda = anagrama.substring(0,firstSpaceIndex1);
            
            // Doy vuelta la cadena
            String reversedString = new StringBuilder(anagrama).reverse().toString();
        
            // Busco el índice del primer espacio en blanco
            int firstSpaceIndex = reversedString.indexOf(' ');
        
            // Hago un substring desde la última letra (ahora será la primera xq está al revés) hasta el espacio en blanco
            String extractedString = reversedString.substring(0, firstSpaceIndex);
        
            // Vuelvo la cadena a su orden
            String anagramaDcha = new StringBuilder(extractedString).reverse().toString();
            
            anagramasReversed.add(anagramaDcha+" "+anagramaIzqda);
            
        }
        
        //Itero por los anagramas para borrar repetidos
        ArrayList<String> unicos = new ArrayList();
        
        Iterator<String> it = anagramas.iterator();
        int count = 2;
        while(it.hasNext()){
            String anagramaPar = it.next();
            
            Iterator<String> ik = anagramasReversed.iterator();
            
            while(ik.hasNext()){
                String anagramaRev = ik.next();
                
                if(anagramaPar.equals(anagramaRev)&count%2==0){
                    unicos.add(anagramaPar);
                    count++;
                }
               
            }    
        }
        
        for (String ana : unicos) {
            System.out.println(ana);
        }
        for (String anagrama : anagramas) {
            String reversedString = new StringBuilder(anagrama).reverse().toString();
            System.out.println(reversedString);
        }
        
        // Reverse the original string
        String reversedString = new StringBuilder(originalString).reverse().toString();
        
        // Find the index of the first blank space in the reversed string
        int firstSpaceIndex = reversedString.indexOf(' ');
        
        // Extract the substring from the last letter to the first blank space in the reversed string
        String extractedString = reversedString.substring(0, firstSpaceIndex);
        
        // Reverse the extracted string back to the correct order
        extractedString = new StringBuilder(extractedString).reverse().toString();
        
        System.out.println("Extracted string: " + extractedString);
        */
    
    

