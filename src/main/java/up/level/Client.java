package up.level;

public class Client {
    private int id;
    private String name;
    private String lastName;
    private Integer ticketId;

    public Client(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ticketId=" + ticketId +
                '}';
    }
}
