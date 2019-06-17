//Namespace
package com.company;

//Imports
import java.nio.charset.Charset;
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

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
        String current;
        int countVowels = 0;
        int countConsonant = 0;

        //Try statement
        try {

            //Field
            Scanner scan = new Scanner( new File( "lyrics.txt" ) );

            while (scan.hasNext()) {
                current = scan.next();

                StringTokenizer st = new StringTokenizer(current," " + "-" + "," + "(" + ")");

                //Prints out in console the words without
                while(st.hasMoreTokens() ) {
                    System.out.println(st.nextToken());
                }

                //If statement that analyzes the longest word
                if (current.length() > longestWord.length()) {
                    shortestWord = longestWord;
                    longestWord = current;
                }

                //If statement that analyzes the second longest word
                if (current.length() < longestWord.length()) {
                    if (current.length() > shortestWord.length()) {
                        shortestWord = current;
                    }
                }

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
                scan.close();
            }
        //Catch Statement
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file: " + fileName);
        }

        //Try statement for storing the new file with results
        try {
            PrintWriter print = new PrintWriter("results.txt");
            print.println("Longest word: " + longestWord);
            print.println("Second longest: " + shortestWord);
            print.println("Total number of vowels: " + countVowels);
            print.println("Total number of consonants: " + countConsonant);
            print.println("Most repeated word: ");
            print.close();
        }
        //Catch statement
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
