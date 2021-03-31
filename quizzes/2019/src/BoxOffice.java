import java.util.ArrayList;
import java.util.List;

public class BoxOffice {

    public static List<Ticket> buy(Concert concert, int n) throws InvalidTicket {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            tickets.add(new Ticket(1 + concert.getTicketsSold(), concert));
        }
        return tickets;
    }
}
