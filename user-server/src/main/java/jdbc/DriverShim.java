package jdbc;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class DriverShim implements Driver {
    private Driver driver;

    DriverShim(Driver d) { this.driver = d; }

    public boolean acceptsURL(String u) throws SQLException {
        return this.driver.acceptsURL(u);
    }
    public Connection connect(String u, Properties p) throws SQLException {
        return this.driver.connect(u, p);
    }

    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    public int getMajorVersion() {
        return 0;
    }

    public int getMinorVersion() {
        return 0;
    }

    public boolean jdbcCompliant() {
        return false;
    }

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
