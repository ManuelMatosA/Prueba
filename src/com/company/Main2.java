//Namespace
package com.company;
//Linea que tiene mas palabras
//Imports
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        //Variables for counters
        int countCo = 0;
        int countVo = 0;
        //Variable for the string that stores the contents of the file
        String st;
        String maxLine = null;
        String shortLine = null;
        int maxLength = 0;
        int shortLength = 0;
        int lineCount = 0;
        int locationLong = 0, locationShort = 0;

        try {

            //Fields
            Scanner in = new Scanner(System.in, Charset.defaultCharset());

            //Prompt the user to enter the file or directory name.
            System.out.print( "Enter file or directory name: " );
            String fileName = in.nextLine();

            //Create file class
            File file = new File( fileName );
            //Create Buffered reader class
            BufferedReader br = new BufferedReader( new FileReader( file ) );

            //While loop that reads line by line until there is nothing left to read
            while ((st = br.readLine()) != null) {
                //Turn all letters to lower case with .toLowerCase method
                String readingToLower = st.toLowerCase();

                //Longest line conditional
                if(st.length() > maxLength) {
                    maxLength = st.length();
                    shortLength = maxLength;
                    shortLine = maxLine;
                    maxLine = st;
                    locationLong = lineCount;
                } else if (st.length() < maxLength) { //Shortest line
                    if (st.length() < shortLength) {
                        shortLine = st;
                        shortLength = st.length();
                        locationShort = lineCount;
                    }
                }
                if (st.contains(".")) {
                    break;
                }
                lineCount++;


                //For loops that initializes a counter that increments until it becomes less  than the variable for the string that stores the contents of the file
                for (int i = 0; i < st.length(); i++) {

                    //If statements that allows to only count the vocals
                    if (readingToLower.charAt( i ) == 'a' || readingToLower.charAt( i ) == 'e' || readingToLower.charAt( i ) == 'i' || readingToLower.charAt( i ) == 'o' || readingToLower.charAt( i ) == 'u') {

                        //Counter that stores how many vocals there are
                        countVo++;

                    } else if (String.valueOf(  readingToLower.charAt( i )).matches( "[bcdfghjklmnpqrstvwxyz]" )) {
                        countCo++;
                    }
                    //Else If statements that allows to only count the consonants
//                    } else if (readingToLower.charAt( i ) == 'b' || readingToLower.charAt( i ) == 'c' || readingToLower.charAt( i ) == 'd' || readingToLower.charAt( i ) == 'f' || readingToLower.charAt( i ) == 'g' ||
//                            readingToLower.charAt( i ) == 'h' || readingToLower.charAt( i ) == 'j' || readingToLower.charAt( i ) == 'k' || readingToLower.charAt( i ) == 'l' ||
//                            readingToLower.charAt( i ) == 'm' || readingToLower.charAt( i ) == 'n' || readingToLower.charAt( i ) == 'p' || readingToLower.charAt( i ) == 'q' || readingToLower.charAt( i ) == 'r' ||
//                            readingToLower.charAt( i ) == 's' || readingToLower.charAt( i ) == 't' || readingToLower.charAt( i ) == 'v' || readingToLower.charAt( i ) == 'w' || readingToLower.charAt( i ) == 'x' || readingToLower.charAt( i ) == 'y' || readingToLower.charAt( i ) == 'z') {
//
//                        //Counter that stores how many consonants there are
//                        countCo++;
//                    }
            }
                //Print writer class that creates a new file to store the calculated values
                PrintWriter print = new PrintWriter( "final.txt" );
                //Print in new txt file total consonants
                print.println("Total Consonants: " + countCo );
                //Print in new txt file total vowels
                print.println("Total Vowels: " + countVo );
                //Largest line
                print.println("The largest line is line "  + locationLong + " \"" + maxLine + "\" with a length of " + maxLength + " characters");
                print.println("The largest line is line "  + locationShort + " \"" + shortLine + "\" with a length of " + shortLength + " characters");
                //Close print
                print.close();
            }
        }
        //catch statements
         catch(FileNotFoundException ex){
                System.out.println( "Unable to open file" );
            }
         catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

