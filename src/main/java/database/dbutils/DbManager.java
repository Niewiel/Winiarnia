package database.dbutils;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import database.models.Category;
import database.models.Producent;
import database.models.Wino;

import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by niewiel on 31.05.17.
 */
public class DbManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(DbManager.class);

    private static final String JDBC_DRIVER_HD = "jdbc:h2:./CelarioDB";
    private static final String USER = "admin";
    private static final String PASS = "admin";

    private static JdbcConnectionSource conectionSource;

    public static void initDatabase(){
        createConnectionSource();
        dropTable();
        createTable();
        closeConnectionSource();
    }

    public static void createConnectionSource() {
        try {
            conectionSource = new JdbcConnectionSource(JDBC_DRIVER_HD, USER, PASS);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public static ConnectionSource getConnectionSource() {
        if (conectionSource == null)
            createConnectionSource();
        return conectionSource;
    }

    public static void closeConnectionSource() {
        if (conectionSource != null) {
            try {
                conectionSource.close();
            } catch (IOException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }

    private static void createTable() {
        try {
            TableUtils.createTableIfNotExists(conectionSource, Producent.class);
            TableUtils.createTableIfNotExists(conectionSource, Wino.class);
            TableUtils.createTableIfNotExists(conectionSource, Category.class);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private static void dropTable() {
        try {
            TableUtils.dropTable(conectionSource, Producent.class, true);
            TableUtils.dropTable(conectionSource, Wino.class, true);
            TableUtils.dropTable(conectionSource, Category.class, true);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }
}
