package Lecture4A1;

public class Stack<E> {
    private Node<E> top;
    private int count;

    public E peek() 
    {
        return top == null? null : top.value;
    }

    public int getCount() 
    {
        return count;
    }

    public boolean isEmpty()
    {
        return count <= 0;
    }

    public void push(E value) 
    {
        count += 1;
        Node<E> newtop = new Node<E>(value);
        if (top == null) 
        {
            top = newtop;
        }
        else 
        {
            newtop.setNext(top);
            top = newtop;
        }
    }

    public E pop() 
    {
        if (count == 0) 
        {
            return (E)null;
        }
        
        count -= 1;
        E ret = top.value;
        top = top.next;
        if (top == null) count = 0;

        return ret;
    }

    
    Stack() {
        top = null;
        count = 0;
    }
    
}
