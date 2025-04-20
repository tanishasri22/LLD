package creationalPattern.prototypePattern.solution;
//TOP LAYER COPY ONLY FOR NON-PRIMITIVES
class Address {
    private String city;

    Address(String city){
        this.city = city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }
}

class Employee implements Cloneable {
    private String name;
    private Address address;

    Employee(String name, String city){
        this.name = name;
        address = new Address(city);
    }

    @Override
    public Employee clone() throws CloneNotSupportedException{
        return (Employee)super.clone();
    }

    public void setAddress(String city) {
        this.address.setCity(city);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}

public class shallow {
    public static void main(String[] args) throws CloneNotSupportedException{
        Employee employee = new Employee("Tanisha", "Gurgaon");

        Employee clonedEmployee = (Employee) employee.clone();

        System.out.println("\nEmployee: "+employee.getName() +", " + employee.getAddress().getCity());
        System.out.println("Cloned employee: " + clonedEmployee.getName() + ", " + clonedEmployee.getAddress().getCity());

        clonedEmployee.setName("Alex");
        clonedEmployee.setAddress("Delhi");

        System.out.println("\nAfter modification to cloned object compare the primitive and non-primitive:");
        System.out.println("Employee: " + employee.getName() + ", " + employee.getAddress().getCity());
        System.out.println("Cloned employee: " + clonedEmployee.getName() + ", " + clonedEmployee.getAddress().getCity());

    }
}