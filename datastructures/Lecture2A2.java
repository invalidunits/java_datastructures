//P1
// Create an arraylist of 25 int values
// populate it using a for loop to contain increasing powers of 2 beginning at 0
// Print out your list of powers of 2 using a loop to. access the elements in that format.


// P2 
// Same thing as P1 except use an object



import java.util.ArrayList;

public class Lecture2A2 {

    public static void main(String[] args) 
    {
        // Part 1
        ArrayList<Integer> list = new ArrayList<>();

        // populate the array
        for (int i = 0; i < 25; i++) 
        {
            if (list.isEmpty()) 
            {
                list.add(1);
            }
            else 
            {
                list.add(list.get(list.size() - 1)*2);
            }
        }


        System.out.println(list);

        // Part 2
        ArrayList<Lecture1B2.Car> parr = new ArrayList<>();

        // populate the array
        for (int i = 0; i < 25; i++) 
        {
            parr.add(new Lecture1B2.Car("Honda #" + (i + 1), i*2, true));
        }

        // print it out
        for (int i = 0; i < parr.size(); i++) 
        {
            parr.get(i).drive(); 
        }

        System.out.println();
    }
}
