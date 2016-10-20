/**
* Created by Anton Avraamov on 16.10.2016.
*/

public class Homework04{

    public static void main(String[] args) {

        Employee[] arrEmployee = new Employee[5];
        arrEmployee[0] = new Employee("Pupkin Vasil", "General Director", "pup@bk.com","89758374", 190000, 50);
        arrEmployee[1] = new Employee("Maria Ivanoff", "Accountant", "supermasha@mail.com","9465273", 50000, 55);
        arrEmployee[2] = new Employee("Petr Kodov", "Developer", "pk@bk.com","3143143", 90000, 35);
        arrEmployee[3] = new Employee("Ann Testova", "Tester", "megatest@mail.com","84657239", 40000, 25);
        arrEmployee[4] = new Employee("Sidr Sidorov", "Cleaner", "cleanme@bk.com","84657239", 20000, 65);

        for (int i = 0; i<arrEmployee.length; i++){
            if (arrEmployee[i].getAge() > 40){
                arrEmployee[i].printEmp();
            }
        }
    }
}

    /**
    * class Employee
    */
class Employee {

    private String name;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    /**
    * Constructor for Employee
    */

    public Employee(String name, String position, String email, String phone, double salary, int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    /**
    * Getter for age
    */
    public int getAge(){
        return this.age;
    }

    /**
    * Printing employee information
    */
    public void printEmp(){
        System.out.println(
            "Name: " + this.name + 
            "\nPosition: " + this.position +
            "\nEmail: " + this.email +
            "\nPhone: " + this.phone +
            "\nSalary: " + this.salary +
            "\nAge: " + this.age);
        System.out.println();
    }
}