package dao;

import dbcp.DatabaseConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReplyDAO {
    DatabaseConnectionPool databaseConnectionPool = new DatabaseConnectionPool();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    int result;

    public int deleteReplyByMemberId(int memberId) {
        String sql = "delete from reply where member_id = ?;";

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, memberId);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public int deleteReplyByBoardId(String boardId) {
        String sql = "delete from reply where board_id = ?;";

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(boardId));
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement);
        }

        return result;
    }
}
