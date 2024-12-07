package exercise1;

public class Player {
    private int playerId;
    private String firstName;
    private String lastName;

    // Constructor
    public Player(int playerId, String firstName, String lastName) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
