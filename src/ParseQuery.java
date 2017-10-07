/**
 * This will be the file that will parse the incoming commands and do as told.
 * Created by antoniocontreras on 10/5/17.
 */
public class ParseQuery {
    //Key Words
    public static boolean  executeQuery(String[] arr, boolean arg) {
        //TODO: learn how I will parse through the queries
        for (int i = 0 ; i < arr.length; i++) {
            if (arr[0].equals("end")) {
                return false;
            }
        }
        return true;
    }
}
