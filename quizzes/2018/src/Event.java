import java.util.*;

public class Event {
    private String title;
    private String description = "";
    private String date = "";

    private final List<Person> people = new ArrayList<>();

    public Event(String title) {
        this.title = title;
    }

    public Event(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public Event(Event event) {
        this.title = event.title;
        this.date = event.date;
        this.description = event.description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title + " is a " + this.description + " and will be held at " + this.date + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(title, event.title) && Objects.equals(description, event.description) && Objects.equals(date, event.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, date);
    }

    public void addPerson(Person person) {
        if (!people.contains(person)) {
            people.add(person);
        }
    }

    public int getAudienceCount() {
        return people.size();
    }
}
