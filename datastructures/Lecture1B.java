

import java.awt.Point;

public class Lecture1B {
    // public static void main(String[] args) 
    // {   
    //     Point p1 = new Point(5, 7);
    //     Point p2 = new Point(6, 9);

    //     System.out.println(p1);    
    //     System.out.println(p2);

    //     p1.move((int)p2.getX(), (int)p2.getY());

    //     System.out.println(p1);    
    //     System.out.println(p2);
    // }

    // public static String printPoint(Point p)
    // {
    //     return "(" + p.getX() + ", " + p.getY() + ")";
    // }

    public static void main(String[] args) 
    {
        Paper p1 = new Paper();
        Paper p2 = new Paper(36, 24, false, 100);

        System.out.println(p1);
        System.out.println(p2);
        
    }


    public static class Paper {
        private double height;
        private double width;
        private boolean lined;
        private double weight;

        public Paper() {
            this.height = 11.0;
            this.width = 8.5;
            this.lined = false;
            this.weight = 20.0;
        }

        public Paper(double height, double width, boolean lined, double weight) {
            this.height = height;
            this.height = width;
            this.lined = lined;
            this.weight = weight;
        }
        
        @Override
        public String toString() 
        {
            return width + "x" + height + ", " + this.weight + "lb " + (lined? "lined " : "") + "paper";
        }
    }    
}
