//P1
// Create an array of 25 int values
// populate it using a for loop to contain increasing powers of 2 beginning at 0
// Print out your list of powers of 2 using a loop to. access the elements in that format.


// P2 
// Same thing as P1 except use an object



import java.awt.Point;

public class Lecture2A1 {

    public static void main(String[] args) 
    {
        // Part 1
        int[] arr = new int[25];

        // populate the array
        for (int i = 0; i < arr.length; i++) 
        {
            if (i == 0) 
            {
                arr[0] = 1;
            }
            else 
            {
                arr[i] = arr[i-1]*2;
            }
        }

        // print it out
        for (int i = 0; i < arr.length; i++) 
        {
            if (i != 0) {
                System.out.print(", ");
            }

            System.out.print(arr[i]);
        }
        System.out.println();

        // Part 2
        Lecture1B2.Car[] parr = new Lecture1B2.Car[25];

        // populate the array
        for (int i = 0; i < parr.length; i++) 
        {
            parr[i] = new Lecture1B2.Car("Honda #" + (i + 1), i*2, true);
        }

        // print it out
        for (int i = 0; i < parr.length; i++) 
        {
            parr[i].drive(); 
        }

        System.out.println();
    }
}
