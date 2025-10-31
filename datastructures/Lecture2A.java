
import java.awt.Point;
import java.util.ArrayList;

public class Lecture2A {
    public static void main(String[] args) {
        int[] arr = { 72, 3, 5, 16, 21 };
        Point[] points = new Point[5];
        for (int i = 0; i < points.length; i++)
        {
            points[i] = new Point(i, i*2);
        }        

        System.out.println(points[2]);

        for (Point x : points) {
            System.out.println((x));
        }


        ArrayList<Character> list = new ArrayList<Character>();
        list.add('A');
        list.add('@');
        list.add('j');
        list.add('s');

        list.set(0, 'K');
        
        System.out.println(list);

        

    }
}
