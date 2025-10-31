import java.util.LinkedList;
import java.util.List;

public class Lecture6A2 {
 
    public static void main(String[] args)
    {
        int[] coins = new int[]{1, 2, 3};
        System.out.println(powerset(coins));
    }


    public static LinkedList<LinkedList<Integer>> powerset(int[] set)
    {
        LinkedList<LinkedList<Integer>> accumulate = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        accumulate.add(temp);
        backtrack(accumulate, temp, set, 0);
        return accumulate;
    }


    public static void backtrack(LinkedList<LinkedList<Integer>> accumulate, LinkedList<Integer> temp, int[] set, int cursor)
    {
        if (cursor >= set.length)
        {
            return;
        }
        
        System.out.println(String.valueOf(cursor) + ": " + temp.toString());
        temp.add(set[cursor]);
        accumulate.add(new LinkedList<>(temp));
        backtrack(accumulate, temp, set, cursor + 1);
        
        temp.removeLast();
        backtrack(accumulate, temp, set, cursor + 1);
    }


}