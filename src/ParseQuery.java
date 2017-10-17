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
    String conditionItem;
    String condition;
    String postCondition;


    /*
     *This will parse through the whole query and parse all of the
     * required data needed to extract the information that you need.
     */
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
            } else if (arr[i].toLowerCase().equals("where")) {
                previousCommand = arr[i].toLowerCase();
            } else {
                if (previousCommand.equals("select")) {
                    item = arr[i].toLowerCase();
                    previousCommand = "item";
                } else if (previousCommand.equals("from")) {
                    location = arr[i].toLowerCase();
                    previousCommand = "location";
                } else if (previousCommand.equals("where")) {
                    //This will be for query checks with conditions
                    //First you will have to make it work with equality, then greater than and less thancd 
                    conditionItem = arr[i].toLowerCase();
                    previousCommand = "conditionitem";
                } else if (previousCommand.equals("conditionitem")) {
                    condition = arr[i].toLowerCase();
                    previousCommand = "condition";
                } else if (previousCommand.equals("condition")) {
                    postCondition = arr[i].toLowerCase();
                    previousCommand = "postcondition";
                }
            }
        }

        //this is the select clause
        //TODO, test this select statement, simple with NO CONDITIONS
        if (action.equals("select")) {
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
        if (_item.equals("*")) {
            //this gets the table(hashmap) that i want
            _db.db.get(tableName).showRecords();
            return true;
        } else {
            for (int num : _db.db.get(tableName).table.keySet()) {
                ArrayList<String> list = _db.db.get(tableName).table.get(num);
                if (_item.equals("name")) {
                    System.out.println(list.get(0));
                } else if (_item.equals("team")) {
                    System.out.println(list.get(1));
                } else if (_item.equals("position")) {
                    System.out.println(list.get(2));
                } else {
                    System.out.println(list.get(3));
                }


            }
        }
        return true;
    }


    /*
     *This will be a select clause with condistions
     * SELECT ___ FROM _____ WHERE ________
     */
//    public static boolean selectClauseWithCondition() {

//    }

}
