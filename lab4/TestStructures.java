import java.io.Console;

class TestStructures 
{
    public static void main(String[] args)
    {
        Stack stack = new Stack();
        Queue queue = new Queue();

        for (int i = 1; i <= 5; i++)
        {
            System.out.println("pushing " + i + " to the stack.");
            stack.push(i);
        }

        while (!stack.isEmpty())
        {
            System.out.println("popped " + stack.pop() + " off the stack");
        }

        for (int i = 1; i <= 3; i++)
        {
            System.out.println("pushing " + i + " to the stack.");
            stack.push(i);
        }

        while (!stack.isEmpty())
        {
            int val = (Integer)stack.pop();
            System.out.println("popped " + val + " off the stack. enqueueing...");
            queue.enqueue(val);
        }

        while (!queue.isEmpty())
        {
           System.out.println("dequeueing " +  queue.dequeue() + " from the queue.");
        }

        System.out.println("dequeueing " +  queue.dequeue() + " from the queue.");
        System.out.println("popped " + stack.pop() + " off the stack.");
    }
}