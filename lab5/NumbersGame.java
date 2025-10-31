import java.util.Scanner;

public class NumbersGame 
{
    public static int reduceToSingleDigit(int num)
    {
        num = num <= 0? num : (num % 10) + reduceToSingleDigit(num/10);
        if (num >= 10)
        {
            return reduceToSingleDigit(num);
        }

        return num;
    }

    public static int reverseFactorial(int num, int div)
    {
        return num <= 1? div - 1 : reverseFactorial(num/div, div + 1);
    }

    public static int sumSquaresDigits(int num) 
    {
        return (num <= 0)? 0 : (num % 10)*(num % 10) + sumSquaresDigits(num/10);
    }

    public static void main(String[] args)
    {
        Scanner ioscan = new Scanner(System.in);
        boolean cont = true;
        while (cont)
        {
            System.out.println("Welcome to the Numbers Game");
            System.out.println("1. reduceToSingleDigit");
            System.out.println("2. reverseFactorial");
            System.out.println("3. sumSquaresDigits");
            System.out.println("0. exit");
            System.out.print("Choose an Option? ");
            int i = ioscan.nextInt();
            int input = 0;
            switch (i) {
                case 0:
                    cont = false; 
                    break;

                case 1:
                    System.out.print("Enter a number? ");
                    input = ioscan.nextInt();
                    System.out.println("The single-digit reduction of " +  input + " is " + reduceToSingleDigit(input));
                    break;

                case 2:
                    System.out.print("Enter a number? ");
                    input = ioscan.nextInt();
                    System.out.println(input + " is the factorial of " + reverseFactorial(input, 2));
                    break;

                case 3:
                    System.out.print("For which value (int)? ");
                    input = ioscan.nextInt();
                    System.out.println(input + " is the factorial of " + sumSquaresDigits(input));
                    break;
                    
            
                default:
                    System.out.println("Invalid input.");
            }

            continue;
        }

        ioscan.close();
    }
}
