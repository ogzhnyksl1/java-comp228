//also created a Main driver class to test the singers
// by creating a Singers object, displaying its default values,
// modifying them using setters, and printing the updated values to show the results.

public class Main {
    public static void main(String[] args) {
        // no argument constructor
        Singers singer1 = new Singers();

        // default values
        System.out.println("Default values:");
        displaySingerDetails(singer1);

        //setters
        singer1.setId(1);
        singer1.setName("Freddie Mercury");
        singer1.setAddress("London, UK");
        singer1.setDob("5 September 1946");
        singer1.setAlbumsPublished(15);

        // updated values
        System.out.println("\nUpdated values:");
        displaySingerDetails(singer1);
    }

    // details of a Singer obj
    public static void displaySingerDetails(Singers singer) {
        System.out.println("ID: " + singer.getId());
        System.out.println("Name: " + singer.getName());
        System.out.println("Address: " + singer.getAddress());
        System.out.println("Date of Birth: " + singer.getDob());
        System.out.println("Albums Published: " + singer.getAlbumsPublished());
    }
}
