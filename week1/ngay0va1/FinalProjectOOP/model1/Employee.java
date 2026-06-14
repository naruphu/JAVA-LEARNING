package model1;
public class Employee extends Person{
    private double salary;

    public Employee(int id, String name, String mail, double salary){
        super(id, name, mail);
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    @Override
    public void displayInfo(){
        System.out.println(this);
    }
    
    @Override
    public String toString(){
        return "Employee{ id: " + getId() + ", name: " + getName() + ", email: " + getMail() +  ", salary " + salary + " }"; 
    }
}