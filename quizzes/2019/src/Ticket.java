public class Ticket {

    private final int number;
    private final Concert concert;

    public Ticket(int number, Concert concert) throws InvalidTicket{
        if (number < 0) {
            throw new InvalidTicket();
        }
        this.number = number;
        this.concert = concert;
        this.concert.incrementTicketsSold();
    }

    public int getNumber() {
        return this.number;
    }

    public Concert getConcert() {
        return this.concert;
    }
}
