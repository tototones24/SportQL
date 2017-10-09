import java.util.Scanner;

/**
 * Code interaction with user.
 * Created by antoniocontreras on 10/5/17.
 */
public class StartDb {


    public static void main(String[] args) {
        Database newDB = new Database();
        boolean dbActive = true;
        while (dbActive) {

            Scanner in = new Scanner(System.in);
            String query = in.nextLine();
            String[] tokens = query.split("\\s+");



            ParseQuery parser = new ParseQuery();
            dbActive = parser.executeQuery(tokens, dbActive, newDB);



            

        }

    }
}
