public class SinglyLinkedList<E> {

    Node<E> head;
    int size;

    public SinglyLinkedList() {
      this.head = null;
      size = 0;
    }

    public void add(E val){
      if (size == 0) {
        size = 1;
        head = new Node<>(val);
        return;
      }
      
      Node<E> cur = head; 
      while (cur.getNext() != null) { cur = cur.getNext(); } 
      cur.setNext(new Node<>(val));
    }

    public E get(int ind){
      Node<E> cur = head; 
      if (cur == null) return null;
      while (cur.getNext() != null && (--ind >= 0)) { cur = cur.getNext(); } 
      return cur.value;
    }

    public void set(int ind, E val) throws ArrayIndexOutOfBoundsException {
      Node<E> cur = head; 
      while (cur.getNext() != null && (--ind >= 0)) { cur = cur.getNext(); } 
      if (cur != null) {
        cur.value = val;
        return;
      }

      if (cur == null && ind == -1) {
        add(val);
        return;
      }

      throw new ArrayIndexOutOfBoundsException();
    }

    public E remove(int ind) throws ArrayIndexOutOfBoundsException {
      ind -= 1;
      Node<E> cur = head; 
      while (cur.getNext() != null && (--ind >= 0)) { cur = cur.getNext(); } 
      if (cur != null && cur.next != null) {
        E ret = cur.next.value;
        cur.next = cur.next.next;
        return ret;
      }

      throw new ArrayIndexOutOfBoundsException();
    }

    public int size(){
      return size;
    }

    public boolean contains(E val){
      for (Node<E> cur = head; cur != null; cur = cur.getNext()) { 
        if (cur.value == val) return true;
      } 

      return false;
    }

    public int indexOf(E val){
      return -1;
    }

    public void clear(){
      head = null;
    }

    public String toString() {
      String list = "[ ";
      for (Node<E> cur = head; cur != null; cur = cur.getNext()) { 
        list += cur.value.toString();
        if (cur.next != null) {
          list += ", ";
        }
      } 

      return list += " ]";
    }


}