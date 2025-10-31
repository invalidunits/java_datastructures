import java.io.FileWriter;
import java.util.Random;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class

public class Lecture7B2 {
    public static int pivotmode = 0;
    // public static int selectPivot(int begin, int end)
    // {
    //     switch (pivotmode) 
    //     {
    //         case 0:
    //         default:
    //             return begin;
    //         case 1:
    //             return end - 1;
    //         case 2:
    //             return (begin + end) / 2;
    //         case 3:
    //             Random random = new Random();
    //             return random.nextInt(end - begin) + begin;
    //     }   
    // }

    public static void quickSort(int list[], int begin, int end)
    {
        if ((end - begin) <= 1) return;
        int pivot = partition(list, begin, end);
        quickSort(list, begin, pivot - 1);
        quickSort(list, pivot + 1, end);
    }

    public static int partition(int list[], int begin, int end) 
    {
        int pivot = (begin + end) / 2;
        int pivotVal = list[pivot];

        int finalPivot = begin;
        // bring all values less than the pivot to the start of the list
        for (int i = begin; i < end; i++)
        {
            if (list[i] < pivotVal)
            {
                swap(list, i, finalPivot);
                finalPivot++; 
            }
        }

        swap(list, finalPivot, pivot);
        return finalPivot;
    }

    public static void mergeSort(int[] arr, int begin, int end)
    {
        int len = (end - begin);
        if (len <= 1) return;

        int middle = (begin + end)/2;
        mergeSort(arr, begin, middle);
        mergeSort(arr, middle, end);


        if (arr[middle - 1] > arr[middle])
        {
            int[] temp = new int[end - begin];
            int i = begin;
            int j = middle;
            for (int k = begin; k < end; k++)
            {
                if (i < middle && (j >= end || arr[i] <= arr[j]))
                {
                    temp[k - begin] = arr[i];
                    i++;
                }
                else
                {
                    temp[k - begin] = arr[j];
                    j++;
                }
            }

            for (int k = begin; k < end; k++)
            {
                arr[k] = temp[k - begin];
            }
        }
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

    public static void swap(int list[], int A, int B)
    {
        if (A == B) return;
        int temp = list[A];
        list[A] = list[B];
        list[B] = temp;
    }

    public static void generateRandomList(int list[], int size)
    {
        Random random = new Random();
        for (int i = 0; i < size; i++)
        {
            list[i] = random.nextInt();
        }
    }

    
    public static class Dummy {
        public void m() {
        }
    }


    protected static void warmUPJVM() {
        for (int i = 0; i < 100000; i++) {
            Dummy dummy = new Dummy();
            dummy.m();
        }
    }


    public static void main(String args[]) throws IOException
    {
        warmUPJVM();

        int listsize = 10;
        for (int i = 1; i < 7; i++)
        {
            listsize *= 10;
        }

        int samples = 5;


        // final sorting size will by 100mB
        int[] list = new int[listsize];
        int[] list2 = new int[listsize];

        FileWriter myWriter = new FileWriter("results.txt");

        listsize = 10;
        for (int i = 1; i < 7; i++)
        {  
            
            listsize *= 10;
            myWriter.write(String.valueOf(listsize) + ", ");  
            for (int j = 0; j < samples; j++)
            {

                generateRandomList(list, listsize);
                System.arraycopy(list, 0, list2, 0, listsize);

                long startns = System.currentTimeMillis();
                mergeSort(list, 0, listsize); 
                long time = System.currentTimeMillis() - startns;
                myWriter.write(String.valueOf(time) + ", ");
                System.out.println("Merge sort finished " + listsize + " size list in " + time + "ms");
                startns = System.currentTimeMillis();
                quickSort(list2, 0, listsize);
                time = System.currentTimeMillis() - startns;
                myWriter.write(String.valueOf(time));
                System.out.println("Quick sort finished " + listsize + " size list in " + time + "ms");
                System.gc();
                myWriter.write("\n");  
            }
            
        }

        myWriter.flush();
        myWriter.close();

    }
}
