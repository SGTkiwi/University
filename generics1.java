import java.awt.*;
import java.util.*;
abstract class Animal {
    public abstract void canDo();
  }
  class Snake extends Animal {
    public void canDo() { System.out.println("I can crawl"); }
  }
  class Dog extends Animal {
    public void canDo() { System.out.println("I can bark"); }
  }
  class Lion extends Animal {
    public void canDo() { System.out.println("I can roar");}
  }
  class AnimalHouse<E>{
    private E animal;

    public AnimalHouse(){}
    public AnimalHouse(E a){
        this.animal = a;
    }

    public E getAnimal(){return animal;}
    public void setAnimal(E obj){this.animal = obj;}
    public String toString(){
        return String.format("%s", animal.getClass().getSimpleName());
    }
  }

  class Person implements Comparable<Person> {
    protected String name="", irdNumber="";
    public Person(String name, String irdNumber) {
      this.name = name;
      this.irdNumber = irdNumber;
    }
    public String toString() { return String.format("%s(%s)", name, irdNumber); }
    public int compareTo(Person p) {
      return name.compareTo(p.name);
    }
  }
  class Employee extends Person {
    protected double weeklySalary;
    public Employee(String n, String ird, double salary) {
      super(n, ird);
      weeklySalary = salary;
    }
  }
  

public class generics1 {
    public static void main(String[] args) {
        Employee[] array = new Employee[]{new Employee("Jane Graff", "245-123-345", 1200), new Employee("Dick Smith", "999-222-111", 980), new Employee("Mike Hill", "123-456-789", 1500)};
        Employee e = getMaxEntry(array);
        System.out.println(e);
    }

    private static <T extends Person> T getMaxEntry(T[] people) {
        T current = people[0];
        int compare = 0;
        for (int i = 1; i < people.length; i++) {
            int x = current.compareTo(people[i]);
            if (x < compare) {
                current = people[i];
                compare = x;
            }
        }
        return current;
    }

    private static <T> int getCount(T[] array, T target) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                sum++;
            }
        }
        return sum;
    }
}
