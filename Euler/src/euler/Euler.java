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
import java.util.Iterator;

public class Euler {

    public static void main(String[] args) {
        
        ArrayList<String> todas = new ArrayList();
        
        // Paso el enum donde tengo todas las palabras a una colección de String
        for (palabras p : palabras.values()) {
            todas.add(p.toString());               
            }
        
        System.out.println("Todas: "+todas.size());
        
        // Ordeno la colección por cantidad de letras contenidas en cada cadena
        Collections.sort(todas, (String s1, String s2) -> Integer.compare(s1.length(), s2.length()));
        
        ArrayList<String> anagramas = new ArrayList();
       
        // Hago una doble iteración por la colección y en cada vuelta tomo la cadena, la paso a un vector de char, 
        // lo ordeno y lo comparo con la cadena pasada a vector de char del bucle interior. Luego valido. Si son 
        // iguales, guardo las cadenas como anagramas
        for (String p : todas) {
            char[] arreglo = p.toCharArray();
            Arrays.sort(arreglo);
            for (String q : todas) {
                char[] arreglo2 = q.toCharArray();
                Arrays.sort(arreglo2);
                if(Arrays.equals(arreglo, arreglo2)&!p.equals(q)&p.length()==q.length()){
                    anagramas.add(p+" "+q);
                }
            }               
        }
        
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
        
       
        
        
//        Collections.sort(todas);
        
        
        
       
             
        }
        
        
       /*
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
       
            }
                    
        
    
    

