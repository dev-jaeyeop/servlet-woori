package dbcp;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnectionPool {
    private Object dataSource;

    public DatabaseConnectionPool() {
        try {
            this.dataSource = new InitialContext().lookup("java:comp/env/jdbc/dbcp");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public DatabaseConnectionPool(String resourceName) {
        try {
            this.dataSource = new InitialContext().lookup("java:comp/env/" + resourceName);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public DataSource getDataSource() {
        return (DataSource) dataSource;
    }

    public void freeConnection(Connection connection, PreparedStatement preparedStatement) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void freeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
