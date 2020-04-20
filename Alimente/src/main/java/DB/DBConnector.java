package DB;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DBConnector {
    public static Connection connectToDB() {

        try {
            URL u = new URL("jar:file:D:\\JAVA\\pad-proiect2\\Alimente\\src\\main\\resources\\mysql-connector-java-8.0.15.jar!/");
            String classname = "com.mysql.cj.jdbc.Driver";
            URLClassLoader ucl = new URLClassLoader(new URL[]{u});
            Driver d = (Driver) Class.forName(classname, true, ucl).newInstance();
            DriverManager.registerDriver(new DriverShim(d));

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/alimente", "root", "123456789a");
            return con;
        } catch (Exception e) {
            return null;
        }
    }
}
