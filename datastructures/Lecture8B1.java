import java.util.HashMap;
import java.lang.String;

public class Lecture8B1 {
    public static class Inventory
    {
        private HashMap<String, Integer> map;
        public Inventory()
        {
            map = new HashMap<>();
        }

        public void addStock(String item, int count)
        {
            if (count < 0) return;
            if (!map.containsKey(item)) map.put(item, count);
        }

        public void increaseStock(String item, int count)
        {
            if (count < 0) return;
            if (!map.containsKey(item)) map.put(item, count);
            else map.put(item, map.remove(item) + count);
        }

        public void removeStock(String item, int count)
        {
            if (map.containsKey(item))
            {
                var finalcount = map.remove(item) - count;
                if (finalcount > 0) map.put(item, finalcount);
            }
        }

        public int getStock(String item)
        {
            if (map.containsKey(item)) return map.get(item);
            return 0;
        }

        public boolean inStock(String name)
        {
            return getStock(name) != 0;
        }

    }
    
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addStock("wrenches", 5);
        inventory.addStock("gerbil feeders", 2);
        inventory.addStock("toilet seats", 1);
        inventory.addStock("electric heaters", 3);

        System.out.println("wrenches in stock: " + inventory.getStock("wrenches"));
        System.out.println("Someone bought a wrench.");
        inventory.removeStock("wrenches", 1);
        System.out.println("wrenches in stock: " + inventory.getStock("wrenches"));
        System.out.println("Someone bought 4 wrenchs.");
        inventory.removeStock("wrenches", 4);
        System.out.println("wrenches in stock: " + inventory.getStock("wrenches"));
        
        System.out.println("gerbil feeders in stock: " + inventory.getStock("gerbil feeders"));
        System.out.println("Recieved new supply of gerbil feeders. ");
        inventory.increaseStock("gerbil feeders", 5);
        System.out.println("gerbil feeders in stock: " + inventory.getStock("gerbil feeders"));
        System.out.println("Any gerbil feeders in stock?: " + inventory.inStock("gerbil feeders"));

    }
}
