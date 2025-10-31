import java.io.Console;
import java.util.Scanner;

public class SillyStrings {
    public static int countVowels(String str)
    {
        
        if (str.length() <= 0) return 0;
        if (str.length() == 1) return "aeiouAEIOU".contains(str.substring(0, 1))?  1 : 0;
        else if (str.length() <= 0) return 0;

        int middle = str.length()/2;
        return countVowels(str.substring(0, middle)) + countVowels(str.substring(middle, str.length()));
    }
    
    public static String reverse(String str)
    {
        System.out.println(str);
        if (str.length() <= 0) return "";
        if (str.length() == 1) return str;
        int middle = str.length()/2;
        return reverse(str.substring(middle, str.length())) + reverse(str.substring(0, middle));
    }

    public static String interleaveChar(String str, char ch)
    {
        if(str.length() == 1) return str;
        return  str.substring(0, 1) + String.valueOf(ch) + interleaveChar(str.substring(1), ch);
    }
    public static void main(String[] args)
    {
        Scanner ioscan = new Scanner(System.in);
        boolean cont = true;
        while (cont)
        {
            System.out.println("Welcome to the SillyStrings");
            System.out.println("1. countVowels");
            System.out.println("2. reverse");
            System.out.println("3. interleaveChar");
            System.out.println("0. exit");
            System.out.print("Choose an Option? ");
            int i = ioscan.nextInt();
            Console console = System.console();
            char inputchar = '\0';
            String input = "";
            switch (i) {
                case 0:
                    cont = false; 
                    break;

                case 1:
                    System.out.print("Enter a string? ");
                    input = console.readLine();
                    System.out.println(input + " has " + countVowels(input) + " vowels");
                    break;

                case 2:
                    System.out.print("Enter a string? ");
                    input = console.readLine();
                    System.out.println("The reverse of " + input + " is " + reverse(input));
                    break;

                case 3:
                    System.out.print("Enter a string? ");
                    input = console.readLine();
                    System.out.print("Enter a char? ");
                    inputchar = (char)console.readLine().charAt(0);
                    System.out.println("The interleave of " + input + " with " + inputchar + " is " + interleaveChar(input, '-'));
                    break;
                    
            
                default:
                    System.out.println("Invalid input.");
            }

            continue;
        }

        ioscan.close();
    }
}
