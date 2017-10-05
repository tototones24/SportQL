import java.util.HashMap;

/**
 * This will hold all of the table
 * Created by antoniocontreras on 10/5/17.
 */
public class Database {

    HashMap<String, Table> db;
    int tableInserterCounter;

    public Database() {
        db = new HashMap<String, Table>();
        tableInserterCounter = 0;
    }

    /*
     * Inputs the table into the db.
     */
    public void insertTable(String name, Table table) {
        db.put(name, table);
    }

    public void showAll() {
        if (db.keySet().size() == 0) {
            System.out.println("There are no tables in this db");
        } else {
            for (String name : db.keySet()) {
                System.out.println(name);
            }
        }
    }

    /*
     * Removes the table iff the table exists in the db.
     */
    public void removeTable(String tableName) {
        if (db.keySet().contains(tableName)) {
            db.remove(tableName);
        }
    }

    public static void main(String[] args) {
        Database db = new Database();
        Table table = new Table("table1", "Baseball");
        db.insertTable(table.name, table);
        db.showAll();
        db.removeTable("table1");
        db.showAll();
        //TODO once test cases for the TABLE class are done make sure to test cross interaction.
    }

}
