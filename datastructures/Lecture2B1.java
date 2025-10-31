

public class Lecture2B1 {
    public static void main(String[] args) 
    {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        System.out.println(list);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.set(0, 4);
        System.out.println(list);

    }
}