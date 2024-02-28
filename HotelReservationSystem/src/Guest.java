import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Guest {
    private Connection connection;
    private Scanner scanner;

    public Guest(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }
    public void reserveRoom(){
        try{
            System.out.println("Enter guest name :");
            String guestName = scanner.next();
            System.out.println("Enter Room no :");
            int roomNumber = scanner.nextInt();
            System.out.println("Enter Contact no :");
            String contactNumber = scanner.next();

            String query = "INSERT INTO reservations (guest_name, room_number, contact_number) " +
                    "VALUES ('" + guestName + "', " + roomNumber + ", '" + contactNumber + "')";

            Statement statement = connection.createStatement();
            int affectedRows = statement.executeUpdate(query);

            if(affectedRows > 0){
                System.out.println("Reservation Successful !");
            }else {
                System.out.println("Reservation Failed !");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void exit() throws InterruptedException {
        System.out.print("Exiting System");
        int i = 5;
        while(i!=0){
            System.out.print(".");
            Thread.sleep(1000);
            i--;
        }
        System.out.println();
        System.out.println("ThankYou For Using Hotel Reservation System!!!");
    }
}
