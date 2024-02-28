import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User {
    private Connection connection;
    private Scanner scanner;

    public User(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void register() {
        scanner.nextLine();
        System.out.println("Enter full name :");
        String fullName = scanner.nextLine();
        System.out.println("Enter email :");
        String email = scanner.nextLine();
        System.out.println("Enter password :");
        String password = scanner.nextLine();

        if (user_exist(email)) {
            System.out.println("User already exist with this email id !");
            return;
        }
        String registerQuery = "insert into user (full_name,email,password) values(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(registerQuery);
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Registration successful !");
            } else {
                System.out.println("Registration failed !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public String login() {
        System.out.println("Enter email :");
        String email = scanner.next();
        scanner.nextLine();
        System.out.println("Enter password :");
        String password = scanner.next();

        String loginQuery = "select * from user where email = ? and password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return email;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean user_exist(String email) {
        String query = "select * from user where email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
