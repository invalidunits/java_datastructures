import java.util.LinkedList;
import java.util.List;

class Lab5
{
    public static void printArray(Burrito[] arr)
    {
        System.out.print("[ ");
        boolean first = false;
        for (Burrito burrito : arr)
        {
            String size = burrito.getSize();
            String type = burrito.getProtein();
            type = (type != "none"? type : "") + " burrito";
            if (first)
            {
                System.out.print(", ");
            }
            else 
            {
                first = true;
            }

            System.out.print(size + " " + type);
        }
        System.out.println(" ]");
    }

    

    public static void printList(LinkedList<Burrito> list)
    {
        System.out.print("[ ");
        boolean first = false;
        for (Burrito burrito : list)
        {
            String size = burrito.getSize();
            String type = burrito.getProtein();
            type = (type != "none"? type : "") + " burrito";
            if (first)
            {
                System.out.print(", ");
            }
            else 
            {
                first = true;
            }

            System.out.print(size + " " + type);
        }
        System.out.println(" ]");
    }

    public static int compareBurritos(Burrito a, Burrito b)
    {
        boolean aLarge = a.getSize() == "large";
        boolean bLarge = b.getSize() == "large";
        if (aLarge != bLarge) return aLarge? -1 : 1;
        if (b.getSize() == "large" && a.getSize() != "large") return 1;
        return a.getProtein().compareTo(b.getProtein());
    }

    public static void mergeSortBurrito(Burrito[] array, int begin, int end)
    {
        if ((end - begin) <= 1) return;
        int middle = (begin + end)/2;
        mergeSortBurrito(array, begin, middle);
        mergeSortBurrito(array, middle, end);
        
        Burrito[] temp = new Burrito[end - begin];
        int i = begin;
        int j = middle;
        for (int k = begin; k < end; k++)
        {
            if (i < middle && (j >= end || (compareBurritos(array[i], array[j]) <= 0)))
            {
                temp[k - begin] = array[i];
                i++;
            }
            else
            {
                temp[k - begin] = array[j];
                j++;
            }
        }

        for (int k = begin; k < end; k++)
        {
            array[k] = temp[k - begin];
        }
    }

    public static void quickSortBurrito(List<Burrito> list)
    {
        if (list.size() <= 1) return;
        int pivot = list.size()/2;
        Burrito pivotVal = list.get(0);
        int finalPivot = 0;
        // bring all values less than the pivot to the start of the list
        for (int i = 0; i < list.size(); i++)
        {
            if (compareBurritos(list.get(i), pivotVal) < 0)
            {
                Burrito temp = list.get(finalPivot);
                list.set(finalPivot, list.get(i));
                list.set(i, temp);
                finalPivot++; 
            }
        }

        Burrito temp = list.get(finalPivot);
        list.set(finalPivot, list.get(pivot));
        list.set(pivot, temp);
        pivot = finalPivot;

        quickSortBurrito(list.subList(0, finalPivot));
        quickSortBurrito(list.subList(finalPivot, list.size()));
    }



    public static void main(String[] args)
    {
        // Test Case 1: Empty array
        Burrito[] emptyArray = new Burrito[0];
        System.out.println("Empty array test:");
        printArray(emptyArray);

        // Test Case 2: Array with one item
        Burrito[] singleArray = { new Burrito("small", "chicken") };
        System.out.println("\nSingle-item array test:");
        printArray(singleArray);

        // Test Case 3: Array with multiple items
        Burrito[] burritoArray = {
                new Burrito("small", "chicken"),
                new Burrito("large", "platypus"),
                new Burrito("large", "beef"),
                new Burrito("small", "steak")
        };
        System.out.println("\nMulti-item array test:");
        printArray(burritoArray);

        System.out.println("\nTesting merge sort:");
        mergeSortBurrito(burritoArray, 0, burritoArray.length);
        printArray(burritoArray);




        // Test Case 4: Empty LinkedList
        LinkedList<Burrito> emptyList = new LinkedList<>();
        System.out.println("\nEmpty list test:");
        printList(emptyList);

        // Test Case 5: LinkedList with one item
        LinkedList<Burrito> singleList = new LinkedList<>();
        singleList.add(new Burrito("large", "carnitas"));
        System.out.println("\nSingle-item list test:");
        printList(singleList);

        // Test Case 6: LinkedList with multiple items
        LinkedList<Burrito> burritoList = new LinkedList<>();
        burritoList.add(new Burrito("small", "chicken"));
        burritoList.add(new Burrito("large", "platypus"));
        burritoList.add(new Burrito("large", "beef"));
        burritoList.add(new Burrito("small", "steak"));

        System.out.println("\nMulti-item list test:");
        printList(burritoList);
        
        System.out.println("\nTesting quick sort:");
        quickSortBurrito(burritoList);
        printList(burritoList);
    }
}