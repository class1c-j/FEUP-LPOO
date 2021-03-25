import java.util.ArrayList;
import java.util.List;

public class Party extends Event {

    private List<Event> events = new ArrayList<>();

    public Party(String title) {
        super(title);
    }

    public Party(String title, String date) {
        super(title, date);
    }

    public Party(String title, String date, String description) {
        super(title, date, description);
    }

    public void addEvent(Event e) {
        events.add(e);
    }

    @Override
    public int getAudienceCount() {
        int count = 0;
        for (Event event : events) {
            count += event.getAudienceCount();
        }
        count += super.getAudienceCount();
        return count;
    }
}
