import java.sql.*;
import java.util.Scanner;

public class db_connection {

    public String url = "jdbc:mysql://localhost:3306/anime";
    public String user_name = "root";
    public String passwd = "vegeta007";
    public Connection connect;
    public Statement statement;
    public PreparedStatement preparedstatement;
    public ResultSet resultset;
    Scanner in = new Scanner(System.in);

    //--------------------------------- LIST DATA -----------------------------------//
    public void listData() {
        String query = "SELECT * FROM Naruto";
        try {
            connect = DriverManager.getConnection(url, user_name, passwd);
            statement = connect.createStatement();
            resultset = statement.executeQuery(query);

            while (resultset.next()) {
                System.out.println(resultset.getInt("char_id") + " " + resultset.getString("name") + " " +
                        resultset.getString("clan") + " " + resultset.getString("village") + " " +
                        resultset.getString("gender"));
            }

            statement.close();
            connect.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

//--------------------------------- INSERT DATA ---------------------------------//

    public void insertData() {
        int char_id;
        String name;
        String clan;
        String village;
        String gender;

        System.out.println("Enter values in following order: \ni - char_id\nii - name\niii - clan\niv - village\nv - gender");
        char_id = in.nextInt();
        in.nextLine();
        name = in.nextLine();
        clan = in.nextLine();
        village = in.nextLine();
        gender = in.nextLine();

        String query = "INSERT INTO Naruto VALUES (?,?,?,?,?)";
        try {
            connect = DriverManager.getConnection(url, user_name, passwd);
            preparedstatement = connect.prepareStatement(query);
            preparedstatement.setInt(1, char_id);
            preparedstatement.setString(2, name);
            preparedstatement.setString(3, clan);
            preparedstatement.setString(4, village);
            preparedstatement.setString(5, gender);
            int result = preparedstatement.executeUpdate();
            System.out.println(result + " row updated");
            preparedstatement.close();
            connect.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

//--------------------------------- DELETE DATA ---------------------------------//

    public void deleteData() {
        System.out.println("Enter the id of a specific character to delete its data!");
        int char_id = in.nextInt();
        String query = "DELETE FROM Naruto WHERE char_id = ?";
        try {
            connect = DriverManager.getConnection(url, user_name, passwd);
            preparedstatement = connect.prepareStatement(query);
            preparedstatement.setInt(1, char_id);
            int result = preparedstatement.executeUpdate();
            System.out.println(result + " row affected!");
            preparedstatement.close();
            connect.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

//--------------------------------- MODIFY DATA ---------------------------------//

}
