import java.util.Objects;

public class Attendee extends Person {

    private boolean hasPaid;

    public Attendee(String name, int age) {
        super(name, age);
    }

    public Attendee(String name) {
        super(name);
    }

    public boolean hasPaid() {
        return hasPaid;
    }

    @Override
    public String toString() {
        return "Attendee " + this.getName() + (this.hasPaid ? " has" : " hasn't") + " paid its registration.";
    }

}
