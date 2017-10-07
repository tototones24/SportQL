import java.util.Scanner;

/**
 * Code interaction with user.
 * Created by antoniocontreras on 10/5/17.
 */
public class StartDb {


    public static void main(String[] args) {


        boolean dbActive = true;
        while (dbActive) {
            Scanner in = new Scanner(System.in);
            String query = in.nextLine();
            String[] pieces = query.split("\\s+");
            for (String str : pieces) {
                System.out.println(str);
            }

            ParseQuery.executeQuery(pieces, dbActive);
            //TODO:dbActive does not change value.

        }

    }
}
