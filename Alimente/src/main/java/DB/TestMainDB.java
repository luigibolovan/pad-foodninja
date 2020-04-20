package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestMainDB {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBConnector.connectToDB();

        String query = " insert into alimente (nume_aliment,protein,carbs,fat)" + " values (?,?,?,?)";

        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, "paine");
        preparedStmt.setDouble(2, 8.4);
        preparedStmt.setDouble(3, 47.4);
        preparedStmt.setDouble(4, 1.2);
        preparedStmt.execute();

        //conn.close();

    }

}
