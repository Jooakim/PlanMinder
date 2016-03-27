import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

public class SetupDatabase {

    private Connection con;
    private String tableName = "Users";

    public SetupDatabase() {

        con = Database.getConnection();

        // Look if table tableName exists, if not create one
        try {
            DatabaseMetaData meta = con.getMetaData();
            ResultSet rs = meta.getTables(null, null, tableName, null);

            if (rs.next()) {
                System.out.println("Database is already up to date!");
            } else {
                String query = "CREATE TABLE " + tableName  
                    + "(Username varchar(40)," 
                    + "Password varchar(40)," 
                    + "PRIMARY KEY (Username));";

                Statement st = con.createStatement();
                st.executeUpdate(query);
                System.out.println("Table created successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Could not create table: " + tableName);
            e.printStackTrace();
        } 

    }

    private void removeTable() {

        try {
            Statement st = con.createStatement();
            st.executeUpdate("DROP TABLE " + tableName + ";");
        } catch (SQLException e) {
            System.out.println("Could not drop table: " + tableName);
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        SetupDatabase setup = new SetupDatabase();
        //setup.removeTable();
    }

}
