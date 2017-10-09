import javax.xml.crypto.Data;
import java.util.ArrayList;

/**
 * This will be the file that will parse the incoming commands and do as told.
 * Created by antoniocontreras on 10/5/17.
 */
public class ParseQuery {

    String action;
    String item;
    String location;
    String previousCommand;

    //This will parse through the whole query
    public boolean  executeQuery(String[] arr, boolean arg, Database db) {
        //TODO: learn how I will parse through the queries
        for (int i = 0 ; i < arr.length; i++) {

            //these are single query checks
            //SELECT ____ FROM _______
            if (arr[i].equals("end")) {
                return false;
            } else if (arr[i].toLowerCase().equals("select")) {
                action = arr[i].toLowerCase();
                previousCommand = arr[i];
            } else if (arr[i].toLowerCase().equals("from")) {
                location = arr[i].toLowerCase();
                previousCommand = arr[i].toLowerCase();
            } else {
                if (previousCommand == "select") {
                    item = arr[i].toLowerCase();
                    previousCommand = "item";
                } else if (previousCommand == "from") {
                    location = arr[i].toLowerCase();
                    previousCommand = "location";
                }
            }
        }

        //this is the select clause
        //TODO, test this select statement, simple with NO CONDITIONS
        if (action == "select") {
            return selectClause(item, location, db);
        }
        return true;
    }

    /*
     * This is the method that will do the actual printing out of the data
     * in the case of a simple select with no conditions.
     */
    public boolean selectClause(String _item, String tableName, Database _db) {
        //selects everything from the corresponding table.
        if (_item == "*") {
            //this gets the table(hashmap) that i want
            _db.db.get(tableName).showRecords();
            return true;
        } else {
            for (int num : _db.db.get(tableName).table.keySet()) {
                ArrayList<String> list = _db.db.get(tableName).table.get(num);
                if (_item == "name") {
                    System.out.println(list.get(0));
                } else if (_item == "team") {
                    System.out.println(list.get(1));
                } else if (_item == "position") {
                    System.out.println(list.get(2));
                } else {
                    System.out.println(list.get(3));
                }


            }
        }
        return true;
    }

}
