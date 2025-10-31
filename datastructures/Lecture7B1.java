public class Lecture7B1 
{
    public static int selectPivot(int begin, int end)
    {
        // random pivot
        // return (int)Math.floor(Math.random()*(end - begin)) + begin;

        // // first element pivot
        // return begin;

        // // last element pivot
        // return end - 1;
       
        // median 
        return (begin + end) / 2;
    }

    public static void quickSort(int list[], int begin, int end)
    {
        if ((end - begin) <= 1) return;
        int pivot = partition(list, begin, end);
        quickSort(list, begin, pivot - 1);
        quickSort(list, pivot + 1, end);
    }

    public static int partition(int list[], int begin, int end) 
    {
        int pivot = selectPivot(begin, end);;
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

    public static void swap(int list[], int A, int B)
    {
        if (A == B) return;
        int temp = list[A];
        list[A] = list[B];
        list[B] = temp;
    }


    public static void printArray(int[] arr, int begin, int end) {
        System.out.print("[");

        for(int i = begin; i < end; ++i) {
            System.out.print(i == begin ? " " : ", ");
            System.out.print(arr[i]);
        }

        System.out.print(" ");
        System.out.println("]");
    }


    public static void main(String[] args)
    {
        int[] x = {1, 6, -1, 7, 5};
        printArray(x, 0, x.length);
        quickSort(x, 0, x.length);
        System.out.print("Final array: ");
        printArray(x, 0, x.length);

    }
}