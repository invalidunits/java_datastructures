/*
* Create a Class with a couple of field,s a constructor, getters and setters, 
* at least one other type of method. Static fields and methods are optional.
*/

/*
 * Create a main mthod to test your class by creating a couple objects and using their methods. 
 * I recommend a nice toString  method (whic will overload the Objefct toString method)
 * 
 */



public class Lecture1B2 {

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car);
        car.drive();
        car.SetInsured(true);
        System.out.println(car);
        car.drive();
        

        Car car2 = new Car("2025 Volkswagon", 3721, true);
        System.out.println(car2);
        car2.drive();
    }


    static public class Car {
        private String model;
        private double weight;
        private boolean insured;

        Car(String model, int weight, boolean insured) 
        {
            this.model = model;
            this.weight = weight;
            this.insured = insured;
        }

        Car() 
        {
            this.model = "2025 Porshe";
            this.weight = 3424;
            this.insured = false;
        }

        public void drive() {
            if (!insured) {
                System.out.println("You were arrested for driving without proper insurance.");
            } else {
                System.out.println("You drove the " + model + ".");
            }
        }


        public String getModel() {
            return model;
        }

        public double getWeight() {
            return weight;
        }

        public boolean isInsured() {
            return insured;
        }

        public void SetInsured(boolean insured) {
            this.insured = insured; 
        }

        @Override
        public String toString() {
            return model + ", " + weight + " lbs, is" + (insured? "insured." : "not insured.");
        }

        
    }
}
