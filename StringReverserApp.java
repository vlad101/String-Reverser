/*****************************************************************************************
 * The String Reverse in-place Program.                                                  *
 * @author: Vladimir Efros                                                               *
 * This program gives a simple demonstration of the reverse                              *
 * of the string separated by delimeter whitespace using string split function           *
 * and StringTokenizer. It splits the Stirng at the whitespace and reverses each string  *
 * The Original String: Hello World!  --> The modified String: olleH !dlroW              *
 *****************************************************************************************/

import java.util.Scanner;
import java.util.StringTokenizer;

class StringReverser
{
    private String str;                     // The string entered by the user
    private String[] splitter;              // The string array containing splitted strings of string str
    private int count;                      // The number of String objects created
    
    /**
     * The Constructor method creates a String Object
     * @param s The String Literal entered by the user.
     * @param c The object counter.
     */
    public StringReverser(String s, int c)
    {
        str = s;
        count = c;
        splitter = new String[str.length()];
    }
    
    /**
     * The spliStr method splits the string.
     */
    public void splitStr()
    {
        splitter = str.split(" ");
    }
    
    /**
     * The getSplitStr method displays a splitted 
     * string separated by the comma delimeters.
     */
    public void getSplitStr()
    {
        System.out.print("The Splitted String " + count + ": ");
        for(int i = 0; i < splitter.length; i++)
        {
            System.out.print(splitter[i]);
            if(i < splitter.length - 1)
                System.out.print(", ");
        }
        System.out.println();                    
    }
    
    /**
     * @return The reversed String using an array split function.
     */
    public String displayRevStringSplit()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("The Reversed String using a split string function: " + count + ": ");
        for(int i = 0; i < splitter.length; i++)
        {
            for(int j = splitter[i].length() - 1; j >= 0; j--)
                builder.append(splitter[i].charAt(j));
            if(i < splitter.length - 1)
                builder.append(" ");
        }
        return builder.toString();
    }
    
     /**
     * @return The reversed String using a StringTokenizer.
     */
    public String displayRevStringTokenizer()
    {
        String st = "The Reversed String using StringTokenizer " + count + ": ";
        StringTokenizer tokenizer = new StringTokenizer(str);
        while(tokenizer.hasMoreTokens())
        {
            String str = tokenizer.nextToken();
            for(int i = str.length() - 1; i >= 0; i--)
                st += str.charAt(i);
            st += " ";
        }
        return st;
    }
    
    /**
     * @return The original string entered by the user.
     */
    public String displayStr()
    {
        return str;
    }
    
    /**
     * A string counter.
     */
    public static int amount = 1;
    
    /**
     * The scanner class is used for the input
     */
    public static Scanner keyboard = new Scanner(System.in);
    
    /**
     * The getString method gets the string from the user.
     * @return The string entered by the user.
     */
    public static String getString()
    {
        String st = "";
        do
        {
            System.out.print("Enter the string " + amount + ": ");
            st = keyboard.nextLine();
            if(st == null || st.length() < 1)
                System.out.println("Wrong String! Try again!");
        }
        while(st == null || st.length() < 1);  
        amount++;
        return st;
    }
}

    /**
     * The Program Test Driver.
     */
public class StringReverserApp
{
    public static void main(String[] args)
    {        
        // Get the amount of strings.
        final int SIZE = validateInteger("Enter the number of Strings to be reversed: ");  // the amount of StringReversers
        
        // create an array of StringReverser Objects
        StringReverser[] reversers = new StringReverser[SIZE];
        
        // Create a new object for each string
        for(int i = 0; i < reversers.length; i++)                                 // For each StringReverser Object
            reversers[i] = new StringReverser(StringReverser.getString(), i + 1); // Get the Strings from the user
        System.out.println();
        
        for(int i = 0; i < reversers.length; i++)                // For each StringReverser Object 
        {
            System.out.println("The Original String " + (i + 1) + ": " + reversers[i].displayStr());   // Display Original String
            reversers[i].splitStr();                                                                   // Split the String into strings
            reversers[i].getSplitStr();                                                                // Display Splitted String
            System.out.println(reversers[i].displayRevStringSplit());                                  // Display Reversed String using an array split function
            System.out.println(reversers[i].displayRevStringTokenizer());                              // Display Reversed String using an array split function
            System.out.println();
        }         
    }
    
     /**
     * The validateInteger method validates the integer format of the number.
     * @param str The message prompt asking to enter the number.
     * @return The x in the proper integer format.
     * @exception NumberFormatException when x has a wrong integer format.
     */
    public static int validateInteger(String str)
    {
        int x = 0;
        boolean b = true;
        do
        {
            try
            {
                do
                {
                    b = true;
                    System.out.print(str);
                    x = Integer.parseInt(StringReverser.keyboard.next());
                    StringReverser.keyboard.nextLine();  // consume a line
                    if(x <= 0)
                        System.out.println("Enter a number greater than 0! Try again!");
                }
                while(x <= 0);
            }
            catch(NumberFormatException nfe)
            {
                b = false;
                System.out.println("Wrong Value! Try again!");
            }
        }while(b == false); 
        return x;
    }
}
