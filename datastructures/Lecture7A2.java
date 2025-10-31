import java.lang.Integer;

public class Lecture7A2
{

    public static void mergeSort(String[] arr, int begin, int end)
    {
        int len = (end - begin);
        if (len <= 1) return;

        int middle = (begin + end)/2;
        mergeSort(arr, begin, middle);
        mergeSort(arr, middle, end);


        if (arr[middle - 1].compareTo(arr[middle]) > 0)
        {
            String[] temp = new String[end - begin];
            int i = begin;
            int j = middle;
            for (int k = begin; k < end; k++)
            {
                if (i < middle && (j >= end || (arr[i].compareTo(arr[j]) <= 0)))
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

    public static void printArray(String[] arr, int begin, int end)
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
        String[] x = {"action", "radiation", "ballet", "needle", "conductor", "wage", "recycle", "name", "vegetation", "fastidious"};
        mergeSort(x, 0, x.length);
        printArray(x, 0, x.length);

    }    
}
