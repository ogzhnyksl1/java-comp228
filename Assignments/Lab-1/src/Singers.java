public class Singers {
    private int id;
    private String name;
    private String address;
    private String dob; // string to keep it simple
    private int albumsPublished;

    // no argument constructor
    public Singers() {
        this.id = 0;
        this.name = "Unknown";
        this.address = "Unknown";
        this.dob = "Unknown";
        this.albumsPublished = 0;
    }

    // 1 argument
    public Singers(int id) {
        this();
        this.id = id;
    }

    // 2 arguments
    public Singers(int id, String name) {
        this(id);
        this.name = name;
    }

    // 3 arguments
    public Singers(int id, String name, String address) {
        this(id, name);
        this.address = address;
    }

    // 4 arguments
    public Singers(int id, String name, String address, String dob) {
        this(id, name, address);
        this.dob = dob;
    }

    // 5 arguments
    public Singers(int id, String name, String address, String dob, int albumsPublished) {
        this(id, name, address, dob);
        this.albumsPublished = albumsPublished;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getAlbumsPublished() {
        return albumsPublished;
    }

    public void setAlbumsPublished(int albumsPublished) {
        this.albumsPublished = albumsPublished;
    }

    // 1 setter for all fields
    public void setAll(int id, String name, String address, String dob, int albumsPublished) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.albumsPublished = albumsPublished;
    }
}
