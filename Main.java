import java.util.ArrayList;

abstract class Employee
 {
    private String name;
    private  int id;

    public Employee(String name, int id)
    {
         this.name = name;
         this.id = id;
    }
    // method -- it is behaving like encapsulation
    public String getName()
    {
      return name;
    }
    public int getId()
    {
     return id;
    }

    public abstract double calculateSalary();// --- method

    //overriding the toString() method because it is already inbuilt in java
    // that is why to use the toSting() we have done such a thing
    @Override
    public String toString ()
    {
        return "Employee [name="+name+",id="+id+",salary =" + calculateSalary()+"]";
    }
 }
 class fullTimeEmployee extends Employee
 {
     private double monthlySalary;

     public fullTimeEmployee(String name, int id , double monthlySalary) //Constructor--
     {
         super(name,id);// it is used as a reference variable to refer the immediate parent class object
         this.monthlySalary= monthlySalary;
     }

     @Override
     public double calculateSalary()
     {
         return monthlySalary;
     }
 }
 class partTimeEmployee extends Employee
 {
    private int hoursWorked;
    private double hourlyRate;

    // Constructor
     public partTimeEmployee(String name,int id,int hoursWorked, double hourlyRate)
     {
         super(name, id);
         this.hoursWorked = hoursWorked;
         this.hourlyRate = hourlyRate;
     }
      @Override
      public double calculateSalary()
      {
       return hourlyRate*hoursWorked;
      }
 }
 class PayRollSystem
 {
     private ArrayList<Employee> employeeList;

     public PayRollSystem()// constructor
     {
         employeeList = new ArrayList<>();
     }

     // add employee in a list
     public void addEmployee(Employee employee)
     // we made This -- class (Employee) list type.
     // and in that list we will put an object
     //of (Employee) that's why I have made a [employee] as object to store in list
     {
        employeeList.add(employee);// we can add employee in a list
     }

     // we are using another methode to remove the employee for the list
      public void removeEmployee(int id)
      {
          Employee employeeToRemove = null;
          // we are using (foreach) this to search the ID
          // so that we can remove that particular Employee
          for (Employee employee: employeeList)
          {
              if (employee.getId()== id)
              {
                 employeeToRemove = employee;
                 break;
              }
              if(employeeToRemove != null)
              {
               employeeList.remove(employeeToRemove);
              }

          }

      }
       // In this method :---->
      // we are using (foreach) this to search the ID
      // so that we can remove that particular Employee
     public void displayEmployee()
     {
         for (Employee employee : employeeList)
         {
             System.out.println(employee);
         }

     }
 }


public class Main
 {
    public static void main(String[] args)
    {
        PayRollSystem payRollSystem = new PayRollSystem();
        fullTimeEmployee emp1 = new fullTimeEmployee("Alok", 23001, 55000.0);
        partTimeEmployee emp2 = new partTimeEmployee("Vandana",23006, 40, 200 );

        // Now I am going to add variable(employee) in arraylist
        // using add method
        payRollSystem.addEmployee(emp1);
        payRollSystem.addEmployee(emp2);
        // Now we are going to get the employee to see who is working
        System.out.println("Initial employee details: ");
        payRollSystem.displayEmployee();
        System.out.println("Removing the employee");
        payRollSystem.removeEmployee(1);
        System.out.println("Remaining the employee details: ");
        payRollSystem.displayEmployee();


    }

 }