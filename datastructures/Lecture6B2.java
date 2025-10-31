import java.security.InvalidParameterException;

class Lecture6B2
{
    public static void main(String[] args)
    {
        System.out.println(sum(new int[]{1, 2, 3, 4, 5}, 0, 4));
    }

    public static int sum(int[] array, int low, int high)
    {
        if (high <= low)
        {
            return array[low];
        }

        int middle = (high + low) / 2;
        return sum(array, low, middle) + sum(array, middle + 1, high);
    }
}