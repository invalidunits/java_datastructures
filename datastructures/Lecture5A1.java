public class Lecture5A1 {
    // recursive factorial can take a 
    public static int factorial(int i)
    {
        if (i <= 0) return 1;
        return i*factorial(i-1);
    }
    
    public static int factorial_old(int i)
    {
        int n = 1;
        for (; i != 0; i--)
        {
            n *= i;
        }

        return n;
    }

    public static void main(String[] args)
    {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 16; i++)
        {
            System.out.println(i + "! = " + String.valueOf(factorial_old(i)));
        }

        System.out.println("Completed in " + (System.currentTimeMillis() - time) + "ms");

        long time2 = System.currentTimeMillis();
        for (int i = 0; i < 16; i++)
        {
            System.out.println(i + "! = " + String.valueOf(factorial(i)));
        }   
        System.out.println("Completed in " + (System.currentTimeMillis() - time2) + "ms");
    }
}
