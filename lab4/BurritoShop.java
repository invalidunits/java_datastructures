class BurritoShop
{
    private Queue ordersQueue;
    private Queue unprocessedTransactions;
    private Stack uncleanDishes;

    BurritoShop()
    {
        ordersQueue = new Queue();
        unprocessedTransactions = new Queue();
        uncleanDishes = new Stack();
    }

    public void takeOrder(Burrito order)
    {
        ordersQueue.enqueue(order);
        unprocessedTransactions.enqueue(order);
        uncleanDishes.push("a plate");
    }

    public void makeNextOrder()
    {
        if (ordersQueue.getSize() <= 0)
        {
            System.out.println("No more orders available.");
            return;
        }

        
        uncleanDishes.push("a spoon");

        Burrito burrito = (Burrito)ordersQueue.dequeue();
        System.out.println("Serving " + burrito.toString());
    }

    public void ringOutTransaction()
    {
        if (unprocessedTransactions.getSize() <= 0)
        {
            System.out.println("No more transactions to ring out.");
            return;
        }

        Burrito burrito = (Burrito)unprocessedTransactions.dequeue();
        double cost = burrito.getCost();
        System.out.println("Your burrito will cost: " + cost);
    }

    public void washDish()
    {
        if (uncleanDishes.getSize() <= 0)
        {
            System.out.println("No more dishes to wash.");
            return;
        }

        String dish = (String)uncleanDishes.pop();
        System.out.println("Washing  " + dish);
    }

    public void washAllDishs()
    {
        while (anyDishs()) washDish();
    }

    public boolean anyDishs()
    {
        return !uncleanDishes.isEmpty();
    }

    public int orderCount()
    {
        return ordersQueue.getSize();
    }
     
    public int transactionCount()
    {
        return unprocessedTransactions.getSize();
    }
}