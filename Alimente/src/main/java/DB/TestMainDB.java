package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Basic.*;

public class TestMainDB {
    public static ArrayList<Aliment> test() throws SQLException {
        ArrayList<Aliment> alimente = new ArrayList<Aliment>();
        Connection conn = DBConnector.connectToDB();
        String query = "select alimente.nume_aliment, alimente.protein, alimente.carbs, alimente.fat from alimente;";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        ResultSet rs = preparedStmt.executeQuery();
        while(rs.next()){
            Aliment a = new Aliment(rs.getString(1), rs.getDouble(4), rs.getDouble(3), rs.getDouble(2));
            alimente.add(a);
        }

        //conn.close();

        return alimente;
    }

}
