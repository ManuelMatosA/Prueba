//Namespace
package com.company;

//Imports
import java.nio.charset.Charset;
import java.util.Scanner;
import java.io.*;


//Main Class
public class Main {


    public static void main(String [ ] args) {

        //Fields
        Scanner in = new Scanner(System.in, Charset.defaultCharset());

        //Prompt the user to enter the file or directory name.
        System.out.print( "Enter file or directory name: " );
        String fileName = in.nextLine();

        //Variables
        String longestWord = "";
        String shortestWord = "";
        int countVowels = 0;
        int countConsonant = 0;
        int count = 0;
        int maxCount = 0;
        String repeat;


        //Try statement
        try {
            //Read the whole file all at once
            String current = new Scanner( new File( fileName ) )
                    .useDelimiter( "\\A" ).next();

            //Convert
            String toLower = current.toLowerCase();
            String special = toLower.replace( "-" + "," + ", " + "'", " " );
            String[] words = special.split( " ", 0 );

            //Find most repeated character
            char[] chars = current.toCharArray();
            int max = 0;
            for (char i: chars)
                if (chars[i] > max)
                    max = chars[i];
            int mostRepeated = chars[max];


            //Longest and shortest word loop
            for (int p = 0; p < words.length; p++) {
                for (int j = 1 + p; j < words.length; j++) {

                    //Longest word conditional
                    if (words[p].length() >= words[j].length()) {
                        longestWord = words[p];
                        shortestWord = longestWord;
                    }

                    //Shortest word conditional
                    if (words[p].length() < words[j].length()) {
                        if (words[p].length() < shortestWord.length()) {
                            shortestWord = words[p];
                        }
                    }
                }
            }


           /* //Determine the most repeated word in a file
            for(int i = 0; i < words.length; i++){
                count = 1;
                //Count each word in the file and store it in variable count
                for(int j = i+1; j < words.length; j++){
                    if(words.(i).equals(words.(j))){
                        count++;
                    }
                }
                if(count > maxCount){
                    maxCount = count;
                    repeat = words(i);
                }
            }

*/
            //For loop that analyzes vocals
            for (int i = 0; i < current.length(); i++) {
                if (current.charAt( i ) == 'a' || current.charAt( i ) == 'e' || current.charAt( i ) == 'i' || current.charAt( i ) == 'o' || current.charAt( i ) == 'u') {
                        countVowels++;
                }
            }

            //For loop that analyzes consonants
            for (int j = 0; j < current.length(); j++) {
                if (current.charAt( j ) == 'b' || current.charAt( j ) == 'c' || current.charAt( j ) == 'd' || current.charAt( j ) == 'f' || current.charAt( j ) == 'g' || current.charAt( j ) == 'h' ||
                    current.charAt( j ) == 'j' || current.charAt( j ) == 'k' || current.charAt( j ) == 'l' || current.charAt( j ) == 'm' || current.charAt( j ) == 'n' || current.charAt( j ) == 'p' ||
                    current.charAt( j ) == 'q' || current.charAt( j ) == 'r' || current.charAt( j ) == 's' || current.charAt( j ) == 't' || current.charAt( j ) == 'v' || current.charAt( j ) == 'w' ||
                    current.charAt( j ) == 'x' || current.charAt( j ) == 'y' || current.charAt( j ) == 'z') {
                        countConsonant++;
                }
            }
        }

        //Catch Statement
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file: " + fileName);
        }

        //Try statement for storing the new file with results
        try {
            //Creates new file
            PrintWriter print = new PrintWriter("results.txt");
            //Prints longest word
            print.println("Longest word: " + longestWord + " with " + longestWord.length() + " characters");
            //Prints second longest word
            print.println("Shortest word: " + shortestWord + " with " + shortestWord.length() + " characters");
            //Prints total numbers of vowels
            print.println("Total number of vowels: " + countVowels);
            //Prints total number of consonants
            print.println("Total number of consonants: " + countConsonant);
            //Prints most repeated character
            print.println("Most repeated character: ");
            print.println("Most repeated word: ");
            //Terminate close
            print.close();
        }
        //Catch statement
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
/*char[] chars = current.toCharArray();
            int max = 0;
            for (char i: chars)
            if (chars[i] > max) {
                max = chars[i];
            }
            System.out.println(chars[max]);
*/
