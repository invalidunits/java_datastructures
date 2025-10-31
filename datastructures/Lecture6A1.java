public class Lecture6A1 {
 
    public static void main(String[] args)
    {
        int[] coins = new int[]{200, 100, 25, 10, 5};
        System.out.println(minCoinChange(coins, 120));
    }


    public static int minCoinChange(int[] coins, int amount)
    {
        if (amount <= 0) return 0;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++)
        {
            if (coins[i] <= amount)
            {
                // System.out.println(min);   
                min = Math.min(min, 1 + minCoinChange(coins, amount - coins[i]));
            }
        }

        return min;
    }
}