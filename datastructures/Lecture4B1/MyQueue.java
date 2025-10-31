package Lecture4B1;

public class MyQueue<E> {
    private static class Node<E>
    {
        private E value;
        private Node<E> next;
        private Node<E> last;

        public Node(E value) {
            this.value = value;
            this.next = null;
        }

        public E getValue(){
            return this.value;
        }

        public void setValue(E val){
            this.value = val;
        }


        public Node<E> getNext(){
            return this.next;
        }

        public Node<E> getLast(){
            return this.last;
        }

        public void setNext(Node<E> next){
            if (this.next != null) this.next.last = null;
            this.next = next;
            if (this.next != null) this.next.last = this;
        }

        public void setLast(Node<E> last){
            if (this.last != null) this.last.next = null;
            this.last = last;
            if (this.last != null) this.last.next = this;
        }
    }


    private Node<E> head = null;
    private Node<E> tail = null;
    int size = 0;

    public boolean isEmpty() { return this.size == 0; }

    public void enqueue(E value) {
        size += 1;
        Node<E> newNode = new Node<E>(value);
        if (head == null) {
            head = newNode;
        } 

        newNode.setNext(tail);
        tail = newNode;
    }

    public E dequeue() {
        if (tail == null) return null;
        
        E value = this.head.getValue();
        this.head = head.last;
        if (this.head == null)
        {
            head = null;
            size = 0;
        }
        else
        {
            this.head.setNext(head);
            size -= 1;
        }

        
        return value;
    }
}
