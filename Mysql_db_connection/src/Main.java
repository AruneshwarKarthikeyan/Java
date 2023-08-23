import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Scanner input = new Scanner(System.in);
        db_connection db = new db_connection();
        try {
            while (true) {
                System.out.println("choose integer values to perform specific operations\n" +
                        "1 - To List all Data\n2 - To Insert new Row\n3 - To Delete a Row\n4 - To Exit");
                int opt = input.nextInt();

                switch (opt) {
                    case 1:
                        db.listData();
                        break;
                    case 2:
                        db.insertData();
                        break;
                    case 3:
                        db.deleteData();
                        break;
                }
                if (opt == 4) {
                    System.out.println("Process Terminated!");
                    break;
                } else {
                    System.out.println();
                    System.out.println("\"INVALID INPUT\" - Choose from provided options");
                    System.out.println();
                }
            }
        } catch (InputMismatchException ime) {
            System.out.println();
            System.out.println("\"INVALID INPUT\" - Only Specified Integer Values");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }


    }
}