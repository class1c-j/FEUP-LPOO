import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concert {
    private final String city;
    private final String country;
    private final String date;
    private final List<Act> acts = new ArrayList<>();
    private int ticketsSold = 0;

    public Concert(String city, String country, String date) {
        this.city = city;
        this.country = country;
        this.date = date;
    }

    public void incrementTicketsSold() {
        ++this.ticketsSold;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return Objects.equals(city, concert.city) && Objects.equals(country, concert.country) && Objects.equals(date, concert.date) && Objects.equals(acts, concert.acts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, date, acts);
    }

    public void addAct(Act act) {
        this.acts.add(act);
    }

    public List<Act> getActs() {
        return this.acts;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDate() {
        return date;
    }

    public boolean isValid(Ticket ticket){
        return ticket.getConcert() == this;
    }

    public boolean participates(Artist artist) {
        for (Act act : this.acts) {
            if (act instanceof Artist) {
                if (act.equals(artist)) return true;
            } else {
                if (((Band) act).containsArtist(artist)) {
                    return true;
                }
            }
        }
        return false;
    }
}
