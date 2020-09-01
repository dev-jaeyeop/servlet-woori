package dao;

import dbConnection.DBConnectionMgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReplyDAO {
    DBConnectionMgr dbConnectionMgr = new DBConnectionMgr();
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    int result;

    public int deleteReply(int memberId) {
        String sql = "delete from reply where member_id = ?;";

        try {
            connection = dbConnectionMgr.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, memberId);
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnectionMgr.freeConnection(connection, preparedStatement);
        }

        return result;
    }
}
