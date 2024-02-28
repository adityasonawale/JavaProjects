import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class HotelReservationSystem {
    private static final String url ="jdbc:mysql://localhost:3306/hotel_db";
    private static final String username ="root";
    private static final String password = "root";
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            while (true){
                System.out.println();
                System.out.println("HOTEL MANAGEMENT SYSTEM");
                System.out.println();
                System.out.println("1. Reserve a room ");
                System.out.println("2. View Reservation ");
                System.out.println("3. Get room no. ");
                System.out.println("4. Update reservation ");
                System.out.println("5. Delete reservation ");
                System.out.println("0. exit");
                System.out.println("Choose an option !");
                int choice = scanner.nextInt();

                Guest guest = new Guest(connection,scanner);
                Admin admin = new Admin(connection,scanner);

                switch (choice){
                    case 1:
                        //reserve room
                        guest.reserveRoom();
                        break;
                    case 2:
                        //view reservation
                        admin.viewReservations();
                        break;
                    case 3:
                        //get room no
                        admin.getRoomNumber();
                        break;
                    case 4:
                        //update reservation
                        admin.updateReservation();
                        break;
                    case 5:
                        //delete reservation
                        admin.deleteReservation();
                        break;
                    case 0:
                        //exit
                        guest.exit();
                        return;
                    default:
                        System.out.println("Invalid choice try again !");
                        break;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
