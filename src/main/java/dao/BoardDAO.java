package dao;

import dbcp.DatabaseConnectionPool;
import model.dto.Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
    DatabaseConnectionPool databaseConnectionPool = new DatabaseConnectionPool();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    int result;

    public int createBoard(String memberId, String type, String title, String content) {
        String sql = "insert into board values (null, ?, ?, ?, ?, null, null);";

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(memberId));
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, title);
            preparedStatement.setString(4, content);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public ArrayList<Board> selectBoardAll() {
        String sql = "select * from board;";
        ArrayList<Board> boards = new ArrayList<>();

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Board board = new Board();
                board.setId(resultSet.getInt("id"));
                board.setMemberId(resultSet.getInt("member_id"));
                board.setType(resultSet.getString("type"));
                board.setTitle(resultSet.getString("title"));
                board.setContent(resultSet.getString("content"));
                board.setCreatedAt(resultSet.getDate("created_at"));
                board.setUpdatedAt(resultSet.getDate("updated_at"));
                boards.add(board);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement, resultSet);
        }

        return boards;
    }

    public int updateBoard(String id, String type, String title, String content) {
        String sql = "update board set type = ?, title = ?, content = ? where id = ?;";

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, content);
            preparedStatement.setInt(4, Integer.parseInt(id));
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement);
        }

        return result;
    }

    public int deleteBoardByMemberId(int memberId) {
        String sql = "delete from board where member_id = ?;";

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

    public int deleteBoardById(String id) {
        String sql = "delete from board where id = ?;";

        try {
            connection = databaseConnectionPool.getDataSource().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(id));
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConnectionPool.freeConnection(connection, preparedStatement);
        }

        return result;
    }
}
