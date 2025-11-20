import java.util.LinkedList;

/**
 * Represents an employee in a company.
 */
public class Employee {

    private final String name;
    private double salary;
    private String position;
    private Employee supervisor;
    private final LinkedList<Employee> employees;

    /**
     * Constructs an employee with the specified name, salary, and position.
     *
     * @param name     the name of the employee
     * @param salary   the salary of the employee
     * @param position the position of the employee
     */
    public Employee(String name, double salary, String position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.supervisor = null;
        this.employees = new LinkedList<>();
    }

    /**
     * Gets the name of the employee.
     *
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the salary of the employee.
     *
     * @return the salary of the employee
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Gets the position of the employee.
     *
     * @return the position of the employee
     */
    public String getPosition() {
        return position;
    }

    /**
     * Gets the supervisor of the employee.
     *
     * @return the supervisor of the employee
     */
    public Employee getSupervisor() {
        return supervisor;
    }

    /**
     * Gets the list of employees supervised by this employee.
     *
     * @return the list of employees supervised by this employee
     */
    public LinkedList<Employee> getEmployees() {
        return employees;
    }

    /**
     * Sets the salary of the employee.
     *
     * @param salary the new salary of the employee
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Sets the position of the employee.
     *
     * @param position the new position of the employee
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Sets the supervisor of the employee.
     *
     * @param supervisor the new supervisor of the employee
     */
    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    /**
     * Hires a new employee under this employee's supervision.
     *
     * @param employee the employee to be hired
     */
    public void hireEmployee(Employee employee) {
        // TODO: complete this method for PART 1

        if (!employees.contains(employee))
        {
            employee.supervisor = this;
            employees.add(employee);
        }
        


    }

    /**
     * Calculates the total number of employees supervised by this employee.
     *
     * @return the total number of employees supervised by this employee
     */
    public int numOfEmployees() {
        // TODO: complete this method for PART 1
        int count = employees.size();
        for (Employee employee : employees)
        {
            count += employee.numOfEmployees();
        }
        return count;
    }
    
    /**
     * Prints the employees supervised by this employee. Display it nicely with
     * correct formatting. The depth will help you space it out.
     * (Hint: you want to visit all employees in a specific order)
     *
     * Example:
     * A
     *      B
     *      C
     *          D
     *          E
     *      F
     *
     * (Hint: count the nodes in your tree from this point on - DFS)
     * @param depth the depth of the employee in the hierarchy
     */
    public void printEmployees(int depth) {
        // TODO: implement this method for PART 1

        System.out.println("    ".repeat(depth) + position + ", " + name + " ( $" + salary + " )");
        depth += 1;
        for (Employee employee : employees)
        {
            employee.printEmployees(depth);
        }

    }

    /**
     * Simulates the employee leaving the company and promoting the necessary
     * replacements.
     */
    public void leaveCompany() {
        if (this.getSupervisor() == null) {
            System.out.println("The CEO cannot leave the company!");
        } else {
            promoteSeniorEmployee(this);
        }
    }

    /**
     * Promotes the senior-most employee in the hierarchy under the specified supervisor.
     * This method recursively promotes the first employee found in the supervisor's direct reports,
     * adjusting their position, supervisor, and salary, and reassigning their subordinates to the promoted employee.
     * If the promoted employee has subordinates, the method recursively promotes them as well.
     *
     * The order of seniority MUST be maintained. Seniority is noted by position on a team (i.e. the index of their
     * position in the employees list). So when someone is promoted, they should join the end of the supervisor's list,
     * not take the place of the person they replace. Also, when someone gets promoted over their peers, their peers
     * should be added to their list of employees before their newly promoted replacement.
     *
     * Example: Bob supervises Chris, Danielle, and Eric; Chris supervises Frances and Gerry; the structure would be:
     *      Bob
     *          Chris
     *              Frances
     *              Gary
     *          Danielle
     *          Eric
     *
     *  But after Bob leaves, and we apply the promotions, it would be:
     *      Chris
     *          Danielle
     *          Eric
     *          Frances
     *              Gary
     *
     * @param employee The supervisor whose senior-most employee is to be promoted.
     */
    public void promoteSeniorEmployee(Employee employee) {
        // TODO: implement this method for PART 2
        
        var new_super = employee.supervisor;
        new_super.employees.remove(employee);
        
        if (!employee.employees.isEmpty())
        {
            var firstSenior = employee.employees.peekFirst();
            firstSenior.promoteSeniorEmployee(firstSenior);
            firstSenior.position = employee.position;
            firstSenior.salary = employee.salary;

            
            new_super.hireEmployee(firstSenior);
            boolean hassubsenior = !firstSenior.employees.isEmpty();

            for (Employee sub_employee : employee.employees)
            {
                if (sub_employee != firstSenior) 
                {
                    firstSenior.hireEmployee(sub_employee);
                }
            }
            employee.employees.clear();

            if (hassubsenior) firstSenior.employees.add(firstSenior.employees.remove()); // move subsenior to the bottom
        }

    }


}
