import java.util.Scanner;

/**
 * Code interaction with user.
 * Created by antoniocontreras on 10/5/17.
 */
public class StartDb {

    //TEST CASES THAT YOU HAVE DONE
        //* regular select * from table

    //TEST CASE THAT YOU NEED TO DO
        //you need to check for when spelling is off, when a table does not exist,

    public static void main(String[] args) {
        Database newDB = new Database();
        boolean dbActive = true;

        Table table = new Table("Table1", "Baseball");
        table.insertRecord("Tony", "Yankees", "SS", "186");
        table.insertRecord("Caleb", "Dodgers", "1B", "00");
        newDB.insertTable("baseball", table);

        while (dbActive) {

            Scanner in = new Scanner(System.in);
            String query = in.nextLine();
            String[] tokens = query.split("\\s+");
            ParseQuery parser = new ParseQuery();
            dbActive = parser.executeQuery(tokens, dbActive, newDB);



            

        }

    }
}
