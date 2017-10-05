import java.util.ArrayList;
import java.util.HashMap;

/**
 * This table will be a representation of a DB table. It will hold records
 * that will be manually inputted or parsed frmo a
 * Created by antoniocontreras on 10/4/17.
 */
public class Table {
    String name;
    String sport;
    HashMap<Integer, ArrayList<String>> table;
    Integer uniqueKey = 0;

    public Table(String name, String sport) {
        this.name = name;
        this.sport = sport;
        table = new HashMap<Integer, ArrayList<String>>();
    }

    /*
     * For inputs correspond to the NAME, TEAM, POSITIONS and POINTS.
     */
    public void insertRecord(String name, String team, String position, String points) {
        ArrayList<String> newRecord = new ArrayList<String>();
        newRecord.add(name);
        newRecord.add(team);
        newRecord.add(position);
        newRecord.add(points);
        table.put(uniqueKey, newRecord);
        uniqueKey++;
    }

    /*
     * At the moment thinking about adding all conditions into a list then iterating
     * through the list in order to remove them from the table
     */
    public void removeRecord(ArrayList<String> lst) {
        //TODO, how will i remove these
    }

    public static void main(String[] args) {
        //TODO think of test cases for the table class.
    }
}
