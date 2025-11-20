public class TestCompany {
    public static void main(String[] args)
    {
        Employee ceo = new Employee("Alice", 200000, "CEO");
        Employee director1 = new Employee("Bob", 150000, "Director");
        ceo.hireEmployee(director1);

        Employee manager11 = new Employee("Eve", 120000, "Manager");
        director1.hireEmployee(manager11);

        manager11.hireEmployee(new Employee("Ivy", 100000, "Employee"));
        manager11.hireEmployee(new Employee("Javk", 100000, "Employee"));

        Employee manager12 = new Employee("Frank", 120000, "Manager");
        director1.hireEmployee(manager12);
        manager12.hireEmployee(new Employee("Kate", 100000, "Employee"));


        Employee director2 = new Employee("Carrie", 150000, "Director");
        ceo.hireEmployee(director2);
        Employee manager2 = new Employee("Grace", 120000, "Manager");
        director2.hireEmployee(manager2);
        manager2.hireEmployee(new Employee("Liam", 100000, "Employee"));

        Employee director3 = new Employee("David", 150000, "Director");
        ceo.hireEmployee(director3);
        Employee manager3 = new Employee("Harry", 120000, "Manager");
        director3.hireEmployee(manager3);
        manager3.hireEmployee(new Employee("Mia", 100000, "Employee"));
        Company company = new Company("Company Inc.", ceo);
        company.printCompany();
    }   
}
