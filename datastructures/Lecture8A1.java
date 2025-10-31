public class Lecture8A1 {
    
    public static int key(int x, int min)
    {
        return x - min;
    }

    public static void countingSort(int[] input, int min, int max)
    {
        int k = max - min;
        int[] count = new int[k + 1];
        int[] output = new int[input.length];

        for (int i = 0; i < input.length; i++) 
        {
            count[key(input[i], min)] += 1;
        }

        printArray(count, 0, count.length);

        for (int i = 1; i < k; i++)
        {
            count[i] = count[i] + count[i - 1];
        }
        printArray(count, 0, count.length);

        for (int i = input.length - 1; i >= 0; i--)
        {
            // System.out.println(input[i]);
            // System.out.println(count[input[i]]);

            int key = key(input[i], min);
            count[key] -= 1;

            System.out.println(input[i] + " moving to " + count[key]);
            output[count[key]] = input[i];
        }

        System.arraycopy(output, 0, input, 0, input.length);
    }

    public static void printArray(int[] arr, int begin, int end)
    {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(i == 0? " " : ", ");
            System.out.print(arr[i]);
        }
        System.out.print(" ");
        System.out.println("]");
    }

    public static void main(String[] args)
    {
        int[] x = {1, 6, -1, 7, 5, 9, 2};
        countingSort(x, -1, 10);
        printArray(x, 0, x.length);
    }    
}
