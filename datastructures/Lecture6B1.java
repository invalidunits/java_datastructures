import java.security.InvalidParameterException;

class Lecture6B1
{


    public static void main(String[] args)
    {
        System.out.println(min(new int[]{1, 2, 3, 4, 5}, 0, 4));
    }

    // public static int min(int[] array) throws InvalidParameterException
    // {
    //     if (array.length <= 0) throw new InvalidParameterException("argument \"array\" must have a positive size");
    //     if (array.length == 1) return array[0];
    //     if (array.length == 2) return Math.min(array[0], array[1]);
    //     int[] left = new int[array.length / 2];
    //     int[] right = new int[array.length - left.length];
    //     System.arraycopy(array, 0,left, 0, left.length);
    //     System.arraycopy(array, left.length, right, 0, right.length);
    //     return Math.min(min(left), min(right));
    // }

    public static int min(int[] array, int low, int high) throws InvalidParameterException
    {
        if (high <= low)
        {
            return array[low];
        }

        
        if (array.length <= 0) throw new InvalidParameterException("argument \"array\" must have a positive size");
        int middle = (high + low) / 2;
        return Math.min(min(array, low, middle), min(array, middle + 1, high));
    }
}