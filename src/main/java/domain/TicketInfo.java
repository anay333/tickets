package domain;

public class TicketInfo implements Comparable<TicketInfo> {
    private int id;
    private String from;
    private String to;
    private int price;
    private int travelTime;

    public TicketInfo() {

    }

    public TicketInfo(int id, String arrivalAirport, String departureAirport, int price, int travelTime) {
        this.id = id;
        this.to = arrivalAirport;
        this.from = departureAirport;
        this.price = price;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public int compareTo(TicketInfo o) {
        TicketInfo t = o;

        return this.price - t.price;
    }
}
