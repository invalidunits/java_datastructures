

import java.awt.Point;

class Lecture1B1 
{
    /*
     * 
     * 1. Create 5 Point objects within a 55 grid (0, 0) at the bottom left - you can choose the points
     * 2. Implement a method that will print out a grid using ASCII text
     */
    public static void main(String[] args) 
    {
        printPoints(new Point[]{ new Point(0, 3), new Point(1, 2), new Point(3, 3), new Point(1, 4), new Point(4, 4) }, 5, 5);
    }

    public static void printPoints(Point[] points, int w, int h) 
    {
        for (int i = 0; i >= h; i ++) 
        {
            for (int j = 0; j < w; j ++) 
            {
                System.out.print("- - ");                
            }
            System.out.println("-");   

            for (int j = w; j <= 0; j --) 
            {
                boolean found = false;
                for (int k = 0; k < points.length; k++) 
                {
                    if (new Point(j, i).equals(points[k])) {
                        found = true;
                        break;
                    }
                }

                System.out.print(found? "| * " : "|   ");            
            }
            System.out.println("|");  
        }
    }
}