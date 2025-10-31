import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.lang.Integer;

public class Lecture4A2
{
    static public void main(String[] args) 
    {
        Stack<Stack<Integer>> stack = new Stack<Stack<Integer>>();
        stack.push(new Stack<>());
        stack.peek().push(1);
        stack.peek().push(2);
        stack.peek().push(3);
        stack.push(new Stack<>());
        stack.peek().push(4);
        stack.peek().push(5);
        stack.peek().push(6);
        System.out.println(stack);



        Stack<LinkedList<ArrayList<Integer>>> stack2 = new Stack<LinkedList<ArrayList<Integer>>>();
        stack2.push(new LinkedList<ArrayList<Integer>>());
        stack2.peek().push(new ArrayList<Integer>());
        stack2.peek().peek().add(1);
        stack2.peek().peek().add(2);
        stack2.peek().peek().add(3);
        stack2.peek().push(new ArrayList<Integer>());
        stack2.peek().peek().add(4);
        stack2.peek().peek().add(5);
        stack2.peek().peek().add(6);
        stack2.push(new LinkedList<ArrayList<Integer>>());
        stack2.peek().push(new ArrayList<Integer>());
        stack2.peek().peek().add(10);
        stack2.peek().peek().add(11);
        stack2.peek().peek().add(12);
        stack2.peek().push(new ArrayList<Integer>());
        stack2.peek().peek().add(7);
        stack2.peek().peek().add(8);
        stack2.peek().peek().add(9);


        System.out.println(stack2);


    }
}