public class RuntimePolymorphism {
public static void main(String[] args) {
    Person p = new Person("Ranjith", 24, 70.5f);
    p.showDetails();
    Person e = new Employee("Ranjith", 50000.0f);
    e.showDetails();
}
    
}
class Person {
    String name;
    int age;
    float weight;

    Person(String name, int age, float weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    void showDetails() {
        System.out.println("Person Details");
        System.out.println("Name: " + name + " Age: " + age + " Weight: " + weight);
    }
}

class Employee extends Person {
    String empid;
    float salary;

    Employee(String name, float salary) {
        super(name, 0, 0.0f);
        this.salary = salary;
    }

    Employee(String name, int age, float weight, float salary) {
        super(name, age, weight);
        this.salary = salary;
    }

    @Override
    void showDetails() {
        System.out.println("Employee Details");
        System.out.println("Name: " + name + " Salary: " + salary);
    }
}
