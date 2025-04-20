package creationalPattern.prototypePattern.solution;
//ALL LAYER COPY ONLY FOR NON-PRIMITIVES
class Address {
    private String city;

    Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}

class Employee implements Cloneable {
    private String name;
    private Address address;
    

    Employee(String name, String city) {
        this.name = name;
        address = new Address(city);
    }

    public Employee clone() throws CloneNotSupportedException {
        Employee emp = (Employee) super.clone();
        emp.address = new Address(emp.address.getCity());
        return emp;
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

    public void setAddress(String city) {
        address.setCity(city);
    }

}

public class deep {
    public static void main(String[] args) throws CloneNotSupportedException {

        Employee originalObject = new Employee("Shreya", "Gurgaon");

        Employee clonedObject = originalObject.clone();

        System.out.println("\noriginalObject " + originalObject.getName() + " " + originalObject.getAddress().getCity());
        System.out.println("clonedObject " + clonedObject.getName() + " " + clonedObject.getAddress().getCity());

        clonedObject.setName("tanisha");
        clonedObject.setAddress("Azamgarh");

        System.out.println("\nAfter the modification ");

        System.out.println("\noriginalObject " + originalObject.getName() + " " + originalObject.getAddress().getCity());
        System.out.println("clonedObject " + clonedObject.getName() + " " + clonedObject.getAddress().getCity());

    }

}