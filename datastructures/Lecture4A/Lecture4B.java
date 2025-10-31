package Lecture4A;

import java.lang.Integer;

public class Lecture4B {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println("Pushing 1 to the stack");
        stack.push(1);
        System.out.println("Pushing 2 to the stack");
        stack.push(2);
        System.out.println("Pushing 3 to the stack");
        stack.push(3);     

        System.out.println("Calling peek()");
        System.out.println("Returned " + stack.peek());

        System.out.println("Calling pop()");
        System.out.println("Returned " + stack.pop());
        
        System.out.println("Calling isEmpty()");
        System.out.println("Returned " + stack.isEmpty());

        System.out.println("Calling pop()");
        System.out.println("Returned " + stack.pop());
        
        System.out.println("Calling getCount()");
        System.out.println("Returned " + stack.getCount());

        System.out.println("Calling pop()");
        System.out.println("Returned " + stack.pop());
        
        System.out.println("Calling isEmpty()");
        System.out.println("Returned " + stack.isEmpty());
    }    
}
