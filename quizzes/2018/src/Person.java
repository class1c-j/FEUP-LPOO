import java.util.Objects;

public abstract class Person extends User implements Comparable {
    private final String name;
    private int age;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.setUsername(name + age);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.getName());
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Person)o).getName());
    }
}
