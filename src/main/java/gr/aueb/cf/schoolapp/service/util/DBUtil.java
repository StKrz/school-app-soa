package gr.aueb.cf.schoolapp.service.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {

    private static final BasicDataSource ds = new BasicDataSource();
    private static Connection connection;

    static {
        ds.setUrl("jdbc:mysql://localhost:3306/schooldbpro?serverTimezone=UTC");
        ds.setUsername("schoolpro");
        ds.setPassword("******");
        ds.setInitialSize(8);
        ds.setMaxTotal(32);
        ds.setMinIdle(8);

        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public DBUtil() {
    }

    public static Connection getConnection() throws SQLException {
        connection = ds.getConnection();
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
