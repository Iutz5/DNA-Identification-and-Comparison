/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DNAAssignment;

/**
 *
 * @author ianut
 */
public class Main {

    /**
     * @param dna1 must include character A,C,T, or G. Any other character will not be included
     * @param dna2 must include character A,C,T, or G. Any other character will not be included
     * @return whether or not an Anti-sense is detected and the percentage of the difference within the two strands.
     */
    public static double differences(String dna1, String dna2) { // Computing the differnece between the DNA Strands
        double difference = 0; // initalizing the variable
        for (int i=0 ; i < smallestString(dna1,dna2).length(); i++) { // for loop to go through each character
            if (dna1.charAt(i) != dna2.charAt(i)) { // only need a change if there is a difference
                difference = difference + 1; // counter marker like the MonteCarloSim
            }
        }
        difference = difference + (largestString(dna1,dna2).length()-smallestString(dna1,dna2).length()) / (double) largestString(dna1,dna2).length();
        return difference; //if the strands start out the same, have to compute the difference after the strand as well
    }
    public static String largestString (String dna1 , String dna2) { // identifying which string is larger
        String longest = dna1;
        if (dna1.length() < dna2.length()) {
                longest = dna2;
            } else if (dna1.length() >= dna2.length()) {
                longest =  dna1;
            }
        return longest; // I couldn't find a method on java so I made them up!
    }
    public static String smallestString (String dna1 , String dna2) { // identifying which string is smaller
        String smallest = dna1;
        if (dna1.length() < dna2.length()) {
                smallest = dna1;
            } else if (dna1.length() >= dna2.length()) {
                smallest =  dna2;
            }
        return smallest;
    }
    public static String reverse(String dna) { // flipping the strand to where it reads right to left
        String result = ""; // start with an empty string and add onto it
        for (int i = dna.length()-1 ; i >= 0 ; i--) { // start at the last letter of the string and work backwards
            result = result + dna.charAt(i); // include zero because that is the first character in the string
        }
        return result;
    }
    public static String detectAntisense(String sense) { // A=T , T=A , C=G, G=C
        String result = ""; // start with an empty string and add onto it as well
        for (int i = 0 ; i < sense.length(); i++) {
            if (sense.charAt(i) == 'T'){
                result = result + 'A';
            } else if (sense.charAt(i) == 'A') {
                result = result + 'T';
            } else if (sense.charAt(i) == 'C') {
                result = result + 'G';
            } else if (sense.charAt(i) == 'G') {
                result = result + 'C';
            }
        }
        return result; // need a new string that modifies the old string so you can make any adjustments without it interefering
    }
        
    public static void main(String[] args) {
        // TODO code application logic here
        String dna1 = "TCGAT"; // examples of DNA strands
        String dna2 = "TCGATC";
        String sense1 = "ATC";
        String sense2 = "CGA";
        System.out.println(differences(dna1,dna2)); // mathamtical percentage of the difference computed as a double
        String complement1 = reverse(sense1);
        String complement2 = reverse(sense2);
        String antisense1 = detectAntisense(complement1);
        String antisense2 = detectAntisense(complement2);
        int indexOf = dna1.indexOf(antisense1); // identifying the anitsense
        if (indexOf >= 0) { // added speech to make it seem as if the computer is talking to the user
            System.out.println("The location of the Antisense " + antisense1 + " begins at character " + (indexOf + 1) + ".");
        } else {
            System.out.println("There is no location of an Antisense");
        }
        
        
       
        
    }
    
}
