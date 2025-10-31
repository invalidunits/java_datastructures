import java.util.LinkedList;
import java.util.Queue;
import java.lang.Integer;

public class Lecture4B2 {
    
    public static void main(String[] args) {
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(1);
        queue1.add(2);
        queue1.add(4);
        queue1.add(8);

        while (queue1.peek() != null) 
        {
            System.out.println(queue1.poll());
        }

        Queue<String> queue2 = new LinkedList<>();
        queue2.add("Hello");
        queue2.add("World");
        queue2.add("from");
        queue2.add("Queue");

        while (queue2.peek() != null) 
        {
            System.out.println(queue2.poll());
        }

    }
    
}
