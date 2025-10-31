package Lecture4B1;

import java.lang.Integer;

public class Lecture4B1 {
    public static void main(String[] args)
    {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("queue.dequeue(): " + queue.dequeue());
        System.out.println("queue.dequeue(): " + queue.dequeue());
        System.out.println("queue.dequeue(): " + queue.dequeue());
    }
}
