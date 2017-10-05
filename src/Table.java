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

    public void insertRecord(String name, String team, String position, String points) {
        ArrayList<String> newRecord = new ArrayList<String>();
        newRecord.add(name);
        newRecord.add(team);
        newRecord.add(position);
        newRecord.add(points);
        table.put(uniqueKey, newRecord);
        uniqueKey++;
    }

    //still deciding how I will want to remove a record
    public void removeRecord() {

    }
}
